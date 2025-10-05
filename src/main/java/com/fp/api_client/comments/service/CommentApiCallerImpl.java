package com.fp.api_client.comments.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fp.api_client.comments.domain.Comment;
import com.fp.api_client.comments.domain.CommentPage;
import com.fp.api_client.comments.domain.NewCommentDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class CommentApiCallerImpl implements CommentApiCaller {

	private String basePath;
	private ObjectMapper objectMapper;

	// https://dummyjson.com/
	public CommentApiCallerImpl(String basePath) {
		this.basePath = basePath;
		this.objectMapper = new ObjectMapper();
	}

	/**
	 * Obtiene todos los comments
	 *
	 * Ej. https://dummyjson.com/comments
	 *
	 * GET
	 *
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public CommentPage getAllComments() throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath))
				.method("GET", BodyPublishers.noBody()).build();
		return getCommentsPage(request);
	}

	/**
	 * Obtiene un comment a partir de su id
	 *
	 * GET
	 *
	 * Ej. https://dummyjson.com/comment/1
	 *
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public Comment getComment(int id) throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id))
				.method("GET", BodyPublishers.noBody()).build();

		Comment comment = getComment(request);
		return comment;
	}

	@Override
	public CommentPage getCommentsByPostId(int postId) throws IOException, InterruptedException, ApiCallException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/ " + "post/" + postId))
				.method("GET", BodyPublishers.noBody()).build();
		return getCommentsPage(request);
	}

	/**
	 * Hace la llamada de la request y devuelve un Comment
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private Comment getComment(HttpRequest request) throws ApiCallException, IOException, InterruptedException {
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		handleResponse(response);
		Comment comment = objectMapper.readValue(response.body(), Comment.class);
		return comment;
	}

	/**
	 * Hace la llamada de la request y devuelve un CommentPage
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	private CommentPage getCommentsPage(HttpRequest request)
			throws IOException, InterruptedException, ApiCallException {
		HttpResponse<String> response = null;

		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		handleResponse(response);
		CommentPage commentPage = objectMapper.readValue(response.body(), CommentPage.class);
		return commentPage;
	}



	/**
	 * Crea un nuevo comentario
	 *
	 * POST
	 *
	 * @param newCommentDto
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	@Override
	public Comment addComment(NewCommentDto newCommentDto) throws IOException, InterruptedException, ApiCallException {
		String jsonNewComment = objectMapper.writeValueAsString(newCommentDto);
		String url = basePath + "/add";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(jsonNewComment)).build();
		return getComment(request);
	}

	/**
	 * Actualiza un comentario existe
	 *
	 * POST
	 *
	 * @param id             del comentario a actualizar
	 * @param updateComment informacion del comentario actualizado
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	@Override
	public Comment updateComment(int id, Comment updateComment)
			throws IOException, InterruptedException, ApiCallException {
		String jsonComment = objectMapper.writeValueAsString(updateComment);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id))
				.header("Content-Type", "application/json").PUT(BodyPublishers.ofString(jsonComment)).build();
		return getComment(request);
	}

	/**
	 * Borra un comentario asociado al id indicado como argumento
	 * @param id
	 * @return
	 * @throws ApiCallException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public Comment deleteComment(int id) throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id)).DELETE().build();
		return getComment(request);
	}


	/**
	 *  Obtiene los comentarios paginados
	 *  Solamente aquellos campos que pertenezcan a la seleccion
	 * 	GET Ej. https://dummyjson.com/comments?limit=10&skip=10&select=title,price
	 *
	 * @param limit
	 * @param skip
	 * @param selection
	 * @return
	 * @throws ApiCallException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public CommentPage getComments(int limit, int skip, String selection) throws ApiCallException, IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();
		String query = String.format("?limit=%s&skip=%s&select=%s",limit, skip, selection);
		sb.append(basePath);
		sb.append(query);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sb.toString())).GET().build();
		return getCommentsPage(request);
	}

	private void handleResponse(HttpResponse<String> response) throws ApiCallException {
		int statusCode = response.statusCode();
		if (statusCode != 200 && statusCode != 201) {
			handleError(response);
		}
	}

	private void handleError(HttpResponse<String> response) throws ApiCallException {
		String responseBody = response.body();
		switch (response.statusCode()) {
			case 404:
				throw new ApiCallException("El recurso no fue encontrado.", response.statusCode(), responseBody);
			case 400:
				throw new ApiCallException("Error en la solicitud del cliente.", response.statusCode(), responseBody);
			case 500:
				throw new ApiCallException("Error en el servidor.", response.statusCode(), responseBody);
			default:
				throw new ApiCallException("Error desconocido", response.statusCode(), responseBody);
		}
	}

}
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");	}

	@Override
	public CommentPage getCommentsByPostId(int postId) throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");	}

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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private void handleResponse(HttpResponse<String> response) throws ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private void handleError(HttpResponse<String> response) throws ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

}
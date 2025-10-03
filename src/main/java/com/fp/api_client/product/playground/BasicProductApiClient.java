package com.fp.api_client.product.playground;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fp.api_client.product.domain.ProductPage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class BasicProductApiClient {

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products y devuelve el cuerpo de la respuesta.
	 * 
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getAllProducts() {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products")).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products y devuelve el objeto ProductPage correspondiente al cuerpopo de la respuesta.
	 *
	 * @return El objeto ProductPage correspondiente al cuerpo de la respuesta.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecucion de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public ProductPage getAllProductsV2() {
		ObjectMapper objectMapper = new ObjectMapper();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products")).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			ProductPage productPage = objectMapper.readValue(respuesta.body(), ProductPage.class);
			return productPage;
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/{id} y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @param id El identificador del producto que se desea obtener.
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecucion de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getProduct(int id) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/" + id)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/search?q={keyword} y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @param keyword La palabra clave para buscar productos.
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepci n de entrada/salida durante la ejecuci n de la petici n.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecuci n de la petici n.
	 */
	public String searchProducts(String keyword) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/search?q=" + keyword)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products y devuelve el cuerpo de la respuesta en formato JSON.
	 * La peticion admite los siguientes parametros:
	 * <ul>
	 * <li>limit: El n mero de productos que se desean obtener por p gina.</li>
	 * <li>skip: El n mero de productos que se desean omitir al principio de la p gina.</li>
	 * <li>selection: La lista de campos que se desean obtener para cada producto.</li>
	 * </ul>
	 *
	 * @param limit El n mero de productos que se desean obtener por p gina.
	 * @param skip El n mero de productos que se desean omitir al principio de la p gina.
	 * @param selection La lista de campos que se desean obtener para cada producto.
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepci n de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecuci n de la peticion.
	 */
	public String getProducts(int limit, int skip, String selection) {
		//https://dummyjson.com/products?limit=10&skip=10&select=title,price
		String url = String.format("https://dummyjson.com/products?limit=%s&skip=%s&select=%s",limit, skip, selection);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/categories y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getAllProductsCategories() {
		String url = String.format("https://dummyjson.com/products/categories");
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/categories y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecucion de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getProductsOfCategory(String category) {
		String url = String.format("https://dummyjson.com/products/category/%s", category);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Agrega un producto a la base de datos.
	 *
	 * @param jsonProduct El objeto Producto en formato JSON que se desea agregar.
	 * @return El objeto Producto en formato JSON que se ha agregado.
	 * @throws IOException Si ocurre alguna excepci n de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 * @throws IllegalStateException Si ocurre alguna excepcion de tipo IllegalStateException durante la ejecucion de la peticion.
	 */
	public String addProduct(String jsonProduct) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/add"))
				.header("Content-Type", "application/json").POST(BodyPublishers.ofString(jsonProduct)).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 201) {
			throw new  IllegalStateException("Error al agregar un producto. StatusCode: " + statusCode);
		}
		return response.body();
	}

	/**
	 * Actualiza un producto en la base de datos.
	 *
	 * @param productId El identificador del producto que se desea actualizar.
	 * @param jsonProduct El objeto Producto en formato JSON que se desea agregar.
	 * @return El objeto Producto en formato JSON que se ha actualizado.
	 * @throws IOException Si ocurre alguna excepci n de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecuci n de la peticion.
	 * @throws IllegalStateException Si ocurre alguna excepci n de tipo IllegalStateException durante la ejecuci n de la peticion.
	 */
	public String updateProduct(int productId, String jsonProduct) throws IOException, InterruptedException {
		String url = String.format("https://dummyjson.com/products/%s", productId);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Content-Type", "application/json").PUT(BodyPublishers.ofString(jsonProduct)).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 200) {
			throw new  IllegalStateException("Error al actualizar un producto. StatusCode: " + statusCode);
		}
		return response.body();
	}
	
	
	/**
	 * Elimina un producto de la base de datos.
	 *
	 * @param productId El identificador del producto que se desea eliminar.
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepci n de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecuci n de la peticion.
	 * @throws IllegalStateException Si ocurre alguna excepci n de tipo IllegalStateException durante la ejecuci n de la peticion.
	 */
	public String delete(int productId) throws IOException, InterruptedException {
		String url = String.format("https://dummyjson.com/products/%s", productId);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Content-Type", "application/json").DELETE().build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 200) {
			throw new IllegalStateException("Error al eliminar un producto. StatusCode: " + statusCode);
		}
		return response.body();
	}
}
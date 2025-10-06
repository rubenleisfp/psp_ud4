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
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products y devuelve el objeto ProductPage correspondiente al cuerpopo de la respuesta.
	 *
	 * @return El objeto ProductPage correspondiente al cuerpo de la respuesta.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecucion de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public ProductPage getAllProductsV2() {
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
	}


	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/categories y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecuci n de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepcion de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getAllProductsCategories() {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Realiza una peticion GET a la URL https://dummyjson.com/products/categories y devuelve el cuerpo de la respuesta en formato JSON.
	 *
	 * @return El cuerpo de la respuesta en formato JSON.
	 * @throws IOException Si ocurre alguna excepcion de entrada/salida durante la ejecucion de la peticion.
	 * @throws InterruptedException Si ocurre alguna excepci n de tipo InterruptedException durante la ejecucion de la peticion.
	 */
	public String getProductsOfCategory(String category) {
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
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
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}
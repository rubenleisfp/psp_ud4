package com.fp.api_client.product.service;

import com.fp.api_client.product.domain.Category;
import com.fp.api_client.product.domain.Product;
import com.fp.api_client.product.domain.ProductPage;

import java.io.IOException;
import java.util.List;



public interface ProductApiCaller {

	ProductPage getAllProducts() throws IOException, InterruptedException, ApiCallException;

	Product getProduct(int id) throws IOException, InterruptedException, ApiCallException;

	/**
	 * 
	 * Funcion que buscara los productos que contengan la palabra recibida como argumento
	 * en el titulo o la descripcion
	 * 
	 * @param searchWord la palabra que vamos a buscar en nuestro API ya sea en el titulo o en la descripcion
	 * @return Pagina con los productos que coinciden con nuestra busqueda
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	ProductPage searchProducts(String searchWord) throws IOException, InterruptedException, ApiCallException;

	List<Category> getAllProductsCategories() throws IOException, InterruptedException, ApiCallException;

	ProductPage getProductsOfCategory(String category) throws IOException, InterruptedException, ApiCallException;

	Product addProduct(Product product) throws IOException, InterruptedException, ApiCallException;

	Product updateProduct(int id, Product updatedProduct) throws IOException, InterruptedException, ApiCallException;

	Product deleteProduct(int id) throws IOException, InterruptedException, ApiCallException;

	ProductPage getProducts(int limit, int skip, String selection) throws ApiCallException, IOException, InterruptedException;
}
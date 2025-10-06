package com.fp.api_client.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;


import com.fp.api_client.product.domain.Category;
import com.fp.api_client.product.domain.Product;
import com.fp.api_client.product.domain.ProductPage;
import com.fp.api_client.product.service.ApiCallException;
import com.fp.api_client.product.service.ProductApiCallerImpl;
import com.fp.api_client.product.util.MockUtils;
import org.junit.Before;
import org.junit.Test;



public class ProductApiCallerImplTest {

	private static final String BASE_PATH = "https://dummyjson.com/products";
	private ProductApiCallerImpl productApiCaller;

	@Before
	public void setUp() {
		productApiCaller = new ProductApiCallerImpl(BASE_PATH);
	}

	@Test
	public void testGetAllProducts() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testGetProduct() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testSearchProducts() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");

	}

	@Test
	public void testGetAllProductsCategories() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testGetProductsOfCategory() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testAddProduct() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}
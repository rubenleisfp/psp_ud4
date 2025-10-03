package com.fp.api_client.product.playground;

import com.fp.api_client.product.domain.Product;
import com.fp.api_client.product.domain.ProductPage;

import java.io.IOException;
import java.util.Scanner;

public class AppBasicProductApi {

    private final BasicProductApiClient apiCaller = new BasicProductApiClient();

    public static void main(String[] args) {
        AppBasicProductApi app = new AppBasicProductApi();
        try {
            app.mostrarMenu();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ha ocurrido un error tecnico y no podemos realizar la operativa. Intentelo más tarde");
            //FIXME: En vez de relanzar, deberíamos loguear el error en un fichero de log de errores
            throw  new RuntimeException(e);
        }
    }

    public void mostrarMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Obtener todos los productos");
            System.out.println("2. Obtener producto por ID");
            System.out.println("3. Buscar producto por palabra clave");
            System.out.println("4. Obtener productos con parámetros paginados");
            System.out.println("5. Obtener todas las categorías de productos");
            System.out.println("6. Obtener productos de una categoría");
            System.out.println("7. Agregar un producto");
            System.out.println("8. Actualizar un producto");
            System.out.println("9. Eliminar un producto por ID");
            System.out.println("10. Muestra la suma de todos los precios de los productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            String response = "";
            switch (opcion) {
                case 1 ->    {
                    response = apiCaller.getAllProducts();
                    System.out.println(response);
                }
                case 2 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int idProducto = scanner.nextInt();
                    scanner.nextLine();
                    response = apiCaller.getProduct(idProducto);
                    System.out.println(response);
                }
                case 3 -> {
                    System.out.println("Ingrese el la palabra clave de búsqueda: ");
                    String palabraClave = scanner.nextLine();
                    response = apiCaller.searchProducts(palabraClave);
                    System.out.println(response);
                }
                case 4 -> {
                    System.out.print("Ingrese el límite de productos: ");
                    int limit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el número de elementos a omitir: ");
                    int skip = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese los campos a mostrar: ");
                    String selection = scanner.nextLine();
                    response =  apiCaller.getProducts(limit, skip, selection);
                    System.out.println(response);
                }
                case 5 ->
                {
                    response = apiCaller.getAllProductsCategories();
                    System.out.println(response);
                }
                case 6 -> {
                    System.out.print("Ingrese la categoria de los productos que desea mostrar: ");
                    String category = scanner.nextLine();
                    response = apiCaller.getProductsOfCategory(category);
                    System.out.println(response);
                }
                case 7 -> {
                    System.out.print("Ingrese el producto como Json: ");
                    String productJson = scanner.nextLine();
                    response = apiCaller.addProduct(productJson);
                    System.out.println(response);
                }
                case 8 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese el producto como Json: ");
                    String productJson = scanner.nextLine();
                    response =  apiCaller.updateProduct(id, productJson);
                    System.out.println(response);
                }
                case 9 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    response = apiCaller.delete(id);
                    System.out.println(response);
                }
                case 10 -> {
                    ProductPage productPage = apiCaller.getAllProductsV2();
                    if (productPage == null || productPage.getProducts() == null || productPage.getProducts().isEmpty()) {
                        System.out.println("No se encontraron productos.");
                        break;
                    } else {
                        double total = 0.0;
                        for (Product product : productPage.getProducts()) {
                            total += product.getPrice();
                        }
                        System.out.println("La suma de todos los precios de los productos es: " + total);
                    }
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}
package damiantomczyszyn.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    // Dodaj produkt
    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(nextId++, name, price, quantity);
        products.add(product);
        System.out.println("Dodano produkt: " + product);
    }

    // Usuń produkt
    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
        System.out.println("Usunięto produkt o ID: " + id);
    }

    // Edytuj produkt
    public void editProduct(int id, String newName, double newPrice, int newQuantity) {
        Optional<Product> productOpt = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();

        productOpt.ifPresent(product -> {
            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Zaktualizowano produkt: " + product);
        });

        if (productOpt.isEmpty()) {
            System.out.println("Nie znaleziono produktu o ID: " + id);
        }
    }

    // Wyświetl wszystkie produkty
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Brak produktów.");
        } else {
            products.forEach(System.out::println);
        }
    }

    // Wyświetl produkty z filtrem (przykład z użyciem strumieni)
    public void listProductsByPrice(double minPrice) {
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getPrice() >= minPrice)
                .collect(Collectors.toList());

        filteredProducts.forEach(System.out::println);
    }
}
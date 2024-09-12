package damiantomczyszyn.my;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CMS Sklep Internetowy ---");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Usuń produkt");
            System.out.println("3. Edytuj produkt");
            System.out.println("4. Wyświetl produkty");
            System.out.println("5. Wyświetl produkty o cenie >= X");
            System.out.println("6. Wyjdź");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Pobierz znak nowej linii

            switch (choice) {
                case 1 -> {
                    System.out.print("Nazwa produktu: ");
                    String name = scanner.nextLine();
                    System.out.print("Cena produktu: ");
                    double price = scanner.nextDouble();
                    System.out.print("Ilość: ");
                    int quantity = scanner.nextInt();
                    productService.addProduct(name, price, quantity);
                }
                case 2 -> {
                    System.out.print("ID produktu do usunięcia: ");
                    int id = scanner.nextInt();
                    productService.removeProduct(id);
                }
                case 3 -> {
                    System.out.print("ID produktu do edycji: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Pobierz znak nowej linii
                    System.out.print("Nowa nazwa: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nowa cena: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Nowa ilość: ");
                    int newQuantity = scanner.nextInt();
                    productService.editProduct(id, newName, newPrice, newQuantity);
                }
                case 4 -> productService.listProducts();
                case 5 -> {
                    System.out.print("Minimalna cena: ");
                    double minPrice = scanner.nextDouble();
                    productService.listProductsByPrice(minPrice);
                }
                case 6 -> {
                    System.out.println("Zamykanie programu...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }
}
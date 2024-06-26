import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//Write a program which keeps the information about products and their prices.
//Each product has a name, a price, and its quantity.
//If the product doesn't exist yet, add it with its starting quantity.

//If you receive a product that already exists, increases its quantity
//by the input quantity and if its price is different, replace the price as well.

//You will receive products' names, prices, and quantities on new lines.
//Until you receive the command "buy", keep adding items.
//When you do receive the command "buy", print the items with their names
//and the total price of all the products with that name.

//Input

//Until you receive "buy", the products come in the format:
//"{name} {price} {quantity}".

//The product data is always delimited by a single space.

//Output

//Print information about each product, following the format:
//"{productName} -> {totalPrice}"

//Format the average total price to the 2nd decimal place.

//Example

//Input:
//Beer 2.20 100
//IceTea 1.50 50
//NukaCola 3.30 80
//Water 1.00 500
//buy

//Output:
//Beer -> 220.00
//IceTea -> 75.00
//NukaCola -> 264.00
//Water -> 500.00

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {

            //Beer 2.20 100
            String productName = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            if (productsQuantity.containsKey(productName)) {
                int existingQuantity = productsQuantity.get(productName);
                productsQuantity.put(productName, existingQuantity + quantity);
            } else {
                productsQuantity.put(productName, quantity);
            }

            productsPrice.put(productName, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {

            String productName = entry.getKey();
            int productQuantity = entry.getValue();
            double productPrice = productsPrice.get(productName);

            System.out.printf("%s -> %.2f\n", productName, productQuantity * productPrice);
        }
    }
}

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class OutputGenerator {
    ShoppingCart cart = new ShoppingCart();
    Scanner scanner = new Scanner(System.in);
    int totalCost = 0;

    public void generateLocalization(String language, String country) {
        Locale myLocale = new Locale(language, country);
        ResourceBundle langBundle = ResourceBundle.getBundle("MessagesBundle", myLocale);

        String numberOfItemsMessage = langBundle.getString("numberOfItems");
        String priceForItemMessage = langBundle.getString("priceForItem");
        String quantityOfItemMessage = langBundle.getString("quantityOfItem");
        String totalCostMessage = langBundle.getString("totalCost");

        System.out.println(numberOfItemsMessage);
        int numberOfItems = scanner.nextInt();

        for(int i = 0; i < numberOfItems; i++) {
            System.out.println(priceForItemMessage);
            int priceOfItem = scanner.nextInt();
            System.out.println(quantityOfItemMessage);
            int quantityOfItem = scanner.nextInt();
            Item item = new Item(priceOfItem, quantityOfItem);
            cart.addItem(item);
        }
        calculate(totalCostMessage, cart);
}

public int calculate(String totalCostMessage, ShoppingCart cart) {
    for(Item item : cart.getShoppingCart()) {
        totalCost += item.getPrice() * item.getQuantity();
    }
    System.out.println(totalCostMessage +  " " + totalCost);
    return totalCost;
    }
}

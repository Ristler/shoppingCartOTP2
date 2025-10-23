import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class OutputGeneratorTest {
    OutputGenerator generator;
    ShoppingCart shoppingCart;
    Item item1;
    Item item2;

    @BeforeEach
    void setUp() {
        generator = new OutputGenerator();
        shoppingCart = new ShoppingCart();
        item1 = new Item(1, 10);
        item2 = new Item(1, 10);
    }

    @Test
    void testEnglish() {
        Locale myLocale = new Locale("en", "US");
        ResourceBundle langBundle = ResourceBundle.getBundle("MessagesBundle", myLocale);
        String numberOfItemsMessage = langBundle.getString("numberOfItems");

        assertEquals("Enter the number of items to purchase:", numberOfItemsMessage);

    }
    @Test
    void testFinnish() {
        Locale myLocale = new Locale("fi", "FI");
        ResourceBundle langBundle = ResourceBundle.getBundle("MessagesBundle", myLocale);
        String numberOfItemsMessage = langBundle.getString("numberOfItems");

        assertEquals("Syötä ostettavien tuotteiden määrä:", numberOfItemsMessage);

    }
    @Test
    void testJapanese() {
        Locale myLocale = new Locale("ja", "JP");
        ResourceBundle langBundle = ResourceBundle.getBundle("MessagesBundle", myLocale);
        String numberOfItemsMessage = langBundle.getString("numberOfItems");

        assertEquals("購入する商品の数を入力してください:", numberOfItemsMessage);

    }
    @Test
    void testSwedish() {
        Locale myLocale = new Locale("sv", "SE");
        ResourceBundle langBundle = ResourceBundle.getBundle("MessagesBundle", myLocale);
        String numberOfItemsMessage = langBundle.getString("numberOfItems");

        assertEquals("Ange antalet varor att köpa:", numberOfItemsMessage);
    }

    @Test
    void calculate() {
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        assertEquals(20, generator.calculate("Test case only", shoppingCart));
    }
}
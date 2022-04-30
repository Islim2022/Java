
import java.util.ArrayList;

public class OrdersTest {

    public static void main(String[] args) {
        // Create 2 orders for unspecified guests (without specifying a name);
        Orders order1 = new Orders();
        Orders order2 = new Orders();

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        Orders order3 = new Orders("Sam");
        Orders order4 = new Orders("Hanei");
        Orders order5 = new Orders("Noah");

        // Add at least 2 items to each of the orders using the addItem method you wrote
        // , for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);

        Items item1 = new Items("Mocha", 4.5);
        Items item2 = new Items("Latte", 5.5);
        Items item3 = new Items("Capaccino", 3.75);
        Items item4 = new Items("Drip Coffee", 2.75);

        order1.addItem(item1);
        order1.addItem(item2);
        order1.display();
        System.out.println(order1.getStatusMessage());
        

        order2.addItem(item3);
        order2.addItem(item4);
        order2.display();
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        order3.addItem(item1);
        order3.addItem(item3);
        order3.display();
        order3.setReady(true);
        System.out.println(order3.getStatusMessage());

        order4.addItem(item2);
        order4.addItem(item4);
        order4.addItem(item3);
        order4.setReady(true);
        order4.display();
        System.out.println(order4.getStatusMessage());

        order5.addItem(item1);
        order5.addItem(item3);
        order5.addItem(item4);
        order5.display();
        System.out.println(order5.getStatusMessage());
    }
}



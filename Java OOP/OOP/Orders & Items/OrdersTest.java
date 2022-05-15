
import java.util.ArrayList;

public class OrdersTest {

    public static void main(String[] args) {
        // Item Variables
        Items item1 = new Items();
        item1.name = "Mocha";
        item1.price = 4.5;

        Items item2 = new Items();
        item2.name = "Latte";
        item2.price = 5.5;

        Items item3 = new Items();
        item3.name = "Capaccino";
        item3.price = 3.75;

        Items item4 = new Items();
        item4.name = "Drip Coffee";
        item4.price = 2.75;

        // Order Variables
        Orders order1 = new Orders();
        Orders order2 = new Orders();
        Orders order3 = new Orders();
        Orders order4 = new Orders();

        order1.name = "Cindhuri";
        System.out.println(order1.total); // Predict what will happen if you print order1.total = 0.0
        order1.ready = true; // Cindhuri’s order is now ready. Update her status.

        order2.name = "Jimmy";
        order2.items.add(item1); // Add item1 to order2's item list and increment the order's total.
        order2.total += item1.price;
        order2.ready = true; // Jimmy’s order is now ready. Update his status.
        System.out.println(order2.total);


        order3.name = "Noah";
        order3.items.add(item3); // order3 ordered a cappucino
        order3.total += item3.price;
        System.out.println(order3.total);

        order4.name = "Sam";
        order4.items.add(item2); // order4 added a latte
        order4.total += item2.price;
        // Sam ordered more drinks -- 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.total += item2.price * 2;
        System.out.println(order4.total);

                // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}



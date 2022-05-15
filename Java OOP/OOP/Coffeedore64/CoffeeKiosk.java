import java.util.ArrayList;

public class CoffeeKiosk {
    static int index=0;
    ArrayList<Items> items=new ArrayList<Items>();
    ArrayList<Orders> orders= new ArrayList<Orders>();
    public CoffeeKiosk(){
        items= new ArrayList<Items>();
        orders=new ArrayList<Orders>();
    }
    public void addItem(String name , double price){

        Items newItem= new Items(name, price, index);
        index++;
        items.add(newItem);
    }
    public void displayMenu(){
        for(Items i:this.items){
            System.out.println(i.getIndex()+"  "+i.getName()+"--"+i.getPrice());
        }
    }
    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Orders newOrder= new Orders(name);
        
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            displayMenu();
        // Get the item object from the menu, and add the item to the order
        int itemnumber=Integer.parseInt(itemNumber);
        Items orderItem = this.items.get(itemnumber);
        Orders order= new Orders(name);
        order.addItem(orderItem);
        this.orders.add(order);

        System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
        }   
        // Ask them to enter a new item index or q again, and take their input
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        for(Orders order : this.orders){
            order.display();
        }
        
    }
}
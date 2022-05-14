import java.util.ArrayList;

public class Orders {
    // Set the member variables to private instead of  public.
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();

    // Add a constructor to your Order class that takes no arguments, 
    // but sets the name to "Guest" 
    // and initializes the items array to an empty ArrayList<Item> 
    public Orders() {
        this.name = "Guest";
        this.items = new ArrayList<Items>();
    }
    // Add an overloaded constructor for Order 
    // that takes String name as an argument,
    // so you can create an instance with a name.
    public Orders(String name) {
        this.name=name;
    }

    // Create getters and setters for all the member variables.
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public double getTotal() {
        return this.total;
    }
    public void setTotal(double total) {
        this.total=total;
    }
    public boolean getReady() {
        return this.ready;
    }
    public void setReady(boolean ready) {
        this.ready=ready;
    }
    public ArrayList<Items> getItems() {
        return this.items;
    }
    public void setItems(ArrayList<Items> items) {
        this.items=items;
    }
    // Create a method called addItem  
    // that takes an Item object as an argument and adds the item to the order's items array. 
    // No need to return anything.
    public void addItem(Items item) {
        this.items.add(item);
    }


    // Create a method called getStatusMessage that returns a String message. 
    // If the order is ready, return "Your order is ready."
    // , if not, return "Thank you for waiting. Your order will be ready soon."
    public String getStatusMessage() {
        if(this.ready) {
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon."; 
        }
    }
    // create a method called display that prints out the order information.
    public void display() {
        System.out.println("Customer Name: " + this.name);
        for(Items Item:this.items) {
            System.out.println(Item.getName() + " - " + Item.getPrice());
            total += Item.getPrice();
        }
        System.out.println("Total: " + total);
    }
    public double getOrderTotal() {
        for(Items Item:this.items) {
            total += Item.getPrice();
        }
        return total;
    }
}

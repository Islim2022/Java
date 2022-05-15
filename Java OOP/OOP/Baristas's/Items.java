public class Items {
    // Set the member variables to private instead of  public.
    private String name;
    private double price;

    // Create getters and setters for all the member variables.
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    // Add a constructor to your Item class
    public Items(String name, double price){
        this.name=name;
        this.price=price;
    }

}

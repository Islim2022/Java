public class Items {
    private String name;
    private double price;
    private int index;
    
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
    public void setIndex(int index){
        this.index=index;
    }
    public int getIndex(){
        return this.index;
    }
    
    // Add a constructor to your Item class
    public Items(String name, double price, int index){
        this.name=name;
        this.price=price;
        this.index=index;
    }
}

public class Test {
    public static void main(String []args){
        Items item1= new Items("Mocha", 4.5,1);
        Items item2= new Items("Latte", 5.5,2);
        Items item3= new Items("Cappaccino", 3.75,3);
        CoffeeKiosk coffekisok= new CoffeeKiosk();

        coffekisok.addItem("banana", 2.0);
        coffekisok.newOrder();
        coffekisok.addItem("coffe", 1.5);
        coffekisok.addItem("muffin", 4.0);
        coffekisok.newOrder();
        coffekisok.addItem("apple", 2.5);
        coffekisok.newOrder();
    
        
    }
    
}
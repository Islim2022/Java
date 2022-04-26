public class Cafe{
    public static void main(String[] args){
        // APP VARIABLES
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready.";
        String displayTotalMessage = "Your total is $";

        // Menu variables
        double mochaPrice = 3.5;
        double dripCoffePrice = 2.5;
        double lattePrice = 5.5;
        double cappucinoPrice = 3.0;

        // Customer name variables
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION
        // Example:
        System.out.println(generalGreeting + customer1);

        // Cindhuri ordered a coffee
        // Print the correct status message, based on her order status
        System.out.println(customer1 + readyMessage);

        // Noah ordered a cappuccino
        // Use an if statement to check the status of his order and print the correct status message. 
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappucinoPrice);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }

        // Sam just ordered 2 lattes
        // print the message to display their total
        // use an if statement to print the appropriate order status message.
        System.out.println(displayTotalMessage + lattePrice * 2);
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // Jimmy just realized he was charged for a coffee but had ordered a latte. 
        // Print the total message with the new calculated total (what he owes) to make up the difference.
        System.out.println(customer3 + ", " + displayTotalMessage + (lattePrice - dripCoffePrice));
    }
}
import java.util.ArrayList;
import java.util.Random;

public class Puzzlejava {
    // 1. getTenRolls
    // Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
    public ArrayList<Integer> randomNumbers() {

        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        Random randMachine = new Random();

        for (int i = 1; i <=10; i++) {
            randomNumbers.add(randMachine.nextInt(20) + 1);
        }
        return randomNumbers;
    }

    // 2. getRandomLetter
    // Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values).

    public String getRandomLetter() {

        Random randMachine = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char randomLetter = alphabet.charAt(randMachine.nextInt(26));

        return String.valueOf(randomLetter);
    }

    // 3. generatePassword
    // Write a method that uses the previous method to create a random string of eight characters, and return that string.
    public String generatePassword() {

        String password = "";

        for(int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }


    // 4. getNewPasswordSet
    // Write a method that takes an int length as an argument and creates an array of random eight character words. 
    // The array should be the length passed in as an int.
    public ArrayList<String> getNewPasswordSet(int length) {

        ArrayList<String> newPasswordSet = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            newPasswordSet.add(generatePassword());
        }
        return newPasswordSet;

    }
}


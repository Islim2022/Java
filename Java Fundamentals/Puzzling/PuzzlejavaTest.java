import java.util.ArrayList;
import java.util.Random;

public class PuzzlejavaTest {
    public static void main(String[] arg){
        Puzzlejava test = new Puzzlejava();
        System.out.println(test.randomNumbers());
        System.out.println(test.getRandomLetter());
        System.out.println(test.generatePassword());
        System.out.println(test.getNewPasswordSet(8));
    }
}

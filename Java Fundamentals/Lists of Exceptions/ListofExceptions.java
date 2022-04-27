import java.util.ArrayList;

public class ListofExceptions {
    public ArrayList makeList(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(myList.get(i) + "converted into integer");
            }
        return myList;
        }
    }
}

package generics.bounding;

import java.util.ArrayList;
import java.util.List;

// Wildcard: ?
    //? -> "Unknown data type"
    // T: Type T / Any data type
public class GenericWithWildcard {



    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        System.out.println("========== LOWER BOUNDING ============");
        addElements(intList);
        System.out.println("intList = " + intList);

        // addElements(doubleList); => LOWER BOUNDING =>  coz double is not the parent class of Integer
        // addElements(stringList); => LOWER BOUNDING =>  coz string is not the parent class of Integer

        addElements(numberList);
        System.out.println("numberList = " + numberList); // Number is the parent class on Integer

        addElements(objectList);
        System.out.println("objectList = " + objectList); // Object is the parent class on Integer

        System.out.println("========== WILD CARDS ============");
        printElements(intList);
        printElements(doubleList);
        printElements(stringList);
        printElements(numberList);
        printElements(objectList);
    }

    public static void addElements(List<? super Integer> list){ // ? means data can be ANY from the parent of Integer

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
    }

    // Upper bounding with wildcard
    public static void multiplyByTwo(List<? extends Number> list){

        list.stream().map(item -> 2*item.doubleValue());
    }

    public static void printElements(List<?> list){

        // list.add(162); // You can't add / change anything on the list. ? unknown data type => READ ONLY
        // list.remove(2); // indexes are not related to the data types, so we can remove items from this list
        for (Object w: list){
            System.out.print(w + " ");
        }
    }   // NOTE: List<T> and List<?> look similar but they're not.

    public static <T, U> void printElements(List<?> list1, List<?> list2){

        for (Object w: list1){
            System.out.print(w + " ");
        }
    }   // NOTE: List<T> and List<?> look similar but they're not.


//    public static void addElementsToList(List<?> list , ? element){ // CTE => wildcard won't work like this
//
//        list.add(element);
//    }

//    public static <T,U> void addElementsToList(List<T> list , U element){ // CTE => coz T and U data type could be different
//        list.add(element);
//    }

    public static <T> void addElementsToList(List<T> list , T element){
        list.add(element);
    }


}

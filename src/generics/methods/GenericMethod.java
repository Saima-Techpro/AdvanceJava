package generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr = {2, 3, 4, 88, 52};
        Double[] doubleArr = {1.3, 35.2, 87.9, 0.5};
        String[] strArray = {"Java", "Generics", "makes", "our", "lives", "easier"};

        System.out.println("============ Normal way of using printArray() method ============");

        printArray(intArr);
        printArray(doubleArr);
        printArray(strArray);

        // We have learnt Method Overloading previously. But it's inefficient from programming perspective
        // because we have to create 3 different methods to work for 3 different Arrays

        System.out.println("============ Using printArrayGeneric() method ============");

        // Generic method are more efficient because single printArrayGeneric() method works for all 3 arrays with different data types
        printArrayGeneric(intArr);
        printArrayGeneric(doubleArr);
        printArrayGeneric(strArray);

        System.out.println("===================");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(strArray));

        System.out.println("========== MULTIPLE PARAMS GENERIC =========");
        printArrayAndElement(intArr, intArr[0]);
        printArrayAndElement(intArr, getFirst(doubleArr));
        printArrayAndElement(doubleArr, intArr[0]);
        printArrayAndElement(doubleArr, getFirst(strArray));
        printArrayAndElement(strArray, getFirst(intArr));
        printArrayAndElement(strArray, strArray[strArray.length-1]);


    }


    // Method overloading
    public static void printArray(Integer[] array ){
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArray(Double[] array ){
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArray(String[] array ){
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    // Generic method here

    public static <T> void printArrayGeneric(T[] array){
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();

    }

    public static <T> T getFirst(T[] array){
//        T firstElement = array[0];// first way
//        return firstElement;  OR

        return array[0];
    }

    // return type can be any type like String for T Generic type
    public static <T> String getFirstString(T[] array){
        T firstElement = array[0];// first way
        return firstElement.toString();
    }

    public static <T, U> void printArrayAndElement(T[] array, U element){
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println(element);
        System.out.println();

        // NOTE: <T, U> => T and U can have same data type or different

    }
}

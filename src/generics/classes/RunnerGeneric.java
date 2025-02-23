package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        /*
             BENEFITS OF GENERICS

           1- Type-safety: Generics allow our compilers to apply type safety on our codes and if there's
                           a violation of type safety, it will show us CTE (Compile Time Error).
                           Using Generics, we will not get ClassCastException
           2- Since we hae type-safety, we don't need to do any type casting

           3- Generics allow programmers to apply general algorithms
         */

        GenericProduct<String> book = new GenericProduct<>();
        book.setCode("advancedjava");

        GenericProduct<Integer> laptop = new GenericProduct<>();
        laptop.setCode(123456);

        String str = book.getCode();
        int integer = laptop.getCode();

        System.out.println(str + " " + integer);

        // Which class use generic data type?
        // ArrayList<E>  => E stands for Element

        // Which class use generic data type and accepts two parameters?
        // HashMap<K,V> => Key, Value

        /*
        Example:
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Age", 25);
        hashMap.put(12, 25);

         */

        GenericClassTwoParams<String, Integer> myMap = new GenericClassTwoParams<>("Generic", 1234);
        GenericClassTwoParams<String, String> myMap1 = new GenericClassTwoParams<>("Generic", "awesome!!");





    }
}

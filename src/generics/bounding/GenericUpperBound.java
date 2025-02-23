package generics.bounding;

    // We can upper bound parameters for generic types.
    // T: Only sub classes of numbers
    // T: SHORT, BYTE, INTEGER, DOUBLE, LONG, FLOAT, NUMBER

public class GenericUpperBound <T extends Number> { // if want to do mathematical operations ONLY

    public T[] numberArray;

    public Double getAverage(){
        double sum = 0;
        for (T  number: this.numberArray){ // number => w
            sum += number.doubleValue();
        }

        double avg = sum/this.numberArray.length;
        return avg;
    }


    public static void main(String[] args) {

        Integer[] integers = {2,3,6,8,9};
        Double[] doubles = {0.5, 82.7, 10.3, 5.8};
        String[] strings = {"Generics", "can", "be", "upper-bound"};

        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>();
        obj1.numberArray = integers;
        System.out.println("obj1.getAverage() = " + obj1.getAverage());

//        obj1.numberArray = doubles; => gives Compile Time Error => CTE
//        obj1.numberArray = strings; => gives Compile Time Error => CTE


        GenericUpperBound<Double> obj2 = new GenericUpperBound<>();
        obj2.numberArray = doubles;
        System.out.println("obj2.getAverage() = " + obj2.getAverage());
//        obj2.numberArray = strings; => gives Compile Time Error => CTE coz GenericUpperBound extends to Numbers types

//        GenericUpperBound<String> obj3 = new GenericUpperBound<>();
//        obj3.numberArray = strings;  => CTE => coz GenericUpperBound extends to Numbers types







    }
}

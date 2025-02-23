package generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {



        NonGenericProduct book = new NonGenericProduct();
        book.setCode("advancedjava");



        NonGenericProduct laptop = new NonGenericProduct();
        laptop.setCode(123456);

        String str = (String) book.getCode();
//        String str1 = (String) laptop.getCode(); // ClassCastException => RunTime error
        int str1 = (int) laptop.getCode();

    }
}

package generics.classes;

    /*
    Our purpose: We need to create product objects with one class, without creating new classes
    for every single product with product codes of different data types.

    */
public class NonGenericProduct {

    private Object code;


        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }
    }

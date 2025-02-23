package generics.classes;

    /*
    Our purpose: We need to create product objects with one class, without creating new classes
    for every single product with product codes of different data types.

    E --> Element, Collection etc.
    K --> Key
    V --> Value
    N --> Number
    T --> Type
    S,U,V etc. --> For second, third fourth types etc.

    */
public class GenericProduct<T> {

    private T code;

        public T getCode() {
            return code;
        }

        public void setCode(T code) {
            this.code = code;
        }
    }

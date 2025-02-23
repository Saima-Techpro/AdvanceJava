package generics.interfaces;

    /*
    Option 1: If you're implementing generic interface, the class implementing the interface
    should also be generic one. Data type can be decided later

     */
public class GenericInterfaceImpl<T> implements GenericInterface<T> {


        @Override
        public void print(T value) {

        }

        @Override
        public T find() {
            return null;
        }
    }

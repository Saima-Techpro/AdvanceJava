package generics.interfaces;

    /*
    Option 2: Deciding data type while implementing a generic interface
     */
public class GenericInterfaceStringImpl implements GenericInterface <String> {
        @Override
        public void print(String value) {

        }

        @Override
        public String find() {
            return "";
        }
    }

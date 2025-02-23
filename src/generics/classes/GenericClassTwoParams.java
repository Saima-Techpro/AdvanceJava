package generics.classes;

public class GenericClassTwoParams <S, U> {

    // S, U allow us to put different data types without ANY limit on data types

    private S myKey;
    private U myValue;

    public GenericClassTwoParams(S myKey, U myValue) {
        this.myKey = myKey;
        this.myValue = myValue;
    }

    public S getMyKey() {
        return myKey;
    }

    public void setMyKey(S myKey) {
        this.myKey = myKey;
    }

    public U getMyValue() {
        return myValue;
    }

    public void setMyValue(U myValue) {
        this.myValue = myValue;
    }



}

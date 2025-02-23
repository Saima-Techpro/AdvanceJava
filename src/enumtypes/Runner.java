package enumtypes;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthMessage("123456");
        printPasswordStrengthMessage("WEAK");
        printPasswordStrengthMessage("STRONG");
        printPasswordStrengthMessage("VERYSTRONG");

        System.out.println("============= Using Enum =============");

        printPasswordStrengthMessageEnum(PasswordStrength.TOOWEAK);
        printPasswordStrengthMessageEnum(PasswordStrength.WEAK);
        printPasswordStrengthMessageEnum(PasswordStrength.STRONG);
        printPasswordStrengthMessageEnum(PasswordStrength.VERYSTRONG);


    }


    public static void printPasswordStrengthMessage(String strength){
        if (strength.equals(PasswordStrengthConstant.TOOWEAK)){
            System.out.println("Your password is extremely weak, almost non-existent");
        } else if (strength.equals(PasswordStrengthConstant.WAEK)) {
            System.out.println("Your password is weak, try harder");
        } else if (strength.equals(PasswordStrengthConstant.STRONG)) {
            System.out.println("Your password is strong, but could be better");
        } else if (strength.equals(PasswordStrengthConstant.VERYSTRONG)) {
            System.out.println("Your password is very strong. Well done!");
        }else {
            System.out.println("Invalid input"); // make no sense, these messages are sent to user as they're registering
        }
    }


    // Create the same method with Enum

    public static void printPasswordStrengthMessageEnum(PasswordStrength strength){
        if (strength.equals(PasswordStrength.TOOWEAK)){
            System.out.println("Your password is extremely weak, almost non-existent");
        } else if (strength.equals(PasswordStrength.WEAK)) {
            System.out.println("Your password is weak, try harder");
        } else if (strength.equals(PasswordStrength.STRONG)) {
            System.out.println("Your password is strong, but could be better");
        } else if (strength.equals(PasswordStrength.VERYSTRONG)) {
            System.out.println("Your password is very strong. Well done!");
        }
    }
}

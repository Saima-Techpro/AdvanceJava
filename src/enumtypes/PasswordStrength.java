package enumtypes;

public enum PasswordStrength {

    TOOWEAK(5),
    WEAK (25),
    STRONG (75),
    VERYSTRONG(100);

    private final int level;

    PasswordStrength(int level){ // enum constructor is private by default
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}

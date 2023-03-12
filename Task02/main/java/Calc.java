public class Calc {
    private int value;

    public Calc(int value) {
        this.value = value;
    }

    public int countHexDigits() {
        int count = 0;
        String hex = Integer.toHexString(value);
        for (int i = 0; i < hex.length(); i++) {
            if (Character.isDigit(hex.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public int countOctalDigits() {
        int count = 0;
        String octal = Integer.toOctalString(value);
        for (int i = 0; i < octal.length(); i++) {
            if (Character.isDigit(octal.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

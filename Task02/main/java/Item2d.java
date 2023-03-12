import java.io.Serializable;

public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    private int decimalNumber;
    private int hexCount;
    private int octalCount;

    public Item2d(int decimalNumber, int hexCount, int octalCount) {
        this.decimalNumber = decimalNumber;
        this.hexCount = hexCount;
        this.octalCount = octalCount;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public int getHexCount() {
        return hexCount;
    }

    public int getOctalCount() {
        return octalCount;
    }

    // Метод для подсчета количества 16-ричных и 8-ричных цифр
    public static Item2d countHexOctalDigits(int decimalNumber) {
        int hexCount = 0;
        int octalCount = 0;

        // Преобразование десятичного числа в строку
        String decimalString = Integer.toString(decimalNumber);

        // Подсчет количества 16-ричных цифр в строке
        for (int i = 0; i < decimalString.length(); i++) {
            char c = decimalString.charAt(i);
            if (c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || Character.isDigit(c) && Integer.parseInt(String.valueOf(c)) >= 8) {
                hexCount++;
            }
        }

        // Подсчет количества 8-ричных цифр в строке
        for (int i = 0; i < decimalString.length(); i++) {
            char c = decimalString.charAt(i);
            if (Character.isDigit(c) && Integer.parseInt(String.valueOf(c)) >= 8) {
                octalCount++;
            }
        }

        return new Item2d(decimalNumber, hexCount, octalCount);
    }
}

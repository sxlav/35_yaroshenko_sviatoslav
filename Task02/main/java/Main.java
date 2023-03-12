import java.io.*;

public class Main {
    public static void main(String[] args) {
        // створюємо об'єкт класу Item2d
        Item2d item = new Item2d(5, 10, 20);

        try {
            // записуємо об'єкт у файл
            FileOutputStream fileOut = new FileOutputStream("item.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(item);
            out.close();
            fileOut.close();

            // зчитуємо об'єкт з файлу
            FileInputStream fileIn = new FileInputStream("item.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Item2d itemRead = (Item2d) in.readObject();
            in.close();
            fileIn.close();

            // виводимо результати підрахунку
            System.out.println("Decimal number: " + item.getDecimalNumber());
            System.out.println("Hexadecimal digits: " + itemRead.getHexCount());
            System.out.println("Octal digits: " + itemRead.getOctalCount());

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Item2d class not found");
            c.printStackTrace();
        }
    }
}

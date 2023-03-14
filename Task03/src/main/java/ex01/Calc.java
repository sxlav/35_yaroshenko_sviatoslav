package ex01;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * The Calc class performs calculations on a given input and saves the result to a file.
 */
public class Calc {
    /**
     * The name of the file to save the result to.
     */
    private static final String FILENAME = "Save.bin";
    /**
     * The current result of the calculation.
     */
    private Item2d result;
    /**
     * Creates a new `Calc` object with a default result.
     */
    public Calc() {
        result = new Item2d();
    }
    /**
     * Sets the current result of the calculation.
     * @param result the new result of the calculation
     */
    public void setResult(Item2d result) {
        this.result = result;
    }
    /**
     * Returns the current result of the calculation.
     * @return the current result of the calculation
     */
    public Item2d getResult() {
        return result;
    }
    /**
     * Calculates the hexadecimal and octal representation of the input value and returns the result.
     * @param input the input value to calculate
     * @return an `Item2d` object containing the input value, hexadecimal count, and octal count
     */
    public Item2d calc(double input) {
        String hexOutput = Double.toHexString(input);
        String octOutput = Integer.toOctalString((int) input);

        // Подсчет количества шестнадцатеричных и восьмеричных цифр
        int hexCount = hexOutput.replaceAll("\\.", "").length();
        int octCount = octOutput.length();

        return new Item2d(input, hexCount, octCount);
    }
    /**
     * Initializes the result of the calculation with the calculated value based on the given input.
     * @param input the input value to calculate
     */
    public void init(double input) {
        setResult(calc(input));
    }
    /**
     * Prints the current result of the calculation to the console.
     */
    public void show() {
        System.out.println(getResult());
    }
    /**
     * Saves the current result of the calculation to a file.
     * @throws IOException if there is an error writing to the file
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    /**
     * Restores the current result of the calculation from a saved file.
     * @throws Exception if there is an error reading from the file
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}
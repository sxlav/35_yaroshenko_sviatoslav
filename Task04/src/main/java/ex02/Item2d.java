package ex02;

import java.io.Serializable;
/**
 * Представляет двумерный элемент, в котором хранятся входные данные вместе с количеством шестнадцатеричных и восьмеричных цифр.
 */
public class Item2d implements Serializable {
    /**
     * Входное значение элемента.
     */
    private double input;
    /**
     * Количество шестнадцатеричных цифр в элементе.
     */
    private int hex;
    /**
     * Количество восьмеричных цифр в элементе.
     */
    private int oct;
    /**
     * Создает новый Item2d со значениями по умолчанию input, hex и oct.
     */
    public Item2d() {}
    /**
     * Создает новый Item2d с указанными значениями для ввода, шестнадцатеричного и окт.
     *
     * @param input The input value of the item.
     * @param hex The number of hexadecimal digits in the item.
     * @param oct The number of octal digits in the item.
     */
    public Item2d(double input, int hex, int oct) {
        this.input = input;
        this.hex= hex;
        this.oct = oct;
    }
    /**
     * Gets the input value of the item.
     *
     * @return The input value of the item.
     */
    public double getInput() {
        return input;
    }
    /**
     * Sets the input value of the item.
     *
     * @param input The input value of the item.
     */
    public void setInput(double input) {
        this.input = input;
    }
    /**
     * Gets the number of hexadecimal digits in the item.
     *
     * @return The number of hexadecimal digits in the item.
     */
    public int getHex() {
        return oct;
    }
    /**
     * Sets the number of hexadecimal digits in the item.
     *
     * @param hex The number of hexadecimal digits in the item.
     */
    public void setHex(int hex) {
        this.hex = hex;
    }
    /**
     * Gets the number of octal digits in the item.
     *
     * @return The number of octal digits in the item.
     */
    public int getOct() {
        return oct;
    }
    /**
     * Sets the number of octal digits in the item.
     *
     * @param oct The number of octal digits in the item.
     */
    public void setOct(int oct) {
        this.oct = oct;
    }
    /**
     * Returns a string representation of the item.
     *
     * @return A string representation of the item.
     */
    @Override
    public String toString() {
        return "Input: " + input + ", Number of hexadecimal digits: " + hex +
                ", Number of octal digits: " + oct;
    }
}
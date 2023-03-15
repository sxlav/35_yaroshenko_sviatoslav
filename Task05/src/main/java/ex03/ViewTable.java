package ex03;
import java.util.Formatter;
import ex02.Item2d;
import ex02.ViewResult;
/** ConcreteProduct
 * (шаблон проектирования
 * Factory Method)<br>
 * Вывод в виде таблицы
 * @author xone
 * @version 1.0
 * @see ViewResult
 */


public class ViewTable extends ViewResult {
    /** Определяет ширину таблицы по умолчанию */
    private static final int DEFAULT_WIDTH = 20;
    /** Текущая ширина таблицы */
    private int width;
    /** Устанавливает {@linkplain ViewTable#width width}
     * значением {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }
    /** Устанавливает {@linkplain ViewTable#width} значением <b>width</b><br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult() ViewResult()}
     * @param width определяет ширину таблицы
     */
    public ViewTable(int width) {
        this.width = width;
    }
    /** Устанавливает {@linkplain ViewTable#width} значением <b>width</b><br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult(int n) ViewResult(int
    n)}
     * @param width определяет ширину таблицы
     * @param n количество элементов коллекции; передаётся суперконструктору
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }
    /** Устанавливает поле {@linkplain ViewTable#width} значением <b>width</b>
     * @param width новая ширина таблицы
     * @return заданная параметром <b>width</b> ширина таблицы
     */
    public int setWidth(int width) {
        return this.width = width;
    }
    /** Возвращает значение поля {@linkplain ViewTable#width}
     * @return текущая ширина таблицы
     */
    public int getWidth() {
        return width;
    }
    /** Выводит вертикальный разделитель шириной {@linkplain ViewTable#width} символов */
    private void outLine() {
        for(int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }
    /** Вызывает {@linkplain ViewTable#outLine()}; завершает вывод разделителем строки */
    private void outLineLn() {
        outLine();
        System.out.println();
    }
    /** Выводит заголовок таблицы шириной {@linkplain ViewTable#width} символов */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%" + ((width)/3) + "s|%" + ((width)/3) + "s|%" + ((width)/3) + "s\n", "Input", "Hex", "Oct");
        System.out.printf(fmt.toString());
    }
    /** Выводит тело таблицы шириной {@linkplain ViewTable#width} символов */
    private void outBody() {
       for(Item2d item : getItems()) {
           Formatter formatter = new Formatter();
           formatter.format("%" + ((width)/3) + ".2f|%" + ((width)/3) + "s|%" + ((width)/3) + "s\n", item.getInput(), item.getHex(), item.getOct());
           System.out.print(formatter.toString());
       }
    }
    /** Перегрузка (совмещение, overloading) метода суперкласса;
     * устанавливает поле {@linkplain ViewTable#width} значением <b>width</b><br>
     * Вызывает метод {@linkplain ViewResult#viewInit() viewInit()}
     * @param width новая ширина таблицы


     */
    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();
    }
    /** Перегрузка метода суперкласса;
     * устанавливает поле {@linkplain ViewTable#width} значением <b>width</b><br>
     * Для объекта {@linkplain ViewTable} вызывает метод {@linkplain ViewTable#init(double
            stepX)}
     * @param width новая ширина таблицы.
     * @param stepInput передается методу <b>init(double)</b>
     */
    public final void init(int width, double stepInput) { // method overloading
        this.width = width;
        init(stepInput);
    }
    /** Переопределение (замещение, overriding) метода суперкласса;
     * выводит информационное сообщение и вызывает метод суперкласса
     * {@linkplain ViewResult#init(double stepX) init(double stepX)}<br>
     * {@inheritDoc}
     */
    @Override
    public void init(double stepInput) { // method overriding
        System.out.print("Initialization... ");
        super.init(stepInput);
        System.out.println("done. ");
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewBody() {
        outBody();
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}
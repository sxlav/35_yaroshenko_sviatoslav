package ex04;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ex02.ViewResult;
import ex02.Item2d;
/** Тестирование класса
 * ChangeItemCommand
 * @author xone
 * @version 4.0
 * @see ChangeItemCommand
 */
public class MainTest {
   private ViewResult viewResult;
    /**
    * Настраивает новый объект ViewResult с двумя элементами для тестирования перед каждым тестом.
    */
    @Before
    public void setUp(){
        // создаем новый объект ViewResult с двумя элементами для тестирования
        viewResult = new ViewResult(2);
    }
    /**
     * Проверяет метод calc() класса ViewResult, предоставляя входное значение 10,0.
     * Метод вычисляет шестнадцатеричные и восьмеричные значения для входного значения и возвращает карту.
     * Ожидаемый результат сравнивается с фактическим с помощью метода assertEquals.
     */
    @Test
    public void testCalc(){
        // протестируем метод calc() с входным значением 10.0
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("hex", 5);
        expected.put("oct", 2);
        assertEquals(expected, viewResult.calc(10.0));
    }
    /**
     * Проверяет метод init() класса ViewResult, проверяя входные, шестнадцатеричные и восьмеричные значения первого элемента.
     * после инициализации с входным значением 0,5. Ожидаемые значения сравниваются с фактическими значениями с помощью
     * метод assertEquals.
     */
    @Test
    public void testInit(){
        // тестируем метод init(), проверяя входные и шестнадцатеричные/восьмеричные значения первого элемента
        viewResult.init(0.5);
        Item2d item = viewResult.getItems().get(0);
        assertEquals(0.5, item.getInput(), 0.0);
        assertEquals(1, item.getHex());
        assertEquals(1, item.getOct());
    }
    /**
    * Очищает после каждого теста, устанавливая для объекта ViewResult значение null.
    */
    @After
    public void tearDown(){
        // очищаем после каждого теста, устанавливая для объекта viewResult значение null
        viewResult = null;
    }

}
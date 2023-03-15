package ex01;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Calc;
/** Выполняет тестирование разработанных классов.
 * @author xone
 * @version 1.0
 */
public class MainTest {
    /**
     * Проверка основной функциональности класса {@linkplain Calc}
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        Item2d result = calc.calc(15.5);
        assertEquals(15.5, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }

    /**
     * Проверка сериализации. Корректность восстановления данных.
     */
    @Test
    public void testInit() {

        Calc calc = new Calc();
        calc.init(20.25);
        Item2d result = calc.getResult();
        assertEquals(20.25, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }

    @Test
    public void testSaveAndRestore() {
        Calc calc = new Calc();
        calc.init(10.0);
        try {
            calc.save();
            calc.restore();
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
        Item2d result = calc.getResult();
        assertEquals(10.0, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }
}
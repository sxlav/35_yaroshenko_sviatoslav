package ex05;
import ex02.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ex02.ViewResult;
import ex02.Item2d;

/** Тестирование
 * разработанных классов
 * @author xone
 * @version 5.0
 * @see CommandQueue
 * @see MaxCommand
 * @see AvgCommand
 * @see MinMaxCommand
 */

public class MainTest {
    private static final String FILENAME = "items.bin";

    private ViewResult viewResult;
    /**
     * Инициализирует новый объект ViewResult перед каждым тестом.
     * @throws Exception, если возникает исключение
     */
    @Before
    public void setUp() throws Exception{
        viewResult = new ViewResult(10);
        viewResult.viewInit();
    }
    /**
     * Удаляет файл "items.bin" после каждого теста, если он существует.
     * @throws Exception, если возникает исключение
     */
    @After
    public void tearDown() throws Exception{
        File file = new File(FILENAME);
        if(file.exists()){
            file.delete();
        }
    }
    /**
     * Тестирует метод getItems в классе ViewResult.
     * Проверяет, не является ли список элементов, возвращаемых getItems, пустым и имеет размер 10.
     * @throws Exception, если возникает исключение
     */
    @Test
    public void testGetItems() throws Exception{
        ArrayList<Item2d> items = viewResult.getItems();
        assertNotNull(items);
        assertEquals(10, items.size());
    }
    /**
     * Проверяет метод calc в классе ViewResult.
     * Проверяет, не является ли карта, возвращаемая calc, нулевой и имеет ли ожидаемые значения для «hex» и «oct».
     * @throws Exception, если возникает исключение
     */
    @Test
    public void testCalc() throws Exception{
        Map<String, Integer> map = viewResult.calc(255.0);
        assertNotNull(map);
        assertEquals(6, map.get("hex").intValue());
        assertEquals(3, map.get("oct").intValue());
    }
    /**
     * Проверяет методы viewSave и viewRestore в классе ViewResult.
     * Сохраняет текущее состояние viewResult с помощью viewSave, восстанавливает его с помощью viewRestore, а затем проверяет, соответствуют ли восстановленные элементы исходным элементам.
     * @throws Exception, если возникает исключение
     */
    @Test
    public void testViewSaveAndRestore() throws Exception{
        viewResult.viewSave();
        ViewResult restoredViewResult = new ViewResult();
        restoredViewResult.viewRestore();
        ArrayList<Item2d> originalItems = viewResult.getItems();
        ArrayList<Item2d> restoredItems = restoredViewResult.getItems();
        assertNotNull(restoredItems);
        assertEquals(originalItems.size(), restoredItems.size());


        for (int i = 0; i < originalItems.size(); i++){
            Item2d originalItem = originalItems.get(i);
            Item2d restoredItem = restoredItems.get(i);

            assertEquals(originalItem.getInput(), restoredItem.getInput(), 0.0);
            assertEquals(originalItem.getHex(), restoredItem.getHex());
            assertEquals(originalItem.getOct(), restoredItem.getOct());
        }
    }
}
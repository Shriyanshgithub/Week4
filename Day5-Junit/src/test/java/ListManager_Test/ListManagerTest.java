package ListManager_Test;

import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_3.ListManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    ListManager listManager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        assertEquals(2, list.size());
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        assertTrue(listManager.removeElement(list, 5));
        assertFalse(list.contains(5));
        assertEquals(1, list.size());

        assertFalse(listManager.removeElement(list, 20)); // Element not in list
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));

        list.add(1);
        list.add(2);
        assertEquals(2, listManager.getSize(list));

        list.clear();
        assertEquals(0, listManager.getSize(list));
    }

    @Test
    void testNullListOperations() {
        assertEquals(0, listManager.getSize(null));
        assertFalse(listManager.removeElement(null, 5));

        List<Integer> list = null;
        listManager.addElement(list, 5); // Should not throw an exception
    }
}


import java.util.ArrayList;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    void testAddRemoveAndSize() {
        ArrayList<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);

        assertEquals(2, manager.getSize(list));

        manager.removeElement(list, 10);
        assertEquals(1, manager.getSize(list));
    }
}

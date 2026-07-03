import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<String> items;

    @Before
    public void setUp() {
        items = new ArrayList<>();
        items.add("Apple");
    }

    @After
    public void tearDown() {
        items.clear();
        items = null;
    }

    @Test
    public void testAddItem() {
        String newItem = "Banana";

        items.add(newItem);

        assertEquals(2, items.size());
        assertEquals("Banana", items.get(1));
    }
}
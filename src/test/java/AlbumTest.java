import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AlbumTest {

    @Test
    public void testAppend() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        assertEquals("1 -> 2 -> 3 -> NULL", doublyLinkedList.toString());
    }

    @Test
    public void testInsert(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(0, 1);
        list.insert(1, 2);
        assertEquals("1 -> 2 -> NULL", list.toString());
        list.insert(0,0);
        assertEquals("0 -> 1 -> 2 -> NULL", list.toString());
    }

    @Test
    public void testDelete(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.delete(1);
        assertEquals("1 -> 3 -> 4 -> NULL", list.toString());
        list.delete(2);
        assertEquals("1 -> 3 -> NULL", list.toString());
    }


}
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

    @Test
    public void testGetIndex(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        assertEquals(0, list.getIndex(1));
        assertEquals(1, list.getIndex(2));
        assertEquals(2, list.getIndex(3));
        assertEquals(3, list.getIndex(4));
        assertEquals(-1, list.getIndex(5));
    }
    @Test
    public void testShuffle(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.shuffle();
        assertNotEquals("1 -> 2 -> 3 -> 4 -> NULL", list.toString());
        System.out.println(list.toString());
    }

    @Test
    public void testPartition(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        DoublyLinkedList<Integer> newList = list.partition(3);
        assertEquals("3 -> 4 -> NULL", newList.toString());
        assertEquals("1 -> 2 -> NULL", list.toString());
        System.out.println(newList.toString());
    }
}
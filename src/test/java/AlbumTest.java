import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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

    @Test
    public void testAppendAlbum() {
        DoublyLinkedList<Album> list = new DoublyLinkedList<>();
        List<String> artists1 = new ArrayList<>();
        artists1.add("ArtistName");
        Album album1 = new Album(1, artists1, "Album One", 10);

        List<String> artists2 = new ArrayList<>();
        artists2.add("ArtistName2");
        Album album2 = new Album(2, artists2, "Album Two", 15);

        list.append(album1);
        list.append(album2);

        assertEquals("ID: 1 - - 10 - - [ArtistName] -> ID: 2 - - 15 - - [ArtistName2] -> NULL", list.toString());
    }

    @Test
    public void testInsertAlbum() {
        DoublyLinkedList<Album> list = new DoublyLinkedList<>();
        List<String> artists1 = new ArrayList<>();
        artists1.add("Wasta");
        Album album1 = new Album(1, artists1, "Album One", 10);

        List<String> artists2 = new ArrayList<>();
        artists2.add("Puth");
        Album album2 = new Album(2, artists2, "Album Two", 15);

        list.append(album1);
        list.insert(1, album2);

        assertEquals("ID: 1 - - 10 - - [Wasta] -> ID: 2 - - 15 - - [Puth] -> NULL", list.toString());

        List<String> artists3 = new ArrayList<>();
        artists3.add("Harris");
        Album album3 = new Album(3, artists3, "Album Three", 20);

        list.insert(0, album3);

        assertEquals("ID: 3 - - 20 - - [Harris] -> ID: 1 - - 10 - - [Wasta] -> ID: 2 - - 15 - - [Puth] -> NULL", list.toString());
    }

    @Test
    public void testDeleteAlbum(){
        DoublyLinkedList<Album> list = new DoublyLinkedList<>();
        List<String> artists1 = new ArrayList<>();
        artists1.add("Wasta");
        Album album1 = new Album(1, artists1, "Album One", 10);
        List<String> artists2 = new ArrayList<>();
        artists2.add("Puth");
        Album album2 = new Album(2, artists2, "Album Two", 15);
        list.append(album1);
        list.append(album2);

        list.delete(1);
        assertEquals("ID: 1 - - 10 - - [Wasta] -> NULL", list.toString());
    }



}
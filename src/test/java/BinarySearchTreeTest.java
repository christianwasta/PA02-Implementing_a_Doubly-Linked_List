import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testConstructor() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertNull(bst.root);
    }

    @Test
    public void testInsert() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        ArrayList<String> artists = new ArrayList<>();
        artists.add("The Beatles");
        artists.add("The Rolling Stones");
        Album album = new Album(1, artists, "The White Album", 30);
        bst.insert(album);
        assertEquals(album, bst.root.data);
        System.out.println(bst.root.data);
    }



}
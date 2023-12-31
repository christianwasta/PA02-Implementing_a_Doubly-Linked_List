import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(bst.root);
        bst.insert(album);
        assertEquals(album, bst.root.data);
        System.out.println(bst.root.data);
    }

    @Test
    public void testDeleteNum(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        Node<Integer> deleteNode = bst.delete(50);
        System.out.println("Deleted Node:" + deleteNode.data);

    }
    @Test
    public void testDelete() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        ArrayList<String> artists = new ArrayList<>();
        artists.add("The Beatles");
        artists.add("The Rolling Stones");
        Album album = new Album(1, artists, "The White Album", 30);
        bst.insert(album);
        System.out.println(bst.root.data);
        assertEquals(album, bst.root.data);
        Node<Album> deleteNode = bst.delete(album);
        assertNull(bst.root);
        System.out.println("Deleted Node:" + deleteNode.data);

    }

    @Test
    public void testContains() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        ArrayList<String> artists = new ArrayList<>();
        artists.add("The Beatles");
        artists.add("The Rolling Stones");
        Album album = new Album(1, artists, "The White Album", 30);
        bst.insert(album);
        assertTrue(bst.contains(album));
        System.out.println(bst.contains(album));
        assertFalse(bst.contains(new Album(2, artists, "The White Album", 30)));
        System.out.println(bst.contains(new Album(2, artists, "The White Album", 30)));
    }

    @Test
    public void testToString() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        String expected = "50, 30, 20, N, N, 40, N, N, 70, N, N";
        String actual = bst.toString();
        assertEquals(expected, actual);
        System.out.println(bst.toString());
    }

    @Test
    public void testRebalance() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        ArrayList<String> artists = new ArrayList<>();
        artists.add("The Beatles");
        artists.add("The Rolling Stones");
        Album album1 = new Album(1, artists, "The White Album", 30);
        Album album2 = new Album(2, artists, "The White Album", 30);

        bst.insert(album2);
        bst.insert(album1);
        System.out.println(bst.toString());
        BinarySearchTree<Album> newTree = bst.rebalance();
        System.out.println(newTree.toString());
        assertEquals(album1, newTree.root.data);
        assertEquals(album2, newTree.root.right.data);
    }

    @Test
    public void testPartition() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        List<Integer> partitionList = bst.partition(40);
        assertEquals(40, partitionList.get(0));
        System.out.println(partitionList);
    }

    @Test
    public void testPartitionAlbum() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        ArrayList<String> artists = new ArrayList<>();
        artists.add("The Beatles");
        artists.add("The Rolling Stones");
        Album album1 = new Album(1, artists, "The White Album", 30);
        Album album2 = new Album(2, artists, "The White Album", 30);

        bst.insert(album1);
        bst.insert(album2);
        List<Album> partitionList = bst.partition(album2);
        List<Album> partitionList2 = bst.partition(album1);
        assertEquals(album1, partitionList2.get(1));
        System.out.println(partitionList2);
    }



}
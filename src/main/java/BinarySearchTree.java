public class BinarySearchTree<T extends Comparable<T>>{
    public Node<T> root;
    private int size;

    public BinarySearchTree(){
        root = null;
        this.size = 0;
    }

    public Node<T> insert(T data){
        root = insert(root, data);
        return root;
    }

    public Node<T> insert(Node<T> node, T data){
        if (node == null){
            node = new Node<>(data);
            return node;
        }
        if (data.compareTo(node.data) < 0){
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0){
            node.right = insert(node.right, data);
        }
        return node;
    }


}


import java.util.ArrayList;
import java.util.List;

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

    private Node<T> insert(Node<T> node, T data){
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
    public T delete(T data){
        Node<T> deleteNode = new Node<>(data);
        root = delete(root, data, deleteNode);
        if (deleteNode.data == null){
            throw new IllegalArgumentException("Cannot delete from an empty tree");
        }
        return deleteNode.data;
    }

    private Node<T> delete(Node<T> node, T data, Node<T> deleteNode){
        if (node == null){
            return null;
        }
        if (data.compareTo(node.data) < 0){
            node.left = delete(node.left, data, deleteNode);
        } else if (data.compareTo(node.data) > 0){
            node.right = delete(node.right, data, deleteNode);
        } else {
            if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            }
            node.data = findMin(node.right);
            node.right = delete(node.right, node.data, deleteNode);
        }
        return node;
    }

    private T findMin(Node<T> node) {
        T findMin = node.data;
        while (node.left != null){
            findMin = node.left.data;
            node = node.left;
        }
        return findMin;
    }

    public boolean contains(T data){
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data){
        if (node == null){
            return false;
        }
        if (data.compareTo(node.data) < 0){
            return contains(node.left, data);
        } else if (data.compareTo(node.data) > 0){
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    @Override
    public String toString(){
        return toString(root);
    }

    private String toString(Node<T> node){
        if (node == null){
            return "N";
        }
        return node.data.toString() + ", " + toString(node.left) + ", " + toString(node.right);
    }

    private Node<T> get(){
        return root;
    }

    public BinarySearchTree<T> rebalance(){
        List<T> inorderList = new ArrayList<>();
        inOrder(root, inorderList);
        return buildBalancedTree(inorderList, 0, inorderList.size() - 1);
    }

    private void inOrder(Node<T> node, List<T> inorderList){
        if (node == null){
            return;
        }
        inOrder(node.left, inorderList);
        inorderList.add(node.data);
        inOrder(node.right, inorderList);
    }

    private BinarySearchTree<T> buildBalancedTree(List<T> inorderList, int start, int end) {
        if (start > end) {
            return new BinarySearchTree<>();
        }
        int mid = (start + end) / 2;
        BinarySearchTree<T> balancedTree = new BinarySearchTree<>();
        balancedTree.insert(inorderList.get(mid));

        balancedTree.root.left = buildBalancedTree(inorderList, start, mid - 1).root;
        balancedTree.root.right = buildBalancedTree(inorderList, mid + 1, end).root;
        return balancedTree;
    }

    public List<T> partition(T data){
        List<T> partitionList = new ArrayList<>();
        partition(root, data, partitionList);
        return partitionList;
    }

    private void partition(Node<T> node, T data, List<T> partitionList){
        if (node == null){
            return;
        }
        if (node.data.compareTo(data) >= 0){
            partition(node.left, data, partitionList);
            partition(node.right, data, partitionList);
            partitionList.add(node.data);
        }
        else {
            partition(node.right, data, partitionList);
        }
    }
}


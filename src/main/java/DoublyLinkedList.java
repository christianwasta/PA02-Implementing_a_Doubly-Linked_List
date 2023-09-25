public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node append(T data) {
        Node newNode = new Node<T>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> insert(int location, T data) {
        Node<T> newNode = new Node<>(data);
        if (location == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (location == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
        return newNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> toPrint = this.head;
        while (toPrint != null) {
            stringBuilder.append(toPrint.data.toString());
            stringBuilder.append(" -> ");
            toPrint = toPrint.next;
        }

        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}

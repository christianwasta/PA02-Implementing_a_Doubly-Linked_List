public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
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

    public Node<T> delete(int location) {
        Node<T> toDelete = null;
        if (location == 0) {
            toDelete = head;
            head = head.next;
            head.prev = null;
        } else if (location == size - 1) {
            toDelete = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            toDelete = current.next;
            current.next = current.next.next;
            current.next.prev = current;
        }
        size--;
        return toDelete;
    }

    public int getIndex(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int shuffle() {
        Node<T> current = head;
        int random = (int) (Math.random() * size);

        for (int i = 0; i < size; i++) {
            Node<T> randomNode = head;
            for (int j = 0; j < random; j++) {
                randomNode = randomNode.next;
            }
            Node<T> temp = new Node<>(current.data);
            current.data = randomNode.data;
            randomNode.data = temp.data;
            current = current.next;
        }
        System.out.println(random);
        return random;
    }

    public DoublyLinkedList<T> partition(T data){
        DoublyLinkedList<T> newList = new DoublyLinkedList<>();
        Node current = head;
        while (current != null) {
            if (((Comparable<T>) current.data).compareTo(data) >= 0) {
                newList.append((T) current.data);
                delete(getIndex((T) current.data));
            }
            current = current.next;
        }
        return newList;
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

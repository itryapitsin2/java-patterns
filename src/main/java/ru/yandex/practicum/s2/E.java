package ru.yandex.practicum.s2;

// <template>
class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
// <template>

public class E {
    public static Node<String> solution(Node<String> head) {
        Node<String> current = head;
        Node<String> result = null;
        do {
            Node<String> next = current.next;
            Node<String> prev = current.prev;

            result = current;

            result.next = prev;
            result.prev = next;

            current = next;
        } while (current != null);

        return result;
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        node1.prev = node0;
        node2.prev = node1;
        node3.prev = node2;
        Node<String> newNode = solution(node0);
        /* result is :*/
        assert newNode == node3;
        assert node3.next == node2;
        assert node2.next == node1;
        assert node2.prev == node3;
        assert node1.next == node0;
        assert node1.prev == node2;
        assert node0.prev == node1;
    }
}
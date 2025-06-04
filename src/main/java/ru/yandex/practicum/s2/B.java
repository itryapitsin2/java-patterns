package ru.yandex.practicum.s2;

class NodeB<V> {
    public V value;
    public NodeB<V> next;

    public NodeB(V value, NodeB<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class B {
    public static void solution(NodeB<String> head) {
        NodeB<String> current = head;
        do {
            System.out.println(current.value);
            current = current.next;
        } while (current != null);
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        NodeB<String> node3 = new NodeB<>("node3", null);
        NodeB<String> node2 = new NodeB<>("node2", node3);
        NodeB<String> node1 = new NodeB<>("node1", node2);
        NodeB<String> node0 = new NodeB<>("node0", node1);
        solution(node0);
        /*
        Output is:
        node0
        node1
        node2
        node3
        */
    }
}
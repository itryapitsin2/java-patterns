package ru.yandex.practicum.s2;

// <template>
class NodeD<V> {
    public V value;
    public NodeD<V> next;

    public NodeD(V value, NodeD<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class D {
    public static int solution(NodeD<String> head, String elem) {
        int idx = 0;
        NodeD<String> current = head;
        do {
            if (current.value.equals(elem)) {
                return idx;
            }
            current = current.next;
            idx++;
        } while (current != null);
        return -1;
    }

    public static void main(String[] args) {
        NodeD<String> node3 = new NodeD<>("node3", null);
        NodeD<String> node2 = new NodeD<>("node2", node3);
        NodeD<String> node1 = new NodeD<>("node1", node2);
        NodeD<String> node0 = new NodeD<>("node0", node1);
        int idx = solution(node0, "node0");
        System.out.println(idx);
    }
}
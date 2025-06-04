package ru.yandex.practicum.s2;

// <template>
class NodeC<V> {
    public V value;
    public NodeC<V> next;

    public NodeC(V value, NodeC<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class C {
    public static NodeC<String> solution(NodeC<String> head, int idx) {
        int counter = 0;
        NodeC<String> current = head;
        NodeC<String> prev = null;
        do {
            if (counter == idx) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
            counter++;
        } while ((counter - 1) != idx);
        return head;
    }

    public static void main(String[] args) {
        NodeC<String> node3 = new NodeC<>("node3", null);
        NodeC<String> node2 = new NodeC<>("node2", node3);
        NodeC<String> node1 = new NodeC<>("node1", node2);
        NodeC<String> node0 = new NodeC<>("node0", node1);
        NodeC<String> newHead = solution(node0, 1);
        System.gc();
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}

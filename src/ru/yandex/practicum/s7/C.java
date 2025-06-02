package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class C {

    private record GoldSandHeap(long price, long mass) implements Comparable<GoldSandHeap> {

        @Override
        public int compareTo(GoldSandHeap o) {
            var result = Long.compare(o.price(), this.price);
            if (result == 0) {
                return Long.compare(o.mass(), this.mass);
            } else {
                return result;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var maxPayload = Integer.parseInt(reader.readLine());
            var heapCount = Integer.parseInt(reader.readLine());

            var heaps = new ArrayList<GoldSandHeap>();

            for (int i = 0; i < heapCount; i++) {
                var heap = new ArrayList<>(Arrays
                        .stream(reader.readLine().split(" "))
                        .map(Long::parseLong)
                        .toList());

                heaps.add(new GoldSandHeap(heap.getFirst(), heap.getLast()));
            }

            Collections.sort(heaps);

            var sum = 0L;
            var payload = 0L;
            var iterator = heaps.iterator();
            while (payload < maxPayload && iterator.hasNext()) {
                var next = iterator.next();
                var availablePayload = maxPayload - payload;
                var takeMass = next.mass - availablePayload > 0 ? availablePayload : next.mass;

                sum += (next.price * takeMass);
                payload += takeMass;
            }

            System.out.println(sum);
        }
    }
}

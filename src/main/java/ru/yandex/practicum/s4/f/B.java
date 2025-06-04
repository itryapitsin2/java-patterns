package ru.yandex.practicum.s4.f;

import java.util.*;

public class B {

    public enum OperationType {
        GET,
        PUT,
        DELETE
    }

    private static final String NONE = "None";

    public record Operation(OperationType operationType, Integer... args) {
    }

    public record KeyValue<K, V>(K key, V value) {
    }

    public static class Database {

        private final List<KeyValue<Integer, Integer>>[] store;
        private final int n;

        // Размер базы выбран пропорционально количеству документов в этой задаче.
        // По условие не нужно делать рехеширование, но хотелось избежать большого колинства коллизий.
        public Database(int n) {
            this.store = new LinkedList[n];
            this.n = n;
        }

        public Optional<Integer> delete(Integer key) {
            int hashCode = getHash(key);

            if (store[hashCode] != null) {
                Optional<Integer> value = store[hashCode].stream()
                        .filter(x -> x.key.equals(key))
                        .findFirst()
                        .map(x -> x.value);

                store[hashCode].stream()
                        .filter(x -> x.key.equals(key))
                        .toList()
                        .forEach(x -> store[hashCode].remove(x));

                return value;
            }

            return Optional.empty();
        }

        public void put(Integer key, Integer value) {
            int hashCode = getHash(key);

            List<KeyValue<Integer, Integer>> list = store[hashCode] == null
                    ? new LinkedList<>()
                    : store[hashCode];

            list.addFirst(new KeyValue<>(key, value));
            store[hashCode] = list;
        }

        public Optional<Integer> get(Integer key) {
            int hashCode = getHash(key);
            if (store[hashCode] == null) {
                return Optional.empty();
            }

            return store[hashCode]
                    .stream()
                    .filter(x -> x.key.equals(key))
                    .map(x -> x.value)
                    .findFirst();
        }

        public int getHash(Integer key) {
            return Math.abs(Objects.hash(key) % n);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Operation> requests = readRequests(scanner, n);
            Database database = new Database(n);

            requests.forEach(request -> {
                switch (request.operationType) {
                    case GET -> {
                        Optional<Integer> value = database.get(request.args[0]);
                        System.out.println(
                                value.isPresent() ? value.get() : NONE
                        );
                    }
                    case PUT -> database.put(request.args[0], request.args[1]);
                    case DELETE -> {
                        Optional<Integer> value = database.delete(request.args[0]);
                        System.out.println(
                                value.isPresent() ? value.get() : NONE
                        );
                    }
                }
            });
        }
    }

    private static List<Operation> readRequests(Scanner scanner, int n) {
        List<Operation> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            Operation operation = switch (tmp[0]) {
                case "get" -> new Operation(OperationType.GET, Integer.parseInt(tmp[1]));
                case "put" -> new Operation(OperationType.PUT, Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
                case "delete" -> new Operation(OperationType.DELETE, Integer.parseInt(tmp[1]));
                default -> null;
            };
            if (operation != null) {
                requests.add(operation);
            }
        }

        return requests;
    }
}

//7
//get 9
//delete 9
//put 9 1
//get 9
//put 9 2
//get 9
//put 9 3
//get 9


//10
//get 1
//put 1 10
//put 2 4
//get 1
//get 2
//delete 2
//get 2
//put 1 5
//get 1
//delete 2
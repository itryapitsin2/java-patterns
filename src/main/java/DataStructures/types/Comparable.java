package DataStructures.types;

public interface Comparable<T> {
    boolean left(T element);

    boolean right(T element);

    boolean equals(Object element);
}

import java.util.NoSuchElementException;

public interface Deque<Item> {
    public void printDeque();

    public Item getRecursive(int i);

    public Item removeFirst();

    public Item removeLast();


}


package synthesizer;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    private int fillcount;
    private int capacity;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillcount = 0;
        this.capacity = capacity;
        this.rb = (T[])new Object[this.capacity];
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillcount;
    }


    public void enqueue(T x) {
        if (last == capacity) {
            last = 0;
        }
        fillcount++;
        rb[last] = x;
        last++;// TODO: Enqueue the item. Don't forget to increase fillCount and update last.
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {

        fillcount--;
        T temp = rb[first];
        first++;
        if (first == capacity) {
            first = 0;
        }
        return temp; // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];// TODO: Return the first item. None of your instance variables should change.
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}

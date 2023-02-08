
package synthesizer;

import java.util.Iterator;


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

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int Pos;
        private int curNum;
        public ArrayRingBufferIterator() {
            Pos = first;
            curNum = 0;
        }
        public boolean hasNext() {
            return curNum < fillcount; }
        public T next() {
            T returnItem = rb[Pos];
            Pos = (Pos + 1) % capacity;
            curNum += 1;
            return returnItem;
        }

    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

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
        if (fillcount > capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
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
        if (fillcount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
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
        if (fillcount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];// TODO: Return the first item. None of your instance variables should change.
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this == o) { return true; } // optimization
        if (this.getClass() != o.getClass()) { return false; }
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        if (this.fillCount() != other.fillCount()) { return false; }
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = other.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (thisIterator.next() != otherIterator.next()) {
                return false;
            }
        }
        return true;

}



    // TODO: When you get to part 5, implement the needed code to support iteration.
}

import org.junit.Test;

import static org.junit.Assert.*;

public class DLLQueueTest {

    @Test
    public void size() {
        DLLQueue test=new DLLQueue();
        assertEquals(0,test.size());
        test.enqueue(1);
        assertEquals(1,test.size());
        test.dequeue();
        assertEquals(0,test.size());
    }

    @Test
    public void isEmpty() {
        DLLQueue test=new DLLQueue();
        assertEquals(true,test.isEmpty());
        test.enqueue(1);
        assertEquals(false,test.isEmpty());
        test.peek();
        assertEquals(false,test.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void enqueueIAE(){
        DLLQueue test=new DLLQueue();
        test.enqueue(null);
    }

    @Test
    public void enqueue() {
        DLLQueue test=new DLLQueue();
        test.enqueue(1);
        assertEquals(1,test.peek());
        test.enqueue(2);
        assertEquals(2,test.peek());
        test.enqueue(3);
        assertEquals(3,test.peek());
    }

    @Test
    public void dequeue() {
        DLLQueue test=new DLLQueue();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(1,test.dequeue());
        assertEquals(2,test.dequeue());
        test.dequeue();
        assertEquals(null,test.dequeue());
    }

    @Test
    public void peek() {
        DLLQueue test=new DLLQueue();
        assertEquals(null, test.peek());
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(3,test.peek());
        test.dequeue();
        assertEquals(3, test.peek());

    }
}
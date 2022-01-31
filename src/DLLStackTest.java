import org.junit.Test;

import static org.junit.Assert.*;

public class DLLStackTest {

    @Test
    public void size() {
        DLLStack test=new DLLStack();
        assertEquals(0,test.size());
        test.push(1);
        test.push(2);
        assertEquals(2,test.size());
        test.pop();
        assertEquals(1,test.size());
    }

    @Test
    public void isEmpty() {
        DLLStack test=new DLLStack();
        assertEquals(true,test.isEmpty());
        test.push(1);
        assertEquals(false,test.isEmpty());
        test.peek();
        assertEquals(false,test.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void pushIAE(){
        DLLStack test=new DLLStack();
        test.push(null);
    }

    @Test
    public void push() {
        DLLStack test=new DLLStack();
        test.push(1);
        assertEquals(1,test.size());
        test.push(2);
        assertEquals(2,test.size());
        test.push(3);
        assertEquals(3,test.size());
    }

    @Test
    public void pop() {
        DLLStack test=new DLLStack();
        assertEquals(null, test.pop());
        test.push(1);
        test.push(2);
        test.push(3);
        test.pop();
        assertEquals(2, test.peek());
        test.pop();
        assertEquals(1, test.peek());
        test.pop();
        assertEquals(0, test.size());
    }

    @Test
    public void peek() {
        DLLStack test=new DLLStack();
        assertEquals(null,test.peek());
        test.push(1);
        test.push(2);
        test.push(3);
        assertEquals(3,test.peek());
        test.pop();
        assertEquals(2,test.peek());
    }
}
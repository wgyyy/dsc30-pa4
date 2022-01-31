/*
 * NAME: Gaoying Wang
 * PID: A16131629
 */

/**
 * TODO
 * @param <T> generic container
 * @author Gaoying Wang
 * @since ${2022-01-30}
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    public DLLStack() {
        this.stack=new DoublyLinkedList<T>();
    }

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void push(T data) {
        if (data==null){
            throw new IllegalArgumentException();
        }
        this.stack.add(data);
    }

    public T pop() {
        if (this.stack.size()==0){
            return null;
        }else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    public T peek() {
        if (this.stack.size()==0){
            return null;
        }else {
            return this.stack.get(this.stack.size() - 1);
        }
    }

}

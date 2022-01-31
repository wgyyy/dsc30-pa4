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
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    public DLLQueue() {
        this.queue=new DoublyLinkedList<T>();
    }

    public int size() {
        return this.queue.size();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void enqueue(T data) {
        if (data==null){
            throw new IllegalArgumentException();
        }
        this.queue.add(data);
    }

    public T dequeue() {
        if (this.queue.size()==0){
            return null;
        }else {
            return this.queue.remove(0);
        }
    }

    public T peek() {
        if (this.queue.size()==0){
            return null;
        }else {
            return this.queue.get(this.queue.size() - 1);
        }
    }

}

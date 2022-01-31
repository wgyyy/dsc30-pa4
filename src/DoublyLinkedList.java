/*
 * NAME: Gaoying Wang
 * PID: A16131629
 */

import java.util.AbstractList;

/**
 * This class constructs a doubly linked list that contains integers.
 * @author Gaoying Wang
 * @since ${2022-01-28}
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data=element;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
           this.data=element;
           this.next=nextNode;
           this.prev=prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data=element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next=n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev=p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            this.prev.next=this.next;
            this.next.prev=this.prev;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head=null;
        this.nelems=0;
        this.tail=null;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element==null){
            throw new NullPointerException();
        }
        Node new_node=new Node(element);
        if (head==null){
            head=tail=new_node;
            head.prev=null;
            tail.next=null;
            nelems++;
            return true;
        }else{
            tail.next=new_node;
            new_node.prev=tail;
            tail=new_node;
            tail.next=null;
            nelems++;
            return true;
        }
    }

    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * TODO: Javadoc comments
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index>this.size() ) {
        throw new IndexOutOfBoundsException();
        }else if (element==null){
            throw new NullPointerException();
        }
        Node new_node=new Node(element);
        if (head==null){
            head=tail=new_node;
            head.prev=null;
            tail.next=null;
            nelems++;
        }else if (index==this.size()-1){
            tail.next=new_node;
            new_node.prev=tail;
            tail=new_node;
            tail.next=null;
            nelems++;
        }else if(index==0){
            new_node.next=head;
            head.prev=new_node;
            head=new_node;
            head.prev=null;
            nelems++;
        }
        else{
            Node previous_node=this.getNth(index-1);
            new_node.next=previous_node.next;
            previous_node.next=new_node;
            new_node.prev=previous_node;
            if (new_node.next!=null) {
                new_node.next.prev = new_node;
        }
        nelems++;
        }

    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        head.setNext(tail);
        head.setPrev(tail);
        tail.setNext(head);
        tail.setPrev(head);
        head=null;
        tail=null;
        nelems=0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * This method tests whether the list contains certain element.
     */
    @Override
    public boolean contains(Object element) {
        for (int x=0;x<this.size();x++){
            if (this.get(x)==element){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * This method returns the number of the targeted node.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index>this.size() || this.size()==0){
            throw new IndexOutOfBoundsException();
        }
        return this.getNth(index).data;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * This method returns the targeted node.
     */
    private Node getNth(int index) {
        if (index>this.size()){
            throw new IndexOutOfBoundsException();
        }
        Node thisNode = null;
        if (index==this.size()-1){
            return tail;
        }else{
            for (int x=0;x<index+1;x++){
                if (x==0){
                    thisNode=head;
                }else{
                    thisNode=thisNode.next;
                }
            }
        }
        return thisNode;
    }

    /**
     * Determine if the list empty
     *
     * This method checks whether the list is empty.
     */
    @Override
    public boolean isEmpty() {
        if (this.size()==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Remove the element from position index in the list
     *
     * This method remove the element at the index position.
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index>this.size()-1){
            throw new IndexOutOfBoundsException();
        }
        Node thisNode=this.getNth(index);
        Node prevNode=thisNode.getPrev();
        Node nextNode=thisNode.getNext();
        if (nextNode!=null){
            nextNode.prev=prevNode;
        }
        if (prevNode!=null){
            prevNode.next=nextNode;
        }
        if (thisNode==head){
            head=nextNode;
        }
        if (thisNode==tail){
            tail=prevNode;
        }
        this.nelems--;
        return thisNode.data;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * This method changes the number that the node at the
     * index position points to.
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index>this.size()-1){
            throw new IndexOutOfBoundsException();
        }
        if (element==null){
            throw new NullPointerException();
        }
        Node thisNode=this.getNth(index);
        T previousData=thisNode.data;
        thisNode.setElement(element);
        return previousData;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * This method returns the size of the list.
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * This method uses the string to show all the number it includes.
     */
    @Override
    public String toString() {
        String result="[(head) -> ";
        Node thisNode = head;
        for (int x=0;x<this.size();x++){
            if (x==0){
                result=result+thisNode.data+" -> ";
            }else {
                thisNode = thisNode.next;
                result = result + thisNode.data + " -> ";
            }
        }
        result=result+"(tail)]";
        return result;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @org.junit.Test
    public void add() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        String actual= newlist.toString();
        String expected="[(head) -> 1 -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(2);
        actual= newlist.toString();
        expected="[(head) -> 1 -> 2 -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(3);
        actual= newlist.toString();
        expected="[(head) -> 1 -> 2 -> 3 -> (tail)]";
        assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void addNPE() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(null);
    }

    @org.junit.Test
    public void testAdd() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(0,1);
        String actual= newlist.toString();
        String expected="[(head) -> 1 -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(1,2);
        actual= newlist.toString();
        expected="[(head) -> 1 -> 2 -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(0,3);
        actual=newlist.toString();
        expected="[(head) -> 3 -> 1 -> 2 -> (tail)]";
        assertEquals(expected,actual);
    }

    @Test (expected = NullPointerException.class)
    public void AddNPE(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(0,null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void ADDIOB(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(0,1);
        newlist.add(3,2);
    }

    @org.junit.Test
    public void clear() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.clear();
        String actual= newlist.toString();
        String expected="[(head) -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(1);
        newlist.add(2);
        newlist.clear();
        actual= newlist.toString();
        expected="[(head) -> (tail)]";
        assertEquals(expected,actual);
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        newlist.clear();
        actual= newlist.toString();
        expected="[(head) -> (tail)]";
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void contains() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        boolean expected=true;
        boolean actual=newlist.contains(1);
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void get() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        assertEquals(new Integer(1),newlist.get(0));
        assertEquals(new Integer(2),newlist.get(1));
        assertEquals(new Integer(3),newlist.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIOB(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.get(1);
    }


    @org.junit.Test
    public void isEmpty() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        boolean expected=false;
        boolean actual=newlist.isEmpty();
        assertEquals(expected,actual);
        newlist.clear();
        expected=true;
        actual=newlist.isEmpty();
        assertEquals(expected,actual);
        expected=true;
        actual=newlist.isEmpty();
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void remove() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        assertEquals(new Integer(1),newlist.remove(0));
        assertEquals(new Integer(3),newlist.remove(1));
        assertEquals(new Integer(2), newlist.remove(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIOB(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        newlist.remove(3);
    }

    @org.junit.Test
    public void set() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        newlist.set(1,4);
        assertEquals(new Integer(4),newlist.get(1));
        newlist.set(0,5);
        assertEquals(new Integer(5),newlist.get(0));
        newlist.set(2,9);
        assertEquals(new Integer(9),newlist.get(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void setIOB(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        newlist.set(3,9);
    }

    @Test (expected = NullPointerException.class)
    public void setNPE(){
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        newlist.set(1,null);
    }

    @org.junit.Test
    public void size() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        int expected=3;
        int actual=newlist.size();
        assertEquals(expected,actual);
        newlist.clear();
        expected=0;
        actual=newlist.size();
        assertEquals(expected,actual);
        newlist.add(1);
        newlist.add(2);
        expected=2;
        actual=newlist.size();
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void testToString() {
        DoublyLinkedList newlist=new DoublyLinkedList();
        String expected="[(head) -> (tail)]";
        String actual=newlist.toString();
        assertEquals(expected,actual);
        newlist.add(1);
        newlist.add(2);
        newlist.add(3);
        expected="[(head) -> 1 -> 2 -> 3 -> (tail)]";
        actual=newlist.toString();
        assertEquals(expected,actual);
        newlist.set(1,9);
        expected="[(head) -> 1 -> 9 -> 3 -> (tail)]";
        actual=newlist.toString();
        assertEquals(expected,actual);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void removeMultipleOfIAE(){
        DoublyLinkedList newlist1=new DoublyLinkedList();
        for (int x=1;x<20;x++){
            newlist1.add(x);
        }
        newlist1.removeMultipleOf(0);
    }

    @org.junit.Test
    public void removeMultipleOf(){
        DoublyLinkedList newlist1=new DoublyLinkedList();
        for (int x=1;x<20;x++){
            newlist1.add(x);
        }
        newlist1.removeMultipleOf(5);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> " +
                "4 -> 6 -> 7 -> 8 -> 9 -> 11 -> 12 -> 13 -> 14 -> " +
                "16 -> 17 -> 18 -> 19 -> (tail)]", newlist1.toString());
        DoublyLinkedList newlist2=new DoublyLinkedList();
        for (int x=1;x<20;x++){
            newlist2.add(x);
        }
        newlist2.removeMultipleOf(2);
        assertEquals("[(head) -> 1 -> 3 -> " +
                "5 -> 7 -> 9 -> 11 -> 13 -> 15 -> " +
                "17 -> 19 -> (tail)]", newlist2.toString());
        DoublyLinkedList newlist3=new DoublyLinkedList();
        for (int x=1;x<20;x++){
            newlist3.add(x);
        }
        newlist3.removeMultipleOf(1);
        assertEquals("[(head) -> (tail)]", newlist3.toString());
    }

    @org.junit.Test
    public void swapSegment(){
        DoublyLinkedList newlist1=new DoublyLinkedList();
        for (int x=1;x<20;x++){
            newlist1.add(x);
        }
        DoublyLinkedList newlist2=new DoublyLinkedList();
        for (int x=19;x>0;x--){
            newlist2.add(x);
        }
        newlist1.swapSegment(newlist2,5);
        assertEquals("[(head) -> 19 -> 18 -> 17 -> 16 -> 15 -> " +
                "14 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> " +
                "16 -> 17 -> 18 -> 19 -> (tail)]",newlist1.toString());
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 13 ->" +
                " 12 -> 11 -> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 " +
                "-> (tail)]",newlist2.toString());
        newlist1.swapSegment(newlist2,5);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 ->" +
                " 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19" +
                " -> (tail)]",newlist1.toString());
        assertEquals("[(head) -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 ->" +
                " 13 -> 12 -> 11 -> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2" +
                " -> 1 -> (tail)]",newlist2.toString());
        newlist1.removeMultipleOf(1);
        newlist2.removeMultipleOf(1);
        for (int x=1;x<20;x++){
            newlist1.add(x);
        }
        for (int x=19;x>0;x--){
            newlist2.add(x);
        }
        newlist1.swapSegment(newlist2,10);
        assertEquals("[(head) -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 ->" +
                " 12 -> 11 -> 10 -> 9 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 ->" +
                " 19 -> (tail)]",newlist1.toString());
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 ->" +
                " 9 -> 10 -> 11 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 ->" +
                " 1 -> (tail)]",newlist2.toString());
    }

}
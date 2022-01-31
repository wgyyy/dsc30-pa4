/*
 * NAME: Gaoying Wang
 * PID: A16131629
 */

import java.awt.*;

/**
 * This class is designed for scheduling the completion of several tasks.
 *
 * @author Gaoying Wang
 * @since ${2020-01-30}
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    public RoundRobin(Task[] toHandle) {
        this.waitlist=new DoublyLinkedList<Task>();
        this.finished=new DoublyLinkedList<Task>();
        for (int y=0;y<toHandle.length;y++){
            waitlist.add(toHandle[y]);
        }
        this.quantum=4;
        this.burstTime=0;
        this.waitTime=0;

    }

    public RoundRobin(int quantum, Task[] toHandle) {
        if (toHandle == null || quantum < 1 || toHandle.length<=0)
            throw new IllegalArgumentException();
        this.waitlist=new DoublyLinkedList<Task>();
        this.finished=new DoublyLinkedList<Task>();
        for (int y=0;y<toHandle.length;y++){
            waitlist.add(toHandle[y]);
        }
        this.quantum=quantum;
        this.burstTime=0;
        this.waitTime=0;
    }

    public String handleAllTasks() {
        if (waitlist.isEmpty()){
            return TASK_HANDLED;
        }else {
            Task replacement;
            String result="";
            while(waitlist.size()>0) {
                System.out.println(waitlist);
                for (int x = 0; x < this.quantum; x++) {
                    if (waitlist.get(0).handleTask() == false) {
                        break;
                    }else {
                        burstTime++;
                    }
                    waitTime=waitTime+(waitlist.size() - 1);
                }
                if (waitlist.get(0).isFinished()==true){
                    finished.add(waitlist.get(0));
                    waitlist.remove(0);
                }else {
                    replacement = waitlist.get(0);
                    waitlist.add(replacement);
                    waitlist.remove(0);
                }
            }
            for (int y = 0; y < finished.size(); y++) {
                result = result + finished.get(y).toString()+" -> ";
            }
            String record = "All tasks are handled within "+ burstTime+
                    " units of" +
                    " burst time and "+waitTime+" units of wait time." +
                    " The tasks are finished in this order:\n"+result;
            record=record.substring(0,record.length()-4);
            return record;
        }
    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}
/*
 * NAME: TODO
 * PID: TODO
 */

/**
 * RoundRobin class
 *
 * @author Ezhil Thaenraj
 * @since 02/4/2021
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";
    private static final int DEFAULT_QUANTUM =  4;

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    public RoundRobin(Task[] toHandle) {
        /*
        This constructor will call the constructor below with a default quantum of 4.
        */
        this(DEFAULT_QUANTUM, toHandle);
    }

    public RoundRobin(int quantum, Task[] toHandle) {
        /* This constructor initializes the instance variables.
        It assigns a doubly linked list to the waitlist variable
        populated with the tasks that are to be handled, then
        initializes the rest of the variables as necessary.
        Assume that toHandle will not have null tasks as an element.

        @throws IllegalArgumentException - if quantum is less than 1
        @throws IllegalArgumentException - if toHandle is null or if
        no tasks have been passed in */
        if (quantum < 1) {
            throw new IllegalArgumentException();
        } else if (toHandle == null || toHandle.length == 0) {
            throw new IllegalArgumentException();
        }

        waitlist = new DoublyLinkedList<Task>();
        finished = new DoublyLinkedList<Task>();

        burstTime = 0;
        waitTime = 0;
        this.quantum = quantum;


        for (Task i: toHandle) {
            waitlist.add(i);
        }
    }

    public String handleAllTasks() {
        /* This is the fundamental method of this class that does most of the job.
        It goes through the tasks in the waitlist, schedules them in order for
        one quantum period and then returns it to the queue or marks it completed
        as necessary. It keeps track of the burst and wait times. It loops through the
        waitlist until no more tasks need to be scheduled. It finally returns a String
        that can be one of two things:

        If the handleAllTasks method is called when there are no tasks in the waitlist.
        Then it should return the constant string TASK_HANDLED defined in this class.

        If there were tasks in the waitlist, once they are completed it returns the following
        (assuming burstTime was 36, waitTime was 148, Task C took 3 quanta, Task D took 1
        quantum, etc. in that order):

        “All tasks are handled within 36 units of burst time and 148 units of wait time.
        The tasks are finished in this order:\nTask(C, 3) -> Task(D, 1) -> Task(E, 2) ->
         Task(B, 5) -> Task(F, 4) -> Task(G, 6) -> Task(A, 7) -> Task(H, 8)”
         */
        if (waitlist.isEmpty()) {
            return TASK_HANDLED;
        }

        while (waitlist.size() > 0) {
            Task newTask = waitlist.get(0);
            for (int j = 0; j < quantum; j++) {
                newTask.handleTask();
                burstTime += 1;
                waitTime += waitlist.size()-1;

                if(newTask.isFinished()) {
                    finished.add(newTask);
                    waitlist.remove(0);
                    break;
                }
            }
            if(!newTask.isFinished()) {
                waitlist.remove(0);
                waitlist.add(newTask);
            }
        }

        String returnStr = "All tasks are handled within " + burstTime +
                " units of burst time and " + waitTime +
                " units of wait time. The tasks are finished in this order:\n"
                + finished.get(0).toString();

        for(int x = 1; x < finished.size(); x++) { //adds string representations in order
            returnStr += " -> " + finished.get(x).toString();
        }

        return returnStr;
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
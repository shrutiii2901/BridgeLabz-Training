class TaskNode {
    int id;
    String name;
    TaskNode next;

    TaskNode(int i, String n) {
        id = i; name = n;
    }
}

class TaskList {
    TaskNode head;

    void addTask(int id, String name) {
        TaskNode node = new TaskNode(id, name);
        if (head == null) {
            head = node;
            node.next = node;
        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = node;
            node.next = head;
        }
    }

    void displayTasks() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.addTask(1, "Study");
        list.addTask(2, "Workout");
        list.addTask(3, "Sleep");

        list.displayTasks();
    }
}

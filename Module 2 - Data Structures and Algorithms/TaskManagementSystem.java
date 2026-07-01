class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
    }

    public void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println(temp.taskName + " " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    public void deleteTask(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void traverseTasks() {
        Task temp = head;

        while (temp != null) {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.status);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem list = new TaskManagementSystem();

        list.addTask(1, "Coding", "Pending");
        list.addTask(2, "Testing", "Completed");

        list.traverseTasks();

        list.searchTask(1);

        list.deleteTask(2);

        System.out.println("\nAfter Deletion:");
        list.traverseTasks();
    }
}
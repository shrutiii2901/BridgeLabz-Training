import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority; 

    BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return other.priority - this.priority;
    }

    void execute() {
        System.out.println("Backing up folder: " + folderPath + " | Priority: " + priority);
    }
}


class BackupScheduler {
    PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    void addTask(BackupTask task) {
        queue.add(task);
    }

    void executeTasks() {
        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            task.execute();
        }
    }
}


public class BackupMain {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addTask(new BackupTask("C:/Documents", 2));
            scheduler.addTask(new BackupTask("C:/System", 5));
            scheduler.addTask(new BackupTask("D:/Photos", 3));
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeTasks();
    }
}

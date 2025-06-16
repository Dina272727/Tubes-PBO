import java.util.ArrayList;
import java.util.List;
import model.User;

public class Project {
    private String name;
    private String description;
    private List<User> members;
    private List<Task> tasks;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
        }
    }

    public void assignTask(Task task, User assignee) {
        if (members.contains(assignee)) {
            task.setAssignedTo(assignee);
            tasks.add(task);
        }
    }

    // Getter & Setter
    public String getName() { return name; }
    public List<User> getMembers() { return members; }
    public List<Task> getTasks() { return tasks; }
}

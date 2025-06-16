import model.User;

public class AssignmentService {
    public void assignTaskToUser(Project project, Task task, User user) {
        if (project.getMembers().contains(user)) {
            project.assignTask(task, user);
            System.out.println("Tugas berhasil diberikan ke: " + user.getUsername());
        } else {
            System.out.println("Gagal: Pengguna bukan anggota proyek.");
        }
    }
}


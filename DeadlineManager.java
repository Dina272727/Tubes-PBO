// Import library untuk tanggal & waktu
import java.time.LocalDateTime;

// Import untuk list dan manipulasi datanya
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Kelas ini bertugas mengelola daftar tugas (task)
public class DeadlineManager implements ITaskManager {
    // Menyimpan semua tugas dalam list
    private List<Task> taskList = new ArrayList<>();

    // Menambahkan tugas baru ke dalam list
    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    // Mengedit tugas berdasarkan ID (mengganti dengan tugas yang baru)
    @Override
    public void editTask(String taskId, Task updatedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            // Jika ID cocok, ganti data tugasnya
            if (taskList.get(i).getTaskId().equals(taskId)) {
                taskList.set(i, updatedTask);
                return; // setelah diganti, keluar dari loop
            }
        }
    }

    // Menghapus tugas dari list berdasarkan ID
    @Override
    public void deleteTask(String taskId) {
        // Hapus semua tugas yang ID-nya sama dengan taskId
        taskList.removeIf(task -> task.getTaskId().equals(taskId));
    }

    // Mengembalikan semua tugas yang ada
    @Override
    public List<Task> getAllTasks() {
        // Kembalikan salinan dari list (biar list aslinya aman)
        return new ArrayList<>(taskList);
    }

    // Mengambil tugas yang tenggat waktunya belum lewat (masih akan datang)
    @Override
    public List<Task> getUpcomingTasks() {
        LocalDateTime now = LocalDateTime.now(); // ambil waktu saat ini
        // Ambil semua tugas yang deadlinenya setelah waktu sekarang
        return taskList.stream()
                .filter(task -> task.getDeadline().isAfter(now))
                .collect(Collectors.toList());
    }
}

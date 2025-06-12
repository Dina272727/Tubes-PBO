import java.util.List;

// Interface ini mendefinisikan aturan/fungsi dasar untuk mengelola tugas (task)
public interface ITaskManager {
    
    // Menambahkan tugas baru
    void addTask(Task task);
    
    // Mengubah isi tugas berdasarkan ID-nya
    void editTask(String taskId, Task updatedTask);
    
    // Menghapus tugas berdasarkan ID-nya
    void deleteTask(String taskId);
    
    // Mengambil semua tugas yang ada
    List<Task> getAllTasks();
    
    // Mengambil tugas-tugas yang tenggat waktunya masih akan datang
    List<Task> getUpcomingTasks();
}

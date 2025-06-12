import java.time.LocalDateTime;

// Kelas Task digunakan untuk menyimpan data tugas
public class Task {
    // Data (atribut) dari tugas
    private String taskId;               // ID tugas
    private String title;                // Judul tugas
    private String description;          // Penjelasan tugas
    private LocalDateTime deadline;      // Batas waktu tugas
    private String status;               // Status tugas (misalnya: "belum", "selesai")

    // Constructor: dipakai saat membuat tugas baru
    public Task(String taskId, String title, String description, LocalDateTime deadline, String status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    // melihat isi data (getter)
    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    // mengubah isi data (setter)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // menandai tugas ini sudah selesai
    public void markAsCompleted() {
        this.status = "selesai";
    }
}

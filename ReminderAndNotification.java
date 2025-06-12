import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

// Kelas Reminder menyimpan informasi event dan deadline-nya
class Reminder {
    private String event;
    private LocalDateTime deadline;

    // Konstruktor
    public Reminder(String event, LocalDateTime deadline) {
        this.event = event;
        this.deadline = deadline;
    }
    // Mengambil nama event
    public String getEvent() {
        return event;
    }
    // Mengambil waktu deadline
    public LocalDateTime getDeadline() {
        return deadline;
    }
    // Mengembalikan deadline dalam format string yang lebih user-friendly
    public String getFormattedDeadline() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return deadline.format(formatter);
    }
    // Menghitung sisa waktu menuju deadline dalam satuan menit
    public long getMinutesUntilDeadline() {
        return Duration.between(LocalDateTime.now(), deadline).toMinutes();
    }
}
// Interface untuk notifikasi
interface Notifier {
    void notify(Reminder reminder);
}
// Implementasi notifikasi dengan popup (terminal output)
class PopupNotifier implements Notifier {
    @Override
    public void notify(Reminder reminder) {
        System.out.println("🔔 [Popup] Reminder: " + reminder.getEvent() + " is due at " + reminder.getFormattedDeadline());
    }
}
// Implementasi notifikasi lewat email (simulasi via terminal)
class EmailNotifier implements Notifier {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void notify(Reminder reminder) {
        System.out.println("📧 [Email to " + email + "] Reminder: '" + reminder.getEvent() + "' is due at " + reminder.getFormattedDeadline());
    }
}

// Kelas utama untuk menjalankan program
public class ReminderAndNotification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reminder> reminders = new ArrayList<>();

        // Meminta alamat email pengguna
        System.out.print("Masukkan alamat email Anda: ");
        String emailUser = scanner.nextLine();

        // Meminta jumlah reminder
        System.out.print("Berapa jumlah reminder yang ingin Anda buat? ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        // Memasukkan data reminder dari pengguna
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nReminder ke-" + (i + 1));
            System.out.print("Nama Event       : ");
            String namaEvent = scanner.nextLine();

            System.out.print("Deadline (format: yyyy-MM-dd HH:mm) : ");
            String deadlineStr = scanner.nextLine();

            // Parsing string deadline ke LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime deadline = LocalDateTime.parse(deadlineStr, formatter);

            // Menambahkan reminder ke list
            reminders.add(new Reminder(namaEvent, deadline));
        }
        // Membuat objek notifikasi popup dan email
        Notifier popup = new PopupNotifier();
        Notifier email = new EmailNotifier(emailUser);

        // Menampilkan reminder yang akan jatuh tempo dalam 60 menit ke depan
        System.out.println("\n📋 Notifikasi dalam 60 menit ke depan:");
        for (Reminder r : reminders) {
            if (r.getMinutesUntilDeadline() <= 60 && r.getMinutesUntilDeadline() >= 0) {
                popup.notify(r);
                email.notify(r);
            }
        }

        System.out.println("\n✅ Selesai. Terima kasih!");
    }
}

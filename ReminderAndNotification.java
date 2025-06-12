import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

class Reminder {
    private String event;
    private LocalDateTime deadline;

    public Reminder(String event, LocalDateTime deadline) {
        this.event = event;
        this.deadline = deadline;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getFormattedDeadline() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return deadline.format(formatter);
    }

    public long getMinutesUntilDeadline() {
        return Duration.between(LocalDateTime.now(), deadline).toMinutes();
    }
}

interface Notifier {
    void notify(Reminder reminder);
}

class PopupNotifier implements Notifier {
    @Override
    public void notify(Reminder reminder) {
        System.out.println("🔔 [Popup] Reminder: " + reminder.getEvent() + " is due at " + reminder.getFormattedDeadline());
    }
}

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

public class ReminderAndNotification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reminder> reminders = new ArrayList<>();

        System.out.print("Masukkan alamat email Anda: ");
        String emailUser = scanner.nextLine();

        System.out.print("Berapa jumlah reminder yang ingin Anda buat? ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nReminder ke-" + (i + 1));
            System.out.print("Nama Event       : ");
            String namaEvent = scanner.nextLine();

            System.out.print("Deadline (format: yyyy-MM-dd HH:mm) : ");
            String deadlineStr = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime deadline = LocalDateTime.parse(deadlineStr, formatter);

            reminders.add(new Reminder(namaEvent, deadline));
        }

        Notifier popup = new PopupNotifier();
        Notifier email = new EmailNotifier(emailUser);

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

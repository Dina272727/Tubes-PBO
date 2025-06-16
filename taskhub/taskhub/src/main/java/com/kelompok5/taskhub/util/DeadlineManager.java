package com.kelompok5.taskhub.util;

import com.kelompok5.taskhub.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;

public class DeadlineManager implements ITaskManager {

    @Override
    public void assignDeadline(Task task) {
        // Menetapkan deadline 3 hari dari sekarang jika belum ada
        if (task.getDeadline() == null) {
            LocalDateTime deadline = LocalDateTime.now().plusDays(3);
            task.setDeadline(deadline);
            System.out.println("Deadline ditetapkan: " + deadline);
        } else {
            System.out.println("Deadline sudah ada: " + task.getDeadline());
        }
    }

    @Override
    public void notifyDeadline(Task task) {
        LocalDateTime deadline = task.getDeadline();
        if (deadline == null) {
            System.out.println("Task belum memiliki deadline.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        Duration remaining = Duration.between(now, deadline);

        System.out.println("Task ID: " + task.getId());
        System.out.println("Sisa waktu: " + remaining.toHours() + " jam");

        if (remaining.toHours() <= 24) {
            System.out.println("⚠️ Deadline kurang dari 24 jam! Kirim notifikasi ke: "
                    + task.getAssignedTo().getUsername());
        }
    }
}

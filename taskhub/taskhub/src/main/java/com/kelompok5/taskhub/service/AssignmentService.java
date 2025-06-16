package com.kelompok5.taskhub.service;

import com.kelompok5.taskhub.model.Project;
import com.kelompok5.taskhub.model.Task;
import com.kelompok5.taskhub.model.Users;


public class AssignmentService {
    public void assignTaskToUser(Project project, Task task, Users user) {
        if (project.getMembers().contains(user)) {
            project.assignTask(task, user);
            System.out.println("Tugas berhasil diberikan ke: " + user.getUsername());
        } else {
            System.out.println("Gagal: Pengguna bukan anggota proyek.");
        }
    }
}



package com.kelompok5.taskhub.util;

import com.kelompok5.taskhub.model.Task;

public interface ITaskManager {
    void assignDeadline(Task task);
    void notifyDeadline(Task task);
}

package com.kelompok5.taskhub.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Project> projects;

    public Group(String groupName) {
        this.groupName = groupName;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }
}


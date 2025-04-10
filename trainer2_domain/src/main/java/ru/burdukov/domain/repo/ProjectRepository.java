package ru.burdukov.domain.repo;

import ru.burdukov.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> findAll();
    Optional<Project> findById(Long id);
    void add(Project project);
    void update(Project project);
    void remove(Long id);
}

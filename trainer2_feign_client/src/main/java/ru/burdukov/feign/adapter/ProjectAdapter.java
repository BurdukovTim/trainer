package ru.burdukov.feign.adapter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.burdukov.domain.model.Project;
import ru.burdukov.domain.repo.ProjectRepository;
import ru.burdukov.feign.client.ProjectFeignClient;
import ru.burdukov.web.api.dto.ProjectDto;
import ru.burdukov.web.api.mapper.QuestionDtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@Primary
public class ProjectAdapter implements ProjectRepository {
    private final ProjectFeignClient feignClient;
    private final QuestionDtoMapper mapper;

    public ProjectAdapter(ProjectFeignClient feignClient, QuestionDtoMapper mapper) {
        this.feignClient = feignClient;
        this.mapper = mapper;
    }

    @Override
    public List<Project> findAll() {
        List<ProjectDto> projects = feignClient.list();
        return projects.stream()
                .map(mapper::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findById(Long id) {
        List<ProjectDto> projects = feignClient.list();
        return projects.stream()
                .map(mapper::mapToModel)
                .filter(project -> project.getId().equals(id))
                .findAny();
    }

    @Override
    public void add(Project project) {
        feignClient.add(mapper.mapToDto(project));
    }

    @Override
    public void update(Project project) {
        feignClient.update(mapper.mapToDto(project));
    }
    @Override
    public void remove(Long id) {
        feignClient.remove(id);
    }

}

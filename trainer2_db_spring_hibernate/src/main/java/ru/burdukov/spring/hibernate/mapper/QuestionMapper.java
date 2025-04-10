package ru.burdukov.spring.hibernate.mapper;

import org.mapstruct.Mapper;
import ru.burdukov.domain.model.OpenQuestionCard;
import ru.burdukov.domain.model.Project;
import ru.burdukov.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.burdukov.spring.hibernate.entity.ProjectEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    OpenQuestionCard mapToModel(OpenQuestionCardEntity entity);
    OpenQuestionCardEntity mapToEntity(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardEntity> entities);
    List<OpenQuestionCardEntity> mapToEntity(List<OpenQuestionCard> questions);
    Project mapToModel(ProjectEntity entity);
    ProjectEntity mapToEntity(Project question);
    List<Project> mapProjectToModel(List<ProjectEntity> entities);
    List<ProjectEntity> mapProjectToEntity(List<Project> questions);
}
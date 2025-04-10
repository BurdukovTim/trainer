package ru.burdukov.spring.hibernate.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.burdukov.spring.hibernate.entity.OpenQuestionCardEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionCrudRepository extends CrudRepository<OpenQuestionCardEntity, Long> {
    List<OpenQuestionCardEntity> findAll();
    Optional<OpenQuestionCardEntity> findById(Long id);
}
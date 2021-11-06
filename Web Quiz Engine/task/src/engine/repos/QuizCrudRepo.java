package engine.repos;

import engine.model.Quiz;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuizCrudRepo extends PagingAndSortingRepository<Quiz, Long> {

}

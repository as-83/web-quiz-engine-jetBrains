package engine.repos;

import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class QuizRepo {

    List<Quiz> quizzes = new ArrayList<>();

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Set<Integer> getCorrectAnswers(long id) {
        return quizzes.get((int)id).getAnswer();
    }

    public Quiz addQuiz(Quiz newQuiz) {
        newQuiz.setId(quizzes.size() + 1);
        quizzes.add(newQuiz);
        return quizzes.get(quizzes.size() - 1);
    }

    public Quiz getQuizById(long id) {
        if (id <= quizzes.size()) {
            return quizzes.get((int)id - 1);
        } else {
            return null;
        }



    }
}

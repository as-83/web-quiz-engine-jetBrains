package engine.services;

import engine.model.Quiz;
import engine.model.SolvedQuiz;
import engine.model.User;
import engine.repos.QuizCrudRepo;
import engine.repos.UserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Service
public class QuizService {
    private QuizCrudRepo quizRepo;

    private UserDBRepo userRepo;

    @Autowired
    public QuizService(QuizCrudRepo quizRepo, UserDBRepo userRepo) {
        this.quizRepo = quizRepo;
        this.userRepo = userRepo;
    }

    public Page<Quiz> getAllQuizzes( Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return quizRepo.findAll(paging);

    }

    public String checkAnswer(Set<Integer> answers, long id) {
        Optional<Quiz> optionalQuiz = quizRepo.findById(id);
        User user = getCurrentUser();
        //if quiz presents in repo
        if (optionalQuiz.isPresent()){
            if (optionalQuiz.get().getAnswer().equals(answers)) {
                //Add quiz to list of solved quizzes
                SolvedQuiz solvedQuiz = new SolvedQuiz();
                solvedQuiz.setId(optionalQuiz.get().getId());
                solvedQuiz.setCompletedAt(LocalDateTime.now());
                user.getSolvedQuizzes().add(solvedQuiz);
                userRepo.save(user);
                return "{\"success\":true,\"feedback\":\"Congratulations, you're right!\"}";
            } else {
                return "{\"success\":false,\"feedback\":\"Wrong answer! Please, try again.\"}";
            }
        } else {
            return  null;
        }

    }

    public Quiz addQuiz(Quiz newQuiz) {
        User user = getCurrentUser();
        newQuiz.setAuthor(user);
        return quizRepo.save(newQuiz);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepo.findByEmail(email).get();
    }

    public Optional<Quiz> getQuizById(long id) {
        return quizRepo.findById(id);
    }

    public int delete(long id) {
        int status = 204;
        Optional<Quiz> quizOptional = quizRepo.findById(id);

        if (!quizOptional.isPresent()) {
            System.out.println("Not found");
            status = 404;
        } else {
            User user = getCurrentUser();
            if (quizOptional.get().getAuthor() == user) {
                quizRepo.delete(quizOptional.get());
            } else {
                status = 403;
            }
        }
        return status;
    }

    public Page<SolvedQuiz> getSolvedQuizzes(Integer page, Integer pageSize) {
        List<SolvedQuiz> solvedQuizzes =  userRepo.findByEmail(getCurrentUser()
                .getEmail()).get().getSolvedQuizzes();
        solvedQuizzes.sort((s1, s2) ->
            s2.getCompletedAt().isAfter(s1.getCompletedAt()) ? 1 : -1
         );
        Pageable paging = PageRequest.of(page, pageSize);
        int start = page * pageSize;
        int end = start + pageSize;
        if (end > solvedQuizzes.size()) {
            end = solvedQuizzes.size();
        }
        Page<SolvedQuiz> quizPage = new PageImpl<>(solvedQuizzes.subList(start, end),
                paging,
                solvedQuizzes.size());
        return quizPage;
    }
}

package engine.controllers;

import engine.model.Quiz;
import engine.model.SolvedQuiz;
import engine.model.UsersAnswer;
import engine.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class QuizController {
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/api/quizzes")
    public ResponseEntity<Page<Quiz>> getAllQuizzes(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
            //@RequestParam(defaultValue = "id") String sortBy
    ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(quizService.getAllQuizzes(page, pageSize));
    }

    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        Optional<Quiz> optionalQuiz = quizService.getQuizById(id);
        if (optionalQuiz.isPresent()){
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(optionalQuiz.get());
        }
        return ResponseEntity.status(404)
                .headers(responseHeaders)
                .body(null);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ResponseEntity<String> checkAnswer(@PathVariable("id") long id, @RequestBody UsersAnswer answer) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        String responseAnswer = quizService.checkAnswer(answer.getAnswer(), id);
        if (responseAnswer != null) {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(responseAnswer);
        }
        return ResponseEntity.status(404)
                .headers(responseHeaders)
                .body(null);
    }

    @PostMapping("api/quizzes")
    public ResponseEntity<Quiz> addQuiz(@RequestBody @Valid Quiz newQuiz) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(quizService.addQuiz(newQuiz));
    }

    @DeleteMapping("/api/quizzes/{id}")
    public ResponseEntity<Quiz> delete(@PathVariable("id") long id ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        int status = quizService.delete(id);


        return ResponseEntity.status(status)
                .headers(responseHeaders)
                .body(null);
    }

    @GetMapping("/api/quizzes/completed")
    public ResponseEntity<Page<SolvedQuiz>> getSolvedQuizzes(
           @RequestParam(defaultValue = "0") Integer page
//            @RequestParam(defaultValue = "10") Integer pageSize,
//            @RequestParam(defaultValue = "completedAt") String sortBy
    ) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(quizService.getSolvedQuizzes(page, 10));

    }
}

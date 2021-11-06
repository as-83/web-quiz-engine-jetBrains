package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Title must not be blank")
    @Column(name = "quiz_title")
    private String title;

    @NotBlank(message = "Question must not be blank")
    @Column(name = "quiz_text")
    private String text;

    @ElementCollection
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name="quiz_id"))
    @Column(name = "option")
    @NotNull
    @Size(min = 2)
    private List<String> options;

    @ElementCollection
    @CollectionTable(name = "answer", joinColumns = @JoinColumn(name="quiz_id"))
    @Column(name = "answer")
    private Set<Integer> answer;

     @ManyToOne()
    @JoinColumn (name="author")
    private User author;

    public Quiz() {
    }

    public long getId() {
        return id;
    }

    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @JsonIgnore
    @JsonProperty
    public Set<Integer> getAnswer() {
        if (answer != null) {
            return answer;
        } else {
            return  Collections.emptySet();
        }

    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

    @JsonIgnore
    @JsonProperty
    public User getAuthor() {
        return author;
    }

    @JsonIgnore
    public void setAuthor(User author) {
        this.author = author;
    }
}

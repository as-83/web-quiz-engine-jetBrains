package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Email()
    @Pattern(regexp= ".+@.+\\..+")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Size(min = 5)
    private String password;

    @Column(name = "role")
    private String role = "ROLE_USER"; // should be prefixed with ROLE_

    @Column(name = "quizzes")
    @OneToMany (mappedBy="author", fetch=FetchType.EAGER)
    private Collection<Quiz> quizzes;

    @ElementCollection
    @CollectionTable(name = "solvedQuizzes", joinColumns = @JoinColumn(name="quiz_id"))
    @Column(name = "solvedQuizzes")
    private List<SolvedQuiz> solvedQuizzes;




    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @JsonProperty
    public String getRole() {
        return role;
    }

    @JsonProperty
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @JsonProperty
    public Collection<Quiz> getQuizzes() {
        return quizzes;
    }

    @JsonIgnore
    public void setQuizzes(Collection<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<SolvedQuiz> getSolvedQuizzes() {
        return solvedQuizzes;
    }

    public void setSolvedQuizzes(List<SolvedQuiz> solvedQuizzes) {
        this.solvedQuizzes = solvedQuizzes;
    }
}

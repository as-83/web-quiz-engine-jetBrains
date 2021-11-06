package engine.model;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class SolvedQuiz {
    private long id;

    LocalDateTime completedAt;

    public SolvedQuiz() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}

package engine.model;

import java.util.Set;


public class UsersAnswer {
    private Set<Integer> answer;

    public UsersAnswer() {
    }

    public UsersAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

    public Set<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }
}

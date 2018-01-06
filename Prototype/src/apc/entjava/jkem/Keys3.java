package apc.entjava.jkem;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Keys3 {
    private String question1;
    private String question2;
    private String question3;
    private Integer score=0;


    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String submit() {
        switch (question1) {
            case "B":  this.score = score + 1;
                break;}
        switch (question2) {
            case "B":  this.score = score + 1;
                break;}
        switch (question3) {
            case "C":  this.score = score + 1;
                break;}

        return "quizResults";
    }

}

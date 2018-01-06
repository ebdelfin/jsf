package apc.entjava.jkem;

import apc.entjava.jkem.dataobjects.CourseDao;
import apc.entjava.jkem.services.CourseService;

import javax.faces.bean.ManagedBean;



@ManagedBean
public class keys {
    private String question1;
    private String question2;
    private String question3;
    private Integer score=0;
    private String username;

    int courseId = 1;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

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


    private CourseService courseService = new CourseDao();


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


        if(courseService.apply(username, courseId)){
            System.out.println("Success");
        }




        return "quizResults";
    }

}

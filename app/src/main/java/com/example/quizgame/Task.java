package com.example.quizgame;
public class Task {
    private String point;
    private String subject;
    private String level;

    public Task(){}
    public Task(String point, String subject, String level) {
        this.point = point;
        this.subject = subject;
        this.level = level;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}


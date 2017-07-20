package com;

import java.util.ArrayList;

/**
 * Created by zuoxiao
 * on 2017/6/23.
 */
public class Zhihu {
    private String question;
    private String url;
    private ArrayList<String> answerList;

    public Zhihu() {
        this.answerList = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Zhihu{" +
                "question='" + question + '\'' +
                ", url='" + url + '\'' +
                ", answerList=" + answerList.toString() +
                '}';
    }
}

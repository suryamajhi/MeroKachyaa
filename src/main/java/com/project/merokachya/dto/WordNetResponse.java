package com.project.merokachya.dto;

public class WordNetResponse {
    int index;
    String answer;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "WordNetResponse{" +
                "index=" + index +
                ", answer='" + answer + '\'' +
                '}';
    }
}

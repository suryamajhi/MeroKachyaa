package com.project.merokachya.dto;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordNetQuestion {
    private Integer index;
    private List<String> options;

    public WordNetQuestion(int index, String[] args){
        this.index = index;
        options = new ArrayList<>();
        options.addAll(Arrays.asList(args));
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}

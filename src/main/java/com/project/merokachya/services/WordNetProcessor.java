package com.project.merokachya.services;

import com.project.merokachya.wordnet.Outcast;
import com.project.merokachya.wordnet.WordNet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordNetProcessor {
    WordNet wordNet;
    Outcast outcast;
    public Map<Integer, String> answers;

    public WordNetProcessor(){
        wordNet = new WordNet("src/main/java/com/project/merokachya/wordnet/synsets.txt","src/main/java/com/project/merokachya/wordnet/hypernyms.txt");
        outcast = new Outcast(wordNet);
        answers = new HashMap<>();
    }

    public void findOutCast(int index, String[] array) {
        String out = outcast.outcast(array);
        answers.put(index, out);
    }
}

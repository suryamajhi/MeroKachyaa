package com.project.merokachya.controllers.user;

import com.project.merokachya.dto.WordNetQuestion;
import com.project.merokachya.dto.WordNetResponse;
import com.project.merokachya.services.WordNetProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Controller(value = "aptitudeController")
public class AptitudeController {

    @Autowired
    WordNetProcessor processor;

    @GetMapping("/aptitude")
    public String displayQuestions(ModelMap modelMap) throws FileNotFoundException {
        List<WordNetQuestion> lists = new ArrayList<>();
        File file = new File("src/main/java/com/project/merokachya/wordnet/outcast1.txt");
        Scanner sc = new Scanner(file);
        int i = 1;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] array = line.split(",");
            WordNetQuestion wordNetQuestion = new WordNetQuestion(i, array);
            processor.findOutCast(i++, array);
            lists.add(wordNetQuestion);
        }

        modelMap.addAttribute("lists", lists);

        return "home.aptitude";
    }

    @PostMapping("/aptitude")
    public String submitAnswers(@RequestBody String body, ModelMap modelMap){
        System.out.println(body);
        String[] array = body.split("=|&");
        int score = 0;

        for(int i = 0; i < array.length; i++){
            WordNetResponse wordNetResponse = new WordNetResponse();
            wordNetResponse.setIndex(Integer.parseInt(array[i++]));
            wordNetResponse.setAnswer(array[i]);
            if(processor.answers.get(wordNetResponse.getIndex()).equalsIgnoreCase(wordNetResponse.getAnswer())){
                score++;
            }
        }


        modelMap.addAttribute("score", score);
        modelMap.addAttribute("response", true);
        modelMap.addAttribute("answers", processor.answers);
        return "home.aptitude";
    }

}

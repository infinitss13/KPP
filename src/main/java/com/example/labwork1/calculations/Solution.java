package com.example.labwork1.calculations;

import com.example.labwork1.SpringConfig;
import com.example.labwork1.cache.Cache;
import com.example.labwork1.logger.ProgramLogger;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Solution {

    private Cache cache;
    private Integer root;


    Solution(){
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
    };


    public int calculateRoot(Parametres parameters) {

        var temp = cache.find(parameters);
        if (temp != null) {
            ProgramLogger.log(Level.WARN, "Value is found in cache!");
            setRoot(temp);

            return temp;
        }
        System.out.println(parameters.firstValue());
        if ((parameters.firstValue() >= parameters.secondValue()) && (parameters.firstValue()>= parameters.thirdValue()))
            temp = parameters.firstValue();
        else if ((parameters.secondValue() >= parameters.firstValue()) && (parameters.secondValue()>= parameters.thirdValue()))
            temp = parameters.secondValue();
        else
            temp = parameters.thirdValue();
        setRoot(temp);
        cache.add(parameters, root);
        return temp;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public int calculateSumOfResult(Integer number) {
        int sum = 0;
        sum = number;
        return sum;

    }

//    public int findMinOfResult(List<Integer> resultList) {
//        int min = 0;
//        if (!resultList.isEmpty()) {
//            min = resultList.stream().mapToInt(Integer::intValue).min().getAsInt();
//        }
//        return min;
//    }
//
//    public int findMaxOfResult(List<Integer> resultList) {
//        int max = 0;
//        if (!resultList.isEmpty()) {
//            max = resultList.stream().mapToInt(Integer::intValue).max().getAsInt();
//        }
//        return max;
//    }

}

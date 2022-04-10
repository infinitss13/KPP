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

@Service

public class Solution {

    private Cache cache;
    private Integer root;


    Solution(){
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
    };


    public void calculateRoot(Parametres parameters) {

        var temp = cache.find(parameters);
        if (temp != null) {
            ProgramLogger.log(Level.WARN, "Value found in cache!");
            setRoot(temp);

            return;
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

    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

}

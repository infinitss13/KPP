package com.example.labwork1.cache;


import com.example.labwork1.calculations.Parametres;
import org.apache.logging.log4j.Level;

import org.jetbrains.annotations.Nullable;
import com.example.labwork1.logger.ProgramLogger;

import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component("Cache")
public class Cache {

    private final HashMap<Parametres, Integer> solutions = new HashMap<>();

    public void add( Parametres params, Integer root) {
        if (!solutions.containsKey(params)) {
            solutions.put(params, root);
            ProgramLogger.log(Level.INFO, "Value " + params + "@" + root + " added to the cache!");
        }
    }

    public @Nullable Integer find( Parametres params) {
        if (solutions.containsKey(params))
            return solutions.get(params);

        ProgramLogger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

}
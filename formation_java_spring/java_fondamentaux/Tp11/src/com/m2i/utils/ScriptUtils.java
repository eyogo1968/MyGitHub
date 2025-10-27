// com.m2i.utils.ScriptUtils.java
package com.m2i.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptUtils {
    public static double calculerPrimeViaScript(double base, double coefficient) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine moteur = manager.getEngineByName("JavaScript");
        try {
            String script = "base * coefficient + 100";
            moteur.put("base", base);
            moteur.put("coefficient", coefficient);
            Object result = moteur.eval(script);
            return Double.parseDouble(result.toString());
        } catch (ScriptException e) {
            System.out.println("Erreur d'exécution du script : " + e.getMessage());
            return 0;
        }
    }
}
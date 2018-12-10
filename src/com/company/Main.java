package com.company;
import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

    public static List<Boolean> StingToBool(String exp) throws java.lang.Exception
    {
        List<Boolean> vals = new ArrayList<>();
        try
        {
            boolean a = true;
            boolean b = true;
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            vals.add(Boolean.valueOf((Boolean)engine.eval(exp.toLowerCase()));
            a= false;
            vals.add(Boolean.valueOf((Boolean)engine.eval(exp.toLowerCase()));
            b = false;
            vals.add(Boolean.valueOf((Boolean)engine.eval(exp.toLowerCase()));
            a = true;
            vals.add(Boolean.valueOf((Boolean)engine.eval(exp.toLowerCase()));


        }
        catch (Exception x)
        {
            System.out.println("Error parsing string.");
        }
        return vals;
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();
        if (input != null || !input.equals(""))
        {

        }
    }
}

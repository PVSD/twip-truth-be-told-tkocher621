package com.company;
import java.util.*;
import java.io.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

    public static Boolean StringToBool(String exp)
    {
        Boolean result;
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            result = Boolean.valueOf((Boolean)engine.eval(exp.toLowerCase()));
        }
        catch (Exception x)
        {
            result = null;
        }
        return result;
    }

    public static void GenerateTruthTable(String exp)
    {
        try
        {
            String a = "true";
            String b = "true";

            FileWriter fileWriter = new FileWriter("outputs.txt", true);

            fileWriter.write("A" + "\t \t" + "B" + "\t \t" + exp.toUpperCase() + "\n");
            for (int i = 0; i < 4; i ++)
            {
                if (i == 0)
                {
                    a = "true";
                    b = "true";
                }
                else if (i == 1)
                {
                    a = "true";
                    b = "false";
                }
                else if (i == 2)
                {
                    a = "false";
                    b = "true";
                }
                else if (i == 3)
                {
                    a = "false";
                    b = "false";
                }
                Boolean result = StringToBool(exp.toLowerCase().replace("a", a).replace("b", b));
                if (result != null)
                    fileWriter.write(a + "\t" + b + "\t" + result + "\n");
                else
                    System.out.println("Error");
            }
            fileWriter.write("\n"); // Space out the tables by one line
            fileWriter.close();
        }
        catch (Exception x)
        {
            System.out.println("Error parsing string.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Input an expression using 'a' and 'b'. Type quit to exit the program.");
        Scanner scan = new Scanner(System.in);
        Boolean running = true;
        while (running)
        {
            String input = scan.nextLine().toLowerCase();
            if (!input.equals("quit"))
            {
                if (input != null || !input.equals("")) {
                    GenerateTruthTable(input);
                } else {
                    System.out.println("Invalid input");
                }
            }
            else
            {
                running = false;
            }
        }
    }
}

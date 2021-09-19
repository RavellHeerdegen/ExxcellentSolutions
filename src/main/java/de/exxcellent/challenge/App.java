package de.exxcellent.challenge;

import Classes.DataMaster;
import Classes.TaskExecuter;
import Interfaces.IReader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App
{
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args)
    {
        // Check length of arguments
        if(args.length == 4)
        {
            System.out.println("Arguments okay");

            // Process given  arguments
            DataMaster dataMaster = new DataMaster();
            dataMaster.processArgs(args[0], args[1], args[2]);

            if (dataMaster.getReaderTypeIsValid())
            {
                // Create Reader-Class
                IReader reader = (IReader) dataMaster.loadReaderClass();
                if (reader != null)
                {
                    // Read file and save it correctly
                    HashMap<String, ArrayList<String>> data = reader.readFile(args[0]);

                    // Create Executer-Class to solve the task
                    TaskExecuter executer = new TaskExecuter(data, dataMaster.getTaskDescriptions(), dataMaster.getCalcFields(), args[3]);

                    // Execute task and give back the result
                    String result = executer.executeTask();
                    System.out.println("Result of task " + args[1] + " with fields " + args[2] + " ending in " + args[3] + " is: " + result);
                }
            }
        }
        else { System.err.println("Count of arguments not met -> " + args.length + " received (4 needed)"); }
    }
}

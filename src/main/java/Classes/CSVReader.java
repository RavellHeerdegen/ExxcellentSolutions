package Classes;

import Interfaces.IReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVReader implements IReader
{

    /**
     * Reads in the given file and splits the data into key and value pairs
     * @param filename The name of the file to read
     * @return A HashMap containing the first row of the file as keys and others as data lists
     */
    @Override
    public HashMap<String, ArrayList<String>> readFile(String filename)
    {
        HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        try
        {
            File file = new File("src/main/resources/de/exxcellent/files/"+filename);
            Scanner scanner = new Scanner(file);

            ArrayList<String> keys = new ArrayList<String>();

            boolean firstRow = true;
            while(scanner.hasNextLine())
            {
                String row = scanner.nextLine();
                String[] data_splits = row.split(",");

                if (firstRow)
                {
                    for(String key : data_splits)
                    {
                        data.put(key, new ArrayList<String>());
                        // Save the key
                        keys.add(key);
                    }
                    firstRow = false;
                }
                else
                {
                    for(int i = 0; i < data.size(); i++)
                    {
                        String key = keys.get(i);
                        data.get(key).add(data_splits[i]);
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException fnf)
        {
            System.err.println("File not found");
            fnf.printStackTrace();
        }
        return data;
    }
}

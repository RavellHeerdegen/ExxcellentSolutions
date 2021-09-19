package Classes;

import Interfaces.IReader;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONReader implements IReader
{
    /**
     * Reads in the given file and splits the data into key and value pairs
     * @param filename The name of the file to read
     * @return A HashMap containing the first row of the file as keys and others as data lists
     */
    @Override
    public HashMap<String, ArrayList<String>> readFile(String filename)
    {
        return null;
    }
}

package Interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface IReader
{
    public abstract HashMap<String, ArrayList<String>> readFile(String filename);
}

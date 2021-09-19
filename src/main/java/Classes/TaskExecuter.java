package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskExecuter
{
    private HashMap<String, ArrayList<String>> data;
    private String[] task_names;
    private String[] calc_fields;
    private String result_field;

    /**
     * Constructor for fast initialization of a TaskExecuter
     * @param data the read key value pairs of a file
     * @param task_names the names of the tasks the executer is going to do
     * @param calc_fields the fields to calculate the result
     * @param result_field the name of the field the executer gives the fitting value back from
     */
    public TaskExecuter(HashMap<String, ArrayList<String>> data, String[] task_names, String[] calc_fields, String result_field)
    {
        this.setData(data);
        this.setTask_names(task_names);
        this.setCalc_fields(calc_fields);
        this.setResult_field(result_field);
    }

    //region Getter Setter

    public HashMap<String, ArrayList<String>> getData() {
        return data;
    }

    public void setData(HashMap<String, ArrayList<String>> data) {
        this.data = data;
    }

    public String[] getTask_names() {
        return task_names;
    }

    public void setTask_names(String[] task_name) { this.task_names = task_name; }

    public String[] getCalc_fields() {
        return calc_fields;
    }

    public void setCalc_fields(String[] calc_fields) {
        this.calc_fields = calc_fields;
    }

    public String getResult_field() {
        return result_field;
    }

    public void setResult_field(String result_field) {
        this.result_field = result_field;
    }

    //endregion

    //region Public methods

    /**
     * Finds the appropriate task definition according to the executer data and returns the result of the operation
     * @return The result of the task operation according to the saved data
     */
    public String executeTask()
    {
        // Get first task
        String firstHierarchyTask = getTask_names()[0];

        switch(firstHierarchyTask)
        {
            case "smallest":
                // Get second task
                String secondHierarchyTask = getTask_names()[1];

                if (secondHierarchyTask.equals("diff")) // Calculate the smallest difference between two or more
                {
                    return smallestDiff();
                }
                else if (secondHierarchyTask.equals("value")) // Calculate the smallest value of one
                {
                    return smallestValue();
                }
                break;
            case "greatest":
                // ...
                break;
            case "average":
                // ...
                break;
            default:
                System.err.println("Unidentifiable task name");
        }

        return "-1";
    }

    //endregion

    //region Private methods

    /**
     * Calculates the smallest absolute difference of two calc fields
     * @return The result field element with the smallest absolute difference
     */
    private String smallestDiff()
    {
        // Get fields for calculation
        ArrayList<String> firstFieldValues = this.getData().get(this.getCalc_fields()[0]);
        ArrayList<String> secondFieldValues = this.getData().get(this.getCalc_fields()[1]);

        try
        {
            // Convert all string values to int for calculation
            List<Integer> firstFieldValuesAsInt = firstFieldValues.stream().map(Integer::valueOf).collect(Collectors.toList());
            List<Integer> secondFieldValuesAsInt = secondFieldValues.stream().map(Integer::valueOf).collect(Collectors.toList());

            // Save smallest value for each round
            int smallestDiffValue = Math.abs(firstFieldValuesAsInt.get(0) - secondFieldValuesAsInt.get(0));
            int smallestFoundIndex = 0;

            for(int i = 1; i < firstFieldValuesAsInt.size(); i++)
            {
                int diffValue = Math.abs(firstFieldValuesAsInt.get(i) - secondFieldValuesAsInt.get(i)); // Absolute difference
                if (diffValue < smallestDiffValue)
                {
                    smallestDiffValue = diffValue;
                    smallestFoundIndex = i;
                }
            }
            return this.getData().get(this.getResult_field()).get(smallestFoundIndex);
        }
        catch (Exception e)
        {
            // Type Conversion Errors and so on...
            System.err.println("Error at converting data types or calculating result");
            e.printStackTrace();
        }
        return "-1";
    }

    /**
     * Finds the smallest value of a calc field
     * @return The result field element with the smallest value
     */
    private String smallestValue()
    {
        return "";
    }

    //endregion

}

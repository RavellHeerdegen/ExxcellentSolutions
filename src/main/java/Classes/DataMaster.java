package Classes;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class DataMaster
{
    private boolean readerTypeIsValid;
    private String readerType;
    private String[] calcFields;
    private String[] taskDescriptions;

    //region Getters Setters

    public String[] getTaskDescriptions() {
        return taskDescriptions;
    }

    public void setTaskDescriptions(String[] taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }

    public String[] getCalcFields() {
        return calcFields;
    }

    public void setCalcFields(String[] calcFields) {
        this.calcFields = calcFields;
    }

    public boolean getReaderTypeIsValid() {
        return readerTypeIsValid;
    }

    public void setReaderTypeIsValid(boolean readerTypeIsValid) {
        this.readerTypeIsValid = readerTypeIsValid;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    //endregion

    //region Public methods

    /**
     * Entry point for processing the given arguments for further handling
     * @param filename the name of the file to be read later
     * @param taskdescriptions the bundled task descriptions to be split
     * @param calcfields the bundled calc field names to be split
     */
    public void processArgs(String filename, String taskdescriptions, String calcfields)
    {
        this.processFileName(filename);
        this.processCalcFields(calcfields);
        this.processTaskDescriptions(taskdescriptions);
    }

    /**
     * Loads an appropriate reader class depending on the given file type
     * @return A reader class fitting the given file
     */
    public Object loadReaderClass()
    {
        try
        {
            ClassLoader cloader = this.getClass().getClassLoader();

            Class readerClass = cloader.loadClass("Classes."+getReaderType()+"Reader");
            System.out.println(readerClass.getSimpleName() + " Class got loaded successfully");

            Constructor constructor = readerClass.getConstructor();
            Object readerObject = constructor.newInstance();

            return readerObject;
        }
        catch (Exception e)
        {
            System.out.println("Fehler bei Laden der Readerklasse");
            // Catch all exceptions in own catch-block with appropriate error handling ...
        }
        return null;
    }

    //endregion

    //region Private methods

    /**
     * Splits the bundled calc field names into all needed field names for later calculation
     * @param calcfields The bundled calc field names
     */
    private void processCalcFields(String calcfields)
    {
        String[] calcfields_split = calcfields.split("\\&");

        this.calcFields = new String[calcfields_split.length];

        for(int i = 0; i < calcfields_split.length; i++)
        {
            this.calcFields[i] = calcfields_split[i];
        }
    }

    /**
     * Splits the bundled task names into all needed tasks for later calculation
     * @param taskdescriptions The bundled task names
     */
    private void processTaskDescriptions(String taskdescriptions)
    {
        String[] taskdescriptions_split = taskdescriptions.split("\\&");

        this.taskDescriptions = new String[taskdescriptions_split.length];

        for(int i = 0; i < taskdescriptions_split.length; i++)
        {
            this.taskDescriptions[i] = taskdescriptions_split[i];
        }
    }

    /**
     * Decides if the given file is okay in type and saves the type for reader initialization
     * @param filename The file to read data from
     */
    private void processFileName(String filename)
    {
        String[] expected_types = {"csv", "json", "xls"};
        List<String> expected_types_list = Arrays.asList(expected_types);

        String[] file_data = filename.split("\\.");
        if (expected_types_list.contains((file_data[1])))
        {
            System.out.println("Filetype is okay");
            setReaderType(file_data[1].toUpperCase());
            setReaderTypeIsValid(true);
        }
        else
        {
            System.out.println("Filetype not allowed");
            setReaderType("");
            setReaderTypeIsValid(false);
        }
    }

    //endregion
}

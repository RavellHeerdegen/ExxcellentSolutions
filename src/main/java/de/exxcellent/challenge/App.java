package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        // Beispielaufruf des Programmes:
        // mvn exec:java "weatherdata.csv" "smallest&diff" "MnT","MxT" "Day"

        // Hol dir den Dateinamen wo die Daten rausgelesen werden sollen
        // String file_name = args[1];

        // Hole Typnamen für Readerklasse
        // String reader_type = file_name.split(".")[1]; // Dateinamen haben nur einen "." im Namen

        // Welche Aufgabe soll erledigt werden
        // String task_name = args[2];

        // Um welche Felder geht es zur Berechnung
        // String[] calcfield_names = args[3];

        // Um welches Feld geht es als Ergebnis
        // String result_field = args[4];

        // Erzeuge ein Key/Value Mapping für alle Felder/Werte
        // Map<Key,Value> data = new Map<Key,Value>();

        // Erstelle Executer-Klasse zur Erledigung der Aufgabe
        // TaskExecuter executer = new TaskExecuter();

        // ----------------------------------------------------

        // Erzeuge Reader-Klasse
        // Class reader_Class = Class.loadDynamicType(reader_type, Constructor());
        // CSVReader reader = reader_Class.initialize();

        // Lese Datei ein
        // data = reader.readFile(file_name);

        // Bewältige Aufgabe und gebe Ergebnis zurück
        // int dayWithSmallestTempSpread = executer.getResultOf(task_name, calcfield_names, result_field, data);

        //

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}

package de.exxcellent.challenge;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.CompletableFuture.anyOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

//    @BeforeEach
//    void setUp() {
//        successLabel = "successful";
//    }

//    @Test
//    void aPointlessTest() {
//        assertEquals("successful", successLabel, "My expectations were not met");
//    }

//    @Test
//    void runFootball() {
//        App.main("--football", "football.csv");
//    }

    @Test
    void EnoughArgsTest()
    {
        App.main("weather.csv", "smallest&diff", "MnT&MxT", "Day");
    }

    @Test
    void NotEnoughArgsTest() { App.main("weather.csv"); }

    @Test
    void FileTypeIsAllowedTest()
    {
        String[] expected_types = {"csv","json","xls"};
        List<String> expected_types_list = Arrays.asList(expected_types);

        String file_name = "weather.csv";
        String[] file_data = file_name.split("\\.");

        assertTrue(expected_types_list.contains(file_data[1]));
    }

    @Test
    void FileTypeIsNotAllowedTest()
    {
        String[] expected_types = {"csv","json","xls"};
        List<String> expected_types_list = Arrays.asList(expected_types);

        String file_name = "weather.cv";
        String[] file_data = file_name.split("\\.");

        assertFalse(expected_types_list.contains(file_data[1]));
    }

    @Test
    void FileNameIsOkayTest()
    {
        String file_name = "weather.csv";
        String[] file_data = file_name.split("\\.");

        assertTrue(file_data.length == 2);
    }

    @Test
    void FileNameIsCorruptTest()
    {
        String file_name = "weatherdata";
        String[] file_data = file_name.split("\\.");

        assertFalse(file_data.length == 2);
    }

    @Test
    void FileDataIsNotCorruptTest()
    {
        // check if keys and values are equal in length
    }

    @Test
    void ArgumentsIncludeFalseCharactersTest()
    {
        // check if arguments titles are okay, i.e. task names != "greatest value"
    }

}
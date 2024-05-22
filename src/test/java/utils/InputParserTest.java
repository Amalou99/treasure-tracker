package utils;

import org.carbonIT.model.Map;
import org.carbonIT.utils.InputParser;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void testParseInput() throws IOException {
        String testInputPath = "src/test/resources/input_test.txt";
        Map map = InputParser.parseMap(testInputPath);
        assertNotNull(map);
        assertEquals(4, map.getWidth());
        assertEquals(4, map.getHeight());
        assertEquals(1, map.getAdventurers().size());
    }
}

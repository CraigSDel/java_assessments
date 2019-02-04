import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class FileUtilTest {

    @Test
    public void readFileContents() throws URISyntaxException {
        String expectedContent = getExpectedFileContent();
        assertEquals(expectedContent, FileUtil.readFile("addresses[4681].json"));
    }

    private String getExpectedFileContent() {
        return "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"type\": {\n" +
                "      \"code\": \"1\",\n" +
                "      \"name\": \"Physical Address\"\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
    }
}

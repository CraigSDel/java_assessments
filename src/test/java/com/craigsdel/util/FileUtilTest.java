package com.craigsdel.util;

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
                "    },\n" +
                "    \"addressLineDetail\": {\n" +
                "      \"line1\": \"Address 1\",\n" +
                "      \"line2\": \"Line 2\"\n" +
                "    },\n" +
                "    \"provinceOrState\": {\n" +
                "      \"code\": \"5\",\n" +
                "      \"name\": \"Eastern Cape\"\n" +
                "    },\n" +
                "    \"cityOrTown\": \"City 1\",\n" +
                "    \"country\": {\n" +
                "      \"code\": \"ZA\",\n" +
                "      \"name\": \"South Africa\"\n" +
                "    },\n" +
                "    \"postalCode\": \"1234\",\n" +
                "    \"lastUpdated\": \"2015-06-21T00:00:00.000Z\"\n" +
                "  }\n" +
                "]\n";
    }
}

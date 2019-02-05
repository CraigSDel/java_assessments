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
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"type\": {\n" +
                "      \"code\": \"2\",\n" +
                "      \"name\": \"Postal Address\"\n" +
                "    },\n" +
                "    \"cityOrTown\": \"City 2\",\n" +
                "    \"country\": {\n" +
                "      \"code\": \"LB\",\n" +
                "      \"name\": \"Lebanon\"\n" +
                "    },\n" +
                "    \"postalCode\": \"2345\",\n" +
                "    \"lastUpdated\": \"2017-06-21T00:00:00.000Z\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"type\": {\n" +
                "      \"code\": \"5\",\n" +
                "      \"name\": \"Business Address\"\n" +
                "    },\n" +
                "    \"addressLineDetail\": {\n" +
                "      \"line1\": \"Address 3\",\n" +
                "      \"line2\": \"\"\n" +
                "    },\n" +
                "    \"cityOrTown\": \"City 3\",\n" +
                "    \"country\": {\n" +
                "      \"code\": \"ZA\",\n" +
                "      \"name\": \"South Africa\"\n" +
                "    },\n" +
                "    \"postalCode\": \"3456\",\n" +
                "    \"suburbOrDistrict\": \"Suburb 3\",\n" +
                "    \"lastUpdated\": \"2018-06-13T00:00:00.000Z\"\n" +
                "  }\n" +
                "]\n";
    }
}

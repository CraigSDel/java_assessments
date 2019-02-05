package com.craigsdel.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class FileUtil {

    private FileUtil() {
    }

    public static String readFile(String filePath) throws URISyntaxException {
        StringBuilder result = new StringBuilder("");
        //Get file from resources folder
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).toURI());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

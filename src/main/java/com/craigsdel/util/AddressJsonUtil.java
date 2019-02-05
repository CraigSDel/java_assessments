package com.craigsdel.util;

import com.craigsdel.entity.Address;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class AddressJsonUtil {

    private AddressJsonUtil() {
    }

    public static List<Address> fileToJson(String filePath) throws URISyntaxException, IOException {
        String mapData = FileUtil.readFile(filePath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(mapData, mapper.getTypeFactory().constructCollectionType(List.class, Address.class));
    }
}

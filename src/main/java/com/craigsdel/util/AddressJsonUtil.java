package com.craigsdel.util;

import com.craigsdel.entity.Address;
import com.craigsdel.entity.Type;
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

    public static List<Address> fileToJson(final String filePath) throws URISyntaxException, IOException {
        final String mapData = FileUtil.readFile(filePath);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(mapData, mapper.getTypeFactory().constructCollectionType(List.class, Address.class));
    }

    public static void prettyPrintAddress(final List<Address> addresses) {
        addresses.forEach(address -> System.out.println(prettyPrintAddress(address)));
    }

    public static void prettyPrintAddress(final List<Address> addresses, final Type type) {
        addresses.stream()
                .filter(address -> type.getCode().equals(address.getType().getCode()) && type.getName().equalsIgnoreCase(address.getType().getName()))
                .forEach(address -> System.out.println(prettyPrintAddress(address)));
    }

    public static String prettyPrintAddress(final Address address) {
        final String templateFormat = "Type:%1$s - Address Line 1:%2$s - Address Line 2:%3$s - City:%4$s - Province:%5$s - Postal Code:%6$s - Country:%7$s";
        String type = "";
        String line1 = "";
        String line2 = "";
        String cityOrTown = "";
        String provinceName = "";
        String postalCode = "";
        String countryName = "";
        if (address.getType().getName() != null) {
            type = address.getType().getName();
        }
        if (address.getAddressLineDetail() != null && address.getAddressLineDetail().getLine1() != null && address.getAddressLineDetail().getLine2() != null) {
            line1 = address.getAddressLineDetail().getLine1();
            line2 = address.getAddressLineDetail().getLine2();
        }
        if (address.getCityOrTown() != null) {
            cityOrTown = address.getCityOrTown();
        }
        if (address.getProvinceOrState() != null && address.getProvinceOrState().getName() != null) {
            provinceName = address.getProvinceOrState().getName();
        }
        if (address.getPostalCode() != null) {
            postalCode = address.getPostalCode();
        }
        if (address.getCountry() != null && address.getCountry().getName() != null) {
            countryName = address.getCountry().getName();
        }
        return String.format(templateFormat, type, line1, line2, cityOrTown, provinceName, postalCode, countryName);
    }
}

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
public class AddressUtil {

    private AddressUtil() {
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

    public boolean isValid(Address address) {
        try {
            Integer.parseInt(address.getPostalCode());
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (address.getAddressLineDetail() == null) {
            return false;
        }
        if (address.getAddressLineDetail().getLine1() == null && "".equals(address.getAddressLineDetail().getLine1()) ||
                address.getAddressLineDetail().getLine2() == null && "".equals(address.getAddressLineDetail().getLine2())) {
            return false;
        }
        if (address.getCountry() == null && address.getCountry().getCode() == null && "".equals(address.getCountry().getCode())
                && address.getCountry().getName() == null && "".equals(address.getCountry().getName())) {
            return false;
        }
        if ("ZA".equals(address.getCountry().getCode())) {
            if(address.getProvinceOrState() == null && address.getProvinceOrState().getCode() == null && "".equals(address.getProvinceOrState().getName()))
            return false;
        }
        return true;
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
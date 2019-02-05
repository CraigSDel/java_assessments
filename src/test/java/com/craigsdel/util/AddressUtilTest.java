package com.craigsdel.util;

import com.craigsdel.entity.*;
import com.craigsdel.exception.AddressValidationException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class AddressUtilTest {

    @Test
    public void fileToJson() throws IOException, URISyntaxException, ParseException {
        final List<Address> stringObjectMap = AddressUtil.fileToJson("addresses[4681].json");
        assertNotNull(stringObjectMap);
        final Address expectedAddress = buildAddress();
        assertEquals(expectedAddress, stringObjectMap.get(0));
    }

    @Test
    public void prettyPrint() throws ParseException {
        final String expected = "Type:Physical Address - Address Line 1:Address 1 - Address Line 2:Line 2 - City:City 1 - Province:Eastern Cape - Postal Code:1234 - Country:South Africa";
        assertEquals(expected, AddressUtil.prettyPrintAddress(buildAddress()));
    }

    @Test(expected = AddressValidationException.class)
    public void validateAddress() throws ParseException, AddressValidationException {
        final Address address = buildAddress();
        assertEquals(true, AddressUtil.isValid(address));
        address.setCountry(null);
        assertEquals(false, AddressUtil.isValid(address));
        address.setAddressLineDetail(null);
        assertEquals(false, AddressUtil.isValid(address));
        address.setProvinceOrState(new ProvinceOrState(5L, "Texas"));
        assertEquals(false, AddressUtil.isValid(address));
    }


    @Test(expected = AddressValidationException.class)
    public void validateAddressCountry() throws ParseException, AddressValidationException {
        Address address = buildAddress();
        address.setCountry(null);
        assertEquals(false, AddressUtil.isValidCountry(address));
        address.setCountry(new Country());
        assertEquals(false, AddressUtil.isValidCountry(address));
        address = buildAddress();
        assertEquals(true, AddressUtil.isValidCountry(address));
    }

    @Test(expected = AddressValidationException.class)
    public void validateAddressLineDetail() throws ParseException, AddressValidationException {
        Address address = buildAddress();
        address.setAddressLineDetail(null);
        assertEquals(false, AddressUtil.isValidAddressDetail(address));
        address.setAddressLineDetail(new AddressLineDetail());
        assertEquals(false, AddressUtil.isValidAddressDetail(address));
        address.setAddressLineDetail(new AddressLineDetail("", ""));
        assertEquals(false, AddressUtil.isValidAddressDetail(address));
        address.setAddressLineDetail(new AddressLineDetail("321 Hello World", ""));
        assertEquals(true, AddressUtil.isValidAddressDetail(address));
        address.setAddressLineDetail(new AddressLineDetail("", "321 Hello World"));
        assertEquals(true, AddressUtil.isValidAddressDetail(address));
        address = buildAddress();
        assertEquals(true, AddressUtil.isValidAddressDetail(address));
    }

    @Test(expected = AddressValidationException.class)
    public void validateAddressZA() throws ParseException, AddressValidationException {
        Address address = buildAddress();
        assertEquals(true, AddressUtil.isValidZAProvince(address));
        address.setProvinceOrState(new ProvinceOrState(5L, "Texas"));
        assertEquals(false, AddressUtil.isValidZAProvince(address));
    }

    @Test
    public void validateAddressPostalCode() throws ParseException, AddressValidationException {
        Address address = buildAddress();
        assertEquals(true, AddressUtil.isValidPostalCode(address));
    }

    private Address buildAddress() throws ParseException {
        final long id = 1L;
        final Type type = Type.builder()
                .code(id)
                .name("Physical Address")
                .build();
        final AddressLineDetail addressLineDetail = AddressLineDetail.builder()
                .line1("Address 1")
                .line2("Line 2")
                .build();
        final ProvinceOrState provinceOrState = ProvinceOrState.builder()
                .code(5L)
                .name("Eastern Cape")
                .build();
        final Date lastUpdated = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .parse("2015-06-21T00:00:00.000Z");
        final String postalCode = "1234";
        final Country country = Country.builder()
                .code("ZA")
                .name("South Africa")
                .build();
        final String cityOrTown = "City 1";
        return Address.builder()
                .id(id)
                .type(type)
                .addressLineDetail(addressLineDetail)
                .provinceOrState(provinceOrState)
                .cityOrTown(cityOrTown)
                .country(country)
                .postalCode(postalCode)
                .lastUpdated(lastUpdated)
                .build();
    }

}

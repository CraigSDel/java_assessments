package com.craigsdel.util;

import com.craigsdel.entity.*;
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
public class AddressJsonUtilTest {

    @Test
    public void fileToJson() throws IOException, URISyntaxException, ParseException {
        final List<Address> stringObjectMap = AddressJsonUtil.fileToJson("addresses[4681].json");
        assertNotNull(stringObjectMap);
        final Address expectedAddress = expectedAddress();
        assertEquals(expectedAddress, stringObjectMap.get(0));
    }

    private Address expectedAddress() throws ParseException {
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
                .name("Eastern Cape").build();
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

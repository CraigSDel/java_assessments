package com.craigsdel.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ZAProvinces {
    EASTERN_CAPE("EASTERN CAPE"),
    FREE_STATE("FREE STATE"),
    GAUTENG("GAUTENG"),
    KWAZULU_NATAL("KWAZULU NATAL"),
    LIMPOPO("LIMPOPO"),
    MPUMALANGA("MPUMALANGA"),
    NORTH_WEST("NORTH WEST"),
    NORTHERN_CAPE("NORTHERN CAPE"),
    WESTERN_CAPE("WESTERN CAPE");

    private final String name;

    public static ZAProvinces fromString(String text) {
        for (ZAProvinces provinces : ZAProvinces.values()) {
            if (provinces.name.equalsIgnoreCase(text)) {
                return provinces;
            }
        }
        return null;
    }
}

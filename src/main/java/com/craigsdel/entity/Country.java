package com.craigsdel.entity;

import lombok.*;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Country {
    private String code;
    private String name;
}

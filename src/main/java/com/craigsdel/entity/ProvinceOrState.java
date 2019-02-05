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
public class ProvinceOrState {
    private Long code;
    private String name;
}

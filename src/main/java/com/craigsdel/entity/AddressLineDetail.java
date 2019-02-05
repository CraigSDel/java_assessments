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
public class AddressLineDetail {
    private String line1;
    private String line2;
}

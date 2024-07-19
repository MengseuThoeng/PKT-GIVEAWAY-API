package org.pktstore.cambodia.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BaseError<T> {
    private String code;
    private T description;
}

package org.pktstore.cambodia;

import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(

        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Name is required")
        String name
) {
}

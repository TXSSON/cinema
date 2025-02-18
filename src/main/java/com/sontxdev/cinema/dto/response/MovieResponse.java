package com.sontxdev.cinema.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private String id;
    private String name;
}

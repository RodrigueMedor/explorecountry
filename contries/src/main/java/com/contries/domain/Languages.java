package com.contries.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Languages {
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;
}

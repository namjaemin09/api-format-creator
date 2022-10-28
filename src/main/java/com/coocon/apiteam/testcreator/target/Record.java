package com.coocon.apiteam.testcreator.target;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Record extends Lump{
    private String resource;
    private String target;
}

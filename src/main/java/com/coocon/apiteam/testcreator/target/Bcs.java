package com.coocon.apiteam.testcreator.target;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Bcs extends Lump {
    private String filePackage;
    private String startTime;
    private String endTime;

}

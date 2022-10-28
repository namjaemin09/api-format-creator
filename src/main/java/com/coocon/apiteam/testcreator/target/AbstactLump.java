package com.coocon.apiteam.testcreator.target;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
abstract class AbstractLump {
    private String name;

    private LinkedHashMap<String, AbstractLump> input_rules;
    private LinkedHashMap<String, AbstractLump> output_rules;
    private HashMap<String, AbstractLump> sub_rules;
}

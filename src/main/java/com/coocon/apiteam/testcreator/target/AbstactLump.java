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

    private LinkedHashMap<String, Item> inputRules;
    private LinkedHashMap<String, Item> outputRules;
    private HashMap<String, AbstractLump> subRules;

    abstract boolean addInputRule(Item item);
    abstract boolean addOutputRule(Item item);
    abstract boolean addSubRule(Item item);

}

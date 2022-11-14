package com.coocon.apiteam.testcreator.target;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Lump extends AbstractLump {
    @Override
    boolean addInputRule(Item item) {
        return false;
    }

    @Override
    boolean addOutputRule(Item item) {
        return false;
    }

    @Override
    boolean addSubRule(Item item) {
        return false;
    }
}

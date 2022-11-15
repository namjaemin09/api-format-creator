package com.coocon.apiteam.testcreator.target;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.LinkedHashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private String name;
    private String id;
    private String padding;
    private String length;
    private String fullChar;
    private String align;
    private String required;
    private String typeDat;
    private String target;
    private String defaultValue;
    private String resourceId;
    private String packageId;



}

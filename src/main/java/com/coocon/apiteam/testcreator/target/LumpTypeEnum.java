package com.coocon.apiteam.testcreator.target;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LumpTypeEnum {
    SVC("svc"),
    IMO("imo"),
    IDO("ido"),
    CMO("cmo"),
    WSVC("WSVC"),
    BCS("BCS");

    private String type;
}

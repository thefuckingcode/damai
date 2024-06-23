package com.taobao.slide.model;

import java.io.Serializable;
import java.util.List;
import tb.ee2;

/* compiled from: Taobao */
public class ResultDO implements Serializable {
    private static final long serialVersionUID = 732893053025707124L;
    public String eTag;
    public String name;
    public String peaExtra;
    public String podExtra;
    public List<PayloadDO> resources;
    public ee2 statData;
    public String version;

    public ResultDO(String str, String str2, String str3, String str4, List<PayloadDO> list, String str5) {
        this.name = str;
        this.version = str2;
        this.podExtra = str3;
        this.peaExtra = str4;
        this.resources = list;
        this.eTag = str5;
        ee2 ee2 = new ee2();
        this.statData = ee2;
        ee2.a = str;
        ee2.b = str5;
        ee2.c = str2;
    }

    public String toString() {
        return String.format("{name:%s, version:%s, podExtra:%s, peaExtra:%s, resources:%s", this.name, this.version, this.podExtra, this.peaExtra, this.resources);
    }
}

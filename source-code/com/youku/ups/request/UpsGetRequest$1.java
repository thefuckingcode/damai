package com.youku.ups.request;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashSet;

/* compiled from: Taobao */
class UpsGetRequest$1 extends HashSet<String> {
    UpsGetRequest$1() {
        add(IRequestConst.MDL);
        add("device_brand");
        add(IRequestConst.OSV);
        add("ua");
    }
}

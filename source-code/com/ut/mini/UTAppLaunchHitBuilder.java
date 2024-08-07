package com.ut.mini;

import com.ut.mini.UTHitBuilders;
import java.util.Map;
import tb.zf2;

/* compiled from: Taobao */
class UTAppLaunchHitBuilder extends UTHitBuilders.UTHitBuilder {
    UTAppLaunchHitBuilder(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        if (!zf2.f(str)) {
            super.setProperty(UTHitBuilders.UTHitBuilder.FIELD_PAGE, str);
        }
        super.setProperty(UTHitBuilders.UTHitBuilder.FIELD_EVENT_ID, "" + i);
        if (!zf2.f(str2)) {
            super.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG1, str2);
        }
        if (!zf2.f(str3)) {
            super.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str3);
        }
        if (!zf2.f(str4)) {
            super.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG3, str4);
        }
        super.setProperties(map);
    }
}

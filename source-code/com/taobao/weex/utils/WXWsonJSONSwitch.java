package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.bridge.WXJSObject;
import tb.jl1;
import tb.tz2;
import tb.uz2;

/* compiled from: Taobao */
public class WXWsonJSONSwitch {
    public static boolean USE_WSON = true;
    public static final String WSON_OFF = "wson_off";

    public static final byte[] convertJSONToWsonIfUseWson(byte[] bArr) {
        if (!USE_WSON) {
            return bArr;
        }
        if (bArr == null) {
            return null;
        }
        String str = new String(bArr);
        if (str.startsWith(jl1.ARRAY_START_STR)) {
            return uz2.a(JSON.parseArray(str));
        }
        return uz2.a(JSON.parse(str));
    }

    public static final Object convertWXJSObjectDataToJSON(WXJSObject wXJSObject) {
        if (wXJSObject.type == 4) {
            return JSON.parse(tz2.i((byte[]) wXJSObject.data).toString());
        }
        return JSON.parse(wXJSObject.data.toString());
    }

    @NonNull
    public static String fromObjectToJSONString(WXJSObject wXJSObject) {
        Object i;
        if (wXJSObject == null || wXJSObject.type != 4 || (i = tz2.i((byte[]) wXJSObject.data)) == null) {
            return WXJsonUtils.fromObjectToJSONString(wXJSObject, false);
        }
        return i.toString();
    }

    public static final Object parseWsonOrJSON(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            if (USE_WSON) {
                return tz2.i(bArr);
            }
            return JSON.parse(new String(bArr, "UTF-8"));
        } catch (Exception e) {
            WXLogUtils.e("WXSwitch", e);
            if (USE_WSON) {
                return JSON.parse(new String(bArr));
            }
            return tz2.i(bArr);
        }
    }

    public static final WXJSObject toWsonOrJsonWXJSObject(Object obj) {
        if (obj == null) {
            return new WXJSObject(null);
        }
        if (obj.getClass() == WXJSObject.class) {
            return (WXJSObject) obj;
        }
        if (USE_WSON) {
            return new WXJSObject(4, tz2.j(obj));
        }
        return new WXJSObject(3, WXJsonUtils.fromObjectToJSONString(obj));
    }
}

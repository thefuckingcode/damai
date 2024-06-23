package com.taobao.android.dinamic.expression.parser;

import android.text.TextUtils;
import com.taobao.android.dinamic.exception.DinamicException;
import java.util.HashMap;
import java.util.Map;
import tb.a7;
import tb.b5;
import tb.b80;
import tb.bo2;
import tb.co2;
import tb.de0;
import tb.e71;
import tb.hf2;
import tb.is0;
import tb.jb0;
import tb.kb0;
import tb.lb0;
import tb.lj1;
import tb.mf2;
import tb.ml1;
import tb.nb0;
import tb.o11;
import tb.o70;
import tb.ob0;
import tb.ob1;
import tb.p11;
import tb.p70;
import tb.pf2;
import tb.q11;
import tb.rf2;
import tb.s11;
import tb.si0;
import tb.t11;
import tb.v0;
import tb.v70;
import tb.w70;
import tb.xc0;

/* compiled from: Taobao */
public class a {
    private static Map<String, v0> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("data", new v70());
        a.put(o70.CONSTANT_PREFIX, new p70());
        a.put(o70.SUBDATA_PREFIX, new b80());
        a.put(o70.APP_STYLE, new a7());
        a.put(o70.AND_PREFIX, new b5());
        a.put(o70.EQUAL_PREFIX, new de0());
        a.put("len", new e71());
        a.put(o70.NOT_PREFIX, new lj1());
        a.put(o70.ELSE_PREFIX, new xc0());
        a.put(o70.MATCH_PREFIX, new ob1());
        a.put(o70.LOWER_PREFIX, new mf2());
        a.put("uc", new rf2());
        a.put(o70.CONCAT_PREFIX, new hf2());
        a.put(o70.TRIPLE_PREFIX, new co2());
        a.put(o70.SUBSTR_PREFIX, new pf2());
        a.put(o70.FIND_PREFIX, new si0());
        a.put(o70.AGET_PREFIX, new is0());
        a.put(o70.DGET_PREFIX, new is0());
        a.put(o70.OR_PREFIX, new ml1());
        a.put(o70.TRIM_PREFIX, new bo2());
        a.put(o70.FLOAT_LITTER_PREFIX, new nb0());
        a.put(o70.FLOAT_LITTER_EQUAL_PREFIX, new ob0());
        a.put(o70.FLOAT_BIGGER_EQUAL_PREFIX, new lb0());
        a.put(o70.FLOAT_BIGGER_PREFIX, new kb0());
        a.put(o70.FLOAT_EQUAL, new jb0());
        a.put(o70.INT_BIGGER_EQUAL_PREFIX, new q11());
        a.put(o70.INT_BIGGER_PREFIX, new p11());
        a.put(o70.INT_LITTER_EQUAL_PREFIX, new t11());
        a.put(o70.INT_LITTER_PREFIX, new s11());
        a.put(o70.INT_EQUAL, new o11());
        a.put(o70.SIZE_BY_FACTOR, new b());
        a.put(o70.IS_ELDER, new w70());
    }

    public static boolean a(String str) {
        return a.containsKey(str);
    }

    public static DinamicDataParser b(String str) {
        return a.get(str);
    }

    public static void c(String str, v0 v0Var) throws DinamicException {
        if (TextUtils.isEmpty(str) || v0Var == null) {
            throw new DinamicException("prefix or parser is null");
        } else if (a.get(str) == null) {
            a.put(str, v0Var);
        } else {
            throw new DinamicException("registerParser failed, parser already register by current identify:" + str);
        }
    }
}

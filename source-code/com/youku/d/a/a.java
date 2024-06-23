package com.youku.d.a;

import com.youku.core.context.YoukuContext;
import com.youku.phone.ruleswitcher.RuleSwitcher;

/* compiled from: Taobao */
public class a {
    private static int a = 1048575;

    public static boolean a(String str, double d) {
        return RuleSwitcher.switchHit(YoukuContext.getApplicationContext(), str, d);
    }
}

package com.youku.gaiax.api.proxy;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.common.utils.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class IProxyPrefs$initOrange$1 extends Lambda implements Function0<ur2> {
    public static final IProxyPrefs$initOrange$1 INSTANCE = new IProxyPrefs$initOrange$1();

    IProxyPrefs$initOrange$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        try {
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d("[GaiaX]", k21.r("GaiaXOrange配置更新 - ", new JSONObject()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

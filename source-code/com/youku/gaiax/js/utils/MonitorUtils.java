package com.youku.gaiax.js.utils;

import com.alipay.sdk.m.k.b;
import com.youku.gaiax.js.GaiaXJS;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.if1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ`\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ&\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J.\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/youku/gaiax/js/utils/MonitorUtils;", "", "", "scene", b.l, "id", "type", "state", "", "value", "jsModuleName", "jsApiName", "jsApiType", "Ltb/ur2;", "monitor", "jsInitScene", "templateId", if1.DIMEN_BIZ, "jsTemplate", "jsApi", "TYPE_JS_CONTEXT_INIT", "Ljava/lang/String;", "TYPE_LOAD_MODULE", "TYPE_JS_LIBRARY_INIT", "TYPE_LOAD_INDEX_JS", "TYPE_JS_TO_CONTEXT", "TYPE_CONTEXT_TO_RETURN", "TYPE_RETURN_TO_CONTEXT", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class MonitorUtils {
    @NotNull
    public static final MonitorUtils INSTANCE = new MonitorUtils();
    @NotNull
    public static final String TYPE_CONTEXT_TO_RETURN = "CONTEXT_TO_RETURN";
    @NotNull
    public static final String TYPE_JS_CONTEXT_INIT = "JS_CONTEXT_INIT";
    @NotNull
    public static final String TYPE_JS_LIBRARY_INIT = "JS_LIBRARY_INIT";
    @NotNull
    public static final String TYPE_JS_TO_CONTEXT = "JS_TO_CONTEXT";
    @NotNull
    public static final String TYPE_LOAD_INDEX_JS = "LOAD_INDEX_JS";
    @NotNull
    public static final String TYPE_LOAD_MODULE = "LOAD_MODULE";
    @NotNull
    public static final String TYPE_RETURN_TO_CONTEXT = "RETURN_TO_CONTEXT";

    private MonitorUtils() {
    }

    private final void monitor(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("monitor() called with: scene = " + str + ", biz = " + str2 + ", id = " + str3 + ", type = " + str4 + ", state = " + str5 + ", value = " + j + ", moduleName = " + str6 + ", apiName = " + str7 + ", apiType = " + str8);
        }
        GaiaXJS.Listener listener$GaiaX_Android_JS = GaiaXJS.Companion.getInstance().getListener$GaiaX_Android_JS();
        if (listener$GaiaX_Android_JS != null) {
            listener$GaiaX_Android_JS.monitor(str, str2, str3, str4, str5, j, str6, str7, str8);
        }
    }

    static /* synthetic */ void monitor$default(MonitorUtils monitorUtils, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, Object obj) {
        String str9 = "";
        String str10 = (i & 2) != 0 ? str9 : str2;
        String str11 = (i & 4) != 0 ? str9 : str3;
        String str12 = (i & 8) != 0 ? str9 : str4;
        String str13 = (i & 16) != 0 ? str9 : str5;
        long j2 = (i & 32) != 0 ? -1 : j;
        String str14 = (i & 64) != 0 ? str9 : str6;
        String str15 = (i & 128) != 0 ? str9 : str7;
        if ((i & 256) == 0) {
            str9 = str8;
        }
        monitorUtils.monitor(str, str10, str11, str12, str13, j2, str14, str15, str9);
    }

    public final void jsApi(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j) {
        k21.i(str, "type");
        k21.i(str2, "jsModuleName");
        k21.i(str3, "jsApiName");
        k21.i(str4, "jsApiType");
        monitor$default(this, "GAIAX_JS_API", null, null, str, null, j, str2, str3, str4, 22, null);
    }

    public final void jsInitScene(@NotNull String str, long j) {
        k21.i(str, "type");
        monitor$default(this, "GAIAX_JS_INIT", null, null, str, null, j, null, null, null, 470, null);
    }

    public final void jsTemplate(@NotNull String str, long j, @NotNull String str2, @NotNull String str3) {
        k21.i(str, "type");
        k21.i(str2, "templateId");
        k21.i(str3, if1.DIMEN_BIZ);
        monitor$default(this, "GAIAX_JS_TEMPLATE", str3, str2, str, null, j, null, null, null, 464, null);
    }
}

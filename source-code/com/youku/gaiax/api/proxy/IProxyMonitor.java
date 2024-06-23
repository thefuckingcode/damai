package com.youku.gaiax.api.proxy;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J`\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0002H&JB\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyMonitor;", "", "Ltb/ur2;", "monitorInit", "", "scene", b.l, "id", "type", "state", "", "value", "module", "api", "apiType", "monitor", "monitorLocalAndRemote", "code", "version", "message", "Lcom/alibaba/fastjson/JSONObject;", "bizData", NotificationCompat.CATEGORY_ALARM, "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface IProxyMonitor {
    @NotNull
    public static final String CODE_5001 = "5001";
    @NotNull
    public static final String CODE_5002 = "5002";
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyMonitor$Companion;", "", "", "CODE_5001", "Ljava/lang/String;", "CODE_5002", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        public static final String CODE_5001 = "5001";
        @NotNull
        public static final String CODE_5002 = "5002";

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class DefaultImpls {
        public static /* synthetic */ void alarm$default(IProxyMonitor iProxyMonitor, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, int i, Object obj) {
            if (obj == null) {
                String str6 = "";
                String str7 = (i & 2) != 0 ? str6 : str2;
                String str8 = (i & 4) != 0 ? str6 : str3;
                String str9 = (i & 8) != 0 ? str6 : str4;
                if ((i & 16) == 0) {
                    str6 = str5;
                }
                iProxyMonitor.alarm(str, str7, str8, str9, str6, (i & 32) != 0 ? new JSONObject() : jSONObject);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alarm");
        }

        public static /* synthetic */ void monitor$default(IProxyMonitor iProxyMonitor, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, Object obj) {
            if (obj == null) {
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
                iProxyMonitor.monitor(str, str10, str11, str12, str13, j2, str14, str15, str9);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
        }

        public static void monitorInit(@NotNull IProxyMonitor iProxyMonitor) {
            k21.i(iProxyMonitor, "this");
        }
    }

    void alarm(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject);

    void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8);

    void monitorInit();

    void monitorLocalAndRemote();
}

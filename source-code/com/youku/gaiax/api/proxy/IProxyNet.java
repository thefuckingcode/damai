package com.youku.gaiax.api.proxy;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyNet;", "", "", "templatesId", "Lcom/youku/gaiax/api/proxy/IProxyNet$NetResponse;", "requestTemplates", "", "pageNum", Constants.Name.PAGE_SIZE, "", "timestamp", "requestTemplateWithPage", "NetResponse", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface IProxyNet {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Nullable
        public static NetResponse requestTemplateWithPage(@NotNull IProxyNet iProxyNet, int i, int i2, long j) {
            k21.i(iProxyNet, "this");
            return null;
        }

        @Nullable
        public static NetResponse requestTemplates(@NotNull IProxyNet iProxyNet, @NotNull String str) {
            k21.i(iProxyNet, "this");
            k21.i(str, "templatesId");
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyNet$NetResponse;", "", "", "isSuccess", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class NetResponse {
        @NotNull
        private JSONObject data = new JSONObject();
        @NotNull
        private String message = "";
        @NotNull
        private String status = "";

        @NotNull
        public final JSONObject getData() {
            return this.data;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public final boolean isSuccess() {
            return k21.d("SUCCESS", this.status);
        }

        public final void setData(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "<set-?>");
            this.data = jSONObject;
        }

        public final void setMessage(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.message = str;
        }

        public final void setStatus(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.status = str;
        }
    }

    @Nullable
    NetResponse requestTemplateWithPage(int i, int i2, long j);

    @Nullable
    NetResponse requestTemplates(@NotNull String str);
}

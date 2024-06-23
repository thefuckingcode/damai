package com.youku.gaiax.provider.module;

import com.taobao.weex.common.Constants;
import com.youku.gaiax.provider.module.net.YYBaseMtopRequest;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.EnvUrlProviderProxy;
import java.io.Serializable;
import kotlin.Metadata;
import mtopsdk.mtop.domain.MethodEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010%\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!¨\u0006-"}, d2 = {"Lcom/youku/gaiax/provider/module/TemplateApiModel;", "Lcom/youku/gaiax/provider/module/net/YYBaseMtopRequest;", "Ljava/io/Serializable;", "Lmtopsdk/mtop/domain/MethodEnum;", "getHttpMethod", "", "getNeedEcode", "getNeedSession", "", "getVersion", "getApiName", "", "pageNum", "I", "getPageNum", "()I", "setPageNum", "(I)V", Constants.Name.PAGE_SIZE, "getPageSize", "setPageSize", "", "timestamp", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "platform", "Ljava/lang/String;", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "templateIds", "getTemplateIds", "setTemplateIds", "env", "getEnv", "setEnv", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class TemplateApiModel extends YYBaseMtopRequest implements Serializable {
    @NotNull
    private String appVersion;
    @NotNull
    private String env;
    private int pageNum;
    private int pageSize = 50;
    @NotNull
    private String platform = "ANDROID";
    @Nullable
    private String templateIds;
    private long timestamp;

    public TemplateApiModel() {
        String versionName = AppInfoProviderProxy.getVersionName();
        this.appVersion = versionName == null ? "" : versionName;
        String str = "publish";
        if (EnvUrlProviderProxy.isDaily()) {
            str = "daily";
        } else if (EnvUrlProviderProxy.isPre()) {
            str = "pre";
        } else {
            EnvUrlProviderProxy.isOnline();
        }
        this.env = str;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getApiName() {
        PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
        if (companion.isDamaiApp()) {
            return "mtop.damai.wireless.gaia.template.list.page";
        }
        return companion.isTppApp() ? "mtop.taopiaopiao.wireless.gaia.template.list.page" : "";
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getEnv() {
        return this.env;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public MethodEnum getHttpMethod() {
        return MethodEnum.POST;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedEcode() {
        return false;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedSession() {
        return false;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    public final String getTemplateIds() {
        return this.templateIds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getVersion() {
        return "1.0";
    }

    public final void setAppVersion(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setEnv(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.env = str;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final void setPlatform(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.platform = str;
    }

    public final void setTemplateIds(@Nullable String str) {
        this.templateIds = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }
}

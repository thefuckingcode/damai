package com.alibaba.yymidservice.popup.request.requestparam;

import com.alibaba.yymidservice.popup.request.PicBaseRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupReportResponseBean;
import com.alient.gaiax.container.util.ChannelUtil;
import com.taobao.orange.OConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/alibaba/yymidservice/popup/request/requestparam/PopupReportRequestParam;", "Lcom/alibaba/yymidservice/popup/request/PicBaseRequest;", "Lcom/alibaba/yymidservice/popup/request/bean/PopupReportResponseBean;", "", "comboChannel", "Ljava/lang/String;", "getComboChannel", "()Ljava/lang/String;", "setComboChannel", "(Ljava/lang/String;)V", "comboCityId", "getComboCityId", "setComboCityId", "pkId", "getPkId", "setPkId", "Lorg/json/JSONObject;", "args", "Lorg/json/JSONObject;", "getArgs", "()Lorg/json/JSONObject;", "setArgs", "(Lorg/json/JSONObject;)V", "<init>", "()V", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PopupReportRequestParam extends PicBaseRequest<PopupReportResponseBean> {
    @Nullable
    private JSONObject args;
    @Nullable
    private String comboChannel;
    @Nullable
    private String comboCityId;
    @Nullable
    private String pkId;

    public PopupReportRequestParam() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            this.API_NAME = "mtop.damai.mec.popup.report";
            this.comboChannel = "1";
        } else if (channelUtil.isTppApp()) {
            this.API_NAME = "mtop.film.life.popup.report";
            this.comboChannel = OConstant.CODE_POINT_EXP_BIND_SERVICE;
        }
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
    }

    @Nullable
    public final JSONObject getArgs() {
        return this.args;
    }

    @Nullable
    public final String getComboChannel() {
        return this.comboChannel;
    }

    @Nullable
    public final String getComboCityId() {
        return this.comboCityId;
    }

    @Nullable
    public final String getPkId() {
        return this.pkId;
    }

    public final void setArgs(@Nullable JSONObject jSONObject) {
        this.args = jSONObject;
    }

    public final void setComboChannel(@Nullable String str) {
        this.comboChannel = str;
    }

    public final void setComboCityId(@Nullable String str) {
        this.comboCityId = str;
    }

    public final void setPkId(@Nullable String str) {
        this.pkId = str;
    }
}

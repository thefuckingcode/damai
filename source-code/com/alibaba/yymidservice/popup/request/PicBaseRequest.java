package com.alibaba.yymidservice.popup.request;

import com.alibaba.pictures.request.BaseRequest;
import com.alient.gaiax.container.util.ChannelUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/alibaba/yymidservice/popup/request/PicBaseRequest;", "BizResponse", "Lcom/alibaba/pictures/request/BaseRequest;", "", "markRequestLabel", "<init>", "()V", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class PicBaseRequest<BizResponse> extends BaseRequest<BizResponse> {
    @Override // com.alibaba.pictures.request.BaseRequest, com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            return "damai";
        }
        channelUtil.isTppApp();
        return "tpp";
    }
}

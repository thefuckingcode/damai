package com.alimm.xadsdk.request.builder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.request.RequestUtils;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import java.util.Map;

/* compiled from: Taobao */
public class PasterAdRequestBuilder extends BaseAdRequestBuilder {
    private static final String OTT_MID_PASTER_AD_PATH = "/mo";
    private static final String PASTER_AD_PATH = "/uts/v1/video";

    private String getUrlPath() {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? OTT_MID_PASTER_AD_PATH : PASTER_AD_PATH;
    }

    /* access modifiers changed from: protected */
    @Override // com.alimm.xadsdk.request.builder.BaseAdRequestBuilder
    public void addQueryParams(@NonNull RequestInfo requestInfo, @NonNull Map<String, String> map) {
        String str;
        if (requestInfo instanceof PasterAdRequestInfo) {
            PasterAdRequestInfo pasterAdRequestInfo = (PasterAdRequestInfo) requestInfo;
            RequestUtils.addVideoInfo(pasterAdRequestInfo, map);
            map.put("sid", pasterAdRequestInfo.getSessionId());
            map.put("p", String.valueOf(pasterAdRequestInfo.getAdType()));
            String str2 = "0";
            map.put(IRequestConst.FU, pasterAdRequestInfo.isFullScreen() ? "1" : str2);
            if (pasterAdRequestInfo.getReqFrom() == 1) {
                map.put(IRequestConst.AW, "off");
                str = "2";
            } else {
                map.put(IRequestConst.AW, "a");
                str = String.valueOf(pasterAdRequestInfo.getOfflineVideo());
            }
            map.put(IRequestConst.VC, str);
            map.put(IRequestConst.WHITE_IDEA_IDS, pasterAdRequestInfo.getIes());
            map.put(IRequestConst.VIP_TIPS, "1");
            map.put(IRequestConst.DQ, pasterAdRequestInfo.getQuality());
            map.put(IRequestConst.OFFLINE_VIDEO, String.valueOf(pasterAdRequestInfo.getOfflineVideo()));
            if (pasterAdRequestInfo.isSupportHttps()) {
                str2 = "1";
            }
            map.put(IRequestConst.AD_HTTPS, str2);
            if (1 == pasterAdRequestInfo.getMediaType()) {
                map.put(IRequestConst.LID, !TextUtils.isEmpty(pasterAdRequestInfo.getLiveId()) ? pasterAdRequestInfo.getLiveId() : "");
                map.put(IRequestConst.LIVE_STATE, String.valueOf(pasterAdRequestInfo.getLiveState()));
                map.put(IRequestConst.LIVE_AD_FLAG, String.valueOf(pasterAdRequestInfo.getLiveAdFlag()));
            }
            map.put("rst", 1 == AdSdkManager.getInstance().getConfig().getDeviceType() ? "m3u8" : YKLAnimationViewAdapter.TYPE_MP4);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alimm.xadsdk.request.builder.BaseAdRequestBuilder
    @NonNull
    public String getRequestUrl(boolean z) {
        return getProtocol() + getUrlDomain(z) + getUrlPath();
    }
}

package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.b01;
import tb.kl1;
import tb.l32;
import tb.vz0;

/* compiled from: Taobao */
public class SVGNRegionImage implements IRegionImage, RequestListener<ImageData, vz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private l32 assist;
    private boolean isRainBowUrl;
    private IRegionImageCallback listener;
    private SVGRequest mRequest;
    private String url;

    public SVGNRegionImage(IRegionImageCallback iRegionImageCallback, l32 l32, boolean z) {
        this.listener = iRegionImageCallback;
        this.assist = l32;
        this.isRainBowUrl = z;
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989288779")) {
            ipChange.ipc$dispatch("1989288779", new Object[]{this});
            return;
        }
        try {
            SVGRequest sVGRequest = this.mRequest;
            if (sVGRequest != null) {
                sVGRequest.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-674012428")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("-674012428", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImage
    public void loadRegionImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304812046")) {
            ipChange.ipc$dispatch("304812046", new Object[]{this, str});
            return;
        }
        this.url = str;
        l32 l32 = this.assist;
        boolean z = this.isRainBowUrl;
        if (z) {
            l32 = null;
        }
        SVGRequest sVGRequest = new SVGRequest(new b01(false, str, -1, true, z, l32));
        this.mRequest = sVGRequest;
        sVGRequest.d(this);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kl1<vz0> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281806460")) {
            ipChange.ipc$dispatch("-281806460", new Object[]{this, kl1, str, str2});
        } else if (this.listener != null) {
            RegionImageData.RegionImageStatus regionImageStatus = RegionImageData.RegionImageStatus.LOAD_FAILED;
            if (TextUtils.equals(str, ImageData.CODE_SVG_BUILD_FAIL)) {
                regionImageStatus = RegionImageData.RegionImageStatus.PARSE_FAILED;
            }
            RegionImageData regionImageData = new RegionImageData();
            regionImageData.setRegionImageUrl(kl1.d());
            regionImageData.setRegionImageStatus(regionImageStatus);
            regionImageData.failReason = "svg:" + str2;
            this.listener.onLoadRegionImageFailed(regionImageData);
        }
    }

    public void onSuccess(kl1<vz0> kl1, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812422482")) {
            ipChange.ipc$dispatch("-812422482", new Object[]{this, kl1, imageData});
        } else if (this.listener != null) {
            RegionImageData regionImageData = new RegionImageData();
            regionImageData.setRegionImageUrl(kl1.d());
            regionImageData.setRegionImageStatus(RegionImageData.RegionImageStatus.SUCCESS);
            regionImageData.setRegionSVG(imageData.getSVG());
            this.listener.onLoadRegionImageSuccess(regionImageData);
        }
    }
}

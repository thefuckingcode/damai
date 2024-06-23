package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RegionImageData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String failReason;
    private RegionImageStatus mLoadRegionImageStatus = RegionImageStatus.INIT;
    private BaseSVG mRainbowSVG;
    private Bitmap mRegionImageBitmap;
    private String mRegionImageUrl;
    private BaseSVG mRegionSVG;

    /* compiled from: Taobao */
    public enum RegionImageStatus {
        INIT,
        SUCCESS,
        LOAD_FAILED,
        PARSE_FAILED,
        UN_KNOWN
    }

    public BaseSVG getRainbowSVG() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1508761662")) {
            return this.mRainbowSVG;
        }
        return (BaseSVG) ipChange.ipc$dispatch("-1508761662", new Object[]{this});
    }

    public Bitmap getRegionImageBitmap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1645884014")) {
            return this.mRegionImageBitmap;
        }
        return (Bitmap) ipChange.ipc$dispatch("1645884014", new Object[]{this});
    }

    public RegionImageStatus getRegionImageStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1538126378")) {
            return this.mLoadRegionImageStatus;
        }
        return (RegionImageStatus) ipChange.ipc$dispatch("-1538126378", new Object[]{this});
    }

    public String getRegionImageUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1300479004")) {
            return this.mRegionImageUrl;
        }
        return (String) ipChange.ipc$dispatch("-1300479004", new Object[]{this});
    }

    public BaseSVG getRegionSVG() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "411705282")) {
            return this.mRegionSVG;
        }
        return (BaseSVG) ipChange.ipc$dispatch("411705282", new Object[]{this});
    }

    public void setRainbowSVG(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220764276")) {
            ipChange.ipc$dispatch("-1220764276", new Object[]{this, baseSVG});
            return;
        }
        this.mRainbowSVG = baseSVG;
    }

    public void setRegionImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902133010")) {
            ipChange.ipc$dispatch("1902133010", new Object[]{this, bitmap});
            return;
        }
        this.mRegionImageBitmap = bitmap;
    }

    public void setRegionImageStatus(RegionImageStatus regionImageStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953952672")) {
            ipChange.ipc$dispatch("-953952672", new Object[]{this, regionImageStatus});
            return;
        }
        this.mLoadRegionImageStatus = regionImageStatus;
    }

    public void setRegionImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777250182")) {
            ipChange.ipc$dispatch("-777250182", new Object[]{this, str});
            return;
        }
        this.mRegionImageUrl = str;
    }

    public void setRegionSVG(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951492572")) {
            ipChange.ipc$dispatch("-1951492572", new Object[]{this, baseSVG});
            return;
        }
        this.mRegionSVG = baseSVG;
    }
}

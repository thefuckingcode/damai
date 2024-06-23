package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ImageData {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CODE_NET_ERROR = "svg_net_error";
    public static final String CODE_NET_LIMIT = "svg_net_limit";
    public static final String CODE_SVG_BUILD_FAIL = "svg_build_fail";
    public static final String CODE_SVG_NONE_CONTENT = "svg_text_content_empty";
    public static final String CODE_SVG_NONE_FLOOR = "svg_none_floor_id";
    private String errorCode;
    private String imageUrl;
    private final boolean isSuccess = true;
    private boolean isSvg = false;
    private Bitmap mJPG;
    private BaseSVG mSVG;

    public ImageData(String str, BaseSVG baseSVG) {
        this.imageUrl = str;
        this.mSVG = baseSVG;
    }

    public String getImageUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1713289529")) {
            return this.imageUrl;
        }
        return (String) ipChange.ipc$dispatch("1713289529", new Object[]{this});
    }

    public Bitmap getJPG() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "369379244")) {
            return this.mJPG;
        }
        return (Bitmap) ipChange.ipc$dispatch("369379244", new Object[]{this});
    }

    public BaseSVG getSVG() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "65848973")) {
            return this.mSVG;
        }
        return (BaseSVG) ipChange.ipc$dispatch("65848973", new Object[]{this});
    }

    public boolean isHasFloorId() {
        BaseSVG baseSVG;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395611622")) {
            return ((Boolean) ipChange.ipc$dispatch("395611622", new Object[]{this})).booleanValue();
        }
        if (!this.isSvg || (baseSVG = this.mSVG) == null || baseSVG.getSvgPaintData() == null || !this.mSVG.getSvgPaintData().hasFloorData()) {
            return false;
        }
        return true;
    }

    public boolean isSvg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-501644293")) {
            return this.isSvg;
        }
        return ((Boolean) ipChange.ipc$dispatch("-501644293", new Object[]{this})).booleanValue();
    }

    public ImageData(String str, Bitmap bitmap) {
        this.imageUrl = str;
        this.mJPG = bitmap;
    }
}

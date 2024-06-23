package cn.damai.commonbusiness.seatbiz.view.model;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import cn.damai.commonbusiness.seatbiz.view.render.a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class BaseSVG {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    private RectF bounds;
    protected PictureDrawable drawable = null;
    protected List<RegionBound> mRegionBounds;
    protected Picture picture;
    protected List<List<PointLocation>> regionLocationList;
    protected a svgPaintData;
    protected float svgScale = 1.0f;
    protected List<String> unrecognizedCommandList;

    @Deprecated
    public RectF getBounds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "783511658")) {
            return this.bounds;
        }
        return (RectF) ipChange.ipc$dispatch("783511658", new Object[]{this});
    }

    public PictureDrawable getDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216606870")) {
            return (PictureDrawable) ipChange.ipc$dispatch("216606870", new Object[]{this});
        }
        if (this.drawable == null) {
            this.drawable = new PictureDrawable(this.picture);
        }
        return this.drawable;
    }

    public Picture getPicture() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "30047985")) {
            return this.picture;
        }
        return (Picture) ipChange.ipc$dispatch("30047985", new Object[]{this});
    }

    public List<RegionBound> getRegionBounds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1142913762")) {
            return this.mRegionBounds;
        }
        return (List) ipChange.ipc$dispatch("-1142913762", new Object[]{this});
    }

    public List<List<PointLocation>> getRegionLocationMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1871554242")) {
            return this.regionLocationList;
        }
        return (List) ipChange.ipc$dispatch("1871554242", new Object[]{this});
    }

    public float getSVGScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "382712028")) {
            return this.svgScale;
        }
        return ((Float) ipChange.ipc$dispatch("382712028", new Object[]{this})).floatValue();
    }

    public a getSvgPaintData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-124682967")) {
            return this.svgPaintData;
        }
        return (a) ipChange.ipc$dispatch("-124682967", new Object[]{this});
    }

    public List<String> getUnrecognizedCommandList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-932929143")) {
            return this.unrecognizedCommandList;
        }
        return (List) ipChange.ipc$dispatch("-932929143", new Object[]{this});
    }

    public void setRegionLocationList(List<List<PointLocation>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565269328")) {
            ipChange.ipc$dispatch("-565269328", new Object[]{this, list});
            return;
        }
        this.regionLocationList = list;
    }

    public void setSVGScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110049440")) {
            ipChange.ipc$dispatch("-110049440", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.svgScale = f;
    }

    public void setSvgPaintData(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526933475")) {
            ipChange.ipc$dispatch("1526933475", new Object[]{this, aVar});
            return;
        }
        this.svgPaintData = aVar;
    }

    public void setUnrecognizedCommandList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584579579")) {
            ipChange.ipc$dispatch("1584579579", new Object[]{this, list});
            return;
        }
        this.unrecognizedCommandList = list;
    }
}

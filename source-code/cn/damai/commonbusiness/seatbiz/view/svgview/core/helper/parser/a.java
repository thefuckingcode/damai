package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPaintData;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class a extends BaseSVG {
    private static transient /* synthetic */ IpChange $ipChange;
    private float a = 1.0f;
    private final Picture b;
    private final RectF c;
    private List<List<PointLocation>> d;
    private List<String> e;
    private PictureDrawable f = null;
    private SVGPaintData g;
    private List<RegionBound> h;

    a(SVGPaintData sVGPaintData, List<List<PointLocation>> list, List<RegionBound> list2) {
        this.g = sVGPaintData;
        this.b = sVGPaintData.buildPicture();
        this.c = null;
        this.h = list2;
        this.d = list;
    }

    /* renamed from: a */
    public SVGPaintData getSvgPaintData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1674801530")) {
            return this.g;
        }
        return (SVGPaintData) ipChange.ipc$dispatch("1674801530", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public RectF getBounds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1299802032")) {
            return this.c;
        }
        return (RectF) ipChange.ipc$dispatch("1299802032", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public PictureDrawable getDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451189008")) {
            return (PictureDrawable) ipChange.ipc$dispatch("451189008", new Object[]{this});
        }
        if (this.f == null) {
            this.f = new PictureDrawable(this.b);
        }
        return this.f;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public Picture getPicture() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "558692843")) {
            return this.b;
        }
        return (Picture) ipChange.ipc$dispatch("558692843", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public List<RegionBound> getRegionBounds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-802712092")) {
            return this.h;
        }
        return (List) ipChange.ipc$dispatch("-802712092", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public List<List<PointLocation>> getRegionLocationMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1894768196")) {
            return this.d;
        }
        return (List) ipChange.ipc$dispatch("-1894768196", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public float getSVGScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-427884074")) {
            return this.a;
        }
        return ((Float) ipChange.ipc$dispatch("-427884074", new Object[]{this})).floatValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public List<String> getUnrecognizedCommandList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "528054531")) {
            return this.e;
        }
        return (List) ipChange.ipc$dispatch("528054531", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public void setRegionLocationList(List<List<PointLocation>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656298282")) {
            ipChange.ipc$dispatch("656298282", new Object[]{this, list});
            return;
        }
        this.d = list;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public void setSVGScale(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531275174")) {
            ipChange.ipc$dispatch("531275174", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        this.a = f2;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.model.BaseSVG
    public void setUnrecognizedCommandList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369566783")) {
            ipChange.ipc$dispatch("-369566783", new Object[]{this, list});
            return;
        }
        this.e = list;
    }
}

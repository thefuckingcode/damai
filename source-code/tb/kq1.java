package tb;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.render.a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import cn.damai.seat.bean.VenueImage;
import cn.damai.seat.support.combine.ICombiner;
import cn.damai.seat.support.combine.OnPicCombineListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class kq1 implements ICombiner {
    private static transient /* synthetic */ IpChange $ipChange;
    public final VenueImage a = new VenueImage();
    public final RegionData b;
    private final boolean c;
    private final lr d;
    private PriceInfo e;
    private Picture f;
    private PictureDrawable g;
    private List<List<PointLocation>> h;
    private List<RegionBound> i;
    private float j;
    private OnPicCombineListener k;

    public kq1(RegionData regionData, OnPicCombineListener onPicCombineListener) {
        lr lrVar = new lr();
        this.d = lrVar;
        this.j = 1.0f;
        this.b = regionData;
        this.c = lrVar.e(regionData);
        this.k = onPicCombineListener;
    }

    private i32 a(boolean z, @Nullable PriceLevel priceLevel) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173045697")) {
            return (i32) ipChange.ipc$dispatch("1173045697", new Object[]{this, Boolean.valueOf(z), priceLevel});
        }
        RegionData regionData = this.b;
        if (regionData == null || (regionInfo = regionData.ri) == null) {
            return new l40();
        }
        if (z) {
            return new ki1(priceLevel, this.e, regionInfo.regionList, regionInfo.standColorList, regionInfo.mRegionIdMatchList);
        }
        return new li1(priceLevel, this.e, regionInfo.regionList);
    }

    public Picture b(PriceLevel priceLevel) {
        BaseSVG baseSVG;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047006665")) {
            return (Picture) ipChange.ipc$dispatch("-1047006665", new Object[]{this, priceLevel});
        } else if (this.e == null) {
            return null;
        } else {
            if (this.c) {
                baseSVG = this.a.getRainBowSvg();
            } else {
                baseSVG = this.a.getRegionSvg();
            }
            if (baseSVG == null || baseSVG.getSvgPaintData() == null) {
                return null;
            }
            return baseSVG.getSvgPaintData().buildPicture(a(this.c, priceLevel));
        }
    }

    public void c(ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011119227")) {
            ipChange.ipc$dispatch("-2011119227", new Object[]{this, imageData});
        } else if (imageData != null) {
            String imageUrl = imageData.getImageUrl();
            if (imageUrl.equals(this.b.ri.rainbowSvgImg)) {
                this.a.setRainBowSvg(imageData.getSVG());
            } else if (imageUrl.equals(this.b.ri.seatSvgImg)) {
                this.a.setRegionSvg(imageData.getSVG());
            }
            combineIfNeed();
        }
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void combineIfNeed() {
        BaseSVG baseSVG;
        i32 i32;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757167779")) {
            ipChange.ipc$dispatch("-757167779", new Object[]{this});
        } else if (this.e != null) {
            if (this.c) {
                baseSVG = this.a.getRainBowSvg();
            } else {
                baseSVG = this.a.getRegionSvg();
            }
            BaseSVG regionSvg = this.a.getRegionSvg();
            if (regionSvg != null && regionSvg.getSvgPaintData() != null && baseSVG != null && baseSVG.getSvgPaintData() != null) {
                a svgPaintData = baseSVG.getSvgPaintData();
                a svgPaintData2 = regionSvg.getSvgPaintData();
                if (this.c) {
                    i32 = a(true, null);
                } else if (!this.d.f(this.b)) {
                    i32 = a(false, null);
                } else {
                    i32 = new zb2();
                }
                this.f = svgPaintData.buildPicture(i32);
                svgPaintData2.setRegionColorData(null);
                svgPaintData2.setRainbowColorData(null);
                this.g = new PictureDrawable(svgPaintData2.buildPicture(true));
                this.j = regionSvg.getSVGScale();
                this.h = regionSvg.getRegionLocationMap();
                List<RegionBound> regionBounds = regionSvg.getRegionBounds();
                this.i = regionBounds;
                if (this.k != null) {
                    this.k.onPicCombineFinish(new lq1(this.f, this.g, this.h, regionBounds, this.j));
                }
            }
        }
    }

    public void d(PriceInfo priceInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060478257")) {
            ipChange.ipc$dispatch("-2060478257", new Object[]{this, priceInfo});
            return;
        }
        this.e = priceInfo;
        combineIfNeed();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public boolean isPrepared() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1708914632")) {
            return (this.f == null || this.g == null) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1708914632", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void removeDynamic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440123668")) {
            ipChange.ipc$dispatch("1440123668", new Object[]{this});
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
    }
}

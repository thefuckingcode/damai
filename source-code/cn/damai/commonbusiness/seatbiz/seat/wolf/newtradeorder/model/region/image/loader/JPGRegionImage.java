package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.RegionImageLoader;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class JPGRegionImage implements IRegionImage {
    private static transient /* synthetic */ IpChange $ipChange;
    private IRegionImageCallback mRegionImageCallback;
    private RegionImageLoader mRegionImageLoader;

    public JPGRegionImage(RegionImageLoader regionImageLoader, IRegionImageCallback iRegionImageCallback) {
        this.mRegionImageLoader = regionImageLoader;
        this.mRegionImageCallback = iRegionImageCallback;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLoadRegionImageFailed(String str, RegionImageData.RegionImageStatus regionImageStatus, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440754178")) {
            ipChange.ipc$dispatch("-1440754178", new Object[]{this, str, regionImageStatus, str2});
            return;
        }
        RegionImageData regionImageData = new RegionImageData();
        regionImageData.setRegionImageUrl(str);
        regionImageData.setRegionImageStatus(regionImageStatus);
        regionImageData.failReason = "jpg:" + str2;
        this.mRegionImageCallback.onLoadRegionImageFailed(regionImageData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLoadRegionImageSuccess(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708166955")) {
            ipChange.ipc$dispatch("-708166955", new Object[]{this, str, bitmap});
            return;
        }
        RegionImageData regionImageData = new RegionImageData();
        regionImageData.setRegionImageUrl(str);
        regionImageData.setRegionImageStatus(RegionImageData.RegionImageStatus.SUCCESS);
        regionImageData.setRegionImageBitmap(bitmap);
        this.mRegionImageCallback.onLoadRegionImageSuccess(regionImageData);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImage
    public void loadRegionImage(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502472733")) {
            ipChange.ipc$dispatch("-502472733", new Object[]{this, str});
        } else if (this.mRegionImageCallback != null) {
            if (TextUtils.isEmpty(str)) {
                onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, "imgUrl=null");
            } else {
                a.b().c(str).n(new DMImageCreator.DMImageSuccListener() {
                    /* class cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.JPGRegionImage.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                    public void onSuccess(DMImageCreator.e eVar) {
                        Drawable drawable;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1266887595")) {
                            ipChange.ipc$dispatch("-1266887595", new Object[]{this, eVar});
                        } else if (eVar == null || (drawable = eVar.a) == null) {
                            JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, "ImageLoader_getDrawable_failed");
                        } else {
                            try {
                                JPGRegionImage.this.onLoadRegionImageSuccess(str, ((BitmapDrawable) drawable).getBitmap());
                            } catch (Exception e) {
                                e.printStackTrace();
                                JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, e.getMessage());
                            }
                        }
                    }
                }).e(new DMImageCreator.DMImageFailListener() {
                    /* class cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.JPGRegionImage.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                    public void onFail(DMImageCreator.d dVar) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2039876928")) {
                            ipChange.ipc$dispatch("-2039876928", new Object[]{this, dVar});
                            return;
                        }
                        String str = "ImageLoader_download_fail";
                        if (dVar != null) {
                            str = str + "resultCode=" + dVar.a;
                        }
                        JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, str);
                    }
                }).f();
            }
        }
    }
}

package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMark;
import com.youku.tinywindow.TinyWindowManager;
import java.util.Collection;

/* compiled from: Taobao */
public class WaterMarkContainer extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String TAG = "WaterMarkView";
    private Configuration mConfiguration;
    private int mCurrentPosition;

    public WaterMarkContainer(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean canShow(WaterMark waterMark) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020930054")) {
            return ((Boolean) ipChange.ipc$dispatch("1020930054", new Object[]{this, waterMark})).booleanValue();
        }
        if (TinyWindowManager.getInstance().isInTinyWindowMode()) {
            return false;
        }
        Configuration configuration = this.mConfiguration;
        if (configuration != null && (i = configuration.orientation) != 1) {
            return i == 2 && ((i2 = waterMark.displayMode) == 0 || i2 == 1);
        }
        if (getHeight() > getWidth()) {
            int i3 = waterMark.displayMode;
            if (i3 == 0 || i3 == 2) {
                return true;
            }
        } else {
            int i4 = waterMark.displayMode;
            if (i4 == 0 || i4 == 3) {
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290009765")) {
            ipChange.ipc$dispatch("290009765", new Object[]{this});
            return;
        }
        post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkContainer.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "438776582")) {
                    ipChange.ipc$dispatch("438776582", new Object[]{this});
                    return;
                }
                for (int i = 0; i < WaterMarkContainer.this.getChildCount(); i++) {
                    IWaterMarkView iWaterMarkView = (IWaterMarkView) WaterMarkContainer.this.getChildAt(i);
                    WaterMark waterMark = iWaterMarkView.getWaterMark();
                    if (WaterMarkContainer.this.canShow(waterMark)) {
                        WaterMark.DisplayDTOS displayDTOS = waterMark.getDisplayDTOS(WaterMarkContainer.this.mCurrentPosition);
                        if (displayDTOS != null) {
                            iWaterMarkView.updateDisplayDTOS(displayDTOS);
                            iWaterMarkView.show();
                        }
                    } else {
                        iWaterMarkView.hide();
                    }
                    iWaterMarkView.requestLayout();
                }
            }
        });
    }

    public void bindData(final Collection<WaterMark> collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246877324")) {
            ipChange.ipc$dispatch("-246877324", new Object[]{this, collection});
            return;
        }
        post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkContainer.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.widget.TextView, com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkTextView, android.view.View] */
            /* JADX WARN: Type inference failed for: r2v11, types: [android.widget.FrameLayout, com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkContainer] */
            /* JADX WARNING: Unknown variable types count: 2 */
            public void run() {
                WaterMarkImageView waterMarkImageView;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "831803592")) {
                    ipChange.ipc$dispatch("831803592", new Object[]{this});
                    return;
                }
                if (WaterMarkContainer.this.getChildCount() > 0) {
                    WaterMarkContainer.this.removeAllViews();
                }
                for (WaterMark waterMark : collection) {
                    WaterMark.DisplayDTOS displayDTOS = waterMark.getDisplayDTOS(WaterMarkContainer.this.mCurrentPosition);
                    if (displayDTOS != null) {
                        if (waterMark.rsType == 1) {
                            ?? waterMarkTextView = new WaterMarkTextView(WaterMarkContainer.this.getContext(), waterMark, displayDTOS);
                            waterMarkTextView.setContentDescription("displayMode=" + waterMark.displayMode);
                            WaterMarkContainer.this.addView(waterMarkTextView);
                            waterMarkImageView = waterMarkTextView;
                        } else {
                            WaterMarkImageView waterMarkImageView2 = new WaterMarkImageView(WaterMarkContainer.this.getContext(), waterMark, displayDTOS);
                            waterMarkImageView2.setContentDescription("displayMode=" + waterMark.displayMode);
                            waterMarkImageView2.setImageUrl(waterMark.rsUrl);
                            WaterMarkContainer.this.addView(waterMarkImageView2);
                            waterMarkImageView = waterMarkImageView2;
                        }
                        if (WaterMarkContainer.this.canShow(waterMark)) {
                            waterMarkImageView.show();
                        } else {
                            waterMarkImageView.hide();
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441898205")) {
            ipChange.ipc$dispatch("-1441898205", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        this.mConfiguration = configuration;
        refresh();
    }

    public void onSizeChanged(final int i, final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909010452")) {
            ipChange.ipc$dispatch("-1909010452", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkContainer.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "242263077")) {
                    ipChange.ipc$dispatch("242263077", new Object[]{this});
                    return;
                }
                WaterMarkContainer.this.getLayoutParams().width = i;
                WaterMarkContainer.this.getLayoutParams().height = i2;
                WaterMarkContainer.this.requestLayout();
            }
        });
    }

    public void updateCurrentPosition(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777657828")) {
            ipChange.ipc$dispatch("-1777657828", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkContainer.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "635290087")) {
                    ipChange.ipc$dispatch("635290087", new Object[]{this});
                    return;
                }
                WaterMarkContainer.this.mCurrentPosition = i;
                WaterMarkContainer.this.refresh();
            }
        });
    }
}

package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.util.TypedValue;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.liveservice.bean.WaterMarkV2;
import com.youku.upsplayer.module.Watermark;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WaterMark {
    private static transient /* synthetic */ IpChange $ipChange;
    public float alpha;
    public int autoScale;
    public List<DisplayDTOS> displayDTOS = new ArrayList();
    public int displayMode;
    public int refCoord;
    public int refWnd;
    public int rsType;
    public String rsUrl;
    public String text;
    public String textColor;
    public int textSize;
    public int type;

    /* compiled from: Taobao */
    public class DisplayDTOS {
        public int duration;
        public int height;
        public float posX;
        public float posY;
        public int start;
        public int width;

        public DisplayDTOS() {
        }
    }

    /* compiled from: Taobao */
    public final class DisplayMode {
        public static final int ALL = 0;
        public static final int HORIZONTAL = 1;
        public static final int SMALL = 3;
        public static final int VERTICAL = 2;

        public DisplayMode() {
        }
    }

    /* compiled from: Taobao */
    public final class RefCoord {
        public static final int LEFT_BOTTOM = 3;
        public static final int LEFT_TOP = 0;
        public static final int RIGHT_BOTTOM = 2;
        public static final int RIGHT_TOP = 1;

        public RefCoord() {
        }
    }

    /* compiled from: Taobao */
    public final class ResType {
        public static final int PIC = 2;
        public static final int TEXT = 1;
        public static final int WATERMARK = 0;

        public ResType() {
        }
    }

    public WaterMark(WaterMarkV2 waterMarkV2) {
        this.textColor = waterMarkV2.getTextColor();
        this.type = (int) waterMarkV2.getType();
        this.text = waterMarkV2.getText();
        this.refWnd = (int) waterMarkV2.getRefWnd();
        this.rsUrl = waterMarkV2.getRsUrl();
        this.displayMode = waterMarkV2.getDisplay_mode();
        this.refCoord = waterMarkV2.getRefCoord();
        this.alpha = waterMarkV2.getAlpha();
        this.autoScale = waterMarkV2.getAutoScale();
        this.rsType = (int) waterMarkV2.getRsType();
        for (WaterMarkV2.displayDTOS displaydtos : waterMarkV2.getDisplayDTOS()) {
            DisplayDTOS displayDTOS2 = new DisplayDTOS();
            displayDTOS2.posY = displaydtos.posY;
            displayDTOS2.posX = displaydtos.posX;
            displayDTOS2.height = (int) displaydtos.height;
            displayDTOS2.width = (int) displaydtos.width;
            displayDTOS2.duration = (int) displaydtos.duration;
            displayDTOS2.start = (int) displaydtos.start;
            this.displayDTOS.add(displayDTOS2);
        }
    }

    private int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-214012667")) {
            return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("-214012667", new Object[]{this, context, Float.valueOf(f)})).intValue();
    }

    public DisplayDTOS getDisplayDTOS(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662898931")) {
            return (DisplayDTOS) ipChange.ipc$dispatch("-1662898931", new Object[]{this, Integer.valueOf(i)});
        }
        DisplayDTOS displayDTOS2 = null;
        if (this.displayDTOS != null) {
            for (int i2 = 0; i2 < this.displayDTOS.size(); i2++) {
                DisplayDTOS displayDTOS3 = this.displayDTOS.get(i2);
                int i3 = displayDTOS3.start;
                if (i >= i3 && displayDTOS3.duration == 0) {
                    return displayDTOS3;
                }
                int i4 = displayDTOS3.duration + i3;
                if (i >= i3 && i <= i4) {
                    displayDTOS2 = displayDTOS3;
                }
            }
        }
        return displayDTOS2;
    }

    public WaterMark(Context context, Watermark watermark) {
        this.textColor = watermark.textColor;
        this.type = watermark.type;
        this.text = watermark.text;
        this.rsUrl = watermark.rsUrl;
        this.displayMode = watermark.displayMode;
        this.refCoord = watermark.refCoord;
        this.alpha = watermark.alpha;
        this.autoScale = watermark.autoScale;
        this.rsType = watermark.rsType;
        com.youku.upsplayer.module.DisplayDTOS[] displayDTOSArr = watermark.displayDTOS;
        for (com.youku.upsplayer.module.DisplayDTOS displayDTOS2 : displayDTOSArr) {
            DisplayDTOS displayDTOS3 = new DisplayDTOS();
            displayDTOS3.posY = displayDTOS2.posY;
            displayDTOS3.posX = displayDTOS2.posX;
            displayDTOS3.height = dip2px(context, (float) displayDTOS2.height);
            displayDTOS3.width = dip2px(context, (float) displayDTOS2.width);
            displayDTOS3.duration = displayDTOS2.duration;
            displayDTOS3.start = displayDTOS2.start;
            this.displayDTOS.add(displayDTOS3);
        }
    }
}

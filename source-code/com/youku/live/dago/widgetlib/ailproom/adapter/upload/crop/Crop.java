package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class Crop {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CROP = 6709;
    public static final int REQUEST_PICK = 9162;
    public static final int RESULT_ERROR = 404;
    private Intent cropIntent;

    /* compiled from: Taobao */
    public interface Extra {
        public static final String ASPECT_X = "aspect_x";
        public static final String ASPECT_Y = "aspect_y";
        public static final String ERROR = "error";
        public static final String OUTPUT_X = "output_x";
        public static final String OUTPUT_Y = "output_y";
    }

    private Crop(Uri uri, Uri uri2) {
        Intent intent = new Intent();
        this.cropIntent = intent;
        intent.setData(uri);
        this.cropIntent.putExtra("output", uri2);
    }

    public static int getAspectX(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "937309108")) {
            return bundle.getInt("aspect_x");
        }
        return ((Integer) ipChange.ipc$dispatch("937309108", new Object[]{bundle})).intValue();
    }

    public static int getAspectY(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2112893707")) {
            return bundle.getInt("aspect_y");
        }
        return ((Integer) ipChange.ipc$dispatch("-2112893707", new Object[]{bundle})).intValue();
    }

    public static Throwable getError(Intent intent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "620424525")) {
            return (Throwable) intent.getSerializableExtra("error");
        }
        return (Throwable) ipChange.ipc$dispatch("620424525", new Object[]{intent});
    }

    public static int getOutputX(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1595997973")) {
            return bundle.getInt(Extra.OUTPUT_X);
        }
        return ((Integer) ipChange.ipc$dispatch("-1595997973", new Object[]{bundle})).intValue();
    }

    public static int getOutputY(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-351233492")) {
            return bundle.getInt(Extra.OUTPUT_Y);
        }
        return ((Integer) ipChange.ipc$dispatch("-351233492", new Object[]{bundle})).intValue();
    }

    public static Uri getSaveUri(Intent intent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1134579480")) {
            return (Uri) intent.getParcelableExtra("output");
        }
        return (Uri) ipChange.ipc$dispatch("1134579480", new Object[]{intent});
    }

    public static Uri getSourceUri(Intent intent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "558373302")) {
            return intent.getData();
        }
        return (Uri) ipChange.ipc$dispatch("558373302", new Object[]{intent});
    }

    public static Crop of(Uri uri, Uri uri2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2003324329")) {
            return new Crop(uri, uri2);
        }
        return (Crop) ipChange.ipc$dispatch("-2003324329", new Object[]{uri, uri2});
    }

    public Crop asSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734313505")) {
            return (Crop) ipChange.ipc$dispatch("-1734313505", new Object[]{this});
        }
        this.cropIntent.putExtra("aspect_x", 1);
        this.cropIntent.putExtra("aspect_y", 1);
        return this;
    }

    public Intent getIntent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "126114008")) {
            return this.cropIntent;
        }
        return (Intent) ipChange.ipc$dispatch("126114008", new Object[]{this});
    }

    public Crop withAspect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116898640")) {
            return (Crop) ipChange.ipc$dispatch("1116898640", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.cropIntent.putExtra("aspect_x", i);
        this.cropIntent.putExtra("aspect_y", i2);
        return this;
    }

    public Crop withOutputSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590353338")) {
            return (Crop) ipChange.ipc$dispatch("-1590353338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.cropIntent.putExtra(Extra.OUTPUT_X, i);
        this.cropIntent.putExtra(Extra.OUTPUT_Y, i2);
        return this;
    }
}

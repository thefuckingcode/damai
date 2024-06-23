package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import tb.qg0;
import tb.tp1;
import tb.ug2;

/* compiled from: Taobao */
public class DagoLikeEffectViewUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean isBitmapLoadDone = false;
    private static List<Bitmap> sBitmaps = new ArrayList();

    public static DagoLikeEffectView addDagoLikeEffectView(ViewGroup viewGroup, DagoLikeEffectParams dagoLikeEffectParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1742935305")) {
            return new DagoLikeEffectView(viewGroup, dagoLikeEffectParams);
        }
        return (DagoLikeEffectView) ipChange.ipc$dispatch("1742935305", new Object[]{viewGroup, dagoLikeEffectParams});
    }

    public static Bitmap getRandomDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365070473")) {
            return (Bitmap) ipChange.ipc$dispatch("365070473", new Object[0]);
        }
        List<Bitmap> list = sBitmaps;
        if (list == null || list.isEmpty()) {
            return BitmapFactory.decodeResource(UIUtil.getResources(), new int[]{R.drawable.dago_pgc_ic_heart0, R.drawable.dago_pgc_ic_heart1, R.drawable.dago_pgc_ic_heart2, R.drawable.dago_pgc_ic_heart3, R.drawable.dago_pgc_ic_heart4, R.drawable.dago_pgc_ic_heart5}[random(5)]);
        }
        List<Bitmap> list2 = sBitmaps;
        return list2.get(random(list2.size()));
    }

    public static int[] getRandomPos() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1433566473")) {
            return (int[]) ipChange.ipc$dispatch("-1433566473", new Object[0]);
        }
        DisplayMetrics displayMetrics = UIUtil.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / 2;
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) / 2;
        return new int[]{i + random(i), i2 + random(i2)};
    }

    private static int random(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001266609")) {
            return ((Integer) ipChange.ipc$dispatch("2001266609", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (i != 0 && Build.VERSION.SDK_INT >= 21) {
            return ThreadLocalRandom.current().nextInt(i);
        } else {
            return 0;
        }
    }

    public static void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369784923")) {
            ipChange.ipc$dispatch("369784923", new Object[0]);
            return;
        }
        isBitmapLoadDone = false;
        List<Bitmap> list = sBitmaps;
        if (list != null) {
            list.clear();
            sBitmaps = null;
        }
    }

    public static void setLikeViewSrc(String str, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741977577")) {
            ipChange.ipc$dispatch("-1741977577", new Object[]{str, Integer.valueOf(i)});
        } else if (!isBitmapLoadDone) {
            tp1.o().s(str).Q(new IPhenixListener<ug2>() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectViewUtils.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public boolean onHappen(ug2 ug2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "577875425")) {
                        return ((Boolean) ipChange.ipc$dispatch("577875425", new Object[]{this, ug2})).booleanValue();
                    }
                    if (ug2.f() != null && !ug2.i()) {
                        if (DagoLikeEffectViewUtils.sBitmaps != null) {
                            DagoLikeEffectViewUtils.sBitmaps.clear();
                        }
                        List unused = DagoLikeEffectViewUtils.sBitmaps = DagoLikeEffectViewUtils.split(ug2.f().getBitmap(), i);
                        boolean unused2 = DagoLikeEffectViewUtils.isBitmapLoadDone = true;
                    }
                    return true;
                }
            }).m(new IPhenixListener<qg0>() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectViewUtils.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public boolean onHappen(qg0 qg0) {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-1854920388")) {
                        return false;
                    }
                    return ((Boolean) ipChange.ipc$dispatch("-1854920388", new Object[]{this, qg0})).booleanValue();
                }
            }).n();
        }
    }

    /* access modifiers changed from: private */
    public static List<Bitmap> split(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92677014")) {
            return (List) ipChange.ipc$dispatch("-92677014", new Object[]{bitmap, Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width / i;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Bitmap.createBitmap(bitmap, i3 * i, 0, i, height));
        }
        return arrayList;
    }
}

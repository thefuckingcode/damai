package cn.damai.commonbusiness.qrcode.util;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import cn.damai.common.askpermission.OnGrantListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.zxing.WriterException;
import java.util.Hashtable;
import tb.dw1;
import tb.ge0;
import tb.hp1;
import tb.lp1;
import tb.od0;
import tb.rd0;
import tb.t9;
import tb.vb;
import tb.vd;

/* compiled from: Taobao */
public class QrcodeUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CODE_SCAN_GALLERY = 1000;

    /* compiled from: Taobao */
    public interface OnQRcodeCreateListener {
        void onFailure();

        void onSuccess(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    public class a implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1361147833")) {
                ipChange.ipc$dispatch("-1361147833", new Object[]{this});
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            this.a.startActivityForResult(intent, 1000);
        }
    }

    public static Bitmap a(int i, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "592886025")) {
            return e(str, i);
        }
        return (Bitmap) ipChange.ipc$dispatch("592886025", new Object[]{Integer.valueOf(i), str});
    }

    public static Bitmap b(int i, String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1166019393")) {
            return e(str, i);
        }
        return (Bitmap) ipChange.ipc$dispatch("1166019393", new Object[]{Integer.valueOf(i), str, bitmap});
    }

    public static void c(int i, String str, OnQRcodeCreateListener onQRcodeCreateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099543910")) {
            ipChange.ipc$dispatch("-2099543910", new Object[]{Integer.valueOf(i), str, onQRcodeCreateListener});
            return;
        }
        Bitmap e = e(str, i);
        if (e != null) {
            if (onQRcodeCreateListener != null) {
                onQRcodeCreateListener.onSuccess(e);
            }
        } else if (onQRcodeCreateListener != null) {
            onQRcodeCreateListener.onFailure();
        }
    }

    private static vb d(String str, t9 t9Var, int i, int i2, Hashtable hashtable) throws WriterException {
        ge0 ge0;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272319068")) {
            return (vb) ipChange.ipc$dispatch("1272319068", new Object[]{str, t9Var, Integer.valueOf(i), Integer.valueOf(i2), hashtable});
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (t9Var != t9.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + t9Var);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            ge0 ge02 = ge0.L;
            if (!(hashtable == null || (ge0 = (ge0) hashtable.get(od0.ERROR_CORRECTION)) == null)) {
                ge02 = ge0;
            }
            dw1 dw1 = new dw1();
            rd0.l(str, ge02, hashtable, dw1);
            return h(dw1, i, i2);
        }
    }

    private static Bitmap e(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715089434")) {
            return (Bitmap) ipChange.ipc$dispatch("715089434", new Object[]{str, Integer.valueOf(i)});
        }
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(od0.CHARACTER_SET, "utf-8");
            vb d = d(str, t9.QR_CODE, i, i, hashtable);
            int c = d.c();
            int b = d.b();
            int[] iArr = new int[(c * b)];
            for (int i2 = 0; i2 < b; i2++) {
                for (int i3 = 0; i3 < c; i3++) {
                    if (d.a(i3, i2)) {
                        iArr[(i2 * c) + i3] = -16777216;
                    } else {
                        iArr[(i2 * c) + i3] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, c, 0, 0, c, b);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(Activity activity, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241062308")) {
            return (String) ipChange.ipc$dispatch("-241062308", new Object[]{activity, uri});
        }
        Cursor query = activity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    public static void g(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503026282")) {
            ipChange.ipc$dispatch("-1503026282", new Object[]{activity});
            return;
        }
        hp1.b(activity, false, lp1.STORAGE, "才能添加图片～", new a(activity));
    }

    private static vb h(dw1 dw1, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582362533")) {
            return (vb) ipChange.ipc$dispatch("-582362533", new Object[]{dw1, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        vd c = dw1.c();
        int e = c.e();
        int d = c.d();
        int max = Math.max(i, e);
        int max2 = Math.max(i2, d);
        int min = Math.min(max / e, max2 / d);
        int i3 = (max - (e * min)) / 2;
        int i4 = (max2 - (d * min)) / 2;
        vb vbVar = new vb(max, max2);
        int i5 = 0;
        while (i5 < d) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < e) {
                if (c.b(i7, i5) == 1) {
                    vbVar.d(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return vbVar;
    }
}

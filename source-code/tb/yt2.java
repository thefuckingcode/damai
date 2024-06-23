package tb;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.R$string;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
public class yt2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ boolean b;

        a(Activity activity, boolean z) {
            this.a = activity;
            this.b = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "30836271")) {
                ipChange.ipc$dispatch("30836271", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://tfs.alipayobjects.com/L1/71/100/and/alipay_wap_main.apk"));
            this.a.startActivity(intent);
            dialogInterface.dismiss();
            if (this.b) {
                this.a.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ Activity b;

        b(boolean z, Activity activity) {
            this.a = z;
            this.b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1000417294")) {
                ipChange.ipc$dispatch("1000417294", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            if (this.a) {
                this.b.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ boolean b;

        c(Activity activity, boolean z) {
            this.a = activity;
            this.b = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1969998317")) {
                ipChange.ipc$dispatch("1969998317", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://weixin.qq.com/cgi-bin/download302?check=false&uin=&stype=&promote=&fr=&lang=zh_CN&ADTAG=&url=android16"));
            this.a.startActivity(intent);
            dialogInterface.dismiss();
            if (this.b) {
                this.a.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ Activity b;

        d(boolean z, Activity activity) {
            this.a = z;
            this.b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1355387956")) {
                ipChange.ipc$dispatch("-1355387956", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            if (this.a) {
                this.b.finish();
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370455312")) {
            return ((Boolean) ipChange.ipc$dispatch("370455312", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        } else if (APAPIFactory.createZFBApi(xs0.a(), "2015092200310865", false).isZFBAppInstalled()) {
            return true;
        } else {
            DMDialog dMDialog = new DMDialog(activity);
            dMDialog.v(bk2.b(activity, R$string.data_string_007));
            dMDialog.q(bk2.b(activity, R$string.data_string_045));
            dMDialog.n(bk2.b(activity, R$string.Ensure), new a(activity, z));
            dMDialog.i(bk2.b(activity, R$string.Cancel), new b(z, activity));
            dMDialog.show();
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480734087")) {
            return ((Boolean) ipChange.ipc$dispatch("480734087", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        } else if (activity.getPackageManager().getLaunchIntentForPackage("com.tencent.mm") != null) {
            return true;
        } else {
            DMDialog dMDialog = new DMDialog(activity);
            dMDialog.v(bk2.b(activity, R$string.data_string_007));
            dMDialog.q(bk2.b(activity, R$string.data_string_008));
            dMDialog.n(bk2.b(activity, R$string.Ensure), new c(activity, z));
            dMDialog.i(bk2.b(activity, R$string.Cancel), new d(z, activity));
            dMDialog.show();
            return false;
        }
    }

    public static Bitmap c(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-348420552")) {
            return d(context, str, null);
        }
        return (Bitmap) ipChange.ipc$dispatch("-348420552", new Object[]{context, str});
    }

    public static Bitmap d(@NonNull Context context, String str, BitmapFactory.Options options) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057767318")) {
            return (Bitmap) ipChange.ipc$dispatch("2057767318", new Object[]{context, str, options});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            if (!i(context, str)) {
                return BitmapFactory.decodeFile(str, options);
            }
            Uri parse = Uri.parse(str);
            if (!"content".equals(parse.getScheme())) {
                parse = e(context, str);
            }
            if (parse == null) {
                return null;
            }
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, UploadQueueMgr.MSGTYPE_REALTIME);
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                openFileDescriptor.close();
                return decodeFileDescriptor;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static Uri e(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246323263")) {
            return (Uri) ipChange.ipc$dispatch("1246323263", new Object[]{context, str});
        }
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex("_id"));
            query.close();
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i);
        } else if (!new File(str).exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1030953166")) {
            return BitmapFactory.decodeStream(new ByteArrayInputStream(h(bitmap, i)), null, null);
        }
        return (Bitmap) ipChange.ipc$dispatch("1030953166", new Object[]{bitmap, Integer.valueOf(i)});
    }

    public static byte[] g(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940359641")) {
            return (byte[]) ipChange.ipc$dispatch("-940359641", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap == null) {
            return null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            int i3 = i - 10;
            return (i3 > 0 && byteArray.length >= i2) ? g(bitmap, i3, i2) : byteArray;
        }
    }

    public static byte[] h(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "970791592")) {
            return (byte[]) ipChange.ipc$dispatch("970791592", new Object[]{bitmap, Integer.valueOf(i)});
        } else if (bitmap == null) {
            return null;
        } else {
            return g(Bitmap.createScaledBitmap(bitmap, 200, (bitmap.getHeight() * 200) / bitmap.getWidth(), true), 80, i);
        }
    }

    public static boolean i(@NonNull Context context, @NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48661710")) {
            return ((Boolean) ipChange.ipc$dispatch("-48661710", new Object[]{context, str})).booleanValue();
        } else if (Build.VERSION.SDK_INT < 29 || str.substring(0, str.lastIndexOf("/")).contains(context.getPackageName())) {
            return false;
        } else {
            return true;
        }
    }

    public static Bitmap j(Bitmap bitmap, double d2, double d3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885748300")) {
            return (Bitmap) ipChange.ipc$dispatch("1885748300", new Object[]{bitmap, Double.valueOf(d2), Double.valueOf(d3)});
        }
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d2) / width, ((float) d3) / height);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }
}

package cn.damai.commonbusiness.photoselect.imageselected.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fe;
import tb.g01;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class ImageTask2 extends AsyncTask<String, Void, Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Listener a;
    private ImageView b;
    private boolean c;

    /* compiled from: Taobao */
    public interface Listener {
        void onSuccess(ImageView imageView, Bitmap bitmap);
    }

    public ImageTask2(Context context, boolean z, ImageView imageView, Listener listener) {
        this.a = listener;
        this.c = z;
        this.b = imageView;
    }

    private static Bitmap b(boolean z, String str) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345638207")) {
            return (Bitmap) ipChange.ipc$dispatch("345638207", new Object[]{Boolean.valueOf(z), str});
        }
        if (z) {
            try {
                bitmap = g01.d(str, 400, 400);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            bitmap = g01.d(str, 800, 1300);
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1998701619")) {
            return (Bitmap) ipChange.ipc$dispatch("1998701619", new Object[]{this, strArr});
        }
        Bitmap b2 = b(this.c, strArr[0]);
        if (b2 != null) {
            fe.a.put(strArr[0], b2);
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077815326")) {
            ipChange.ipc$dispatch("-1077815326", new Object[]{this, bitmap});
            return;
        }
        super.onPostExecute(bitmap);
        this.a.onSuccess(this.b, bitmap);
    }
}

package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.util.DMRGBUtil;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
public class pq implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    int a;
    int b;
    int c;
    int d;
    boolean e;

    public pq(Context context, boolean z, boolean z2) {
        this.e = z;
        this.a = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (ScreenUtil.dip2px(context, 21.0f) * 2);
        this.d = ScreenUtil.dip2px(context, 12.0f);
        if (z2) {
            this.b = ScreenUtil.dip2px(context, 136.0f);
        } else {
            this.b = ScreenUtil.dip2px(context, 112.0f);
        }
        if (z) {
            this.c = ScreenUtil.dip2px(context, 150.0f);
        } else {
            this.c = ScreenUtil.dip2px(context, 180.0f);
        }
    }

    public static int a(float f, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1110499063")) {
            return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
        }
        return ((Integer) ipChange.ipc$dispatch("1110499063", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1614214981")) {
            return "id";
        }
        return (String) ipChange.ipc$dispatch("1614214981", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        int i;
        LinearGradient linearGradient;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228817566")) {
            return (Bitmap) ipChange.ipc$dispatch("-228817566", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        Bitmap bitmap2 = bitmapSupplier.get(this.a, this.b, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) this.c) / ((float) width);
        float f2 = (float) height;
        int i2 = (int) (f2 * f);
        int i3 = this.b;
        if (i2 > i3) {
            i = (int) ((f2 - (((float) i3) / f)) / 2.0f);
            height -= i;
        } else {
            i = 0;
        }
        Paint paint = new Paint(1);
        int f3 = DMRGBUtil.f(bitmap);
        paint.setColor(f3);
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.a, (float) this.b);
        int i4 = this.d;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setFilterBitmap(true);
        Rect rect = new Rect(0, i, width, height);
        int i5 = this.a;
        canvas.drawBitmap(bitmap, rect, new Rect(i5 - this.c, 0, i5, this.b), paint);
        int i6 = this.a;
        float f4 = ((float) (i6 - this.c)) / ((float) i6);
        if (this.e) {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) this.a, 0.0f, new int[]{f3, f3, a(0.4f, f3)}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) this.a, 0.0f, new int[]{f3, f3, a(0.3f, f3)}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP);
        }
        paint.setXfermode(null);
        paint.setShader(linearGradient);
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.a, (float) this.b);
        int i7 = this.d;
        canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint);
        return bitmap2;
    }
}

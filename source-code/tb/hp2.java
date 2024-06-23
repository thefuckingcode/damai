package tb;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.collection.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class hp2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LruCache<String, Typeface> b = new LruCache<>(5);
    private Typeface a;

    public hp2(Context context, String str) {
        Typeface typeface = b.get(str);
        this.a = typeface;
        if (typeface == null) {
            Typeface createFromAsset = Typeface.createFromAsset(context.getApplicationContext().getAssets(), String.format("%s", str));
            this.a = createFromAsset;
            b.put(str, createFromAsset);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315972170")) {
            ipChange.ipc$dispatch("-1315972170", new Object[]{this, textPaint});
            return;
        }
        textPaint.setTypeface(this.a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898413300")) {
            ipChange.ipc$dispatch("1898413300", new Object[]{this, textPaint});
            return;
        }
        textPaint.setTypeface(this.a);
    }
}

package com.alient.onearch.adapter.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/util/DisplayUtil;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "dpValue", "dp2px", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DisplayUtil {
    @NotNull
    public static final DisplayUtil INSTANCE = new DisplayUtil();

    private DisplayUtil() {
    }

    public final float dp2px(@NotNull Context context, float f) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            Resources resources = context.getResources();
            k21.h(resources, "context.resources");
            return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }
}

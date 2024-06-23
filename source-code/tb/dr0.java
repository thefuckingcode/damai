package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alibaba.gaiax.render.view.basic.GXProgressView;
import com.alibaba.gaiax.render.view.basic.GXRichText;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXGridView;
import com.alibaba.gaiax.render.view.container.GXScrollView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class dr0 {
    @NotNull
    public static final dr0 INSTANCE = new dr0();
    @NotNull
    private static final Map<String, Class<?>> a;
    @NotNull
    private static final Map<String, Function1<Context, View>> b = new LinkedHashMap();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("gaia-template", GXView.class);
        linkedHashMap.put("view", GXView.class);
        linkedHashMap.put("text", GXText.class);
        linkedHashMap.put(WXBasicComponentType.RICHTEXT, GXRichText.class);
        linkedHashMap.put("image", GXImageView.class);
        linkedHashMap.put("scroll", GXScrollView.class);
        linkedHashMap.put("grid", GXGridView.class);
        linkedHashMap.put("iconfont", GXIconFont.class);
        linkedHashMap.put("shadow", GXShadowLayout.class);
        linkedHashMap.put("slider", GXSliderView.class);
        linkedHashMap.put("progress", GXProgressView.class);
    }

    private dr0() {
    }

    public static /* synthetic */ View b(dr0 dr0, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return dr0.a(context, str, str2);
    }

    private final <T extends View> T d(Class<?> cls, Context context) {
        if (cls == null) {
            return null;
        }
        Object newInstance = cls.getConstructor(Context.class).newInstance(context);
        Objects.requireNonNull(newInstance, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.newInstance");
        return (T) ((View) newInstance);
    }

    private final <T extends View> View e(String str, Context context) {
        if (str == null) {
            return new GXView(context);
        }
        Object newInstance = Class.forName(str).getConstructor(Context.class).newInstance(context);
        Objects.requireNonNull(newInstance, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.newInstance");
        return (View) newInstance;
    }

    @NotNull
    public final <T extends View> T a(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        T t;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "type");
        if (!k21.d("custom", str) || str2 == null) {
            Map<String, Class<?>> map = a;
            if (map.containsKey(str)) {
                t = (T) d(map.get(str), context);
            } else {
                Function1<Context, View> function1 = b.get(str);
                t = function1 == null ? null : (T) function1.invoke(context);
            }
        } else {
            t = (T) e(str2, context);
        }
        Objects.requireNonNull(t, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.createView");
        return t;
    }

    @NotNull
    public final Map<String, Class<?>> c() {
        return a;
    }
}

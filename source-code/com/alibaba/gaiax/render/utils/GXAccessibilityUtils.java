package com.alibaba.gaiax.render.utils;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class GXAccessibilityUtils {
    @NotNull
    public static final GXAccessibilityUtils INSTANCE = new GXAccessibilityUtils();

    private GXAccessibilityUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041 A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0042 A[Catch:{ Exception -> 0x0054 }] */
    public final void a(@NotNull View view, @Nullable JSONObject jSONObject) {
        String str;
        k21.i(view, "view");
        boolean z = false;
        if (jSONObject == null) {
            str = null;
        } else {
            try {
                str = jSONObject.getString("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                if (d != null && !d.isPreventAccessibilityThrowException()) {
                    z = true;
                }
                if (z) {
                    throw e;
                }
                return;
            }
        }
        int i = 2;
        if (str != null) {
            if (str.length() > 0) {
                view.setContentDescription(str);
                view.setImportantForAccessibility(1);
                if (jSONObject == null) {
                    Boolean bool = jSONObject.getBoolean("accessibilityEnable");
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            i = 1;
                        }
                        view.setImportantForAccessibility(i);
                    }
                }
                if (jSONObject == null) {
                    String string = jSONObject.getString("accessibilityTraits");
                    if (string != null) {
                        ViewCompat.setAccessibilityDelegate(view, new GXAccessibilityUtils$accessibilityOfImage$2$1(string));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        view.setImportantForAccessibility(2);
        if (jSONObject == null) {
        }
        if (jSONObject == null) {
        }
    }

    public final void b(@NotNull View view, @Nullable JSONObject jSONObject, @NotNull CharSequence charSequence) {
        Object obj;
        k21.i(view, "view");
        k21.i(charSequence, "content");
        boolean z = false;
        if (jSONObject == null) {
            obj = null;
        } else {
            try {
                obj = jSONObject.get("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                if (d != null && !d.isPreventAccessibilityThrowException()) {
                    z = true;
                }
                if (z) {
                    throw e;
                }
                return;
            }
        }
        String str = obj instanceof String ? (String) obj : null;
        int i = 2;
        if (str == null || !(!o.y(str))) {
            view.setContentDescription(null);
            if (charSequence.length() > 0) {
                view.setImportantForAccessibility(1);
            } else {
                view.setImportantForAccessibility(2);
            }
        } else {
            view.setContentDescription(str);
            view.setImportantForAccessibility(1);
        }
        if (jSONObject != null) {
            Boolean bool = jSONObject.getBoolean("accessibilityEnable");
            if (bool != null) {
                if (bool.booleanValue()) {
                    i = 1;
                }
                view.setImportantForAccessibility(i);
            }
        }
        if (jSONObject != null) {
            String string = jSONObject.getString("accessibilityTraits");
            if (string != null) {
                ViewCompat.setAccessibilityDelegate(view, new GXAccessibilityUtils$accessibilityOfText$2$1(string));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041 A[Catch:{ Exception -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0042 A[Catch:{ Exception -> 0x0054 }] */
    public final void c(@NotNull View view, @Nullable JSONObject jSONObject) {
        String str;
        k21.i(view, "view");
        boolean z = false;
        if (jSONObject == null) {
            str = null;
        } else {
            try {
                str = jSONObject.getString("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                if (d != null && !d.isPreventAccessibilityThrowException()) {
                    z = true;
                }
                if (z) {
                    throw e;
                }
                return;
            }
        }
        int i = 2;
        if (str != null) {
            if (str.length() > 0) {
                view.setContentDescription(str);
                view.setImportantForAccessibility(1);
                if (jSONObject == null) {
                    Boolean bool = jSONObject.getBoolean("accessibilityEnable");
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            i = 1;
                        }
                        view.setImportantForAccessibility(i);
                    }
                }
                if (jSONObject == null) {
                    String string = jSONObject.getString("accessibilityTraits");
                    if (string != null) {
                        ViewCompat.setAccessibilityDelegate(view, new GXAccessibilityUtils$accessibilityOfView$2$1(string));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        view.setImportantForAccessibility(2);
        if (jSONObject == null) {
        }
        if (jSONObject == null) {
        }
    }

    @NotNull
    public final String d(@NotNull String str) {
        k21.i(str, "traits");
        switch (str.hashCode()) {
            case -1377687758:
                if (str.equals(BaseCellItem.TYPE_BUTTON)) {
                    String name = Button.class.getName();
                    k21.h(name, "Button::class.java.name");
                    return name;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    return "";
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    String name2 = TextView.class.getName();
                    k21.h(name2, "TextView::class.java.name");
                    return name2;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    String name3 = ImageView.class.getName();
                    k21.h(name3, "ImageView::class.java.name");
                    return name3;
                }
                break;
        }
        String name4 = View.class.getName();
        k21.h(name4, "View::class.java.name");
        return name4;
    }
}

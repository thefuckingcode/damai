package com.alibaba.android.bindingx.plugin.android;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.WeakRunnable;
import com.alibaba.android.bindingx.core.internal.o;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.f91;
import tb.jl1;

/* compiled from: Taobao */
public final class NativeViewUpdateService {
    private static final Map<String, INativeViewUpdater> a;
    private static final LayoutUpdater b = new LayoutUpdater();
    private static final b c = new b();
    private static final List<String> d = Arrays.asList("width", "height", W3CStyleConstants.MARGIN_LEFT, W3CStyleConstants.MARGIN_RIGHT, W3CStyleConstants.MARGIN_TOP, W3CStyleConstants.MARGIN_BOTTOM, W3CStyleConstants.PADDING_LEFT, W3CStyleConstants.PADDING_RIGHT, W3CStyleConstants.PADDING_TOP, W3CStyleConstants.PADDING_BOTTOM);
    private static final Handler e = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    private static final class BackgroundUpdater implements INativeViewUpdater {
        private BackgroundUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Integer) {
                final int intValue = ((Integer) obj).intValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.BackgroundUpdater.AnonymousClass1 */

                    public void run() {
                        Drawable background = view.getBackground();
                        if (background == null) {
                            view.setBackgroundColor(intValue);
                        } else if (background instanceof ColorDrawable) {
                            ((ColorDrawable) background).setColor(intValue);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class ColorUpdater implements INativeViewUpdater {
        private ColorUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Integer) {
                final int intValue = ((Integer) obj).intValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ColorUpdater.AnonymousClass1 */

                    public void run() {
                        View view = view;
                        if (view instanceof TextView) {
                            ((TextView) view).setTextColor(intValue);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class ContentOffsetXUpdater implements INativeViewUpdater {
        private ContentOffsetXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ContentOffsetXUpdater.AnonymousClass1 */

                    public void run() {
                        view.setScrollX((int) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class ContentOffsetYUpdater implements INativeViewUpdater {
        private ContentOffsetYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ContentOffsetYUpdater.AnonymousClass1 */

                    public void run() {
                        view.setScrollY((int) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class LayoutUpdater implements INativeViewUpdater {
        private String a;

        private LayoutUpdater() {
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            this.a = str;
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if ((obj instanceof Double) && !TextUtils.isEmpty(this.a)) {
                final int g = (int) NativeViewUpdateService.g(((Double) obj).doubleValue(), iDeviceResolutionTranslator);
                String str2 = this.a;
                str2.hashCode();
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1502084711:
                        if (str2.equals(W3CStyleConstants.PADDING_TOP)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (str2.equals("height")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -887955139:
                        if (str2.equals(W3CStyleConstants.MARGIN_RIGHT)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -396426912:
                        if (str2.equals(W3CStyleConstants.PADDING_RIGHT)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 113126854:
                        if (str2.equals("width")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 143541095:
                        if (str2.equals(W3CStyleConstants.PADDING_BOTTOM)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 679766083:
                        if (str2.equals(W3CStyleConstants.PADDING_LEFT)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 941004998:
                        if (str2.equals(W3CStyleConstants.MARGIN_LEFT)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1970025654:
                        if (str2.equals(W3CStyleConstants.MARGIN_TOP)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 2086035242:
                        if (str2.equals(W3CStyleConstants.MARGIN_BOTTOM)) {
                            c = '\t';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass9 */

                            public void run() {
                                View view = view;
                                view.setPadding(view.getPaddingLeft(), g, view.getPaddingRight(), view.getPaddingBottom());
                            }
                        });
                        break;
                    case 1:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass2 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                layoutParams.height = g;
                                view.setLayoutParams(layoutParams);
                            }
                        });
                        break;
                    case 2:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass4 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = g;
                                    view.setLayoutParams(layoutParams);
                                    return;
                                }
                                f91.b("set margin right failed");
                            }
                        });
                        break;
                    case 3:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass8 */

                            public void run() {
                                View view = view;
                                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), g, view.getPaddingBottom());
                            }
                        });
                        break;
                    case 4:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass1 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                layoutParams.width = g;
                                view.setLayoutParams(layoutParams);
                            }
                        });
                        break;
                    case 5:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass10 */

                            public void run() {
                                View view = view;
                                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), g);
                            }
                        });
                        break;
                    case 6:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass7 */

                            public void run() {
                                View view = view;
                                view.setPadding(g, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                            }
                        });
                        break;
                    case 7:
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass3 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = g;
                                    view.setLayoutParams(layoutParams);
                                    return;
                                }
                                f91.b("set margin left failed");
                            }
                        });
                        break;
                    case '\b':
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass5 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = g;
                                    view.setLayoutParams(layoutParams);
                                    return;
                                }
                                f91.b("set margin top failed");
                            }
                        });
                        break;
                    case '\t':
                        NativeViewUpdateService.h(new Runnable() {
                            /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.AnonymousClass6 */

                            public void run() {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = g;
                                    view.setLayoutParams(layoutParams);
                                    return;
                                }
                                f91.b("set margin bottom failed");
                            }
                        });
                        break;
                }
                this.a = null;
            }
        }
    }

    /* compiled from: Taobao */
    private static final class OpacityUpdater implements INativeViewUpdater {
        private OpacityUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final float doubleValue = (float) ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.OpacityUpdater.AnonymousClass1 */

                    public void run() {
                        view.setAlpha(doubleValue);
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class RotateUpdater implements INativeViewUpdater {
        private RotateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateUpdater.AnonymousClass1 */

                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance((float) k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotation((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class RotateXUpdater implements INativeViewUpdater {
        private RotateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateXUpdater.AnonymousClass1 */

                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance((float) k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotationX((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class RotateYUpdater implements INativeViewUpdater {
        private RotateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateYUpdater.AnonymousClass1 */

                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance((float) k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotationY((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class ScaleUpdater implements INativeViewUpdater {
        private ScaleUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            NativeViewUpdateService.h(new Runnable() {
                /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleUpdater.AnonymousClass1 */

                public void run() {
                    Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                    if (l != null) {
                        view.setPivotX(((Float) l.first).floatValue());
                        view.setPivotY(((Float) l.second).floatValue());
                    }
                    Object obj = obj;
                    if (obj instanceof Double) {
                        float doubleValue = (float) ((Double) obj).doubleValue();
                        view.setScaleX(doubleValue);
                        view.setScaleY(doubleValue);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                            double doubleValue2 = ((Double) arrayList.get(0)).doubleValue();
                            double doubleValue3 = ((Double) arrayList.get(1)).doubleValue();
                            view.setScaleX((float) doubleValue2);
                            view.setScaleY((float) doubleValue3);
                        }
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    private static final class ScaleXUpdater implements INativeViewUpdater {
        private ScaleXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleXUpdater.AnonymousClass1 */

                    public void run() {
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setScaleX((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class ScaleYUpdater implements INativeViewUpdater {
        private ScaleYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleYUpdater.AnonymousClass1 */

                    public void run() {
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setScaleY((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class TranslateUpdater implements INativeViewUpdater {
        private TranslateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                    final double doubleValue = ((Double) arrayList.get(0)).doubleValue();
                    final double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
                    NativeViewUpdateService.h(new Runnable() {
                        /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateUpdater.AnonymousClass1 */

                        public void run() {
                            view.setTranslationX((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                            view.setTranslationY((float) NativeViewUpdateService.g(doubleValue2, iDeviceResolutionTranslator));
                        }
                    });
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static final class TranslateXUpdater implements INativeViewUpdater {
        private TranslateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateXUpdater.AnonymousClass1 */

                    public void run() {
                        view.setTranslationX((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class TranslateYUpdater implements INativeViewUpdater {
        private TranslateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() {
                    /* class com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateYUpdater.AnonymousClass1 */

                    public void run() {
                        view.setTranslationY((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    private static final class b implements INativeViewUpdater {
        private b() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("opacity", new OpacityUpdater());
        hashMap.put("transform.translate", new TranslateUpdater());
        hashMap.put("transform.translateX", new TranslateXUpdater());
        hashMap.put("transform.translateY", new TranslateYUpdater());
        hashMap.put("transform.scale", new ScaleUpdater());
        hashMap.put("transform.scaleX", new ScaleXUpdater());
        hashMap.put("transform.scaleY", new ScaleYUpdater());
        hashMap.put("transform.rotate", new RotateUpdater());
        hashMap.put("transform.rotateZ", new RotateUpdater());
        hashMap.put("transform.rotateX", new RotateXUpdater());
        hashMap.put("transform.rotateY", new RotateYUpdater());
        hashMap.put("background-color", new BackgroundUpdater());
        hashMap.put("color", new ColorUpdater());
        hashMap.put("scroll.contentOffsetX", new ContentOffsetXUpdater());
        hashMap.put("scroll.contentOffsetY", new ContentOffsetYUpdater());
    }

    public static void d() {
        e.removeCallbacksAndMessages(null);
    }

    @NonNull
    public static INativeViewUpdater e(@NonNull String str) {
        INativeViewUpdater iNativeViewUpdater = a.get(str);
        if (iNativeViewUpdater != null) {
            return iNativeViewUpdater;
        }
        if (d.contains(str)) {
            LayoutUpdater layoutUpdater = b;
            layoutUpdater.a(str);
            return layoutUpdater;
        }
        f91.b("unknown property [" + str + jl1.ARRAY_END_STR);
        return c;
    }

    /* access modifiers changed from: private */
    public static int f(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || TextUtils.isEmpty(str) || (obj = map.get(str)) == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static double g(double d2, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        return iDeviceResolutionTranslator.webToNative(d2, new Object[0]);
    }

    /* access modifiers changed from: private */
    public static void h(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            e.post(new WeakRunnable(runnable));
        }
    }
}

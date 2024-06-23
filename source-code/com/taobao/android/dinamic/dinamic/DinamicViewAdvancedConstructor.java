package com.taobao.android.dinamic.dinamic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamicx.DXDarkModeCenter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.a80;
import tb.h80;
import tb.o70;
import tb.q42;
import tb.r70;
import tb.s70;
import tb.sp;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class DinamicViewAdvancedConstructor {
    private static final String TAG = "DinamicViewAdvancedConstructor";
    private boolean isInitialize = false;
    private boolean isNeedReflect;
    private boolean isRunSuperMethod;
    private List<a> methodInfos;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        Method a;
        String[] b;
        Class[] c;

        a(Method method, String[] strArr, Class[] clsArr) {
            this.a = method;
            this.b = strArr;
            this.c = clsArr;
        }
    }

    public DinamicViewAdvancedConstructor() {
        a80.a(new Runnable() {
            /* class com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor.AnonymousClass1 */

            public void run() {
                DinamicViewAdvancedConstructor.this.initialize();
            }
        });
    }

    private a findMethodForAttr(String str) {
        for (a aVar : this.methodInfos) {
            String[] strArr = aVar.b;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(str, strArr[i])) {
                        return aVar;
                    }
                    i++;
                }
            }
        }
        return null;
    }

    private Method findSetAttributesMethod() {
        try {
            return getClassLoader().loadClass(getClass().getName()).getDeclaredMethod("setAttributes", View.class, Map.class, ArrayList.class, x70.class);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initialize() {
        this.isNeedReflect = findSetAttributesMethod() == null;
        scanAllDinamicAttrMethods();
        this.isInitialize = true;
    }

    private void scanAllDinamicAttrMethods() {
        try {
            this.methodInfos = new ArrayList();
            Method[] methods = getClassLoader().loadClass(getClass().getName()).getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(DinamicAttr.class)) {
                    String[] attrSet = ((DinamicAttr) method.getAnnotation(DinamicAttr.class)).attrSet();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (attrSet.length > 0 && parameterTypes.length > 0 && parameterTypes.length - attrSet.length == 1) {
                        this.methodInfos.add(new a(method, attrSet, parameterTypes));
                    } else if (b.e()) {
                        DinamicLog.a(b.TAG, "Senioronstructor scanAllDinamicAttrMethods function info error");
                    }
                }
            }
        } catch (Throwable th) {
            if (b.e()) {
                DinamicLog.i(b.TAG, th, "Senioronstructor scanAllDinamicAttrMethods exception");
            }
        }
    }

    private void setSpecificAttributes(View view, Map<String, Object> map, x70 x70) {
        boolean z;
        a findMethodForAttr;
        Object obj;
        Class[] clsArr;
        View view2 = view;
        List<a> list = this.methodInfos;
        if (!(list == null || list.size() == 0)) {
            z70 c = h80.c(view);
            Map<String, Object> map2 = c.b;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals((String) it.next(), entry.getKey())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z && (findMethodForAttr = findMethodForAttr(entry.getKey())) != null) {
                    Method method = findMethodForAttr.a;
                    String[] strArr = findMethodForAttr.b;
                    Class[] clsArr2 = findMethodForAttr.c;
                    if (strArr.length > 1) {
                        arrayList.addAll(Arrays.asList(strArr));
                    }
                    Object[] objArr = new Object[clsArr2.length];
                    if (!clsArr2[0].isInstance(view2)) {
                        x70.e().b().a(r70.ERROR_CODE_VIEW_EXCEPTION, c.a);
                        if (b.e()) {
                            DinamicLog.e(b.TAG, "Senioronstructor first param class not match");
                        }
                    } else {
                        objArr[0] = view2;
                        int i = 0;
                        while (i < strArr.length) {
                            if ("module".equals(strArr[i])) {
                                obj = x70.c();
                            } else if (DAttrConstant.DINAMIC_CONTEXT.equals(strArr[i])) {
                                obj = x70.b();
                            } else if (DAttrConstant.DINAMIC_PARAMS.equals(strArr[i])) {
                                obj = x70;
                            } else if (map.containsKey(strArr[i])) {
                                obj = map.get(strArr[i]);
                            } else {
                                obj = map2.get(strArr[i]);
                            }
                            int i2 = i + 1;
                            if (clsArr2[i2].isInstance(obj)) {
                                objArr[i2] = obj;
                                clsArr = clsArr2;
                            } else {
                                if (obj != null) {
                                    x70.e().b().a(r70.ERROR_CODE_VIEW_EXCEPTION, c.a);
                                }
                                if (b.e()) {
                                    clsArr = clsArr2;
                                    DinamicLog.e(b.TAG, String.format("AdvancedConstructor %s value is null or not exist", strArr[i]));
                                } else {
                                    clsArr = clsArr2;
                                }
                                objArr[i2] = null;
                            }
                            i = i2;
                            clsArr2 = clsArr;
                        }
                        try {
                            method.invoke(this, objArr);
                        } catch (Exception e) {
                            x70.e().b().a(r70.ERROR_CODE_VIEW_EXCEPTION, c.a);
                            if (b.e()) {
                                DinamicLog.i(b.TAG, e, "AdvancedConstructor method invoke exception");
                            }
                        }
                        view2 = view;
                    }
                }
            }
        }
    }

    @Deprecated
    public void applyDefaultProperty(View view) {
    }

    public void applyDefaultProperty(View view, Map<String, Object> map, x70 x70) {
        if (!map.containsKey("dBackgroundColor")) {
            view.setBackgroundColor(0);
        }
        if (!map.containsKey(DAttrConstant.VIEW_ALPHA)) {
            view.setAlpha(1.0f);
        }
        applyDefaultProperty(view);
    }

    public void bindDataImpl(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        if (needBindData(view, map, x70)) {
            setAttributes(view, map, arrayList, x70);
        }
    }

    /* access modifiers changed from: protected */
    public ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }

    public Class getDebugClass() {
        try {
            return getClassLoader().loadClass(getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final z70 handleAttributeSet(AttributeSet attributeSet) {
        z70 z70 = new z70();
        int attributeCount = attributeSet.getAttributeCount();
        if (attributeCount <= 0) {
            return z70;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(o70.RES_AUTO_NAMESPACE, attributeName);
            if (attributeValue != null) {
                if (attributeName.startsWith("on")) {
                    hashMap3.put(attributeName, attributeValue);
                } else if (attributeValue.startsWith("$") || attributeValue.startsWith(o70.DINAMIC_PREFIX_AT)) {
                    hashMap2.put(attributeName, attributeValue);
                } else {
                    hashMap.put(attributeName, attributeValue);
                }
            }
        }
        z70.b = hashMap;
        z70.c = Collections.unmodifiableMap(hashMap2);
        z70.d = Collections.unmodifiableMap(hashMap3);
        return z70;
    }

    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new View(context, attributeSet);
    }

    public View initializeViewWithModule(String str, Context context, AttributeSet attributeSet, x70 x70) {
        return initializeView(str, context, attributeSet);
    }

    public boolean needBindData(View view, Map<String, Object> map, x70 x70) {
        if (map.containsKey(DAttrConstant.VIEW_VISIBILITY)) {
            Object obj = map.get(DAttrConstant.VIEW_VISIBILITY);
            if (obj instanceof String) {
                setVisibility(view, (String) obj);
            }
        }
        return view.getVisibility() != 8;
    }

    public void setAccessibilityHidden(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setContentDescription("");
        } else if (z) {
            view.setImportantForAccessibility(2);
        } else {
            view.setImportantForAccessibility(1);
        }
    }

    public void setAccessibilityText(View view, String str) {
        view.setContentDescription(str);
    }

    public void setAlpha(View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                view.setAlpha(Float.valueOf(str).floatValue());
            } catch (NumberFormatException unused) {
                view.setAlpha(1.0f);
            }
        } else {
            view.setAlpha(1.0f);
        }
    }

    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        if (arrayList.contains("dBackgroundColor") || arrayList.contains(DAttrConstant.VIEW_CORNER_RADIUS) || arrayList.contains(DAttrConstant.VIEW_BORDER_COLOR) || arrayList.contains(DAttrConstant.VIEW_BORDER_WIDTH)) {
            setBackground(view, (String) map.get(DAttrConstant.VIEW_CORNER_RADIUS), (String) map.get(DAttrConstant.VIEW_BORDER_COLOR), (String) map.get(DAttrConstant.VIEW_BORDER_WIDTH), (String) map.get("dBackgroundColor"));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ALPHA)) {
            setAlpha(view, (String) map.get(DAttrConstant.VIEW_ALPHA));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ACCESSIBILITYTEXT)) {
            setAccessibilityText(view, (String) map.get(DAttrConstant.VIEW_ACCESSIBILITYTEXT));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ACCESSIBILITYTEXT_HIDDEN)) {
            String str = (String) map.get(DAttrConstant.VIEW_ACCESSIBILITYTEXT_HIDDEN);
            if (!TextUtils.isEmpty(str)) {
                setAccessibilityHidden(view, Boolean.valueOf(str).booleanValue());
            } else {
                setAccessibilityHidden(view, true);
            }
        }
        if (arrayList.contains(DAttrConstant.VIEW_DISABLE_DARK_MODE)) {
            setForceDark(view, Boolean.valueOf((String) map.get(DAttrConstant.VIEW_DISABLE_DARK_MODE)).booleanValue());
        }
        if (!this.isInitialize) {
            initialize();
        }
        if (this.isNeedReflect) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                hashMap.put(next, map.get(next));
            }
            setSpecificAttributes(view, hashMap, x70);
        }
    }

    public void setBackground(View view, String str, String str2, String str3, String str4) {
        Drawable background = view.getBackground();
        if (background != null && (background instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            int d = sp.d(str4, 0);
            if (!TextUtils.isEmpty(str4)) {
                gradientDrawable.setColor(d);
            }
            if (!TextUtils.isEmpty(str)) {
                gradientDrawable.setCornerRadius((float) q42.b(view.getContext(), str, 0));
            }
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                gradientDrawable.setStroke(q42.b(view.getContext(), str3, 0), sp.d(str2, d));
            }
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            int d2 = sp.d(str4, 0);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            int b = q42.b(view.getContext(), str, 0);
            int d3 = sp.d(str2, d2);
            int b2 = q42.b(view.getContext(), str3, 0);
            gradientDrawable2.setCornerRadius((float) b);
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(d2);
            if (b2 > 0) {
                gradientDrawable2.setStroke(b2, d3);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(gradientDrawable2);
            } else {
                view.setBackgroundDrawable(gradientDrawable2);
            }
        } else {
            view.setBackgroundColor(sp.d(str4, 0));
        }
    }

    public void setEvents(View view, x70 x70) {
        new s70().b(view, x70);
    }

    /* access modifiers changed from: protected */
    public void setForceDark(View view, boolean z) {
        if (z) {
            DXDarkModeCenter.a(view);
        }
    }

    public void setVisibility(View view, String str) {
        if (TextUtils.equals("visible", str)) {
            view.setVisibility(0);
        } else if (TextUtils.equals(DAttrConstant.VISIBILITY_INVISIBLE, str)) {
            view.setVisibility(4);
        } else if (TextUtils.equals("gone", str)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }
}

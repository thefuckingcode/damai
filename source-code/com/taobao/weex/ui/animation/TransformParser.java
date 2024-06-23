package com.taobao.weex.ui.animation;

import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.utils.FunctionParser;
import com.taobao.weex.utils.WXDataStructureUtil;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class TransformParser {
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BOTTOM = "bottom";
    public static final String CENTER = "center";
    private static final String DEG = "deg";
    private static final String FULL = "100%";
    private static final String HALF = "50%";
    public static final String HEIGHT = "height";
    public static final String LEFT = "left";
    private static final String PX = "px";
    public static final String RIGHT = "right";
    public static final String TOP = "top";
    public static final String WIDTH = "width";
    public static final String WX_ROTATE = "rotate";
    public static final String WX_ROTATE_X = "rotateX";
    public static final String WX_ROTATE_Y = "rotateY";
    public static final String WX_ROTATE_Z = "rotateZ";
    public static final String WX_SCALE = "scale";
    public static final String WX_SCALE_X = "scaleX";
    public static final String WX_SCALE_Y = "scaleY";
    public static final String WX_TRANSLATE = "translate";
    public static final String WX_TRANSLATE_X = "translateX";
    public static final String WX_TRANSLATE_Y = "translateY";
    private static final String ZERO = "0%";
    public static Map<String, List<Property<View, Float>>> wxToAndroidMap;

    static {
        ArrayMap arrayMap = new ArrayMap();
        wxToAndroidMap = arrayMap;
        arrayMap.put("translate", Arrays.asList(View.TRANSLATION_X, View.TRANSLATION_Y));
        wxToAndroidMap.put("translateX", Collections.singletonList(View.TRANSLATION_X));
        wxToAndroidMap.put("translateY", Collections.singletonList(View.TRANSLATION_Y));
        wxToAndroidMap.put("rotate", Collections.singletonList(View.ROTATION));
        wxToAndroidMap.put(WX_ROTATE_Z, Collections.singletonList(View.ROTATION));
        wxToAndroidMap.put("rotateX", Collections.singletonList(View.ROTATION_X));
        wxToAndroidMap.put("rotateY", Collections.singletonList(View.ROTATION_Y));
        wxToAndroidMap.put("scale", Arrays.asList(View.SCALE_X, View.SCALE_Y));
        wxToAndroidMap.put("scaleX", Collections.singletonList(View.SCALE_X));
        wxToAndroidMap.put("scaleY", Collections.singletonList(View.SCALE_Y));
        wxToAndroidMap.put(Constants.Name.PERSPECTIVE, Collections.singletonList(CameraDistanceProperty.getInstance()));
        wxToAndroidMap = Collections.unmodifiableMap(wxToAndroidMap);
    }

    private static float parsePercent(String str, int i, int i2) {
        return (WXUtils.fastGetFloat(str, i2) / 100.0f) * ((float) i);
    }

    /* access modifiers changed from: private */
    public static float parsePercentOrPx(String str, int i, int i2) {
        int lastIndexOf = str.lastIndexOf(37);
        if (lastIndexOf != -1) {
            return parsePercent(str.substring(0, lastIndexOf), i, 1);
        }
        int lastIndexOf2 = str.lastIndexOf(PX);
        if (lastIndexOf2 != -1) {
            return WXViewUtils.getRealPxByWidth(WXUtils.fastGetFloat(str.substring(0, lastIndexOf2), 1), i2);
        }
        return WXViewUtils.getRealPxByWidth(WXUtils.fastGetFloat(str, 1), i2);
    }

    private static Pair<Float, Float> parsePivot(@Nullable String str, int i, int i2, int i3) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(32)) == -1) {
            return null;
        }
        int i4 = indexOf;
        while (i4 < str.length() && str.charAt(i4) == ' ') {
            i4++;
        }
        if (i4 >= str.length() || str.charAt(i4) == ' ') {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(str.substring(0, indexOf).trim());
        arrayList.add(str.substring(i4, str.length()).trim());
        return parsePivot(arrayList, i, i2, i3);
    }

    private static float parsePivotX(String str, int i, int i2) {
        if ("left".equals(str)) {
            str = ZERO;
        } else if ("right".equals(str)) {
            str = FULL;
        } else if ("center".equals(str)) {
            str = HALF;
        }
        return parsePercentOrPx(str, i, i2);
    }

    private static float parsePivotY(String str, int i, int i2) {
        if ("top".equals(str)) {
            str = ZERO;
        } else if ("bottom".equals(str)) {
            str = FULL;
        } else if ("center".equals(str)) {
            str = HALF;
        }
        return parsePercentOrPx(str, i, i2);
    }

    public static Map<Property<View, Float>, Float> parseTransForm(String str, @Nullable String str2, final int i, final int i2, final int i3) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                return new FunctionParser(str2, new FunctionParser.Mapper<Property<View, Float>, Float>() {
                    /* class com.taobao.weex.ui.animation.TransformParser.AnonymousClass1 */

                    private Map<Property<View, Float>, Float> convertParam(int i, int i2, int i3, @NonNull List<Property<View, Float>> list, @NonNull List<String> list2) {
                        HashMap newHashMapWithExpectedSize = WXDataStructureUtil.newHashMapWithExpectedSize(list.size());
                        ArrayList arrayList = new ArrayList(list.size());
                        if (list.contains(View.ROTATION) || list.contains(View.ROTATION_X) || list.contains(View.ROTATION_Y)) {
                            arrayList.addAll(parseRotationZ(list2));
                        } else if (list.contains(View.TRANSLATION_X) || list.contains(View.TRANSLATION_Y)) {
                            arrayList.addAll(parseTranslation(list, i, i2, list2, i3));
                        } else if (list.contains(View.SCALE_X) || list.contains(View.SCALE_Y)) {
                            arrayList.addAll(parseScale(list.size(), list2));
                        } else if (list.contains(CameraDistanceProperty.getInstance())) {
                            arrayList.add(parseCameraDistance(list2));
                        }
                        if (list.size() == arrayList.size()) {
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                newHashMapWithExpectedSize.put(list.get(i4), arrayList.get(i4));
                            }
                        }
                        return newHashMapWithExpectedSize;
                    }

                    private Float parseCameraDistance(List<String> list) {
                        float f;
                        if (list.size() == 1) {
                            float realPxByWidth = WXViewUtils.getRealPxByWidth(WXUtils.getFloat(list.get(0)), i3);
                            float f2 = WXEnvironment.getApplication().getResources().getDisplayMetrics().density;
                            if (!Float.isNaN(realPxByWidth) && realPxByWidth > 0.0f) {
                                f = realPxByWidth * f2;
                                return Float.valueOf(f);
                            }
                        }
                        f = Float.MAX_VALUE;
                        return Float.valueOf(f);
                    }

                    private void parseDoubleTranslation(int i, int i2, @NonNull List<String> list, List<Float> list2, String str, int i3) {
                        String str2;
                        if (list.size() == 1) {
                            str2 = str;
                        } else {
                            str2 = list.get(1);
                        }
                        list2.add(Float.valueOf(TransformParser.parsePercentOrPx(str, i, i3)));
                        list2.add(Float.valueOf(TransformParser.parsePercentOrPx(str2, i2, i3)));
                    }

                    @NonNull
                    private List<Float> parseRotationZ(@NonNull List<String> list) {
                        ArrayList arrayList = new ArrayList(1);
                        for (String str : list) {
                            int lastIndexOf = str.lastIndexOf(TransformParser.DEG);
                            if (lastIndexOf != -1) {
                                arrayList.add(Float.valueOf(WXUtils.fastGetFloat(str.substring(0, lastIndexOf))));
                            } else {
                                arrayList.add(Float.valueOf((float) Math.toDegrees((double) WXUtils.fastGetFloat(str))));
                            }
                        }
                        return arrayList;
                    }

                    private List<Float> parseScale(int i, @NonNull List<String> list) {
                        ArrayList arrayList = new ArrayList(list.size() * 2);
                        ArrayList arrayList2 = new ArrayList(list.size());
                        for (String str : list) {
                            arrayList2.add(Float.valueOf(WXUtils.fastGetFloat(str)));
                        }
                        arrayList.addAll(arrayList2);
                        if (i != 1 && list.size() == 1) {
                            arrayList.addAll(arrayList2);
                        }
                        return arrayList;
                    }

                    private void parseSingleTranslation(List<Property<View, Float>> list, int i, int i2, List<Float> list2, String str, int i3) {
                        if (list.contains(View.TRANSLATION_X)) {
                            list2.add(Float.valueOf(TransformParser.parsePercentOrPx(str, i, i3)));
                        } else if (list.contains(View.TRANSLATION_Y)) {
                            list2.add(Float.valueOf(TransformParser.parsePercentOrPx(str, i2, i3)));
                        }
                    }

                    private List<Float> parseTranslation(List<Property<View, Float>> list, int i, int i2, @NonNull List<String> list2, int i3) {
                        ArrayList arrayList = new ArrayList(2);
                        String str = list2.get(0);
                        if (list.size() == 1) {
                            parseSingleTranslation(list, i, i2, arrayList, str, i3);
                        } else {
                            parseDoubleTranslation(i, i2, list2, arrayList, str, i3);
                        }
                        return arrayList;
                    }

                    @Override // com.taobao.weex.utils.FunctionParser.Mapper
                    public Map<Property<View, Float>, Float> map(String str, List<String> list) {
                        if (list == null || list.isEmpty() || !TransformParser.wxToAndroidMap.containsKey(str)) {
                            return new HashMap();
                        }
                        return convertParam(i, i2, i3, TransformParser.wxToAndroidMap.get(str), list);
                    }
                }).parse();
            }
        } catch (Exception e) {
            WXLogUtils.e("TransformParser", e);
            WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_TRANSITION;
            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, "parse animation transition", wXErrorCode.getErrorMsg() + "parse transition error: " + e.getMessage(), null);
        }
        return new LinkedHashMap();
    }

    public static PropertyValuesHolder[] toHolders(Map<Property<View, Float>, Float> map) {
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[map.size()];
        int i = 0;
        for (Map.Entry<Property<View, Float>, Float> entry : map.entrySet()) {
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofFloat(entry.getKey(), entry.getValue().floatValue());
            i++;
        }
        return propertyValuesHolderArr;
    }

    private static Pair<Float, Float> parsePivot(@NonNull List<String> list, int i, int i2, int i3) {
        return new Pair<>(Float.valueOf(parsePivotX(list.get(0), i, i3)), Float.valueOf(parsePivotY(list.get(1), i2, i3)));
    }
}

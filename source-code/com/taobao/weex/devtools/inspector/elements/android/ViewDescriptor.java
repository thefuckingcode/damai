package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import android.view.ViewDebug;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.StringUtil;
import com.taobao.weex.devtools.common.android.ResourcesUtil;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.AttributeAccumulator;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.devtools.inspector.helper.IntegerFormatter;
import com.taobao.weex.ui.component.WXComponent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import tb.gl1;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor {
    private static final String ID_NAME = "id";
    private static final String NONE_MAPPING = "<no mapping>";
    private static final String NONE_VALUE = "(none)";
    private final MethodInvoker mMethodInvoker;
    @GuardedBy("this")
    @Nullable
    private volatile List<ViewCSSProperty> mViewProperties;
    @Nullable
    private Pattern mWordBoundaryPattern;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class FieldBackedCSSProperty extends ViewCSSProperty {
        private final Field mField;

        public FieldBackedCSSProperty(Field field, String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mField = field;
            field.setAccessible(true);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewDescriptor.ViewCSSProperty
        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mField.get(view);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class MethodBackedCSSProperty extends ViewCSSProperty {
        private final Method mMethod;

        public MethodBackedCSSProperty(Method method, String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mMethod = method;
            method.setAccessible(true);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewDescriptor.ViewCSSProperty
        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mMethod.invoke(view, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public abstract class ViewCSSProperty {
        private final ViewDebug.ExportedProperty mAnnotation;
        private final String mCSSName;

        public ViewCSSProperty(String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            this.mCSSName = str;
            this.mAnnotation = exportedProperty;
        }

        @Nullable
        public final ViewDebug.ExportedProperty getAnnotation() {
            return this.mAnnotation;
        }

        public final String getCSSName() {
            return this.mCSSName;
        }

        public abstract Object getValue(View view) throws InvocationTargetException, IllegalAccessException;
    }

    public ViewDescriptor() {
        this(new MethodInvoker());
    }

    private static boolean canFlagsBeMappedToString(@Nullable ViewDebug.ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.flagMapping() == null || exportedProperty.flagMapping().length <= 0) ? false : true;
    }

    private static boolean canIntBeMappedToString(@Nullable ViewDebug.ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.mapping() == null || exportedProperty.mapping().length <= 0) ? false : true;
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0 || Character.isTitleCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toTitleCase(sb.charAt(0)));
        return sb.toString();
    }

    private String convertViewPropertyNameToCSSName(String str) {
        String[] split = getWordBoundaryPattern().split(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(gl1.TYPE_OPEN_URL_METHOD_GET) && !split[i].equals(WXComponent.PROP_FS_MATCH_PARENT)) {
                sb.append(split[i].toLowerCase());
                if (i < split.length - 1) {
                    sb.append('-');
                }
            }
        }
        return sb.toString();
    }

    @Nullable
    private static String getIdAttribute(View view) {
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id);
    }

    private void getIdStyle(View view, StyleAccumulator styleAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute == null) {
            styleAccumulator.store("id", NONE_VALUE, false);
        } else {
            styleAccumulator.store("id", idAttribute, false);
        }
    }

    private void getStyleFromFloat(String str, Float f, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        styleAccumulator.store(str, String.valueOf(f), isDefaultValue(f));
    }

    private void getStyleFromInteger(String str, Integer num, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String format = IntegerFormatter.getInstance().format(num, exportedProperty);
        if (canIntBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, format + " (" + mapIntToStringUsingAnnotation(num.intValue(), exportedProperty) + jl1.BRACKET_END_STR, false);
        } else if (canFlagsBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, format + " (" + mapFlagsToStringUsingAnnotation(num.intValue(), exportedProperty) + jl1.BRACKET_END_STR, false);
        } else {
            styleAccumulator.store(str, format, isDefaultValue(num, exportedProperty));
        }
    }

    private void getStyleFromValue(View view, String str, Object obj, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        if (str.equals("id")) {
            getIdStyle(view, styleAccumulator);
        } else if (obj instanceof Integer) {
            getStyleFromInteger(str, (Integer) obj, exportedProperty, styleAccumulator);
        } else if (obj instanceof Float) {
            getStyleFromFloat(str, (Float) obj, exportedProperty, styleAccumulator);
        } else {
            getStylesFromObject(view, str, obj, exportedProperty, styleAccumulator);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r7.equals("topMargin") == false) goto L_0x0041;
     */
    private void getStylesFromObject(View view, String str, Object obj, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String str2;
        if (!(exportedProperty == null || !exportedProperty.deepExport() || obj == null)) {
            Field[] fields = obj.getClass().getFields();
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    char c = 1;
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        String name = field.getName();
                        name.hashCode();
                        switch (name.hashCode()) {
                            case -599904534:
                                if (name.equals("rightMargin")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -414179485:
                                break;
                            case 1928835221:
                                if (name.equals("leftMargin")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2064613305:
                                if (name.equals("bottomMargin")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                str2 = W3CStyleConstants.MARGIN_RIGHT;
                                break;
                            case 1:
                                str2 = W3CStyleConstants.MARGIN_TOP;
                                break;
                            case 2:
                                str2 = W3CStyleConstants.MARGIN_LEFT;
                                break;
                            case 3:
                                str2 = W3CStyleConstants.MARGIN_BOTTOM;
                                break;
                            default:
                                String prefix = exportedProperty.prefix();
                                if (prefix != null) {
                                    name = prefix + name;
                                }
                                str2 = convertViewPropertyNameToCSSName(name);
                                break;
                        }
                        getStyleFromValue(view, str2, obj2, (ViewDebug.ExportedProperty) field.getAnnotation(ViewDebug.ExportedProperty.class), styleAccumulator);
                    } catch (IllegalAccessException e) {
                        LogUtil.e(e, "failed to get property of name: \"" + str + "\" of object: " + String.valueOf(obj));
                        return;
                    }
                }
            }
        }
    }

    private List<ViewCSSProperty> getViewProperties() {
        if (this.mViewProperties == null) {
            synchronized (this) {
                if (this.mViewProperties == null) {
                    ArrayList arrayList = new ArrayList();
                    Method[] declaredMethods = View.class.getDeclaredMethods();
                    for (Method method : declaredMethods) {
                        ViewDebug.ExportedProperty exportedProperty = (ViewDebug.ExportedProperty) method.getAnnotation(ViewDebug.ExportedProperty.class);
                        if (exportedProperty != null) {
                            arrayList.add(new MethodBackedCSSProperty(method, convertViewPropertyNameToCSSName(method.getName()), exportedProperty));
                        }
                    }
                    Field[] declaredFields = View.class.getDeclaredFields();
                    for (Field field : declaredFields) {
                        ViewDebug.ExportedProperty exportedProperty2 = (ViewDebug.ExportedProperty) field.getAnnotation(ViewDebug.ExportedProperty.class);
                        if (exportedProperty2 != null) {
                            arrayList.add(new FieldBackedCSSProperty(field, convertViewPropertyNameToCSSName(field.getName()), exportedProperty2));
                        }
                    }
                    Collections.sort(arrayList, new Comparator<ViewCSSProperty>() {
                        /* class com.taobao.weex.devtools.inspector.elements.android.ViewDescriptor.AnonymousClass1 */

                        public int compare(ViewCSSProperty viewCSSProperty, ViewCSSProperty viewCSSProperty2) {
                            return viewCSSProperty.getCSSName().compareTo(viewCSSProperty2.getCSSName());
                        }
                    });
                    this.mViewProperties = Collections.unmodifiableList(arrayList);
                }
            }
        }
        return this.mViewProperties;
    }

    private Pattern getWordBoundaryPattern() {
        if (this.mWordBoundaryPattern == null) {
            this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
        }
        return this.mWordBoundaryPattern;
    }

    private static boolean isDefaultValue(Float f) {
        return f.floatValue() == 0.0f;
    }

    private static String mapFlagsToStringUsingAnnotation(int i, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        if (canFlagsBeMappedToString(exportedProperty)) {
            StringBuilder sb = null;
            ViewDebug.FlagToString[] flagMapping = exportedProperty.flagMapping();
            boolean z = false;
            for (ViewDebug.FlagToString flagToString : flagMapping) {
                if (flagToString.outputIf() == ((flagToString.mask() & i) == flagToString.equals())) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (z) {
                        sb.append(" | ");
                    }
                    sb.append(flagToString.name());
                    z = true;
                }
            }
            return z ? sb.toString() : NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private static String mapIntToStringUsingAnnotation(int i, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        if (canIntBeMappedToString(exportedProperty)) {
            ViewDebug.IntToString[] mapping = exportedProperty.mapping();
            for (ViewDebug.IntToString intToString : mapping) {
                if (intToString.from() == i) {
                    return intToString.to();
                }
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    public View getViewForHighlighting(Object obj) {
        return (View) obj;
    }

    public ViewDescriptor(MethodInvoker methodInvoker) {
        this.mMethodInvoker = methodInvoker;
    }

    private static boolean isDefaultValue(Integer num, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        if (canFlagsBeMappedToString(exportedProperty) || canIntBeMappedToString(exportedProperty) || num.intValue() != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onGetAttributes(View view, AttributeAccumulator attributeAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute != null) {
            attributeAccumulator.store("id", idAttribute);
        }
    }

    /* access modifiers changed from: protected */
    public String onGetNodeName(View view) {
        String name = view.getClass().getName();
        return StringUtil.removePrefix(name, "android.view.", StringUtil.removePrefix(name, "android.widget."));
    }

    /* access modifiers changed from: protected */
    public void onGetStyles(View view, StyleAccumulator styleAccumulator) {
        List<ViewCSSProperty> viewProperties = getViewProperties();
        int size = viewProperties.size();
        for (int i = 0; i < size; i++) {
            ViewCSSProperty viewCSSProperty = viewProperties.get(i);
            try {
                getStyleFromValue(view, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(view), viewCSSProperty.getAnnotation(), styleAccumulator);
            } catch (IllegalAccessException | InvocationTargetException e) {
                LogUtil.e(e, "failed to get style property " + viewCSSProperty.getCSSName() + " of element= " + view.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSetAttributesAsText(View view, String str) {
        for (Map.Entry<String, String> entry : Descriptor.parseSetAttributesAsTextArg(str).entrySet()) {
            this.mMethodInvoker.invoke(view, "set" + capitalize(entry.getKey()), entry.getValue());
        }
    }
}

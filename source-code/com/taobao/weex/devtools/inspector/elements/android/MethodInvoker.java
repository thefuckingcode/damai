package com.taobao.weex.devtools.inspector.elements.android;

import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class MethodInvoker {
    private static final List<TypedMethodInvoker<?>> invokers = Arrays.asList(new StringMethodInvoker(), new CharSequenceMethodInvoker(), new IntegerMethodInvoker(), new FloatMethodInvoker(), new BooleanMethodInvoker());

    /* compiled from: Taobao */
    private static class BooleanMethodInvoker extends TypedMethodInvoker<Boolean> {
        BooleanMethodInvoker() {
            super(Boolean.TYPE);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.elements.android.MethodInvoker.TypedMethodInvoker
        public Boolean convertArgument(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    /* compiled from: Taobao */
    private static class CharSequenceMethodInvoker extends TypedMethodInvoker<CharSequence> {
        CharSequenceMethodInvoker() {
            super(CharSequence.class);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.elements.android.MethodInvoker.TypedMethodInvoker
        public CharSequence convertArgument(String str) {
            return str;
        }
    }

    /* compiled from: Taobao */
    private static class FloatMethodInvoker extends TypedMethodInvoker<Float> {
        FloatMethodInvoker() {
            super(Float.TYPE);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.elements.android.MethodInvoker.TypedMethodInvoker
        public Float convertArgument(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }
    }

    /* compiled from: Taobao */
    private static class IntegerMethodInvoker extends TypedMethodInvoker<Integer> {
        IntegerMethodInvoker() {
            super(Integer.TYPE);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.elements.android.MethodInvoker.TypedMethodInvoker
        public Integer convertArgument(String str) {
            return Integer.valueOf(Integer.parseInt(str));
        }
    }

    /* compiled from: Taobao */
    private static class StringMethodInvoker extends TypedMethodInvoker<String> {
        StringMethodInvoker() {
            super(String.class);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.elements.android.MethodInvoker.TypedMethodInvoker
        public String convertArgument(String str) {
            return str;
        }
    }

    /* compiled from: Taobao */
    private static abstract class TypedMethodInvoker<T> {
        private final Class<T> mArgType;

        TypedMethodInvoker(Class<T> cls) {
            this.mArgType = cls;
        }

        /* access modifiers changed from: protected */
        public abstract T convertArgument(String str);

        /* access modifiers changed from: package-private */
        public boolean invoke(Object obj, String str, String str2) {
            try {
                obj.getClass().getMethod(str, this.mArgType).invoke(obj, convertArgument(str2));
                return true;
            } catch (NoSuchMethodException unused) {
                return false;
            } catch (InvocationTargetException e) {
                LogUtil.w("InvocationTargetException: " + e.getMessage());
                return false;
            } catch (IllegalAccessException e2) {
                LogUtil.w("IllegalAccessException: " + e2.getMessage());
                return false;
            } catch (IllegalArgumentException e3) {
                LogUtil.w("IllegalArgumentException: " + e3.getMessage());
                return false;
            }
        }
    }

    public void invoke(Object obj, String str, String str2) {
        Util.throwIfNull(obj, str, str2);
        int size = invokers.size();
        for (int i = 0; i < size; i++) {
            if (invokers.get(i).invoke(obj, str, str2)) {
                return;
            }
        }
        LogUtil.w("Method with name " + str + " not found for any of the MethodInvoker supported argument types.");
    }
}

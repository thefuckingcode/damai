package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSBoolean;
import com.youku.gaiax.quickjs.JSDataException;
import com.youku.gaiax.quickjs.JSNull;
import com.youku.gaiax.quickjs.JSNumber;
import com.youku.gaiax.quickjs.JSString;
import com.youku.gaiax.quickjs.JSUndefined;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;

/* compiled from: Taobao */
public class StandardTypeAdapters {
    private static final TypeAdapter<Boolean> BOOLEAN_TYPE_ADAPTER = new TypeAdapter<Boolean>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass3 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Boolean fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Boolean bool) {
            return context.createJSBoolean(bool.booleanValue());
        }
    };
    private static final TypeAdapter<Byte> BYTE_TYPE_ADAPTER = new TypeAdapter<Byte>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass4 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Byte fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Byte.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getByte());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Byte b) {
            return context.createJSNumber((int) b.byteValue());
        }
    };
    private static final TypeAdapter<Character> CHARACTER_TYPE_ADAPTER = new TypeAdapter<Character>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass5 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Character fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            String string = ((JSString) jSValue.cast(JSString.class)).getString();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new JSDataException("Can't treat \"" + string + "\" as char");
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Character ch) {
            return context.createJSString(ch.toString());
        }
    };
    private static final TypeAdapter<Double> DOUBLE_TYPE_ADAPTER = new TypeAdapter<Double>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass10 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Double fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Double.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getDouble());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Double d) {
            return context.createJSNumber(d.doubleValue());
        }
    };
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass1 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == Void.TYPE) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.TYPE) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER;
            }
            if (type == Void.class) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.class) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER.nullable();
            }
            if (type == Byte.class) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER.nullable();
            }
            if (type == Character.class) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER.nullable();
            }
            if (type == Short.class) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER.nullable();
            }
            if (type == Integer.class) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER.nullable();
            }
            if (type == Long.class) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER.nullable();
            }
            if (type == Float.class) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER.nullable();
            }
            if (type == Double.class) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER.nullable();
            }
            if (type == String.class) {
                return StandardTypeAdapters.STRING_TYPE_ADAPTER.nullable();
            }
            return null;
        }
    };
    private static final TypeAdapter<Float> FLOAT_TYPE_ADAPTER = new TypeAdapter<Float>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass9 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Float fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Float.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getFloat());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Float f) {
            return context.createJSNumber((double) f.floatValue());
        }
    };
    private static final TypeAdapter<Integer> INTEGER_TYPE_ADAPTER = new TypeAdapter<Integer>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass7 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Integer fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Integer.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getInt());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Integer num) {
            return context.createJSNumber(num.intValue());
        }
    };
    private static final TypeAdapter<Long> LONG_TYPE_ADAPTER = new TypeAdapter<Long>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass8 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Long fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Long.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getLong());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Long l) {
            return context.createJSNumber(l.longValue());
        }
    };
    private static final TypeAdapter<Short> SHORT_TYPE_ADAPTER = new TypeAdapter<Short>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass6 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Short fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Short.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getShort());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Short sh) {
            return context.createJSNumber((int) sh.shortValue());
        }
    };
    private static final TypeAdapter<String> STRING_TYPE_ADAPTER = new TypeAdapter<String>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass11 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public String fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return ((JSString) jSValue.cast(JSString.class)).getString();
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, String str) {
            return context.createJSString(str);
        }
    };
    private static final TypeAdapter<Void> VOID_TYPE_ADAPTER = new TypeAdapter<Void>() {
        /* class com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.AnonymousClass2 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Void fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                return null;
            }
            throw new JSDataException("excepted: JSNull or JSUndefined, actual: " + jSValue.getClass().getSimpleName());
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Void r3) {
            return context.createJSNull();
        }
    };
}

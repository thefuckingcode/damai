package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import tb.jl1;

/* compiled from: Taobao */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        Enum r8;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        String str;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (i < length) {
            char c17 = i == length + -1 ? jl1.ARRAY_END : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new Integer(scanLongValue));
                    }
                    char c18 = jSONLexer.ch;
                    if (c18 == ',') {
                        int i2 = jSONLexer.bp + 1;
                        jSONLexer.bp = i2;
                        if (i2 >= jSONLexer.len) {
                            c16 = JSONLexer.EOI;
                        } else {
                            c16 = jSONLexer.text.charAt(i2);
                        }
                        jSONLexer.ch = c16;
                        jSONLexer.token = 16;
                    } else if (c18 == ']') {
                        int i3 = jSONLexer.bp + 1;
                        jSONLexer.bp = i3;
                        if (i3 >= jSONLexer.len) {
                            c15 = JSONLexer.EOI;
                        } else {
                            c15 = jSONLexer.text.charAt(i3);
                        }
                        jSONLexer.ch = c15;
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c19 = jSONLexer.ch;
                    if (c19 == '\"') {
                        str = jSONLexer.scanStringValue(jl1.QUOTE);
                    } else if (c19 != 'n' || !jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                        throw new JSONException("not match string. feild : " + obj);
                    } else {
                        int i4 = jSONLexer.bp + 4;
                        jSONLexer.bp = i4;
                        if (i4 >= jSONLexer.len) {
                            c14 = JSONLexer.EOI;
                        } else {
                            c14 = jSONLexer.text.charAt(i4);
                        }
                        jSONLexer.ch = c14;
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t, str);
                    } else {
                        fieldDeserializer.setValue(t, str);
                    }
                    char c20 = jSONLexer.ch;
                    if (c20 == ',') {
                        int i5 = jSONLexer.bp + 1;
                        jSONLexer.bp = i5;
                        if (i5 >= jSONLexer.len) {
                            c13 = JSONLexer.EOI;
                        } else {
                            c13 = jSONLexer.text.charAt(i5);
                        }
                        jSONLexer.ch = c13;
                        jSONLexer.token = 16;
                    } else if (c20 == ']') {
                        int i6 = jSONLexer.bp + 1;
                        jSONLexer.bp = i6;
                        if (i6 >= jSONLexer.len) {
                            c12 = JSONLexer.EOI;
                        } else {
                            c12 = jSONLexer.text.charAt(i6);
                        }
                        jSONLexer.ch = c12;
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t, new Long(scanLongValue2));
                        }
                        char c21 = jSONLexer.ch;
                        if (c21 == ',') {
                            int i7 = jSONLexer.bp + 1;
                            jSONLexer.bp = i7;
                            if (i7 >= jSONLexer.len) {
                                c11 = JSONLexer.EOI;
                            } else {
                                c11 = jSONLexer.text.charAt(i7);
                            }
                            jSONLexer.ch = c11;
                            jSONLexer.token = 16;
                        } else if (c21 == ']') {
                            int i8 = jSONLexer.bp + 1;
                            jSONLexer.bp = i8;
                            if (i8 >= jSONLexer.len) {
                                c10 = JSONLexer.EOI;
                            } else {
                                c10 = jSONLexer.text.charAt(i8);
                            }
                            jSONLexer.ch = c10;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t, Boolean.valueOf(scanBoolean));
                        }
                        char c22 = jSONLexer.ch;
                        if (c22 == ',') {
                            int i9 = jSONLexer.bp + 1;
                            jSONLexer.bp = i9;
                            if (i9 >= jSONLexer.len) {
                                c9 = JSONLexer.EOI;
                            } else {
                                c9 = jSONLexer.text.charAt(i9);
                            }
                            jSONLexer.ch = c9;
                            jSONLexer.token = 16;
                        } else if (c22 == ']') {
                            int i10 = jSONLexer.bp + 1;
                            jSONLexer.bp = i10;
                            if (i10 >= jSONLexer.len) {
                                c8 = JSONLexer.EOI;
                            } else {
                                c8 = jSONLexer.text.charAt(i10);
                            }
                            jSONLexer.ch = c8;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c23 = jSONLexer.ch;
                        if (c23 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            if (scanSymbol == null) {
                                r8 = null;
                            } else {
                                r8 = Enum.valueOf(cls, scanSymbol);
                            }
                        } else if (c23 < '0' || c23 > '9') {
                            throw new JSONException("illegal enum." + jSONLexer.info());
                        } else {
                            r8 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue(t, r8);
                        char c24 = jSONLexer.ch;
                        if (c24 == ',') {
                            int i11 = jSONLexer.bp + 1;
                            jSONLexer.bp = i11;
                            if (i11 >= jSONLexer.len) {
                                c7 = JSONLexer.EOI;
                            } else {
                                c7 = jSONLexer.text.charAt(i11);
                            }
                            jSONLexer.ch = c7;
                            jSONLexer.token = 16;
                        } else if (c24 == ']') {
                            int i12 = jSONLexer.bp + 1;
                            jSONLexer.bp = i12;
                            if (i12 >= jSONLexer.len) {
                                c6 = JSONLexer.EOI;
                            } else {
                                c6 = jSONLexer.text.charAt(i12);
                            }
                            jSONLexer.ch = c6;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.ch == '1') {
                        fieldDeserializer.setValue(t, new Date(jSONLexer.scanLongValue()));
                        char c25 = jSONLexer.ch;
                        if (c25 == ',') {
                            int i13 = jSONLexer.bp + 1;
                            jSONLexer.bp = i13;
                            if (i13 >= jSONLexer.len) {
                                c5 = JSONLexer.EOI;
                            } else {
                                c5 = jSONLexer.text.charAt(i13);
                            }
                            jSONLexer.ch = c5;
                            jSONLexer.token = 16;
                        } else if (c25 == ']') {
                            int i14 = jSONLexer.bp + 1;
                            jSONLexer.bp = i14;
                            if (i14 >= jSONLexer.len) {
                                c4 = JSONLexer.EOI;
                            } else {
                                c4 = jSONLexer.text.charAt(i14);
                            }
                            jSONLexer.ch = c4;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c26 = jSONLexer.ch;
                        if (c26 == '[') {
                            int i15 = jSONLexer.bp + 1;
                            jSONLexer.bp = i15;
                            if (i15 >= jSONLexer.len) {
                                c3 = JSONLexer.EOI;
                            } else {
                                c3 = jSONLexer.text.charAt(i15);
                            }
                            jSONLexer.ch = c3;
                            jSONLexer.token = 14;
                        } else if (c26 == '{') {
                            int i16 = jSONLexer.bp + 1;
                            jSONLexer.bp = i16;
                            if (i16 >= jSONLexer.len) {
                                c2 = JSONLexer.EOI;
                            } else {
                                c2 = jSONLexer.text.charAt(i16);
                            }
                            jSONLexer.ch = c2;
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t, fieldInfo.fieldType, null);
                        if (c17 == ']') {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (c17 == ',' && jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i++;
                }
                i++;
            } catch (IllegalAccessException e) {
                throw new JSONException("set " + fieldInfo.name + "error", e);
            }
        }
        if (jSONLexer.ch == ',') {
            int i17 = jSONLexer.bp + 1;
            jSONLexer.bp = i17;
            if (i17 >= jSONLexer.len) {
                c = JSONLexer.EOI;
            } else {
                c = jSONLexer.text.charAt(i17);
            }
            jSONLexer.ch = c;
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t;
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        boolean z;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            long fnv_64_lower = TypeUtils.fnv_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i].fieldInfo.name);
                    i++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    int i2 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i2 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i2].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i2;
                        }
                        i2++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i3 = this.smartMatchHashArrayMapping[binarySearch];
                if (i3 != -1) {
                    fieldDeserializer = this.sortedFieldDeserializers[i3];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                        fieldDeserializer = null;
                    }
                }
            }
        }
        int i4 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && !((defaultJSONParser.lexer.features & i4) == 0 && (i4 & this.beanInfo.parserFeatures) == 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class<?> cls2 = this.clazz;
                while (cls2 != null && cls2 != Object.class) {
                    Field[] declaredFields = cls2.getDeclaredFields();
                    for (Field field : declaredFields) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    /* access modifiers changed from: protected */
    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Constructor<?> constructor = javaBeanInfo.defaultConstructor;
            if (constructor == null && javaBeanInfo.factoryMethod == null) {
                return null;
            }
            Method method = javaBeanInfo.factoryMethod;
            if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
                return null;
            }
            try {
                if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                    obj = constructor.newInstance(defaultJSONParser.contex.object);
                } else if (constructor != null) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = method.invoke(null, new Object[0]);
                }
                if (!(defaultJSONParser == null || (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0)) {
                    FieldInfo[] fieldInfoArr = this.beanInfo.fields;
                    for (FieldInfo fieldInfo : fieldInfoArr) {
                        if (fieldInfo.fieldClass == String.class) {
                            fieldInfo.set(obj, "");
                        }
                    }
                }
                return obj;
            } catch (Exception e) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    /* access modifiers changed from: protected */
    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (this.beanInfo.ordered) {
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr.length) {
                    return null;
                }
                FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
                if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                    return fieldDeserializer;
                }
                i++;
            }
        } else {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i2];
                } else {
                    length = i2 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public FieldDeserializer getFieldDeserializerByHash(long j) {
        int i = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
            if (fieldDeserializer.fieldInfo.nameHashCode == j) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) != 0) {
            jSONLexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
            Type type = null;
            List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
            if (list != null) {
                for (ExtraTypeProvider extraTypeProvider : list) {
                    type = extraTypeProvider.getExtraType(obj, str);
                }
            }
            if (type == null) {
                obj2 = defaultJSONParser.parse();
            } else {
                obj2 = defaultJSONParser.parseObject(type);
            }
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, obj2);
                return;
            }
            List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
            if (list2 != null) {
                for (ExtraProcessor extraProcessor : list2) {
                    extraProcessor.processExtra(obj, str, obj2);
                }
                return;
            }
            return;
        }
        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            String[] strArr = fieldInfo.alternateNames;
            for (String str : strArr) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:212:0x02da, code lost:
        if (r0 == 16) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        r14.nextTokenWithChar(tb.jl1.CONDITION_IF_MIDDLE);
        r0 = r14.token;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x02f8, code lost:
        if (r0 != 4) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x02fa, code lost:
        r0 = r14.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0304, code lost:
        if (tb.o70.DINAMIC_PREFIX_AT.equals(r0) == false) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0306, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x030a, code lost:
        r2 = (T) r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x030c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x030d, code lost:
        r11 = r1;
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0312, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x031a, code lost:
        if ("..".equals(r0) == false) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x031c, code lost:
        r2 = r1.parent;
        r3 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0320, code lost:
        if (r3 == null) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0322, code lost:
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0325, code lost:
        r45.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0330, code lost:
        r2 = (T) r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0339, code lost:
        if ("$".equals(r0) == false) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x033b, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x033c, code lost:
        r3 = r2.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x033e, code lost:
        if (r3 == null) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0340, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0342, code lost:
        r3 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0344, code lost:
        if (r3 == null) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0347, code lost:
        r45.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0353, code lost:
        r45.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        r14.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0366, code lost:
        if (r14.token != 13) goto L_0x037a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0368, code lost:
        r14.nextToken(16);
        r45.setContext(r1, r2, r47);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0372, code lost:
        if (r25 == null) goto L_0x0376;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0374, code lost:
        r25.object = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0376, code lost:
        r45.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0379, code lost:
        return (T) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x037a, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0383, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0384, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0386, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0387, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0389, code lost:
        r11 = r1;
        r10 = r2;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x038e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x038f, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0392, code lost:
        r1 = r22;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x03b0, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x03b1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x03b2, code lost:
        r11 = r1;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x03b4, code lost:
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x03cb, code lost:
        if (r0.equals(r4) == false) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0408, code lost:
        r14 = r26;
        r6 = r40;
        r11 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:458:0x0695, code lost:
        r21 = r25;
        r6 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:459:0x0699, code lost:
        if (r21 != null) goto L_0x0769;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:460:0x069b, code lost:
        if (r14 != null) goto L_0x06b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:462:?, code lost:
        r1 = (T) createInstance(r45, r46);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x06a1, code lost:
        if (r6 != null) goto L_0x06ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:?, code lost:
        r6 = r45.setContext(r11, r1, r47);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x06a8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x06a9, code lost:
        r10 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:468:0x06ac, code lost:
        if (r6 == null) goto L_0x06b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x06ae, code lost:
        r6.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x06b0, code lost:
        r45.setContext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x06b3, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x06b4, code lost:
        r0 = r44.beanInfo.creatorConstructorParameters;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x06b8, code lost:
        if (r0 == null) goto L_0x06bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x06ba, code lost:
        r1 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x06bc, code lost:
        r1 = r44.fieldDeserializers.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x06bf, code lost:
        r2 = new java.lang.Object[r1];
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:477:0x06c2, code lost:
        if (r3 >= r1) goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:478:0x06c4, code lost:
        r4 = r44.fieldDeserializers[r3].fieldInfo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:479:0x06ca, code lost:
        if (r0 == null) goto L_0x06d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x06cc, code lost:
        r5 = r14.remove(r4.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x06d3, code lost:
        r5 = r14.get(r4.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x06d9, code lost:
        if (r5 != null) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x06db, code lost:
        r5 = com.alibaba.fastjson.util.TypeUtils.defaultValue(r4.fieldClass);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x06e1, code lost:
        r2[r3] = r5;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x06e6, code lost:
        r1 = r44.beanInfo;
        r3 = r1.creatorConstructor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x06ea, code lost:
        if (r3 == null) goto L_0x073b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:488:?, code lost:
        r1 = (T) r3.newInstance(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:489:0x06f0, code lost:
        if (r0 == null) goto L_0x076b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:490:0x06f2, code lost:
        r0 = r14.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:492:0x06fe, code lost:
        if (r0.hasNext() == false) goto L_0x076b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:493:0x0700, code lost:
        r2 = r0.next();
        r3 = getFieldDeserializer(r2.getKey());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x0710, code lost:
        if (r3 == null) goto L_0x06fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:495:0x0712, code lost:
        r3.setValue(r1, r2.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x071a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x073a, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r44.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x073b, code lost:
        r0 = r1.factoryMethod;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x073d, code lost:
        if (r0 == null) goto L_0x0769;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:?, code lost:
        r21 = r0.invoke(null, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x0745, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x0765, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r44.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0766, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x0769, code lost:
        r1 = (T) r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:509:0x076b, code lost:
        if (r6 == null) goto L_0x076f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x076d, code lost:
        r6.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x076f, code lost:
        r45.setContext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x0772, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x07b3, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r0.token));
     */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x04d2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0647  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x068f A[Catch:{ all -> 0x07bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0690 A[Catch:{ all -> 0x07bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:528:0x07c9  */
    private <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        ParseContext parseContext;
        Object obj3;
        Throwable th;
        long j;
        Class<?> cls;
        FieldInfo fieldInfo;
        FieldDeserializer fieldDeserializer;
        int i;
        ParseContext parseContext2;
        ParseContext parseContext3;
        int i2;
        Type type2;
        String str;
        String str2;
        float f;
        int i3;
        Object obj4;
        long j2;
        boolean z;
        boolean z2;
        double d;
        HashMap hashMap;
        Object obj5;
        double d2;
        FieldInfo fieldInfo2;
        String str3;
        ParseContext parseContext4;
        ParseContext parseContext5;
        Type type3;
        Class<Double> cls2;
        JSONLexer jSONLexer;
        Object obj6;
        String str4;
        boolean z3;
        int i4;
        Class<Float> cls3;
        Class<Double> cls4;
        JSONLexer jSONLexer2;
        int i5;
        int i6;
        Object obj7;
        Object obj8;
        String stringVal;
        Class<?> cls5;
        T t;
        FieldDeserializer fieldDeserializer2;
        double d3;
        Object valueOf;
        boolean z4;
        boolean z5;
        Class<Double> cls6 = Double.class;
        Class<Float> cls7 = Float.class;
        if (type == JSON.class || type == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexer jSONLexer3 = defaultJSONParser.lexer;
        int i7 = jSONLexer3.token;
        ParseContext parseContext6 = null;
        if (i7 == 8) {
            jSONLexer3.nextToken(16);
            return null;
        }
        boolean z6 = jSONLexer3.disableCircularReferenceDetect;
        ParseContext parseContext7 = defaultJSONParser.contex;
        if (!(obj2 == null || parseContext7 == null)) {
            parseContext7 = parseContext7.parent;
        }
        ParseContext parseContext8 = parseContext7;
        if (i7 == 13) {
            try {
                jSONLexer3.nextToken(16);
                T t2 = obj2 == null ? (T) createInstance(defaultJSONParser, type) : (T) obj2;
                defaultJSONParser.setContext(parseContext8);
                return t2;
            } catch (Throwable th2) {
                th = th2;
                obj8 = obj2;
                parseContext = parseContext8;
                obj3 = obj8;
                if (parseContext6 != null) {
                }
                defaultJSONParser.setContext(parseContext);
                throw th;
            }
        } else {
            if (i7 == 14) {
                if (this.beanInfo.supportBeanToArray || (jSONLexer3.features & Feature.SupportArrayToBean.mask) != 0) {
                    T t3 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                    defaultJSONParser.setContext(parseContext8);
                    return t3;
                }
            }
            if (i7 == 12 || i7 == 16) {
                try {
                    if (defaultJSONParser.resolveStatus == 2) {
                        defaultJSONParser.resolveStatus = 0;
                    }
                    String str5 = this.beanInfo.typeKey;
                    int length = this.sortedFieldDeserializers.length;
                    Object obj9 = obj2;
                    ParseContext parseContext9 = parseContext8;
                    ParseContext parseContext10 = null;
                    HashMap hashMap2 = null;
                    long j3 = 0;
                    int i8 = 0;
                    while (true) {
                        if (j3 != 0) {
                            try {
                                fieldDeserializer = getFieldDeserializerByHash(j3);
                                if (fieldDeserializer != null) {
                                    fieldInfo = fieldDeserializer.fieldInfo;
                                    cls = fieldInfo.fieldClass;
                                } else {
                                    fieldInfo = null;
                                    cls = null;
                                }
                                j = 0;
                            } catch (Throwable th3) {
                                th = th3;
                                Object obj10 = obj9;
                                parseContext = parseContext9;
                                parseContext6 = parseContext10;
                                obj3 = obj10;
                                if (parseContext6 != null) {
                                }
                                defaultJSONParser.setContext(parseContext);
                                throw th;
                            }
                        } else {
                            j = j3;
                            fieldDeserializer = null;
                            fieldInfo = null;
                            cls = null;
                        }
                        if (fieldDeserializer == null) {
                            if (i8 < length) {
                                fieldDeserializer = this.sortedFieldDeserializers[i8];
                                fieldInfo = fieldDeserializer.fieldInfo;
                                cls = fieldInfo.fieldClass;
                            }
                            i8++;
                        }
                        double d4 = 0.0d;
                        if (fieldDeserializer != null) {
                            str2 = str5;
                            long j4 = fieldInfo.nameHashCode;
                            i2 = length;
                            i = i8;
                            if (cls != Integer.TYPE) {
                                if (cls != Integer.class) {
                                    if (cls != Long.TYPE) {
                                        if (cls != Long.class) {
                                            if (cls == String.class) {
                                                valueOf = jSONLexer3.scanFieldString(j4);
                                                int i9 = jSONLexer3.matchStat;
                                                if (i9 <= 0) {
                                                    if (i9 == -2) {
                                                        j3 = jSONLexer3.fieldHash;
                                                        i8 = i;
                                                        str5 = str2;
                                                        length = i2;
                                                    }
                                                    z2 = false;
                                                    z = false;
                                                    i3 = 0;
                                                    f = 0.0f;
                                                    d3 = 0.0d;
                                                    obj4 = valueOf;
                                                    j2 = 0;
                                                    d = d3;
                                                    if (z2) {
                                                        fieldInfo2 = fieldInfo;
                                                        try {
                                                            String scanSymbol = jSONLexer3.scanSymbol(defaultJSONParser.symbolTable);
                                                            if (scanSymbol == null) {
                                                                d2 = d;
                                                                int i10 = jSONLexer3.token;
                                                                if (i10 == 13) {
                                                                    jSONLexer3.nextToken(16);
                                                                    parseContext2 = parseContext9;
                                                                    parseContext3 = parseContext10;
                                                                    break;
                                                                }
                                                            } else {
                                                                d2 = d;
                                                            }
                                                            char c = jl1.CONDITION_IF_MIDDLE;
                                                            if ("$ref" != scanSymbol || parseContext9 == null) {
                                                                parseContext2 = parseContext9;
                                                                parseContext3 = parseContext10;
                                                                if (str2 != null) {
                                                                    str = str2;
                                                                    try {
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                        obj5 = obj9;
                                                                        parseContext6 = parseContext3;
                                                                        parseContext = parseContext2;
                                                                        obj3 = obj5;
                                                                        if (parseContext6 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    str = str2;
                                                                }
                                                                if (JSON.DEFAULT_TYPE_KEY == scanSymbol) {
                                                                    c = jl1.CONDITION_IF_MIDDLE;
                                                                    try {
                                                                        jSONLexer3.nextTokenWithChar(c);
                                                                        if (jSONLexer3.token == 4) {
                                                                            stringVal = jSONLexer3.stringVal();
                                                                            jSONLexer3.nextToken(16);
                                                                            type2 = type;
                                                                            if (!(type2 instanceof Class) || !stringVal.equals(((Class) type2).getName())) {
                                                                                JavaBeanDeserializer seeAlso = getSeeAlso(defaultJSONParser.config, this.beanInfo, stringVal);
                                                                            } else {
                                                                                if (jSONLexer3.token == 13) {
                                                                                    jSONLexer3.nextToken();
                                                                                    break;
                                                                                }
                                                                                i8 = i;
                                                                                str5 = str;
                                                                                j3 = j;
                                                                                length = i2;
                                                                                parseContext10 = parseContext3;
                                                                                parseContext9 = parseContext2;
                                                                            }
                                                                        } else {
                                                                            parseContext8 = parseContext2;
                                                                            try {
                                                                                throw new JSONException("syntax error");
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                                parseContext6 = parseContext3;
                                                                                obj8 = obj9;
                                                                                parseContext = parseContext8;
                                                                                obj3 = obj8;
                                                                                if (parseContext6 != null) {
                                                                                }
                                                                                defaultJSONParser.setContext(parseContext);
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        parseContext6 = parseContext3;
                                                                        obj5 = obj9;
                                                                        parseContext = parseContext2;
                                                                        obj3 = obj5;
                                                                        if (parseContext6 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    str2 = str;
                                                                    str3 = scanSymbol;
                                                                    parseContext5 = parseContext3;
                                                                    parseContext4 = parseContext2;
                                                                    type3 = type;
                                                                }
                                                            } else {
                                                                try {
                                                                    break;
                                                                } catch (Throwable th7) {
                                                                    th = th7;
                                                                    parseContext6 = parseContext10;
                                                                    obj3 = obj9;
                                                                    parseContext = parseContext9;
                                                                    if (parseContext6 != null) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            parseContext6 = parseContext10;
                                                            obj3 = obj9;
                                                            parseContext = parseContext9;
                                                            if (parseContext6 != null) {
                                                            }
                                                            defaultJSONParser.setContext(parseContext);
                                                            throw th;
                                                        }
                                                    } else {
                                                        d2 = d;
                                                        fieldInfo2 = fieldInfo;
                                                        parseContext4 = parseContext9;
                                                        parseContext5 = parseContext10;
                                                        type3 = type;
                                                        str3 = null;
                                                    }
                                                    if (obj9 == null || hashMap2 != null) {
                                                        parseContext3 = parseContext5;
                                                        cls2 = cls6;
                                                        jSONLexer = jSONLexer3;
                                                        obj5 = obj9;
                                                    } else {
                                                        parseContext3 = parseContext5;
                                                        try {
                                                            Object createInstance = createInstance(defaultJSONParser, type);
                                                            if (createInstance == null) {
                                                                jSONLexer = jSONLexer3;
                                                                try {
                                                                    cls2 = cls6;
                                                                    hashMap2 = new HashMap(this.fieldDeserializers.length);
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    obj5 = createInstance;
                                                                    parseContext = parseContext4;
                                                                    parseContext6 = parseContext3;
                                                                    obj3 = obj5;
                                                                    if (parseContext6 != null) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                            } else {
                                                                cls2 = cls6;
                                                                jSONLexer = jSONLexer3;
                                                            }
                                                            if (!z6) {
                                                                parseContext3 = defaultJSONParser.setContext(parseContext4, createInstance, obj);
                                                                hashMap = hashMap2;
                                                                obj5 = createInstance;
                                                                if (z2) {
                                                                    if (!z) {
                                                                        try {
                                                                            fieldDeserializer.parseField(defaultJSONParser, obj5, type3, hashMap);
                                                                            z3 = z6;
                                                                            cls3 = cls7;
                                                                            jSONLexer2 = jSONLexer;
                                                                            str4 = str2;
                                                                            i4 = i2;
                                                                            cls4 = cls2;
                                                                            parseContext = parseContext4;
                                                                            obj6 = obj5;
                                                                            i5 = 13;
                                                                        } catch (Throwable th10) {
                                                                            th = th10;
                                                                            parseContext = parseContext4;
                                                                            parseContext6 = parseContext3;
                                                                            obj3 = obj5;
                                                                            if (parseContext6 != null) {
                                                                            }
                                                                            defaultJSONParser.setContext(parseContext);
                                                                            throw th;
                                                                        }
                                                                    } else {
                                                                        if (obj5 == null) {
                                                                            if (cls != Integer.TYPE) {
                                                                                if (cls != Integer.class) {
                                                                                    if (cls != Long.TYPE) {
                                                                                        if (cls != Long.class) {
                                                                                            if (cls != Float.TYPE) {
                                                                                                if (cls != cls7) {
                                                                                                    cls4 = cls2;
                                                                                                    if (cls != Double.TYPE) {
                                                                                                        if (cls != cls4) {
                                                                                                            obj7 = obj4;
                                                                                                            hashMap.put(fieldInfo2.name, obj7);
                                                                                                            parseContext2 = parseContext4;
                                                                                                            z3 = z6;
                                                                                                        }
                                                                                                    }
                                                                                                    obj7 = new Double(d2);
                                                                                                    hashMap.put(fieldInfo2.name, obj7);
                                                                                                    parseContext2 = parseContext4;
                                                                                                    z3 = z6;
                                                                                                }
                                                                                            }
                                                                                            cls4 = cls2;
                                                                                            obj7 = new Float(f);
                                                                                            hashMap.put(fieldInfo2.name, obj7);
                                                                                            parseContext2 = parseContext4;
                                                                                            z3 = z6;
                                                                                        }
                                                                                    }
                                                                                    cls4 = cls2;
                                                                                    obj7 = Long.valueOf(j2);
                                                                                    hashMap.put(fieldInfo2.name, obj7);
                                                                                    parseContext2 = parseContext4;
                                                                                    z3 = z6;
                                                                                }
                                                                            }
                                                                            cls4 = cls2;
                                                                            obj7 = Integer.valueOf(i3);
                                                                            hashMap.put(fieldInfo2.name, obj7);
                                                                            parseContext2 = parseContext4;
                                                                            z3 = z6;
                                                                        } else {
                                                                            z3 = z6;
                                                                            cls4 = cls2;
                                                                            parseContext2 = parseContext4;
                                                                            if (obj4 == null) {
                                                                                try {
                                                                                    Class<?> cls8 = Integer.TYPE;
                                                                                    if (cls != cls8) {
                                                                                        if (cls != Integer.class) {
                                                                                            Class<?> cls9 = Long.TYPE;
                                                                                            if (cls != cls9) {
                                                                                                if (cls != Long.class) {
                                                                                                    Class<?> cls10 = Float.TYPE;
                                                                                                    if (cls != cls10) {
                                                                                                        if (cls != cls7) {
                                                                                                            Class<?> cls11 = Double.TYPE;
                                                                                                            if (cls != cls11) {
                                                                                                                if (cls != cls4) {
                                                                                                                    fieldDeserializer.setValue(obj5, obj4);
                                                                                                                }
                                                                                                            }
                                                                                                            if (!fieldInfo2.fieldAccess || cls != cls11) {
                                                                                                                fieldDeserializer.setValue(obj5, new Double(d2));
                                                                                                            } else {
                                                                                                                fieldDeserializer.setValue(obj5, d2);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (!fieldInfo2.fieldAccess || cls != cls10) {
                                                                                                        fieldDeserializer.setValue(obj5, new Float(f));
                                                                                                    } else {
                                                                                                        fieldDeserializer.setValue(obj5, f);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (!fieldInfo2.fieldAccess || cls != cls9) {
                                                                                                fieldDeserializer.setValue(obj5, Long.valueOf(j2));
                                                                                            } else {
                                                                                                fieldDeserializer.setValue(obj5, j2);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (!fieldInfo2.fieldAccess || cls != cls8) {
                                                                                        fieldDeserializer.setValue(obj5, Integer.valueOf(i3));
                                                                                    } else {
                                                                                        fieldDeserializer.setValue(obj5, i3);
                                                                                    }
                                                                                } catch (IllegalAccessException e) {
                                                                                    throw new JSONException("set property error, " + fieldInfo2.name, e);
                                                                                } catch (Throwable th11) {
                                                                                    th = th11;
                                                                                    parseContext6 = parseContext3;
                                                                                    parseContext = parseContext2;
                                                                                    obj3 = obj5;
                                                                                    if (parseContext6 != null) {
                                                                                    }
                                                                                    defaultJSONParser.setContext(parseContext);
                                                                                    throw th;
                                                                                }
                                                                            } else {
                                                                                fieldDeserializer.setValue(obj5, obj4);
                                                                            }
                                                                        }
                                                                        jSONLexer2 = jSONLexer;
                                                                        obj6 = obj5;
                                                                        if (jSONLexer2.matchStat == 4) {
                                                                            parseContext = parseContext2;
                                                                            break;
                                                                        }
                                                                        cls3 = cls7;
                                                                        str4 = str2;
                                                                        i4 = i2;
                                                                        parseContext = parseContext2;
                                                                        i5 = 13;
                                                                    }
                                                                    i6 = jSONLexer2.token;
                                                                    if (i6 == 16) {
                                                                        if (i6 == i5) {
                                                                            jSONLexer2.nextToken(16);
                                                                            break;
                                                                        }
                                                                        if (i6 == 18 || i6 == 1) {
                                                                        }
                                                                        i8 = i;
                                                                        parseContext9 = parseContext;
                                                                        hashMap2 = hashMap;
                                                                        cls6 = cls4;
                                                                        cls7 = cls3;
                                                                        length = i4;
                                                                        z6 = z3;
                                                                        str5 = str4;
                                                                        obj9 = obj6;
                                                                        j3 = j;
                                                                        parseContext10 = parseContext3;
                                                                        jSONLexer3 = jSONLexer2;
                                                                    }
                                                                } else {
                                                                    z3 = z6;
                                                                    jSONLexer2 = jSONLexer;
                                                                    str4 = str2;
                                                                    cls4 = cls2;
                                                                    i4 = i2;
                                                                    cls3 = cls7;
                                                                    parseContext = parseContext4;
                                                                    obj6 = obj5;
                                                                    i5 = 13;
                                                                    try {
                                                                        if (parseField(defaultJSONParser, str3, obj5, type, hashMap)) {
                                                                            if (jSONLexer2.token == 17) {
                                                                                throw new JSONException("syntax error, unexpect token ':'");
                                                                            }
                                                                            i6 = jSONLexer2.token;
                                                                            if (i6 == 16) {
                                                                            }
                                                                        } else if (jSONLexer2.token == 13) {
                                                                            jSONLexer2.nextToken();
                                                                            break;
                                                                        }
                                                                    } catch (Throwable th12) {
                                                                        th = th12;
                                                                        obj5 = obj6;
                                                                        parseContext6 = parseContext3;
                                                                        obj3 = obj5;
                                                                        if (parseContext6 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                }
                                                                i8 = i;
                                                                parseContext9 = parseContext;
                                                                hashMap2 = hashMap;
                                                                cls6 = cls4;
                                                                cls7 = cls3;
                                                                length = i4;
                                                                z6 = z3;
                                                                str5 = str4;
                                                                obj9 = obj6;
                                                                j3 = j;
                                                                parseContext10 = parseContext3;
                                                                jSONLexer3 = jSONLexer2;
                                                            } else {
                                                                obj5 = createInstance;
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            parseContext = parseContext4;
                                                            obj5 = obj9;
                                                            parseContext6 = parseContext3;
                                                            obj3 = obj5;
                                                            if (parseContext6 != null) {
                                                                parseContext6.object = obj3;
                                                            }
                                                            defaultJSONParser.setContext(parseContext);
                                                            throw th;
                                                        }
                                                    }
                                                    hashMap = hashMap2;
                                                    if (z2) {
                                                    }
                                                    i8 = i;
                                                    parseContext9 = parseContext;
                                                    hashMap2 = hashMap;
                                                    cls6 = cls4;
                                                    cls7 = cls3;
                                                    length = i4;
                                                    z6 = z3;
                                                    str5 = str4;
                                                    obj9 = obj6;
                                                    j3 = j;
                                                    parseContext10 = parseContext3;
                                                    jSONLexer3 = jSONLexer2;
                                                }
                                            } else if (cls == Date.class) {
                                                valueOf = jSONLexer3.scanFieldDate(j4);
                                                int i11 = jSONLexer3.matchStat;
                                                if (i11 <= 0) {
                                                    if (i11 == -2) {
                                                        j3 = jSONLexer3.fieldHash;
                                                        i8 = i;
                                                        str5 = str2;
                                                        length = i2;
                                                    }
                                                    z2 = false;
                                                    z = false;
                                                    i3 = 0;
                                                    f = 0.0f;
                                                    d3 = 0.0d;
                                                    obj4 = valueOf;
                                                    j2 = 0;
                                                    d = d3;
                                                    if (z2) {
                                                    }
                                                    if (obj9 == null) {
                                                    }
                                                    parseContext3 = parseContext5;
                                                    cls2 = cls6;
                                                    jSONLexer = jSONLexer3;
                                                    obj5 = obj9;
                                                    hashMap = hashMap2;
                                                    if (z2) {
                                                    }
                                                    i8 = i;
                                                    parseContext9 = parseContext;
                                                    hashMap2 = hashMap;
                                                    cls6 = cls4;
                                                    cls7 = cls3;
                                                    length = i4;
                                                    z6 = z3;
                                                    str5 = str4;
                                                    obj9 = obj6;
                                                    j3 = j;
                                                    parseContext10 = parseContext3;
                                                    jSONLexer3 = jSONLexer2;
                                                }
                                            } else {
                                                if (cls != Boolean.TYPE) {
                                                    if (cls != Boolean.class) {
                                                        if (cls != Float.TYPE) {
                                                            if (cls != cls7) {
                                                                if (cls != Double.TYPE) {
                                                                    if (cls != cls6) {
                                                                        if (fieldInfo.isEnum && (defaultJSONParser.config.getDeserializer(cls) instanceof EnumDeserializer)) {
                                                                            long scanFieldSymbol = jSONLexer3.scanFieldSymbol(j4);
                                                                            int i12 = jSONLexer3.matchStat;
                                                                            if (i12 > 0) {
                                                                                valueOf = fieldDeserializer.getEnumByHashCode(scanFieldSymbol);
                                                                                z5 = true;
                                                                                z4 = true;
                                                                            } else if (i12 == -2) {
                                                                                j3 = jSONLexer3.fieldHash;
                                                                                i8 = i;
                                                                                str5 = str2;
                                                                                length = i2;
                                                                            } else {
                                                                                valueOf = null;
                                                                                z5 = false;
                                                                                z4 = false;
                                                                            }
                                                                            z = z4;
                                                                            i3 = 0;
                                                                            f = 0.0f;
                                                                            z2 = z5;
                                                                            d3 = 0.0d;
                                                                            obj4 = valueOf;
                                                                            j2 = 0;
                                                                            d = d3;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj9 == null) {
                                                                            }
                                                                            parseContext3 = parseContext5;
                                                                            cls2 = cls6;
                                                                            jSONLexer = jSONLexer3;
                                                                            obj5 = obj9;
                                                                            hashMap = hashMap2;
                                                                            if (z2) {
                                                                            }
                                                                            i8 = i;
                                                                            parseContext9 = parseContext;
                                                                            hashMap2 = hashMap;
                                                                            cls6 = cls4;
                                                                            cls7 = cls3;
                                                                            length = i4;
                                                                            z6 = z3;
                                                                            str5 = str4;
                                                                            obj9 = obj6;
                                                                            j3 = j;
                                                                            parseContext10 = parseContext3;
                                                                            jSONLexer3 = jSONLexer2;
                                                                        } else if (cls == int[].class) {
                                                                            valueOf = jSONLexer3.scanFieldIntArray(j4);
                                                                            int i13 = jSONLexer3.matchStat;
                                                                            if (i13 <= 0) {
                                                                                if (i13 == -2) {
                                                                                    j3 = jSONLexer3.fieldHash;
                                                                                    i8 = i;
                                                                                    str5 = str2;
                                                                                    length = i2;
                                                                                }
                                                                                z2 = false;
                                                                                z = false;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                d3 = 0.0d;
                                                                                obj4 = valueOf;
                                                                                j2 = 0;
                                                                                d = d3;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                        } else if (cls == float[].class) {
                                                                            valueOf = jSONLexer3.scanFieldFloatArray(j4);
                                                                            int i14 = jSONLexer3.matchStat;
                                                                            if (i14 <= 0) {
                                                                                if (i14 == -2) {
                                                                                    j3 = jSONLexer3.fieldHash;
                                                                                    i8 = i;
                                                                                    str5 = str2;
                                                                                    length = i2;
                                                                                }
                                                                                z2 = false;
                                                                                z = false;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                d3 = 0.0d;
                                                                                obj4 = valueOf;
                                                                                j2 = 0;
                                                                                d = d3;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                        } else if (cls == double[].class) {
                                                                            valueOf = jSONLexer3.scanFieldDoubleArray(j4);
                                                                            int i15 = jSONLexer3.matchStat;
                                                                            if (i15 <= 0) {
                                                                                if (i15 == -2) {
                                                                                    j3 = jSONLexer3.fieldHash;
                                                                                    i8 = i;
                                                                                    str5 = str2;
                                                                                    length = i2;
                                                                                }
                                                                                z2 = false;
                                                                                z = false;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                d3 = 0.0d;
                                                                                obj4 = valueOf;
                                                                                j2 = 0;
                                                                                d = d3;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                        } else if (cls == float[][].class) {
                                                                            valueOf = jSONLexer3.scanFieldFloatArray2(j4);
                                                                            int i16 = jSONLexer3.matchStat;
                                                                            if (i16 <= 0) {
                                                                                if (i16 == -2) {
                                                                                    j3 = jSONLexer3.fieldHash;
                                                                                    i8 = i;
                                                                                    str5 = str2;
                                                                                    length = i2;
                                                                                }
                                                                                z2 = false;
                                                                                z = false;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                d3 = 0.0d;
                                                                                obj4 = valueOf;
                                                                                j2 = 0;
                                                                                d = d3;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                        } else if (cls == double[][].class) {
                                                                            valueOf = jSONLexer3.scanFieldDoubleArray2(j4);
                                                                            int i17 = jSONLexer3.matchStat;
                                                                            if (i17 <= 0) {
                                                                                if (i17 == -2) {
                                                                                    j3 = jSONLexer3.fieldHash;
                                                                                    i8 = i;
                                                                                    str5 = str2;
                                                                                    length = i2;
                                                                                }
                                                                                z2 = false;
                                                                                z = false;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                d3 = 0.0d;
                                                                                obj4 = valueOf;
                                                                                j2 = 0;
                                                                                d = d3;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                        } else {
                                                                            if (jSONLexer3.matchField(fieldInfo.nameHashCode)) {
                                                                                d = 0.0d;
                                                                                z2 = true;
                                                                                z = false;
                                                                                obj4 = null;
                                                                                i3 = 0;
                                                                                f = 0.0f;
                                                                                j2 = 0;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj9 == null) {
                                                                                }
                                                                                parseContext3 = parseContext5;
                                                                                cls2 = cls6;
                                                                                jSONLexer = jSONLexer3;
                                                                                obj5 = obj9;
                                                                                hashMap = hashMap2;
                                                                                if (z2) {
                                                                                }
                                                                                i8 = i;
                                                                                parseContext9 = parseContext;
                                                                                hashMap2 = hashMap;
                                                                                cls6 = cls4;
                                                                                cls7 = cls3;
                                                                                length = i4;
                                                                                z6 = z3;
                                                                                str5 = str4;
                                                                                obj9 = obj6;
                                                                                j3 = j;
                                                                                parseContext10 = parseContext3;
                                                                                jSONLexer3 = jSONLexer2;
                                                                            }
                                                                            type2 = type;
                                                                            parseContext2 = parseContext9;
                                                                            parseContext3 = parseContext10;
                                                                            str = str2;
                                                                            i8 = i;
                                                                            str5 = str;
                                                                            j3 = j;
                                                                            length = i2;
                                                                            parseContext10 = parseContext3;
                                                                            parseContext9 = parseContext2;
                                                                        }
                                                                    }
                                                                }
                                                                d4 = jSONLexer3.scanFieldDouble(j4);
                                                                int i18 = jSONLexer3.matchStat;
                                                                if (i18 > 0) {
                                                                    d = d4;
                                                                    z2 = true;
                                                                    z = true;
                                                                    obj4 = null;
                                                                    i3 = 0;
                                                                    f = 0.0f;
                                                                    j2 = 0;
                                                                    if (z2) {
                                                                    }
                                                                    if (obj9 == null) {
                                                                    }
                                                                    parseContext3 = parseContext5;
                                                                    cls2 = cls6;
                                                                    jSONLexer = jSONLexer3;
                                                                    obj5 = obj9;
                                                                    hashMap = hashMap2;
                                                                    if (z2) {
                                                                    }
                                                                    i8 = i;
                                                                    parseContext9 = parseContext;
                                                                    hashMap2 = hashMap;
                                                                    cls6 = cls4;
                                                                    cls7 = cls3;
                                                                    length = i4;
                                                                    z6 = z3;
                                                                    str5 = str4;
                                                                    obj9 = obj6;
                                                                    j3 = j;
                                                                    parseContext10 = parseContext3;
                                                                    jSONLexer3 = jSONLexer2;
                                                                } else if (i18 == -2) {
                                                                    j3 = jSONLexer3.fieldHash;
                                                                    i8 = i;
                                                                    str5 = str2;
                                                                    length = i2;
                                                                }
                                                            }
                                                        }
                                                        float scanFieldFloat = jSONLexer3.scanFieldFloat(j4);
                                                        int i19 = jSONLexer3.matchStat;
                                                        if (i19 > 0) {
                                                            f = scanFieldFloat;
                                                            d = 0.0d;
                                                            z2 = true;
                                                            z = true;
                                                        } else if (i19 == -2) {
                                                            j3 = jSONLexer3.fieldHash;
                                                            i8 = i;
                                                            str5 = str2;
                                                            length = i2;
                                                        } else {
                                                            f = scanFieldFloat;
                                                            d = 0.0d;
                                                            z2 = false;
                                                            z = false;
                                                        }
                                                        obj4 = null;
                                                        i3 = 0;
                                                        j2 = 0;
                                                        if (z2) {
                                                        }
                                                        if (obj9 == null) {
                                                        }
                                                        parseContext3 = parseContext5;
                                                        cls2 = cls6;
                                                        jSONLexer = jSONLexer3;
                                                        obj5 = obj9;
                                                        hashMap = hashMap2;
                                                        if (z2) {
                                                        }
                                                        i8 = i;
                                                        parseContext9 = parseContext;
                                                        hashMap2 = hashMap;
                                                        cls6 = cls4;
                                                        cls7 = cls3;
                                                        length = i4;
                                                        z6 = z3;
                                                        str5 = str4;
                                                        obj9 = obj6;
                                                        j3 = j;
                                                        parseContext10 = parseContext3;
                                                        jSONLexer3 = jSONLexer2;
                                                    }
                                                }
                                                valueOf = Boolean.valueOf(jSONLexer3.scanFieldBoolean(j4));
                                                int i20 = jSONLexer3.matchStat;
                                                if (i20 <= 0) {
                                                    if (i20 == -2) {
                                                        j3 = jSONLexer3.fieldHash;
                                                        i8 = i;
                                                        str5 = str2;
                                                        length = i2;
                                                    }
                                                    z2 = false;
                                                    z = false;
                                                    i3 = 0;
                                                    f = 0.0f;
                                                    d3 = 0.0d;
                                                    obj4 = valueOf;
                                                    j2 = 0;
                                                    d = d3;
                                                    if (z2) {
                                                    }
                                                    if (obj9 == null) {
                                                    }
                                                    parseContext3 = parseContext5;
                                                    cls2 = cls6;
                                                    jSONLexer = jSONLexer3;
                                                    obj5 = obj9;
                                                    hashMap = hashMap2;
                                                    if (z2) {
                                                    }
                                                    i8 = i;
                                                    parseContext9 = parseContext;
                                                    hashMap2 = hashMap;
                                                    cls6 = cls4;
                                                    cls7 = cls3;
                                                    length = i4;
                                                    z6 = z3;
                                                    str5 = str4;
                                                    obj9 = obj6;
                                                    j3 = j;
                                                    parseContext10 = parseContext3;
                                                    jSONLexer3 = jSONLexer2;
                                                }
                                            }
                                            z2 = true;
                                            z = true;
                                            i3 = 0;
                                            f = 0.0f;
                                            d3 = 0.0d;
                                            obj4 = valueOf;
                                            j2 = 0;
                                            d = d3;
                                            if (z2) {
                                            }
                                            if (obj9 == null) {
                                            }
                                            parseContext3 = parseContext5;
                                            cls2 = cls6;
                                            jSONLexer = jSONLexer3;
                                            obj5 = obj9;
                                            hashMap = hashMap2;
                                            if (z2) {
                                            }
                                            i8 = i;
                                            parseContext9 = parseContext;
                                            hashMap2 = hashMap;
                                            cls6 = cls4;
                                            cls7 = cls3;
                                            length = i4;
                                            z6 = z3;
                                            str5 = str4;
                                            obj9 = obj6;
                                            j3 = j;
                                            parseContext10 = parseContext3;
                                            jSONLexer3 = jSONLexer2;
                                        }
                                    }
                                    long scanFieldLong = jSONLexer3.scanFieldLong(j4);
                                    int i21 = jSONLexer3.matchStat;
                                    if (i21 > 0) {
                                        z2 = true;
                                        z = true;
                                    } else if (i21 == -2) {
                                        j3 = jSONLexer3.fieldHash;
                                        i8 = i;
                                        str5 = str2;
                                        length = i2;
                                    } else {
                                        z2 = false;
                                        z = false;
                                    }
                                    i3 = 0;
                                    f = 0.0f;
                                    d3 = 0.0d;
                                    obj4 = null;
                                    j2 = scanFieldLong;
                                    d = d3;
                                    if (z2) {
                                    }
                                    if (obj9 == null) {
                                    }
                                    parseContext3 = parseContext5;
                                    cls2 = cls6;
                                    jSONLexer = jSONLexer3;
                                    obj5 = obj9;
                                    hashMap = hashMap2;
                                    if (z2) {
                                    }
                                    i8 = i;
                                    parseContext9 = parseContext;
                                    hashMap2 = hashMap;
                                    cls6 = cls4;
                                    cls7 = cls3;
                                    length = i4;
                                    z6 = z3;
                                    str5 = str4;
                                    obj9 = obj6;
                                    j3 = j;
                                    parseContext10 = parseContext3;
                                    jSONLexer3 = jSONLexer2;
                                }
                            }
                            int scanFieldInt = jSONLexer3.scanFieldInt(j4);
                            int i22 = jSONLexer3.matchStat;
                            if (i22 > 0) {
                                i3 = scanFieldInt;
                                d = 0.0d;
                                z2 = true;
                                z = true;
                            } else if (i22 == -2) {
                                j3 = jSONLexer3.fieldHash;
                                i8 = i;
                                str5 = str2;
                                length = i2;
                            } else {
                                i3 = scanFieldInt;
                                d = 0.0d;
                                z2 = false;
                                z = false;
                            }
                            obj4 = null;
                            f = 0.0f;
                            j2 = 0;
                            if (z2) {
                            }
                            if (obj9 == null) {
                            }
                            parseContext3 = parseContext5;
                            cls2 = cls6;
                            jSONLexer = jSONLexer3;
                            obj5 = obj9;
                            hashMap = hashMap2;
                            if (z2) {
                            }
                            i8 = i;
                            parseContext9 = parseContext;
                            hashMap2 = hashMap;
                            cls6 = cls4;
                            cls7 = cls3;
                            length = i4;
                            z6 = z3;
                            str5 = str4;
                            obj9 = obj6;
                            j3 = j;
                            parseContext10 = parseContext3;
                            jSONLexer3 = jSONLexer2;
                        } else {
                            str2 = str5;
                            i2 = length;
                            i = i8;
                        }
                        d = d4;
                        z2 = false;
                        z = false;
                        obj4 = null;
                        i3 = 0;
                        f = 0.0f;
                        j2 = 0;
                        if (z2) {
                        }
                        if (obj9 == null) {
                        }
                        parseContext3 = parseContext5;
                        cls2 = cls6;
                        jSONLexer = jSONLexer3;
                        obj5 = obj9;
                        hashMap = hashMap2;
                        if (z2) {
                        }
                        i8 = i;
                        parseContext9 = parseContext;
                        hashMap2 = hashMap;
                        cls6 = cls4;
                        cls7 = cls3;
                        length = i4;
                        z6 = z3;
                        str5 = str4;
                        obj9 = obj6;
                        j3 = j;
                        parseContext10 = parseContext3;
                        jSONLexer3 = jSONLexer2;
                    }
                    JavaBeanDeserializer seeAlso2 = getSeeAlso(defaultJSONParser.config, this.beanInfo, stringVal);
                    if (seeAlso2 == null) {
                        Class<?> checkAutoType = defaultJSONParser.config.checkAutoType(stringVal, this.clazz, jSONLexer3.features);
                        Class<?> cls12 = TypeUtils.getClass(type);
                        if (cls12 == null || (checkAutoType != null && cls12.isAssignableFrom(checkAutoType))) {
                            seeAlso2 = defaultJSONParser.config.getDeserializer(checkAutoType);
                            cls5 = checkAutoType;
                        } else {
                            throw new JSONException("type not match");
                        }
                    } else {
                        cls5 = null;
                    }
                    if (seeAlso2 instanceof JavaBeanDeserializer) {
                        JavaBeanDeserializer javaBeanDeserializer = seeAlso2;
                        t = (T) javaBeanDeserializer.deserialze(defaultJSONParser, cls5, obj, null);
                        if (!(str == null || (fieldDeserializer2 = javaBeanDeserializer.getFieldDeserializer(str)) == null)) {
                            fieldDeserializer2.setValue(t, stringVal);
                        }
                    } else {
                        t = (T) seeAlso2.deserialze(defaultJSONParser, cls5, obj);
                    }
                    if (parseContext3 != null) {
                        parseContext3.object = obj9;
                    }
                    defaultJSONParser.setContext(parseContext2);
                    return t;
                } catch (Throwable th14) {
                    th = th14;
                    parseContext = parseContext8;
                    obj3 = obj2;
                    if (parseContext6 != null) {
                    }
                    defaultJSONParser.setContext(parseContext);
                    throw th;
                }
            } else if (jSONLexer3.isBlankInput()) {
                defaultJSONParser.setContext(parseContext8);
                return null;
            } else if (i7 == 4 && jSONLexer3.stringVal().length() == 0) {
                jSONLexer3.nextToken();
                defaultJSONParser.setContext(parseContext8);
                return null;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("syntax error, expect {, actual ");
                stringBuffer.append(jSONLexer3.info());
                if (obj instanceof String) {
                    stringBuffer.append(", fieldName ");
                    stringBuffer.append(obj);
                }
                throw new JSONException(stringBuffer.toString());
            }
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        double d;
        float f;
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                if (fieldDeserializer != null) {
                    Object value = entry.getValue();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Method method = fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        Field field = fieldInfo.field;
                        Type type = fieldInfo.fieldType;
                        if (type == Boolean.TYPE) {
                            if (value == Boolean.FALSE) {
                                field.setBoolean(createInstance, false);
                            } else if (value == Boolean.TRUE) {
                                field.setBoolean(createInstance, true);
                            }
                        } else if (type == Integer.TYPE) {
                            if (value instanceof Number) {
                                field.setInt(createInstance, ((Number) value).intValue());
                            }
                        } else if (type == Long.TYPE) {
                            if (value instanceof Number) {
                                field.setLong(createInstance, ((Number) value).longValue());
                            }
                        } else if (type == Float.TYPE) {
                            if (value instanceof Number) {
                                field.setFloat(createInstance, ((Number) value).floatValue());
                            } else if (value instanceof String) {
                                String str = (String) value;
                                if (str.length() <= 10) {
                                    f = TypeUtils.parseFloat(str);
                                } else {
                                    f = Float.parseFloat(str);
                                }
                                field.setFloat(createInstance, f);
                            }
                        } else if (type == Double.TYPE) {
                            if (value instanceof Number) {
                                field.setDouble(createInstance, ((Number) value).doubleValue());
                            } else if (value instanceof String) {
                                String str2 = (String) value;
                                if (str2.length() <= 10) {
                                    d = TypeUtils.parseDouble(str2);
                                } else {
                                    d = Double.parseDouble(str2);
                                }
                                field.setDouble(createInstance, d);
                            }
                        } else if (value != null && type == value.getClass()) {
                            field.set(createInstance, value);
                        }
                        String str3 = fieldDeserializer.fieldInfo.format;
                        if (str3 == null || type != Date.class || !(value instanceof String)) {
                            obj = type instanceof ParameterizedType ? TypeUtils.cast(value, (ParameterizedType) type, parserConfig) : TypeUtils.cast(value, type, parserConfig);
                        } else {
                            try {
                                obj = new SimpleDateFormat(str3).parse((String) value);
                            } catch (ParseException unused) {
                                obj = null;
                            }
                        }
                        field.set(createInstance, obj);
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo2 = fieldInfoArr[i];
            Object obj2 = map.get(fieldInfo2.name);
            if (obj2 == null) {
                obj2 = TypeUtils.defaultValue(fieldInfo2.fieldClass);
            }
            objArr[i] = obj2;
        }
        Constructor<?> constructor = this.beanInfo.creatorConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e);
        }
    }
}

package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class JavaBeanSerializer implements ObjectSerializer {
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        FieldSerializer[] fieldSerializerArr = this.sortedGetters;
        for (FieldSerializer fieldSerializer : fieldSerializerArr) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:274:0x03bc, code lost:
        if (r7.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue) == false) goto L_0x0408;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0166 A[SYNTHETIC, Splitter:B:110:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0213 A[Catch:{ Exception -> 0x05ab, all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0242 A[Catch:{ Exception -> 0x05ab, all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0257 A[Catch:{ Exception -> 0x05ab, all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x025e A[Catch:{ Exception -> 0x05ab, all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0264 A[Catch:{ Exception -> 0x05ab, all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0623 A[SYNTHETIC, Splitter:B:442:0x0623] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0259 A[EDGE_INSN: B:456:0x0259->B:172:0x0259 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0145  */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        FieldSerializer[] fieldSerializerArr;
        Throwable th;
        SerialContext serialContext;
        Exception exc;
        Exception e;
        boolean z;
        boolean z2;
        List<BeforeFilter> list;
        int i;
        List<AfterFilter> list2;
        int i2;
        int i3;
        List<PropertyFilter> list3;
        List<PropertyPreFilter> list4;
        List<ValueFilter> list5;
        List<NameFilter> list6;
        Class<String> cls;
        boolean z3;
        long j;
        boolean z4;
        int i4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        Object obj3;
        FieldInfo fieldInfo;
        String str2;
        Object obj4;
        boolean z8;
        int i5;
        Object obj5;
        Iterator<PropertyFilter> it;
        Object obj6;
        SerialContext serialContext2;
        IdentityHashMap<Object, SerialContext> identityHashMap;
        Object obj7 = obj;
        Class<String> cls2 = String.class;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj7 == null) {
            serializeWriter.writeNull();
            return;
        }
        SerialContext serialContext3 = jSONSerializer.context;
        if ((serialContext3 == null || (serialContext3.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj7)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        int i6 = serializeWriter.features;
        if ((SerializerFeature.SortField.mask & i6) != 0) {
            fieldSerializerArr = this.sortedGetters;
        } else {
            fieldSerializerArr = this.getters;
        }
        SerialContext serialContext4 = jSONSerializer.context;
        if ((i6 & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new SerialContext(serialContext4, obj7, obj2, this.features);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj7, jSONSerializer.context);
        }
        int i7 = this.features;
        int i8 = SerializerFeature.BeanToArray.mask;
        boolean z9 = ((i7 & i8) == 0 && (serializeWriter.features & i8) == 0) ? false : true;
        char c = z9 ? jl1.ARRAY_START : '{';
        char c2 = z9 ? jl1.ARRAY_END : '}';
        try {
            int i9 = serializeWriter.count + 1;
            if (i9 > serializeWriter.buf.length) {
                try {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i9);
                    } else {
                        serializeWriter.flush();
                        i9 = 1;
                    }
                } catch (Exception e2) {
                    exc = e2;
                    serialContext = serialContext4;
                    String str3 = "write javaBean error, fastjson version 1.1.71";
                    if (obj2 != null) {
                    }
                    throw new JSONException(str3, exc);
                } catch (Throwable th2) {
                    th = th2;
                    serialContext = serialContext4;
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            }
            serializeWriter.buf[serializeWriter.count] = c;
            serializeWriter.count = i9;
            if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            int i10 = this.features;
            int i11 = SerializerFeature.WriteClassName.mask;
            if ((i10 & i11) == 0) {
                int i12 = serializeWriter.features;
                if ((i11 & i12) == 0 || (type == null && (i12 & SerializerFeature.NotWriteRootClassName.mask) != 0 && ((serialContext2 = jSONSerializer.context) == null || serialContext2.parent == null))) {
                    z = false;
                    if (z || obj.getClass() == type) {
                        z2 = false;
                    } else {
                        String str4 = this.typeKey;
                        if (str4 == null) {
                            str4 = jSONSerializer.config.typeKey;
                        }
                        serializeWriter.writeFieldName(str4, false);
                        String str5 = this.typeName;
                        if (str5 == null) {
                            str5 = obj.getClass().getName();
                        }
                        jSONSerializer.write(str5);
                        z2 = true;
                    }
                    char c3 = !z2 ? ',' : 0;
                    list = jSONSerializer.beforeFilters;
                    if (list != null) {
                        for (BeforeFilter beforeFilter : list) {
                            c3 = beforeFilter.writeBefore(jSONSerializer, obj7, c3);
                        }
                    }
                    boolean z10 = c3 != ',';
                    int i13 = serializeWriter.features;
                    boolean z11 = (SerializerFeature.QuoteFieldNames.mask & i13) == 0 && (SerializerFeature.UseSingleQuotes.mask & i13) == 0;
                    boolean z12 = (SerializerFeature.UseSingleQuotes.mask & i13) == 0;
                    boolean z13 = (SerializerFeature.NotWriteDefaultValue.mask & i13) == 0;
                    List<PropertyFilter> list7 = jSONSerializer.propertyFilters;
                    boolean z14 = z10;
                    List<NameFilter> list8 = jSONSerializer.nameFilters;
                    List<ValueFilter> list9 = jSONSerializer.valueFilters;
                    List<PropertyPreFilter> list10 = jSONSerializer.propertyPreFilters;
                    i = 0;
                    while (i < fieldSerializerArr.length) {
                        try {
                            FieldSerializer fieldSerializer = fieldSerializerArr[i];
                            FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                            Class<?> cls3 = fieldInfo2.fieldClass;
                            String str6 = fieldInfo2.name;
                            if ((SerializerFeature.SkipTransientField.mask & serializeWriter.features) == 0 || fieldInfo2.field == null || !fieldInfo2.fieldTransient) {
                                String str7 = this.typeKey;
                                if (str7 == null || !str7.equals(str6)) {
                                    if (list10 != null) {
                                        Iterator<PropertyPreFilter> it2 = list10.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                if (!it2.next().apply(jSONSerializer, obj7, str6)) {
                                                    z3 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    z3 = true;
                                    if (z3) {
                                        Object obj8 = null;
                                        if (fieldInfo2.fieldAccess) {
                                            if (cls3 == Integer.TYPE) {
                                                j = 0;
                                                z5 = false;
                                                z4 = false;
                                                i4 = fieldInfo2.field.getInt(obj7);
                                                z6 = true;
                                            } else if (cls3 == Long.TYPE) {
                                                j = fieldInfo2.field.getLong(obj7);
                                                z6 = true;
                                                z5 = false;
                                                i4 = 0;
                                                z4 = false;
                                            } else if (cls3 == Boolean.TYPE) {
                                                z4 = fieldInfo2.field.getBoolean(obj7);
                                                j = 0;
                                                z6 = true;
                                                z5 = false;
                                                i4 = 0;
                                            } else {
                                                obj8 = fieldInfo2.field.get(obj7);
                                            }
                                            if (list7 == null) {
                                                if (z6) {
                                                    obj6 = obj8;
                                                    if (cls3 == Integer.TYPE) {
                                                        obj8 = Integer.valueOf(i4);
                                                    } else if (cls3 == Long.TYPE) {
                                                        obj8 = Long.valueOf(j);
                                                    } else if (cls3 == Boolean.TYPE) {
                                                        obj8 = Boolean.valueOf(z4);
                                                    }
                                                    z5 = true;
                                                    it = list7.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            break;
                                                        }
                                                        list4 = list10;
                                                        if (!it.next().apply(obj7, str6, obj8)) {
                                                            z7 = false;
                                                            break;
                                                        }
                                                        list10 = list4;
                                                    }
                                                } else {
                                                    obj6 = obj8;
                                                }
                                                obj8 = obj6;
                                                it = list7.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                    }
                                                    list10 = list4;
                                                }
                                            }
                                            list4 = list10;
                                            z7 = true;
                                            if (z7) {
                                                list5 = list9;
                                                list6 = list8;
                                                list3 = list7;
                                                cls = cls2;
                                                i++;
                                                cls2 = cls;
                                                fieldSerializerArr = fieldSerializerArr;
                                                z11 = z11;
                                                z13 = z13;
                                                list8 = list6;
                                                list9 = list5;
                                                list10 = list4;
                                                list7 = list3;
                                                obj7 = obj;
                                            } else {
                                                if (list8 != null) {
                                                    if (z6 && !z5) {
                                                        if (cls3 == Integer.TYPE) {
                                                            obj8 = Integer.valueOf(i4);
                                                        } else if (cls3 == Long.TYPE) {
                                                            obj8 = Long.valueOf(j);
                                                        } else if (cls3 == Boolean.TYPE) {
                                                            obj8 = Boolean.valueOf(z4);
                                                        }
                                                        z5 = true;
                                                    }
                                                    list6 = list8;
                                                    str = str6;
                                                    for (Iterator<NameFilter> it3 = list8.iterator(); it3.hasNext(); it3 = it3) {
                                                        str = it3.next().process(obj7, str, obj8);
                                                    }
                                                } else {
                                                    list6 = list8;
                                                    str = str6;
                                                }
                                                if (list9 != null) {
                                                    if (z6 && !z5) {
                                                        if (cls3 == Integer.TYPE) {
                                                            obj8 = Integer.valueOf(i4);
                                                        } else if (cls3 == Long.TYPE) {
                                                            obj8 = Long.valueOf(j);
                                                        } else if (cls3 == Boolean.TYPE) {
                                                            obj8 = Boolean.valueOf(z4);
                                                        }
                                                        z5 = true;
                                                    }
                                                    list5 = list9;
                                                    Object obj9 = obj8;
                                                    for (ValueFilter valueFilter : list9) {
                                                        obj9 = valueFilter.process(obj7, str6, obj9);
                                                        obj8 = obj8;
                                                    }
                                                    obj8 = obj9;
                                                    obj3 = obj8;
                                                } else {
                                                    list5 = list9;
                                                    obj3 = obj8;
                                                }
                                                if (!z5 || obj8 != null) {
                                                    obj5 = obj8;
                                                    fieldInfo = fieldInfo2;
                                                    list3 = list7;
                                                    cls = cls2;
                                                    str2 = "";
                                                } else {
                                                    obj5 = obj8;
                                                    list3 = list7;
                                                    int i14 = fieldInfo2.serialzeFeatures | this.features;
                                                    int i15 = serializeWriter.features;
                                                    int i16 = i14 | i15;
                                                    if (cls3 == Boolean.class) {
                                                        int i17 = SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                        fieldInfo = fieldInfo2;
                                                        int i18 = SerializerFeature.WriteMapNullValue.mask | i17;
                                                        if (!(!z9 && (i16 & i18) == 0 && (i18 & i15) == 0)) {
                                                            if ((i16 & i17) == 0 && (i17 & i15) == 0) {
                                                                obj4 = obj5;
                                                            } else {
                                                                obj4 = Boolean.FALSE;
                                                            }
                                                            cls = cls2;
                                                            str2 = "";
                                                        }
                                                        cls = cls2;
                                                        i++;
                                                        cls2 = cls;
                                                        fieldSerializerArr = fieldSerializerArr;
                                                        z11 = z11;
                                                        z13 = z13;
                                                        list8 = list6;
                                                        list9 = list5;
                                                        list10 = list4;
                                                        list7 = list3;
                                                        obj7 = obj;
                                                    } else {
                                                        fieldInfo = fieldInfo2;
                                                        cls = cls2;
                                                        if (cls3 == cls) {
                                                            int i19 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                            str2 = "";
                                                            int i20 = SerializerFeature.WriteMapNullValue.mask | i19;
                                                            if (!(!z9 && (i16 & i20) == 0 && (i20 & i15) == 0)) {
                                                                if (!((i16 & i19) == 0 && (i15 & i19) == 0)) {
                                                                    obj4 = str2;
                                                                }
                                                            }
                                                            i++;
                                                            cls2 = cls;
                                                            fieldSerializerArr = fieldSerializerArr;
                                                            z11 = z11;
                                                            z13 = z13;
                                                            list8 = list6;
                                                            list9 = list5;
                                                            list10 = list4;
                                                            list7 = list3;
                                                            obj7 = obj;
                                                        } else {
                                                            str2 = "";
                                                            if (Number.class.isAssignableFrom(cls3)) {
                                                                int i21 = SerializerFeature.WriteNullNumberAsZero.mask;
                                                                int i22 = SerializerFeature.WriteMapNullValue.mask | i21;
                                                                if (!(!z9 && (i16 & i22) == 0 && (i22 & serializeWriter.features) == 0)) {
                                                                    if (!((i16 & i21) == 0 && (serializeWriter.features & i21) == 0)) {
                                                                        obj4 = 0;
                                                                    }
                                                                }
                                                                i++;
                                                                cls2 = cls;
                                                                fieldSerializerArr = fieldSerializerArr;
                                                                z11 = z11;
                                                                z13 = z13;
                                                                list8 = list6;
                                                                list9 = list5;
                                                                list10 = list4;
                                                                list7 = list3;
                                                                obj7 = obj;
                                                            } else if (Collection.class.isAssignableFrom(cls3)) {
                                                                int i23 = SerializerFeature.WriteNullListAsEmpty.mask;
                                                                int i24 = SerializerFeature.WriteMapNullValue.mask | i23;
                                                                if (!(!z9 && (i16 & i24) == 0 && (i24 & serializeWriter.features) == 0)) {
                                                                    if (!((i16 & i23) == 0 && (serializeWriter.features & i23) == 0)) {
                                                                        obj4 = Collections.emptyList();
                                                                    }
                                                                }
                                                                i++;
                                                                cls2 = cls;
                                                                fieldSerializerArr = fieldSerializerArr;
                                                                z11 = z11;
                                                                z13 = z13;
                                                                list8 = list6;
                                                                list9 = list5;
                                                                list10 = list4;
                                                                list7 = list3;
                                                                obj7 = obj;
                                                            } else if (!z9) {
                                                                if (!fieldSerializer.writeNull) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (!z5 || obj4 == null || !z13 || (!((cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE || cls3 == Long.TYPE || cls3 == Float.TYPE || cls3 == Double.TYPE) && (obj4 instanceof Number) && ((Number) obj4).byteValue() == 0) && (cls3 != Boolean.TYPE || !(obj4 instanceof Boolean) || ((Boolean) obj4).booleanValue()))) {
                                                        if (!z14) {
                                                            int i25 = serializeWriter.count + 1;
                                                            if (i25 > serializeWriter.buf.length) {
                                                                if (serializeWriter.writer == null) {
                                                                    serializeWriter.expandCapacity(i25);
                                                                } else {
                                                                    serializeWriter.flush();
                                                                    i25 = 1;
                                                                }
                                                            }
                                                            serializeWriter.buf[serializeWriter.count] = ',';
                                                            serializeWriter.count = i25;
                                                            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                                jSONSerializer.println();
                                                            }
                                                        }
                                                        if (str == str6) {
                                                            if (!z9) {
                                                                serializeWriter.writeFieldName(str, true);
                                                            }
                                                            jSONSerializer.write(obj4);
                                                        } else if (obj3 != obj4) {
                                                            if (!z9) {
                                                                fieldSerializer.writePrefix(jSONSerializer);
                                                            }
                                                            jSONSerializer.write(obj4);
                                                        } else {
                                                            if (!z9) {
                                                                if (z11) {
                                                                    char[] cArr = fieldSerializer.name_chars;
                                                                    int length = cArr.length;
                                                                    int i26 = serializeWriter.count + length;
                                                                    if (i26 > serializeWriter.buf.length) {
                                                                        if (serializeWriter.writer == null) {
                                                                            serializeWriter.expandCapacity(i26);
                                                                        } else {
                                                                            int i27 = 0;
                                                                            do {
                                                                                char[] cArr2 = serializeWriter.buf;
                                                                                int length2 = cArr2.length;
                                                                                int i28 = serializeWriter.count;
                                                                                int i29 = length2 - i28;
                                                                                System.arraycopy(cArr, i27, cArr2, i28, i29);
                                                                                serializeWriter.count = serializeWriter.buf.length;
                                                                                serializeWriter.flush();
                                                                                length -= i29;
                                                                                i27 += i29;
                                                                            } while (length > serializeWriter.buf.length);
                                                                            i5 = i27;
                                                                            i26 = length;
                                                                            System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length);
                                                                            serializeWriter.count = i26;
                                                                        }
                                                                    }
                                                                    i5 = 0;
                                                                    System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length);
                                                                    serializeWriter.count = i26;
                                                                } else {
                                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                                }
                                                            }
                                                            if (!z6 || z5) {
                                                                if (z9) {
                                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                } else if (cls3 == cls) {
                                                                    int i30 = fieldSerializer.features | this.features;
                                                                    if (obj4 == null) {
                                                                        int i31 = serializeWriter.features;
                                                                        int i32 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                                        if ((i31 & i32) == 0 && (i30 & i32) == 0) {
                                                                            serializeWriter.writeNull();
                                                                        } else {
                                                                            serializeWriter.writeString(str2);
                                                                        }
                                                                    } else {
                                                                        String str8 = (String) obj4;
                                                                        if (z12) {
                                                                            serializeWriter.writeStringWithSingleQuote(str8);
                                                                        } else {
                                                                            serializeWriter.writeStringWithDoubleQuote(str8, 0, true);
                                                                        }
                                                                    }
                                                                } else if (!fieldInfo.isEnum) {
                                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                } else if (obj4 == null) {
                                                                    serializeWriter.writeNull();
                                                                } else if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                    String str9 = ((Enum) obj4).toString();
                                                                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                        serializeWriter.writeStringWithSingleQuote(str9);
                                                                    } else {
                                                                        serializeWriter.writeStringWithDoubleQuote(str9, 0, false);
                                                                    }
                                                                } else {
                                                                    serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                }
                                                                z14 = true;
                                                                i++;
                                                                cls2 = cls;
                                                                fieldSerializerArr = fieldSerializerArr;
                                                                z11 = z11;
                                                                z13 = z13;
                                                                list8 = list6;
                                                                list9 = list5;
                                                                list10 = list4;
                                                                list7 = list3;
                                                                obj7 = obj;
                                                            } else if (cls3 == Integer.TYPE) {
                                                                if (i4 == Integer.MIN_VALUE) {
                                                                    serializeWriter.write("-2147483648");
                                                                } else {
                                                                    int i33 = 0;
                                                                    while ((i4 < 0 ? -i4 : i4) > SerializeWriter.sizeTable[i33]) {
                                                                        i33++;
                                                                    }
                                                                    int i34 = i33 + 1;
                                                                    if (i4 < 0) {
                                                                        i34++;
                                                                    }
                                                                    int i35 = serializeWriter.count + i34;
                                                                    if (i35 > serializeWriter.buf.length) {
                                                                        if (serializeWriter.writer == null) {
                                                                            serializeWriter.expandCapacity(i35);
                                                                        } else {
                                                                            char[] cArr3 = new char[i34];
                                                                            SerializeWriter.getChars((long) i4, i34, cArr3);
                                                                            serializeWriter.write(cArr3, 0, i34);
                                                                            z8 = true;
                                                                            if (!z8) {
                                                                                SerializeWriter.getChars((long) i4, i35, serializeWriter.buf);
                                                                                serializeWriter.count = i35;
                                                                            }
                                                                        }
                                                                    }
                                                                    z8 = false;
                                                                    if (!z8) {
                                                                    }
                                                                }
                                                            } else if (cls3 == Long.TYPE) {
                                                                jSONSerializer.out.writeLong(j);
                                                            } else if (cls3 == Boolean.TYPE) {
                                                                if (z4) {
                                                                    SerializeWriter serializeWriter2 = jSONSerializer.out;
                                                                    char[] cArr4 = true_chars;
                                                                    serializeWriter2.write(cArr4, 0, cArr4.length);
                                                                } else {
                                                                    SerializeWriter serializeWriter3 = jSONSerializer.out;
                                                                    char[] cArr5 = false_chars;
                                                                    serializeWriter3.write(cArr5, 0, cArr5.length);
                                                                }
                                                            }
                                                        }
                                                        z14 = true;
                                                        i++;
                                                        cls2 = cls;
                                                        fieldSerializerArr = fieldSerializerArr;
                                                        z11 = z11;
                                                        z13 = z13;
                                                        list8 = list6;
                                                        list9 = list5;
                                                        list10 = list4;
                                                        list7 = list3;
                                                        obj7 = obj;
                                                    }
                                                    i++;
                                                    cls2 = cls;
                                                    fieldSerializerArr = fieldSerializerArr;
                                                    z11 = z11;
                                                    z13 = z13;
                                                    list8 = list6;
                                                    list9 = list5;
                                                    list10 = list4;
                                                    list7 = list3;
                                                    obj7 = obj;
                                                }
                                                obj4 = obj5;
                                                if (!z14) {
                                                }
                                                if (str == str6) {
                                                }
                                                z14 = true;
                                                i++;
                                                cls2 = cls;
                                                fieldSerializerArr = fieldSerializerArr;
                                                z11 = z11;
                                                z13 = z13;
                                                list8 = list6;
                                                list9 = list5;
                                                list10 = list4;
                                                list7 = list3;
                                                obj7 = obj;
                                            }
                                        } else {
                                            obj8 = fieldSerializer.getPropertyValue(obj7);
                                        }
                                        j = 0;
                                        z6 = false;
                                        z5 = true;
                                        i4 = 0;
                                        z4 = false;
                                        if (list7 == null) {
                                        }
                                        list4 = list10;
                                        z7 = true;
                                        if (z7) {
                                        }
                                    }
                                }
                            }
                            list5 = list9;
                            list6 = list8;
                            list4 = list10;
                            list3 = list7;
                            cls = cls2;
                            i++;
                            cls2 = cls;
                            fieldSerializerArr = fieldSerializerArr;
                            z11 = z11;
                            z13 = z13;
                            list8 = list6;
                            list9 = list5;
                            list10 = list4;
                            list7 = list3;
                            obj7 = obj;
                        } catch (Exception e3) {
                            exc = e3;
                            serialContext = serialContext4;
                            String str32 = "write javaBean error, fastjson version 1.1.71";
                            if (obj2 != null) {
                                try {
                                    str32 = str32 + ", fieldName : " + obj2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    th = th;
                                    jSONSerializer.context = serialContext;
                                    throw th;
                                }
                            }
                            throw new JSONException(str32, exc);
                        } catch (Throwable th4) {
                            th = th4;
                            serialContext = serialContext4;
                            jSONSerializer.context = serialContext;
                            throw th;
                        }
                    }
                    list2 = jSONSerializer.afterFilters;
                    if (list2 != null) {
                        char c4 = z14 ? ',' : 0;
                        for (AfterFilter afterFilter : list2) {
                            c4 = afterFilter.writeAfter(jSONSerializer, obj, c4);
                        }
                    }
                    if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                        jSONSerializer.decrementIdent();
                        jSONSerializer.println();
                    }
                    i2 = serializeWriter.count + 1;
                    if (i2 > serializeWriter.buf.length) {
                        if (serializeWriter.writer == null) {
                            serializeWriter.expandCapacity(i2);
                        } else {
                            serializeWriter.flush();
                            i3 = 1;
                            serializeWriter.buf[serializeWriter.count] = c2;
                            serializeWriter.count = i3;
                            jSONSerializer.context = serialContext4;
                        }
                    }
                    i3 = i2;
                    serializeWriter.buf[serializeWriter.count] = c2;
                    serializeWriter.count = i3;
                    jSONSerializer.context = serialContext4;
                }
            }
            z = true;
            if (z) {
            }
            z2 = false;
            if (!z2) {
            }
            list = jSONSerializer.beforeFilters;
            if (list != null) {
            }
            if (c3 != ',') {
            }
            int i132 = serializeWriter.features;
            if ((SerializerFeature.QuoteFieldNames.mask & i132) == 0) {
            }
            if ((SerializerFeature.UseSingleQuotes.mask & i132) == 0) {
            }
            if ((SerializerFeature.NotWriteDefaultValue.mask & i132) == 0) {
            }
            List<PropertyFilter> list72 = jSONSerializer.propertyFilters;
            boolean z142 = z10;
            List<NameFilter> list82 = jSONSerializer.nameFilters;
            List<ValueFilter> list92 = jSONSerializer.valueFilters;
            try {
                List<PropertyPreFilter> list102 = jSONSerializer.propertyPreFilters;
                i = 0;
                while (i < fieldSerializerArr.length) {
                }
                list2 = jSONSerializer.afterFilters;
                if (list2 != null) {
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                i2 = serializeWriter.count + 1;
                if (i2 > serializeWriter.buf.length) {
                }
                i3 = i2;
                serializeWriter.buf[serializeWriter.count] = c2;
                serializeWriter.count = i3;
                jSONSerializer.context = serialContext4;
            } catch (Exception e4) {
                e = e4;
                serialContext = serialContext4;
                exc = e;
                String str322 = "write javaBean error, fastjson version 1.1.71";
                if (obj2 != null) {
                }
                throw new JSONException(str322, exc);
            } catch (Throwable th5) {
                th = th5;
                serialContext = serialContext4;
                th = th;
                jSONSerializer.context = serialContext;
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            serialContext = serialContext4;
            exc = e;
            String str3222 = "write javaBean error, fastjson version 1.1.71";
            if (obj2 != null) {
            }
            throw new JSONException(str3222, exc);
        } catch (Throwable th6) {
            th = th6;
            serialContext = serialContext4;
            th = th;
            jSONSerializer.context = serialContext;
            throw th;
        }
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    public JavaBeanSerializer(Class<?> cls, int i, Map<String, String> map, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        PropertyNamingStrategy naming;
        this.features = 0;
        String[] strArr = null;
        JSONType jSONType = z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            str2 = jSONType.typeName();
            if (str2.length() == 0) {
                str2 = null;
                str = null;
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                str = null;
                while (superclass != null && superclass != Object.class) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str = jSONType2.typeKey();
                    if (str.length() != 0) {
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        str = jSONType3.typeKey();
                        if (str.length() != 0) {
                            break;
                        }
                    }
                }
                if (str != null && str.length() == 0) {
                    str = null;
                }
            }
            propertyNamingStrategy2 = (propertyNamingStrategy != null || (naming = jSONType.naming()) == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str2 = null;
            str = null;
        }
        this.typeName = str2;
        this.typeKey = str;
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        for (FieldInfo fieldInfo : computeGetters) {
            arrayList.add(new FieldSerializer(fieldInfo));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        strArr = jSONType != null ? jSONType.orders() : strArr;
        if (strArr == null || strArr.length == 0) {
            FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
            System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
            Arrays.sort(fieldSerializerArr2);
            if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
                this.sortedGetters = fieldSerializerArr;
            } else {
                this.sortedGetters = fieldSerializerArr2;
            }
        } else {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            for (FieldInfo fieldInfo2 : computeGetters2) {
                arrayList2.add(new FieldSerializer(fieldInfo2));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
        }
    }
}

package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ListTypeFieldDeserializer extends FieldDeserializer {
    private final boolean array;
    private ObjectDeserializer deserializer;
    private final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 14);
        Type type = fieldInfo.fieldType;
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            this.array = true;
            return;
        }
        this.itemType = TypeUtils.getCollectionItemType(type);
        this.array = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        int i;
        int i2;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        if (type instanceof ParameterizedType) {
            Class cls = null;
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() instanceof Class) {
                    cls = (Class) parameterizedType.getRawType();
                }
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        type2 = parameterizedType.getActualTypeArguments()[i2];
                        if (!type2.equals(this.itemType)) {
                            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
                        }
                    }
                }
                i2 = -1;
                if (i2 != -1) {
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    if (parameterizedType3.getRawType() instanceof Class) {
                        cls = (Class) parameterizedType3.getRawType();
                    }
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        i = 0;
                        while (true) {
                            if (i >= length2) {
                                break;
                            } else if (cls.getTypeParameters()[i].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                            type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                        }
                    }
                    i = -1;
                    if (i != -1) {
                    }
                }
            }
        } else if ((type2 instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    break;
                }
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i3];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length == 1) {
                        type2 = bounds[0];
                    }
                } else {
                    i3++;
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
            this.deserializer = objectDeserializer;
        }
        int i4 = jSONLexer.token;
        if (i4 == 14) {
            int i5 = 0;
            char c6 = jSONLexer.ch;
            int i6 = 15;
            char c7 = JSONLexer.EOI;
            if (c6 == '[') {
                int i7 = jSONLexer.bp + 1;
                jSONLexer.bp = i7;
                if (i7 >= jSONLexer.len) {
                    c5 = JSONLexer.EOI;
                } else {
                    c5 = jSONLexer.text.charAt(i7);
                }
                jSONLexer.ch = c5;
                jSONLexer.token = 14;
            } else if (c6 == '{') {
                int i8 = jSONLexer.bp + 1;
                jSONLexer.bp = i8;
                if (i8 >= jSONLexer.len) {
                    c4 = JSONLexer.EOI;
                } else {
                    c4 = jSONLexer.text.charAt(i8);
                }
                jSONLexer.ch = c4;
                jSONLexer.token = 12;
            } else if (c6 == '\"') {
                jSONLexer.scanString();
            } else if (c6 == ']') {
                int i9 = jSONLexer.bp + 1;
                jSONLexer.bp = i9;
                if (i9 >= jSONLexer.len) {
                    c3 = JSONLexer.EOI;
                } else {
                    c3 = jSONLexer.text.charAt(i9);
                }
                jSONLexer.ch = c3;
                jSONLexer.token = 15;
            } else {
                jSONLexer.nextToken();
            }
            while (true) {
                int i10 = jSONLexer.token;
                if (i10 == 16) {
                    jSONLexer.nextToken();
                } else if (i10 == i6) {
                    break;
                } else {
                    collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, Integer.valueOf(i5)));
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkListResolve(collection);
                    }
                    if (jSONLexer.token == 16) {
                        char c8 = jSONLexer.ch;
                        if (c8 == '[') {
                            int i11 = jSONLexer.bp + 1;
                            jSONLexer.bp = i11;
                            if (i11 >= jSONLexer.len) {
                                c2 = JSONLexer.EOI;
                            } else {
                                c2 = jSONLexer.text.charAt(i11);
                            }
                            jSONLexer.ch = c2;
                            jSONLexer.token = 14;
                        } else if (c8 == '{') {
                            int i12 = jSONLexer.bp + 1;
                            jSONLexer.bp = i12;
                            if (i12 >= jSONLexer.len) {
                                c = JSONLexer.EOI;
                            } else {
                                c = jSONLexer.text.charAt(i12);
                            }
                            jSONLexer.ch = c;
                            jSONLexer.token = 12;
                        } else if (c8 == '\"') {
                            jSONLexer.scanString();
                        } else {
                            jSONLexer.nextToken();
                        }
                    }
                    i5++;
                    i6 = 15;
                }
            }
            if (jSONLexer.ch == ',') {
                int i13 = jSONLexer.bp + 1;
                jSONLexer.bp = i13;
                if (i13 < jSONLexer.len) {
                    c7 = jSONLexer.text.charAt(i13);
                }
                jSONLexer.ch = c7;
                jSONLexer.token = 16;
                return;
            }
            jSONLexer.nextToken();
        } else if (i4 == 12) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
        } else {
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new JSONException(str);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        JSONArray jSONArray;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.array) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.setComponentType(this.itemType);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        Object obj2 = arrayList;
        if (this.array) {
            Object array2 = arrayList.toArray((Object[]) Array.newInstance((Class) this.itemType, arrayList.size()));
            jSONArray.setRelatedArray(array2);
            obj2 = array2;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, obj2);
        } else {
            setValue(obj, obj2);
        }
    }
}

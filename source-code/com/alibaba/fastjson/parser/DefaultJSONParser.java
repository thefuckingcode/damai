package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import tb.jl1;
import tb.o70;

/* compiled from: Taobao */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* compiled from: Taobao */
    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token));
    }

    /* access modifiers changed from: protected */
    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    /* access modifiers changed from: protected */
    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    /* access modifiers changed from: protected */
    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } catch (Throwable th) {
            this.lexer.close();
            throw th;
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    /* access modifiers changed from: protected */
    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    ParseContext parseContext = resolveTask.ownerContext;
                    Object obj2 = null;
                    Object obj3 = parseContext != null ? parseContext.object : null;
                    String str = resolveTask.referenceValue;
                    if (str.startsWith("$")) {
                        for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                            if (str.equals(this.contextArray[i2].toString())) {
                                obj2 = this.contextArray[i2].object;
                            }
                        }
                    } else {
                        obj2 = resolveTask.context.object;
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x0136 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v34, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x04ee  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0518 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x05b1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c1  */
    public final Object parseObject(Map map, Object obj) {
        boolean z;
        Map<String, Object> map2;
        boolean z2;
        String str;
        char c;
        char c2;
        boolean z3;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        boolean z4;
        Object obj2;
        int i;
        String str2;
        char c10;
        Object obj3;
        Object obj4;
        boolean z5;
        Object obj5;
        Class<?> cls;
        Object obj6;
        FieldDeserializer fieldDeserializer;
        String str3;
        String str4;
        JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        if (i2 == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (i2 == 12 || i2 == 16) {
            if (map instanceof JSONObject) {
                z = true;
                map2 = ((JSONObject) map).getInnerMap();
            } else {
                map2 = map;
                z = false;
            }
            boolean z6 = (jSONLexer.features & Feature.AllowISO8601DateFormat.mask) != 0;
            boolean z7 = jSONLexer.disableCircularReferenceDetect;
            ParseContext parseContext = this.contex;
            boolean z8 = false;
            while (true) {
                try {
                    char c11 = jSONLexer.ch;
                    if (!(c11 == '\"' || c11 == '}')) {
                        jSONLexer.skipWhitespace();
                        c11 = jSONLexer.ch;
                    }
                    while (c11 == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        c11 = jSONLexer.ch;
                    }
                    char c12 = JSONLexer.EOI;
                    if (c11 == '\"') {
                        String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, jl1.QUOTE);
                        str4 = scanSymbol;
                        if (jSONLexer.ch != ':') {
                            jSONLexer.skipWhitespace();
                            str4 = scanSymbol;
                            if (jSONLexer.ch != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.pos + ", name " + ((Object) scanSymbol));
                            }
                        }
                    } else if (c11 == '}') {
                        int i3 = jSONLexer.bp + 1;
                        jSONLexer.bp = i3;
                        if (i3 < jSONLexer.len) {
                            c12 = jSONLexer.text.charAt(i3);
                        }
                        jSONLexer.ch = c12;
                        jSONLexer.sp = 0;
                        jSONLexer.nextToken(16);
                        if (!z7) {
                            this.contex = parseContext;
                        }
                        return map;
                    } else if (c11 == '\'') {
                        String scanSymbol2 = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        if (jSONLexer.ch != ':') {
                            jSONLexer.skipWhitespace();
                        }
                        str4 = scanSymbol2;
                        if (jSONLexer.ch != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos);
                        }
                    } else if (c11 == 26) {
                        throw new JSONException("syntax error, " + jSONLexer.info());
                    } else if (c11 == ',') {
                        throw new JSONException("syntax error, " + jSONLexer.info());
                    } else if ((c11 >= '0' && c11 <= '9') || c11 == '-') {
                        jSONLexer.sp = 0;
                        jSONLexer.scanNumber();
                        try {
                            if (jSONLexer.token == 2) {
                                str3 = jSONLexer.integerValue();
                            } else {
                                str3 = jSONLexer.decimalValue(true);
                            }
                            if (z) {
                                str3 = str3.toString();
                            }
                            str4 = str3;
                            if (jSONLexer.ch != ':') {
                                throw new JSONException("parse number key error, " + jSONLexer.info());
                            }
                        } catch (NumberFormatException unused) {
                            throw new JSONException("parse number key error, " + jSONLexer.info());
                        }
                    } else if (c11 == '{' || c11 == '[') {
                        jSONLexer.nextToken();
                        z2 = true;
                        str = parse();
                        if (z2) {
                            int i4 = jSONLexer.bp + 1;
                            jSONLexer.bp = i4;
                            if (i4 >= jSONLexer.len) {
                                c = JSONLexer.EOI;
                            } else {
                                c = jSONLexer.text.charAt(i4);
                            }
                            jSONLexer.ch = c;
                            while (true) {
                                if (c > ' ') {
                                    break;
                                }
                                if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f') {
                                    if (c != '\b') {
                                        break;
                                    }
                                }
                                jSONLexer.next();
                                c = jSONLexer.ch;
                            }
                        } else {
                            c = jSONLexer.ch;
                        }
                        jSONLexer.sp = 0;
                        if (str != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            String scanSymbol3 = jSONLexer.scanSymbol(this.symbolTable, jl1.QUOTE);
                            int i5 = 0;
                            while (true) {
                                if (i5 >= scanSymbol3.length()) {
                                    z5 = true;
                                    break;
                                }
                                char charAt = scanSymbol3.charAt(i5);
                                if (charAt < '0' || charAt > '9') {
                                    z5 = false;
                                } else {
                                    i5++;
                                }
                            }
                            if (!z5) {
                                obj5 = null;
                                cls = this.config.checkAutoType(scanSymbol3, null, jSONLexer.features);
                            } else {
                                obj5 = null;
                                cls = null;
                            }
                            if (cls == null) {
                                map.put(JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                            } else {
                                jSONLexer.nextToken(16);
                                if (jSONLexer.token == 13) {
                                    jSONLexer.nextToken(16);
                                    try {
                                        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                        if (deserializer instanceof JavaBeanDeserializer) {
                                            JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                                            obj6 = javaBeanDeserializer.createInstance(this, cls);
                                            for (Map.Entry entry : map.entrySet()) {
                                                Object key = entry.getKey();
                                                if ((key instanceof String) && (fieldDeserializer = javaBeanDeserializer.getFieldDeserializer((String) key)) != null) {
                                                    fieldDeserializer.setValue(obj6, entry.getValue());
                                                }
                                            }
                                        } else {
                                            obj6 = obj5;
                                        }
                                        if (obj6 == null) {
                                            if (cls == Cloneable.class) {
                                                obj6 = new HashMap();
                                            } else if ("java.util.Collections$EmptyMap".equals(scanSymbol3)) {
                                                obj6 = Collections.emptyMap();
                                            } else {
                                                obj6 = cls.newInstance();
                                            }
                                        }
                                        return obj6;
                                    } catch (Exception e) {
                                        throw new JSONException("create instance error", e);
                                    }
                                } else {
                                    this.resolveStatus = 2;
                                    if (this.contex != null && !(obj instanceof Integer)) {
                                        popContext();
                                    }
                                    if (map.size() > 0) {
                                        Object cast = TypeUtils.cast((Object) map, (Class) cls, this.config);
                                        parseObject(cast);
                                        if (!z7) {
                                            this.contex = parseContext;
                                        }
                                        return cast;
                                    }
                                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls);
                                    Object deserialze = deserializer2.deserialze(this, cls, obj);
                                    if (deserializer2 instanceof MapDeserializer) {
                                        this.resolveStatus = 0;
                                    }
                                    if (!z7) {
                                        this.contex = parseContext;
                                    }
                                    return deserialze;
                                }
                            }
                        } else if (str == "$ref" || parseContext == null || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            if (!z7 || z8) {
                                c2 = jl1.QUOTE;
                            } else {
                                ParseContext context = setContext(this.contex, map, obj);
                                if (parseContext == null) {
                                    parseContext = context;
                                }
                                c2 = jl1.QUOTE;
                                z8 = true;
                            }
                            if (c != c2) {
                                String scanStringValue = jSONLexer.scanStringValue(c2);
                                String str5 = scanStringValue;
                                if (z6) {
                                    JSONLexer jSONLexer2 = new JSONLexer(scanStringValue);
                                    Date date = scanStringValue;
                                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                                        date = jSONLexer2.calendar.getTime();
                                    }
                                    jSONLexer2.close();
                                    str5 = date;
                                }
                                if (map2 != null) {
                                    map2.put(str, str5 == 1 ? 1 : 0);
                                } else {
                                    map.put(str, str5 == 1 ? 1 : 0);
                                }
                            } else if ((c < '0' || c > '9') && c != '-') {
                                if (c == '[') {
                                    jSONLexer.token = 14;
                                    int i6 = jSONLexer.bp + 1;
                                    jSONLexer.bp = i6;
                                    if (i6 >= jSONLexer.len) {
                                        c10 = JSONLexer.EOI;
                                    } else {
                                        c10 = jSONLexer.text.charAt(i6);
                                    }
                                    jSONLexer.ch = c10;
                                    ArrayList arrayList = new ArrayList();
                                    if (!(obj != null && obj.getClass() == Integer.class)) {
                                        setContext(parseContext);
                                    }
                                    parseArray(arrayList, str);
                                    JSONArray jSONArray = new JSONArray(arrayList);
                                    if (map2 != null) {
                                        map2.put(str, jSONArray);
                                    } else {
                                        map.put(str, jSONArray);
                                    }
                                    int i7 = jSONLexer.token;
                                    if (i7 == 13) {
                                        jSONLexer.nextToken(16);
                                        if (!z7) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    } else if (i7 == 16) {
                                        z3 = z;
                                    } else {
                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                    }
                                } else if (c == '{') {
                                    int i8 = jSONLexer.bp + 1;
                                    jSONLexer.bp = i8;
                                    if (i8 >= jSONLexer.len) {
                                        c9 = JSONLexer.EOI;
                                    } else {
                                        c9 = jSONLexer.text.charAt(i8);
                                    }
                                    jSONLexer.ch = c9;
                                    jSONLexer.token = 12;
                                    boolean z9 = obj instanceof Integer;
                                    Map jSONObject = (jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject();
                                    ParseContext context2 = (z7 || z9) ? null : setContext(parseContext, jSONObject, str);
                                    if (this.fieldTypeResolver != null) {
                                        if (str != null) {
                                            str2 = str.toString();
                                            z3 = z;
                                        } else {
                                            z3 = z;
                                            str2 = null;
                                        }
                                        Type resolve = this.fieldTypeResolver.resolve(map, str2);
                                        if (resolve != null) {
                                            obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, str);
                                            z4 = true;
                                            if (!z4) {
                                                obj2 = parseObject(jSONObject, str);
                                            }
                                            if (!(context2 == null || jSONObject == obj2)) {
                                                context2.object = map;
                                            }
                                            if (this.resolveStatus == 1) {
                                                checkMapResolve(map, str.toString());
                                            }
                                            if (map2 == null) {
                                                map2.put(str, obj2);
                                            } else {
                                                map.put(str, obj2);
                                            }
                                            if (z9) {
                                                setContext(parseContext, obj2, str);
                                            }
                                            i = jSONLexer.token;
                                            if (i != 13) {
                                                jSONLexer.nextToken(16);
                                                if (!z7) {
                                                    this.contex = parseContext;
                                                }
                                                if (!z7) {
                                                    this.contex = parseContext;
                                                }
                                                return map;
                                            } else if (i != 16) {
                                                throw new JSONException("syntax error, " + jSONLexer.info());
                                            }
                                        }
                                    } else {
                                        z3 = z;
                                    }
                                    obj2 = null;
                                    z4 = false;
                                    if (!z4) {
                                    }
                                    context2.object = map;
                                    if (this.resolveStatus == 1) {
                                    }
                                    if (map2 == null) {
                                    }
                                    if (z9) {
                                    }
                                    i = jSONLexer.token;
                                    if (i != 13) {
                                    }
                                } else {
                                    z3 = z;
                                    if (c == 't') {
                                        if (jSONLexer.text.startsWith("true", jSONLexer.bp)) {
                                            jSONLexer.bp += 3;
                                            jSONLexer.next();
                                            map.put(str, Boolean.TRUE);
                                        }
                                    } else if (c != 'f') {
                                        jSONLexer.nextToken();
                                        Object parse = parse();
                                        String str6 = str;
                                        if (map.getClass() == JSONObject.class) {
                                            str6 = str.toString();
                                        }
                                        map.put(str6, parse);
                                        int i9 = jSONLexer.token;
                                        if (i9 == 13) {
                                            jSONLexer.nextToken(16);
                                            if (!z7) {
                                                this.contex = parseContext;
                                            }
                                            return map;
                                        }
                                        if (i9 != 16) {
                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                        }
                                        z = z3;
                                    } else if (jSONLexer.text.startsWith("false", jSONLexer.bp)) {
                                        jSONLexer.bp += 4;
                                        jSONLexer.next();
                                        map.put(str, Boolean.FALSE);
                                    }
                                    c3 = jSONLexer.ch;
                                    if (!(c3 == ',' || c3 == '}')) {
                                        jSONLexer.skipWhitespace();
                                        c3 = jSONLexer.ch;
                                    }
                                    if (c3 == ',') {
                                        int i10 = jSONLexer.bp + 1;
                                        jSONLexer.bp = i10;
                                        if (i10 >= jSONLexer.len) {
                                            c8 = JSONLexer.EOI;
                                        } else {
                                            c8 = jSONLexer.text.charAt(i10);
                                        }
                                        jSONLexer.ch = c8;
                                    } else if (c3 == '}') {
                                        int i11 = jSONLexer.bp + 1;
                                        jSONLexer.bp = i11;
                                        if (i11 >= jSONLexer.len) {
                                            c4 = JSONLexer.EOI;
                                        } else {
                                            c4 = jSONLexer.text.charAt(i11);
                                        }
                                        jSONLexer.ch = c4;
                                        jSONLexer.sp = 0;
                                        if (c4 == ',') {
                                            int i12 = jSONLexer.bp + 1;
                                            jSONLexer.bp = i12;
                                            if (i12 >= jSONLexer.len) {
                                                c7 = JSONLexer.EOI;
                                            } else {
                                                c7 = jSONLexer.text.charAt(i12);
                                            }
                                            jSONLexer.ch = c7;
                                            jSONLexer.token = 16;
                                        } else if (c4 == '}') {
                                            int i13 = jSONLexer.bp + 1;
                                            jSONLexer.bp = i13;
                                            if (i13 >= jSONLexer.len) {
                                                c6 = JSONLexer.EOI;
                                            } else {
                                                c6 = jSONLexer.text.charAt(i13);
                                            }
                                            jSONLexer.ch = c6;
                                            jSONLexer.token = 13;
                                        } else if (c4 == ']') {
                                            int i14 = jSONLexer.bp + 1;
                                            jSONLexer.bp = i14;
                                            if (i14 >= jSONLexer.len) {
                                                c5 = JSONLexer.EOI;
                                            } else {
                                                c5 = jSONLexer.text.charAt(i14);
                                            }
                                            jSONLexer.ch = c5;
                                            jSONLexer.token = 15;
                                        } else {
                                            jSONLexer.nextToken();
                                        }
                                        if (!z7) {
                                            setContext(this.contex, map, obj);
                                        }
                                        if (!z7) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    } else {
                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                    }
                                }
                                z = z3;
                            } else {
                                map2.put(str, jSONLexer.scanNumberValue());
                            }
                            z3 = z;
                            c3 = jSONLexer.ch;
                            jSONLexer.skipWhitespace();
                            c3 = jSONLexer.ch;
                            if (c3 == ',') {
                            }
                        } else {
                            jSONLexer.nextToken(4);
                            if (jSONLexer.token == 4) {
                                String stringVal = jSONLexer.stringVal();
                                jSONLexer.nextToken(13);
                                if (o70.DINAMIC_PREFIX_AT.equals(stringVal)) {
                                    ParseContext parseContext2 = this.contex;
                                    obj4 = parseContext2.object;
                                    if (!(obj4 instanceof Object[]) && !(obj4 instanceof Collection)) {
                                        ParseContext parseContext3 = parseContext2.parent;
                                        if (parseContext3 != null) {
                                            obj3 = parseContext3.object;
                                            if (jSONLexer.token == 13) {
                                                jSONLexer.nextToken(16);
                                                if (!z7) {
                                                    this.contex = parseContext;
                                                }
                                                return obj3;
                                            }
                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                        }
                                        obj3 = null;
                                        if (jSONLexer.token == 13) {
                                        }
                                    }
                                } else {
                                    if ("..".equals(stringVal)) {
                                        obj4 = parseContext.object;
                                        if (obj4 == null) {
                                            addResolveTask(new ResolveTask(parseContext, stringVal));
                                            this.resolveStatus = 1;
                                        }
                                    } else if ("$".equals(stringVal)) {
                                        ParseContext parseContext4 = parseContext;
                                        while (true) {
                                            ParseContext parseContext5 = parseContext4.parent;
                                            if (parseContext5 == null) {
                                                break;
                                            }
                                            parseContext4 = parseContext5;
                                        }
                                        Object obj7 = parseContext4.object;
                                        if (obj7 != null) {
                                            obj3 = obj7;
                                            if (jSONLexer.token == 13) {
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext4, stringVal));
                                            this.resolveStatus = 1;
                                        }
                                    } else {
                                        addResolveTask(new ResolveTask(parseContext, stringVal));
                                        this.resolveStatus = 1;
                                    }
                                    obj3 = null;
                                    if (jSONLexer.token == 13) {
                                    }
                                }
                                obj3 = obj4;
                                if (jSONLexer.token == 13) {
                                }
                            } else {
                                throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token));
                            }
                        }
                    } else {
                        String scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                        jSONLexer.skipWhitespace();
                        char c13 = jSONLexer.ch;
                        str4 = scanSymbolUnQuoted;
                        if (c13 != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.bp + ", actual " + c13);
                        } else if (z) {
                            str4 = scanSymbolUnQuoted.toString();
                        }
                    }
                    z2 = false;
                    str = str4;
                    if (z2) {
                    }
                    jSONLexer.sp = 0;
                    if (str != JSON.DEFAULT_TYPE_KEY) {
                    }
                    if (str == "$ref") {
                    }
                    if (!z7) {
                    }
                    c2 = jl1.QUOTE;
                    if (c != c2) {
                    }
                    z3 = z;
                    c3 = jSONLexer.ch;
                    jSONLexer.skipWhitespace();
                    c3 = jSONLexer.ch;
                    if (c3 == ',') {
                    }
                } finally {
                    if (!z7) {
                        this.contex = parseContext;
                    }
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i2) + AVFSCacheConstants.COMMA_SEP + jSONLexer.info());
        }
    }

    public String parseString() {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            JSONLexer jSONLexer2 = this.lexer;
            char c = jSONLexer2.ch;
            char c2 = JSONLexer.EOI;
            if (c == ',') {
                int i2 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i2;
                if (i2 < jSONLexer2.len) {
                    c2 = jSONLexer2.text.charAt(i2);
                }
                jSONLexer2.ch = c2;
                this.lexer.token = 16;
            } else if (c == ']') {
                int i3 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i3;
                if (i3 < jSONLexer2.len) {
                    c2 = jSONLexer2.text.charAt(i3);
                }
                jSONLexer2.ch = c2;
                this.lexer.token = 15;
            } else if (c == '}') {
                int i4 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i4;
                if (i4 < jSONLexer2.len) {
                    c2 = jSONLexer2.text.charAt(i4);
                }
                jSONLexer2.ch = c2;
                this.lexer.token = 13;
            } else {
                jSONLexer2.nextToken();
            }
            return stringVal;
        } else if (i == 2) {
            String numberString = jSONLexer.numberString();
            this.lexer.nextToken(16);
            return numberString;
        } else {
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.disableCircularReferenceDetect) {
            this.contex = parseContext;
        }
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i != 2) {
            boolean z = true;
            if (i == 3) {
                if ((jSONLexer.features & Feature.UseBigDecimal.mask) == 0) {
                    z = false;
                }
                Number decimalValue = jSONLexer.decimalValue(z);
                this.lexer.nextToken();
                return decimalValue;
            } else if (i == 4) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken(16);
                if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                    JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                    try {
                        if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                            return jSONLexer2.calendar.getTime();
                        }
                        jSONLexer2.close();
                    } finally {
                        jSONLexer2.close();
                    }
                }
                return stringVal;
            } else if (i == 12) {
                return parseObject((jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
            } else if (i != 14) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken(16);
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken(16);
                        return Boolean.FALSE;
                    case 8:
                        break;
                    case 9:
                        jSONLexer.nextToken(18);
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 18) {
                            jSONLexer3.nextToken(10);
                            accept(10);
                            long longValue = this.lexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error, " + this.lexer.info());
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("syntax error, " + this.lexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray(hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray(treeSet, obj);
                                return treeSet;
                            case 23:
                                break;
                            default:
                                throw new JSONException("syntax error, " + this.lexer.info());
                        }
                }
                jSONLexer.nextToken();
                return null;
            } else {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONArray;
            }
        } else {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(new JSONLexer(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    /* access modifiers changed from: protected */
    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i] = parseContext2;
        return parseContext2;
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(new JSONLexer(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    /* JADX INFO: finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        String str;
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 21 || i == 22) {
            jSONLexer.nextToken();
        }
        JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token == 14) {
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                jSONLexer2.nextToken(2);
            } else if (String.class == type) {
                objectDeserializer = StringCodec.instance;
                jSONLexer2.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(12);
            }
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i2 = 0;
            while (true) {
                try {
                    JSONLexer jSONLexer3 = this.lexer;
                    int i3 = jSONLexer3.token;
                    if (i3 == 16) {
                        jSONLexer3.nextToken();
                    } else if (i3 == 15) {
                        this.contex = parseContext;
                        jSONLexer3.nextToken(16);
                        return;
                    } else {
                        Object obj2 = null;
                        String str2 = null;
                        if (Integer.TYPE == type) {
                            collection.add(IntegerCodec.instance.deserialze(this, null, null));
                        } else if (String.class == type) {
                            if (i3 == 4) {
                                str = jSONLexer3.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    str2 = parse.toString();
                                }
                                str = str2;
                            }
                            collection.add(str);
                        } else {
                            if (i3 == 8) {
                                jSONLexer3.nextToken();
                            } else {
                                obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                        }
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 16) {
                            jSONLexer4.nextToken();
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    this.contex = parseContext;
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + AVFSCacheConstants.COMMA_SEP + this.lexer.info());
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c = jSONLexer.ch;
        char c2 = JSONLexer.EOI;
        if (c == '{') {
            int i = jSONLexer.bp + 1;
            jSONLexer.bp = i;
            jSONLexer.ch = i < jSONLexer.len ? jSONLexer.text.charAt(i) : c2;
            jSONLexer.token = 12;
        } else if (c == '[') {
            int i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            jSONLexer.ch = i2 < jSONLexer.len ? jSONLexer.text.charAt(i2) : c2;
            jSONLexer.token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z;
        Class<?> cls;
        int i;
        JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        int i3 = 8;
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i2 == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error, " + this.lexer.info());
            }
            jSONLexer.nextToken(2);
            int i4 = 0;
            while (i4 < typeArr.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i5 = jSONLexer3.token;
                if (i5 == i3) {
                    jSONLexer3.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr[i4];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (i5 == 2) {
                            obj = Integer.valueOf(jSONLexer3.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i4 != typeArr.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z = false;
                        } else {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.lexer.token == 14) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    JSONLexer jSONLexer4 = this.lexer;
                                    i = jSONLexer4.token;
                                    if (i != 16) {
                                        break;
                                    }
                                    jSONLexer4.nextToken(12);
                                }
                                if (i != 15) {
                                    throw new JSONException("syntax error, " + this.lexer.info());
                                }
                            }
                            obj = TypeUtils.cast(arrayList, type, this.config);
                        }
                    } else if (i5 == 4) {
                        obj = jSONLexer3.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i4] = obj;
                JSONLexer jSONLexer5 = this.lexer;
                int i6 = jSONLexer5.token;
                if (i6 == 15) {
                    break;
                } else if (i6 == 16) {
                    if (i4 == typeArr.length - 1) {
                        jSONLexer5.nextToken(15);
                    } else {
                        jSONLexer5.nextToken(2);
                    }
                    i4++;
                    i3 = 8;
                } else {
                    throw new JSONException("syntax error, " + this.lexer.info());
                }
            }
            JSONLexer jSONLexer6 = this.lexer;
            if (jSONLexer6.token == 15) {
                jSONLexer6.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error, " + this.lexer.info());
        } else {
            throw new JSONException("syntax error, " + this.lexer.info());
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x022e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A[LOOP:1: B:58:0x00e8->B:59:0x00ea, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f8  */
    public final void parseArray(Collection collection, Object obj) {
        boolean z;
        int i;
        int i2;
        Number number;
        JSONLexer jSONLexer;
        char c;
        JSONObject jSONObject;
        char c2;
        char c3;
        char c4;
        JSONLexer jSONLexer2 = this.lexer;
        int i3 = jSONLexer2.token;
        if (i3 == 21 || i3 == 22) {
            jSONLexer2.nextToken();
            i3 = this.lexer.token;
        }
        if (i3 == 14) {
            boolean z2 = this.lexer.disableCircularReferenceDetect;
            ParseContext parseContext = this.contex;
            if (!z2) {
                setContext(parseContext, collection, obj);
            }
            try {
                JSONLexer jSONLexer3 = this.lexer;
                char c5 = jSONLexer3.ch;
                if (c5 != '\"') {
                    if (c5 == ']') {
                        jSONLexer3.next();
                        this.lexer.nextToken(16);
                        if (z2) {
                            return;
                        }
                        return;
                    } else if (c5 == '{') {
                        int i4 = jSONLexer3.bp + 1;
                        jSONLexer3.bp = i4;
                        if (i4 >= jSONLexer3.len) {
                            c4 = JSONLexer.EOI;
                        } else {
                            c4 = jSONLexer3.text.charAt(i4);
                        }
                        jSONLexer3.ch = c4;
                        this.lexer.token = 12;
                    } else {
                        jSONLexer3.nextToken(12);
                    }
                } else if ((jSONLexer3.features & Feature.AllowISO8601DateFormat.mask) == 0) {
                    z = true;
                    i = 0;
                    while (true) {
                        if (z) {
                            JSONLexer jSONLexer4 = this.lexer;
                            if (jSONLexer4.ch == '\"') {
                                String scanStringValue = jSONLexer4.scanStringValue(jl1.QUOTE);
                                JSONLexer jSONLexer5 = this.lexer;
                                char c6 = jSONLexer5.ch;
                                if (c6 == ',') {
                                    int i5 = jSONLexer5.bp + 1;
                                    jSONLexer5.bp = i5;
                                    if (i5 >= jSONLexer5.len) {
                                        c3 = JSONLexer.EOI;
                                    } else {
                                        c3 = jSONLexer5.text.charAt(i5);
                                    }
                                    jSONLexer5.ch = c3;
                                    collection.add(scanStringValue);
                                    if (this.resolveStatus == 1) {
                                        checkListResolve(collection);
                                    }
                                    if (c3 == '\"') {
                                        i++;
                                    } else {
                                        this.lexer.nextToken();
                                        z = false;
                                    }
                                } else if (c6 == ']') {
                                    int i6 = jSONLexer5.bp + 1;
                                    jSONLexer5.bp = i6;
                                    if (i6 >= jSONLexer5.len) {
                                        c2 = JSONLexer.EOI;
                                    } else {
                                        c2 = jSONLexer5.text.charAt(i6);
                                    }
                                    jSONLexer5.ch = c2;
                                    collection.add(scanStringValue);
                                    if (this.resolveStatus == 1) {
                                        checkListResolve(collection);
                                    }
                                    this.lexer.nextToken(16);
                                    if (!z2) {
                                        this.contex = parseContext;
                                        return;
                                    }
                                    return;
                                } else {
                                    jSONLexer5.nextToken();
                                }
                            }
                        }
                        i2 = this.lexer.token;
                        while (i2 == 16) {
                            this.lexer.nextToken();
                            i2 = this.lexer.token;
                        }
                        JSONArray jSONArray = null;
                        jSONArray = null;
                        if (i2 != 2) {
                            number = this.lexer.integerValue();
                            this.lexer.nextToken(16);
                        } else if (i2 != 3) {
                            if (i2 == 4) {
                                String stringVal = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                                jSONArray = stringVal;
                                if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                                    JSONLexer jSONLexer6 = new JSONLexer(stringVal);
                                    Date date = stringVal;
                                    if (jSONLexer6.scanISO8601DateIfMatch(true)) {
                                        date = jSONLexer6.calendar.getTime();
                                    }
                                    jSONLexer6.close();
                                    jSONArray = date;
                                }
                            } else if (i2 == 6) {
                                Boolean bool = Boolean.TRUE;
                                this.lexer.nextToken(16);
                                jSONArray = bool;
                            } else if (i2 == 7) {
                                Boolean bool2 = Boolean.FALSE;
                                this.lexer.nextToken(16);
                                jSONArray = bool2;
                            } else if (i2 == 8) {
                                this.lexer.nextToken(4);
                            } else if (i2 == 12) {
                                if ((this.lexer.features & Feature.OrderedField.mask) != 0) {
                                    jSONObject = new JSONObject(new LinkedHashMap());
                                } else {
                                    jSONObject = new JSONObject();
                                }
                                jSONArray = parseObject(jSONObject, Integer.valueOf(i));
                            } else if (i2 == 20) {
                                throw new JSONException("unclosed jsonArray");
                            } else if (i2 == 23) {
                                this.lexer.nextToken(4);
                            } else if (i2 == 14) {
                                JSONArray jSONArray2 = new JSONArray();
                                parseArray(jSONArray2, Integer.valueOf(i));
                                jSONArray = jSONArray2;
                            } else if (i2 != 15) {
                                jSONArray = parse();
                            } else {
                                this.lexer.nextToken(16);
                                if (!z2) {
                                    this.contex = parseContext;
                                    return;
                                }
                                return;
                            }
                            number = jSONArray;
                        } else {
                            JSONLexer jSONLexer7 = this.lexer;
                            if ((jSONLexer7.features & Feature.UseBigDecimal.mask) != 0) {
                                number = jSONLexer7.decimalValue(true);
                            } else {
                                number = jSONLexer7.decimalValue(false);
                            }
                            this.lexer.nextToken(16);
                        }
                        collection.add(number);
                        if (this.resolveStatus == 1) {
                            checkListResolve(collection);
                        }
                        jSONLexer = this.lexer;
                        if (jSONLexer.token == 16) {
                            char c7 = jSONLexer.ch;
                            if (c7 == '\"') {
                                jSONLexer.pos = jSONLexer.bp;
                                jSONLexer.scanString();
                            } else if (c7 >= '0' && c7 <= '9') {
                                jSONLexer.pos = jSONLexer.bp;
                                jSONLexer.scanNumber();
                            } else if (c7 == '{') {
                                jSONLexer.token = 12;
                                int i7 = jSONLexer.bp + 1;
                                jSONLexer.bp = i7;
                                if (i7 >= jSONLexer.len) {
                                    c = JSONLexer.EOI;
                                } else {
                                    c = jSONLexer.text.charAt(i7);
                                }
                                jSONLexer.ch = c;
                            } else {
                                jSONLexer.nextToken();
                            }
                        }
                        i++;
                    }
                } else {
                    jSONLexer3.nextToken(4);
                }
                z = false;
                i = 0;
                while (true) {
                    if (z) {
                    }
                    i2 = this.lexer.token;
                    while (i2 == 16) {
                    }
                    JSONArray jSONArray3 = null;
                    jSONArray3 = null;
                    if (i2 != 2) {
                    }
                    collection.add(number);
                    if (this.resolveStatus == 1) {
                    }
                    jSONLexer = this.lexer;
                    if (jSONLexer.token == 16) {
                    }
                    i++;
                }
            } finally {
                if (!z2) {
                    this.contex = parseContext;
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(i3) + ", pos " + this.lexer.pos);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i = this.lexer.token;
        if (i == 12 || i == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    JSONLexer jSONLexer = this.lexer;
                    int i2 = jSONLexer.token;
                    if (i2 == 13) {
                        jSONLexer.nextToken(16);
                        return;
                    } else if (i2 == 16) {
                        continue;
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer == null) {
                    JSONLexer jSONLexer2 = this.lexer;
                    if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                        jSONLexer2.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
                        parse();
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 13) {
                            jSONLexer3.nextToken();
                            return;
                        }
                    } else {
                        throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                    }
                } else {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    Type type = fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
                        obj2 = IntegerCodec.instance.deserialze(this, type, null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
                        obj2 = parseString();
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
                        obj2 = IntegerCodec.instance.deserialze(this, type, null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
                        obj2 = deserializer2.deserialze(this, type, null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    JSONLexer jSONLexer4 = this.lexer;
                    int i3 = jSONLexer4.token;
                    if (i3 != 16 && i3 == 13) {
                        jSONLexer4.nextToken(16);
                        return;
                    }
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i));
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), (Object) null);
    }
}

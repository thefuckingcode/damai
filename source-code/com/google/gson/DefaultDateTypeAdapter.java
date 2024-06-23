package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Taobao */
final class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:2:0x0003 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0011 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.gson.JsonElement] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.gson.JsonElement] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.gson.JsonElement] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.Date] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Date] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r5 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r5.getAsString(), new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        throw new com.google.gson.JsonSyntaxException(r5.getAsString(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5 = r4.enUsFormat.parse(r5.getAsString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    private Date deserializeToDate(JsonElement jsonElement) {
        synchronized (this.localFormat) {
            jsonElement = this.localFormat.parse(jsonElement.getAsString());
            return jsonElement;
        }
    }

    public String toString() {
        return DefaultDateTypeAdapter.class.getSimpleName() + '(' + this.localFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.JsonDeserializer
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement instanceof JsonPrimitive) {
            Date deserializeToDate = deserializeToDate(jsonElement);
            if (type == Date.class) {
                return deserializeToDate;
            }
            if (type == Timestamp.class) {
                return new Timestamp(deserializeToDate.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(deserializeToDate.getTime());
            }
            throw new IllegalArgumentException(DefaultDateTypeAdapter.class + " cannot deserialize to " + type);
        }
        throw new JsonParseException("The date should be a string value");
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        synchronized (this.localFormat) {
            jsonPrimitive = new JsonPrimitive(this.enUsFormat.format(date));
        }
        return jsonPrimitive;
    }

    DefaultDateTypeAdapter(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(int i) {
        this(DateFormat.getDateInstance(i, Locale.US), DateFormat.getDateInstance(i));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat2;
    }
}

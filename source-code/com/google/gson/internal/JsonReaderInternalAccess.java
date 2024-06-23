package com.google.gson.internal;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}

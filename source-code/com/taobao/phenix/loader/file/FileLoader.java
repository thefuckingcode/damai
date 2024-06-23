package com.taobao.phenix.loader.file;

import android.content.res.Resources;
import java.io.IOException;
import java.util.Map;
import tb.i42;
import tb.r02;

/* compiled from: Taobao */
public interface FileLoader {
    public static final int LOCAL_ASSET = 34;
    public static final int LOCAL_BASE64 = 40;
    public static final int LOCAL_EXTENDED = 48;
    public static final int LOCAL_FILE = 33;
    public static final int LOCAL_RES = 36;

    r02 load(i42 i42, String str, Map<String, String> map) throws IOException, Resources.NotFoundException, UnSupportedSchemeException;
}

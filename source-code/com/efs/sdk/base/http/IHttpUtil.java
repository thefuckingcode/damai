package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import tb.vy0;

/* compiled from: Taobao */
public interface IHttpUtil {
    @NonNull
    vy0 get(String str, Map<String, String> map);

    @NonNull
    vy0 post(String str, Map<String, String> map, File file);

    @NonNull
    vy0 post(String str, Map<String, String> map, byte[] bArr);

    @NonNull
    vy0 postAsFile(String str, Map<String, String> map, byte[] bArr);
}

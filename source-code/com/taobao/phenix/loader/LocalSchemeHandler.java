package com.taobao.phenix.loader;

import java.io.IOException;
import tb.r02;

/* compiled from: Taobao */
public interface LocalSchemeHandler {
    r02 handleScheme(String str) throws IOException;

    boolean isSupported(String str);
}

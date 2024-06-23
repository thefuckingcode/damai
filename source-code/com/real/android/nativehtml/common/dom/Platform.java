package com.real.android.nativehtml.common.dom;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import tb.sa0;

/* compiled from: Taobao */
public interface Platform {
    Element createElement(sa0 sa0, ElementType elementType, String str);

    float getPixelPerDp();

    void openInBrowser(URI uri);

    InputStream openInputStream(URI uri) throws IOException;
}

package com.uc.webview.export.utility;

import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.SDKFactory;

@Interface
/* compiled from: Taobao */
public class TestHelper {
    private TestHelper() {
    }

    public static void handlePerformanceTests(String str) throws Exception {
        SDKFactory.a(str);
    }
}

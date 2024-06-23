package com.taobao.weex.bridge;

/* compiled from: Taobao */
public interface JavascriptInvokable {
    Invoker getMethodInvoker(String str);

    String[] getMethods();
}

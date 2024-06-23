package com.uc.sandboxExport;

/* compiled from: Taobao */
public interface h {

    /* compiled from: Taobao */
    public static class a {
        static String a(int i) {
            return i == 0 ? "NormalRenderProc" : i == 1 ? "IsolateRenderProc" : i == 2 ? "GPUProc" : "UnknownProc";
        }
    }
}

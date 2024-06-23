package com.android.alibaba.ip.runtime;

/* compiled from: Taobao */
public class PatchesLoaderDumper {
    public static void main(String[] strArr) {
        try {
            ((PatchesLoader) Class.forName("com.android.alibaba.ip.runtime.AppPatchesLoaderImpl").newInstance()).load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}

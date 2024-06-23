package com.taobao.update.datasource;

import com.alibaba.fastjson.JSONObject;
import com.taobao.update.result.BundleUpdateStep;

/* compiled from: Taobao */
public interface UpdateListener {

    /* compiled from: Taobao */
    public interface PatchListener {
        void hasPatched(boolean z);

        void patchFailed(String str);

        void patchStart();

        void patchSuccess();

        void patching(BundleUpdateStep bundleUpdateStep);
    }

    void onUpdate(boolean z, JSONObject jSONObject, String str);

    void patchProcessListener(PatchListener patchListener);
}

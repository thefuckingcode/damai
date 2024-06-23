package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: Taobao */
class InspectorNativeCommandHandler implements InspectorCommandHandler {
    private final long a;

    InspectorNativeCommandHandler(long j) {
        this.a = j;
    }

    private native void handleNative(long j, String str, int i, String str2, String str3);

    @Override // com.taobao.android.riverlogger.inspector.InspectorCommandHandler
    public void handle(@NonNull JSONObject jSONObject, @NonNull b bVar) {
        handleNative(this.a, bVar.b(), bVar.a(), bVar.c(), jSONObject.toString());
    }
}

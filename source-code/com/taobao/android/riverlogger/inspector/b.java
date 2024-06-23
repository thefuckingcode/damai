package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    private final String a;
    private int b;
    private final String c;

    b(@NonNull String str, int i, @Nullable String str2, @NonNull JSONObject jSONObject) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        RemoteChannel c2;
        if (this.b >= 0 && (c2 = com.taobao.android.riverlogger.remote.b.c()) != null) {
            c2.d(this.b, null);
        }
        super.finalize();
    }
}

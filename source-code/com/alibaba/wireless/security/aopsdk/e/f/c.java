package com.alibaba.wireless.security.aopsdk.e.f;

import com.alibaba.wireless.security.aopsdk.e.e.a;
import com.alibaba.wireless.security.aopsdk.e.e.b;
import org.json.JSONObject;

/* compiled from: ExecutionConfig */
public class c extends a {
    private static final int l = 1000;
    public int d = 0;
    private final Object e = new Object();
    @a(key = "sr", type = b.INT)
    public int f = -1;
    @a(key = "ir", type = b.INT)
    public int g = -1;
    @a(key = "nr", type = b.INT)
    public int h = -1;
    @a(key = "tr", type = b.INT)
    public int i = -1;
    @a(key = "dh", type = b.STRING)
    public String j;
    @a(key = "rs", type = b.INT)
    public int k = -1;

    @Override // com.alibaba.wireless.security.aopsdk.e.f.a
    public void b(JSONObject jSONObject) {
        int i2 = 1000;
        super.b(jSONObject);
        String str = this.j;
        if (str != null) {
            if (com.alibaba.wireless.security.aopsdk.e.g.a.b(str)) {
                int i3 = this.f;
                if (i3 == -1) {
                    i3 = 1000;
                }
                this.f = i3;
            } else {
                this.f = Integer.MAX_VALUE;
            }
        }
        int i4 = this.f;
        if (i4 != -1) {
            i2 = i4;
        }
        this.f = i2;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        boolean z = false;
        synchronized (this.e) {
            int i2 = this.f;
            if (i2 > 0) {
                int i3 = this.d + 1;
                this.d = i3;
                if (i3 >= i2) {
                    this.d = i3 - i2;
                    z = true;
                }
            }
        }
        return z;
    }
}

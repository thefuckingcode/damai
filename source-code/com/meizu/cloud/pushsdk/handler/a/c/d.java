package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.a.c;

/* compiled from: Taobao */
public class d {
    private String a;
    private String b;
    private String c;
    private String d;

    /* compiled from: Taobao */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        String str = "";
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : str;
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : str;
        this.c = !TextUtils.isEmpty(aVar.c) ? aVar.c : str;
        this.d = !TextUtils.isEmpty(aVar.d) ? aVar.d : str;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        c cVar = new c();
        cVar.a("task_id", this.a);
        cVar.a(PushConstants.SEQ_ID, this.b);
        cVar.a(PushConstants.PUSH_TIMESTAMP, this.c);
        cVar.a(PushConstants.DEVICE_ID, this.d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}

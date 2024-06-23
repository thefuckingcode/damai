package com.vivo.push;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class i implements IPushActionListener {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            this.a.k = "";
            this.a.j.a("APP_TOKEN", "");
            this.a.m();
            this.a.j.b("APP_TAGS");
            return;
        }
        this.a.k = null;
        this.a.j.b("APP_TOKEN");
    }
}

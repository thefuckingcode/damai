package com.taobao.applink.c;

import android.os.AsyncTask;

/* compiled from: Taobao */
class a extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    a(b bVar, String str, String str2, String str3) {
        this.d = bVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        this.d.d(this.a, this.b, this.c);
        return null;
    }
}

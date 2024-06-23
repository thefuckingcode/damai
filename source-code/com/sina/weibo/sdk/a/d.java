package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.c;
import com.sina.weibo.sdk.net.e;

/* compiled from: Taobao */
public final class d extends c<Void, Void, String> {
    private Context Z;
    private c<String> aa;
    private Throwable ab;
    private String ac;
    private String ad;
    private String ae;

    public d(Context context, String str, String str2, String str3, c<String> cVar) {
        this.Z = context;
        this.ac = str;
        this.ad = str2;
        this.ae = str3;
        this.aa = cVar;
    }

    private String d(String str) {
        return HttpManager.a(this.Z, "", this.ae, this.ad, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public String l() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            e.a aVar = new e.a();
            aVar.i = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new b().a(aVar.a("oauth_timestamp", valueOf).a("oauth_sign", d(valueOf)).b("appKey", this.ad).b("oauth_timestamp", valueOf).b("oauth_sign", d(valueOf)).b("img", this.ac).e()).f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ab = th;
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.a.c
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ab;
        if (th != null) {
            c<String> cVar = this.aa;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        c<String> cVar2 = this.aa;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}

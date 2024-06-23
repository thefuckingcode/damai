package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.c;
import com.sina.weibo.sdk.net.e;

/* compiled from: Taobao */
public final class e extends c<Void, Void, String> {
    private c<String> aa;
    private Throwable ab;
    private String ad;
    private Oauth2AccessToken af;

    public e(String str, Oauth2AccessToken oauth2AccessToken, c<String> cVar) {
        this.ad = str;
        this.af = oauth2AccessToken;
        this.aa = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public String l() {
        try {
            e.a aVar = new e.a();
            aVar.i = "https://api.weibo.com/oauth2/access_token";
            return new b().a(aVar.b("client_id", this.ad).b("appKey", this.ad).b("grant_type", "refresh_token").b("refresh_token", this.af.getRefreshToken()).e()).f();
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

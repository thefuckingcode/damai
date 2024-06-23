package com.alibaba.security.realidentity.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.g;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.b;
import java.io.File;
import org.json.JSONObject;

@f(a = "finish")
/* compiled from: Taobao */
public class d extends a {
    private static final String as = "FinishJSApi";

    private static void d() {
        if (g.a() != null) {
            g.a(new File(g.a()));
        }
    }

    private static LastExitTrackMsg e() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(g.a.a.f);
        lastExitTrackMsg.setParams(h.a(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private static RPTrack.LastExitTrackParams f() {
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(g.a.a.f);
        return lastExitTrackParams;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "finish";
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101  */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        b bVar;
        Context context;
        Exception e;
        if (a.a()) {
            a.a(as, "FinishApi execute params: ".concat(String.valueOf(str)));
        }
        RPResult rPResult = RPResult.AUDIT_IN_AUDIT;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.getString(a.F);
            try {
                str4 = jSONObject.getString("code");
            } catch (Exception e2) {
                e = e2;
                str4 = null;
                str3 = str4;
                if (a.a()) {
                }
                a.a(hVar);
                a.a("FinishApi parse params error", e);
                str5 = "";
                if ("AUDIT_IN_AUDIT".equals(str2)) {
                }
                bVar = g.a.a.h;
                if (a.C0102a.a.a == null) {
                }
                if (bVar != null) {
                }
                context = this.ao;
                ((Activity) context).finish();
                if (com.alibaba.security.common.d.g.a() != null) {
                }
                hVar.b();
                a(new WVResult("success"), true);
                return true;
            }
            try {
                str3 = jSONObject.getString("subCode");
                try {
                    if (!String.valueOf(RPResult.AUDIT_FAIL.code).equals(str4) || !jSONObject.has("display")) {
                        if (jSONObject.has("message")) {
                            str5 = jSONObject.getString("message");
                            if ("AUDIT_IN_AUDIT".equals(str2)) {
                                rPResult = RPResult.AUDIT_IN_AUDIT;
                            } else if ("AUDIT_FAIL".equals(str2)) {
                                rPResult = RPResult.AUDIT_FAIL;
                            } else if ("AUDIT_PASS".equals(str2)) {
                                rPResult = RPResult.AUDIT_PASS;
                            } else if ("AUDIT_NOT".equals(str2)) {
                                rPResult = RPResult.AUDIT_NOT;
                            }
                            bVar = g.a.a.h;
                            if (a.C0102a.a.a == null) {
                                LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
                                lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
                                lastExitTrackMsg.setView("");
                                RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
                                lastExitTrackParams.setUrl(g.a.a.f);
                                lastExitTrackMsg.setParams(h.a(lastExitTrackParams));
                                a.C0102a.a.a = lastExitTrackMsg;
                            }
                            if (bVar != null) {
                                bVar.onFinish(rPResult, new RPDetail(str4, str3, str5, a.ap));
                                g.a.a.h = null;
                            }
                            context = this.ao;
                            if (context != null && (context instanceof Activity)) {
                                ((Activity) context).finish();
                            }
                            if (com.alibaba.security.common.d.g.a() != null) {
                                com.alibaba.security.common.d.g.a(new File(com.alibaba.security.common.d.g.a()));
                            }
                            hVar.b();
                            a(new WVResult("success"), true);
                            return true;
                        }
                        str5 = "";
                        if ("AUDIT_IN_AUDIT".equals(str2)) {
                        }
                        bVar = g.a.a.h;
                        if (a.C0102a.a.a == null) {
                        }
                        if (bVar != null) {
                        }
                        context = this.ao;
                        ((Activity) context).finish();
                        if (com.alibaba.security.common.d.g.a() != null) {
                        }
                        hVar.b();
                        a(new WVResult("success"), true);
                        return true;
                    }
                    str5 = jSONObject.getString("display");
                    if ("AUDIT_IN_AUDIT".equals(str2)) {
                    }
                    bVar = g.a.a.h;
                    if (a.C0102a.a.a == null) {
                    }
                    if (bVar != null) {
                    }
                    context = this.ao;
                    ((Activity) context).finish();
                    if (com.alibaba.security.common.d.g.a() != null) {
                    }
                    hVar.b();
                    a(new WVResult("success"), true);
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    if (com.alibaba.security.common.c.a.a()) {
                    }
                    a.a(hVar);
                    a.a("FinishApi parse params error", e);
                    str5 = "";
                    if ("AUDIT_IN_AUDIT".equals(str2)) {
                    }
                    bVar = g.a.a.h;
                    if (a.C0102a.a.a == null) {
                    }
                    if (bVar != null) {
                    }
                    context = this.ao;
                    ((Activity) context).finish();
                    if (com.alibaba.security.common.d.g.a() != null) {
                    }
                    hVar.b();
                    a(new WVResult("success"), true);
                    return true;
                }
            } catch (Exception e4) {
                e = e4;
                str3 = null;
                if (com.alibaba.security.common.c.a.a()) {
                }
                a.a(hVar);
                a.a("FinishApi parse params error", e);
                str5 = "";
                if ("AUDIT_IN_AUDIT".equals(str2)) {
                }
                bVar = g.a.a.h;
                if (a.C0102a.a.a == null) {
                }
                if (bVar != null) {
                }
                context = this.ao;
                ((Activity) context).finish();
                if (com.alibaba.security.common.d.g.a() != null) {
                }
                hVar.b();
                a(new WVResult("success"), true);
                return true;
            }
        } catch (Exception e5) {
            e = e5;
            str2 = null;
            str4 = null;
            str3 = str4;
            if (com.alibaba.security.common.c.a.a()) {
                com.alibaba.security.common.c.a.b();
            }
            a.a(hVar);
            a.a("FinishApi parse params error", e);
            str5 = "";
            if ("AUDIT_IN_AUDIT".equals(str2)) {
            }
            bVar = g.a.a.h;
            if (a.C0102a.a.a == null) {
            }
            if (bVar != null) {
            }
            context = this.ao;
            ((Activity) context).finish();
            if (com.alibaba.security.common.d.g.a() != null) {
            }
            hVar.b();
            a(new WVResult("success"), true);
            return true;
        }
    }
}

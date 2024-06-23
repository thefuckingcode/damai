package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gd;
import com.amap.api.mapcore.util.l;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class k extends Thread {
    WeakReference<IAMapDelegate> a = null;
    private Context b;

    public k(Context context, IAMapDelegate iAMapDelegate) {
        this.b = context;
        this.a = new WeakReference<>(iAMapDelegate);
    }

    public void interrupt() {
        super.interrupt();
    }

    public void run() {
        JSONObject jSONObject;
        WeakReference<IAMapDelegate> weakReference;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        JSONObject jSONObject3;
        JSONObject optJSONObject2;
        JSONObject jSONObject4;
        JSONObject optJSONObject3;
        WeakReference<IAMapDelegate> weakReference2;
        gm e;
        JSONObject jSONObject5;
        JSONObject optJSONObject4;
        WeakReference<IAMapDelegate> weakReference3;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                gi.a().a(this.b);
                StringBuilder sb = new StringBuilder();
                sb.append("14S");
                sb.append(";");
                sb.append("11K");
                sb.append(";");
                sb.append("001");
                sb.append(";");
                sb.append("14M");
                sb.append(";");
                sb.append("14L");
                sb.append(";");
                sb.append("16V");
                sb.append(";");
                sb.append("14Z");
                sb.append(";");
                sb.append("154");
                sb.append(";");
                sb.append("156");
                sb.append(";");
                sb.append("15C");
                sb.append(";");
                sb.append("16G");
                try {
                    WeakReference<IAMapDelegate> weakReference4 = this.a;
                    if (!(weakReference4 == null || weakReference4.get() == null)) {
                        IAMapDelegate iAMapDelegate = this.a.get();
                        if (iAMapDelegate.getAMapExtraInterfaceManager() != null) {
                            sb.append(iAMapDelegate.getAMapExtraInterfaceManager().b());
                        }
                    }
                } catch (Throwable unused) {
                }
                gd.a a2 = gd.a(this.b, eq.e(), sb.toString(), (Map<String, String>) null);
                boolean z = true;
                if (!(gd.a == 1 || a2 == null || (weakReference3 = this.a) == null || weakReference3.get() == null)) {
                    Message obtainMessage = this.a.get().getMainHandler().obtainMessage();
                    obtainMessage.what = 2;
                    String str = a2.a;
                    if (str != null) {
                        obtainMessage.obj = str;
                    }
                    this.a.get().getMainHandler().sendMessage(obtainMessage);
                }
                if (!(a2 == null || (jSONObject5 = a2.w) == null || (optJSONObject4 = jSONObject5.optJSONObject("154")) == null || !gd.a(optJSONObject4.getString("able"), true))) {
                    String optString = optJSONObject4.optString("mc");
                    String optString2 = optJSONObject4.optString("si");
                    if (!TextUtils.isEmpty(optString)) {
                        eg.a(this.b, "approval_number", "mc", (Object) optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        eg.a(this.b, "approval_number", "si", (Object) optString2);
                    }
                }
                if (!(a2 == null || a2.x == null || (e = eq.e()) == null)) {
                    e.a(a2.x.a);
                }
                if (a2 != null) {
                    a(a2);
                }
                if (a2 != null) {
                    try {
                        JSONObject jSONObject6 = a2.w;
                        if (jSONObject6 != null && (optJSONObject3 = jSONObject6.optJSONObject("14M")) != null && optJSONObject3.has("able") && gd.a(optJSONObject3.getString("able"), true)) {
                            int i = 2592000;
                            if (optJSONObject3.has("time")) {
                                i = Math.max(60, optJSONObject3.getInt("time"));
                            }
                            if (!(System.currentTimeMillis() - eg.a(this.b, "Map3DCache", "time", (Long) 0L).longValue() <= ((long) (i * 1000)) || (weakReference2 = this.a) == null || weakReference2.get() == null)) {
                                this.a.get().clearTileCache();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (!(a2 == null || (jSONObject4 = a2.w) == null)) {
                    try {
                        JSONObject optJSONObject5 = jSONObject4.optJSONObject("14L");
                        if (optJSONObject5 != null && optJSONObject5.has("able")) {
                            boolean a3 = gd.a(optJSONObject5.getString("able"), false);
                            WeakReference<IAMapDelegate> weakReference5 = this.a;
                            if (!(weakReference5 == null || weakReference5.get() == null)) {
                                IAMapDelegate iAMapDelegate2 = this.a.get();
                                if (a3) {
                                    z = false;
                                }
                                iAMapDelegate2.setHideLogoEnble(z);
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (!(a2 == null || (jSONObject3 = a2.w) == null || (optJSONObject2 = jSONObject3.optJSONObject("156")) == null)) {
                    ea.a(gd.a(optJSONObject2.optString("able"), false));
                }
                if (!(a2 == null || a2.w == null)) {
                    a(this.b, eq.e(), a2);
                }
                if (!(a2 == null || (jSONObject2 = a2.w) == null || (optJSONObject = jSONObject2.optJSONObject("15C")) == null)) {
                    final boolean a4 = gd.a(optJSONObject.optString("able"), false);
                    final String optString3 = optJSONObject.optString("logo_day_url");
                    final String optString4 = optJSONObject.optString("logo_day_md5");
                    final String optString5 = optJSONObject.optString("logo_night_url");
                    final String optString6 = optJSONObject.optString("logo_night_md5");
                    final String optString7 = optJSONObject.optString("logo_day_ipv6_url");
                    final String optString8 = optJSONObject.optString("logo_night_ipv6_url");
                    ep.a().a(new Runnable() {
                        /* class com.amap.api.mapcore.util.k.AnonymousClass1 */

                        public void run() {
                            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3)) {
                                boolean z = a4;
                                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                                String str2 = optString3;
                                String str3 = optString4;
                                String str4 = optString7;
                                if (z) {
                                    l.d dVar = new l.d(str2, str3, str4, str);
                                    dVar.a("amap_web_logo", "md5_day");
                                    new l(k.this.b, dVar, eq.e()).a();
                                }
                                WeakReference<IAMapDelegate> weakReference = k.this.a;
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    k.this.a.get().changeLogoIconStyle(str, z, 0);
                                }
                            }
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString5)) {
                                boolean z2 = a4;
                                String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
                                String str6 = optString5;
                                String str7 = optString6;
                                String str8 = optString8;
                                if (z2) {
                                    l.d dVar2 = new l.d(str6, str7, str8, str5);
                                    dVar2.a("amap_web_logo", "md5_night");
                                    new l(k.this.b, dVar2, eq.e()).a();
                                }
                                WeakReference<IAMapDelegate> weakReference2 = k.this.a;
                                if (weakReference2 != null && weakReference2.get() != null) {
                                    k.this.a.get().changeLogoIconStyle(str5, z2, 1);
                                }
                            }
                        }
                    });
                }
                if (a2 != null) {
                    try {
                        if (!(a2.w == null || (weakReference = this.a) == null || weakReference.get() == null)) {
                            IAMapDelegate iAMapDelegate3 = this.a.get();
                            if (iAMapDelegate3.getAMapExtraInterfaceManager() != null) {
                                iAMapDelegate3.getAMapExtraInterfaceManager().a(a2.w);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (!(a2 == null || (jSONObject = a2.w) == null)) {
                    a(jSONObject);
                }
                hd.a(this.b, eq.e());
                interrupt();
                WeakReference<IAMapDelegate> weakReference6 = this.a;
                if (weakReference6 != null && weakReference6.get() != null) {
                    this.a.get().setRunLowFrame(false);
                }
            }
        } catch (Throwable th3) {
            interrupt();
            hd.c(th3, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th3.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("16G");
                boolean a2 = gd.a(optJSONObject.optString("able", ""), false);
                boolean a3 = gd.a(optJSONObject.optString("removeCache", ""), false);
                boolean a4 = gd.a(optJSONObject.optString("uploadInfo", ""), false);
                eh.a(a2);
                eh.b(a3);
                eh.c(a4);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Context context, gm gmVar, gd.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && (jSONObject = aVar.w) != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("16V");
                boolean a2 = gd.a(optJSONObject.optString(AppIconSetting.DEFAULT_LARGE_ICON, ""), false);
                String optString = optJSONObject.optString("dis", "");
                boolean a3 = gd.a(optJSONObject.optString("able", ""), false);
                boolean a4 = gd.a(optJSONObject.optString("isFilter", ""), true);
                if (!a2 || gn.f(optString)) {
                    hm.a(gmVar).a(context, a3, a4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(gd.a aVar) {
        try {
            gd.a.C0146a aVar2 = aVar.x;
            if (aVar2 != null) {
                en.a(this.b, "maploc", "ue", Boolean.valueOf(aVar2.a));
                JSONObject jSONObject = aVar2.c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                int i = 30;
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 >= 30) {
                    i = optInt2;
                }
                ir.a(optInt, gd.a(jSONObject.optString("igu"), false));
                en.a(this.b, "maploc", "opn", Integer.valueOf(i));
            }
        } catch (Throwable th) {
            hd.c(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }
}

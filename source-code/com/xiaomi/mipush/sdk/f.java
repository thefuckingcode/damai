package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class f implements AbstractPushManager {
    private static volatile f a;

    /* renamed from: a  reason: collision with other field name */
    private Context f70a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f71a;

    /* renamed from: a  reason: collision with other field name */
    private Map<e, AbstractPushManager> f72a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private boolean f73a = false;

    private f(Context context) {
        this.f70a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private void a() {
        e eVar;
        AbstractPushManager a2;
        e eVar2;
        AbstractPushManager a3;
        e eVar3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f71a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f71a.getOpenHmsPush() + " HW online switch : " + i.m242a(this.f70a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ag.HUAWEI.equals(n.a(this.f70a)));
                b.m182a(sb.toString());
            }
            if (this.f71a.getOpenHmsPush()) {
                Context context = this.f70a;
                e eVar4 = e.ASSEMBLE_PUSH_HUAWEI;
                if (i.m242a(context, eVar4) && ag.HUAWEI.equals(n.a(this.f70a))) {
                    if (!m236a(eVar4)) {
                        a(eVar4, ak.a(this.f70a, eVar4));
                    }
                    b.c("hw manager add to list");
                    if (this.f71a.getOpenFCMPush()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("ASSEMBLE_PUSH : ");
                        sb2.append(" FCM user switch : " + this.f71a.getOpenFCMPush() + " FCM online switch : " + i.m242a(this.f70a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.m246a(this.f70a));
                        b.m182a(sb2.toString());
                    }
                    if (this.f71a.getOpenFCMPush()) {
                        Context context2 = this.f70a;
                        e eVar5 = e.ASSEMBLE_PUSH_FCM;
                        if (i.m242a(context2, eVar5) && n.m246a(this.f70a)) {
                            if (!m236a(eVar5)) {
                                a(eVar5, ak.a(this.f70a, eVar5));
                            }
                            b.c("fcm manager add to list");
                            if (this.f71a.getOpenCOSPush()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("ASSEMBLE_PUSH : ");
                                sb3.append(" COS user switch : " + this.f71a.getOpenCOSPush() + " COS online switch : " + i.m242a(this.f70a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.b(this.f70a));
                                b.m182a(sb3.toString());
                            }
                            if (this.f71a.getOpenCOSPush()) {
                                Context context3 = this.f70a;
                                e eVar6 = e.ASSEMBLE_PUSH_COS;
                                if (i.m242a(context3, eVar6) && n.b(this.f70a)) {
                                    a(eVar6, ak.a(this.f70a, eVar6));
                                    if (this.f71a.getOpenFTOSPush()) {
                                        Context context4 = this.f70a;
                                        e eVar7 = e.ASSEMBLE_PUSH_FTOS;
                                        if (i.m242a(context4, eVar7) && n.c(this.f70a)) {
                                            a(eVar7, ak.a(this.f70a, eVar7));
                                            return;
                                        }
                                    }
                                    eVar = e.ASSEMBLE_PUSH_FTOS;
                                    if (m236a(eVar) && (a2 = a(eVar)) != null) {
                                        m235a(eVar);
                                        a2.unregister();
                                        return;
                                    }
                                    return;
                                }
                            }
                            eVar2 = e.ASSEMBLE_PUSH_COS;
                            if (m236a(eVar2) && (a3 = a(eVar2)) != null) {
                                m235a(eVar2);
                                a3.unregister();
                            }
                            if (this.f71a.getOpenFTOSPush()) {
                            }
                            eVar = e.ASSEMBLE_PUSH_FTOS;
                            if (m236a(eVar)) {
                                return;
                            }
                            return;
                        }
                    }
                    eVar3 = e.ASSEMBLE_PUSH_FCM;
                    if (m236a(eVar3) && (a4 = a(eVar3)) != null) {
                        m235a(eVar3);
                        a4.unregister();
                    }
                    if (this.f71a.getOpenCOSPush()) {
                    }
                    if (this.f71a.getOpenCOSPush()) {
                    }
                    eVar2 = e.ASSEMBLE_PUSH_COS;
                    m235a(eVar2);
                    a3.unregister();
                    if (this.f71a.getOpenFTOSPush()) {
                    }
                    eVar = e.ASSEMBLE_PUSH_FTOS;
                    if (m236a(eVar)) {
                    }
                }
            }
            e eVar8 = e.ASSEMBLE_PUSH_HUAWEI;
            if (m236a(eVar8) && (a5 = a(eVar8)) != null) {
                m235a(eVar8);
                a5.unregister();
            }
            if (this.f71a.getOpenFCMPush()) {
            }
            if (this.f71a.getOpenFCMPush()) {
            }
            eVar3 = e.ASSEMBLE_PUSH_FCM;
            m235a(eVar3);
            a4.unregister();
            if (this.f71a.getOpenCOSPush()) {
            }
            if (this.f71a.getOpenCOSPush()) {
            }
            eVar2 = e.ASSEMBLE_PUSH_COS;
            m235a(eVar2);
            a3.unregister();
            if (this.f71a.getOpenFTOSPush()) {
            }
            eVar = e.ASSEMBLE_PUSH_FTOS;
            if (m236a(eVar)) {
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f72a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f71a = pushConfiguration;
        this.f73a = ba.a(this.f70a).a(ho.AggregatePushSwitch.a(), true);
        if (this.f71a.getOpenHmsPush() || this.f71a.getOpenFCMPush() || this.f71a.getOpenCOSPush() || this.f71a.getOpenFTOSPush()) {
            ba.a(this.f70a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m235a(e eVar) {
        this.f72a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f72a.containsKey(eVar)) {
                this.f72a.remove(eVar);
            }
            this.f72a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m236a(e eVar) {
        return this.f72a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f71a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f71a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f71a;
            return pushConfiguration3 != null ? pushConfiguration3.getOpenFTOSPush() : z;
        } else {
            PushConfiguration pushConfiguration4 = this.f71a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        b.m182a("ASSEMBLE_PUSH : assemble push register");
        if (this.f72a.size() <= 0) {
            a();
        }
        if (this.f72a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m238a(this.f70a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        b.m182a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f72a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f72a.clear();
    }
}

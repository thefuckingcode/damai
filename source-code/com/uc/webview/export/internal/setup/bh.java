package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
public class bh extends ax {
    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.internal.setup.ax
    public final bu a(bt btVar) {
        return new a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        b.a(281);
        if (!af.b() || getUCM() == null) {
            a(p.b((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        } else {
            b(getUCM());
        }
        b.a(282);
    }

    /* compiled from: Taobao */
    class a extends bu {
        int a = 0;
        boolean b;
        final ValueCallback<Object> c = new bi(this);

        public a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if (num != null) {
                this.a = num.intValue();
            }
            this.b = !p.b((Boolean) this.f.getOption(UCCore.OPTION_USE_SDK_SETUP));
        }

        static /* synthetic */ void c(a aVar) {
            int i = ae.d.b;
            if ((aVar.a & 32) != 0) {
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_PAK;
                ae a2 = ae.a();
                a2.getClass();
                aVar.a(i2, bVar, new ae.a(new bp(aVar), aVar.c), aVar.c);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final boolean a() {
            b.a(298);
            this.f.getOption("CONTEXT");
            this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if ((this.a & 4) != 0) {
                int i = ae.d.b;
                ae.b bVar = ae.b.VERIFY_CORE_JAR;
                ae a2 = ae.a();
                a2.getClass();
                a(i, bVar, new ae.a(new bj(this), this.c), this.c);
                b.a(299);
                return true;
            }
            b.a(299);
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            b.a(300);
            b.a(302);
            int i = ae.d.b;
            ae.b bVar = ae.b.CHECK_OLD_KERNEL;
            ae a2 = ae.a();
            a2.getClass();
            a(i, bVar, new ae.a(new bk(this), this.c), this.c);
            b.a(303);
            if ((this.a & 1) != 0) {
                int i2 = ae.d.b;
                ae.b bVar2 = ae.b.VERIFY_SDK_SHELL;
                ae a3 = ae.a();
                a3.getClass();
                a(i2, bVar2, new ae.a(new bl(this), this.c), this.c);
            }
            b.a(304);
            int i3 = ae.d.b;
            ae.b bVar3 = ae.b.LOAD_SDK_SHELL;
            ae a4 = ae.a();
            a4.getClass();
            a(i3, bVar3, new ae.a(new bm(this), this.c), this.c);
            b.a(301);
        }

        static /* synthetic */ void a(a aVar) {
            if (!p.b((Boolean) aVar.f.getOption(UCCore.OPTION_USE_SDK_SETUP))) {
                int i = ae.d.b;
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_VERSION;
                ae a2 = ae.a();
                a2.getClass();
                aVar.a(i2, bVar, new ae.a(new bn(aVar), aVar.c), aVar.c);
            }
        }

        static /* synthetic */ void b(a aVar) {
            int i = ae.d.b;
            if ((aVar.a & 8) != 0) {
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_SO;
                ae a2 = ae.a();
                a2.getClass();
                aVar.a(i2, bVar, new ae.a(new bo(aVar), aVar.c), aVar.c);
            }
        }
    }
}

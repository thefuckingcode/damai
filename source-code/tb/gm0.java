package tb;

import android.app.Activity;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.fluttercommon.DMBaseFlutterActivity;
import cn.damai.fluttercommon.DMNFCActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.c;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.lifecycle.SolidResponse;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.ArrayList;
import tb.xl0;

/* compiled from: Taobao */
public class gm0 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = (gm0.class.getSimpleName() + "_xxx");
    private static String b = "XGS5ysbZ/3DHAT6TGKdGJ7CeBYobdomOTKN5D6yP/v4kd4kjntIrTugRVGudxRwu/bq0UZyJA2XLyRnQLL0QNrUd/m+NZJO+uebVTLVSZBeSNSii5XCXoOIzmyhA8lAmThp12mNOcLuVGqVRRzC4Bh8pxfRRPI+p5mMf3FwlShGWq4lVgT4KgvCg7MeC8NkfAZMim4nDJmRgGxRG8FcD4pAI7MfobG/xlfzoVcvHMtw8xOy+tZ3uJmVFQ4Hn5g3LgbQD538wmT9aP2tQU+xsMEjPZwSwO33w7oBbHF4ah/byOjaiBVIyrk8k9wETwCy8B4WxO4bdKRrQ8EBc+BekJw==";
    private static gm0 c;
    private volatile boolean a = false;

    /* compiled from: Taobao */
    public class a implements FlutterBoostDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        a(gm0 gm0) {
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public boolean popRoute(c cVar) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-600517833")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-600517833", new Object[]{this, cVar})).booleanValue();
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public void pushFlutterRoute(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-900168956")) {
                ipChange.ipc$dispatch("-900168956", new Object[]{this, cVar});
                return;
            }
            Activity c = i3.b().c();
            if (FlutterBoost.h().e() != null) {
                c = FlutterBoost.h().e();
            }
            Class cls = DMBaseFlutterActivity.class;
            if (!TextUtils.isEmpty(cVar.b()) && "dm_ticket_nfc".equals(cVar.b())) {
                cls = DMNFCActivity.class;
            }
            c.startActivity(new FlutterBoostActivity.a(cls).a(FlutterActivityLaunchConfigs.BackgroundMode.transparent).c(false).d(cVar.d()).e(cVar.b()).f(cVar.a()).b(c));
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public void pushNativeRoute(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1246254265")) {
                ipChange.ipc$dispatch("-1246254265", new Object[]{this, cVar});
            } else if (FlutterBoost.h().e() != null) {
                DMNav.from(FlutterBoost.h().e()).forResult(cVar.c()).withExtras(kn.a(cVar.a())).toUri(cVar.b());
            }
        }
    }

    private gm0() {
    }

    public static gm0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352148219")) {
            return (gm0) ipChange.ipc$dispatch("352148219", new Object[0]);
        }
        if (c == null) {
            synchronized (gm0.class) {
                if (c == null) {
                    c = new gm0();
                }
            }
        }
        return c;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(FlutterEngine flutterEngine) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540252567")) {
            ipChange.ipc$dispatch("1540252567", new Object[]{flutterEngine});
            return;
        }
        yr0.b();
        yr0.a(flutterEngine);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930685792")) {
            ipChange.ipc$dispatch("-1930685792", new Object[]{this});
        } else if (!c()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("--user-authorization-code=" + b);
            if (!AppConfig.v()) {
                SolidRequest solidRequest = new SolidRequest();
                solidRequest.name = cn.damai.solid.a.LIB_APP_SO;
                SolidResponse checkSoFilePath = SolidServer.checkSoFilePath(solidRequest);
                String str = "--aot-shared-library-name=" + checkSoFilePath.soFilePath;
                g91.c(cn.damai.solid.a.TAG, "flutter shellArgs lib app path : " + str);
                arrayList.add(str);
            }
            String[] strArr = null;
            if (!arrayList.isEmpty()) {
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            FlutterBoost.h().m(xs0.a(), new a(this), fm0.a, new xl0.b().g(strArr).f());
            this.a = true;
        }
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1452350973")) {
            return this.a && FlutterBoost.h().f() != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("1452350973", new Object[]{this})).booleanValue();
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374464320")) {
            ipChange.ipc$dispatch("1374464320", new Object[]{this});
            return;
        }
        b();
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069281529")) {
            ipChange.ipc$dispatch("-1069281529", new Object[]{this});
            return;
        }
        DMNav.registerStickPreprocessor(new t4());
    }
}

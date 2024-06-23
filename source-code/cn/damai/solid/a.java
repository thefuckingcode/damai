package cn.damai.solid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.solid.SoLibInstallActivity;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.bean.SoInstallResult;
import cn.damai.solid.bean.SoRecord;
import cn.damai.solid.listener.SoInstallListener;
import cn.damai.solid.util.Constant;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.SolidConfig;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.download.XcdnDownloaderImpl;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.util.LibPathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.fc2;
import tb.gc2;
import tb.jf1;
import tb.nc;
import tb.uc2;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LIB_APP_SO = "libapp.so";
    public static final String TAG = "Solid";
    public static boolean d = true;
    private static a e;
    private final HashMap<SoGroupEnum, List<SoRecord>> a;
    private final HashMap<Integer, uc2> b = new HashMap<>();
    private volatile boolean c = false;

    /* renamed from: cn.damai.solid.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0047a implements Solid.OnInitFinishCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C0047a() {
        }

        @Override // com.youku.arch.solid.Solid.OnInitFinishCallback
        public void onFinish(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "66137371")) {
                ipChange.ipc$dispatch("66137371", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                a.this.c = true;
                a.f("init success");
                Solid.getInstance().start();
            }
        }
    }

    private a() {
        HashMap<SoGroupEnum, List<SoRecord>> hashMap = new HashMap<>();
        this.a = hashMap;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SoRecord("libpanorenderer.so"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SoRecord("libflutter.so"));
        if (!AppConfig.v()) {
            SoRecord soRecord = new SoRecord(LIB_APP_SO);
            soRecord.isSkipAppSystemLoad = true;
            arrayList2.add(soRecord);
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new SoRecord("libweexcore.so"));
        arrayList3.add(new SoRecord("libWTF.so"));
        arrayList3.add(new SoRecord("libJavaScriptCore.so"));
        hashMap.put(SoGroupEnum.VR, arrayList);
        hashMap.put(SoGroupEnum.FLUTTER, arrayList2);
        hashMap.put(SoGroupEnum.WEEX, arrayList3);
    }

    public static a d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040704729")) {
            return (a) ipChange.ipc$dispatch("1040704729", new Object[0]);
        }
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707782866")) {
            ipChange.ipc$dispatch("-707782866", new Object[]{str});
        } else if (d) {
            Log.e(TAG, str);
        }
    }

    private void h(Application application, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997657208")) {
            ipChange.ipc$dispatch("-997657208", new Object[]{this, application, Long.valueOf(j)});
            return;
        }
        nc.e(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        DMNav.registerStickPreprocessor(new fc2());
        DMNav.registerStickPreprocessor(new gc2());
        Solid.getInstance().init(new SolidConfig.Builder(application).openLog(AppConfig.v()).useCompress(true).setLibPath(LibPathUtil.getDefaultLibPath(application)).setLaunchTimeMillions(j).setVersionName(AppConfig.q()).setDownloader(new XcdnDownloaderImpl("1")).setMonitor(new jf1()).build(), new C0047a());
        nc.a("SolidInit", SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
    }

    public void b(Context context, SoGroupEnum soGroupEnum, SoInstallListener soInstallListener) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "160196183")) {
            ipChange.ipc$dispatch("160196183", new Object[]{this, context, soGroupEnum, soInstallListener});
            return;
        }
        uc2 uc2 = new uc2(soGroupEnum, soInstallListener);
        if (!this.c) {
            uc2.onInstallFail(Constant.CODE_SOLID_NOT_INIT, Constant.MSG_SOLID_NOT_INIT);
            return;
        }
        List<SoRecord> list = this.a.get(soGroupEnum);
        if (f92.d(list)) {
            uc2.onInstallFail(Constant.CODE_SOLID_NONE_SO_GROUP, Constant.MSG_SOLID_NONE_SO_GROUP);
            return;
        }
        Iterator<SoRecord> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SoRecord next = it.next();
            if (!next.isSkipAppSystemLoad && !next.isSystemLoaded) {
                z = false;
                break;
            }
        }
        if (z) {
            f("dependOnRemoteSoInstall: GN:" + soGroupEnum.soGroupName + " onInstallSuccess already install");
            uc2.onInstallSuccess();
            return;
        }
        SolidRequest solidRequest = new SolidRequest();
        solidRequest.name = soGroupEnum.soGroupName;
        Status checkSoGroupStatus = SolidServer.checkSoGroupStatus(solidRequest);
        f("dependOnRemoteSoInstall: not install GN:" + soGroupEnum.soGroupName + " status:" + checkSoGroupStatus.name());
        if (Status.DOWNLOADED != checkSoGroupStatus || !c(soGroupEnum).isSoInstallSuccess) {
            int uniqueKey = uc2.getUniqueKey();
            this.b.put(Integer.valueOf(uniqueKey), uc2);
            Intent intent = new Intent(context, SoLibInstallActivity.class);
            intent.putExtra("extra_key", new SoLibInstallActivity.Extra(soGroupEnum.name(), uniqueKey));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        f("dependOnRemoteSoInstall: downloaded and install success GN:" + soGroupEnum.soGroupName);
        uc2.onInstallSuccess();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0116  */
    public SoInstallResult c(SoGroupEnum soGroupEnum) {
        Exception e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515444028")) {
            return (SoInstallResult) ipChange.ipc$dispatch("515444028", new Object[]{this, soGroupEnum});
        }
        SoRecord soRecord = null;
        try {
            List<SoRecord> list = this.a.get(soGroupEnum);
            if (f92.d(list)) {
                return SoInstallResult.noSoGroupResult();
            }
            for (SoRecord soRecord2 : list) {
                try {
                    SolidRequest solidRequest = new SolidRequest();
                    solidRequest.name = soRecord2.soLibName;
                    String str = SolidServer.checkSoFilePath(solidRequest).soFilePath;
                    if (TextUtils.isEmpty(str)) {
                        if (d) {
                            f("installSoGroup single so install fail soName:" + soRecord2.soLibName);
                        }
                        throw new IllegalStateException(soGroupEnum.soGroupName + " downloaded,but none " + soRecord2.soLibName + "file path");
                    } else if (!soRecord2.isSkipAppSystemLoad) {
                        if (d) {
                            f("installSoGroup start install single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                        }
                        System.load(str);
                        if (d) {
                            f("installSoGroup install success single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                        }
                        soRecord2.isSystemLoaded = true;
                    } else if (d) {
                        f("isSkipAppSystemLoad = true ,Skip system.load() install single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    soRecord = soRecord2;
                    e2.printStackTrace();
                    if (soRecord == null) {
                    }
                    return new SoInstallResult(false, Constant.CODE_SOLID_SYSTEM_LOAD_FAIL, r0 + " System.load fail:" + e2.getMessage());
                }
            }
            return SoInstallResult.success();
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            String str2 = soRecord == null ? soRecord.soLibName : "unknown.so";
            return new SoInstallResult(false, Constant.CODE_SOLID_SYSTEM_LOAD_FAIL, str2 + " System.load fail:" + e2.getMessage());
        }
    }

    public SoInstallListener e(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "931845699")) {
            return this.b.remove(Integer.valueOf(i));
        }
        return (SoInstallListener) ipChange.ipc$dispatch("931845699", new Object[]{this, Integer.valueOf(i)});
    }

    public void g(Application application, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189494410")) {
            ipChange.ipc$dispatch("-189494410", new Object[]{this, application, Long.valueOf(j)});
            return;
        }
        try {
            h(application, j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

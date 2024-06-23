package tb;

import com.alibaba.analytics.version.IUTBuildInfo;

/* compiled from: Taobao */
public class kq2 implements IUTBuildInfo {
    private static kq2 a = null;
    private static String b = "6.5.10.6";

    private kq2() {
    }

    public static synchronized kq2 a() {
        kq2 kq2;
        synchronized (kq2.class) {
            if (a == null) {
                a = new kq2();
            }
            kq2 = a;
        }
        return kq2;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getBuildID() {
        return "";
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getFullSDKVersion() {
        return b;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getGitCommitID() {
        return "";
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getShortSDKVersion() {
        return b;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public boolean isTestMode() {
        return false;
    }
}

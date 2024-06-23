package mtopsdk.config.upload;

import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.MtopOrangeAdapter;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Taobao */
public class UploadSwitchListener extends MtopOrangeAdapter.MtopOrangeListener {
    private final String TAG = "mtopsdk.UploadSwitchListener";

    @Override // mtopsdk.config.MtopOrangeAdapter.MtopOrangeListener, com.taobao.orange.OrangeConfigListenerV1
    public void onConfigUpdate(String str, boolean z) {
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[onConfigUpdate] groupName=");
            sb.append(str);
            sb.append(",fromCache=");
            sb.append(z);
            TBSdkLog.i("mtopsdk.UploadSwitchListener", sb.toString());
        }
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
            /* class mtopsdk.config.upload.UploadSwitchListener.AnonymousClass1 */

            public void run() {
                RemoteConfig.getInstance().updateUploadRemoteConfig();
                UploadSwitchConfigManager instance = UploadSwitchConfigManager.getInstance();
                instance.parseRemoteSegmentSizeMapConfig();
                instance.parseUseHttpsBizCodeSetConfig();
                instance.parseDegradeBizCodeSetConfig();
            }
        });
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i("mtopsdk.UploadSwitchListener", "[onConfigUpdate]submit UploadSwitchConfigBroadcast task to ThreadPool");
        }
    }
}

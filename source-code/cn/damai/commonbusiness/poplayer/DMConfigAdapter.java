package cn.damai.commonbusiness.poplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;

/* compiled from: Taobao */
public class DMConfigAdapter implements IConfigAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final int b;
    private final Handler c = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    public class a implements OrangeConfigListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopLayer a;

        a(PopLayer popLayer) {
            this.a = popLayer;
        }

        @Override // com.taobao.orange.OrangeConfigListener
        public void onConfigUpdate(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "390661601")) {
                ipChange.ipc$dispatch("390661601", new Object[]{this, str});
                return;
            }
            this.a.updateCacheConfigAsync(DMConfigAdapter.this.b);
        }
    }

    public DMConfigAdapter(int i, String str) {
        this.b = i;
        this.a = str;
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public void addConfigObserver(Context context, PopLayer popLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446984553")) {
            ipChange.ipc$dispatch("1446984553", new Object[]{this, context, popLayer});
            return;
        }
        OrangeConfig.getInstance().registerListener(new String[]{this.a}, new a(popLayer));
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public String getConfigItemByKey(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "932583812")) {
            return OrangeConfig.getInstance().getConfig(this.a, str, "");
        }
        return (String) ipChange.ipc$dispatch("932583812", new Object[]{this, context, str});
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public void initializeConfigContainer(Context context, final PopLayer popLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1021069005")) {
            ipChange.ipc$dispatch("-1021069005", new Object[]{this, context, popLayer});
            return;
        }
        this.c.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.poplayer.DMConfigAdapter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;
            private int mRetryCount = 0;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2113658015")) {
                    ipChange.ipc$dispatch("2113658015", new Object[]{this});
                    return;
                }
                try {
                    int i = this.mRetryCount;
                    this.mRetryCount = i + 1;
                    if (i <= 10) {
                        if ("orange_fucking_silly_bug".equals(OrangeConfig.getInstance().getConfig(DMConfigAdapter.this.a, "anyone", "orange_fucking_silly_bug"))) {
                            DMConfigAdapter.this.c.postDelayed(this, 1000);
                        } else {
                            popLayer.updateCacheConfigAsync(DMConfigAdapter.this.b);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }, 1000);
    }
}

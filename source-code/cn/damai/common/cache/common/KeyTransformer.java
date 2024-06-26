package cn.damai.common.cache.common;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public interface KeyTransformer {
    public static final KeyTransformer IDENTITY = new a();

    /* compiled from: Taobao */
    public class a implements KeyTransformer {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.cache.common.KeyTransformer
        public <K> K transform(K k) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1616065130")) {
                return k;
            }
            return (K) ipChange.ipc$dispatch("1616065130", new Object[]{this, k});
        }
    }

    <K> K transform(K k);
}

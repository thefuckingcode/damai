package com.alibaba.pictures.bricks.util.blur;

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

        @Override // com.alibaba.pictures.bricks.util.blur.KeyTransformer
        public <K> K transform(K k) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1930985715")) {
                return k;
            }
            return (K) ipChange.ipc$dispatch("1930985715", new Object[]{this, k});
        }
    }

    <K> K transform(K k);
}

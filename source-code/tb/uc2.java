package tb;

import cn.damai.solid.a;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.listener.SoInstallListener;
import cn.damai.solid.listener.UniqueKeyProvider;
import cn.damai.solid.util.Constant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class uc2 implements SoInstallListener, UniqueKeyProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final AtomicInteger d = new AtomicInteger(1000);
    private final int a = d.getAndIncrement();
    private final SoInstallListener b;
    private final SoGroupEnum c;

    public uc2(SoGroupEnum soGroupEnum, SoInstallListener soInstallListener) {
        this.b = soInstallListener;
        this.c = soGroupEnum;
    }

    @Override // cn.damai.solid.listener.SoInstallListener
    public Map<String, String> alarmExtraMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206777927")) {
            return (Map) ipChange.ipc$dispatch("206777927", new Object[]{this});
        }
        SoInstallListener soInstallListener = this.b;
        if (soInstallListener != null) {
            return soInstallListener.alarmExtraMap();
        }
        return null;
    }

    @Override // cn.damai.solid.listener.UniqueKeyProvider
    public int getUniqueKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1708510518")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("1708510518", new Object[]{this})).intValue();
    }

    @Override // cn.damai.solid.listener.SoInstallListener
    public void onInstallFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432955817")) {
            ipChange.ipc$dispatch("432955817", new Object[]{this, str, str2});
            return;
        }
        a.f("onInstallFail group:" + this.c.soGroupName + "code:" + str + " msg:" + str2);
        HashMap hashMap = new HashMap();
        Map<String, String> alarmExtraMap = alarmExtraMap();
        if (!f92.f(alarmExtraMap)) {
            hashMap.putAll(alarmExtraMap);
        }
        hashMap.put("failSoGroup", this.c.soGroupName);
        vc2.a(str, str2, hashMap);
        SoInstallListener soInstallListener = this.b;
        if (soInstallListener != null) {
            soInstallListener.onInstallFail(str, Constant.MSG_FAIL_TO_USER);
        }
    }

    @Override // cn.damai.solid.listener.SoInstallListener
    public void onInstallSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115818580")) {
            ipChange.ipc$dispatch("2115818580", new Object[]{this});
            return;
        }
        a.f("onInstallSuccess group:" + this.c.soGroupName);
        HashMap hashMap = new HashMap();
        hashMap.put("successSoGroup", this.c.soGroupName);
        vc2.b(hashMap);
        SoInstallListener soInstallListener = this.b;
        if (soInstallListener != null) {
            soInstallListener.onInstallSuccess();
        }
    }
}

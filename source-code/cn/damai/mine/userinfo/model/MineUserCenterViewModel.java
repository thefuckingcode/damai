package cn.damai.mine.userinfo.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.VipCardInfoWrap;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class MineUserCenterViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private MineUserCenterRepository repository = new MineUserCenterRepository();

    public MineUserCenterViewModel(@NonNull Application application) {
        super(application);
    }

    public void requestMineUserCenterData(DMMtopRequestListener<UserCenterDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95956139")) {
            ipChange.ipc$dispatch("95956139", new Object[]{this, dMMtopRequestListener});
            return;
        }
        this.repository.requestUserCenterData(dMMtopRequestListener);
    }

    public void requestUnLoginVipInfo(DMMtopRequestListener<VipCardInfoWrap> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94533289")) {
            ipChange.ipc$dispatch("94533289", new Object[]{this, dMMtopRequestListener});
            return;
        }
        this.repository.requestUnLoginVipInfo(dMMtopRequestListener);
    }
}

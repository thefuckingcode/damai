package cn.damai.category.venue.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.venue.bean.VenueQueryResponse;
import cn.damai.common.aac.DamaiViewModel;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.zu2;

/* compiled from: Taobao */
public class VenueViewModel extends DamaiViewModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private int mPageNo;
    private MutableLiveData<VenueQueryResponse> mQueryBean = new MutableLiveData<>();
    private Object[] mQueryRequest = new Object[3];
    private zu2 mRepository;
    private MutableLiveData<String> toastEvent = new MutableLiveData<>();

    public VenueViewModel(Context context) {
        this.mContext = context;
        this.mRepository = new zu2();
    }

    public MutableLiveData<VenueQueryResponse> getQueryBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1130894187")) {
            return this.mQueryBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1130894187", new Object[]{this});
    }

    public MutableLiveData<String> getToastEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-147000034")) {
            return this.toastEvent;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-147000034", new Object[]{this});
    }

    public void query(int i, String str, String str2, String str3, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965675065")) {
            ipChange.ipc$dispatch("965675065", new Object[]{this, Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2)});
            return;
        }
        this.mRepository.a(i, 20, str, str2, str3, i2, new DMMtopRequestListener<VenueQueryResponse>(VenueQueryResponse.class) {
            /* class cn.damai.category.venue.viewmodel.VenueViewModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1217858831")) {
                    ipChange.ipc$dispatch("1217858831", new Object[]{this, str, str2});
                    return;
                }
                VenueViewModel.this.toastEvent.setValue(str2);
            }

            public void onSuccess(VenueQueryResponse venueQueryResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "435487792")) {
                    ipChange.ipc$dispatch("435487792", new Object[]{this, venueQueryResponse});
                    return;
                }
                VenueViewModel.this.mQueryBean.setValue(venueQueryResponse);
            }
        });
    }

    public void setQueryRequest(int i, String str, String str2, String str3, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913111112")) {
            ipChange.ipc$dispatch("-1913111112", new Object[]{this, Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2)});
            return;
        }
        this.mPageNo = i;
        query(i, str, str2, str3, i2);
    }
}

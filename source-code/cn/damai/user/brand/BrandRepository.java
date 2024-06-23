package cn.damai.user.brand;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.user.brand.bean.BrandInfoRerquest;
import cn.damai.user.brand.bean.BrandInfoResult;
import cn.damai.user.brand.bean.BrandNearbyShowRerquest;
import cn.damai.user.brand.bean.BrandResponse;
import cn.damai.user.brand.bean.BrandShowResponse;
import cn.damai.user.brand.bean.NearbyShows;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BrandRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public BrandRepository(Context context) {
    }

    public MutableLiveData<BrandResponse> a(BrandInfoRerquest brandInfoRerquest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642371951")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-642371951", new Object[]{this, brandInfoRerquest});
        }
        final MutableLiveData<BrandResponse> mutableLiveData = new MutableLiveData<>();
        brandInfoRerquest.request(new DMMtopRequestListener<BrandInfoResult>(BrandInfoResult.class) {
            /* class cn.damai.user.brand.BrandRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "86752769")) {
                    ipChange.ipc$dispatch("86752769", new Object[]{this, str, str2});
                    return;
                }
                BrandResponse brandResponse = new BrandResponse();
                brandResponse.errorCode = str;
                brandResponse.errorMsg = str2;
                mutableLiveData.setValue(brandResponse);
            }

            public void onSuccess(BrandInfoResult brandInfoResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2081908921")) {
                    ipChange.ipc$dispatch("-2081908921", new Object[]{this, brandInfoResult});
                    return;
                }
                BrandResponse brandResponse = new BrandResponse();
                brandResponse.data = brandInfoResult;
                mutableLiveData.setValue(brandResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<BrandShowResponse> b(BrandNearbyShowRerquest brandNearbyShowRerquest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951116554")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-951116554", new Object[]{this, brandNearbyShowRerquest});
        }
        final MutableLiveData<BrandShowResponse> mutableLiveData = new MutableLiveData<>();
        brandNearbyShowRerquest.request(new DMMtopRequestListener<NearbyShows>(NearbyShows.class) {
            /* class cn.damai.user.brand.BrandRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "78993410")) {
                    ipChange.ipc$dispatch("78993410", new Object[]{this, str, str2});
                    return;
                }
                BrandShowResponse brandShowResponse = new BrandShowResponse();
                brandShowResponse.errorCode = str;
                brandShowResponse.errorMsg = str2;
                mutableLiveData.setValue(brandShowResponse);
            }

            public void onSuccess(NearbyShows nearbyShows) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1359061953")) {
                    ipChange.ipc$dispatch("1359061953", new Object[]{this, nearbyShows});
                    return;
                }
                BrandShowResponse brandShowResponse = new BrandShowResponse();
                brandShowResponse.data = nearbyShows;
                mutableLiveData.setValue(brandShowResponse);
            }
        });
        return mutableLiveData;
    }
}

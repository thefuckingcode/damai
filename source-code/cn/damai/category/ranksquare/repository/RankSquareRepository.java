package cn.damai.category.ranksquare.repository;

import androidx.lifecycle.MutableLiveData;
import cn.damai.category.ranksquare.bean.RankSquareBean;
import cn.damai.category.ranksquare.bean.RankSquareMoreBean;
import cn.damai.category.ranksquare.bean.RankSquareResponse;
import cn.damai.category.ranksquare.request.RankSquareMoreRequest;
import cn.damai.category.ranksquare.request.RankSquareRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RankSquareRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public MutableLiveData<RankSquareResponse> a(RankSquareMoreRequest rankSquareMoreRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233569498")) {
            return (MutableLiveData) ipChange.ipc$dispatch("233569498", new Object[]{this, rankSquareMoreRequest});
        }
        final MutableLiveData<RankSquareResponse> mutableLiveData = new MutableLiveData<>();
        AnonymousClass2 r1 = new DMMtopRequestListener<RankSquareMoreBean>(RankSquareMoreBean.class) {
            /* class cn.damai.category.ranksquare.repository.RankSquareRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "523914434")) {
                    ipChange.ipc$dispatch("523914434", new Object[]{this, str, str2});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(false);
                rankSquareResponse.errorCode = str;
                rankSquareResponse.errorMsg = str2;
                mutableLiveData.setValue(rankSquareResponse);
            }

            public void onSuccess(RankSquareMoreBean rankSquareMoreBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "765244077")) {
                    ipChange.ipc$dispatch("765244077", new Object[]{this, rankSquareMoreBean});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(true);
                rankSquareResponse.mRankSquareMoreBean = rankSquareMoreBean;
                mutableLiveData.setValue(rankSquareResponse);
            }
        };
        if (rankSquareMoreRequest != null) {
            rankSquareMoreRequest.request(r1);
        }
        return mutableLiveData;
    }

    public MutableLiveData<RankSquareResponse> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1356026416")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1356026416", new Object[]{this});
        }
        final MutableLiveData<RankSquareResponse> mutableLiveData = new MutableLiveData<>();
        new RankSquareRequest().request(new DMMtopRequestListener<RankSquareBean>(RankSquareBean.class) {
            /* class cn.damai.category.ranksquare.repository.RankSquareRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "531673793")) {
                    ipChange.ipc$dispatch("531673793", new Object[]{this, str, str2});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(false);
                rankSquareResponse.errorCode = str;
                rankSquareResponse.errorMsg = str2;
                mutableLiveData.setValue(rankSquareResponse);
            }

            public void onSuccess(RankSquareBean rankSquareBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "149564579")) {
                    ipChange.ipc$dispatch("149564579", new Object[]{this, rankSquareBean});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(true);
                rankSquareResponse.mRankSquareBean = rankSquareBean;
                mutableLiveData.setValue(rankSquareResponse);
            }
        });
        return mutableLiveData;
    }
}

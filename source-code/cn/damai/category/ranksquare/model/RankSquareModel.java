package cn.damai.category.ranksquare.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.ranksquare.bean.RankSquareResponse;
import cn.damai.category.ranksquare.repository.RankSquareRepository;
import cn.damai.category.ranksquare.request.RankSquareMoreRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RankSquareModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private MutableLiveData<Integer> mPageIndex = new MutableLiveData<>();
    public RankSquareRepository mRepository = new RankSquareRepository();

    public RankSquareModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<RankSquareResponse> getMoreRankSquareData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612203481")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-612203481", new Object[]{this});
        }
        RankSquareMoreRequest rankSquareMoreRequest = new RankSquareMoreRequest();
        rankSquareMoreRequest.pageNo = this.mPageIndex.getValue().intValue();
        return this.mRepository.a(rankSquareMoreRequest);
    }

    public MutableLiveData<Integer> getPageIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "359538306")) {
            return this.mPageIndex;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("359538306", new Object[]{this});
    }

    public MutableLiveData<RankSquareResponse> getRankSquareListData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1562886128")) {
            return this.mRepository.b();
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1562886128", new Object[]{this});
    }
}

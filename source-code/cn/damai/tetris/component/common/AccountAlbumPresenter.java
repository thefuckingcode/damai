package cn.damai.tetris.component.common;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.f92;
import tb.w9;

/* compiled from: Taobao */
public class AccountAlbumPresenter extends BasePresenter<AccountAlbumContract.Model, AccountAlbumContract.View, BaseSection> implements AccountAlbumContract.Presenter<AccountAlbumContract.Model, AccountAlbumContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public AccountAlbumPresenter(AccountAlbumView accountAlbumView, String str, w9 w9Var) {
        super(accountAlbumView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934113887")) {
            ipChange.ipc$dispatch("-1934113887", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2125320318")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2125320318", new Object[]{this})).booleanValue();
    }

    public void init(AccountAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027340157")) {
            ipChange.ipc$dispatch("2027340157", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (!f92.d(model.getAccounts())) {
            if (model.getStyleInfo() != null && !TextUtils.isEmpty(model.getStyleInfo().getString("title"))) {
                ((AccountAlbumContract.View) getView()).getTitle().setText(model.getStyleInfo().getString("title"));
            }
            ((AccountAlbumContract.View) getView()).getRecycleView().setVisibility(0);
            ((AccountAlbumContract.View) getView()).getRecycleView().setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext.getActivity());
            linearLayoutManager.setOrientation(0);
            ((AccountAlbumContract.View) getView()).getRecycleView().setLayoutManager(linearLayoutManager);
            ((AccountAlbumContract.View) getView()).getRecycleView().setAdapter(new AccountAlbumAdapter(this.mContext.getActivity(), model.getAccounts(), this));
        }
    }

    public void rebindData(AccountAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657997927")) {
            ipChange.ipc$dispatch("657997927", new Object[]{this, model});
            return;
        }
        super.rebindData((IModel) model);
    }
}

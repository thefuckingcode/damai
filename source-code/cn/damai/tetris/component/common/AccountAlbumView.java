package cn.damai.tetris.component.common;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AccountAlbumView extends AbsView<AccountAlbumContract.Presenter> implements AccountAlbumContract.View<AccountAlbumContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    RecyclerView albumView;
    private Context mContext;
    TextView title;

    public AccountAlbumView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.albumView = (RecyclerView) view.findViewById(R$id.common_account_list);
        this.title = (TextView) view.findViewById(R$id.common_account_title);
    }

    @Override // cn.damai.tetris.component.common.AccountAlbumContract.View
    public RecyclerView getRecycleView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1286372896")) {
            return this.albumView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("-1286372896", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.AccountAlbumContract.View
    public TextView getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-998189331")) {
            return this.title;
        }
        return (TextView) ipChange.ipc$dispatch("-998189331", new Object[]{this});
    }
}

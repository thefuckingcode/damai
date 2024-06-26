package cn.damai.tetris.component.ip;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.ip.IpVideoAlbumContract;
import cn.damai.tetris.component.ip.bean.VideoAlbum;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.BasePresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.tf;

/* compiled from: Taobao */
public class IpVideoAlbumView extends AbsView<IpVideoAlbumContract.Presenter> implements IpVideoAlbumContract.View<IpVideoAlbumContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private tf mPanel;

    public IpVideoAlbumView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mPanel = new tf(view);
    }

    @Override // cn.damai.tetris.component.ip.IpVideoAlbumContract.View
    public tf getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-818227390")) {
            return this.mPanel;
        }
        return (tf) ipChange.ipc$dispatch("-818227390", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpVideoAlbumContract.View
    public void initAblum(List<VideoAlbum> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044759696")) {
            ipChange.ipc$dispatch("-1044759696", new Object[]{this, list});
        } else if (list != null) {
            RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R$id.ip_videoalbum_list);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new IpVideoAlbumAdapter(this.mContext, list, (BasePresenter) getPresenter()));
        }
    }
}

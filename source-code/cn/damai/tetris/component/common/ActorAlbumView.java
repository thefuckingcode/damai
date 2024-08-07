package cn.damai.tetris.component.common;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.ActorAlbumContract;
import cn.damai.tetris.component.common.bean.ActorBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.view.DMLRLabelView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.gr;
import tb.ob;

/* compiled from: Taobao */
public class ActorAlbumView extends AbsView<ActorAlbumContract.Presenter> implements ActorAlbumContract.View<ActorAlbumContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1859276847")) {
                ipChange.ipc$dispatch("-1859276847", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, ((ActorBean) this.a.get(0)).getArtistId());
            bundle.putString("usertype", "2");
            DMNav.from(ActorAlbumView.this.mContext).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
            if (ActorAlbumView.this.getPresenter() != null) {
                ((BasePresenter) ActorAlbumView.this.getPresenter()).userTrackClick("artist_0", true);
            }
        }
    }

    public ActorAlbumView(View view) {
        super(view);
        this.mContext = view.getContext();
    }

    @Override // cn.damai.tetris.component.common.ActorAlbumContract.View
    public void initAblum(List<ActorBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699427755")) {
            ipChange.ipc$dispatch("-1699427755", new Object[]{this, list});
        } else if (list != null) {
            if (list.size() == 1) {
                ((RecyclerView) getRootView().findViewById(R$id.ip_actoralbum_list)).setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) getRootView().findViewById(R$id.actor_single_layout);
                viewGroup.setVisibility(0);
                if (list.get(0) != null) {
                    ob.a((TextView) viewGroup.findViewById(R$id.tv_artist_name), list.get(0).getName());
                    ob.a((TextView) viewGroup.findViewById(R$id.tv_artist_desc), list.get(0).getDescription());
                    int i = R$id.tv_tag;
                    ((DMLRLabelView) viewGroup.findViewById(i)).setContent("V", list.get(0).getSubtype());
                    cn.damai.uikit.image.a.a().loadinto(list.get(0).getHeadPic(), (ImageView) viewGroup.findViewById(R$id.artist_image));
                    if (getPresenter() != null) {
                        ((BasePresenter) getPresenter()).userTrackExpose(viewGroup.findViewById(i), "artist_0");
                    }
                    viewGroup.setOnClickListener(new a(list));
                    return;
                }
                return;
            }
            getRootView().findViewById(R$id.actor_single_layout).setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R$id.ip_actoralbum_list);
            recyclerView.setVisibility(0);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new ActorAlbumAdapter(this.mContext, list, (BasePresenter) getPresenter()));
        }
    }
}

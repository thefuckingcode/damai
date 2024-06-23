package cn.damai.discover.content.ui.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.bean.FocusEvent;
import cn.damai.discover.content.bean.FollowInfo;
import cn.damai.discover.content.bean.FollowedUser;
import cn.damai.discover.content.ui.ContentDetailActivity;
import cn.damai.discover.content.ui.adapter.ContentFollowUserAdapter;
import cn.damai.discover.main.bean.FollowStateBean;
import cn.damai.discover.main.request.BatchFollowRequest;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$raw;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import tb.br;
import tb.f92;
import tb.gr;
import tb.lk1;
import tb.ym2;

/* compiled from: Taobao */
public class ContentShareViewHolder extends ym2<FollowInfo> implements OnFollowStatusChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private LottieAnimationView e;
    private TextView f;
    private TextView g;
    private View h;
    private ContentFollowUserAdapter i;
    private OnFollowStatusChangeListener j;
    private FollowInfo k;
    private TextView l;
    private View m;
    private String n = "想看";

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<FollowedUser> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, FollowedUser followedUser, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "559346887")) {
                ipChange.ipc$dispatch("559346887", new Object[]{this, view, followedUser, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(FollowedUser followedUser, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-423855310")) {
                ipChange.ipc$dispatch("-423855310", new Object[]{this, followedUser, Integer.valueOf(i)});
            } else if (ContentShareViewHolder.this.a != null && followedUser.isValid()) {
                c.e().x(ContentShareViewHolder.this.getLiveUt().z(i));
                Bundle bundle = new Bundle();
                bundle.putString("userId", followedUser.havanaIdStr);
                DMNav.from(ContentShareViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.Y));
            }
        }
    }

    public ContentShareViewHolder(Context context, OnFollowStatusChangeListener onFollowStatusChangeListener) {
        super(context);
        this.j = onFollowStatusChangeListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(FollowInfo followInfo, boolean z) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182216045")) {
            ipChange.ipc$dispatch("-1182216045", new Object[]{this, followInfo, Boolean.valueOf(z)});
            return;
        }
        c(true);
        this.k = followInfo;
        if (followInfo != null) {
            getLiveUt().M(this.e);
            boolean z2 = followInfo.isFocus;
            this.e.setAnimation(z2 ? R$raw.lottie_favourite_click : R$raw.lottie_favorite_cancel);
            if (z) {
                this.e.playAnimation();
            } else {
                this.e.setProgress(1.0f);
            }
            TextView textView = this.f;
            if (z2) {
                str = "已" + this.n;
            } else {
                str = this.n;
            }
            textView.setText(str);
            this.g.setText("第一个" + this.n + "的人，你的品味很不错呦～");
            List<FollowedUser> list = followInfo.mUsers;
            if (f92.d(list)) {
                this.g.setVisibility(0);
                this.l.setVisibility(8);
                this.h.setVisibility(8);
            } else {
                this.g.setVisibility(8);
                this.l.setVisibility(0);
                this.h.setVisibility(0);
                int i2 = followInfo.focusCount;
                if (i2 > 0) {
                    String g2 = lk1.g((long) i2);
                    if (followInfo.focusCount > 6) {
                        str2 = g2 + "等人" + this.n;
                    } else {
                        str2 = g2 + "人" + this.n;
                    }
                    this.l.setText(str2);
                } else {
                    this.l.setText("他们都" + this.n);
                }
                ContentFollowUserAdapter contentFollowUserAdapter = this.i;
                if (list.size() > 6) {
                    list = list.subList(0, 6);
                }
                contentFollowUserAdapter.f(list);
            }
            followStatusChanged(z2, this.k.focusCount, z);
        }
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1154870382")) {
            return R$layout.live_content_detail_share;
        }
        return ((Integer) ipChange.ipc$dispatch("-1154870382", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540263329")) {
            ipChange.ipc$dispatch("-1540263329", new Object[]{this});
            return;
        }
        this.d = this.b.findViewById(R$id.live_content_detail_follow_layout);
        this.e = (LottieAnimationView) this.b.findViewById(R$id.content_detail_wanna_2_see_icon);
        this.f = (TextView) this.b.findViewById(R$id.live_content_detail_follow_text);
        this.m = this.b.findViewById(R$id.live_wanna_see_top_ui);
        this.g = (TextView) this.b.findViewById(R$id.live_content_detail_tip_1);
        this.l = (TextView) this.b.findViewById(R$id.live_content_detail_tip_focus_count);
        this.h = this.b.findViewById(R$id.live_content_detail_head_layout);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.live_content_detail_head_lv);
        this.i = new ContentFollowUserAdapter(this.a, new a());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.discover.content.ui.viewholder.ContentShareViewHolder.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1204811379")) {
                    ipChange.ipc$dispatch("1204811379", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                rect.set(0, 0, ContentShareViewHolder.this.i.b(), 0);
            }
        });
        recyclerView.setAdapter(this.i);
        this.d.setOnClickListener(this);
    }

    @Override // cn.damai.discover.content.ui.viewholder.OnFollowStatusChangeListener
    public void followStatusChanged(boolean z, int i2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254395556")) {
            ipChange.ipc$dispatch("-1254395556", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)});
            return;
        }
        OnFollowStatusChangeListener onFollowStatusChangeListener = this.j;
        if (onFollowStatusChangeListener != null) {
            onFollowStatusChangeListener.followStatusChanged(z, i2, z2);
        }
    }

    public void g(FollowInfo followInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869421471")) {
            ipChange.ipc$dispatch("-869421471", new Object[]{this, followInfo});
            return;
        }
        h(followInfo, false);
    }

    public boolean i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782170700")) {
            return ((Boolean) ipChange.ipc$dispatch("782170700", new Object[]{this})).booleanValue();
        }
        FollowInfo followInfo = this.k;
        return followInfo != null && followInfo.isFocus;
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1269459066")) {
            ipChange.ipc$dispatch("1269459066", new Object[]{this});
        } else if (this.k != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put(Constants.VIA_ACT_TYPE_NINETEEN, this.k.contentId);
            FollowInfo followInfo = this.k;
            if (!followInfo.isFocus && followInfo.isHasFlowParams()) {
                FollowInfo followInfo2 = this.k;
                hashMap.put(followInfo2.targetType, followInfo2.targetId);
            }
            new BatchFollowRequest(!this.k.isFocus, hashMap).request(new DMMtopRequestListener<FollowStateBean>(FollowStateBean.class) {
                /* class cn.damai.discover.content.ui.viewholder.ContentShareViewHolder.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1115883370")) {
                        ipChange.ipc$dispatch("-1115883370", new Object[]{this, str, str2});
                        return;
                    }
                    ((ContentDetailActivity) ContentShareViewHolder.this.a).stopProgressDialog();
                }

                public void onSuccess(FollowStateBean followStateBean) {
                    Context context;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-359757090")) {
                        ipChange.ipc$dispatch("-359757090", new Object[]{this, followStateBean});
                        return;
                    }
                    ((ContentDetailActivity) ContentShareViewHolder.this.a).stopProgressDialog();
                    boolean isFollowed = followStateBean.isFollowed();
                    if (ContentShareViewHolder.this.k != null) {
                        ContentShareViewHolder.this.k.isFocus = isFollowed;
                        ContentShareViewHolder.this.k.needAnimation = true;
                        ContentShareViewHolder.this.k.updateMyFollowFromFollowList(isFollowed);
                        ContentShareViewHolder contentShareViewHolder = ContentShareViewHolder.this;
                        contentShareViewHolder.h(contentShareViewHolder.k, ContentShareViewHolder.this.k.needAnimation);
                    }
                    if (isFollowed && (context = ContentShareViewHolder.this.a) != null && (context instanceof ContentDetailActivity)) {
                        ((ContentDetailActivity) context).showWantSeeTips();
                    }
                    br.c(FocusEvent.EVENT_NAME_NOTE_FOCUS_CHANGED, FocusEvent.noteFocusChanged());
                }
            });
            ((ContentDetailActivity) this.a).startProgressDialog();
        }
    }

    public void k(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785639727")) {
            ipChange.ipc$dispatch("-785639727", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.n = z ? "想玩" : "想看";
        }
    }

    @Override // tb.ym2
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411226977")) {
            ipChange.ipc$dispatch("1411226977", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (this.k != null && view.getId() == R$id.live_content_detail_follow_layout) {
            j();
            c.e().x(getLiveUt().w());
        }
    }
}

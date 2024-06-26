package cn.damai.user.userprofile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FeedsData;
import cn.damai.user.userprofile.bean.FeedsResponse;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.bean.WatchFeedData;
import cn.damai.user.userprofile.cuser.view.ArticleHolder;
import cn.damai.user.userprofile.cuser.view.CommentViewHolder;
import cn.damai.user.userprofile.cuser.view.FeedsWraperHolder;
import cn.damai.user.userprofile.cuser.view.FollowProjListHolder;
import cn.damai.user.userprofile.cuser.view.FollowUserListHolder;
import cn.damai.user.userprofile.cuser.view.FollowViewHolder;
import cn.damai.user.userprofile.cuser.view.ForwardArticleHolder;
import cn.damai.user.userprofile.cuser.view.ForwardCommentViewHolder;
import cn.damai.user.userprofile.cuser.view.ForwardInfoViewHolder;
import cn.damai.user.userprofile.cuser.view.InfoViewHolder;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.it2;
import tb.js2;
import tb.p21;
import tb.xf2;

/* compiled from: Taobao */
public class FeedsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int A = 45;
    public static int B = 46;
    public static int C = 49;
    public static int D = 20;
    public static int E = 40;
    public static int F = 86;
    public static int G = 97;
    public static int m = 11;
    public static int n = 12;
    public static int o = 13;
    public static int p = 14;
    public static int q = 15;
    public static int r = 22;
    public static int s = 30;
    public static int t = 53;
    public static int u = 56;
    public static int v = 122;
    public static int w = 111;
    public static int x = 153;
    public static int y = 41;
    public static int z = 44;
    private String a = "";
    private Context b;
    private List<FeedMergeDataDO> c;
    private View d;
    boolean e;
    String f;
    String g;
    boolean h = false;
    int i;
    String j;
    boolean k = false;
    String l;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        a(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-779194969")) {
                ipChange.ipc$dispatch("-779194969", new Object[]{this, view});
                return;
            }
            FeedsAdapter.this.f(this.a.dynamicData.get(0).url);
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        b(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1332095400")) {
                ipChange.ipc$dispatch("1332095400", new Object[]{this, view});
                return;
            }
            WatchFeedData watchFeedData = this.a.watchData.get(0);
            String str = watchFeedData.url;
            Bundle bundle = new Bundle();
            bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
            DMNav.from(FeedsAdapter.this.b).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        c(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-851581527")) {
                ipChange.ipc$dispatch("-851581527", new Object[]{this, view});
                return;
            }
            FeedsAdapter.this.f(this.a.articleData.get(0).url);
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    public FeedsAdapter(Context context, FeedsResponse feedsResponse, View view, String str) {
        this.b = context;
        this.d = view;
        this.j = str;
        if (feedsResponse != null) {
            FeedsData feedsData = feedsResponse.data;
        }
    }

    private RecyclerView.ViewHolder d(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "376876304")) {
            return e(viewGroup, i2);
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("376876304", new Object[]{this, viewGroup, Integer.valueOf(i2)});
    }

    private RecyclerView.ViewHolder e(ViewGroup viewGroup, int i2) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1380863312")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1380863312", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        Log.d("getViewHolder", "viewtype: " + i2);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R$layout.user_feeds_item_wrapper, viewGroup, false);
        if (i2 == r || i2 == t || i2 == u || i2 == F || i2 == G) {
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_item, (ViewGroup) null));
            return new CommentViewHolder(linearLayout, (Activity) this.b, this.j);
        }
        int i5 = A;
        if (i2 == i5 || i2 == (i3 = B)) {
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_like_item, (ViewGroup) null));
            return new FollowViewHolder(linearLayout, (Activity) this.b, this.j);
        }
        int i6 = y;
        if ((i2 >= i6 && i2 <= z) || i2 == (i4 = C)) {
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_follow_item, (ViewGroup) null));
            return new FollowViewHolder(linearLayout, (Activity) this.b, this.j);
        } else if (i2 == n) {
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_zhuanfa, (ViewGroup) null));
            return new ForwardInfoViewHolder(linearLayout, (Activity) this.b, this.j);
        } else if (i2 == o || i2 == q) {
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_zhuanfa_comment, (ViewGroup) null));
            return new ForwardCommentViewHolder(linearLayout, (Activity) this.b, this.j);
        } else {
            int i7 = D;
            if ((i2 >= i6 + i7 && i2 <= z + i7) || i2 == i4 + i7) {
                linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_feeds_cell_follow_user, (ViewGroup) null));
                return new FollowUserListHolder(linearLayout, (Activity) this.b, this.j);
            } else if (i2 == i5 + i7 || i2 == i3 + i7) {
                linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_feeds_cell_follow_user, (ViewGroup) null));
                return new FollowProjListHolder(linearLayout, (Activity) this.b, this.j);
            } else if (i2 == s) {
                linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_article, (ViewGroup) null));
                return new ArticleHolder(linearLayout, (Activity) this.b, this.j);
            } else if (i2 == p) {
                linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_zhuanfa_article_item, (ViewGroup) null));
                return new ForwardArticleHolder(linearLayout, (Activity) this.b, this.j);
            } else if (i2 == w) {
                InfoViewHolder infoViewHolder = new InfoViewHolder(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_quanzi, (ViewGroup) null), (Activity) this.b, this.j);
                infoViewHolder.k = true;
                boolean z2 = this.h;
                if (z2) {
                    infoViewHolder.u(z2, this.i);
                }
                return infoViewHolder;
            } else if (i2 == v || i2 == x) {
                InfoViewHolder infoViewHolder2 = new InfoViewHolder(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_quanzi_comment, (ViewGroup) null), (Activity) this.b, this.j);
                infoViewHolder2.k = true;
                boolean z3 = this.h;
                if (z3) {
                    infoViewHolder2.u(z3, this.i);
                }
                return infoViewHolder2;
            } else {
                linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item, (ViewGroup) linearLayout, false));
                InfoViewHolder infoViewHolder3 = new InfoViewHolder(linearLayout, (Activity) this.b, this.j);
                infoViewHolder3.k = false;
                return infoViewHolder3;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659445054")) {
            ipChange.ipc$dispatch("-1659445054", new Object[]{this, str});
        } else if (!xf2.j(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(a.c.d));
        } else {
            Log.d("netlog", "url is null");
        }
    }

    private void g(RecyclerView.ViewHolder viewHolder, int i2, FeedMergeDataDO feedMergeDataDO) {
        List<WatchFeedData> list;
        List<DynamicFeedData> list2;
        List<ArticleFeedData> list3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654653441")) {
            ipChange.ipc$dispatch("-1654653441", new Object[]{this, viewHolder, Integer.valueOf(i2), feedMergeDataDO});
        } else if (getItemViewType(i2) == m || getItemViewType(i2) == n || getItemViewType(i2) == o || getItemViewType(i2) == w || getItemViewType(i2) == t || getItemViewType(i2) == u || getItemViewType(i2) == x || getItemViewType(i2) == q) {
            if (feedMergeDataDO != null && (list2 = feedMergeDataDO.dynamicData) != null && list2.size() > 0) {
                viewHolder.itemView.setOnClickListener(new a(feedMergeDataDO, viewHolder));
            } else if (feedMergeDataDO != null && (list = feedMergeDataDO.watchData) != null && list.size() > 0) {
                viewHolder.itemView.setOnClickListener(new b(feedMergeDataDO, viewHolder));
            }
        } else if (getItemViewType(i2) == s && feedMergeDataDO != null && (list3 = feedMergeDataDO.articleData) != null && list3.size() > 0) {
            viewHolder.itemView.setOnClickListener(new c(feedMergeDataDO, viewHolder));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(RecyclerView.ViewHolder viewHolder, FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265375923")) {
            ipChange.ipc$dispatch("265375923", new Object[]{this, viewHolder, feedMergeDataDO});
        } else if (!this.k) {
            HashMap hashMap = new HashMap();
            if (feedMergeDataDO != null) {
                hashMap.put("content_id", it2.b(feedMergeDataDO));
                hashMap.put("content_type", feedMergeDataDO.bizType);
                List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
                if (!(list == null || list.get(0) == null)) {
                    hashMap.put("circle_id", feedMergeDataDO.dynamicData.get(0).circleId);
                }
            }
            Context context = this.b;
            String str = this.j;
            it2.e(context, str, js2.DYNAMIC, "dynamic_" + viewHolder.itemView.getTag(), true, new HashMap(), hashMap);
        } else {
            HashMap hashMap2 = new HashMap();
            if (feedMergeDataDO != null) {
                hashMap2.put("content_id", it2.b(feedMergeDataDO));
                hashMap2.put("content_type", feedMergeDataDO.bizType);
                hashMap2.put("circle_id", this.l);
            }
            Context context2 = this.b;
            String str2 = this.j;
            it2.e(context2, str2, "circle", "circle_" + viewHolder.itemView.getTag(), true, new HashMap(), hashMap2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "659184982")) {
            return ((Integer) ipChange.ipc$dispatch("659184982", new Object[]{this})).intValue();
        }
        List<FeedMergeDataDO> list = this.c;
        if (list != null) {
            i2 = list.size();
        }
        Log.d("getItemCount", "getItemCount : " + i2);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676545283")) {
            return ((Integer) ipChange.ipc$dispatch("-676545283", new Object[]{this, Integer.valueOf(i2)})).intValue();
        }
        Log.e("getItemViewType", " -------- getItemViewType: " + i2);
        List<FeedMergeDataDO> list = this.c;
        if (list == null || i2 < 0) {
            return 0;
        }
        FeedMergeDataDO feedMergeDataDO = list.get(i2);
        if (feedMergeDataDO == null || xf2.j(feedMergeDataDO.bizType)) {
            return i2;
        }
        if (feedMergeDataDO.bizType.startsWith("6.") || feedMergeDataDO.bizType.startsWith("7.")) {
            if (this.k) {
                return w;
            }
            return m;
        } else if ("4".equals(feedMergeDataDO.bizType)) {
            List<FollowFeedData> list2 = feedMergeDataDO.followData;
            if (list2 == null || list2.size() <= 0) {
                return i2;
            }
            FollowFeedData followFeedData = feedMergeDataDO.followData.get(0);
            if (feedMergeDataDO.followData.size() == 1) {
                i3 = E;
                i4 = followFeedData.subBizType;
            } else {
                i3 = E + followFeedData.subBizType;
                i4 = D;
            }
            return i3 + i4;
        } else {
            int parseFloat = (int) (Float.parseFloat(feedMergeDataDO.bizType) * 10.0f);
            return this.k ? parseFloat + 100 : parseFloat;
        }
    }

    public void h(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731325649")) {
            ipChange.ipc$dispatch("731325649", new Object[]{this, Boolean.valueOf(z2)});
        }
    }

    public void i(boolean z2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771341225")) {
            ipChange.ipc$dispatch("-771341225", new Object[]{this, Boolean.valueOf(z2), Integer.valueOf(i2)});
            return;
        }
        this.h = true;
        this.i = i2;
    }

    public void j(FeedsResponse feedsResponse, boolean z2, boolean z3, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625594766")) {
            ipChange.ipc$dispatch("-625594766", new Object[]{this, feedsResponse, Boolean.valueOf(z2), Boolean.valueOf(z3), str, str2});
            return;
        }
        this.k = z2;
        this.e = z3;
        this.f = str;
        this.g = str2;
        FeedsData feedsData = feedsResponse.data;
        if (feedsData != null) {
            this.l = feedsData.circleId;
            if (feedsData.feedMergeDataList == null) {
                feedsData.feedMergeDataList = new ArrayList();
            }
            this.c = feedsResponse.data.feedMergeDataList;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869973021")) {
            ipChange.ipc$dispatch("-1869973021", new Object[]{this, viewHolder, Integer.valueOf(i2)});
            return;
        }
        List<FeedMergeDataDO> list = this.c;
        if (list != null) {
            FeedMergeDataDO feedMergeDataDO = i2 < list.size() ? this.c.get(i2) : null;
            FeedsWraperHolder feedsWraperHolder = (FeedsWraperHolder) viewHolder;
            feedsWraperHolder.z(false, "");
            feedsWraperHolder.t(this.d);
            if (i2 == 0 && feedMergeDataDO != null) {
                feedsWraperHolder.z(true, feedMergeDataDO.year);
                this.a = feedMergeDataDO.year;
            } else if (!this.k && feedMergeDataDO != null && !xf2.j(feedMergeDataDO.year) && i2 - 1 >= 0 && this.c.get(i3) != null) {
                this.a = this.c.get(i3).year;
                Log.d("year", "lastyear: " + this.a + " , yearxx : " + feedMergeDataDO.year);
                if ("".equals(this.a) || !feedMergeDataDO.year.equals(this.a)) {
                    feedsWraperHolder.z(true, feedMergeDataDO.year);
                    Log.d("year", "lastyearxx: " + this.a);
                } else {
                    feedsWraperHolder.z(false, "");
                }
            }
            if (feedMergeDataDO != null) {
                if ((viewHolder instanceof FollowViewHolder) || (viewHolder instanceof FollowProjListHolder) || (viewHolder instanceof FollowUserListHolder)) {
                    feedMergeDataDO.enablePraise = false;
                    feedMergeDataDO.enableComment = false;
                    feedMergeDataDO.enableForward = false;
                } else {
                    feedMergeDataDO.enablePraise = true;
                    feedMergeDataDO.enableComment = true;
                    feedMergeDataDO.enableForward = true;
                }
            }
            feedsWraperHolder.y(feedMergeDataDO, this.e, this.l, this.f, this.g);
            viewHolder.itemView.setTag(Integer.valueOf(i2));
            Log.e("titleRatingBar", "instanceof " + viewHolder);
            if (viewHolder instanceof FeedsWraperHolder) {
                FeedsWraperHolder feedsWraperHolder2 = (FeedsWraperHolder) viewHolder;
                if (feedMergeDataDO != null) {
                    feedsWraperHolder2.x(feedMergeDataDO);
                }
            }
            g(viewHolder, i2, feedMergeDataDO);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737826675")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("737826675", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        FeedsWraperHolder feedsWraperHolder = (FeedsWraperHolder) d(viewGroup, i2);
        feedsWraperHolder.setType(i2);
        return feedsWraperHolder;
    }
}

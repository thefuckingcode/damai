package cn.damai.user.userprofile.cuser.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.view.ShareExtendView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.ClickGrayImageView;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsAdapter;
import cn.damai.user.userprofile.FeedsViewModel;
import cn.damai.user.userprofile.UserIndexActivity;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.CommentFeedData;
import cn.damai.user.userprofile.bean.DeleteRequest;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.InteractionFeedData;
import cn.damai.user.userprofile.bean.PraiseRequest;
import cn.damai.user.userprofile.bean.VideoInfo;
import cn.damai.user.userprofile.bean.WatchFeedData;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tb.cq;
import tb.d20;
import tb.gr;
import tb.it2;
import tb.js2;
import tb.nd2;
import tb.p21;
import tb.q92;
import tb.tb2;
import tb.v50;
import tb.wz1;
import tb.xf2;

/* compiled from: Taobao */
public class FeedsWraperHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQ_CDOE_EDIT = 10002;
    public static final int REQ_CDOE_PUGLISH = 10001;
    public View a;
    public TextView b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public DMRatingBar h;
    public DMRatingBar i;
    public TextView j;
    public boolean k = false;
    private Activity l;
    private View m;
    private int n;
    private boolean o = false;
    boolean p = false;
    String q;
    String r;
    String s;
    boolean t;
    String u;
    public NineGridlayout v;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2001715432")) {
                ipChange.ipc$dispatch("2001715432", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, this.a);
            DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        b(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824275196")) {
                ipChange.ipc$dispatch("1824275196", new Object[]{this, view});
                return;
            }
            FeedsWraperHolder.this.w(this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a(c cVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "952676453")) {
                    ipChange.ipc$dispatch("952676453", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                ShareManager.E().C();
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1922257476")) {
                    ipChange.ipc$dispatch("1922257476", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                c cVar = c.this;
                FeedsWraperHolder.this.p(cVar.a);
                dialogInterface.dismiss();
                ShareManager.E().C();
            }
        }

        c(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-359401731")) {
                ipChange.ipc$dispatch("-359401731", new Object[]{this, view});
                return;
            }
            new DMDialog(FeedsWraperHolder.this.l).v("注意").q("确定要删除该数据吗?").n("确定", new b()).i("取消", new a(this)).show();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        d(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1751888638")) {
                ipChange.ipc$dispatch("1751888638", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            try {
                if (FeedsWraperHolder.this.i(this.a) != null) {
                    bundle.putString("targetId", FeedsWraperHolder.this.i(this.a));
                }
                if ("2.20".equals(this.a.bizType)) {
                    i = 20;
                } else if ("2.22".equals(this.a.bizType)) {
                    i = 22;
                } else if ("1.1".equals(this.a.bizType)) {
                    i = 23;
                } else {
                    if (!"1.2".equals(this.a.bizType) && !"1.3".equals(this.a.bizType)) {
                        if (!"1.5".equals(this.a.bizType)) {
                            i = "5.32".equals(this.a.bizType) ? 32 : 0;
                        }
                    }
                    i = 24;
                }
                bundle.putInt("targetType", i);
                bundle.putInt("type", 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).toUri(NavUri.b("report"));
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        e(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-431788289")) {
                ipChange.ipc$dispatch("-431788289", new Object[]{this, view});
                return;
            }
            try {
                List<WatchFeedData> list = this.a.watchData;
                if (list != null && list.size() > 0) {
                    WatchFeedData watchFeedData = this.a.watchData.get(0);
                    Bundle bundle = new Bundle();
                    bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EDIT);
                    bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
                    bundle.putInt(p21.ISSUE_PARAM_GRADES, watchFeedData.getValue());
                    bundle.putString("text", watchFeedData.comment);
                    bundle.putStringArrayList("images", (ArrayList) watchFeedData.imgs);
                    bundle.putString("circleId", watchFeedData.circleId);
                    bundle.putString("circleName", watchFeedData.circleName);
                    DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).forResult(10002).toUri(NavUri.b("issue"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                ShareManager.E().C();
                throw th;
            }
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        f(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-504174847")) {
                ipChange.ipc$dispatch("-504174847", new Object[]{this, view});
                return;
            }
            Activity activity = FeedsWraperHolder.this.getActivity();
            DMNav.from(activity).withExtras(FeedsWraperHolder.this.k(this.a)).needLogin().forResult(10001).toUri(NavUri.b("issue"));
            if (this.a != null) {
                FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                if (feedsWraperHolder.p) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", "大家说");
                    hashMap.put("evaluate_id", FeedsWraperHolder.this.i(this.a));
                    hashMap.put("content_type", this.a.bizType);
                    hashMap.put("content_id", FeedsWraperHolder.this.i(this.a));
                    cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                    cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "forward_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.TRUE));
                    return;
                }
                String str = "1";
                if (!feedsWraperHolder.k) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("content_id", FeedsWraperHolder.this.i(this.a));
                    hashMap2.put("content_type", this.a.bizType);
                    if (!FeedsWraperHolder.this.t) {
                        str = "0";
                    }
                    hashMap2.put(wz1.VIEW_TYPE, str);
                    String str2 = FeedsWraperHolder.this.q;
                    it2.e(activity, str2, js2.DYNAMIC, "forward_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap2);
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("content_id", FeedsWraperHolder.this.i(this.a));
                hashMap3.put("content_type", this.a.bizType);
                hashMap3.put("circle_id", FeedsWraperHolder.this.u);
                if (!FeedsWraperHolder.this.t) {
                    str = "0";
                }
                hashMap3.put(wz1.VIEW_TYPE, str);
                String str3 = FeedsWraperHolder.this.q;
                it2.e(activity, str3, "circle", "forward_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap3);
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        g(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        public void onClick(View view) {
            CommentFeedData commentFeedData;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1607115522")) {
                ipChange.ipc$dispatch("1607115522", new Object[]{this, view});
                return;
            }
            FeedMergeDataDO feedMergeDataDO = this.a;
            if (feedMergeDataDO != null) {
                List<CommentFeedData> list = feedMergeDataDO.commentData;
                if (!(list == null || list.size() <= 0 || (commentFeedData = this.a.commentData.get(0)) == null)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, commentFeedData.bizId);
                    DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
                }
                List<WatchFeedData> list2 = this.a.watchData;
                if (list2 != null && list2.size() > 0) {
                    WatchFeedData watchFeedData = this.a.watchData.get(0);
                    if (watchFeedData != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(p21.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
                        DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle2).toUri(NavUri.b("commentdetail"));
                    }
                } else if (!xf2.j(FeedsWraperHolder.this.m(this.a))) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("url", FeedsWraperHolder.this.m(this.a) + "#commentlist");
                    DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle3).toUri(NavUri.b(a.c.d));
                }
                FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                if (feedsWraperHolder.p) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", "大家说");
                    hashMap.put("evaluate_id", FeedsWraperHolder.this.i(this.a));
                    hashMap.put("content_type", this.a.bizType);
                    hashMap.put("content_id", FeedsWraperHolder.this.i(this.a));
                    cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                    cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "comment_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.TRUE));
                    return;
                }
                String str = "1";
                if (!feedsWraperHolder.k) {
                    HashMap hashMap2 = new HashMap();
                    FeedMergeDataDO feedMergeDataDO2 = this.a;
                    if (feedMergeDataDO2 != null) {
                        hashMap2.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO2));
                        hashMap2.put("content_type", this.a.bizType);
                        if (!FeedsWraperHolder.this.t) {
                            str = "0";
                        }
                        hashMap2.put(wz1.VIEW_TYPE, str);
                    }
                    Activity activity = FeedsWraperHolder.this.l;
                    String str2 = FeedsWraperHolder.this.q;
                    it2.e(activity, str2, js2.DYNAMIC, "comment_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap2);
                    return;
                }
                HashMap hashMap3 = new HashMap();
                FeedMergeDataDO feedMergeDataDO3 = this.a;
                if (feedMergeDataDO3 != null) {
                    hashMap3.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO3));
                    hashMap3.put("content_type", this.a.bizType);
                    if (!FeedsWraperHolder.this.t) {
                        str = "0";
                    }
                    hashMap3.put(wz1.VIEW_TYPE, str);
                }
                hashMap3.put("circle_id", FeedsWraperHolder.this.u);
                Activity activity2 = FeedsWraperHolder.this.l;
                String str3 = FeedsWraperHolder.this.q;
                it2.e(activity2, str3, "circle", "comment_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap3);
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ VideoInfo b;
        final /* synthetic */ ArrayList c;

        h(FeedsWraperHolder feedsWraperHolder, Activity activity, VideoInfo videoInfo, ArrayList arrayList) {
            this.a = activity;
            this.b = videoInfo;
            this.c = arrayList;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1534728964")) {
                ipChange.ipc$dispatch("1534728964", new Object[]{this, view});
                return;
            }
            if (view instanceof ClickGrayImageView) {
                ClickGrayImageView clickGrayImageView = (ClickGrayImageView) view;
                if (clickGrayImageView.getTag() != null) {
                    try {
                        i = Integer.parseInt(clickGrayImageView.getTag() + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Activity activity = this.a;
            if (activity != null && !activity.isFinishing()) {
                Bundle bundle = new Bundle();
                if (this.b != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    cn.damai.commonbusiness.imagebrowse.bean.VideoInfo videoInfo = new cn.damai.commonbusiness.imagebrowse.bean.VideoInfo();
                    videoInfo.setPicUrl(this.b.coverUrl);
                    videoInfo.setVideoUrl(this.b.url);
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                    arrayList.add(videoInfo);
                    bundle.putParcelableArrayList("video_info", arrayList);
                }
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                ArrayList arrayList3 = this.c;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        PicInfo picInfo = new PicInfo();
                        picInfo.setPicUrl((String) it.next());
                        arrayList2.add(picInfo);
                    }
                }
                bundle.putParcelableArrayList("pic_info", arrayList2);
                bundle.putInt("position", i);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("videobrowse"));
            }
        }
    }

    /* compiled from: Taobao */
    public class i {
        private static transient /* synthetic */ IpChange $ipChange;
        private CommentFeedData a;
        private String b;
        private String c;
        private String d;
        private String e;

        public i(CommentFeedData commentFeedData) {
            this.a = commentFeedData;
        }

        public String a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-682027553")) {
                return this.e;
            }
            return (String) ipChange.ipc$dispatch("-682027553", new Object[]{this});
        }

        public String b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "658627229")) {
                return this.c;
            }
            return (String) ipChange.ipc$dispatch("658627229", new Object[]{this});
        }

        public String c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1480446900")) {
                return this.b;
            }
            return (String) ipChange.ipc$dispatch("1480446900", new Object[]{this});
        }

        public String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "826652043")) {
                return this.d;
            }
            return (String) ipChange.ipc$dispatch("826652043", new Object[]{this});
        }

        public i e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-512677418")) {
                return (i) ipChange.ipc$dispatch("-512677418", new Object[]{this});
            }
            CommentFeedData commentFeedData = this.a;
            this.c = commentFeedData.comment;
            this.d = commentFeedData.url;
            if (!xf2.j(commentFeedData.userNick)) {
                this.b = this.a.userNick + "@大麦";
            } else {
                this.b = FeedsWraperHolder.this.r + "@大麦";
            }
            if (!xf2.j(this.a.targetImg)) {
                this.e = this.a.targetImg;
            } else if (!xf2.j(this.a.userImg)) {
                this.e = this.a.userImg;
            } else {
                this.e = FeedsWraperHolder.this.s;
            }
            return this;
        }
    }

    public FeedsWraperHolder(View view, Activity activity, String str) {
        super(view);
        this.l = activity;
        this.q = str;
        this.a = view.findViewById(R$id.feeds_item_wrapper_ll);
        this.b = (TextView) view.findViewById(R$id.feeds_item_wrapper_year);
        this.c = view.findViewById(R$id.feeds_interact_parent);
        this.d = (TextView) view.findViewById(R$id.user_feeds_commenttv);
        this.e = (TextView) view.findViewById(R$id.user_feeds_zantv);
        this.g = (TextView) view.findViewById(R$id.feeds_item_more);
        this.f = (TextView) view.findViewById(R$id.user_feeds_zanicon);
        this.h = (DMRatingBar) view.findViewById(R$id.bar_rating);
        this.i = (DMRatingBar) view.findViewById(R$id.bar_rating_title);
        this.j = (TextView) view.findViewById(R$id.bar_rating_title_desc);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String i(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488426101")) {
            return (String) ipChange.ipc$dispatch("488426101", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).bizId;
        }
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).bizId;
        }
        List<ArticleFeedData> list3 = feedMergeDataDO.articleData;
        if (list3 != null && list3.get(0) != null) {
            return feedMergeDataDO.articleData.get(0).bizId;
        }
        List<WatchFeedData> list4 = feedMergeDataDO.watchData;
        if (list4 == null || list4.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).bizId;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String m(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970461162")) {
            return (String) ipChange.ipc$dispatch("-1970461162", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).url;
        }
        List<ArticleFeedData> list2 = feedMergeDataDO.articleData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.articleData.get(0).url;
        }
        List<CommentFeedData> list3 = feedMergeDataDO.commentData;
        if (list3 != null && list3.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).url;
        }
        List<WatchFeedData> list4 = feedMergeDataDO.watchData;
        if (list4 == null || list4.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).url;
    }

    private String n(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352519051")) {
            return (String) ipChange.ipc$dispatch("352519051", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).havanaIdStr;
        }
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).havanaIdStr;
        }
        List<WatchFeedData> list3 = feedMergeDataDO.watchData;
        if (list3 == null || list3.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).havanaIdStr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295635414")) {
            ipChange.ipc$dispatch("1295635414", new Object[]{this, feedMergeDataDO});
            return;
        }
        DeleteRequest deleteRequest = new DeleteRequest();
        List<ArticleFeedData> list = feedMergeDataDO.articleData;
        if (list == null || list.get(0) == null) {
            deleteRequest.commentId = i(feedMergeDataDO);
            deleteRequest.articleId = "";
        } else {
            deleteRequest.articleId = feedMergeDataDO.articleData.get(0).bizId;
            deleteRequest.commentId = "";
        }
        deleteRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) {
            /* class cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374628710")) {
                    ipChange.ipc$dispatch("1374628710", new Object[]{this, str, str2});
                    return;
                }
                Log.d("netlog", "delect comment : " + str);
            }

            public void onSuccess(JSONObject jSONObject) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "282056487")) {
                    ipChange.ipc$dispatch("282056487", new Object[]{this, jSONObject});
                } else if (jSONObject != null && FeedsWraperHolder.this.l != null) {
                    ((UserIndexActivity) FeedsWraperHolder.this.l).refresh();
                }
            }
        });
    }

    private void q(final FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918563577")) {
            ipChange.ipc$dispatch("918563577", new Object[]{this, feedMergeDataDO});
            return;
        }
        if (!feedMergeDataDO.enableForward) {
            this.itemView.findViewById(R$id.user_feeds_zhuanfaicon).setVisibility(8);
            this.itemView.findViewById(R$id.user_feeds_zhuanfatv).setVisibility(8);
        } else {
            new f(feedMergeDataDO);
        }
        if (!feedMergeDataDO.enableComment) {
            this.itemView.findViewById(R$id.user_feeds_commenticon).setVisibility(8);
            this.d.setVisibility(8);
        } else {
            View view = this.itemView;
            int i2 = R$id.user_feeds_commenticon;
            view.findViewById(i2).setVisibility(0);
            this.d.setVisibility(0);
            if (getItemViewType() == FeedsAdapter.G) {
                this.d.setVisibility(8);
                this.itemView.findViewById(i2).setVisibility(8);
            }
            if (feedMergeDataDO.commentNum == 0) {
                this.d.setText("回复");
            } else {
                TextView textView = this.d;
                textView.setText(feedMergeDataDO.commentNum + "");
            }
            g gVar = new g(feedMergeDataDO);
            this.itemView.findViewById(i2).setOnClickListener(gVar);
            this.d.setOnClickListener(gVar);
        }
        if (!feedMergeDataDO.enablePraise) {
            this.itemView.findViewById(R$id.user_feeds_zanicon).setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        View view2 = this.itemView;
        int i3 = R$id.user_feeds_zanicon;
        view2.findViewById(i3).setVisibility(0);
        this.e.setVisibility(0);
        if (feedMergeDataDO.praiseNum == 0) {
            this.e.setText("赞");
        } else {
            TextView textView2 = this.e;
            textView2.setText(feedMergeDataDO.praiseNum + "");
        }
        if (feedMergeDataDO.hasPraised) {
            this.f.setTextColor(this.l.getResources().getColor(R$color.color_FF1268));
            this.f.setText(this.l.getResources().getString(R$string.iconfont_dianzanmian_));
        } else {
            this.f.setTextColor(this.l.getResources().getColor(R$color.color_nozan));
            this.f.setText(this.l.getResources().getString(R$string.iconfont_dianzan_));
        }
        this.o = feedMergeDataDO.hasPraised;
        AnonymousClass8 r0 = new View.OnClickListener() {
            /* class cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-576561405")) {
                    ipChange.ipc$dispatch("-576561405", new Object[]{this, view});
                } else if (FeedsWraperHolder.this.i(feedMergeDataDO) != null) {
                    if (!LoginManager.k().q()) {
                        DMNav.from(FeedsWraperHolder.this.l).toUri(NavUri.b("login"));
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.3f, 1.0f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.3f, 1.0f);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(1000L);
                    animatorSet.setInterpolator(new nd2(0.3f));
                    animatorSet.playTogether(ofFloat3, ofFloat, ofFloat2);
                    animatorSet.start();
                    PraiseRequest praiseRequest = new PraiseRequest();
                    praiseRequest.targetId = FeedsWraperHolder.this.i(feedMergeDataDO);
                    String str = "1";
                    praiseRequest.targetType = str;
                    if (feedMergeDataDO.articleData != null) {
                        praiseRequest.targetType = "2";
                    }
                    praiseRequest.operate = FeedsWraperHolder.this.o ? str : "0";
                    if (feedMergeDataDO.praiseNum != 0 || !FeedsWraperHolder.this.o) {
                        praiseRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) {
                            /* class cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.AnonymousClass8.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                            public void onFail(String str, String str2) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "141697462")) {
                                    ipChange.ipc$dispatch("141697462", new Object[]{this, str, str2});
                                    return;
                                }
                                FeedsWraperHolder.this.o = false;
                            }

                            public void onSuccess(JSONObject jSONObject) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-841628297")) {
                                    ipChange.ipc$dispatch("-841628297", new Object[]{this, jSONObject});
                                } else if (jSONObject != null) {
                                    if (FeedsWraperHolder.this.o) {
                                        AnonymousClass8 r6 = AnonymousClass8.this;
                                        FeedMergeDataDO feedMergeDataDO = feedMergeDataDO;
                                        int i = feedMergeDataDO.praiseNum - 1;
                                        feedMergeDataDO.praiseNum = i;
                                        if (i < 0) {
                                            feedMergeDataDO.praiseNum = 0;
                                        }
                                        if (feedMergeDataDO.praiseNum == 0) {
                                            FeedsWraperHolder.this.e.setText("赞");
                                        } else {
                                            FeedsWraperHolder.this.e.setText(feedMergeDataDO.praiseNum + "");
                                        }
                                        FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                                        TextView textView = feedsWraperHolder.e;
                                        Resources resources = feedsWraperHolder.l.getResources();
                                        int i2 = R$color.color_nozan;
                                        textView.setTextColor(resources.getColor(i2));
                                        FeedsWraperHolder feedsWraperHolder2 = FeedsWraperHolder.this;
                                        feedsWraperHolder2.f.setTextColor(feedsWraperHolder2.l.getResources().getColor(i2));
                                        FeedsWraperHolder feedsWraperHolder3 = FeedsWraperHolder.this;
                                        feedsWraperHolder3.f.setText(feedsWraperHolder3.l.getResources().getString(R$string.iconfont_dianzan_));
                                    } else {
                                        AnonymousClass8 r62 = AnonymousClass8.this;
                                        feedMergeDataDO.praiseNum++;
                                        FeedsWraperHolder.this.e.setText(feedMergeDataDO.praiseNum + "");
                                        FeedsWraperHolder feedsWraperHolder4 = FeedsWraperHolder.this;
                                        TextView textView2 = feedsWraperHolder4.e;
                                        Resources resources2 = feedsWraperHolder4.l.getResources();
                                        int i3 = R$color.color_FF1268;
                                        textView2.setTextColor(resources2.getColor(i3));
                                        FeedsWraperHolder feedsWraperHolder5 = FeedsWraperHolder.this;
                                        feedsWraperHolder5.f.setTextColor(feedsWraperHolder5.l.getResources().getColor(i3));
                                        FeedsWraperHolder feedsWraperHolder6 = FeedsWraperHolder.this;
                                        feedsWraperHolder6.f.setText(feedsWraperHolder6.l.getResources().getString(R$string.iconfont_dianzanmian_));
                                    }
                                    FeedsWraperHolder feedsWraperHolder7 = FeedsWraperHolder.this;
                                    feedsWraperHolder7.o = !feedsWraperHolder7.o;
                                }
                            }
                        });
                        FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                        if (feedsWraperHolder.p) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("titlelabel", "大家说");
                            hashMap.put("evaluate_id", FeedsWraperHolder.this.i(feedMergeDataDO));
                            hashMap.put("content_type", feedMergeDataDO.bizType);
                            hashMap.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO));
                            cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                            cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "likes_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.FALSE));
                        } else if (!feedsWraperHolder.k) {
                            HashMap hashMap2 = new HashMap();
                            FeedMergeDataDO feedMergeDataDO = feedMergeDataDO;
                            if (feedMergeDataDO != null) {
                                hashMap2.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO));
                                hashMap2.put("content_type", feedMergeDataDO.bizType);
                                if (!FeedsWraperHolder.this.t) {
                                    str = "0";
                                }
                                hashMap2.put(wz1.VIEW_TYPE, str);
                            }
                            Activity activity = FeedsWraperHolder.this.l;
                            String str2 = FeedsWraperHolder.this.q;
                            it2.e(activity, str2, js2.DYNAMIC, "dynamic_likes_" + FeedsWraperHolder.this.itemView.getTag(), false, null, hashMap2);
                        } else {
                            HashMap hashMap3 = new HashMap();
                            FeedMergeDataDO feedMergeDataDO2 = feedMergeDataDO;
                            if (feedMergeDataDO2 != null) {
                                hashMap3.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO2));
                                hashMap3.put("content_type", feedMergeDataDO.bizType);
                                if (!FeedsWraperHolder.this.t) {
                                    str = "0";
                                }
                                hashMap3.put(wz1.VIEW_TYPE, str);
                            }
                            hashMap3.put("circle_id", FeedsWraperHolder.this.u);
                            Activity activity2 = FeedsWraperHolder.this.l;
                            String str3 = FeedsWraperHolder.this.q;
                            it2.e(activity2, str3, "circle", "circle_likes_" + FeedsWraperHolder.this.itemView.getTag(), false, null, hashMap3);
                        }
                    }
                }
            }
        };
        this.itemView.findViewById(i3).setOnClickListener(r0);
        this.e.setOnClickListener(r0);
    }

    private void s(FeedMergeDataDO feedMergeDataDO, DMRatingBar dMRatingBar) {
        List<WatchFeedData> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397726620")) {
            ipChange.ipc$dispatch("-397726620", new Object[]{this, feedMergeDataDO, dMRatingBar});
        } else if (dMRatingBar != null) {
            int i2 = this.n;
            if ((i2 == FeedsAdapter.t || i2 == FeedsAdapter.u || i2 == FeedsAdapter.x) && (list = feedMergeDataDO.watchData) != null && list.size() > 0 && feedMergeDataDO.watchData.get(0) != null) {
                float value = (float) feedMergeDataDO.watchData.get(0).getValue();
                Log.e("titleRatingBar", "============  mark: " + value);
                if (value > 0.0f) {
                    dMRatingBar.setVisibility(0);
                    dMRatingBar.setStarMark(value / 2.0f);
                    TextView textView = this.j;
                    if (textView != null) {
                        textView.setVisibility(0);
                        this.j.setText(feedMergeDataDO.watchData.get(0).getValueDesc());
                        return;
                    }
                    return;
                }
                Log.e("titleRatingBar", "============  mark:  mark gone 11111");
                dMRatingBar.setVisibility(8);
                TextView textView2 = this.j;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            Log.e("titleRatingBar", "============  mark:  mark gone 11111  mark gone 2222");
            dMRatingBar.setVisibility(8);
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    private void w(FeedMergeDataDO feedMergeDataDO) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267786319")) {
            ipChange.ipc$dispatch("1267786319", new Object[]{this, feedMergeDataDO});
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.l);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        ShareExtendView d2 = q92.d(this.l, new c(feedMergeDataDO));
        linearLayout.addView(d2, layoutParams);
        if ((!feedMergeDataDO.bizType.startsWith("4") || !feedMergeDataDO.bizType.startsWith("3")) && ((!this.t || this.k) && !d20.E().equals(n(feedMergeDataDO)))) {
            linearLayout.addView(q92.g(this.l, new d(feedMergeDataDO)));
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        String str8 = "";
        if (list == null || list.size() <= 0) {
            List<CommentFeedData> list2 = feedMergeDataDO.commentData;
            if (list2 == null || list2.size() <= 0) {
                List<ArticleFeedData> list3 = feedMergeDataDO.articleData;
                if (list3 == null || list3.size() <= 0) {
                    List<WatchFeedData> list4 = feedMergeDataDO.watchData;
                    if (list4 == null || list4.size() <= 0) {
                        str3 = str8;
                        str2 = str3;
                        str = str2;
                        Bundle bundle = new Bundle();
                        bundle.putString("title", str8);
                        bundle.putString("message", str3);
                        bundle.putString("imageurl", str2);
                        bundle.putString("producturl", str);
                        ShareManager.E().T(this.l, bundle, this.m);
                        ShareManager.E().e0(linearLayout);
                        if ((this.t && !this.k && getItemViewType() != FeedsAdapter.t && getItemViewType() != FeedsAdapter.u) || (d20.E().equals(n(feedMergeDataDO)) && getItemViewType() != FeedsAdapter.x)) {
                            d2.setVisibility(0);
                        }
                        if ((this.t || this.k) && !d20.E().equals(n(feedMergeDataDO))) {
                            d2.setVisibility(8);
                        } else if (getItemViewType() == FeedsAdapter.t || getItemViewType() == FeedsAdapter.x || getItemViewType() == FeedsAdapter.F) {
                            d2.setVisibility(8);
                            linearLayout.addView(q92.e(this.l, new e(feedMergeDataDO)));
                        } else {
                            d2.setVisibility(0);
                        }
                        if (!xf2.j(str)) {
                            ShareManager.E().N();
                        } else {
                            ShareManager.E().q0();
                        }
                        ShareManager.E().l0();
                        if (!this.p) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("titlelabel", "大家说");
                            hashMap.put("evaluate_id", i(feedMergeDataDO));
                            hashMap.put("content_type", feedMergeDataDO.bizType);
                            hashMap.put("content_id", i(feedMergeDataDO));
                            cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e("brand", "evaluate_list", "share_" + this.itemView.getTag(), hashMap, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    i e2 = new i(feedMergeDataDO.watchData.get(0)).e();
                    str6 = e2.b();
                    str5 = e2.d();
                    str4 = e2.c();
                    str7 = e2.a();
                } else {
                    ArticleFeedData articleFeedData = feedMergeDataDO.articleData.get(0);
                    str6 = articleFeedData.articleContent;
                    str5 = articleFeedData.url;
                    str4 = articleFeedData.articleTitle;
                    str7 = articleFeedData.img;
                }
            } else {
                i e3 = new i(feedMergeDataDO.commentData.get(0)).e();
                str6 = e3.b();
                str5 = e3.d();
                str4 = e3.c();
                str7 = e3.a();
            }
        } else {
            DynamicFeedData dynamicFeedData = feedMergeDataDO.dynamicData.get(0);
            str6 = dynamicFeedData.comment;
            str5 = dynamicFeedData.url;
            if (!xf2.j(dynamicFeedData.userNick)) {
                str4 = dynamicFeedData.userNick + "@大麦";
            } else {
                str4 = this.r + "@大麦";
            }
            List<String> list5 = dynamicFeedData.imgs;
            if (list5 == null || list5.size() <= 0) {
                List<String> list6 = dynamicFeedData.forwardImgs;
                if (list6 != null && list6.size() > 0) {
                    str7 = dynamicFeedData.forwardImgs.get(0);
                } else if (!xf2.j(dynamicFeedData.userImg)) {
                    str7 = dynamicFeedData.userImg;
                } else {
                    str7 = this.s;
                }
            } else {
                str7 = dynamicFeedData.imgs.get(0);
            }
        }
        str2 = str7;
        str3 = str6;
        str8 = str4;
        str = str5;
        Bundle bundle2 = new Bundle();
        bundle2.putString("title", str8);
        bundle2.putString("message", str3);
        bundle2.putString("imageurl", str2);
        bundle2.putString("producturl", str);
        ShareManager.E().T(this.l, bundle2, this.m);
        ShareManager.E().e0(linearLayout);
        d2.setVisibility(0);
        if (this.t) {
        }
        d2.setVisibility(8);
        if (!xf2.j(str)) {
        }
        ShareManager.E().l0();
        if (!this.p) {
        }
    }

    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-993556639")) {
            return this.l;
        }
        return (Activity) ipChange.ipc$dispatch("-993556639", new Object[]{this});
    }

    public void h(String str, String str2, Activity activity, String str3, String str4, int i2, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779440507")) {
            ipChange.ipc$dispatch("-779440507", new Object[]{this, str, str2, activity, str3, str4, Integer.valueOf(i2), str5});
        } else if (this.k) {
            View view = this.itemView;
            int i3 = R$id.feeds_item_header;
            ImageView imageView = (ImageView) view.findViewById(i3);
            if (imageView != null) {
                DMImageCreator k2 = cn.damai.common.image.a.b().c(str2).k(new cq((float) v50.a(activity, 1.0f), this.l.getResources().getColor(R$color.color_6black)));
                int i4 = R$drawable.uikit_user_default_icon;
                k2.i(i4).c(i4).g(imageView);
                v(str, R$id.feeds_item_name);
                v(str3, R$id.feeds_item_date);
                this.itemView.findViewById(i3).setOnClickListener(new a(str4));
                View view2 = this.itemView;
                int i5 = R$id.user_b_tag;
                if (view2.findViewById(i5) == null) {
                    return;
                }
                if (!xf2.j(str5)) {
                    this.itemView.findViewById(i5).setVisibility(0);
                    if (str5.equals(InteractionFeedData.USER_BTAG_OFFICIAL)) {
                        ((ImageView) this.itemView.findViewById(i5)).setImageDrawable(this.l.getResources().getDrawable(R$drawable.feeds_user_tag_offical));
                    } else if (str5.equals(InteractionFeedData.USER_BTAG_FANS)) {
                        ((ImageView) this.itemView.findViewById(i5)).setImageDrawable(this.l.getResources().getDrawable(R$drawable.feeds_user_tag_fans));
                    } else {
                        this.itemView.findViewById(i5).setVisibility(8);
                    }
                } else {
                    this.itemView.findViewById(i5).setVisibility(8);
                }
            }
        }
    }

    public int j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1952953989")) {
            return this.n;
        }
        return ((Integer) ipChange.ipc$dispatch("1952953989", new Object[]{this})).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0266  */
    public Bundle k(FeedMergeDataDO feedMergeDataDO) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        List<DynamicFeedData> list;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        List<DynamicFeedData> list2;
        String str18;
        List<CommentFeedData> list3;
        List<WatchFeedData> list4;
        List<DynamicFeedData> list5;
        List<ArticleFeedData> list6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091857392")) {
            return (Bundle) ipChange.ipc$dispatch("2091857392", new Object[]{this, feedMergeDataDO});
        }
        if (feedMergeDataDO == null) {
            return new Bundle();
        }
        String str19 = "-1";
        String str20 = null;
        if (j() == FeedsAdapter.m || j() == FeedsAdapter.n || j() == FeedsAdapter.w) {
            str19 = "23";
            if (!(feedMergeDataDO == null || (list = feedMergeDataDO.dynamicData) == null || list.size() <= 0)) {
                if (feedMergeDataDO.bizType.startsWith("6.") || feedMergeDataDO.bizType.startsWith("7.")) {
                    str19 = "15";
                }
                DynamicFeedData dynamicFeedData = feedMergeDataDO.dynamicData.get(0);
                if (j() == FeedsAdapter.m || j() == FeedsAdapter.w) {
                    str12 = dynamicFeedData.userNick;
                    if (xf2.j(str12)) {
                        str12 = this.r;
                    }
                    String str21 = dynamicFeedData.comment;
                    str10 = this.s;
                    str9 = dynamicFeedData.bizId;
                    List<String> list7 = dynamicFeedData.imgs;
                    if (list7 == null || list7.size() <= 0) {
                        str8 = str21;
                        str7 = null;
                        str11 = null;
                    } else {
                        str7 = dynamicFeedData.imgs.get(0);
                        str8 = str21;
                        str11 = null;
                    }
                } else {
                    String str22 = this.r;
                    str11 = dynamicFeedData.comment;
                    String str23 = dynamicFeedData.forwardId;
                    String str24 = dynamicFeedData.forwardUserNick;
                    str8 = dynamicFeedData.forwardComment;
                    String str25 = dynamicFeedData.forwardUserImg;
                    List<String> list8 = dynamicFeedData.forwardImgs;
                    if (list8 != null && list8.size() > 0) {
                        str20 = dynamicFeedData.forwardImgs.get(0);
                    }
                    str7 = str20;
                    str20 = str22;
                    str12 = str24;
                    str9 = str23;
                    str10 = str25;
                }
                str4 = str12;
                str2 = str10;
                str6 = str7;
                str3 = str11;
                str5 = str20;
                str = str8;
                str20 = str9;
                Bundle bundle = new Bundle();
                bundle.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
                bundle.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
                bundle.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
                bundle.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
                bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
                if (xf2.j(str6)) {
                    bundle.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_IMAGE, str6);
                } else {
                    bundle.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_IMAGE, str2);
                }
                bundle.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
                bundle.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
                bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
                Log.d("netlog", "forward param: " + bundle.toString());
                return bundle;
            }
        } else {
            if (j() == FeedsAdapter.o || j() == FeedsAdapter.q) {
                if (!(feedMergeDataDO == null || (list2 = feedMergeDataDO.dynamicData) == null || list2.size() <= 0)) {
                    DynamicFeedData dynamicFeedData2 = feedMergeDataDO.dynamicData.get(0);
                    str19 = j() == FeedsAdapter.q ? "32" : "20";
                    str17 = this.r;
                    str16 = dynamicFeedData2.comment;
                    str15 = dynamicFeedData2.forwardId;
                    str14 = dynamicFeedData2.forwardUserNick;
                    str13 = dynamicFeedData2.forwardComment;
                    str2 = dynamicFeedData2.forwardUserImg;
                    List<String> list9 = dynamicFeedData2.forwardImgs;
                    if (list9 != null && list9.size() > 0) {
                        str20 = dynamicFeedData2.forwardImgs.get(0);
                    }
                }
                str19 = "20";
            } else {
                if (j() == FeedsAdapter.r || j() == FeedsAdapter.v) {
                    if (!(feedMergeDataDO == null || (list3 = feedMergeDataDO.commentData) == null || list3.size() <= 0)) {
                        CommentFeedData commentFeedData = feedMergeDataDO.commentData.get(0);
                        if (commentFeedData.targetType == 22) {
                            str19 = "22";
                        } else {
                            str19 = "20";
                        }
                        String str26 = commentFeedData.userImg;
                        str18 = commentFeedData.bizId;
                        String str27 = commentFeedData.targetImg;
                        String str28 = commentFeedData.userNick;
                        str = commentFeedData.comment;
                        if (xf2.j(str28)) {
                            str28 = this.r;
                        }
                        str2 = str26;
                        str6 = str27;
                        str4 = str28;
                    }
                    str19 = "20";
                } else if (j() == FeedsAdapter.s) {
                    if (!(feedMergeDataDO == null || (list6 = feedMergeDataDO.articleData) == null || list6.size() <= 0)) {
                        ArticleFeedData articleFeedData = feedMergeDataDO.articleData.get(0);
                        String str29 = articleFeedData.bizId;
                        String str30 = articleFeedData.articleTitle;
                        String str31 = articleFeedData.articleContent;
                        str3 = null;
                        str2 = null;
                        str20 = str29;
                        str6 = articleFeedData.img;
                        str = str31;
                        str4 = str30;
                        str5 = null;
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
                        bundle2.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
                        if (xf2.j(str6)) {
                        }
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
                        bundle2.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
                        bundle2.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
                        Log.d("netlog", "forward param: " + bundle2.toString());
                        return bundle2;
                    }
                } else if (j() == FeedsAdapter.p) {
                    if (!(feedMergeDataDO == null || (list5 = feedMergeDataDO.dynamicData) == null || list5.size() <= 0)) {
                        DynamicFeedData dynamicFeedData3 = feedMergeDataDO.dynamicData.get(0);
                        str17 = this.r;
                        str16 = dynamicFeedData3.comment;
                        str15 = dynamicFeedData3.forwardId;
                        str14 = dynamicFeedData3.forwardTitle;
                        str13 = dynamicFeedData3.forwardContent;
                        str2 = dynamicFeedData3.forwardUserImg;
                        List<String> list10 = dynamicFeedData3.forwardImgs;
                        if (list10 != null && list10.size() > 0) {
                            str20 = dynamicFeedData3.forwardImgs.get(0);
                        }
                    }
                } else if (j() != FeedsAdapter.t && j() != FeedsAdapter.u && j() != FeedsAdapter.x) {
                    str = null;
                    str6 = null;
                    str5 = null;
                    str19 = null;
                    str4 = null;
                    str3 = str4;
                    str2 = str3;
                    Bundle bundle22 = new Bundle();
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
                    bundle22.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
                    if (xf2.j(str6)) {
                    }
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
                    bundle22.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
                    bundle22.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
                    Log.d("netlog", "forward param: " + bundle22.toString());
                    return bundle22;
                } else if (feedMergeDataDO == null || (list4 = feedMergeDataDO.watchData) == null || list4.size() <= 0) {
                    str19 = "32";
                } else {
                    WatchFeedData watchFeedData = feedMergeDataDO.watchData.get(0);
                    String str32 = watchFeedData.userImg;
                    str18 = watchFeedData.bizId;
                    String str33 = watchFeedData.targetImg;
                    str4 = watchFeedData.userNick;
                    str = watchFeedData.comment;
                    if (xf2.j(str4)) {
                        str4 = this.r;
                    }
                    str2 = str32;
                    str6 = str33;
                    str19 = "32";
                }
                str3 = null;
                str20 = str18;
                str5 = null;
                Bundle bundle222 = new Bundle();
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
                bundle222.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
                if (xf2.j(str6)) {
                }
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
                bundle222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
                bundle222.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
                Log.d("netlog", "forward param: " + bundle222.toString());
                return bundle222;
            }
            str4 = str14;
            str = str13;
            str5 = str17;
            str6 = str20;
            str20 = str15;
            str3 = str16;
            Bundle bundle2222 = new Bundle();
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
            bundle2222.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
            if (xf2.j(str6)) {
            }
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
            bundle2222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
            bundle2222.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
            Log.d("netlog", "forward param: " + bundle2222.toString());
            return bundle2222;
        }
        str = null;
        str6 = null;
        str5 = null;
        str4 = null;
        str3 = str4;
        str2 = str3;
        Bundle bundle22222 = new Bundle();
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_ID, str20);
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_TYPE, str19);
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_TITLE, str4);
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_CONTENT_SUBTITLE, str);
        bundle22222.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "24");
        if (xf2.j(str6)) {
        }
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_USER_NICK, str5);
        bundle22222.putString(p21.ISSUE_PARAM_FORWARD_COMMENT_TEXT, str3);
        bundle22222.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_FORWARD);
        Log.d("netlog", "forward param: " + bundle22222.toString());
        return bundle22222;
    }

    public String l(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660990677")) {
            return (String) ipChange.ipc$dispatch("1660990677", new Object[]{this, str, str2, str3});
        } else if (xf2.j(str)) {
            return "";
        } else {
            if (xf2.j(str2)) {
                return str;
            }
            String str4 = str + " / " + str2;
            if (xf2.j(str3)) {
                return str4;
            }
            return str + " / " + str2 + " / " + str3;
        }
    }

    public void o(Bundle bundle, String str, int i2, int i3, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946332998")) {
            ipChange.ipc$dispatch("-946332998", new Object[]{this, bundle, str, Integer.valueOf(i2), Integer.valueOf(i3), str2});
        } else if (i2 != 9) {
            switch (i2) {
                case 1:
                    bundle.putString(FeedsViewModel.ARG_USERID, str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                    return;
                case 2:
                    bundle.putString("artistid", str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                    return;
                case 3:
                    bundle.putString(FeedsViewModel.ARG_USERID, str);
                    bundle.putString("usertype", "3");
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                    return;
                case 4:
                    bundle.putString("brandid", str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                    return;
                case 5:
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(wz1.REPERTOITE));
                    return;
                case 6:
                    if (i3 != 0) {
                        try {
                            bundle.putLong(IssueConstants.ProjectID, Long.parseLong(str));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                        tb2.a(this.l, str2, bundle);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            bundle.putString(FeedsViewModel.ARG_USERID, str);
            bundle.putString("usertype", "9");
            DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
        }
    }

    public void r(ArrayList<String> arrayList, Activity activity, int i2, cn.damai.user.userprofile.bean.VideoInfo videoInfo) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693376614")) {
            ipChange.ipc$dispatch("-693376614", new Object[]{this, arrayList, activity, Integer.valueOf(i2), videoInfo});
            return;
        }
        NineGridlayout nineGridlayout = this.v;
        if (nineGridlayout != null) {
            nineGridlayout.setVisibility(0);
            this.v.setRadius(v50.a(activity, 6.0f));
            this.v.setGap(v50.a(activity, 3.0f));
            ArrayList arrayList2 = new ArrayList();
            String str2 = "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0";
            if (videoInfo != null) {
                if (arrayList == null || arrayList.size() <= 0) {
                    str = "";
                } else {
                    str = str2;
                }
                NineGridlayout.Image image = new NineGridlayout.Image(videoInfo.coverUrl + str);
                image.setShowPlay(true);
                arrayList2.add(image);
            }
            if (arrayList != null && arrayList.size() > 0) {
                if (arrayList2.size() <= 0 && (arrayList2.size() != 0 || arrayList.size() <= 1)) {
                    str2 = "";
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    NineGridlayout.Image image2 = new NineGridlayout.Image(it.next() + str2);
                    image2.setShowPlay(false);
                    arrayList2.add(image2);
                }
            }
            if (arrayList2.size() > 0) {
                this.v.setTotalWidth(i2);
                this.v.updateImages(arrayList2);
                h hVar = new h(this, activity, videoInfo, arrayList);
                this.v.setListener(hVar);
                this.v.setOnClickListener(hVar);
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void setType(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313262733")) {
            ipChange.ipc$dispatch("-313262733", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.n = i2;
    }

    public void t(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101056367")) {
            ipChange.ipc$dispatch("1101056367", new Object[]{this, view});
            return;
        }
        this.m = view;
    }

    public void u(boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917270754")) {
            ipChange.ipc$dispatch("917270754", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i2)});
            return;
        }
        this.p = true;
    }

    public void v(String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320946532")) {
            ipChange.ipc$dispatch("-320946532", new Object[]{this, str, Integer.valueOf(i2)});
        } else if (this.itemView.findViewById(i2) == null) {
        } else {
            if (xf2.j(str)) {
                this.itemView.findViewById(i2).setVisibility(8);
                return;
            }
            this.itemView.findViewById(i2).setVisibility(0);
            ((TextView) this.itemView.findViewById(i2)).setText(str);
        }
    }

    public void x(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226421456")) {
            ipChange.ipc$dispatch("-1226421456", new Object[]{this, feedMergeDataDO});
        }
    }

    public void y(FeedMergeDataDO feedMergeDataDO, boolean z, String str, String str2, String str3) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636252806")) {
            ipChange.ipc$dispatch("1636252806", new Object[]{this, feedMergeDataDO, Boolean.valueOf(z), str, str2, str3});
            return;
        }
        Log.e("titleRatingBar", "updateInfo ======= parent ");
        if (feedMergeDataDO != null) {
            this.t = z;
            this.u = str;
            this.r = str2;
            this.s = str3;
            if (i(feedMergeDataDO) == null || (textView = this.g) == null) {
                TextView textView2 = this.g;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                textView.setVisibility(0);
                this.g.setOnClickListener(new b(feedMergeDataDO));
            }
            TextView textView3 = this.b;
            if (textView3 != null) {
                textView3.setText(feedMergeDataDO.year);
            }
            v(feedMergeDataDO.bizTime, R$id.feeds_item_date);
            v(feedMergeDataDO.title, R$id.feeds_item_title);
            Log.e("titleRatingBar", "============  mark:  titleRatingBar: " + this.i + " , cb : " + this.h);
            s(feedMergeDataDO, this.h);
            s(feedMergeDataDO, this.i);
            View view = this.c;
            if (view != null) {
                if (feedMergeDataDO.enableComment || feedMergeDataDO.enableForward || feedMergeDataDO.enablePraise) {
                    view.setVisibility(0);
                    q(feedMergeDataDO);
                    return;
                }
                view.setVisibility(8);
            }
        }
    }

    public void z(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282129734")) {
            ipChange.ipc$dispatch("1282129734", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        View view = this.a;
        if (view != null && this.b != null) {
            if (z) {
                view.setVisibility(0);
                this.b.setText(str);
                return;
            }
            view.setVisibility(8);
        }
    }
}

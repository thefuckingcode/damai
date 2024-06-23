package cn.damai.discover.content.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.listener.OnPraiseViewClickListenerNew;
import cn.damai.comment.view.PraiseView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.discover.content.bean.ContentCommentList;
import cn.damai.discover.content.ui.viewholder.ContentCommentViewHolder;
import cn.damai.discover.content.ut.LiveUTer;
import cn.damai.discover.content.view.UserInfoView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.gr;
import tb.h03;
import tb.w71;
import tb.xf2;

/* compiled from: Taobao */
public class ContentCommentAdapter extends RecyclerView.Adapter<CommentItemViewHolder> implements LiveUTer {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContentCommentViewHolder.OnCommentClickListener a;
    private ArrayList<ContentCommentList.CommentListItem> b = new ArrayList<>();
    private w71 c;

    /* compiled from: Taobao */
    public class CommentItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private UserInfoView b;
        private TextView c = ((TextView) this.itemView.findViewById(R$id.content_detail_comment_list_item_reply_content));
        private LinearLayout d = ((LinearLayout) this.itemView.findViewById(R$id.content_detail_comment_list_item_comment_content_layout));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.content_detail_comment_list_item_comment_content));
        private PraiseView f;
        private View g;

        /* compiled from: Taobao */
        public class a implements OnPraiseViewClickListenerNew {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ContentCommentList.CommentListItem.CommentPraiseInfo a;

            a(ContentCommentList.CommentListItem.CommentPraiseInfo commentPraiseInfo) {
                this.a = commentPraiseInfo;
            }

            @Override // cn.damai.comment.listener.OnPraiseViewClickListenerNew
            public void OnPraiseViewClick(boolean z, String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1764164660")) {
                    ipChange.ipc$dispatch("-1764164660", new Object[]{this, Boolean.valueOf(z), str});
                    return;
                }
                c.e().x(ContentCommentAdapter.this.getLiveUt().x(this.a.position));
            }
        }

        public CommentItemViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.live_content_detail_comment_item, (ViewGroup) null));
            this.a = context;
            UserInfoView userInfoView = (UserInfoView) this.itemView.findViewById(R$id.content_detail_comment_list_item_avatar);
            this.b = userInfoView;
            userInfoView.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.content_detail_comment_list_item_reply);
            this.f = (PraiseView) this.itemView.findViewById(R$id.content_detail_comment_list_item_praise);
            this.g = this.itemView.findViewById(R$id.content_detail_comment_list_item_divider);
            this.itemView.setOnClickListener(this);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "320639661")) {
                ipChange.ipc$dispatch("320639661", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ContentCommentList.CommentListItem commentListItem = (ContentCommentList.CommentListItem) ContentCommentAdapter.this.b.get(i);
            if (commentListItem != null) {
                commentListItem.position = i;
                this.itemView.setTag(commentListItem);
                ContentCommentList.CommentListItem.ReplyUserInfo replyUserInfo = commentListItem.userDO;
                if (replyUserInfo != null) {
                    this.b.setTag(replyUserInfo);
                    this.b.setAvatarUrl(replyUserInfo.headerImage);
                    UserInfoView userInfoView = this.b;
                    boolean z = replyUserInfo.vip;
                    PerformFilmVipDO performFilmVipDO = replyUserInfo.performFilmVipDO;
                    userInfoView.setVip(z, performFilmVipDO != null ? performFilmVipDO.memberFlag : h03.h());
                    this.b.setUserName(replyUserInfo.nickname);
                    this.b.setTagName(replyUserInfo.userTag);
                    this.b.setUserDesc(commentListItem.getPublishDateAndCity());
                    this.b.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_33x33);
                }
                ArrayList<ContentCommentList.CommentListItem.TextDO> arrayList = commentListItem.textDOList;
                if (xf2.e(arrayList) > 0 && arrayList.get(0) != null) {
                    this.c.setText(arrayList.get(0).value);
                }
                ArrayList<ContentCommentList.CommentListItem> arrayList2 = commentListItem.appendComments;
                if (xf2.e(arrayList2) > 0) {
                    ContentCommentList.CommentListItem commentListItem2 = arrayList2.get(0);
                    if (commentListItem2 != null) {
                        ArrayList<ContentCommentList.CommentListItem.TextDO> arrayList3 = commentListItem2.textDOList;
                        if (xf2.e(arrayList3) <= 0 || arrayList3.get(0) == null || commentListItem2.userDO == null) {
                            this.d.setVisibility(8);
                        } else {
                            ContentCommentList.CommentListItem.TextDO textDO = arrayList3.get(0);
                            ContentCommentList.CommentListItem.ReplyUserInfo replyUserInfo2 = commentListItem2.userDO;
                            if (TextUtils.isEmpty(textDO.value) || TextUtils.isEmpty(replyUserInfo2.nickname)) {
                                this.d.setVisibility(8);
                            } else {
                                String format = String.format("%s%s", "回复@", replyUserInfo2.nickname);
                                this.e.setText(b(String.format("%s%s", format, textDO.value), format, "#30AEFF"));
                                this.d.setVisibility(0);
                            }
                        }
                    } else {
                        this.d.setVisibility(8);
                    }
                } else {
                    this.d.setVisibility(8);
                }
                ContentCommentList.CommentListItem.CommentPraiseInfo commentPraiseInfo = commentListItem.praiseInfo;
                if (commentPraiseInfo != null) {
                    commentPraiseInfo.commentId = commentListItem.commentId;
                    commentPraiseInfo.position = i;
                    this.f.setTag(commentPraiseInfo);
                    CommentPraiseInfoBean commentPraiseInfoBean = new CommentPraiseInfoBean();
                    commentPraiseInfoBean.setPraiseCount(commentPraiseInfo.praiseCount + "");
                    commentPraiseInfoBean.setHasPraised(commentPraiseInfo.hasPraised);
                    this.f.setData(commentPraiseInfoBean, commentPraiseInfo.commentId);
                    this.f.setOnPraiseLayoutClickListenerCommon(new a(commentPraiseInfo));
                }
                if (xf2.e(ContentCommentAdapter.this.b) > 5 || i != xf2.e(ContentCommentAdapter.this.b) - 1) {
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                }
            }
        }

        public SpannableString b(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1291254073")) {
                return (SpannableString) ipChange.ipc$dispatch("-1291254073", new Object[]{this, str, str2, str3});
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), 0, str2.length(), 33);
            return spannableString;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-593664748")) {
                ipChange.ipc$dispatch("-593664748", new Object[]{this, view});
            } else if (view.getId() == R$id.content_detail_comment_list_item_avatar) {
                Bundle bundle = new Bundle();
                bundle.putString("userId", ((ContentCommentList.CommentListItem.ReplyUserInfo) view.getTag()).havanaIdStr);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.Y));
            } else {
                ContentCommentList.CommentListItem commentListItem = (ContentCommentList.CommentListItem) view.getTag();
                if (commentListItem != null) {
                    c.e().x(ContentCommentAdapter.this.getLiveUt().y(commentListItem.position));
                    if (ContentCommentAdapter.this.a != null) {
                        ContentCommentAdapter.this.a.onClick(view);
                    }
                }
            }
        }
    }

    public void c(ContentCommentList.CommentListItem commentListItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691069376")) {
            ipChange.ipc$dispatch("-691069376", new Object[]{this, commentListItem});
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.add(0, commentListItem);
        notifyDataSetChanged();
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "305421336")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("305421336", new Object[]{this})).intValue();
    }

    public void e(List<ContentCommentList.CommentListItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899703072")) {
            ipChange.ipc$dispatch("-1899703072", new Object[]{this, list});
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: f */
    public void onBindViewHolder(@NonNull CommentItemViewHolder commentItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125803829")) {
            ipChange.ipc$dispatch("-125803829", new Object[]{this, commentItemViewHolder, Integer.valueOf(i)});
            return;
        }
        commentItemViewHolder.a(i);
    }

    @NonNull
    /* renamed from: g */
    public CommentItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1697775883")) {
            return new CommentItemViewHolder(viewGroup.getContext());
        }
        return (CommentItemViewHolder) ipChange.ipc$dispatch("1697775883", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1038357455")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("-1038357455", new Object[]{this})).intValue();
    }

    @Override // cn.damai.discover.content.ut.LiveUTer
    @NonNull
    public w71 getLiveUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595353653")) {
            return (w71) ipChange.ipc$dispatch("1595353653", new Object[]{this});
        }
        w71 w71 = this.c;
        return w71 == null ? new w71() : w71;
    }

    public void h(ArrayList<ContentCommentList.CommentListItem> arrayList, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080969948")) {
            ipChange.ipc$dispatch("-1080969948", new Object[]{this, arrayList, str, str2});
            return;
        }
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public void i(ContentCommentViewHolder.OnCommentClickListener onCommentClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330760276")) {
            ipChange.ipc$dispatch("1330760276", new Object[]{this, onCommentClickListener});
            return;
        }
        this.a = onCommentClickListener;
    }

    @Override // cn.damai.discover.content.ut.LiveUTer
    public void setLiveUt(w71 w71) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029750147")) {
            ipChange.ipc$dispatch("-2029750147", new Object[]{this, w71});
            return;
        }
        this.c = w71;
    }
}

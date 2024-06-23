package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.FollowStateBean;
import cn.damai.comment.listener.OnPraiseViewClickListenerNew;
import cn.damai.comment.request.FollowRequest;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.view.PraiseView;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.discover.bean.NineJumpBean;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.discover.content.view.UserInfoView;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.RelatedInfo;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.ip.bean.BaseUserDO;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.BottomActionDialog;
import cn.damai.uikit.view.NineGridView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import java.util.List;
import tb.f92;
import tb.gr;
import tb.h03;
import tb.ri1;
import tb.s50;
import tb.sf2;
import tb.xs0;

/* compiled from: Taobao */
public class BigNoteViewHolder extends BaseViewHolder<NoteBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View A;
    private UserInfoView a;
    private ImageView b;
    private TextView c;
    private NineGridView d;
    private ri1 e;
    private View f;
    private TextView g;
    private DMIconFontTextView h;
    private PraiseView i;
    private View j;
    private ImageView k;
    private TextView l;
    private View m;
    private View n;
    private OnItemClickListener<NoteBean> o;
    public NoteBean p;
    public int q;
    private Context r;
    boolean s = false;
    protected int t = 5;
    protected boolean u = false;
    private NineJumpBean v;
    private View w;
    private View x;
    private TextView y;
    private View z;

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<GridBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, GridBean gridBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1222978927")) {
                ipChange.ipc$dispatch("1222978927", new Object[]{this, view, gridBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(GridBean gridBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "302704868")) {
                ipChange.ipc$dispatch("302704868", new Object[]{this, gridBean, Integer.valueOf(i)});
                return;
            }
            BigNoteViewHolder.this.i(gridBean, i);
        }
    }

    /* compiled from: Taobao */
    public class b implements OnPraiseViewClickListenerNew {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // cn.damai.comment.listener.OnPraiseViewClickListenerNew
        public void OnPraiseViewClick(boolean z, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "481382345")) {
                ipChange.ipc$dispatch("481382345", new Object[]{this, Boolean.valueOf(z), str});
                return;
            }
            BigNoteViewHolder.this.c(z, str, this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements UserInfoView.DnaClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.discover.content.view.UserInfoView.DnaClickListener
        public void onDnaClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "608835007")) {
                ipChange.ipc$dispatch("608835007", new Object[]{this});
                return;
            }
            BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
            NoteBean noteBean = bigNoteViewHolder.p;
            bigNoteViewHolder.dnaOnClickReport(noteBean.contentInfo.id, noteBean.baseUserDO.havanaIdStr, bigNoteViewHolder.q);
            if (TextUtils.isEmpty(this.a)) {
                DialogUtil.b(BigNoteViewHolder.this.r).show();
            } else {
                DMNav.from(BigNoteViewHolder.this.r).toUri(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements BottomActionDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.view.BottomActionDialog.OnActionListener
        public void onItemClick(BottomActionDialog.Action action, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-456432875")) {
                ipChange.ipc$dispatch("-456432875", new Object[]{this, action, Integer.valueOf(i)});
                return;
            }
            BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
            bigNoteViewHolder.l(bigNoteViewHolder.p, action, i);
        }
    }

    public BigNoteViewHolder(View view, OnItemClickListener<NoteBean> onItemClickListener) {
        super(view);
        this.r = view.getContext();
        this.o = onItemClickListener;
        this.a = (UserInfoView) view.findViewById(R$id.content_detail_user_info);
        this.b = (ImageView) view.findViewById(R$id.iv_selected);
        this.c = (TextView) view.findViewById(R$id.note_s1_title);
        this.d = (NineGridView) view.findViewById(R$id.comment_hl_content_pics_v2);
        ri1 ri1 = new ri1(xs0.a(), new a());
        this.e = ri1;
        this.d.setAdapter(ri1);
        this.d.enableLog(AppConfig.v());
        this.f = view.findViewById(R$id.note_relate_ui);
        this.g = (TextView) view.findViewById(R$id.note_relate_tv);
        this.h = (DMIconFontTextView) view.findViewById(R$id.tv_share);
        this.i = (PraiseView) view.findViewById(R$id.comment_hl_praise_layout);
        this.j = view.findViewById(R$id.comment_like_layout);
        this.k = (ImageView) view.findViewById(R$id.comment_like_numicon);
        this.l = (TextView) view.findViewById(R$id.comment_like_num);
        this.m = view.findViewById(R$id.comment_reply_layout);
        TextView textView = (TextView) view.findViewById(R$id.comment_num_reply);
        this.n = view.findViewById(R$id.note_stroke_layout);
        this.A = view.findViewById(R$id.note_more_action);
        this.w = view.findViewById(R$id.item_discover_big_note_head_1);
        View findViewById = view.findViewById(R$id.item_discover_big_note_head_2);
        this.x = findViewById;
        this.y = (TextView) findViewById.findViewById(R$id.note_s1_title_2);
        this.z = this.x.findViewById(R$id.iv_selected_2);
    }

    private void n(String str, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632980110")) {
            ipChange.ipc$dispatch("-632980110", new Object[]{this, str, textView});
        } else if (TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            int length = str.length();
            int i2 = this.t;
            if (length >= i2 * 24) {
                String str2 = str.substring(0, (i2 * 24) - 6) + "...  更多";
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.r.getResources().getColor(R$color.color_9C9CA5)), str2.length() - 4, str2.length(), 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(s50.a(this.r, 12.0f)), str2.length() - 4, str2.length(), 33);
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(str);
        }
    }

    private void o(List<String> list, VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499295117")) {
            ipChange.ipc$dispatch("1499295117", new Object[]{this, list, videoInfo});
            return;
        }
        NineJumpBean nineJumpBean = new NineJumpBean(list, videoInfo);
        this.v = nineJumpBean;
        List<GridBean> gridList = nineJumpBean.getGridList(this.u);
        if (f92.d(gridList)) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.e.j(gridList);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(TextView textView, int i2, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319773445")) {
            ipChange.ipc$dispatch("-1319773445", new Object[]{this, textView, Integer.valueOf(i2), str});
            return;
        }
        if (i2 > 10000) {
            str2 = new BigDecimal(i2 / 10000).setScale(1, 4).doubleValue() + "万";
        } else {
            str2 = i2 + "";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (i2 == 0) {
            textView.setText(str);
        } else {
            textView.setText(str2);
        }
    }

    private void r(NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725210359")) {
            ipChange.ipc$dispatch("725210359", new Object[]{this, noteBean});
            return;
        }
        this.a.setOnClickListener(this);
        BaseUserDO baseUserDO = noteBean.baseUserDO;
        if (baseUserDO != null) {
            this.a.setAvatarUrl(baseUserDO.headImg);
            this.a.setUserName(baseUserDO.nickName);
            this.a.setIsOldVip(baseUserDO.vip);
            String str = baseUserDO.userTypeCode;
            if (str != null) {
                this.a.setVip(false, baseUserDO.performFilmVipDO != null ? Integer.parseInt(str) == 2 ? String.valueOf(baseUserDO.userTypeCode) : baseUserDO.performFilmVipDO.memberFlag : h03.h());
                this.a.setTagName(baseUserDO.userTypeText);
                if (2 != Integer.parseInt(baseUserDO.userTypeCode)) {
                    this.a.setUserTagType(Integer.parseInt(baseUserDO.userTypeCode));
                } else {
                    this.a.showUserTagType(false);
                }
            } else {
                UserInfoView userInfoView = this.a;
                PerformFilmVipDO performFilmVipDO = baseUserDO.performFilmVipDO;
                userInfoView.setVip(false, performFilmVipDO != null ? performFilmVipDO.memberFlag : h03.h());
                this.a.showUserTagType(false);
            }
            this.a.setTag(baseUserDO);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        t(!TextUtils.isEmpty(noteBean.similarity), noteBean.similarity, noteBean.goDnaUrl, "");
    }

    private void t(boolean z2, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087148011")) {
            ipChange.ipc$dispatch("-1087148011", new Object[]{this, Boolean.valueOf(z2), str, str2, str3});
        } else if (z2) {
            this.a.setDna(true, str + "%");
            this.a.setDnaClickListener(new c(str2));
        } else {
            this.a.setDna(false, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u(boolean z2) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367653339")) {
            ipChange.ipc$dispatch("-1367653339", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        if (z2) {
            i2 = R$drawable.dm_icon_like_select;
        } else {
            i2 = R$drawable.dm_icon_like_unselect;
        }
        this.k.setImageResource(i2);
    }

    public void c(boolean z2, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668436524")) {
            ipChange.ipc$dispatch("-1668436524", new Object[]{this, Boolean.valueOf(z2), str, Integer.valueOf(i2)});
        }
    }

    public void dnaOnClickReport(String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806595434")) {
            ipChange.ipc$dispatch("-806595434", new Object[]{this, str, str2, Integer.valueOf(i2)});
        }
    }

    /* renamed from: h */
    public void a(NoteBean noteBean, int i2) {
        TextView textView;
        String str;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "701191423")) {
            ipChange.ipc$dispatch("701191423", new Object[]{this, noteBean, Integer.valueOf(i2)});
            return;
        }
        this.p = noteBean;
        this.q = i2;
        if (this.u) {
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            textView = this.y;
            this.z.setVisibility(noteBean.isFeature() ? 0 : 8);
        } else {
            r(noteBean);
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            textView = this.c;
            this.b.setVisibility(noteBean.isFeature() ? 0 : 8);
        }
        if (this.u) {
            str = noteBean.content;
        } else {
            str = noteBean.getContentInfoText();
        }
        n(sf2.a(str), textView);
        o(noteBean.imgList, noteBean.videoInfo);
        CommentPraiseInfoBean commentPraiseInfoBean = new CommentPraiseInfoBean();
        StringBuilder sb = new StringBuilder();
        sb.append(noteBean.praiseInfo.praiseCount);
        String str2 = "";
        sb.append(str2);
        commentPraiseInfoBean.setPraiseCount(sb.toString());
        commentPraiseInfoBean.setHasPraised(noteBean.praiseInfo.hasPraised);
        this.i.setData(commentPraiseInfoBean, noteBean.sourceId);
        this.i.setOnPraiseLayoutClickListenerCommon(new b(i2));
        if (this.u) {
            this.j.setVisibility(8);
        } else {
            q(this.l, noteBean.focusCount, "想看");
            this.j.setOnClickListener(this);
            boolean z2 = noteBean.focus;
            this.s = z2;
            u(z2);
            this.j.setVisibility(0);
        }
        if (this.u) {
            this.h.setVisibility(8);
        } else {
            this.h.setTag(noteBean.shareDO);
            this.h.setOnClickListener(this);
            this.h.setVisibility(noteBean.shareDO == null ? 8 : 0);
        }
        this.itemView.setTag(noteBean);
        this.itemView.setOnClickListener(this);
        k(this.itemView, noteBean, i2);
        if (!this.u || this.p.prohibitEditing) {
            this.A.setVisibility(8);
        } else {
            this.A.setVisibility(0);
            this.A.setOnClickListener(this);
        }
        View view = this.f;
        if (noteBean.relatedInfo == null) {
            i3 = 8;
        }
        view.setVisibility(i3);
        RelatedInfo relatedInfo = noteBean.relatedInfo;
        if (relatedInfo != null) {
            TextView textView2 = this.g;
            String str3 = relatedInfo.value;
            if (str3 != null) {
                str2 = str3;
            }
            textView2.setText(str2);
        }
    }

    public void i(GridBean gridBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421436764")) {
            ipChange.ipc$dispatch("-1421436764", new Object[]{this, gridBean, Integer.valueOf(i2)});
            return;
        }
        NineJumpBean nineJumpBean = this.v;
        if (nineJumpBean != null && this.r != null) {
            int computePosition2NextPage = nineJumpBean.computePosition2NextPage(i2);
            NineImgUtil a2 = NineImgUtil.a();
            Context context = this.r;
            NineJumpBean nineJumpBean2 = this.v;
            a2.d(context, 0, nineJumpBean2.videoInfoList, nineJumpBean2.picInfoList, computePosition2NextPage);
        }
    }

    public List<BottomActionDialog.Action> j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1913106118")) {
            return null;
        }
        return (List) ipChange.ipc$dispatch("-1913106118", new Object[]{this});
    }

    public void k(View view, NoteBean noteBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266288113")) {
            ipChange.ipc$dispatch("-266288113", new Object[]{this, view, noteBean, Integer.valueOf(i2)});
        }
    }

    public void l(NoteBean noteBean, BottomActionDialog.Action action, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054631045")) {
            ipChange.ipc$dispatch("2054631045", new Object[]{this, noteBean, action, Integer.valueOf(i2)});
        }
    }

    public void likeOnClickReport(boolean z2, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801808118")) {
            ipChange.ipc$dispatch("-1801808118", new Object[]{this, Boolean.valueOf(z2), str, Integer.valueOf(i2)});
        }
    }

    public void m(String str, final View view, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255043823")) {
            ipChange.ipc$dispatch("-255043823", new Object[]{this, str, view, str2, str3});
        } else if (str != null) {
            boolean z2 = this.s;
            String str4 = "19:" + str;
            if (!z2 && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                str4 = str4 + "," + str2 + ":" + str3;
            }
            FollowRequest followRequest = new FollowRequest(!z2, str4);
            view.setClickable(false);
            followRequest.request(new DMMtopRequestListener<FollowStateBean>(FollowStateBean.class) {
                /* class cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1251450427")) {
                        ipChange.ipc$dispatch("-1251450427", new Object[]{this, str, str2});
                        return;
                    }
                    Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + str + " , " + str2);
                    view.setClickable(true);
                }

                public void onSuccess(FollowStateBean followStateBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1342494643")) {
                        ipChange.ipc$dispatch("-1342494643", new Object[]{this, followStateBean});
                        return;
                    }
                    boolean isFollowed = followStateBean.isFollowed();
                    BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
                    bigNoteViewHolder.s = isFollowed;
                    bigNoteViewHolder.u(isFollowed);
                    try {
                        NoteBean noteBean = BigNoteViewHolder.this.p;
                        if (noteBean != null) {
                            int i = noteBean.focusCount;
                            if (followStateBean.status.equals("0")) {
                                String str = ((Object) BigNoteViewHolder.this.l.getText()) + "";
                                if (str != null) {
                                    try {
                                        i = Integer.parseInt(str);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (i > 0) {
                                    i--;
                                }
                            } else {
                                i++;
                            }
                            BigNoteViewHolder bigNoteViewHolder2 = BigNoteViewHolder.this;
                            bigNoteViewHolder2.q(bigNoteViewHolder2.l, i, "想看");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    view.setClickable(true);
                }
            });
        }
    }

    public void onClick(View view) {
        NoteBean noteBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314210896")) {
            ipChange.ipc$dispatch("1314210896", new Object[]{this, view});
        } else if (this.p != null) {
            if (view.getId() == R$id.content_detail_user_info) {
                NoteBean noteBean2 = this.p;
                userOnClickReport(noteBean2.contentInfo.id, noteBean2.baseUserDO.havanaIdStr, this.q);
                BaseUserDO baseUserDO = (BaseUserDO) view.getTag();
                Bundle bundle = new Bundle();
                String str = baseUserDO.havanaIdStr;
                if (str == null) {
                    str = baseUserDO.havanaId;
                }
                bundle.putString("userId", str);
                bundle.putString(RepertoireDetailFragment.USERTYPE, "1");
                DMNav.from(this.r).withExtras(bundle).toUri(NavUri.b(gr.Y));
            } else if (view.getId() == R$id.comment_like_layout) {
                NoteBean noteBean3 = this.p;
                if (noteBean3 != null) {
                    String str2 = noteBean3.contentInfo.id;
                    BaseUserDO baseUserDO2 = noteBean3.baseUserDO;
                    m(str2, view, baseUserDO2.havanaIdStr, baseUserDO2.targetType);
                    likeOnClickReport(this.s, this.p.contentInfo.id, this.q);
                }
            } else if (view.getId() == R$id.tv_share) {
                ContentShareInfo contentShareInfo = (ContentShareInfo) view.getTag();
                if (contentShareInfo != null) {
                    s(this.p, contentShareInfo, this.q);
                }
            } else if (view.getId() == R$id.note_more_action) {
                List<BottomActionDialog.Action> j2 = j();
                if (!f92.d(j2) && this.r != null) {
                    new BottomActionDialog(this.r, new d(), j2).show();
                }
            } else {
                OnItemClickListener<NoteBean> onItemClickListener = this.o;
                if (onItemClickListener != null && (noteBean = this.p) != null) {
                    onItemClickListener.onItemClick(noteBean, this.q);
                }
            }
        }
    }

    public void p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241909301")) {
            ipChange.ipc$dispatch("-241909301", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        View view = this.n;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
                this.n.requestLayout();
            }
        }
    }

    public void s(NoteBean noteBean, ContentShareInfo contentShareInfo, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330543955")) {
            ipChange.ipc$dispatch("-1330543955", new Object[]{this, noteBean, contentShareInfo, Integer.valueOf(i2)});
        }
    }

    public void userOnClickReport(String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037808266")) {
            ipChange.ipc$dispatch("-2037808266", new Object[]{this, str, str2, Integer.valueOf(i2)});
        }
    }
}

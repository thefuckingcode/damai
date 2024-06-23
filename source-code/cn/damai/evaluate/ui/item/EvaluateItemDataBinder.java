package cn.damai.evaluate.ui.item;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.R$dimen;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.listener.OnPraiseViewClickListener;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.EvaluateUserInfoUtil;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.comment.view.DMTagView;
import cn.damai.comment.view.PraiseView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.br;
import tb.fk;
import tb.gr;
import tb.hk;
import tb.ik;
import tb.n42;
import tb.p21;
import tb.re0;
import tb.s50;
import tb.up2;
import tb.wk;
import tb.wz1;

/* compiled from: Taobao */
public class EvaluateItemDataBinder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMENT_ITEM_TYPE_DEFAULT = 0;
    public static final int COMMENT_ITEM_TYPE_DETAIL = 1;
    public static final int COMMENT_SCENE_DEFAULT = 0;
    public static final int COMMENT_SCENE_SCRIPT = 2;
    public static final int COMMENT_SCENE_SCRIPT_STORE = 1;
    private Activity a;
    private f b;
    private e c;
    private EvaluateItemUTReportListener d;
    private EvaluateItemOtherListener e;
    public SimpleItemClickListener f;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private boolean j = false;
    private OnPraiseViewClickListener k = new d();

    /* compiled from: Taobao */
    public interface EvaluateItemOtherListener {
        void deleteComment(CommentsItemBean commentsItemBean);

        void onClickShareBtn(CommentsItemBean commentsItemBean);

        void replyContentClick(boolean z, CommentsItemBean commentsItemBean);
    }

    /* compiled from: Taobao */
    public interface EvaluateItemUTReportListener {
        void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2);

        void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);
    }

    /* compiled from: Taobao */
    enum Scene {
        LIST(0),
        DETAIL(1);
        
        int value;

        private Scene(int i) {
            this.value = i;
        }
    }

    /* compiled from: Taobao */
    public interface SimpleItemClickListener {
        void onSingleItemClick();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ EvaluateItemViewHolder a;

        a(EvaluateItemDataBinder evaluateItemDataBinder, EvaluateItemViewHolder evaluateItemViewHolder) {
            this.a = evaluateItemViewHolder;
        }

        public void onClick(View view) {
            TextView textView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2019771697")) {
                ipChange.ipc$dispatch("-2019771697", new Object[]{this, view});
                return;
            }
            EvaluateItemViewHolder evaluateItemViewHolder = this.a;
            if (evaluateItemViewHolder != null && (textView = evaluateItemViewHolder.c) != null && textView.getLayout() != null) {
                if (this.a.c.getLayout().getEllipsisCount(this.a.c.getLineCount() - 1) > 0) {
                    this.a.e.setText("收起");
                    this.a.c.setMaxLines(Integer.MAX_VALUE);
                    return;
                }
                this.a.e.setText("查看全文");
                this.a.c.setMaxLines(5);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements NineImgUtil.OnClickExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;

        b(CommentsItemBean commentsItemBean) {
            this.a = commentsItemBean;
        }

        @Override // cn.damai.comment.util.NineImgUtil.OnClickExtraListener
        public void onExtraLister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-946057035")) {
                ipChange.ipc$dispatch("-946057035", new Object[]{this, Integer.valueOf(i)});
            } else if (EvaluateItemDataBinder.this.d != null) {
                EvaluateItemUTReportListener evaluateItemUTReportListener = EvaluateItemDataBinder.this.d;
                CommentsItemBean commentsItemBean = this.a;
                evaluateItemUTReportListener.onReportImageInfoClickEvent(false, commentsItemBean, commentsItemBean.getItemIndex(), i);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TextView a;
        final /* synthetic */ CommentsItemBean b;

        c(TextView textView, CommentsItemBean commentsItemBean) {
            this.a = textView;
            this.b = commentsItemBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "19132114")) {
                ipChange.ipc$dispatch("19132114", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                LoginManager.k().v(EvaluateItemDataBinder.this.a);
            } else if (EvaluateItemDataBinder.this.a != null && EvaluateItemDataBinder.this.e != null && !TextUtils.isEmpty(this.a.getText().toString())) {
                EvaluateItemDataBinder.this.e.replyContentClick(true, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements OnPraiseViewClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.comment.listener.OnPraiseViewClickListener
        public void OnPraiseViewClick(boolean z, CommentsItemBean commentsItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "274677592")) {
                ipChange.ipc$dispatch("274677592", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
            } else if (EvaluateItemDataBinder.this.a != null && !EvaluateItemDataBinder.this.a.isFinishing()) {
                br.c("evaluate_praise", commentsItemBean);
                if (EvaluateItemDataBinder.this.d != null) {
                    EvaluateItemDataBinder.this.d.onReportPraiseViewClickEvent(z, commentsItemBean, commentsItemBean.getItemIndex());
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1656712397")) {
                ipChange.ipc$dispatch("-1656712397", new Object[]{this, view});
            } else if (view.getTag() != null) {
                int id = view.getId();
                if (id == R$id.uikit_damai_avatar || id == R$id.comment_userinfo_view) {
                    if (view.getTag() instanceof fk) {
                        EvaluateItemDataBinder.this.o((fk) view.getTag());
                    }
                } else if (id == R$id.comment_layout) {
                    if (view.getTag() instanceof fk) {
                        EvaluateItemDataBinder.this.p((fk) view.getTag());
                    }
                } else if (id == R$id.comment_detail_maincomment_more) {
                    if (view.getTag() instanceof fk) {
                        EvaluateItemDataBinder.this.m((fk) view.getTag());
                    }
                } else if (id == R$id.evaluate_project_info) {
                    if (view.getTag() instanceof fk) {
                        EvaluateItemDataBinder.this.h((fk) view.getTag());
                    }
                } else if (id == R$id.comment_detail_comment_delete && (view.getTag() instanceof fk) && EvaluateItemDataBinder.this.e != null) {
                    EvaluateItemDataBinder.this.e.deleteComment(((fk) view.getTag()).a());
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            fk fkVar;
            CommentsItemBean a2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "261561582")) {
                ipChange.ipc$dispatch("261561582", new Object[]{this, view});
            } else if (view.getTag() != null && (view.getTag() instanceof fk) && (a2 = (fkVar = (fk) view.getTag()).a()) != null && !TextUtils.isEmpty(a2.getUrl()) && EvaluateItemDataBinder.this.a != null && !EvaluateItemDataBinder.this.a.isFinishing()) {
                if (!fkVar.n()) {
                    if (EvaluateItemDataBinder.this.d != null) {
                        EvaluateItemDataBinder.this.d.onReportItemClickEvent(fkVar.o(), a2, a2.getItemIndex());
                    }
                    SimpleItemClickListener simpleItemClickListener = EvaluateItemDataBinder.this.f;
                    if (simpleItemClickListener != null) {
                        simpleItemClickListener.onSingleItemClick();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, a2.getCommentId());
                    bundle.putBoolean("isVEvaluate", fkVar.o());
                    DMNav.from(EvaluateItemDataBinder.this.a).withExtras(bundle).toUri(NavUri.b(gr.X));
                } else if (EvaluateItemDataBinder.this.e != null) {
                    EvaluateItemDataBinder.this.e.replyContentClick(true, a2);
                }
            }
        }
    }

    public EvaluateItemDataBinder(Activity activity, String str) {
        this.a = activity;
        this.b = new f();
        this.c = new e();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(fk fkVar) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527545162")) {
            ipChange.ipc$dispatch("-527545162", new Object[]{this, fkVar});
        } else if (fkVar != null && fkVar.a() != null) {
            EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
            if (evaluateItemUTReportListener != null) {
                evaluateItemUTReportListener.onReportTransferClickEvent(fkVar.o(), fkVar.a(), fkVar.a().getItemIndex());
            }
            if (fkVar.a().getItemType() != 0) {
                int n = n(this.i, fkVar.a());
                if (n == 1 && fkVar.a().getStoreInfo() != null) {
                    if (fkVar.a().getStoreInfo().getStoreId() == null) {
                        str = "";
                    } else {
                        str = String.valueOf(fkVar.a().getStoreInfo().getStoreId());
                    }
                    cn.damai.common.user.c.e().x(ik.I().J(fkVar.a().getCommentId(), null, null, fkVar.a().getStoreInfo().getStoreId(), 0));
                    if (!str.isEmpty()) {
                        DMNav from = DMNav.from(this.a);
                        from.toUri("damai://V1/ScriptPlay?storeId=" + str);
                    }
                } else if (n == 2 && fkVar.a().getScriptInfo() != null) {
                    cn.damai.common.user.c.e().x(ik.I().J(fkVar.a().getCommentId(), null, fkVar.a().getScriptInfo().getId(), null, 0));
                    if (!TextUtils.isEmpty(fkVar.a().getScriptInfo().getActionUrl())) {
                        DMNav.from(this.a).toUri(fkVar.a().getScriptInfo().getActionUrl());
                    }
                }
            } else if ("1".equals(fkVar.a().getTargetDataDO().getTargetDataType())) {
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, fkVar.a().getTargetDataDO().getTargetId());
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
            } else if ("2".equals(fkVar.a().getTargetDataDO().getTargetDataType())) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(RepertoireDetailFragment.REPERTOIREID, fkVar.a().getTargetDataDO().getTargetId());
                DMNav.from(this.a).withExtras(bundle2).toUri(NavUri.b(wz1.REPERTOITE));
            }
        }
    }

    private void k(boolean z, EvaluateItemViewHolder evaluateItemViewHolder) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-612768809")) {
            ipChange.ipc$dispatch("-612768809", new Object[]{this, Boolean.valueOf(z), evaluateItemViewHolder});
        } else if (evaluateItemViewHolder != null) {
            evaluateItemViewHolder.q.setVisibility(z ? 8 : 0);
            PraiseView praiseView = evaluateItemViewHolder.r;
            if (z) {
                i2 = 8;
            }
            praiseView.setVisibility(i2);
        }
    }

    private boolean l(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183039224")) {
            return ((Boolean) ipChange.ipc$dispatch("183039224", new Object[]{this, commentsItemBean})).booleanValue();
        } else if (commentsItemBean == null || TextUtils.isEmpty(commentsItemBean.getIsOwner())) {
            return false;
        } else {
            return Boolean.parseBoolean(commentsItemBean.getIsOwner());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(fk fkVar) {
        CommentsItemBean a2;
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922856990")) {
            ipChange.ipc$dispatch("1922856990", new Object[]{this, fkVar});
        } else if (fkVar != null && (a2 = fkVar.a()) != null && a2.getUserDO() != null && (activity = this.a) != null && !activity.isFinishing()) {
            Activity activity2 = this.a;
            if (activity2 instanceof DamaiBaseActivity) {
                DamaiBaseActivity damaiBaseActivity = (DamaiBaseActivity) activity2;
                EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
                if (evaluateItemUTReportListener != null) {
                    evaluateItemUTReportListener.onReportMoreInfoClickEvent(fkVar.o(), a2, a2.getItemIndex());
                }
                if (a2.getItemType() != 1 || a2.getStoreInfo() == null) {
                    CommentItemMoreUtil.j(damaiBaseActivity, "evaluateList", fkVar.e(), fkVar.f(), fkVar.g(), fkVar.d(), fkVar.h(), a2, l(a2), R$layout.new_evaluate_activity, a2.getItemType() != 2);
                } else {
                    CommentItemMoreUtil.j(damaiBaseActivity, "evaluateList", hk.b(a2.getStoreInfo().getStoreId()), a2.getStoreInfo().getStoreImgUrl(), a2.getStoreInfo().getStoreName(), a2.getStoreInfo().getDes(), "", a2, l(a2), R$layout.comment_detail_layout, false);
                }
            }
        }
    }

    private int n(int i2, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165725686")) {
            return ((Integer) ipChange.ipc$dispatch("165725686", new Object[]{this, Integer.valueOf(i2), commentsItemBean})).intValue();
        } else if (i2 == 0) {
            return commentsItemBean.getItemType();
        } else {
            if (i2 != 1 || commentsItemBean.getScriptInfo() == null) {
                return (i2 != 2 || commentsItemBean.getStoreInfo() == null) ? 0 : 1;
            }
            return 2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(fk fkVar) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141587125")) {
            ipChange.ipc$dispatch("-141587125", new Object[]{this, fkVar});
        } else if (fkVar != null) {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(this.a);
                return;
            }
            CommentsItemBean a2 = fkVar.a();
            if (a2 != null && !TextUtils.isEmpty(a2.getUrl()) && (activity = this.a) != null && !activity.isFinishing()) {
                if (fkVar.n()) {
                    EvaluateItemOtherListener evaluateItemOtherListener = this.e;
                    if (evaluateItemOtherListener != null) {
                        evaluateItemOtherListener.replyContentClick(false, a2);
                        return;
                    }
                    return;
                }
                EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
                if (evaluateItemUTReportListener != null) {
                    evaluateItemUTReportListener.onReportReplyClickEvent(fkVar.o(), a2, a2.getItemIndex());
                }
                Bundle bundle = new Bundle();
                bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, a2.getCommentId());
                bundle.putBoolean("isShowSoftInput", true);
                bundle.putBoolean("isVEvaluate", fkVar.o());
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.X));
            }
        }
    }

    private void t(NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226912380")) {
            ipChange.ipc$dispatch("-1226912380", new Object[]{this, nineGridlayout, commentsItemBean});
        } else if (commentsItemBean == null) {
            nineGridlayout.setVisibility(8);
        } else {
            b bVar = new b(commentsItemBean);
            List<CommentImageInfoBean> imageDOList = commentsItemBean.getImageDOList();
            NineImgUtil.a().b(this.a, (((int) up2.d(this.a)) - n42.a(this.a, 42.0f)) - ((int) this.a.getResources().getDimension(R$dimen.evaluate_item_margin_left)), true, nineGridlayout, commentsItemBean, imageDOList, bVar);
        }
    }

    private void v(CommentsItemBean commentsItemBean, RelativeLayout relativeLayout, TextView textView) {
        String str;
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432774032")) {
            ipChange.ipc$dispatch("-432774032", new Object[]{this, commentsItemBean, relativeLayout, textView});
            return;
        }
        List<CommentsItemBean> appendComments = commentsItemBean.getAppendComments();
        if (appendComments == null || appendComments.size() <= 0) {
            textView.setText("该内容已被删除");
            return;
        }
        CommentsItemBean commentsItemBean2 = appendComments.get(0);
        if (commentsItemBean2 == null) {
            re0.f().k(relativeLayout);
            return;
        }
        CommentUserDoBean userDO = commentsItemBean2.getUserDO();
        if (!TextUtils.isEmpty(userDO.getNickname())) {
            str = "回复@" + userDO.getNickname();
        } else {
            str = "";
        }
        List<CommentTextDoBean> textDOList = commentsItemBean2.getTextDOList();
        if (textDOList != null && textDOList.size() > 0 && (commentTextDoBean = textDOList.get(0)) != null && !TextUtils.isEmpty(commentTextDoBean.getValue())) {
            SpannableString spannableString = new SpannableString(str + commentTextDoBean.getValue());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#30AEFF")), 0, str.length(), 33);
            textView.setText(spannableString);
        }
        relativeLayout.setOnClickListener(new c(textView, commentsItemBean2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02e1  */
    public void i(final EvaluateItemViewHolder evaluateItemViewHolder, fk fkVar, int i2) {
        CommentsItemBean a2;
        float f2;
        String str;
        List<CommentTextDoBean> textDOList;
        int i3;
        String str2;
        ImageView imageView;
        TextView textView;
        String str3;
        IpChange ipChange = $ipChange;
        int i4 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1810975346")) {
            ipChange.ipc$dispatch("1810975346", new Object[]{this, evaluateItemViewHolder, fkVar, Integer.valueOf(i2)});
        } else if (fkVar != null && (a2 = fkVar.a()) != null) {
            EvaluateUserInfoUtil.a().b(a2.getUserDO(), evaluateItemViewHolder.t, evaluateItemViewHolder.j, evaluateItemViewHolder.a, evaluateItemViewHolder.k, a2.getItemType());
            if (fkVar.n()) {
                if (fkVar.i() == 2) {
                    re0.f().m(evaluateItemViewHolder.o);
                    v(a2, evaluateItemViewHolder.o, evaluateItemViewHolder.i);
                } else {
                    re0.f().k(evaluateItemViewHolder.o);
                }
                if (l(a2)) {
                    re0.f().m(evaluateItemViewHolder.m);
                    evaluateItemViewHolder.m.setTag(fkVar);
                    evaluateItemViewHolder.m.setOnClickListener(this.c);
                } else {
                    re0.f().k(evaluateItemViewHolder.m);
                }
                evaluateItemViewHolder.c.setTextSize(1, 14.0f);
                evaluateItemViewHolder.c.setMaxLines(Integer.MAX_VALUE);
                evaluateItemViewHolder.c.setEllipsize(null);
            } else {
                re0.f().k(evaluateItemViewHolder.o);
                re0.f().k(evaluateItemViewHolder.m);
                evaluateItemViewHolder.c.setTextSize(1, 14.0f);
                evaluateItemViewHolder.c.setMaxLines(5);
                evaluateItemViewHolder.c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.g) {
                    evaluateItemViewHolder.e.setOnClickListener(new a(this, evaluateItemViewHolder));
                }
            }
            String str4 = "";
            if (a2.getGradeDOList() != null && a2.getGradeDOList().size() > 0) {
                int i5 = 0;
                while (true) {
                    if (i5 >= a2.getGradeDOList().size()) {
                        break;
                    }
                    CommentGradeBean commentGradeBean = a2.getGradeDOList().get(i5);
                    if (commentGradeBean == null || commentGradeBean.type != 1) {
                        i5++;
                    } else {
                        str = commentGradeBean.valueDesc;
                        if (!TextUtils.isEmpty(commentGradeBean.value)) {
                            f2 = Float.parseFloat(commentGradeBean.value) / 2.0f;
                        }
                    }
                }
                evaluateItemViewHolder.h.setText(str);
                if (f2 <= 3.0f) {
                    evaluateItemViewHolder.h.setTextColor(Color.parseColor("#FF8F3F"));
                } else {
                    evaluateItemViewHolder.h.setTextColor(Color.parseColor("#9C9CA5"));
                }
                if (a2.getItemType() != 1) {
                    evaluateItemViewHolder.g.setStarSize(s50.a(this.a, 11.0f));
                    evaluateItemViewHolder.g.setStarDistance(s50.a(this.a, 1.5f));
                    evaluateItemViewHolder.g.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
                } else {
                    evaluateItemViewHolder.g.setStarSize(s50.a(this.a, 9.0f));
                    evaluateItemViewHolder.g.setStarDistance(s50.a(this.a, 1.0f));
                    evaluateItemViewHolder.g.setMarkDrawable(R$drawable.rating_fill, R$drawable.rating_empty);
                }
                if (f2 != -1.0f) {
                    re0.f().k(evaluateItemViewHolder.g);
                } else {
                    re0.f().m(evaluateItemViewHolder.g);
                    evaluateItemViewHolder.g.setStarMark(f2);
                }
                a2.setItemIndex(fkVar.c());
                a2.setBrilliant(fkVar.k());
                evaluateItemViewHolder.p.setTag(fkVar);
                evaluateItemViewHolder.p.setOnClickListener(this.c);
                evaluateItemViewHolder.t.setTag(fkVar);
                evaluateItemViewHolder.t.setOnClickListener(this.c);
                textDOList = a2.getTextDOList();
                if (textDOList != null || textDOList.size() <= 0) {
                    evaluateItemViewHolder.c.setVisibility(4);
                    evaluateItemViewHolder.c.setText(str4);
                } else {
                    CommentTextDoBean commentTextDoBean = textDOList.get(0);
                    if (commentTextDoBean == null || TextUtils.isEmpty(commentTextDoBean.getValue())) {
                        evaluateItemViewHolder.c.setVisibility(4);
                        evaluateItemViewHolder.c.setText(str4);
                    } else {
                        evaluateItemViewHolder.c.setVisibility(0);
                        evaluateItemViewHolder.c.setText(commentTextDoBean.getValue());
                        if (!TextUtils.isEmpty(commentTextDoBean.getValue())) {
                            evaluateItemViewHolder.c.setVisibility(0);
                            evaluateItemViewHolder.c.post(new Runnable() {
                                /* class cn.damai.evaluate.ui.item.EvaluateItemDataBinder.AnonymousClass2 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    TextView textView;
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-1483933984")) {
                                        ipChange.ipc$dispatch("-1483933984", new Object[]{this});
                                        return;
                                    }
                                    EvaluateItemViewHolder evaluateItemViewHolder = evaluateItemViewHolder;
                                    if (evaluateItemViewHolder != null && (textView = evaluateItemViewHolder.c) != null && textView.getLayout() != null) {
                                        if (evaluateItemViewHolder.c.getLayout().getEllipsisCount(evaluateItemViewHolder.c.getLineCount() - 1) <= 0 || !EvaluateItemDataBinder.this.g) {
                                            evaluateItemViewHolder.e.setVisibility(8);
                                            return;
                                        }
                                        evaluateItemViewHolder.e.setText("查看全文");
                                        evaluateItemViewHolder.e.setVisibility(0);
                                    }
                                }
                            });
                        } else {
                            evaluateItemViewHolder.c.setVisibility(8);
                            evaluateItemViewHolder.e.setVisibility(8);
                        }
                        fkVar.B(a2.isFeature());
                        evaluateItemViewHolder.n.setTag(fkVar);
                        evaluateItemViewHolder.n.setOnClickListener(this.b);
                    }
                }
                evaluateItemViewHolder.s.setTag(fkVar);
                evaluateItemViewHolder.s.setVisibility(0);
                t(evaluateItemViewHolder.s, a2);
                if (this.h != 0) {
                    evaluateItemViewHolder.b.setVisibility(0);
                    evaluateItemViewHolder.y.setVisibility(0);
                    evaluateItemViewHolder.f.setVisibility(8);
                    TextView textView2 = evaluateItemViewHolder.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append(a2.getGmtDisplay());
                    sb.append(" ");
                    sb.append(TextUtils.isEmpty(a2.getCityName()) ? str4 : a2.getCityName());
                    textView2.setText(sb.toString());
                } else {
                    evaluateItemViewHolder.b.setVisibility(8);
                    evaluateItemViewHolder.y.setVisibility(8);
                    evaluateItemViewHolder.f.setVisibility(0);
                    if (fkVar.o) {
                        evaluateItemViewHolder.f.setText(a2.getDateAndPublishCity());
                    } else {
                        evaluateItemViewHolder.f.setText(a2.getGmtDisplay());
                    }
                }
                i3 = Integer.parseInt(a2.getReplyTotal());
                evaluateItemViewHolder.d.setText(i3 <= 0 ? hk.a(i3) : "回复");
                evaluateItemViewHolder.q.setTag(fkVar);
                evaluateItemViewHolder.q.setOnClickListener(this.c);
                evaluateItemViewHolder.r.setShowAnim(true);
                evaluateItemViewHolder.r.setData(a2, fkVar.o(), fkVar.c() - 1);
                evaluateItemViewHolder.r.setOnPraiseViewClickListener(this.k);
                if (fkVar.m() || (fkVar.e() == 0 && a2.getItemType() != 2 && (a2.getStoreInfo() == null || a2.getItemType() != 1))) {
                    evaluateItemViewHolder.l.setVisibility(8);
                } else {
                    evaluateItemViewHolder.l.setTag(fkVar);
                    evaluateItemViewHolder.l.setOnClickListener(this.c);
                    evaluateItemViewHolder.l.setVisibility(0);
                }
                DMTagView dMTagView = evaluateItemViewHolder.z;
                StringBuilder sb2 = new StringBuilder();
                evaluateItemViewHolder.u.setVisibility(0);
                if (a2.getItemType() == 0) {
                    evaluateItemViewHolder.u.setTag(fkVar);
                    evaluateItemViewHolder.u.setOnClickListener(this.c);
                    int n = n(this.i, a2);
                    if (n == 1 && a2.getStoreInfo() != null) {
                        ik.I().g(evaluateItemViewHolder.u, null, a2.getStoreInfo().getStoreId(), 0);
                        String storeImgUrl = a2.getStoreInfo().getStoreImgUrl();
                        str3 = a2.getStoreInfo().getStoreName();
                        sb2.append(a2.getStoreInfo().getDes());
                        str4 = storeImgUrl;
                    } else if (n != 2 || a2.getScriptInfo() == null) {
                        str3 = str4;
                        i4 = -1;
                    } else {
                        ik.I().g(evaluateItemViewHolder.u, a2.getScriptInfo().getId(), null, 0);
                        String posterUrl = a2.getScriptInfo().getPosterUrl();
                        str3 = a2.getScriptInfo().getName();
                        sb2.append(a2.getScriptInfo().getDes());
                        str4 = posterUrl;
                        i4 = 0;
                    }
                    DmInfo dmInfo = a2.getDmInfo();
                    if (dmInfo == null || this.i == 0) {
                        dMTagView.setVisibility(8);
                    } else {
                        dMTagView.setVisibility(0);
                        dMTagView.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName);
                        dMTagView.setDmTagData(dmInfo.dmTags);
                    }
                    str2 = str3;
                } else if (!fkVar.l() || a2.getTargetDataDO() == null) {
                    if (evaluateItemViewHolder.u.getVisibility() == 0) {
                        evaluateItemViewHolder.u.setVisibility(8);
                    }
                    str2 = str4;
                    i4 = -1;
                } else {
                    evaluateItemViewHolder.u.setTag(fkVar);
                    evaluateItemViewHolder.u.setOnClickListener(this.c);
                    str4 = a2.getTargetDataDO().getTargetImg();
                    str2 = a2.getTargetDataDO().getTargetName();
                    if ("1".equals(a2.getTargetDataDO().getTargetDataType()) && a2.getItemType() == 0) {
                        if (!TextUtils.isEmpty(a2.getTargetDataDO().getTargetCityName())) {
                            sb2.append(a2.getTargetDataDO().getTargetCityName());
                        }
                        if (!TextUtils.isEmpty(a2.getTargetDataDO().getTargetShowTime())) {
                            if (!TextUtils.isEmpty(sb2.toString())) {
                                sb2.append(" | ");
                            }
                            sb2.append(a2.getTargetDataDO().getTargetShowTime());
                        }
                        if (!TextUtils.isEmpty(a2.getTargetDataDO().getTargetPlace())) {
                            if (!TextUtils.isEmpty(sb2.toString())) {
                                sb2.append(" | ");
                            }
                            sb2.append(a2.getTargetDataDO().getTargetPlace());
                        }
                    } else if ("2".equals(a2.getTargetDataDO().getTargetDataType()) && !TextUtils.isEmpty(a2.getTargetDataDO().getTargetDesc())) {
                        sb2.append(a2.getTargetDataDO().getTargetDesc());
                    }
                    dMTagView.setVisibility(8);
                    evaluateItemViewHolder.u.setData(str4, str2, sb2.toString(), 0);
                    i4 = 0;
                }
                if (i4 != -1) {
                    evaluateItemViewHolder.u.setVisibility(8);
                } else {
                    evaluateItemViewHolder.u.setData(str4, str2, sb2.toString(), i4);
                }
                if (!a2.isFeature()) {
                    evaluateItemViewHolder.v.setVisibility(0);
                } else {
                    evaluateItemViewHolder.v.setVisibility(8);
                }
                imageView = evaluateItemViewHolder.w;
                if (imageView != null) {
                    imageView.setVisibility(a2.isSpoilerType() ? 0 : 8);
                }
                textView = evaluateItemViewHolder.A;
                if (textView != null) {
                    textView.setVisibility(a2.hasPlayed ? 0 : 8);
                }
                k(a2.isHideInteraction(), evaluateItemViewHolder);
                if (!this.j) {
                    if (evaluateItemViewHolder.x.getVisibility() == 0) {
                        evaluateItemViewHolder.x.setVisibility(8);
                        return;
                    }
                    return;
                } else if (evaluateItemViewHolder.x.getVisibility() == 8) {
                    evaluateItemViewHolder.x.setVisibility(0);
                    return;
                } else {
                    return;
                }
            }
            str = str4;
            f2 = -1.0f;
            evaluateItemViewHolder.h.setText(str);
            if (f2 <= 3.0f) {
            }
            if (a2.getItemType() != 1) {
            }
            if (f2 != -1.0f) {
            }
            a2.setItemIndex(fkVar.c());
            a2.setBrilliant(fkVar.k());
            evaluateItemViewHolder.p.setTag(fkVar);
            evaluateItemViewHolder.p.setOnClickListener(this.c);
            evaluateItemViewHolder.t.setTag(fkVar);
            evaluateItemViewHolder.t.setOnClickListener(this.c);
            textDOList = a2.getTextDOList();
            if (textDOList != null) {
            }
            evaluateItemViewHolder.c.setVisibility(4);
            evaluateItemViewHolder.c.setText(str4);
            evaluateItemViewHolder.s.setTag(fkVar);
            evaluateItemViewHolder.s.setVisibility(0);
            t(evaluateItemViewHolder.s, a2);
            if (this.h != 0) {
            }
            try {
                i3 = Integer.parseInt(a2.getReplyTotal());
            } catch (Exception e2) {
                e2.printStackTrace();
                i3 = 0;
            }
            evaluateItemViewHolder.d.setText(i3 <= 0 ? hk.a(i3) : "回复");
            evaluateItemViewHolder.q.setTag(fkVar);
            evaluateItemViewHolder.q.setOnClickListener(this.c);
            evaluateItemViewHolder.r.setShowAnim(true);
            evaluateItemViewHolder.r.setData(a2, fkVar.o(), fkVar.c() - 1);
            evaluateItemViewHolder.r.setOnPraiseViewClickListener(this.k);
            if (fkVar.m()) {
            }
            evaluateItemViewHolder.l.setVisibility(8);
            DMTagView dMTagView2 = evaluateItemViewHolder.z;
            StringBuilder sb22 = new StringBuilder();
            evaluateItemViewHolder.u.setVisibility(0);
            if (a2.getItemType() == 0) {
            }
            if (i4 != -1) {
            }
            if (!a2.isFeature()) {
            }
            imageView = evaluateItemViewHolder.w;
            if (imageView != null) {
            }
            textView = evaluateItemViewHolder.A;
            if (textView != null) {
            }
            k(a2.isHideInteraction(), evaluateItemViewHolder);
            if (!this.j) {
            }
        }
    }

    public void j(EvaluateItemViewHolder evaluateItemViewHolder, fk fkVar, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305690321")) {
            ipChange.ipc$dispatch("305690321", new Object[]{this, evaluateItemViewHolder, fkVar, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (i2 == 0) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_first_bg);
            evaluateItemViewHolder.x.setVisibility(0);
        } else if (i2 == i3 - 1) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_last_bg);
            evaluateItemViewHolder.x.setVisibility(4);
        } else {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_bg);
            evaluateItemViewHolder.x.setVisibility(0);
        }
        if (i2 == 0 && i3 == 1) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_only_bg);
            evaluateItemViewHolder.x.setVisibility(4);
        }
        i(evaluateItemViewHolder, fkVar, i2);
    }

    public void o(fk fkVar) {
        CommentsItemBean a2;
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106028855")) {
            ipChange.ipc$dispatch("-2106028855", new Object[]{this, fkVar});
        } else if (fkVar != null && (a2 = fkVar.a()) != null && a2.getUserDO() != null && (activity = this.a) != null && !activity.isFinishing()) {
            EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
            if (evaluateItemUTReportListener != null) {
                evaluateItemUTReportListener.onReportUserInfoClickEvent(fkVar.o(), a2, a2.getItemIndex());
            }
            SoftInputUtils.a(this.a);
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, a2.getUserDO().getDamaiUserId());
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
        }
    }

    public void q(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35721860")) {
            ipChange.ipc$dispatch("-35721860", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h = i2;
    }

    public void r(EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806089517")) {
            ipChange.ipc$dispatch("-1806089517", new Object[]{this, evaluateItemUTReportListener});
            return;
        }
        this.d = evaluateItemUTReportListener;
    }

    public void s(EvaluateItemOtherListener evaluateItemOtherListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292858300")) {
            ipChange.ipc$dispatch("292858300", new Object[]{this, evaluateItemOtherListener});
            return;
        }
        this.e = evaluateItemOtherListener;
    }

    public void u(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331119002")) {
            ipChange.ipc$dispatch("-1331119002", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.g = z;
    }

    public EvaluateItemDataBinder(Activity activity, String str, int i2) {
        this.a = activity;
        this.i = i2;
        this.b = new f();
        this.c = new e();
    }

    public EvaluateItemDataBinder(Activity activity) {
        this.a = activity;
        this.b = new f();
        this.c = new e();
    }

    public EvaluateItemDataBinder(Activity activity, int i2) {
        this.a = activity;
        this.i = i2;
        this.b = new f();
        this.c = new e();
    }
}

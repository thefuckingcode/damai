package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.View;
import cn.damai.comment.bean.CommentSyncCircleBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.fk;
import tb.ln2;

/* compiled from: Taobao */
public class ProjectEvaluateViewHolder extends EvaluateItemViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context B;
    private long C;
    private String D;
    private String E;
    private EvaluateItemDataBinder F;
    private fk G;
    private CommentsItemBean H;
    private int I;
    private EvaluateItemDataBinder.EvaluateItemUTReportListener J;

    /* compiled from: Taobao */
    public class a implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2037967769")) {
                ipChange.ipc$dispatch("2037967769", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().r0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1044528682")) {
                ipChange.ipc$dispatch("-1044528682", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().m0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1021160506")) {
                ipChange.ipc$dispatch("-1021160506", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().q0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "266220200")) {
                ipChange.ipc$dispatch("266220200", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().o0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-109511735")) {
                ipChange.ipc$dispatch("-109511735", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().s0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            List<CommentSyncCircleBean> syncCircle;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-333043106")) {
                ipChange.ipc$dispatch("-333043106", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null && (syncCircle = ProjectEvaluateViewHolder.this.H.getSyncCircle()) != null && !syncCircle.isEmpty()) {
                c.e().x(ln2.r().l0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), syncCircle.get(0).getCircleId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "831949950")) {
                ipChange.ipc$dispatch("831949950", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().n0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033163888")) {
                ipChange.ipc$dispatch("-2033163888", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(ln2.r().t0(d20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }
    }

    public ProjectEvaluateViewHolder(Context context, long j, String str, String str2) {
        super((DamaiBaseActivity) context);
        this.B = context;
        this.C = j;
        this.D = str;
        this.E = str2;
        h();
        g();
        i();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025736813")) {
            return (String) ipChange.ipc$dispatch("-2025736813", new Object[]{this});
        }
        CommentUserDoBean userDO = this.H.getUserDO();
        return userDO != null ? userDO.getDamaiUserId() : "";
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777157074")) {
            ipChange.ipc$dispatch("1777157074", new Object[]{this});
            return;
        }
        this.J = new a();
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101134422")) {
            ipChange.ipc$dispatch("1101134422", new Object[]{this});
            return;
        }
        this.F = new EvaluateItemDataBinder((DamaiBaseActivity) this.B, String.valueOf(this.C));
        fk fkVar = new fk(0);
        this.G = fkVar;
        fkVar.v(this.C);
        this.G.x(this.D);
        this.G.w(this.E);
        this.itemView.setBackgroundColor(-1);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123468515")) {
            ipChange.ipc$dispatch("2123468515", new Object[]{this});
            return;
        }
        this.F.r(this.J);
    }

    public void f(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588620965")) {
            ipChange.ipc$dispatch("-588620965", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.I = projectDataHolder.getCommentPosition();
            CommentsItemBean moduleComment = projectDataHolder.getModuleComment();
            this.H = moduleComment;
            if (moduleComment != null) {
                this.G.q(moduleComment);
                this.G.p(false);
                this.F.i(this, this.G, this.I);
                ln2 r = ln2.r();
                View view = this.itemView;
                r.E1(view, this.C + "", this.H.getCommentId(), this.I);
            }
        }
    }
}

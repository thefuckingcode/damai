package cn.damai.comment.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.issue.net.CommentGradeTagBean;
import com.alibaba.pictures.bricks.view.DMRatingBar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ek;
import tb.g91;

/* compiled from: Taobao */
public class DMCommentSubItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private GradeChangeLister gradeChangeLister;
    private Context mContext;
    private int mGrades;
    private DMRatingBar.OnStarChangeListener mOnStarChangeListener = new a();
    private cn.damai.uikit.view.DMRatingBar mSubitemDMRatingBar;
    private View parent;
    private TextView subitemCommentTip;
    private CommentGradeTagBean tagBean;

    /* compiled from: Taobao */
    public interface GradeChangeLister {
        void gradeChange();
    }

    /* compiled from: Taobao */
    public class a implements DMRatingBar.OnStarChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onEventActionUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "215616187")) {
                ipChange.ipc$dispatch("215616187", new Object[]{this});
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onStarChange(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1440714270")) {
                ipChange.ipc$dispatch("1440714270", new Object[]{this, Float.valueOf(f)});
                return;
            }
            DMCommentSubItemView.this.mGrades = (int) (f * 2.0f);
            g91.c("DMCommentSubItemView", " grade = " + DMCommentSubItemView.this.mGrades);
            DMCommentSubItemView.this.mSubitemDMRatingBar.setMarkDrawable(ek.a((float) DMCommentSubItemView.this.mGrades));
            if (DMCommentSubItemView.this.gradeChangeLister != null) {
                DMCommentSubItemView.this.gradeChangeLister.gradeChange();
            }
        }
    }

    public DMCommentSubItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033721825")) {
            ipChange.ipc$dispatch("2033721825", new Object[]{this});
            return;
        }
        setGravity(16);
        setOrientation(0);
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.issue_subitem_layout, this);
        this.parent = inflate;
        this.subitemCommentTip = (TextView) inflate.findViewById(R$id.issue_subitem_comment_tip);
        cn.damai.uikit.view.DMRatingBar dMRatingBar = (cn.damai.uikit.view.DMRatingBar) this.parent.findViewById(R$id.issue_subitem_evaluate_grade_view);
        this.mSubitemDMRatingBar = dMRatingBar;
        dMRatingBar.setOnStarChangeListener(this.mOnStarChangeListener);
        this.mSubitemDMRatingBar.setMinMark(1.0f);
    }

    public int getGrades() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2074247819")) {
            return this.mGrades;
        }
        return ((Integer) ipChange.ipc$dispatch("-2074247819", new Object[]{this})).intValue();
    }

    public CommentGradeTagBean getTagBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1630769100")) {
            return this.tagBean;
        }
        return (CommentGradeTagBean) ipChange.ipc$dispatch("-1630769100", new Object[]{this});
    }

    public void setData(CommentGradeTagBean commentGradeTagBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037563928")) {
            ipChange.ipc$dispatch("-2037563928", new Object[]{this, commentGradeTagBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (commentGradeTagBean != null) {
            this.tagBean = commentGradeTagBean;
            if (!TextUtils.isEmpty(commentGradeTagBean.getDesc())) {
                this.subitemCommentTip.setVisibility(0);
                this.subitemCommentTip.setText(commentGradeTagBean.getDesc());
            } else {
                this.subitemCommentTip.setVisibility(8);
            }
            float floatValue = TextUtils.isEmpty(commentGradeTagBean.getValue()) ? 0.0f : Float.valueOf(commentGradeTagBean.getValue()).floatValue();
            this.mSubitemDMRatingBar.setVisibility(0);
            this.mSubitemDMRatingBar.setMarkDrawable(i, i2);
            if (floatValue != 0.0f) {
                this.mSubitemDMRatingBar.setStarMark(floatValue / 2.0f);
            } else {
                this.mSubitemDMRatingBar.setStarMark(0.0f);
            }
        }
    }

    public void setGradeChangeLister(GradeChangeLister gradeChangeLister2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589530502")) {
            ipChange.ipc$dispatch("1589530502", new Object[]{this, gradeChangeLister2});
            return;
        }
        this.gradeChangeLister = gradeChangeLister2;
    }
}

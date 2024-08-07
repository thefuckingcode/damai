package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.view.DMRatingBar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.rr;
import tb.v50;

/* compiled from: Taobao */
public class ProjectEvaluateMineViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private RelativeLayout b;
    private TextView c;
    private DMRatingBar d;
    private TextView e;
    private OnEvaluateMineListener f;
    private CommentsItemBean g;
    private boolean h;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1167477671")) {
                ipChange.ipc$dispatch("1167477671", new Object[]{this, view});
            } else if (ProjectEvaluateMineViewHolder.this.f != null && ProjectEvaluateMineViewHolder.this.g != null) {
                String commentId = ProjectEvaluateMineViewHolder.this.g.getCommentId();
                String url = ProjectEvaluateMineViewHolder.this.g.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    ProjectEvaluateMineViewHolder.this.f.onClick(view, commentId, url);
                }
            }
        }
    }

    public ProjectEvaluateMineViewHolder(Context context, OnEvaluateMineListener onEvaluateMineListener, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_my_evaluate_layout, viewGroup, false));
        this.a = context;
        this.f = onEvaluateMineListener;
        d();
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163647028")) {
            ipChange.ipc$dispatch("163647028", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.project_item_my_evaluate_rv);
        this.b = relativeLayout;
        rr.b(relativeLayout, -1, v50.a(this.a, 4.0f), Color.parseColor("#0D000000"), v50.a(this.a, 4.0f), 0, v50.a(this.a, 1.0f));
        this.c = (TextView) this.itemView.findViewById(R$id.project_item_my_evaluate_time_tv);
        this.d = (DMRatingBar) this.itemView.findViewById(R$id.project_item_my_evaluate_rating_level);
        this.e = (TextView) this.itemView.findViewById(R$id.project_item_my_evaluate_score_tv);
        this.itemView.setOnClickListener(new a());
    }

    public void c(ProjectDataHolder projectDataHolder) {
        CommentGradeBean commentGradeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1753868082")) {
            ipChange.ipc$dispatch("-1753868082", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            if (!projectDataHolder.isModuleDataBind()) {
                projectDataHolder.setModuleDataBind(true);
                this.h = false;
            }
            if (!this.h) {
                this.h = true;
                CommentsItemBean userCommentItemBean = projectDataHolder.getUserCommentItemBean();
                this.g = userCommentItemBean;
                if (userCommentItemBean != null) {
                    String gmtDisplay = userCommentItemBean.getGmtDisplay();
                    if (!TextUtils.isEmpty(gmtDisplay)) {
                        this.c.setText(gmtDisplay);
                    } else {
                        this.c.setText("");
                    }
                    List<CommentGradeBean> gradeDOList = this.g.getGradeDOList();
                    if (gradeDOList != null && !gradeDOList.isEmpty() && (commentGradeBean = gradeDOList.get(0)) != null) {
                        float f2 = 0.0f;
                        try {
                            f2 = Float.parseFloat(commentGradeBean.value);
                        } catch (NumberFormatException unused) {
                        }
                        this.d.setStarMark(f2 / 2.0f);
                        this.e.setText(commentGradeBean.valueDesc);
                    }
                }
            }
        }
    }
}

package cn.damai.tetris.component.star.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.net.DoTaskResult;
import cn.damai.tetris.component.star.net.FinishTaskRequest;
import cn.damai.tetris.component.star.net.FinishTaskResponse;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.gr;
import tb.jl1;
import tb.ug0;
import tb.vg0;
import tb.wg0;
import tb.xg0;
import tb.yg0;

/* compiled from: Taobao */
public class FansRankingViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private RoundImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private DMIconFontTextView g;
    private View h;
    private ConstraintLayout i;
    private TextView j;
    private TextView k;
    private ConstraintLayout l;
    private TextView m;
    private TextView n;
    private ConstraintLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private View s;
    private FansRankingBean t;
    private ITaskHandler u;
    private Context v;
    BasePresenter w;

    /* compiled from: Taobao */
    public interface ITaskHandler {
        void doShareTask();

        LifecycleOwner getLifecycleOwner();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1156260664")) {
                ipChange.ipc$dispatch("-1156260664", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                DMNav.from(FansRankingViewHolder.this.v).forResult(100).withExtras(new Bundle()).toUri(gr.f());
                FansRankingViewHolder.this.w.userTrackClick("login", true);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FansRankingBean a;

        b(FansRankingBean fansRankingBean) {
            this.a = fansRankingBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "955029705")) {
                ipChange.ipc$dispatch("955029705", new Object[]{this, view});
                return;
            }
            DMNav.from(FansRankingViewHolder.this.v).toUri(this.a.rankingDetailUrl);
            FansRankingViewHolder.this.w.userTrackClick("rankdetail", true);
        }
    }

    public FansRankingViewHolder(View view, ITaskHandler iTaskHandler, Context context, BasePresenter basePresenter) {
        this.s = view;
        this.v = context;
        this.u = iTaskHandler;
        this.r = (TextView) view.findViewById(R$id.join_vip_button);
        this.q = (TextView) view.findViewById(R$id.task3_desc);
        this.p = (TextView) view.findViewById(R$id.task3_name);
        this.o = (ConstraintLayout) view.findViewById(R$id.task3_container);
        this.n = (TextView) view.findViewById(R$id.task2_desc);
        this.m = (TextView) view.findViewById(R$id.task2_name);
        this.l = (ConstraintLayout) view.findViewById(R$id.task2_container);
        this.k = (TextView) view.findViewById(R$id.task1_desc);
        this.j = (TextView) view.findViewById(R$id.task1_name);
        this.i = (ConstraintLayout) view.findViewById(R$id.task1_container);
        this.h = view.findViewById(R$id.layout_shouhu_detail);
        this.g = (DMIconFontTextView) view.findViewById(R$id.youjiantou);
        this.f = (TextView) view.findViewById(R$id.love_value);
        this.d = (TextView) view.findViewById(R$id.name);
        this.e = (TextView) view.findViewById(R$id.unlogin_name);
        this.c = (RoundImageView) view.findViewById(R$id.user_head_pic);
        this.a = (TextView) view.findViewById(R$id.rank_value);
        this.b = (TextView) view.findViewById(R$id.tv_all_click_toall);
        this.w = basePresenter;
    }

    private void g(int i2) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439648874")) {
            ipChange.ipc$dispatch("1439648874", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        FansRankingBean fansRankingBean = this.t;
        if (fansRankingBean != null && (textView = this.f) != null) {
            fansRankingBean.score += (long) i2;
            textView.setText(this.t.score + "");
        }
    }

    private void h(FansRankingBean.TaskBean taskBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015481255")) {
            ipChange.ipc$dispatch("1015481255", new Object[]{this, taskBean});
        } else if (this.t != null && taskBean != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", taskBean.name);
            if (this.w.getSection().getTrackInfo().getArgsMap() != null) {
                hashMap.putAll(this.w.getSection().getTrackInfo().getArgsMap());
            }
            int i2 = taskBean.type;
            if (i2 == 1) {
                i(taskBean);
                this.w.userTrackClick("guard_0", hashMap, false);
            } else if (i2 == 2) {
                if (taskBean.applyStatus != 0) {
                    this.u.doShareTask();
                } else {
                    i(taskBean);
                }
                this.w.userTrackClick("guard_1", hashMap, false);
            } else if (i2 == 3) {
                DMNav.from(this.v).forResult(100).toUri(taskBean.url);
                this.w.userTrackClick("guard_2", hashMap, true);
            }
        }
    }

    private void i(FansRankingBean.TaskBean taskBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217836609")) {
            ipChange.ipc$dispatch("217836609", new Object[]{this, taskBean});
            return;
        }
        FinishTaskRequest finishTaskRequest = new FinishTaskRequest();
        finishTaskRequest.taskId = taskBean.taskId;
        finishTaskRequest.dataId = taskBean.dataId;
        if (this.u != null) {
            j(finishTaskRequest).observe(this.u.getLifecycleOwner(), new yg0(this, taskBean));
        }
    }

    private MutableLiveData<FinishTaskResponse> j(FinishTaskRequest finishTaskRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261247238")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1261247238", new Object[]{this, finishTaskRequest});
        }
        final MutableLiveData<FinishTaskResponse> mutableLiveData = new MutableLiveData<>();
        finishTaskRequest.request(new DMMtopRequestListener<DoTaskResult>(DoTaskResult.class) {
            /* class cn.damai.tetris.component.star.view.FansRankingViewHolder.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "221217072")) {
                    ipChange.ipc$dispatch("221217072", new Object[]{this, str, str2});
                    return;
                }
                FinishTaskResponse finishTaskResponse = new FinishTaskResponse();
                finishTaskResponse.errorCode = str;
                finishTaskResponse.errorMsg = str2;
                mutableLiveData.setValue(finishTaskResponse);
            }

            public void onSuccess(DoTaskResult doTaskResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "804424421")) {
                    ipChange.ipc$dispatch("804424421", new Object[]{this, doTaskResult});
                    return;
                }
                FinishTaskResponse finishTaskResponse = new FinishTaskResponse();
                finishTaskResponse.data = doTaskResult;
                mutableLiveData.setValue(finishTaskResponse);
            }
        });
        return mutableLiveData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(FansRankingBean.TaskBean taskBean, FinishTaskResponse finishTaskResponse) {
        DoTaskResult doTaskResult;
        DoTaskResult.TaskDetail taskDetail;
        DoTaskResult doTaskResult2;
        DoTaskResult.TaskDetail taskDetail2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841017146")) {
            ipChange.ipc$dispatch("841017146", new Object[]{this, taskBean, finishTaskResponse});
        } else if (taskBean.isGuardTask()) {
            if (finishTaskResponse != null && (doTaskResult2 = finishTaskResponse.data) != null && (taskDetail2 = doTaskResult2.taskDetail) != null && taskDetail2.applyStatus != 0) {
                taskBean.canClick = false;
                p(doTaskResult2.totalAssetsNum);
                this.k.setText("今日已完成");
                this.i.setEnabled(false);
                this.i.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
            } else if (!TextUtils.isEmpty(finishTaskResponse.errorMsg)) {
                ToastUtil.i(finishTaskResponse.errorMsg);
            }
        } else if (!taskBean.isShareTask()) {
        } else {
            if (finishTaskResponse != null && (doTaskResult = finishTaskResponse.data) != null && (taskDetail = doTaskResult.taskDetail) != null) {
                int i2 = taskDetail.applyStatus;
                if (i2 != 0) {
                    taskBean.canClick = false;
                    taskBean.applyStatus = i2;
                    this.n.setText("今日已完成");
                }
                if (this.u != null) {
                    g(finishTaskResponse.data.totalAssetsNum);
                    this.u.doShareTask();
                }
            } else if (!TextUtils.isEmpty(finishTaskResponse.errorMsg)) {
                ToastUtil.i(finishTaskResponse.errorMsg);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(int i2, DialogInterface dialogInterface, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744456559")) {
            ipChange.ipc$dispatch("-1744456559", new Object[]{this, Integer.valueOf(i2), dialogInterface, Integer.valueOf(i3)});
            return;
        }
        g(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545621251")) {
            ipChange.ipc$dispatch("-545621251", new Object[]{this, Integer.valueOf(i2), view});
            return;
        }
        g(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(FansRankingBean fansRankingBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134897937")) {
            ipChange.ipc$dispatch("1134897937", new Object[]{this, fansRankingBean, view});
        } else if (!LoginManager.k().q()) {
            DMNav.from(this.v).forResult(100).withExtras(new Bundle()).toUri(gr.f());
        } else {
            DMNav.from(this.v).forResult(100).toUri(fansRankingBean.button.destination);
            this.w.userTrackClick("goto_artist_vip", true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(FansRankingBean fansRankingBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051254160")) {
            ipChange.ipc$dispatch("-2051254160", new Object[]{this, fansRankingBean, view});
        } else if (!LoginManager.k().q()) {
            DMNav.from(this.v).forResult(100).withExtras(new Bundle()).toUri(gr.f());
        } else if (fansRankingBean.artistVip || this.r.getVisibility() != 0) {
            FansRankingBean.TaskBean taskBean = (FansRankingBean.TaskBean) view.getTag();
            if (taskBean != null) {
                h(taskBean);
            }
        } else {
            ToastUtil.f("您还不是VIP会员哦");
        }
    }

    private void p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129766434")) {
            ipChange.ipc$dispatch("-129766434", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        Context context = this.v;
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this.v);
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS);
            dMThemeDialog.f(false);
            dMThemeDialog.o("守护成功");
            if (i2 > 0) {
                String str = jl1.PLUS + i2;
                SpannableString spannableString = new SpannableString(str + "守护值");
                spannableString.setSpan(new ForegroundColorSpan((int) SupportMenu.CATEGORY_MASK), 0, str.length(), 33);
                dMThemeDialog.j(spannableString);
            }
            dMThemeDialog.i(i2 > 0 ? "开心收下" : "我知道啦", new ug0(this, i2));
            dMThemeDialog.g(true, new vg0(this, i2));
            dMThemeDialog.show();
        }
    }

    public void q(FansRankingBean fansRankingBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10423282")) {
            ipChange.ipc$dispatch("-10423282", new Object[]{this, fansRankingBean});
        } else if (fansRankingBean != null) {
            this.t = fansRankingBean;
            if (fansRankingBean.rank >= 0) {
                this.a.setText(fansRankingBean.rank + "");
                if (fansRankingBean.rank > 9999) {
                    this.a.setTextSize(1, 10.0f);
                } else {
                    this.a.setTextSize(1, 20.0f);
                }
            } else {
                this.a.setText("——");
                this.a.setTextSize(1, 20.0f);
            }
            if (fansRankingBean.score >= 0) {
                this.f.setText(fansRankingBean.score + "");
                this.g.setVisibility(0);
            } else {
                this.f.setText("——");
                this.g.setVisibility(8);
            }
            if (LoginManager.k().q()) {
                cn.damai.common.image.a.b().loadinto(fansRankingBean.headPic, this.c);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.d.setText(fansRankingBean.nickName);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.c.setImageResource(R$drawable.mine_account_default);
                this.s.findViewById(R$id.layout_shouhu_detail).setOnClickListener(new a());
            }
            if (fansRankingBean.artistVip || fansRankingBean.button == null) {
                this.r.setVisibility(8);
                this.h.setOnClickListener(new b(fansRankingBean));
                this.w.userTrackExpose(this.h, "rankdetail");
            } else {
                this.r.setVisibility(0);
                this.r.setText(fansRankingBean.button.name);
                this.w.userTrackExpose(this.r, "goto_artist_vip");
                this.r.setOnClickListener(new xg0(this, fansRankingBean));
            }
            wg0 wg0 = new wg0(this, fansRankingBean);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.o.setVisibility(8);
            List<FansRankingBean.TaskBean> list = fansRankingBean.task;
            if (list != null && !list.isEmpty()) {
                ConstraintLayout constraintLayout = null;
                TextView textView = null;
                TextView textView2 = null;
                for (int i2 = 0; i2 < fansRankingBean.task.size(); i2++) {
                    if (i2 == 0) {
                        constraintLayout = this.i;
                        textView = this.j;
                        textView2 = this.k;
                    } else if (i2 == 1) {
                        constraintLayout = this.l;
                        textView = this.m;
                        textView2 = this.n;
                    } else if (i2 == 2) {
                        constraintLayout = this.o;
                        textView = this.p;
                        textView2 = this.q;
                    }
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                        textView.setText(fansRankingBean.task.get(i2).name);
                        textView2.setText(fansRankingBean.task.get(i2).desc);
                        if (fansRankingBean.task.get(i2).applyStatus != 0) {
                            if (i2 == 0) {
                                this.k.setText("今日已完成");
                            } else if (i2 == 1) {
                                this.n.setText("今日已完成");
                            }
                        }
                        constraintLayout.setOnClickListener(wg0);
                        constraintLayout.setTag(fansRankingBean.task.get(i2));
                        constraintLayout.setEnabled(fansRankingBean.task.get(i2).canClick);
                        if (fansRankingBean.task.get(i2).canClick) {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_ff_black_22);
                        } else {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
                        }
                        if (!LoginManager.k().q()) {
                            constraintLayout.setEnabled(true);
                        }
                        if (!fansRankingBean.artistVip && this.r.getVisibility() == 0) {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
                            if (LoginManager.k().q()) {
                                constraintLayout.setEnabled(true);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (this.w.getSection().getTrackInfo().getArgsMap() != null) {
                        hashMap.putAll(this.w.getSection().getTrackInfo().getArgsMap());
                    }
                    hashMap.put("titlelabel", fansRankingBean.task.get(i2).name);
                    this.w.userTrackExpose(constraintLayout, "guard_" + i2, hashMap, false);
                }
            }
            if (!TextUtils.isEmpty(fansRankingBean.rankingMoreLinkDesc)) {
                this.b.setText(fansRankingBean.rankingMoreLinkDesc);
            }
        }
    }
}

package cn.damai.tetris.component.drama.mvp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract;
import cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder;
import cn.damai.tetris.component.drama.viewholder.FocusUiCall;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.br;
import tb.f92;
import tb.jv2;
import tb.tf;
import tb.w9;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class VerticalDramaByMonthView extends AbsView<VerticalDramaByMonthContract.Presenter> implements VerticalDramaByMonthContract.View<VerticalDramaByMonthContract.Presenter>, View.OnClickListener, DramaCardHorViewHolder.OnDramaItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_SHOW_COUNT = 5;
    private LinearLayout mDramaListContainer;
    private DramaMonthBean mMonthBean;
    private View mNoMoreV;
    private tf mPanel;
    private int mPos;
    private String mSectionId;
    private View mShowMoreBtn;
    private List<DramaV1Bean> mTotalList;

    public VerticalDramaByMonthView(View view) {
        super(view);
        this.mDramaListContainer = (LinearLayout) view.findViewById(R$id.drama_list_container);
        this.mShowMoreBtn = view.findViewById(R$id.drama_show_more);
        this.mNoMoreV = view.findViewById(R$id.drama_no_more);
        this.mShowMoreBtn.setOnClickListener(this);
        this.mPanel = new tf(view);
    }

    @SuppressLint({"ViewTag", "NewApi"})
    private void bindDramaList(List<DramaV1Bean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506911300")) {
            ipChange.ipc$dispatch("506911300", new Object[]{this, list});
            return;
        }
        check2ShowNoMore();
        int childCount = this.mDramaListContainer.getChildCount();
        int e = xf2.e(list);
        if (e > childCount) {
            int i = e - childCount;
            for (int i2 = 0; i2 < i; i2++) {
                DramaCardHorViewHolder dramaCardHorViewHolder = new DramaCardHorViewHolder(xs0.a(), this.mDramaListContainer, this);
                dramaCardHorViewHolder.itemView.setTag(R$id.holder_id, dramaCardHorViewHolder);
                this.mDramaListContainer.addView(dramaCardHorViewHolder.itemView);
            }
        } else if (e < childCount) {
            this.mDramaListContainer.removeViews(e, childCount - e);
        }
        if (!f92.d(list)) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                DramaV1Bean dramaV1Bean = list.get(i3);
                View childAt = this.mDramaListContainer.getChildAt(i3);
                if (childAt != null) {
                    Object tag = childAt.getTag(R$id.holder_id);
                    if (tag instanceof DramaCardHorViewHolder) {
                        ((DramaCardHorViewHolder) tag).a(dramaV1Bean, i3);
                    }
                    VerticalDramaByMonthContract.Presenter presenter = (VerticalDramaByMonthContract.Presenter) getPresenter();
                    if (presenter != null) {
                        presenter.exposeItem(childAt, dramaV1Bean, i3);
                    }
                }
            }
        }
    }

    private void check2ShowNoMore() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "971512306")) {
            ipChange.ipc$dispatch("971512306", new Object[]{this});
        } else if (this.mMonthBean != null) {
            boolean z2 = xf2.e(this.mTotalList) > 5;
            DramaMonthBean dramaMonthBean = this.mMonthBean;
            if (!dramaMonthBean.isLastTab || (!dramaMonthBean.isExpand && z2)) {
                z = false;
            }
            View view = this.mNoMoreV;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647535520")) {
            ipChange.ipc$dispatch("-1647535520", new Object[]{this, view});
        } else if (view.getId() == R$id.drama_show_more) {
            this.mShowMoreBtn.setVisibility(8);
            DramaMonthBean dramaMonthBean = this.mMonthBean;
            if (dramaMonthBean != null) {
                dramaMonthBean.isExpand = true;
                ((VerticalDramaByMonthContract.Presenter) getPresenter()).utShowAllClick(this, this.mMonthBean, this.mPos);
            }
            bindDramaList(this.mTotalList);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder.OnDramaItemClickListener
    public void onDramaItemClick(DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097408134")) {
            ipChange.ipc$dispatch("-1097408134", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        DramaMonthBean dramaMonthBean = this.mMonthBean;
        if (dramaMonthBean != null) {
            dramaV1Bean.tempLabelName = dramaMonthBean.labelName;
        }
        ((VerticalDramaByMonthContract.Presenter) getPresenter()).itemClick(this, dramaV1Bean, i);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder.OnDramaItemClickListener
    public void onFocusClick(FocusUiCall focusUiCall, DramaV1Bean dramaV1Bean, int i) {
        w9 context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1043133070")) {
            ipChange.ipc$dispatch("1043133070", new Object[]{this, focusUiCall, dramaV1Bean, Integer.valueOf(i)});
        } else if (this.mMonthBean != null && dramaV1Bean != null && (context = getContext()) != null) {
            ((VerticalDramaByMonthContract.Presenter) getPresenter()).utFocusClick(this, dramaV1Bean, i);
            br.c(context.a(), new Message(jv2.TYPE_CLICK_FOCUS, new jv2(focusUiCall, this.mSectionId, dramaV1Bean)));
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.View
    public void setData(DramaMonthBean dramaMonthBean, String str, int i) {
        List<DramaV1Bean> list;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1506632474")) {
            ipChange.ipc$dispatch("1506632474", new Object[]{this, dramaMonthBean, str, Integer.valueOf(i)});
        } else if (dramaMonthBean != null) {
            this.mMonthBean = dramaMonthBean;
            this.mPos = i;
            this.mSectionId = str;
            this.mPanel.f(dramaMonthBean.labelName);
            this.mPanel.d(false);
            List<DramaV1Bean> list2 = dramaMonthBean.content;
            this.mTotalList = list2;
            boolean z2 = dramaMonthBean.isExpand;
            if (xf2.e(list2) <= 5) {
                z = false;
            }
            if (z2) {
                this.mShowMoreBtn.setVisibility(8);
            } else if (z) {
                this.mShowMoreBtn.setVisibility(0);
            } else {
                this.mShowMoreBtn.setVisibility(8);
            }
            if (z2) {
                list = this.mTotalList;
            } else if (z) {
                list = new ArrayList(this.mTotalList).subList(0, 5);
            } else {
                list = this.mTotalList;
            }
            bindDramaList(list);
        }
    }
}

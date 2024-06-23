package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.component.home.widget.TabLottieLinearView;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.a03;
import tb.d20;

/* compiled from: Taobao */
public class WaterFlowTitleViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    String[] defaultTitles = {"为你推荐"};
    private Context mContext;
    int mCurIndex = 0;
    private TextView mModuleTitle;
    private HomeTabScrollView mScrollView;
    private List<ScrollTitleBean> mTabList = new ArrayList();
    public List<HomeTitleBean.Title> mainTitles;

    /* compiled from: Taobao */
    public class a implements TabLottieLinearView.OnBindListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView.OnBindListener
        public void onBind(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1880549866")) {
                ipChange.ipc$dispatch("-1880549866", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            WaterFlowTitleViewHolder.this.exposeTabItem(view, i);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        long a;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-717164973")) {
                ipChange.ipc$dispatch("-717164973", new Object[]{this, view});
                return;
            }
            List<HomeTitleBean.Title> list = WaterFlowTitleViewHolder.this.mainTitles;
            if (list != null && list.size() != 1) {
                if (this.a == 0) {
                    this.a = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.a < 200) {
                    return;
                }
                this.a = System.currentTimeMillis();
                ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
                WaterFlowTitleViewHolder.this.mCurIndex = scrollTitleBean.index;
                ((CommonViewHolder) WaterFlowTitleViewHolder.this).commonPresenter.sendMsg(new Message(1, scrollTitleBean));
            }
        }
    }

    public WaterFlowTitleViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) this.itemView.findViewById(R$id.hometab_scrollView);
        this.mScrollView = homeTabScrollView;
        homeTabScrollView.setVisibility(0);
        TextView textView = (TextView) this.itemView.findViewById(R$id.homepage_module_title_label);
        this.mModuleTitle = textView;
        textView.setVisibility(8);
    }

    private void updateTab() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-102676246")) {
            ipChange.ipc$dispatch("-102676246", new Object[]{this});
            return;
        }
        this.mTabList.clear();
        for (HomeTitleBean.Title title : this.mainTitles) {
            if (title != null && !TextUtils.isEmpty(title.name)) {
                ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                scrollTitleBean.id = i + "";
                scrollTitleBean.index = i;
                scrollTitleBean.name = title.name;
                scrollTitleBean.picJson = title.jsonIcon;
                scrollTitleBean.picUrl = title.icon;
                this.mTabList.add(scrollTitleBean);
                i++;
            }
        }
        this.mScrollView.setFontColor(R$color.color_000000, R$color.color_9C9CA5).setFontSize(16, 20).setTitle(this.mTabList).setHeight(32).setLineType(3).setOnTitleClickListener(new b()).setBindListener(new a()).commit();
        if (this.mTabList.size() > 1) {
            this.mScrollView.selectTitle(this.mCurIndex);
        }
    }

    public void exposeTabItem(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522298621")) {
            ipChange.ipc$dispatch("-522298621", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "city", d20.d() + "市");
        List<HomeTitleBean.Title> list = this.mainTitles;
        if (!(list == null || i >= list.size() || this.mainTitles.get(i) == null)) {
            a03.h(g, "titlelabel", this.mainTitles.get(i).name);
        }
        c e = c.e();
        e.G(view, "tab_" + i, "bottom", "home", g);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779489669")) {
            ipChange.ipc$dispatch("-779489669", new Object[]{this, commonBean});
        } else if (commonBean instanceof HomeTitleBean) {
            this.mainTitles = new ArrayList();
            HomeTitleBean homeTitleBean = (HomeTitleBean) commonBean;
            List<HomeTitleBean.Title> list = homeTitleBean.mainTitles;
            if (list != null && list.size() >= 1) {
                this.mainTitles = homeTitleBean.mainTitles;
            }
            if (this.mainTitles.size() >= 2) {
                this.mScrollView.setVisibility(0);
                this.mModuleTitle.setVisibility(8);
                updateTab();
                return;
            }
            this.mScrollView.setVisibility(8);
            this.mModuleTitle.setVisibility(0);
            List<HomeTitleBean.Title> list2 = this.mainTitles;
            if (list2 == null || list2.size() == 0) {
                this.mModuleTitle.setText(this.defaultTitles[0]);
                return;
            }
            HomeTitleBean.Title title = this.mainTitles.get(0);
            if (title == null || TextUtils.isEmpty(title.name)) {
                this.mModuleTitle.setText(this.defaultTitles[0]);
            } else {
                this.mModuleTitle.setText(title.name);
            }
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226491248")) {
            ipChange.ipc$dispatch("-1226491248", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 2) {
            try {
                int intValue = ((Integer) obj).intValue();
                this.mCurIndex = intValue;
                List<ScrollTitleBean> list = this.mTabList;
                if (list != null && intValue < list.size()) {
                    this.mScrollView.selectTitle(this.mCurIndex);
                    ScrollTitleBean scrollTitleBean = this.mTabList.get(this.mCurIndex);
                    this.mCurIndex = scrollTitleBean.index;
                    this.commonPresenter.sendMsg(new Message(1, scrollTitleBean));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

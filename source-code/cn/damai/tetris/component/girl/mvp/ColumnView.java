package cn.damai.tetris.component.girl.mvp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.girl.bean.ProjectViewModel;
import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m42;
import tb.ns0;
import tb.uf2;

/* compiled from: Taobao */
public class ColumnView extends AbsView<ColumnContract$Presenter> implements ColumnContract$View<ColumnContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private View mAllBtnLayout;
    private ImageView mBackImage;
    private b mItem1;
    private b mItem2;
    private b mItem3;
    private b mItem4;
    private b mItem5;
    private b mItem6;
    private List<b> mItemUIs = new ArrayList();
    private View mRow2Layout;
    private TextView mSubTitleTv;
    private TextView mTitleTv;
    private int pic_height = 0;
    private int pic_width = 0;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ StepBean a;
        final /* synthetic */ String b;

        a(StepBean stepBean, String str) {
            this.a = stepBean;
            this.b = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1793733380")) {
                ipChange.ipc$dispatch("1793733380", new Object[]{this, view});
                return;
            }
            ((ColumnContract$Presenter) ColumnView.this.getPresenter()).allBtnClick(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        View a;
        private TextView b = ((TextView) this.a.findViewById(R$id.item_title));
        private TextView c = ((TextView) this.a.findViewById(R$id.tv_price_tag));
        private TextView d = ((TextView) this.a.findViewById(R$id.item_price_tv));
        private TextView e = ((TextView) this.a.findViewById(R$id.tv_qi));
        private ProjectViewModel f;
        private DMPosterView g;
        private int h;
        private int i;
        private String j;
        private String k;

        public b(View view) {
            this.a = view;
            this.g = (DMPosterView) view.findViewById(R$id.item_poster);
        }

        public void a(ProjectViewModel projectViewModel, int i2, int i3, String str, String str2, ColumnContract$Model columnContract$Model, JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1641359483")) {
                ipChange.ipc$dispatch("1641359483", new Object[]{this, projectViewModel, Integer.valueOf(i2), Integer.valueOf(i3), str, str2, columnContract$Model, jSONObject});
                return;
            }
            this.f = projectViewModel;
            this.h = i2;
            this.i = i3;
            this.j = str;
            this.k = str2;
            if (projectViewModel == null) {
                this.a.setOnClickListener(null);
                this.a.setTag(null);
                this.a.setVisibility(4);
            } else {
                this.a.setVisibility(0);
                this.a.setOnClickListener(this);
                this.b.setText(projectViewModel.title);
                if (TextUtils.isEmpty(projectViewModel.priceTitle)) {
                    this.d.setText("价格待定");
                    this.d.setTextSize(1, 12.0f);
                    this.c.setVisibility(8);
                    this.e.setVisibility(8);
                } else if (projectViewModel.priceTitle.contains("待定")) {
                    this.d.setText("价格待定");
                    this.d.setTextSize(1, 12.0f);
                    this.c.setVisibility(8);
                    this.e.setVisibility(8);
                } else {
                    this.d.setText(projectViewModel.priceTitle);
                    this.d.setTextSize(1, 16.0f);
                    this.c.setVisibility(0);
                    this.e.setVisibility(0);
                }
                this.g.setImageUrlForWebp(projectViewModel.picUrl, ColumnView.this.pic_width, ColumnView.this.pic_height);
                this.g.setCategoryTagName("");
                double d2 = projectViewModel.itemScore;
                if (d2 != -1.0d) {
                    this.g.setScoreStar(d2, true);
                }
                if ("true".equals(columnContract$Model.getStyleValue(ProjectViewModel.RT_VISI)) && jSONObject != null && !TextUtils.isEmpty(columnContract$Model.getStyleValue(ProjectViewModel.RT_VALUE))) {
                    this.g.setCategoryTagName(jSONObject.getString(columnContract$Model.getStyleValue(ProjectViewModel.RT_VALUE)));
                }
            }
            ns0.a().b((ColumnPresenter) ColumnView.this.getPresenter(), this.a, this.h, this.i, str, projectViewModel.id, str2);
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-217814651")) {
                ipChange.ipc$dispatch("-217814651", new Object[]{this, view});
                return;
            }
            ((ColumnContract$Presenter) ColumnView.this.getPresenter()).projectItemClick(this.f, this.h, this.i, this.j, this.k);
        }
    }

    public ColumnView(View view) {
        super(view);
        if (view != null) {
            initView();
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553299951")) {
            ipChange.ipc$dispatch("-1553299951", new Object[]{this});
            return;
        }
        this.mTitleTv = (TextView) getView().findViewById(R$id.tv_title);
        this.mSubTitleTv = (TextView) getView().findViewById(R$id.tv_subtitle);
        this.mBackImage = (ImageView) getView().findViewById(R$id.image_back);
        this.mAllBtnLayout = getView().findViewById(R$id.layout_all);
        this.mItem1 = new b(getView().findViewById(R$id.item_1_layout));
        this.mItem2 = new b(getView().findViewById(R$id.item_2_layout));
        this.mItem3 = new b(getView().findViewById(R$id.item_3_layout));
        this.mItem4 = new b(getView().findViewById(R$id.item_4_layout));
        this.mItem5 = new b(getView().findViewById(R$id.item_5_layout));
        this.mItem6 = new b(getView().findViewById(R$id.item_6_layout));
        this.mRow2Layout = getView().findViewById(R$id.layout_row2);
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$View
    public void initScreenSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900232087")) {
            ipChange.ipc$dispatch("-900232087", new Object[]{this});
            return;
        }
        Activity activity = ((ColumnPresenter) getPresenter()).getContext().getActivity();
        this.context = activity;
        this.pic_width = m42.a(activity, 103.0f);
        this.pic_height = m42.a(this.context, 138.0f);
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$View
    public void setData(StepBean stepBean, String str, ColumnContract$Model columnContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814076842")) {
            ipChange.ipc$dispatch("814076842", new Object[]{this, stepBean, str, columnContract$Model});
        } else if (stepBean == null || uf2.b(stepBean.contentList) < 3) {
            getView().setVisibility(8);
        } else {
            getView().setVisibility(0);
            cn.damai.uikit.image.a.a().loadinto(columnContract$Model.getStyleValue("backPic"), this.mBackImage);
            this.mTitleTv.setText(columnContract$Model.getStyleValue("title"));
            this.mSubTitleTv.setText(columnContract$Model.getStyleValue("subTitle"));
            this.mItemUIs.clear();
            this.mItemUIs.add(this.mItem1);
            this.mItemUIs.add(this.mItem2);
            this.mItemUIs.add(this.mItem3);
            List<ProjectViewModel> list = stepBean.contentList;
            if (TextUtils.isEmpty(columnContract$Model.getStyleValue("showAll")) || !"true".equals(columnContract$Model.getStyleValue("showAll"))) {
                this.mAllBtnLayout.setVisibility(8);
            } else {
                this.mAllBtnLayout.setVisibility(0);
                this.mAllBtnLayout.setOnClickListener(new a(stepBean, str));
            }
            if (list.size() >= 6) {
                this.mRow2Layout.setVisibility(0);
                this.mItemUIs.add(this.mItem4);
                this.mItemUIs.add(this.mItem5);
                this.mItemUIs.add(this.mItem6);
            } else {
                this.mRow2Layout.setVisibility(8);
            }
            for (int i = 0; i < this.mItemUIs.size(); i++) {
                JSONObject jSONObject = null;
                try {
                    JSONArray jSONArray = columnContract$Model.getRawJson().getJSONArray("contentList");
                    if (jSONArray != null && jSONArray.size() > i) {
                        jSONObject = (JSONObject) jSONArray.get(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mItemUIs.get(i).a(list.get(i), stepBean.position, i, stepBean.groupId, columnContract$Model.getStyleValue("title"), columnContract$Model, jSONObject);
            }
        }
    }
}

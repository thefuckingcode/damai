package cn.damai.tetris.component.star.content.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.login.LoginManager;
import cn.damai.musicfestival.bean.AtmosphereBean;
import cn.damai.tetris.component.star.content.base.ContentBaseContract;
import cn.damai.tetris.component.star.content.base.bean.Button;
import cn.damai.tetris.component.star.content.base.network.ContentCommonParams;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jl1;
import tb.w9;
import tb.wj2;

/* compiled from: Taobao */
public class ContentBasePresenter extends BasePresenter<ContentBaseContract.Model, ContentBaseView, BaseSection> implements ContentBaseContract.Presenter<ContentBaseContract.Model, ContentBaseView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    ContentBaseAdapter mMainListAdapter;
    private int mPageNum = 1;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ContentBasePresenter contentBasePresenter) {
        }

        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-891676279")) {
                ipChange.ipc$dispatch("-891676279", new Object[]{this, view});
                return;
            }
            view.getTag();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1219614090")) {
                ipChange.ipc$dispatch("1219614090", new Object[]{this, view});
                return;
            }
            DMNav.from(((BasePresenter) ContentBasePresenter.this).mContext.getActivity()).toUri(this.a);
            ContentBasePresenter.this.userTrackClick("all", true);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-964062837")) {
                ipChange.ipc$dispatch("-964062837", new Object[]{this, view});
                return;
            }
            ContentBasePresenter.this.doLoadMore(false);
            ContentBasePresenter.this.userTrackClick("more", true);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Button a;

        d(Button button) {
            this.a = button;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1147227532")) {
                ipChange.ipc$dispatch("1147227532", new Object[]{this, view});
            } else if (!ContentBasePresenter.this.isLogin()) {
                LoginManager.k().x(((BasePresenter) ContentBasePresenter.this).mContext.getActivity(), new Intent(), 10001);
            } else {
                Button button = this.a;
                if (button != null && !TextUtils.isEmpty(button.getDestination()) && !TextUtils.isEmpty(this.a.getName())) {
                    DMNav.from(((BasePresenter) ContentBasePresenter.this).mContext.getActivity()).forResult(10002).toUri(this.a.getDestination());
                }
                ContentBasePresenter.this.userTrackClick("goto_artist_vip", true);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements OnBizListener<Pair<BaseResponse, AtmosphereBean>> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public void onSuccess(Pair<BaseResponse, AtmosphereBean> pair) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1655108656")) {
                ipChange.ipc$dispatch("-1655108656", new Object[]{this, pair});
                return;
            }
            ContentBasePresenter contentBasePresenter = ContentBasePresenter.this;
            contentBasePresenter.mMainListAdapter.g(((ContentBaseContract.Model) contentBasePresenter.getModel()).allData());
            ContentBasePresenter.this.updateUI();
            ContentBasePresenter.this.mPageNum = this.a;
        }

        @Override // cn.damai.tetris.componentplugin.OnBizListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1843376141")) {
                ipChange.ipc$dispatch("-1843376141", new Object[]{this, str, str2});
            }
        }
    }

    public ContentBasePresenter(ContentBaseView contentBaseView, String str, w9 w9Var) {
        super(contentBaseView, str, w9Var);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doLoadMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108928849")) {
            ipChange.ipc$dispatch("-2108928849", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Intent intent = getContext().getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("artistId");
            String stringExtra2 = intent.getStringExtra("type");
            DrObj drObj = (DrObj) intent.getSerializableExtra("DrObj");
            int i = this.mPageNum + 1;
            TetrisRequest tetrisRequest = new TetrisRequest(new ContentCommonParams(stringExtra, stringExtra2, i + ""));
            if (drObj != null) {
                drObj.targetArgs = tetrisRequest.args;
                tetrisRequest.dr = jl1.ARRAY_START_STR + JSON.toJSONString(drObj) + jl1.ARRAY_END_STR;
            }
            ((ContentBaseContract.Model) getModel()).load(new e(i), getSection().getComponentId(), tetrisRequest);
        }
    }

    private void updateList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-957028060")) {
            ipChange.ipc$dispatch("-957028060", new Object[]{this});
            return;
        }
        TextView textView = (TextView) ((ContentBaseView) getView()).getProjectsView().findViewById(R$id.content_main_list_show_more);
        boolean hasNext = ((ContentBaseContract.Model) getModel()).allData().getHasNext();
        ((ContentBaseContract.Model) getModel()).allData().getButton();
        int type = ((ContentBaseContract.Model) getModel()).allData().getType();
        String componentId = getSection().getComponentId();
        componentId.hashCode();
        char c2 = 65535;
        switch (componentId.hashCode()) {
            case -2085257335:
                if (componentId.equals(wj2.DM_ARTIST_MAIN_YUEHUA_CONTENT)) {
                    c2 = 0;
                    break;
                }
                break;
            case -2039381270:
                if (componentId.equals(wj2.DM_BASE_CONTENT_FREE)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1731511831:
                if (componentId.equals(wj2.DM_ARTIST_MAIN_OFFICIAL_CONTENT)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1312697377:
                if (componentId.equals(wj2.DM_BASE_CONTENT_VIP)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 3:
                textView.setVisibility(8);
                return;
            case 1:
                if (!hasNext || type != 1) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                textView.setOnClickListener(new c());
                return;
            default:
                return;
        }
    }

    private void updateTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477537968")) {
            ipChange.ipc$dispatch("1477537968", new Object[]{this});
            return;
        }
        ViewGroup projectsView = ((ContentBaseView) getView()).getProjectsView();
        LinearLayout linearLayout = (LinearLayout) projectsView.findViewById(R$id.content_style_title_container);
        TextView textView = (TextView) projectsView.findViewById(R$id.module_title_label_x);
        LinearLayout linearLayout2 = (LinearLayout) projectsView.findViewById(R$id.module_title_more_layout_2);
        TextView textView2 = (TextView) projectsView.findViewById(R$id.module_title_more_text_2);
        if (!TextUtils.isEmpty(((ContentBaseContract.Model) getModel()).getStyleValue("title"))) {
            linearLayout.setVisibility(0);
            textView.setText(((ContentBaseContract.Model) getModel()).getStyleValue("title"));
            textView.setVisibility(0);
            String styleValue = ((ContentBaseContract.Model) getModel()).getStyleValue("subTitle");
            linearLayout2.setVisibility(0);
            textView2.setText(styleValue);
            linearLayout2.setOnClickListener(new b(((ContentBaseContract.Model) getModel()).allData().getSubPageUrl()));
            userTrackExpose(textView2, "all");
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311314638")) {
            ipChange.ipc$dispatch("1311314638", new Object[]{this});
            return;
        }
        updateTitle();
        updateVIP();
        updateList();
    }

    private void updateVIP() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025866635")) {
            ipChange.ipc$dispatch("2025866635", new Object[]{this});
            return;
        }
        boolean artistVip = ((ContentBaseContract.Model) getModel()).allData().getArtistVip();
        Button button = ((ContentBaseContract.Model) getModel()).allData().getButton();
        ViewGroup projectsView = ((ContentBaseView) getView()).getProjectsView();
        LinearLayout linearLayout = (LinearLayout) projectsView.findViewById(R$id.content_vip_divide_line_layout);
        if (artistVip || hasVipButton()) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) projectsView.findViewById(R$id.content_vip_join_button_layout);
        TextView textView = (TextView) projectsView.findViewById(R$id.content_vip_join_button_text);
        RecyclerView recyclerView = (RecyclerView) projectsView.findViewById(R$id.content_main_list);
        if (button == null || TextUtils.isEmpty(button.getDestination()) || TextUtils.isEmpty(button.getName())) {
            linearLayout2.setVisibility(8);
            recyclerView.setVisibility(0);
        } else {
            textView.setText(button.getName());
            linearLayout2.setVisibility(0);
            recyclerView.setVisibility(8);
            userTrackExpose(linearLayout2, "goto_artist_vip");
        }
        linearLayout2.setOnClickListener(new d(button));
    }

    public boolean hasVipButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476752314")) {
            return ((Boolean) ipChange.ipc$dispatch("476752314", new Object[]{this})).booleanValue();
        }
        Button button = ((ContentBaseContract.Model) getModel()).allData().getButton();
        return button != null && !TextUtils.isEmpty(button.getDestination()) && !TextUtils.isEmpty(button.getName());
    }

    public boolean isLogin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "43648612")) {
            return LoginManager.k().q();
        }
        return ((Boolean) ipChange.ipc$dispatch("43648612", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774096312")) {
            ipChange.ipc$dispatch("-1774096312", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ContentBaseContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827539997")) {
            ipChange.ipc$dispatch("827539997", new Object[]{this, model});
            return;
        }
        RecyclerView recyclerView = (RecyclerView) ((ContentBaseView) getView()).getProjectsView().findViewById(R$id.content_main_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getActivity());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ContentBaseAdapter contentBaseAdapter = new ContentBaseAdapter(getContext().getActivity(), new a(this), this);
        this.mMainListAdapter = contentBaseAdapter;
        recyclerView.setAdapter(contentBaseAdapter);
        this.mMainListAdapter.g(((ContentBaseContract.Model) getModel()).allData());
        updateUI();
    }
}

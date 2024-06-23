package com.alibaba.pictures.bricks.selector;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.adapter.ScriptSelectAdapter;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.request.ScriptSelectRequest;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.youku.arch.v3.util.DensityUtil;
import com.youku.arch.v3.util.DisplayUtils;
import kotlin.Lazy;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f52;
import tb.g52;
import tb.h52;
import tb.i52;
import tb.j52;
import tb.k21;
import tb.m40;
import tb.ta0;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptSelectFragment extends BricksBaseFragment implements OnEventListener, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_ID_ITEM_SELECT = "scriptItemSelect";
    @NotNull
    public static final String EXTRA_KEY_PAGE_TYPE = "pageType";
    @NotNull
    public static final String EXTRA_KEY_SELECT_ID = "selectedId";
    @NotNull
    public static final String EXTRA_KEY_TARGET_ID = "targetId";
    public static final int PAGE_TYPE_SCRIPT = 1;
    public static final int PAGE_TYPE_SHOP = 0;
    public static final int SCRIPT_SPAN_COUNT = 4;
    private static final int gridItemWidth;
    private static final int midSpace;
    private static final int sideSpace;
    @NotNull
    private final Lazy adapter$delegate = kotlin.b.b(new ScriptSelectFragment$adapter$2(this));
    private View deleteBtn;
    private ViewGroup errorContainer;
    private EditText inputEditText;
    @NotNull
    private final Lazy inputMethodManager$delegate = kotlin.b.b(new ScriptSelectFragment$inputMethodManager$2(this));
    private int pageNum = 1;
    private int pageType;
    private RecyclerView recycleView;
    private SmartRefreshLayout refreshLayout;
    @NotNull
    private final Lazy selectId$delegate = kotlin.b.b(new ScriptSelectFragment$selectId$2(this));
    @Nullable
    private String targetId;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final int a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "771789124")) {
                return ScriptSelectFragment.gridItemWidth;
            }
            return ((Integer) ipChange.ipc$dispatch("771789124", new Object[]{this})).intValue();
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-773223838")) {
                return ScriptSelectFragment.sideSpace;
            }
            return ((Integer) ipChange.ipc$dispatch("-773223838", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptSelectFragment a;

        b(ScriptSelectFragment scriptSelectFragment) {
            this.a = scriptSelectFragment;
        }

        public void afterTextChanged(@Nullable Editable editable) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "2001669739")) {
                ipChange.ipc$dispatch("2001669739", new Object[]{this, editable});
                return;
            }
            View view = this.a.deleteBtn;
            if (view == null) {
                k21.A("deleteBtn");
                view = null;
            }
            if (!(editable == null || editable.length() == 0)) {
                z = false;
            }
            if (z) {
                i = 8;
            }
            view.setVisibility(i);
        }

        public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "961935544")) {
                ipChange.ipc$dispatch("961935544", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1337407144")) {
                ipChange.ipc$dispatch("-1337407144", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptSelectFragment a;

        c(ScriptSelectFragment scriptSelectFragment) {
            this.a = scriptSelectFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1918940622")) {
                ipChange.ipc$dispatch("-1918940622", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.requestSearch(true);
        }
    }

    static {
        int dp2px = DensityUtil.dp2px(12.0f);
        sideSpace = dp2px;
        int dp2px2 = DensityUtil.dp2px(9.0f);
        midSpace = dp2px2;
        gridItemWidth = ((DisplayUtils.getWidthPixels() - (dp2px2 * 3)) - (dp2px * 2)) / 4;
    }

    /* access modifiers changed from: private */
    public final ScriptSelectAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1404588450")) {
            return (ScriptSelectAdapter) this.adapter$delegate.getValue();
        }
        return (ScriptSelectAdapter) ipChange.ipc$dispatch("1404588450", new Object[]{this});
    }

    private final InputMethodManager getInputMethodManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "786511987")) {
            return (InputMethodManager) this.inputMethodManager$delegate.getValue();
        }
        return (InputMethodManager) ipChange.ipc$dispatch("786511987", new Object[]{this});
    }

    private final String getSelectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1235437635")) {
            return (String) this.selectId$delegate.getValue();
        }
        return (String) ipChange.ipc$dispatch("1235437635", new Object[]{this});
    }

    /* access modifiers changed from: private */
    public final void hideSoftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675834580")) {
            ipChange.ipc$dispatch("-675834580", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            EditText editText = this.inputEditText;
            if (editText == null) {
                k21.A("inputEditText");
                editText = null;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    private final void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190148007")) {
            ipChange.ipc$dispatch("190148007", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.et_keyword);
        k21.h(findViewById, "root.findViewById(R.id.et_keyword)");
        EditText editText = (EditText) findViewById;
        this.inputEditText = editText;
        SmartRefreshLayout smartRefreshLayout = null;
        if (editText == null) {
            k21.A("inputEditText");
            editText = null;
        }
        editText.setHint(this.pageType == 1 ? "搜索关键词查找关联剧本" : "搜索关键词查找关联店铺");
        View findViewById2 = view.findViewById(R$id.ll_delete);
        k21.h(findViewById2, "root.findViewById<View>(R.id.ll_delete)");
        this.deleteBtn = findViewById2;
        View findViewById3 = view.findViewById(R$id.error_container);
        k21.h(findViewById3, "root.findViewById(R.id.error_container)");
        this.errorContainer = (ViewGroup) findViewById3;
        ((TextView) view.findViewById(R$id.search_title_content)).setText(this.pageType == 1 ? "选择要关联的剧本" : "请选择要关联的店铺");
        view.findViewById(R$id.search_title_close).setOnClickListener(new h52(this));
        view.findViewById(R$id.tv_cancel).setOnClickListener(new f52(this));
        View view2 = this.deleteBtn;
        if (view2 == null) {
            k21.A("deleteBtn");
            view2 = null;
        }
        view2.setOnClickListener(new g52(this));
        EditText editText2 = this.inputEditText;
        if (editText2 == null) {
            k21.A("inputEditText");
            editText2 = null;
        }
        editText2.addTextChangedListener(new b(this));
        EditText editText3 = this.inputEditText;
        if (editText3 == null) {
            k21.A("inputEditText");
            editText3 = null;
        }
        editText3.setOnEditorActionListener(new i52(this));
        View findViewById4 = view.findViewById(R$id.recyclerView);
        k21.h(findViewById4, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.recycleView = recyclerView;
        if (this.pageType == 0) {
            if (recyclerView == null) {
                k21.A("recycleView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RecyclerView recyclerView2 = this.recycleView;
            if (recyclerView2 == null) {
                k21.A("recycleView");
                recyclerView2 = null;
            }
            recyclerView2.addItemDecoration(new ScriptSelectFragment$initView$6(this));
        } else {
            if (recyclerView == null) {
                k21.A("recycleView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            RecyclerView recyclerView3 = this.recycleView;
            if (recyclerView3 == null) {
                k21.A("recycleView");
                recyclerView3 = null;
            }
            int i = sideSpace;
            RecyclerView recyclerView4 = this.recycleView;
            if (recyclerView4 == null) {
                k21.A("recycleView");
                recyclerView4 = null;
            }
            int paddingTop = recyclerView4.getPaddingTop();
            RecyclerView recyclerView5 = this.recycleView;
            if (recyclerView5 == null) {
                k21.A("recycleView");
                recyclerView5 = null;
            }
            recyclerView3.setPadding(i, paddingTop, i, recyclerView5.getPaddingBottom());
            RecyclerView recyclerView6 = this.recycleView;
            if (recyclerView6 == null) {
                k21.A("recycleView");
                recyclerView6 = null;
            }
            recyclerView6.addItemDecoration(new ScriptSelectFragment$initView$7(this));
        }
        RecyclerView recyclerView7 = this.recycleView;
        if (recyclerView7 == null) {
            k21.A("recycleView");
            recyclerView7 = null;
        }
        recyclerView7.addOnScrollListener(new ScriptSelectFragment$initView$8(this));
        RecyclerView recyclerView8 = this.recycleView;
        if (recyclerView8 == null) {
            k21.A("recycleView");
            recyclerView8 = null;
        }
        recyclerView8.setAdapter(getAdapter());
        View findViewById5 = view.findViewById(R$id.refresh_layout);
        k21.h(findViewById5, "root.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout2 = (SmartRefreshLayout) findViewById5;
        this.refreshLayout = smartRefreshLayout2;
        if (smartRefreshLayout2 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableRefresh(false);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setEnableAutoLoadMore(true);
        SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
        if (smartRefreshLayout5 == null) {
            k21.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout5;
        }
        smartRefreshLayout.setOnLoadMoreListener(this);
        requestSearch(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m172initView$lambda0(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349636603")) {
            ipChange.ipc$dispatch("-1349636603", new Object[]{scriptSelectFragment, view});
            return;
        }
        k21.i(scriptSelectFragment, "this$0");
        scriptSelectFragment.hideSoftInput();
        FragmentActivity activity = scriptSelectFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m173initView$lambda1(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566257628")) {
            ipChange.ipc$dispatch("-566257628", new Object[]{scriptSelectFragment, view});
            return;
        }
        k21.i(scriptSelectFragment, "this$0");
        scriptSelectFragment.hideSoftInput();
        FragmentActivity activity = scriptSelectFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m174initView$lambda2(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217121347")) {
            ipChange.ipc$dispatch("217121347", new Object[]{scriptSelectFragment, view});
            return;
        }
        k21.i(scriptSelectFragment, "this$0");
        EditText editText = scriptSelectFragment.inputEditText;
        if (editText == null) {
            k21.A("inputEditText");
            editText = null;
        }
        editText.setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final boolean m175initView$lambda3(ScriptSelectFragment scriptSelectFragment, TextView textView, int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345866289")) {
            return ((Boolean) ipChange.ipc$dispatch("345866289", new Object[]{scriptSelectFragment, textView, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        k21.i(scriptSelectFragment, "this$0");
        if (i != 3) {
            return false;
        }
        scriptSelectFragment.hideSoftInput();
        scriptSelectFragment.requestSearch(true);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void requestSearch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874000673")) {
            ipChange.ipc$dispatch("874000673", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.pageNum = 1;
            showLoading("");
        } else {
            this.pageNum++;
        }
        ScriptSelectRequest scriptSelectRequest = new ScriptSelectRequest();
        scriptSelectRequest.setPageIndex(this.pageNum);
        scriptSelectRequest.setPageSize(20);
        scriptSelectRequest.setQueryType(this.pageType);
        scriptSelectRequest.setSelectedId(getSelectId());
        EditText editText = this.inputEditText;
        String str = null;
        if (editText == null) {
            k21.A("inputEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null) {
            k21.h(text, "text");
            CharSequence charSequence = StringsKt__StringsKt.T0(text);
            if (charSequence != null) {
                str = charSequence.toString();
            }
        }
        scriptSelectRequest.setKeyword(str);
        scriptSelectRequest.setTargetId(this.targetId);
        ta0.Companion.b(scriptSelectRequest).a().doOnKTSuccess(new ScriptSelectFragment$requestSearch$1(z, this, scriptSelectRequest)).doOnKTFail(new ScriptSelectFragment$requestSearch$2(z, this)).doOnKTFinish(new ScriptSelectFragment$requestSearch$3(this));
    }

    /* access modifiers changed from: private */
    public final void showEmpty(boolean z) {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219061594")) {
            ipChange.ipc$dispatch("219061594", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ViewGroup viewGroup2 = this.errorContainer;
        if (viewGroup2 == null) {
            k21.A("errorContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        String str = z ? "没有找到符合条件的项目\n您可以减少筛选条件重新重试" : "暂无相关内容";
        ViewGroup viewGroup3 = this.errorContainer;
        if (viewGroup3 == null) {
            k21.A("errorContainer");
            viewGroup = null;
        } else {
            viewGroup = viewGroup3;
        }
        showErrorView(3, str, "", viewGroup, false, false, true, new c(this));
    }

    private final void showSoftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461792153")) {
            ipChange.ipc$dispatch("-1461792153", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            EditText editText = this.inputEditText;
            if (editText == null) {
                k21.A("inputEditText");
                editText = null;
            }
            inputMethodManager.showSoftInput(editText, 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127094268")) {
            ipChange.ipc$dispatch("-1127094268", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        Integer num;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "451998991")) {
            ipChange.ipc$dispatch("451998991", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString("pageType")) == null || (num = n.k(string)) == null)) {
            i = num.intValue();
        }
        this.pageType = i;
        j52.INSTANCE.d(Integer.valueOf(i));
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("targetId") : null;
        this.targetId = string2;
        if (string2 == null) {
            BricksToastUtil.INSTANCE.b("必须传入关联店铺Id");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933248235")) {
            return (View) ipChange.ipc$dispatch("-933248235", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_script_select_fragment, viewGroup, false);
        k21.h(inflate, "root");
        initView(inflate);
        return inflate;
    }

    @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
    public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303751509")) {
            ipChange.ipc$dispatch("303751509", new Object[]{this, str, view, obj});
            return;
        }
        k21.i(str, "eventId");
        if (k21.d(str, EVENT_ID_ITEM_SELECT)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("selectResult", obj instanceof ScriptSelectMo ? (ScriptSelectMo) obj : null);
                ur2 ur2 = ur2.INSTANCE;
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NotNull RefreshLayout refreshLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708126053")) {
            ipChange.ipc$dispatch("-1708126053", new Object[]{this, refreshLayout2});
            return;
        }
        k21.i(refreshLayout2, "refreshLayout");
        requestSearch(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687676632")) {
            ipChange.ipc$dispatch("-687676632", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
    }
}

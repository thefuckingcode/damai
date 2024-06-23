package cn.damai.ultron.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import cn.damai.ultron.R$anim;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.adapter.DmUltronPromotionAdapter;
import cn.damai.ultron.view.bean.DmPromotionOptionsBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.ma0;
import tb.n42;
import tb.w90;

/* compiled from: Taobao */
public class DmUltronPromotionFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private String TAG_ID;
    private DMIconFontTextView cancelIcon;
    private String emptyId;
    DmChooseSwitchListenerImpl<DmPromotionOptionsBean> itemClickListener = new c();
    View mAnimView;
    private LinearLayout mBottomContentLayout;
    private Activity mContext;
    public TextView mLeftTitle;
    private List<DmPromotionOptionsBean> mPromotionBeanList;
    private List<DmPromotionOptionsBean> mPromotionUnUsedList;
    private LinearLayout mTitleBottomLayout;
    public View mTitleBottomLine;
    public TextView mTitleText;
    private TextView mTvTitleBottom;
    private RecyclerView recyclerView;
    private RelativeLayout rl_bottom;
    private String selectId;
    private int selectPos = -1;
    private View v_outside;

    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-232841132")) {
                ipChange.ipc$dispatch("-232841132", new Object[]{this, animation});
                return;
            }
            DmUltronPromotionFragment.this.finish();
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-710586720")) {
                ipChange.ipc$dispatch("-710586720", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1926828371")) {
                ipChange.ipc$dispatch("-1926828371", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            String str;
            String str2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1940798204")) {
                ipChange.ipc$dispatch("1940798204", new Object[]{this, view});
                return;
            }
            if (DmUltronPromotionFragment.this.selectPos < 0 || DmUltronPromotionFragment.this.selectPos >= DmUltronPromotionFragment.this.mPromotionBeanList.size() || DmUltronPromotionFragment.this.mPromotionBeanList.get(DmUltronPromotionFragment.this.selectPos) == null) {
                str2 = DmUltronPromotionFragment.this.emptyId;
                str = "不选择优惠";
            } else {
                DmPromotionOptionsBean dmPromotionOptionsBean = (DmPromotionOptionsBean) DmUltronPromotionFragment.this.mPromotionBeanList.get(DmUltronPromotionFragment.this.selectPos);
                if (!TextUtils.isEmpty(dmPromotionOptionsBean.selectedId)) {
                    str2 = dmPromotionOptionsBean.selectedId;
                } else {
                    str2 = dmPromotionOptionsBean.id;
                }
                str = dmPromotionOptionsBean.cost;
            }
            if (str2 != null) {
                try {
                    w90.h(DmUltronPromotionFragment.this.getActivity(), str);
                    w90.i(DmUltronPromotionFragment.this.getActivity(), str2);
                    cn.damai.common.user.c.e().x(ma0.u().C(DmUltronPromotionFragment.this.getActivity(), str, str2, DmUltronPromotionFragment.this.selectPos));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (DmUltronPromotionFragment.this.selectId == null || !DmUltronPromotionFragment.this.selectId.equals(str2)) {
                Intent intent = new Intent();
                intent.putExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, str2);
                intent.putExtra("selectId", str2);
                intent.putExtra(SocialConstants.PARAM_APP_DESC, str);
                intent.putExtra("tag_id", DmUltronPromotionFragment.this.TAG_ID);
                if (DmUltronPromotionFragment.this.getActivity() != null && (DmUltronPromotionFragment.this.getActivity() instanceof DmOrderActivity)) {
                    ((DmOrderActivity) DmUltronPromotionFragment.this.getActivity()).onSelectPromoBack(intent);
                }
            }
            DmUltronPromotionFragment.this.finishActivity();
        }
    }

    /* compiled from: Taobao */
    public class c implements DmChooseSwitchListenerImpl<DmPromotionOptionsBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void chooseItemListener(DmPromotionOptionsBean dmPromotionOptionsBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1471068497")) {
                ipChange.ipc$dispatch("-1471068497", new Object[]{this, dmPromotionOptionsBean, Integer.valueOf(i)});
                return;
            }
            DmUltronPromotionFragment.this.selectPos = i;
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560135757")) {
            ipChange.ipc$dispatch("560135757", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.selectId = arguments.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            String string = arguments.getString("paramvalue");
            this.TAG_ID = arguments.getString("tag_id");
            List parseArray = JSON.parseArray(string, DmPromotionOptionsBean.class);
            ArrayList arrayList = new ArrayList();
            this.mPromotionBeanList = arrayList;
            if (parseArray != null) {
                arrayList.addAll(parseArray);
            }
            this.mPromotionUnUsedList = JSON.parseArray(arguments.getString("paramvalue_unuse"), DmPromotionOptionsBean.class);
        }
    }

    private void setRecyclerView() {
        List<DmPromotionOptionsBean> list;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1490880423")) {
            ipChange.ipc$dispatch("1490880423", new Object[]{this});
            return;
        }
        RecyclerView recyclerView2 = getRecyclerView();
        if (recyclerView2 != null && (list = this.mPromotionBeanList) != null) {
            Iterator<DmPromotionOptionsBean> it = list.iterator();
            while (it.hasNext()) {
                DmPromotionOptionsBean next = it.next();
                if (next != null) {
                    if (next.checked) {
                        this.selectId = next.selectedId;
                        this.selectPos = i;
                    }
                    if ("-1".equals(next.type)) {
                        this.emptyId = next.selectedId;
                        it.remove();
                    }
                    i++;
                }
            }
            DmUltronPromotionAdapter dmUltronPromotionAdapter = new DmUltronPromotionAdapter(getActivity(), this.mPromotionBeanList, this.itemClickListener);
            if (!f92.d(this.mPromotionUnUsedList)) {
                dmUltronPromotionAdapter.f(this.mPromotionUnUsedList);
            }
            recyclerView2.setAdapter(dmUltronPromotionAdapter);
        }
    }

    public void addErrorView(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394066961")) {
            ipChange.ipc$dispatch("-1394066961", new Object[]{this, str, str2, str3});
            return;
        }
        onResponseError(str2, str, str3, this.mBottomContentLayout, true);
    }

    public <T extends View> T findViewById(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1547427112")) {
            return (T) ((AppCompatActivity) getActivity()).getDelegate().findViewById(i);
        }
        return (T) ((View) ipChange.ipc$dispatch("-1547427112", new Object[]{this, Integer.valueOf(i)}));
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667907082")) {
            ipChange.ipc$dispatch("667907082", new Object[]{this});
        } else if (getActivity() != null && (getActivity() instanceof DmOrderActivity)) {
            ((DmOrderActivity) getActivity()).hideProFragment();
        }
    }

    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341672069")) {
            ipChange.ipc$dispatch("-1341672069", new Object[]{this});
        } else if (this.mAnimView == null) {
            finish();
        } else {
            try {
                if (getActivity() != null) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R$anim.activity_item_animexit);
                    this.mAnimView.startAnimation(loadAnimation);
                    loadAnimation.setAnimationListener(new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1131375909")) {
            return R$layout.activity_pop;
        }
        return ((Integer) ipChange.ipc$dispatch("1131375909", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1214186322")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1214186322", new Object[]{this})).intValue();
    }

    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1091625114")) {
            return this.recyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("1091625114", new Object[]{this});
    }

    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1595371236")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1595371236", new Object[]{this})).booleanValue();
    }

    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1941098038")) {
            return "优惠券";
        }
        return (String) ipChange.ipc$dispatch("-1941098038", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149083914")) {
            ipChange.ipc$dispatch("-1149083914", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108998133")) {
            ipChange.ipc$dispatch("108998133", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907018872")) {
            ipChange.ipc$dispatch("-1907018872", new Object[]{this});
            return;
        }
        this.v_outside = findViewById(R$id.v_outside);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_bottom);
        this.rl_bottom = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((double) DisplayMetrics.getheightPixels(n42.b(getActivity()))) * 0.75d);
        this.rl_bottom.setLayoutParams(layoutParams);
        this.cancelIcon = (DMIconFontTextView) findViewById(R$id.text_ok);
        this.cancelIcon.setVisibility(getRightTextVis() ? 0 : 8);
        this.mTitleText = (TextView) findViewById(R$id.text_title);
        this.mLeftTitle = (TextView) findViewById(R$id.left_text_title);
        String titleContent = getTitleContent();
        TextView textView = this.mTitleText;
        if (titleContent == null) {
            titleContent = "";
        }
        textView.setText(titleContent);
        this.mTitleBottomLayout = (LinearLayout) findViewById(R$id.ll_title_bottom);
        this.mTitleBottomLine = findViewById(R$id.line_title);
        this.mTvTitleBottom = (TextView) findViewById(R$id.title_tip);
        this.mTitleBottomLayout.setVisibility(0);
        updateTitleBottomView(true, "");
        this.mBottomContentLayout = (LinearLayout) findViewById(R$id.ll_bottom_content);
        this.recyclerView = (RecyclerView) findViewById(R$id.rc);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAnimationView(this.rl_bottom);
        this.rl_bottom.startAnimation(AnimationUtils.loadAnimation(getActivity(), R$anim.activity_item_animshow));
        this.rl_bottom.setOnClickListener(null);
        this.v_outside.setOnClickListener(this);
        this.cancelIcon.setOnClickListener(this);
        findViewById(R$id.rl_title).setOnClickListener(null);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702706834")) {
            ipChange.ipc$dispatch("-702706834", new Object[]{this, view});
        } else if (view.getId() == R$id.v_outside || view.getId() == R$id.text_ok) {
            finishActivity();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916423314")) {
            return (View) ipChange.ipc$dispatch("1916423314", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        }
        return this.rootView;
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137925866")) {
            ipChange.ipc$dispatch("137925866", new Object[]{this});
            return;
        }
        onResponseSuccess(this.mBottomContentLayout);
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96926517")) {
            ipChange.ipc$dispatch("-96926517", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        initView();
        getData();
        setRecyclerView();
        this.mContext = getActivity();
        this.mTitleText.setVisibility(8);
        this.mLeftTitle.setText("优惠券");
        this.mLeftTitle.setVisibility(0);
        this.mTitleBottomLine.setVisibility(8);
        DMLabelView dMLabelView = (DMLabelView) findViewById(R$id.btn_confirm);
        dMLabelView.setVisibility(0);
        findViewById(R$id.rc_bottom).setVisibility(4);
        dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_BUYING).setLabelName("确定").setLabelTextSize(16.0f).setContentGravity(17).setCornerRadii((float) n42.a(getActivity(), 22.0f), (float) n42.a(getActivity(), 22.0f), (float) n42.a(getActivity(), 22.0f), (float) n42.a(getActivity(), 2.0f));
        dMLabelView.setOnClickListener(new b());
    }

    public void setAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226818052")) {
            ipChange.ipc$dispatch("-1226818052", new Object[]{this, view});
            return;
        }
        this.mAnimView = view;
    }

    public void updateTitleBottomView(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720091472")) {
            ipChange.ipc$dispatch("-1720091472", new Object[]{this, Boolean.valueOf(z), str});
        } else if (z || TextUtils.isEmpty(str)) {
            this.mTvTitleBottom.setVisibility(8);
            this.mTitleBottomLine.setVisibility(0);
        } else {
            this.mTvTitleBottom.setText(str);
            this.mTvTitleBottom.setVisibility(0);
            this.mTitleBottomLine.setVisibility(8);
        }
    }
}

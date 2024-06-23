package cn.damai.commonbusiness.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.bean.FollowEvent;
import cn.damai.commonbusiness.model.UserAttentionBean;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.br;
import tb.d20;
import tb.gt2;
import tb.wz1;
import tb.xf2;

/* compiled from: Taobao */
public class AttentionView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ATTENTION_TYPE = 1111;
    public static final String BIZ_ID = "biz_id";
    public static final String BIZ_TYPE = "biz_type";
    public static final int USER_TYPE_ARTIST = 2;
    public static final int USER_TYPE_BRAND = 4;
    public static final int USER_TYPE_CATEGORY = 9;
    public static final int USER_TYPE_REPERTOIRE = 5;
    public static final int USER_TYPE_USER = 1;
    public static final int USER_TYPE_VANUE = 3;
    View animView;
    private String area;
    private HashMap argsMap;
    int attention_backgroud;
    String attention_text;
    int attention_textColor;
    boolean cancelFollow;
    Map headData;
    List<AttentionView> listAttent;
    LinearLayout ll_follow;
    Context mContext;
    private boolean mMyself;
    private View.OnClickListener mOnAttentionClickDelegate;
    private String mPageBdian;
    private String mUserId;
    private String mUserType;
    private String module;
    int noattention_backgroud;
    String noattention_text;
    int noattention_textColor;
    String operateType;
    private String page;
    boolean showAnima;
    int state;
    private StateListener stateListener;
    String targetId;
    String targetType;
    boolean textVisiable;
    TextView tv_follow;
    String twoattention_text;

    /* compiled from: Taobao */
    public interface StateListener {
        void onStateChanged(int i);
    }

    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1698158482")) {
                ipChange.ipc$dispatch("-1698158482", new Object[]{this, animation});
            } else if (!AttentionView.this.textVisiable) {
                this.a.setVisibility(8);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "67835974")) {
                ipChange.ipc$dispatch("67835974", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1347528633")) {
                ipChange.ipc$dispatch("-1347528633", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1004765777")) {
                ipChange.ipc$dispatch("-1004765777", new Object[]{this, animation});
                return;
            }
            AttentionView attentionView = AttentionView.this;
            if (!attentionView.textVisiable) {
                attentionView.animView.setVisibility(8);
            }
            AttentionView.this.getRelationUpdateAndLogin();
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1862783131")) {
                ipChange.ipc$dispatch("-1862783131", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-717070008")) {
                ipChange.ipc$dispatch("-717070008", new Object[]{this, animation});
            }
        }
    }

    public AttentionView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r0.equals("互关") == false) goto L_0x0033;
     */
    private void getRelationUpdate() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-934778792")) {
            ipChange.ipc$dispatch("-934778792", new Object[]{this});
            return;
        }
        final String str = "0";
        if (this.tv_follow.getText() != null) {
            String charSequence = this.tv_follow.getText().toString();
            charSequence.hashCode();
            switch (charSequence.hashCode()) {
                case 644385:
                    break;
                case 674261:
                    if (charSequence.equals("关注")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 23786311:
                    if (charSequence.equals("已关注")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    str = "2";
                    break;
                case 2:
                    str = "1";
                    break;
            }
        }
        if (!xf2.j(this.targetId) && !xf2.j(this.targetType)) {
            AttentionTribeEntranceRequest attentionTribeEntranceRequest = new AttentionTribeEntranceRequest();
            attentionTribeEntranceRequest.operateType = this.operateType;
            attentionTribeEntranceRequest.targetId = this.targetId;
            attentionTribeEntranceRequest.targetType = this.targetType;
            attentionTribeEntranceRequest.request(new DMMtopRequestListener<UserAttentionBean.DataBean>(UserAttentionBean.DataBean.class) {
                /* class cn.damai.commonbusiness.view.AttentionView.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1275854595")) {
                        ipChange.ipc$dispatch("-1275854595", new Object[]{this, str, str2});
                        return;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        ToastUtil.i(str2);
                    }
                    AttentionView.this.ll_follow.setAlpha(1.0f);
                    AttentionView.this.setVisibility(0);
                }

                public void onSuccess(UserAttentionBean.DataBean dataBean) {
                    String str;
                    IpChange ipChange = $ipChange;
                    boolean z = false;
                    if (AndroidInstantRuntime.support(ipChange, "-890452667")) {
                        ipChange.ipc$dispatch("-890452667", new Object[]{this, dataBean});
                    } else if (dataBean != null) {
                        int status = dataBean.getStatus();
                        if (status == 1 || status == 2) {
                            z = true;
                        }
                        br.c(FollowEvent.LIVE_FOLLOW_EVENT, Boolean.valueOf(z));
                        AttentionView.this.setState(dataBean.getStatus());
                        if (!TextUtils.isEmpty(AttentionView.this.targetId)) {
                            AttentionView attentionView = AttentionView.this;
                            attentionView.postAttentionState(attentionView.state);
                        }
                        if (!xf2.j(AttentionView.this.page)) {
                            str = AttentionView.this.page;
                        } else if ("5".equals(AttentionView.this.targetType)) {
                            str = wz1.REPERTOITE;
                        } else if ("4".equals(AttentionView.this.targetType)) {
                            str = "brand";
                        } else {
                            str = !"1".equals(AttentionView.this.targetType) ? !TextUtils.isEmpty(AttentionView.this.mPageBdian) ? AttentionView.this.mPageBdian : "business_homepage" : gt2.USER_HOME_PAGE;
                        }
                        c.e().M(AttentionView.this.mContext, str);
                        HashMap hashMap = new HashMap();
                        hashMap.put("usercode", d20.E());
                        hashMap.put("biz_id", AttentionView.this.targetId);
                        hashMap.put("biz_type", AttentionView.this.targetType);
                        hashMap.put("titlelabel", AttentionView.this.targetId + "&" + str);
                        hashMap.put("status", str);
                        String str2 = !TextUtils.isEmpty(AttentionView.this.module) ? AttentionView.this.module : "account_info";
                        if (!TextUtils.isEmpty(AttentionView.this.area)) {
                            hashMap.put(Constants.ACTION_PARAMS_AREA, AttentionView.this.area);
                        }
                        if (AttentionView.this.argsMap != null) {
                            hashMap.putAll(AttentionView.this.argsMap);
                        }
                        c.e().x(new cn.damai.common.user.b().e(str, str2, "follow_btn", hashMap, Boolean.FALSE));
                    }
                }
            });
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512283170")) {
            ipChange.ipc$dispatch("1512283170", new Object[]{this});
            return;
        }
        this.listAttent.add(this);
        LayoutInflater.from(this.mContext).inflate(R$layout.attention_view, (ViewGroup) this, true);
        this.ll_follow = (LinearLayout) findViewById(R$id.ll_follow);
        this.tv_follow = (TextView) findViewById(R$id.tv_follow);
        this.ll_follow.setBackgroundResource(this.noattention_backgroud);
        this.tv_follow.setTextColor(ContextCompat.getColor(this.mContext, this.noattention_textColor));
        this.tv_follow.setText("关注");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postAttentionState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56276383")) {
            ipChange.ipc$dispatch("56276383", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ArtistFollowResultBean artistFollowResultBean = new ArtistFollowResultBean();
        artistFollowResultBean.setArtistId(this.targetId);
        artistFollowResultBean.setFollowStatus(i);
        artistFollowResultBean.targetType = this.targetType;
        new br();
        br.c("artist_follow_status", artistFollowResultBean);
    }

    private void setAttentionListView(List<AttentionView> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551682633")) {
            ipChange.ipc$dispatch("551682633", new Object[]{this, list});
            return;
        }
        this.listAttent = list;
    }

    private void setRelevanceAttentionState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288952234")) {
            ipChange.ipc$dispatch("-288952234", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.ll_follow.setOnClickListener(this);
        this.state = i;
        if (i == 1) {
            this.operateType = "0";
            this.ll_follow.setBackgroundResource(this.attention_backgroud);
            this.tv_follow.setTextColor(ContextCompat.getColor(this.mContext, this.attention_textColor));
            this.tv_follow.setText(this.attention_text);
            if (!this.textVisiable) {
                setVisibility(8);
            }
        } else if (i == 2) {
            this.operateType = "0";
            this.ll_follow.setBackgroundResource(this.attention_backgroud);
            this.tv_follow.setTextColor(ContextCompat.getColor(this.mContext, this.attention_textColor));
            this.tv_follow.setText(this.twoattention_text);
            if (!this.textVisiable) {
                setVisibility(8);
            }
        } else {
            this.operateType = "1";
            this.ll_follow.setBackgroundResource(this.noattention_backgroud);
            this.tv_follow.setTextColor(ContextCompat.getColor(this.mContext, this.noattention_textColor));
            this.tv_follow.setText(this.noattention_text);
            setVisibility(0);
            postInvalidate();
        }
        StateListener stateListener2 = this.stateListener;
        if (stateListener2 != null) {
            stateListener2.onStateChanged(i);
        }
    }

    private void showAnima(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1945456146")) {
            ipChange.ipc$dispatch("1945456146", new Object[]{this, view});
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R$anim.rotate_right);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        loadAnimation.setInterpolator(linearInterpolator);
        loadAnimation.setAnimationListener(new a(view));
        view.startAnimation(loadAnimation);
        if (this.animView != null) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, R$anim.rotate_left);
            loadAnimation2.setInterpolator(linearInterpolator);
            this.animView.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(500);
            animationSet.addAnimation(loadAnimation2);
            this.animView.startAnimation(animationSet);
            animationSet.setAnimationListener(new b());
        }
    }

    public void addAttentionView(AttentionView attentionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769469438")) {
            ipChange.ipc$dispatch("-769469438", new Object[]{this, attentionView});
            return;
        }
        List<AttentionView> list = this.listAttent;
        if (list != null) {
            list.add(attentionView);
            for (int i = 0; i < this.listAttent.size(); i++) {
                AttentionView attentionView2 = this.listAttent.get(i);
                if (attentionView2 != this) {
                    attentionView2.setAttentionListView(this.listAttent);
                }
            }
        }
    }

    public void callClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444291849")) {
            ipChange.ipc$dispatch("1444291849", new Object[]{this});
            return;
        }
        onClick(this.ll_follow);
    }

    public void cleanAttenList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985531832")) {
            ipChange.ipc$dispatch("1985531832", new Object[]{this});
            return;
        }
        List<AttentionView> list = this.listAttent;
        if (list != null) {
            list.clear();
            this.listAttent = null;
        }
    }

    public boolean followed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339677195")) {
            return ((Boolean) ipChange.ipc$dispatch("1339677195", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 1 || i == 2;
    }

    public void getRelationUpdateAndLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087373274")) {
            ipChange.ipc$dispatch("-1087373274", new Object[]{this});
        } else if (LoginManager.k().q()) {
            getRelationUpdate();
        } else if (this.mContext != null) {
            LoginManager.k().x((Activity) this.mContext, new Intent(), 1111);
        }
    }

    public int getState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1160865969")) {
            return this.state;
        }
        return ((Integer) ipChange.ipc$dispatch("-1160865969", new Object[]{this})).intValue();
    }

    public boolean isCancelFollow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1431935334")) {
            return this.cancelFollow;
        }
        return ((Boolean) ipChange.ipc$dispatch("1431935334", new Object[]{this})).booleanValue();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593529463")) {
            ipChange.ipc$dispatch("-1593529463", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i == 1111) {
            getRelationUpdate();
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057355656")) {
            ipChange.ipc$dispatch("2057355656", new Object[]{this, view});
        } else if (view.getId() != R$id.ll_follow) {
        } else {
            if (this.state <= 0 || this.cancelFollow) {
                View.OnClickListener onClickListener = this.mOnAttentionClickDelegate;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                } else if (!LoginManager.k().q()) {
                    DMNav.from(getContext()).forResult(100).toUri(NavUri.b("login"));
                } else if (this.showAnima) {
                    showAnima(view);
                } else {
                    getRelationUpdateAndLogin();
                }
            }
        }
    }

    public void setArea(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421355282")) {
            ipChange.ipc$dispatch("-421355282", new Object[]{this, str});
            return;
        }
        this.area = str;
    }

    public void setArgsMap(HashMap hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001321607")) {
            ipChange.ipc$dispatch("-2001321607", new Object[]{this, hashMap});
            return;
        }
        this.argsMap = hashMap;
    }

    public void setBackGroundState(@DrawableRes int i, @DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971530314")) {
            ipChange.ipc$dispatch("-1971530314", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.attention_backgroud = i;
        this.noattention_backgroud = i2;
    }

    public void setCancelFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806384018")) {
            ipChange.ipc$dispatch("-806384018", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.cancelFollow = z;
    }

    public void setHeadData(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869879106")) {
            ipChange.ipc$dispatch("-1869879106", new Object[]{this, map});
            return;
        }
        this.headData = map;
    }

    public void setInitParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874844655")) {
            ipChange.ipc$dispatch("1874844655", new Object[]{this, str, str2});
            return;
        }
        this.targetId = str;
        this.targetType = str2;
    }

    public void setModule(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421972847")) {
            ipChange.ipc$dispatch("1421972847", new Object[]{this, str});
            return;
        }
        this.module = str;
    }

    public void setMoreInitParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944841958")) {
            ipChange.ipc$dispatch("-944841958", new Object[]{this, str, str2});
            return;
        }
        for (int i = 0; i < this.listAttent.size(); i++) {
            this.listAttent.get(i).setInitParams(str, str2);
        }
    }

    public void setMoreVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669714151")) {
            ipChange.ipc$dispatch("-669714151", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < this.listAttent.size(); i2++) {
            this.listAttent.get(i2).setVisibility(i);
        }
    }

    public void setOnAttentionClickDelegate(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507428426")) {
            ipChange.ipc$dispatch("-507428426", new Object[]{this, onClickListener});
            return;
        }
        this.mOnAttentionClickDelegate = onClickListener;
    }

    public void setPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1743338452")) {
            ipChange.ipc$dispatch("-1743338452", new Object[]{this, str});
            return;
        }
        this.page = str;
    }

    public void setPageBdian(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146779714")) {
            ipChange.ipc$dispatch("-146779714", new Object[]{this, str});
            return;
        }
        this.mPageBdian = str;
    }

    public void setResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189542292")) {
            ipChange.ipc$dispatch("189542292", new Object[]{this});
        } else if (this.state != -1) {
            Intent intent = new Intent();
            intent.putExtra("targetId", this.targetId);
            intent.putExtra("state", this.state);
            Context context = this.mContext;
            if (context != null && !((Activity) context).isFinishing()) {
                ((Activity) this.mContext).setResult(-1, intent);
            }
        }
    }

    public void setShowAnima(boolean z, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335749316")) {
            ipChange.ipc$dispatch("1335749316", new Object[]{this, Boolean.valueOf(z), view});
            return;
        }
        this.showAnima = z;
        this.animView = view;
    }

    public void setState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78084197")) {
            ipChange.ipc$dispatch("-78084197", new Object[]{this, Integer.valueOf(i)});
        } else if (this.listAttent != null) {
            for (int i2 = 0; i2 < this.listAttent.size(); i2++) {
                this.listAttent.get(i2).setRelevanceAttentionState(i);
            }
        }
    }

    public void setStateListener(StateListener stateListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383069568")) {
            ipChange.ipc$dispatch("-383069568", new Object[]{this, stateListener2});
            return;
        }
        this.stateListener = stateListener2;
    }

    public void setTextColorState(@ColorRes int i, @ColorRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293259734")) {
            ipChange.ipc$dispatch("293259734", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.attention_textColor = i;
        this.noattention_textColor = i2;
    }

    public void setTextVisiable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831185773")) {
            ipChange.ipc$dispatch("-1831185773", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.textVisiable = z;
        if (z) {
            this.tv_follow.setVisibility(0);
        } else {
            this.tv_follow.setVisibility(8);
        }
    }

    public void setUser(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686893530")) {
            ipChange.ipc$dispatch("1686893530", new Object[]{this, str, str2, Boolean.valueOf(z)});
            return;
        }
        this.mUserId = str;
        this.mUserType = str2;
        this.mMyself = z;
    }

    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127310236")) {
            ipChange.ipc$dispatch("-1127310236", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setVisibility(i);
        this.ll_follow.setVisibility(i);
    }

    public AttentionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttentionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.operateType = "1";
        this.state = -1;
        this.listAttent = new ArrayList();
        this.cancelFollow = true;
        this.showAnima = false;
        int i2 = R$drawable.attention_btn_followed_normal;
        this.attention_backgroud = i2;
        int i3 = R$drawable.star_attention_bg_red;
        this.noattention_backgroud = i3;
        int i4 = R$color.white;
        this.attention_textColor = i4;
        this.noattention_textColor = i4;
        this.attention_text = "已关注";
        this.noattention_text = "关注";
        this.twoattention_text = "互关";
        this.mUserId = "";
        this.mUserType = "";
        this.textVisiable = true;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AttentionView);
        if (obtainStyledAttributes != null) {
            this.attention_backgroud = obtainStyledAttributes.getResourceId(R$styleable.AttentionView_attention_backgroud, i2);
            this.attention_textColor = obtainStyledAttributes.getResourceId(R$styleable.AttentionView_attention_textColor, i4);
            this.noattention_backgroud = obtainStyledAttributes.getResourceId(R$styleable.AttentionView_noattention_backgroud, i3);
            this.noattention_textColor = obtainStyledAttributes.getResourceId(R$styleable.AttentionView_noattention_textColor, i4);
            this.attention_text = obtainStyledAttributes.getString(R$styleable.AttentionView_attention_text);
            this.noattention_text = obtainStyledAttributes.getString(R$styleable.AttentionView_noattention_text);
            this.twoattention_text = obtainStyledAttributes.getString(R$styleable.AttentionView_twoattention_text);
            obtainStyledAttributes.recycle();
        }
        if (xf2.j(this.attention_text)) {
            this.attention_text = "已关注";
        }
        if (xf2.j(this.noattention_text)) {
            this.noattention_text = "关注";
        }
        if (xf2.j(this.twoattention_text)) {
            this.twoattention_text = "互关";
        }
        initView();
    }
}

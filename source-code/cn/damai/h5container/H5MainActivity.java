package cn.damai.h5container;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.DamaiConstants;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.bean.ShareParams;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.h5container.WebViewFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import tb.hp1;
import tb.ln2;
import tb.lp1;
import tb.ne2;
import tb.p21;
import tb.q92;
import tb.xf2;

/* compiled from: Taobao */
public class H5MainActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_ALBUM = 257;
    public static final int REQUEST_CORP = 259;
    public static final int REQUEST_LOGIN = 10;
    public static final int REQUEST_REALNAME = 260;
    public static final int REQUEST_TAKE_PHOTO = 258;
    boolean forceBack = false;
    WebViewFragment fragment;
    DMIconFontTextView iconFontTextView;
    boolean rotate = true;

    private View getCopyLinkView(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-285545474")) {
            return q92.c(this.mContext, typeInfo.url);
        }
        return (View) ipChange.ipc$dispatch("-285545474", new Object[]{this, typeInfo});
    }

    private View getEditView(final ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "164537529")) {
            return q92.e(this.mContext, new View.OnClickListener() {
                /* class cn.damai.h5container.H5MainActivity.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1171101481")) {
                        ipChange.ipc$dispatch("1171101481", new Object[]{this, view});
                        return;
                    }
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EDIT);
                        bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, typeInfo.commentId);
                        bundle.putString("projectName", typeInfo.projectName);
                        bundle.putInt(p21.ISSUE_PARAM_GRADES, typeInfo.currentScore);
                        bundle.putString("text", typeInfo.content);
                        bundle.putStringArrayList("images", H5MainActivity.getEvaluateImageList(typeInfo.editImgJson));
                        bundle.putString("circleId", typeInfo.circleId);
                        bundle.putString("circleName", typeInfo.circleName);
                        DMNav.from(H5MainActivity.this.mContext).withExtras(bundle).toUri(NavUri.b("issue"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        ShareManager.E().C();
                        throw th;
                    }
                    ShareManager.E().C();
                }
            });
        }
        return (View) ipChange.ipc$dispatch("164537529", new Object[]{this, typeInfo});
    }

    /* access modifiers changed from: private */
    public static ArrayList<String> getEvaluateImageList(ArrayList<ShareParams.EditImgJson> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572087078")) {
            return (ArrayList) ipChange.ipc$dispatch("572087078", new Object[]{arrayList});
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < xf2.e(arrayList); i++) {
            try {
                ShareParams.EditImgJson editImgJson = arrayList.get(i);
                if (editImgJson != null) {
                    arrayList2.add(editImgJson.url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList2;
    }

    private View getGenerateImageView(final ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2078572573")) {
            return q92.f(this.mContext, new View.OnClickListener() {
                /* class cn.damai.h5container.H5MainActivity.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1012575446")) {
                        ipChange.ipc$dispatch("-1012575446", new Object[]{this, view});
                        return;
                    }
                    try {
                        final DMShareMessage dMShareMessage = new DMShareMessage();
                        dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE;
                        ShareParams.TypeInfo typeInfo = typeInfo;
                        dMShareMessage.sharePictureUrl = typeInfo.imageUrl;
                        dMShareMessage.shareTitle = typeInfo.title;
                        dMShareMessage.shareContent = typeInfo.content;
                        dMShareMessage.shareLink = typeInfo.url;
                        dMShareMessage.fromWhere = ln2.PROJECT_EVALUATE;
                        dMShareMessage.userNick = typeInfo.userNick;
                        dMShareMessage.userHeaderIcon = typeInfo.userIcon;
                        dMShareMessage.evaluateGrade = typeInfo.currentScore;
                        dMShareMessage.evaluateTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Long.valueOf(typeInfo.evaluateTime));
                        hp1.b(H5MainActivity.this, false, lp1.STORAGE, "才能分享图片～", new OnGrantListener() {
                            /* class cn.damai.h5container.H5MainActivity.AnonymousClass5.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // cn.damai.common.askpermission.OnGrantListener
                            public void onGranted() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1562461272")) {
                                    ipChange.ipc$dispatch("-1562461272", new Object[]{this});
                                    return;
                                }
                                GenerateImageUtil.p(H5MainActivity.this, dMShareMessage);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        ShareManager.E().C();
                        throw th;
                    }
                    ShareManager.E().C();
                }
            });
        }
        return (View) ipChange.ipc$dispatch("-2078572573", new Object[]{this, typeInfo});
    }

    private View getReportIcon(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2126352905")) {
            return ShareManager.E().F(this.mContext, 0, typeInfo.id, typeInfo.type);
        }
        return (View) ipChange.ipc$dispatch("-2126352905", new Object[]{this, typeInfo});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private View getToolsView(ShareParams.Plugin plugin) {
        View generateImageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058692403")) {
            return (View) ipChange.ipc$dispatch("-1058692403", new Object[]{this, plugin});
        } else if (plugin == null) {
            return null;
        } else {
            try {
                if (plugin.typeInfo == null) {
                    return null;
                }
                if ("report".equals(plugin.type)) {
                    generateImageView = getReportIcon(plugin.typeInfo);
                } else if ("evaluateEdit".equals(plugin.type)) {
                    generateImageView = getEditView(plugin.typeInfo);
                } else if ("copyUrl".equals(plugin.type)) {
                    generateImageView = getCopyLinkView(plugin.typeInfo);
                } else if (!"generateImage".equals(plugin.type)) {
                    return null;
                } else {
                    generateImageView = getGenerateImageView(plugin.typeInfo);
                }
                return generateImageView;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305689242")) {
            ipChange.ipc$dispatch("1305689242", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            findViewById.setBackgroundColor(getColor(R$color.white));
            ne2.d(true, this);
            return;
        }
        findViewById.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254517680")) {
            ipChange.ipc$dispatch("-254517680", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public WebViewFragment getFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1513572182")) {
            return this.fragment;
        }
        return (WebViewFragment) ipChange.ipc$dispatch("1513572182", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "326263194")) {
            return R$layout.webview_activity2;
        }
        return ((Integer) ipChange.ipc$dispatch("326263194", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337774303")) {
            ipChange.ipc$dispatch("-337774303", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void hideNaveBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343646445")) {
            ipChange.ipc$dispatch("-343646445", new Object[]{this});
            return;
        }
        findViewById(R$id.webview_nav_bar).setVisibility(8);
    }

    public void hideShareMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777047194")) {
            ipChange.ipc$dispatch("-777047194", new Object[]{this});
            return;
        }
        DMIconFontTextView dMIconFontTextView = this.iconFontTextView;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setVisibility(4);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510207702")) {
            ipChange.ipc$dispatch("-510207702", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        Uri parse;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1347590963")) {
            ipChange.ipc$dispatch("1347590963", new Object[]{this});
            return;
        }
        hideBaseLayout();
        setImmersionStyle();
        AndroidBug5497Workaround.assistActivity(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(DamaiConstants.KEY_H5_CONTAINER_HIDE_BACK) && extras.getBoolean(DamaiConstants.KEY_H5_CONTAINER_HIDE_BACK)) {
            setLeftNothing();
        }
        if (extras != null && extras.containsKey(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR)) {
            String string = extras.getString(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR);
            if (!TextUtils.isEmpty(string)) {
                z = string.equals("1");
            } else {
                z = extras.getInt(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR) == 1;
            }
            if (z) {
                hideNaveBar();
            }
        } else if (!(extras == null || !extras.containsKey("url") || extras.getString("url") == null)) {
            String str = null;
            try {
                str = Uri.parse(extras.getString("url")).getQueryParameter(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str != null && "1".equals(str)) {
                hideNaveBar();
            }
        }
        if (!(extras == null || !extras.containsKey("url") || extras.getString("url") == null)) {
            try {
                this.forceBack = Uri.parse(extras.getString("url")).getBooleanQueryParameter("forceBack", false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.fragment = new WebViewFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.fragment_view, this.fragment);
        beginTransaction.commitAllowingStateLoss();
        if (extras != null && !"false".equals(extras.getString("loading", "true")) && !xf2.j(extras.getString("url")) && (parse = Uri.parse(extras.getString("url"))) != null && !"false".equalsIgnoreCase(parse.getQueryParameter("loading"))) {
            startProgressDialog(parse.getQueryParameter("loadingTips"));
        }
        if (extras == null || (!"false".equals(extras.getString("rotate", "true")) && !extras.getString("url", "").contains("rotate=false"))) {
            this.rotate = true;
        } else {
            this.rotate = false;
        }
        this.fragment.setListener(new WebViewFragment.LoadListener() {
            /* class cn.damai.h5container.H5MainActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.h5container.WebViewFragment.LoadListener
            public void onLoadFinish() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1616800221")) {
                    ipChange.ipc$dispatch("1616800221", new Object[]{this});
                    return;
                }
                H5MainActivity.this.stopProgressDialog();
            }
        });
        findViewById(R$id.webview_goback).setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.h5container.H5MainActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1243488039")) {
                    ipChange.ipc$dispatch("1243488039", new Object[]{this, view});
                    return;
                }
                H5MainActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192797786")) {
            ipChange.ipc$dispatch("1192797786", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.fragment.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-152668090")) {
            ipChange.ipc$dispatch("-152668090", new Object[]{this});
        } else if (this.forceBack) {
            super.onBackPressed();
        } else if (!this.fragment.backPressed()) {
            setResult(-1);
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164921127")) {
            ipChange.ipc$dispatch("164921127", new Object[]{this});
            return;
        }
        super.onDestroy();
        stopProgressDialog();
        DMBridge.destory();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904776272")) {
            ipChange.ipc$dispatch("904776272", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751355451")) {
            ipChange.ipc$dispatch("-751355451", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018417852")) {
            ipChange.ipc$dispatch("2018417852", new Object[]{this});
            return;
        }
        super.onResume();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void setLeftNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136908188")) {
            ipChange.ipc$dispatch("-2136908188", new Object[]{this});
            return;
        }
        findViewById(R$id.webview_goback).setVisibility(8);
    }

    public void setRequestedOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60626661")) {
            ipChange.ipc$dispatch("60626661", new Object[]{this, Integer.valueOf(i)});
        } else if (this.rotate) {
            super.setRequestedOrientation(i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2048626034")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-2048626034", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void setTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179596041")) {
            ipChange.ipc$dispatch("1179596041", new Object[]{this, str});
        } else if (str != null) {
            ((TextView) findViewById(R$id.webview_titile)).setText(str);
        }
    }

    public void showShareMenu(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432363631")) {
            ipChange.ipc$dispatch("1432363631", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            try {
                final ShareParams shareParams = (ShareParams) JSON.parseObject(jSONObject.toString(), ShareParams.class);
                if (shareParams != null || shareParams.share == null) {
                    DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.webview_share);
                    this.iconFontTextView = dMIconFontTextView;
                    dMIconFontTextView.setVisibility(0);
                    this.iconFontTextView.setOnClickListener(new View.OnClickListener() {
                        /* class cn.damai.h5container.H5MainActivity.AnonymousClass3 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onClick(View view) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-940188888")) {
                                ipChange.ipc$dispatch("-940188888", new Object[]{this, view});
                            } else if (H5MainActivity.this.iconFontTextView.getVisibility() == 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString("title", shareParams.share.title);
                                bundle.putString("message", shareParams.share.description);
                                bundle.putString("imageurl", shareParams.share.image);
                                bundle.putString("producturl", shareParams.share.url);
                                bundle.putString("fromWhere", "H5");
                                bundle.putBoolean("hideCopyLink", true);
                                ShareManager E = ShareManager.E();
                                H5MainActivity h5MainActivity = H5MainActivity.this;
                                E.T(h5MainActivity, bundle, h5MainActivity.findViewById(R$id.fragment_view));
                                ArrayList<ShareParams.Plugin> arrayList = shareParams.plugins;
                                int e = xf2.e(arrayList);
                                if (e > 0) {
                                    LinearLayout linearLayout = new LinearLayout(H5MainActivity.this.mContext);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                    linearLayout.setOrientation(0);
                                    linearLayout.setLayoutParams(layoutParams);
                                    for (int i = 0; i < e; i++) {
                                        View toolsView = H5MainActivity.this.getToolsView(arrayList.get(i));
                                        if (toolsView != null) {
                                            linearLayout.addView(toolsView);
                                        }
                                    }
                                    if (linearLayout.getChildCount() > 0) {
                                        ShareManager.E().e0(linearLayout);
                                    }
                                }
                                ShareManager.E().l0();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

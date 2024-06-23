package cn.damai.h5container;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.bean.ShareParams;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.ui.TaoMaiH5Activity;
import com.taomai.android.h5container.ui.TaoMaiUCH5Fragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hp1;
import tb.k21;
import tb.ln2;
import tb.lp1;
import tb.m40;
import tb.p21;
import tb.q92;
import tb.qq;
import tb.rq;
import tb.sq;
import tb.tq;
import tb.xf2;

/* compiled from: Taobao */
public final class DMH5Activity extends TaoMaiH5Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean forceBack;
    private boolean rotate = true;

    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final ArrayList<String> getEvaluateImageList(ArrayList<ShareParams.EditImgJson> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1921699282")) {
                return (ArrayList) ipChange.ipc$dispatch("-1921699282", new Object[]{this, arrayList});
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            try {
                int e = xf2.e(arrayList);
                for (int i = 0; i < e; i++) {
                    ShareParams.EditImgJson editImgJson = arrayList.get(i);
                    k21.h(editImgJson, "images[i]");
                    arrayList2.add(editImgJson.url);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList2;
        }
    }

    private final View getCopyLinkView(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-262386322")) {
            return q92.c(this, typeInfo.url);
        }
        return (View) ipChange.ipc$dispatch("-262386322", new Object[]{this, typeInfo});
    }

    private final View getEditView(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-428196311")) {
            return q92.e(this, new qq(typeInfo, this));
        }
        return (View) ipChange.ipc$dispatch("-428196311", new Object[]{this, typeInfo});
    }

    /* access modifiers changed from: private */
    /* renamed from: getEditView$lambda-2  reason: not valid java name */
    public static final void m23getEditView$lambda2(ShareParams.TypeInfo typeInfo, DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557566131")) {
            ipChange.ipc$dispatch("1557566131", new Object[]{typeInfo, dMH5Activity, view});
            return;
        }
        k21.i(typeInfo, "$typeInfo");
        k21.i(dMH5Activity, "this$0");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EDIT);
            bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, typeInfo.commentId);
            bundle.putString("projectName", typeInfo.projectName);
            bundle.putInt(p21.ISSUE_PARAM_GRADES, typeInfo.currentScore);
            bundle.putString("text", typeInfo.content);
            Companion companion = Companion;
            ArrayList<ShareParams.EditImgJson> arrayList = typeInfo.editImgJson;
            k21.h(arrayList, "typeInfo.editImgJson");
            bundle.putStringArrayList("images", companion.getEvaluateImageList(arrayList));
            bundle.putString("circleId", typeInfo.circleId);
            bundle.putString("circleName", typeInfo.circleName);
            DMNav.from(dMH5Activity).withExtras(bundle).toUri(NavUri.b("issue"));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ShareManager.E().C();
            throw th;
        }
        ShareManager.E().C();
    }

    private final View getGenerateImageView(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2089649267")) {
            return q92.f(this, new rq(typeInfo, this));
        }
        return (View) ipChange.ipc$dispatch("2089649267", new Object[]{this, typeInfo});
    }

    /* access modifiers changed from: private */
    /* renamed from: getGenerateImageView$lambda-4  reason: not valid java name */
    public static final void m24getGenerateImageView$lambda4(ShareParams.TypeInfo typeInfo, DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907728853")) {
            ipChange.ipc$dispatch("-907728853", new Object[]{typeInfo, dMH5Activity, view});
            return;
        }
        k21.i(typeInfo, "$typeInfo");
        k21.i(dMH5Activity, "this$0");
        try {
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE;
            dMShareMessage.sharePictureUrl = typeInfo.imageUrl;
            dMShareMessage.shareTitle = typeInfo.title;
            dMShareMessage.shareContent = typeInfo.content;
            dMShareMessage.shareLink = typeInfo.url;
            dMShareMessage.fromWhere = ln2.PROJECT_EVALUATE;
            dMShareMessage.userNick = typeInfo.userNick;
            dMShareMessage.userHeaderIcon = typeInfo.userIcon;
            dMShareMessage.evaluateGrade = typeInfo.currentScore;
            dMShareMessage.evaluateTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Long.valueOf(typeInfo.evaluateTime));
            hp1.b(dMH5Activity, false, lp1.STORAGE, "才能分享图片～", new tq(dMH5Activity, dMShareMessage));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ShareManager.E().C();
            throw th;
        }
        ShareManager.E().C();
    }

    /* access modifiers changed from: private */
    /* renamed from: getGenerateImageView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m25getGenerateImageView$lambda4$lambda3(DMH5Activity dMH5Activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324013986")) {
            ipChange.ipc$dispatch("-1324013986", new Object[]{dMH5Activity, dMShareMessage});
            return;
        }
        k21.i(dMH5Activity, "this$0");
        k21.i(dMShareMessage, "$message");
        GenerateImageUtil.p(dMH5Activity, dMShareMessage);
    }

    private final View getReportIcon(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-512922777")) {
            return ShareManager.E().F(this, 0, typeInfo.id, typeInfo.type);
        }
        return (View) ipChange.ipc$dispatch("-512922777", new Object[]{this, typeInfo});
    }

    private final View getToolsView(ShareParams.Plugin plugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1554586461")) {
            return (View) ipChange.ipc$dispatch("1554586461", new Object[]{this, plugin});
        } else if (plugin == null) {
            return null;
        } else {
            try {
                if (plugin.typeInfo == null) {
                    return null;
                }
                if (k21.d("report", plugin.type)) {
                    ShareParams.TypeInfo typeInfo = plugin.typeInfo;
                    k21.h(typeInfo, "plugin.typeInfo");
                    return getReportIcon(typeInfo);
                } else if (k21.d("evaluateEdit", plugin.type)) {
                    ShareParams.TypeInfo typeInfo2 = plugin.typeInfo;
                    k21.h(typeInfo2, "plugin.typeInfo");
                    return getEditView(typeInfo2);
                } else if (k21.d("copyUrl", plugin.type)) {
                    ShareParams.TypeInfo typeInfo3 = plugin.typeInfo;
                    k21.h(typeInfo3, "plugin.typeInfo");
                    return getCopyLinkView(typeInfo3);
                } else if (!k21.d("generateImage", plugin.type)) {
                    return null;
                } else {
                    ShareParams.TypeInfo typeInfo4 = plugin.typeInfo;
                    k21.h(typeInfo4, "plugin.typeInfo");
                    return getGenerateImageView(typeInfo4);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private final void hideNavBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017593658")) {
            ipChange.ipc$dispatch("-2017593658", new Object[]{this});
            return;
        }
        Fragment fragment = getFragment();
        TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
        if (taoMaiUCH5Fragment != null) {
            taoMaiUCH5Fragment.hideWebTitle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showShareMenu$lambda-1  reason: not valid java name */
    public static final void m26showShareMenu$lambda1(ShareParams shareParams, DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071402362")) {
            ipChange.ipc$dispatch("-1071402362", new Object[]{shareParams, dMH5Activity, view});
            return;
        }
        k21.i(shareParams, "$shareParams");
        k21.i(dMH5Activity, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("title", shareParams.share.title);
        bundle.putString("message", shareParams.share.description);
        bundle.putString("imageurl", shareParams.share.image);
        bundle.putString("producturl", shareParams.share.url);
        bundle.putString("fromWhere", "H5");
        bundle.putBoolean("hideCopyLink", true);
        ShareManager.E().T(dMH5Activity, bundle, dMH5Activity.getWindow().getDecorView());
        ArrayList<ShareParams.Plugin> arrayList = shareParams.plugins;
        int e = xf2.e(arrayList);
        if (e > 0) {
            LinearLayout linearLayout = new LinearLayout(dMH5Activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            for (int i = 0; i < e; i++) {
                View toolsView = dMH5Activity.getToolsView(arrayList.get(i));
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

    @Override // com.taomai.android.h5container.ui.TaoMaiH5Activity
    @NotNull
    public Fragment createFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1043184930")) {
            return new DMH5Fragment();
        }
        return (Fragment) ipChange.ipc$dispatch("1043184930", new Object[]{this});
    }

    public final void hideShareMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720847882")) {
            ipChange.ipc$dispatch("-720847882", new Object[]{this});
            return;
        }
        Fragment fragment = getFragment();
        TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
        if (taoMaiUCH5Fragment != null) {
            taoMaiUCH5Fragment.hideWebOptionMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, com.taomai.android.h5container.ui.TaoMaiH5Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96468778")) {
            ipChange.ipc$dispatch("-96468778", new Object[]{this});
        } else if (this.forceBack) {
            finish();
        } else {
            setResult(-1);
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        if (kotlin.text.StringsKt__StringsKt.Q(r7, "rotate=false", false, 2, null) == false) goto L_0x0086;
     */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.taomai.android.h5container.ui.TaoMaiH5Activity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1162397367")) {
            ipChange.ipc$dispatch("1162397367", new Object[]{this, bundle});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(DamaiConstants.KEY_H5_CONTAINER_HIDE_BACK) && extras.getBoolean(DamaiConstants.KEY_H5_CONTAINER_HIDE_BACK)) {
            extras.putString(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR, "1");
        }
        super.onCreate(bundle);
        if (!(extras == null || !extras.containsKey("url") || extras.getString("url") == null)) {
            try {
                this.forceBack = Uri.parse(extras.getString("url")).getBooleanQueryParameter("forceBack", false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (extras != null) {
            if (!k21.d("false", extras.getString("rotate", "true"))) {
                String string = extras.getString("url", "");
                k21.h(string, "bundle.getString(\"url\", \"\")");
            }
            z = false;
        }
        this.rotate = z;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941043785")) {
            ipChange.ipc$dispatch("-941043785", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    public void setRequestedOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382782037")) {
            ipChange.ipc$dispatch("1382782037", new Object[]{this, Integer.valueOf(i)});
        } else if (this.rotate) {
            super.setRequestedOrientation(i);
        }
    }

    public final void setTitleContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074006937")) {
            ipChange.ipc$dispatch("2074006937", new Object[]{this, str});
        } else if (str != null) {
            Fragment fragment = getFragment();
            TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
            if (taoMaiUCH5Fragment != null) {
                taoMaiUCH5Fragment.setWebTitle(str);
            }
        }
    }

    public final void showShareMenu(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590736351")) {
            ipChange.ipc$dispatch("590736351", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            try {
                ShareParams shareParams = (ShareParams) JSON.parseObject(jSONObject.toString(), ShareParams.class);
                if (shareParams != null && shareParams.share == null) {
                    Fragment fragment = getFragment();
                    TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
                    if (taoMaiUCH5Fragment != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("icontype", (Object) "share");
                        taoMaiUCH5Fragment.setWebOptionMenu(jSONObject2, new sq(shareParams, this));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

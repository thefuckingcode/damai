package com.taomai.android.h5container.api;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import com.taomai.android.h5container.widget.InputDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j91;
import tb.k21;
import tb.lf2;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u0014"}, d2 = {"Lcom/taomai/android/h5container/api/TMPromptPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "view", "Ltb/ur2;", "hideSoftKeyBoard", "", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", TMPromptPlugin.ACTION_PROMPT, "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TMPromptPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_PROMPT = "prompt";
    @NotNull
    public static final String BRIDGE_NAME = "TMPrompt";
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements InputDialog.OnClickNegativeListener {
        final /* synthetic */ TMPromptPlugin a;
        final /* synthetic */ WVCallBackContext b;
        final /* synthetic */ InputDialog c;
        final /* synthetic */ Activity d;

        b(TMPromptPlugin tMPromptPlugin, WVCallBackContext wVCallBackContext, InputDialog inputDialog, Activity activity) {
            this.a = tMPromptPlugin;
            this.b = wVCallBackContext;
            this.c = inputDialog;
            this.d = activity;
        }

        @Override // com.taomai.android.h5container.widget.InputDialog.OnClickNegativeListener
        public final void onClick() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((Object) "inputValue", (Object) "");
            jSONObject.put((Object) "ok", (Object) Boolean.FALSE);
            WVCallBackContext wVCallBackContext = this.b;
            if (wVCallBackContext != null) {
                wVCallBackContext.success(jSONObject.toJSONString());
            }
            this.c.dismiss();
            TMPromptPlugin tMPromptPlugin = this.a;
            Activity activity = this.d;
            InputDialog inputDialog = this.c;
            k21.h(inputDialog, "inputDialog");
            Window window = inputDialog.getWindow();
            k21.f(window);
            k21.h(window, "inputDialog.window!!");
            View decorView = window.getDecorView();
            k21.h(decorView, "inputDialog.window!!.decorView");
            tMPromptPlugin.hideSoftKeyBoard(activity, decorView);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class c implements InputDialog.OnClickPositiveListener {
        final /* synthetic */ TMPromptPlugin a;
        final /* synthetic */ InputDialog b;
        final /* synthetic */ WVCallBackContext c;
        final /* synthetic */ Activity d;

        c(TMPromptPlugin tMPromptPlugin, InputDialog inputDialog, WVCallBackContext wVCallBackContext, Activity activity) {
            this.a = tMPromptPlugin;
            this.b = inputDialog;
            this.c = wVCallBackContext;
            this.d = activity;
        }

        @Override // com.taomai.android.h5container.widget.InputDialog.OnClickPositiveListener
        public final void onClick(String str) {
            JSONObject jSONObject = new JSONObject();
            InputDialog inputDialog = this.b;
            k21.h(inputDialog, "inputDialog");
            EditText e = inputDialog.e();
            k21.h(e, "inputDialog.inputContent");
            jSONObject.put((Object) "inputValue", (Object) e.getText().toString());
            jSONObject.put((Object) "ok", (Object) Boolean.TRUE);
            WVCallBackContext wVCallBackContext = this.c;
            if (wVCallBackContext != null) {
                wVCallBackContext.success(jSONObject.toJSONString());
            }
            this.b.dismiss();
            TMPromptPlugin tMPromptPlugin = this.a;
            Activity activity = this.d;
            InputDialog inputDialog2 = this.b;
            k21.h(inputDialog2, "inputDialog");
            Window window = inputDialog2.getWindow();
            k21.f(window);
            k21.h(window, "inputDialog.window!!");
            View decorView = window.getDecorView();
            k21.h(decorView, "inputDialog.window!!.decorView");
            tMPromptPlugin.hideSoftKeyBoard(activity, decorView);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void hideSoftKeyBoard(Activity activity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Throwable th) {
            j91.b("H5PromptPlugin", th.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null && str.hashCode() == -979805852 && str.equals(ACTION_PROMPT)) {
            return prompt(str2, wVCallBackContext);
        }
        return false;
    }

    public final boolean prompt(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        if (!(str == null || (a2 = lf2.a(str)) == null)) {
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                try {
                    String string = a2.getString("title");
                    String string2 = a2.getString("message");
                    String string3 = a2.getString("okButton");
                    String string4 = a2.getString("cancelButton");
                    InputDialog g = new InputDialog(activity, string, string2, string3, string4, false).k(a2.getString("confirmColor")).i(a2.getString("cancelColor")).g(a2.getString(Constants.Name.PLACEHOLDER));
                    g.show();
                    g.h(new b(this, wVCallBackContext, g, activity));
                    g.j(new c(this, g, wVCallBackContext, activity));
                } catch (Throwable th) {
                    j91.c("H5PromptPlugin", "prompt exception!", th);
                }
            }
        }
        return true;
    }
}

package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.uc.webview.export.extension.EmbedViewConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class EmbedViewDemo extends BaseEmbedView {

    /* renamed from: tv  reason: collision with root package name */
    TextView f1045tv;

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str2 == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if ("setText".equals(str)) {
                TextView textView = this.f1045tv;
                if (textView != null) {
                    textView.setText(jSONObject.getString("text"));
                    wVCallBackContext.success();
                }
                return true;
            } else if ("setTextSize".equals(str)) {
                TextView textView2 = this.f1045tv;
                if (textView2 != null) {
                    textView2.setTextSize(Float.valueOf(jSONObject.getString("size")).floatValue());
                    wVCallBackContext.success();
                }
                return true;
            } else if ("setBackground".equals(str)) {
                TextView textView3 = this.f1045tv;
                if (textView3 != null) {
                    textView3.setBackgroundColor(Color.parseColor(jSONObject.getString("color")));
                    wVCallBackContext.success();
                }
                return true;
            } else if (!"setTextColor".equals(str)) {
                return false;
            } else {
                TextView textView4 = this.f1045tv;
                if (textView4 != null) {
                    textView4.setTextColor(Color.parseColor(jSONObject.getString("color")));
                    wVCallBackContext.success();
                }
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public View generateView(Context context) {
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        EmbedViewConfig embedViewConfig = this.params;
        int i2 = embedViewConfig.mWidth;
        int i3 = embedViewConfig.mHeight;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        } else {
            i = 0;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (((float) i3) * (((float) i) / ((float) i2))));
        layoutParams.addRule(13);
        TextView textView = new TextView(context);
        this.f1045tv = textView;
        textView.setBackgroundColor(-7829368);
        this.f1045tv.setText("EmbedView DEMO");
        this.f1045tv.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f1045tv.setTextSize(30.0f);
        this.f1045tv.setGravity(17);
        relativeLayout.addView(this.f1045tv, layoutParams);
        return relativeLayout;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return "demo";
    }
}

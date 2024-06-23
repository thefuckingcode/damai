package cn.damai.commonbusiness.poplayer.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.cr1;
import tb.dr1;
import tb.dz0;
import tb.r30;

@PLViewInfo(type = "image")
/* compiled from: Taobao */
public class PopLayerImageView extends PopLayerBaseView<DMImageView, dz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String url;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708778825")) {
                ipChange.ipc$dispatch("-708778825", new Object[]{this, view});
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("groupId", PopLayerImageView.this.getAttachInfo("groupId"));
                PopLayerImageView.this.fireEventToMasterIfExist("clicked", jSONObject.toString());
                cr1.b("PopLayerImageView.onClick:clicked.", new Object[0]);
            } catch (Throwable th) {
                cr1.c("PopLayerImageView. fire event error.", th);
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BaseConfigItem a;

        b(BaseConfigItem baseConfigItem) {
            this.a = baseConfigItem;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1402511544")) {
                ipChange.ipc$dispatch("1402511544", new Object[]{this, view});
                return;
            }
            AlertDialog create = new AlertDialog.Builder(PopLayerImageView.this.getContext().getApplicationContext(), 3).setMessage(this.a.toString()).setTitle(String.format("Configuration DescItem for %s", this.a.uuid)).create();
            create.getWindow().setType(2038);
            create.show();
        }
    }

    public PopLayerImageView(Context context) {
        super(context);
    }

    private static ImageView.ScaleType getScaleType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924629829")) {
            return (ImageView.ScaleType) ipChange.ipc$dispatch("-1924629829", new Object[]{str});
        } else if ("ScaleAspectFit".equals(str)) {
            return ImageView.ScaleType.FIT_CENTER;
        } else {
            if ("ScaleAspectFill".equals(str)) {
                return ImageView.ScaleType.CENTER_CROP;
            }
            if ("ScaleToFill".equals(str)) {
                return ImageView.ScaleType.FIT_XY;
            }
            if ("SameSizeCentered".equals(str)) {
                return ImageView.ScaleType.CENTER;
            }
            return ImageView.ScaleType.FIT_CENTER;
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void destroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032256274")) {
            ipChange.ipc$dispatch("1032256274", new Object[]{this});
            return;
        }
        super.destroyView();
        InnerView innerview = this.mInnerView;
        if (innerview != null) {
            innerview.setImageUrl(null);
            this.mInnerView = null;
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public SpannableStringBuilder getInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136244016")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("2136244016", new Object[]{this});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            BaseConfigItem r = ((dz0) getPopRequest()).r();
            r30.a(spannableStringBuilder, "UUID", r.uuid, null, new b(r));
            r30.a(spannableStringBuilder, "PopTimes", dr1.b(r.uuid, -1) + "", null, null);
            r30.a(spannableStringBuilder, "ImageUrl", this.url, null, null);
            r30.a(spannableStringBuilder, "ModalThreshold", String.format("%.2f", Float.valueOf(((float) getPenetrateAlpha()) / 255.0f)) + "/" + getPenetrateAlpha(), null, null);
        } catch (Throwable unused) {
            r30.a(spannableStringBuilder, "Error", "getInfo Error", null, null);
        }
        return spannableStringBuilder;
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onReceiveEvent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993515287")) {
            ipChange.ipc$dispatch("993515287", new Object[]{this, str, str2});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if ("modifyImage".equals(str)) {
                String optString = new JSONObject(str2).optString("imgUrl");
                if (!TextUtils.isEmpty(optString)) {
                    this.mInnerView.setImageUrl(optString);
                    jSONObject.put("succeed", true);
                } else {
                    jSONObject.put("succeed", false);
                }
            } else if ("modifyImageFillMode".equals(str)) {
                String optString2 = new JSONObject(str2).optString("imgFillMode", null);
                if (!TextUtils.isEmpty(optString2)) {
                    this.mInnerView.setScaleType(getScaleType(optString2));
                    jSONObject.put("succeed", true);
                } else {
                    jSONObject.put("succeed", false);
                }
            } else {
                jSONObject.put("succeed", false);
                str = "NoSuchOperation";
            }
            fireEventToMasterIfExist(str, jSONObject.toString());
        } catch (Throwable th) {
            cr1.c("ImageTrackController.onReceiveEvent error.", th);
        }
    }

    public void init(Context context, dz0 dz0) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328919122")) {
            ipChange.ipc$dispatch("-328919122", new Object[]{this, context, dz0});
            return;
        }
        try {
            String str = dz0.r().params;
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            }
            if (jSONObject == null) {
                return;
            }
        } catch (Throwable th) {
            cr1.c("PopLayerView init fail.", th);
            jSONObject = null;
        }
        String optString = jSONObject.optString("imgUrl", null);
        this.url = optString;
        if (!TextUtils.isEmpty(optString)) {
            InnerView innerview = (InnerView) new DMImageView(context);
            innerview.setImageUrl(this.url);
            innerview.setScaleType(getScaleType(jSONObject.optString("imgFillMode", "ScaleAspectFit")));
            innerview.setOnClickListener(new a());
            this.mInnerView = innerview;
            addView(innerview, new FrameLayout.LayoutParams(-1, -1));
            showCloseButton(dz0.r().showCloseBtn);
            increaseReadTimes(dz0.r().uuid);
            setPenetrateAlpha((int) (dz0.r().modalThreshold * 255.0d));
        }
    }
}

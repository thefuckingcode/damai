package com.alibaba.pictures.bricks.selector.view;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.m52;

/* compiled from: Taobao */
public final class ScriptViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private OnEventListener a;
    private final RoundRadiusImageView b;
    private final TextView c;
    private final BricksIconFontTextView d;
    private final View e;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final ScriptViewHolder a(@NotNull ViewGroup viewGroup, @Nullable OnEventListener onEventListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "158934168")) {
                return (ScriptViewHolder) ipChange.ipc$dispatch("158934168", new Object[]{this, viewGroup, onEventListener});
            }
            k21.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_script_select_scrpit, viewGroup, false);
            k21.h(inflate, "from(parent.context)\n   …ct_scrpit, parent, false)");
            return new ScriptViewHolder(inflate, onEventListener);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptViewHolder(@NotNull View view, @Nullable OnEventListener onEventListener) {
        super(view);
        k21.i(view, "itemView");
        this.a = onEventListener;
        this.b = (RoundRadiusImageView) view.findViewById(R$id.script_img);
        this.c = (TextView) view.findViewById(R$id.script_name);
        this.d = (BricksIconFontTextView) view.findViewById(R$id.checkbox);
        this.e = view.findViewById(R$id.checkbox_bg);
    }

    /* access modifiers changed from: private */
    public static final void c(ScriptViewHolder scriptViewHolder, ScriptSelectMo scriptSelectMo, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712782104")) {
            ipChange.ipc$dispatch("712782104", new Object[]{scriptViewHolder, scriptSelectMo, view});
            return;
        }
        k21.i(scriptViewHolder, "this$0");
        k21.i(scriptSelectMo, "$data");
        OnEventListener onEventListener = scriptViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(ScriptSelectFragment.EVENT_ID_ITEM_SELECT, scriptViewHolder.itemView, scriptSelectMo);
        }
    }

    private final void d(String str, String str2) {
        int start;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1244327089")) {
            ipChange.ipc$dispatch("1244327089", new Object[]{this, str, str2});
            return;
        }
        if (!(str2 == null || (o.y(str2)))) {
            if (str != null && !(o.y(str))) {
                z = false;
            }
            if (!z) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                try {
                    Matcher matcher = Pattern.compile(str2).matcher(str);
                    while (true) {
                        if (!matcher.find() || (start = matcher.start()) == -1) {
                            break;
                        } else if (start < 0) {
                            break;
                        } else {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.c.getContext(), R$color.bricks_FF2D79)), start, str2.length() + start, 18);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.c.setText(spannableStringBuilder);
                return;
            }
        }
        this.c.setText(str);
    }

    private final void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902876502")) {
            ipChange.ipc$dispatch("-1902876502", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.d.setText(R$string.iconfont_yuangouxuanxuanzhong);
            this.d.setTextColor(Color.parseColor("#FF2869"));
            this.e.setVisibility(0);
        } else {
            this.d.setText(R$string.iconfont_yuangouxuanweixuanzhong);
            this.d.setTextColor(Color.parseColor("#FFFFFF"));
            this.e.setVisibility(8);
        }
    }

    public final void b(@NotNull ScriptSelectMo scriptSelectMo, @Nullable String str, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-688533016")) {
            ipChange.ipc$dispatch("-688533016", new Object[]{this, scriptSelectMo, str, bool});
            return;
        }
        k21.i(scriptSelectMo, "data");
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ScriptSelectFragment.Companion.a();
        }
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        if (layoutParams2 != null) {
            ScriptSelectFragment.a aVar = ScriptSelectFragment.Companion;
            layoutParams2.width = aVar.a();
            layoutParams2.height = (int) ((((float) aVar.a()) * 216.0f) / 162.0f);
        }
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        String headImgUrl = scriptSelectMo.getHeadImgUrl();
        RoundRadiusImageView roundRadiusImageView = this.b;
        int i = R$drawable.bricks_uikit_default_image_bg_grey;
        proxy.loadinto(headImgUrl, roundRadiusImageView, i, i);
        d(scriptSelectMo.getTargetName(), str);
        if (bool != null) {
            z = bool.booleanValue();
        }
        e(z);
        this.itemView.setOnClickListener(new m52(this, scriptSelectMo));
    }
}

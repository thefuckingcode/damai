package cn.damai.issue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.uikit.switchbutton.SwitchButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.kd2;
import tb.m40;

/* compiled from: Taobao */
public final class SpoilerSwitchView extends ConstraintLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private TextView desTv;
    @Nullable
    private SwitchButton spoilerSwitch;
    @Nullable
    private TextView switchDesTv;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpoilerSwitchView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpoilerSwitchView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m54_init_$lambda0(SpoilerSwitchView spoilerSwitchView, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1898235296")) {
            ipChange.ipc$dispatch("-1898235296", new Object[]{spoilerSwitchView, view});
            return;
        }
        k21.i(spoilerSwitchView, "this$0");
        SwitchButton switchButton = spoilerSwitchView.spoilerSwitch;
        if (switchButton == null || !switchButton.isChecked()) {
            z = false;
        }
        if (z) {
            TextView textView = spoilerSwitchView.desTv;
            if (textView != null) {
                textView.setText(spoilerSwitchView.getResources().getString(R$string.spoiler_des_ch));
            }
            TextView textView2 = spoilerSwitchView.switchDesTv;
            if (textView2 != null) {
                textView2.setText("包含");
                return;
            }
            return;
        }
        TextView textView3 = spoilerSwitchView.desTv;
        if (textView3 != null) {
            textView3.setText(spoilerSwitchView.getResources().getString(R$string.spoiler_des));
        }
        TextView textView4 = spoilerSwitchView.switchDesTv;
        if (textView4 != null) {
            textView4.setText("不含");
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535529750")) {
            ipChange.ipc$dispatch("-1535529750", new Object[]{this});
            return;
        }
        this.spoilerSwitch = (SwitchButton) findViewById(R$id.spoiler_switch);
        this.desTv = (TextView) findViewById(R$id.tv_des);
        this.switchDesTv = (TextView) findViewById(R$id.tv_switch_des);
    }

    @Nullable
    public final TextView getDesTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "118597909")) {
            return this.desTv;
        }
        return (TextView) ipChange.ipc$dispatch("118597909", new Object[]{this});
    }

    @Nullable
    public final Boolean getIsSpoiler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999950426")) {
            return (Boolean) ipChange.ipc$dispatch("1999950426", new Object[]{this});
        }
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            return Boolean.valueOf(switchButton.isChecked());
        }
        return null;
    }

    @Nullable
    public final SwitchButton getSpoilerSwitch() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-90351841")) {
            return this.spoilerSwitch;
        }
        return (SwitchButton) ipChange.ipc$dispatch("-90351841", new Object[]{this});
    }

    @Nullable
    public final TextView getSwitchDesTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1333980265")) {
            return this.switchDesTv;
        }
        return (TextView) ipChange.ipc$dispatch("1333980265", new Object[]{this});
    }

    public final void setDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204726729")) {
            ipChange.ipc$dispatch("-204726729", new Object[]{this, textView});
            return;
        }
        this.desTv = textView;
    }

    public final void setIsSpoiler(boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-463556917")) {
            ipChange.ipc$dispatch("-463556917", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            switchButton.setChecked(z);
        }
        SwitchButton switchButton2 = this.spoilerSwitch;
        if (switchButton2 == null || !switchButton2.isChecked()) {
            z2 = false;
        }
        if (z2) {
            TextView textView = this.desTv;
            if (textView != null) {
                textView.setText(getResources().getString(R$string.spoiler_des_ch));
            }
            TextView textView2 = this.switchDesTv;
            if (textView2 != null) {
                textView2.setText("包含");
                return;
            }
            return;
        }
        TextView textView3 = this.desTv;
        if (textView3 != null) {
            textView3.setText(getResources().getString(R$string.spoiler_des));
        }
        TextView textView4 = this.switchDesTv;
        if (textView4 != null) {
            textView4.setText("不含");
        }
    }

    public final void setSpoilerSwitch(@Nullable SwitchButton switchButton) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189810125")) {
            ipChange.ipc$dispatch("-1189810125", new Object[]{this, switchButton});
            return;
        }
        this.spoilerSwitch = switchButton;
    }

    public final void setSwitchDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622466973")) {
            ipChange.ipc$dispatch("-1622466973", new Object[]{this, textView});
            return;
        }
        this.switchDesTv = textView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpoilerSwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.spoiler_switch_view_layout, (ViewGroup) this, true);
        initView();
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            switchButton.setOnClickListener(new kd2(this));
        }
    }
}

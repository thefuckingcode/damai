package cn.damai.comment.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur;
import tb.ur2;
import tb.vr;

/* compiled from: Taobao */
public final class DMTagView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Context mContext;
    private RoundRadiusImageView mDmImgIv;
    private TextView mDmNameTv;
    private TextView mDmTag1Tv;
    private TextView mDmTag2Tv;
    private View mDmTagLine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DMTagView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView(context);
    }

    private final boolean changeLineVisible(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1675433603")) {
            return ((Boolean) ipChange.ipc$dispatch("-1675433603", new Object[]{this, list})).booleanValue();
        } else if (list.size() <= 1) {
            return false;
        } else {
            Iterator<T> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().length() > 0) {
                    i++;
                }
            }
            if (i > 1) {
                return true;
            }
            return false;
        }
    }

    private final void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25636393")) {
            ipChange.ipc$dispatch("25636393", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        LayoutInflater.from(context).inflate(R$layout.ll_dm_tag_view, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.riv_dm_img);
        k21.h(findViewById, "findViewById(R.id.riv_dm_img)");
        this.mDmImgIv = (RoundRadiusImageView) findViewById;
        View findViewById2 = findViewById(R$id.tv_dm_name);
        k21.h(findViewById2, "findViewById(R.id.tv_dm_name)");
        this.mDmNameTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tv_dm_tag_1);
        k21.h(findViewById3, "findViewById(R.id.tv_dm_tag_1)");
        this.mDmTag1Tv = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.v_dm_tag_line);
        k21.h(findViewById4, "findViewById(R.id.v_dm_tag_line)");
        this.mDmTagLine = findViewById4;
        View findViewById5 = findViewById(R$id.tv_dm_tag_2);
        k21.h(findViewById5, "findViewById(R.id.tv_dm_tag_2)");
        this.mDmTag2Tv = (TextView) findViewById5;
    }

    /* access modifiers changed from: private */
    /* renamed from: setDmBaseData$lambda-0  reason: not valid java name */
    public static final void m0setDmBaseData$lambda0(DMTagView dMTagView, Function0 function0, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1129689960")) {
            ipChange.ipc$dispatch("-1129689960", new Object[]{dMTagView, function0, eVar});
            return;
        }
        k21.i(dMTagView, "this$0");
        RoundRadiusImageView roundRadiusImageView = dMTagView.mDmImgIv;
        if (roundRadiusImageView == null) {
            k21.A("mDmImgIv");
            roundRadiusImageView = null;
        }
        roundRadiusImageView.setImageBitmap(eVar.b);
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDmBaseData$lambda-1  reason: not valid java name */
    public static final void m1setDmBaseData$lambda1(Function0 function0, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411580142")) {
            ipChange.ipc$dispatch("-1411580142", new Object[]{function0, dVar});
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    @Nullable
    public final Context getMContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1441444842")) {
            return this.mContext;
        }
        return (Context) ipChange.ipc$dispatch("-1441444842", new Object[]{this});
    }

    public final void setDmBaseData(@Nullable String str, @Nullable String str2, @Nullable Function0<ur2> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56750901")) {
            ipChange.ipc$dispatch("-56750901", new Object[]{this, str, str2, function0});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            a.b().c(str).n(new vr(this, function0)).e(new ur(function0)).f();
        } else if (function0 != null) {
            function0.invoke();
        }
        if (!TextUtils.isEmpty(str2)) {
            TextView textView = this.mDmNameTv;
            if (textView == null) {
                k21.A("mDmNameTv");
                textView = null;
            }
            textView.setText(str2);
        }
    }

    public final void setDmTagData(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183342612")) {
            ipChange.ipc$dispatch("-1183342612", new Object[]{this, list});
            return;
        }
        TextView textView = null;
        if (list == null || list.isEmpty()) {
            View view = this.mDmTagLine;
            if (view == null) {
                k21.A("mDmTagLine");
                view = null;
            }
            view.setVisibility(8);
            TextView textView2 = this.mDmTag1Tv;
            if (textView2 == null) {
                k21.A("mDmTag1Tv");
                textView2 = null;
            }
            textView2.setVisibility(8);
            TextView textView3 = this.mDmTag2Tv;
            if (textView3 == null) {
                k21.A("mDmTag2Tv");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
            return;
        }
        View view2 = this.mDmTagLine;
        if (view2 == null) {
            k21.A("mDmTagLine");
            view2 = null;
        }
        view2.setVisibility(changeLineVisible(list) ? 0 : 8);
        if (list.get(0).length() > 0) {
            TextView textView4 = this.mDmTag1Tv;
            if (textView4 == null) {
                k21.A("mDmTag1Tv");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = this.mDmTag1Tv;
            if (textView5 == null) {
                k21.A("mDmTag1Tv");
                textView5 = null;
            }
            textView5.setText(list.get(0));
        } else {
            TextView textView6 = this.mDmTag1Tv;
            if (textView6 == null) {
                k21.A("mDmTag1Tv");
                textView6 = null;
            }
            textView6.setVisibility(8);
        }
        if (list.size() >= 2) {
            if (list.get(1).length() > 0) {
                TextView textView7 = this.mDmTag2Tv;
                if (textView7 == null) {
                    k21.A("mDmTag2Tv");
                    textView7 = null;
                }
                textView7.setVisibility(0);
                TextView textView8 = this.mDmTag2Tv;
                if (textView8 == null) {
                    k21.A("mDmTag2Tv");
                } else {
                    textView = textView8;
                }
                textView.setText(list.get(1));
                return;
            }
        }
        TextView textView9 = this.mDmTag2Tv;
        if (textView9 == null) {
            k21.A("mDmTag2Tv");
        } else {
            textView = textView9;
        }
        textView.setVisibility(8);
    }

    public final void setMContext(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708054902")) {
            ipChange.ipc$dispatch("1708054902", new Object[]{this, context});
            return;
        }
        this.mContext = context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DMTagView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(attributeSet, TemplateDom.KEY_ATTRS);
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DMTagView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(attributeSet, TemplateDom.KEY_ATTRS);
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @RequiresApi(21)
    public DMTagView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(attributeSet, TemplateDom.KEY_ATTRS);
        initView(context);
    }

    public final void setDmBaseData(@Nullable String str, @Nullable String str2) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369391972")) {
            ipChange.ipc$dispatch("1369391972", new Object[]{this, str, str2});
            return;
        }
        TextView textView2 = null;
        if (!TextUtils.isEmpty(str) && this.mDmImgIv != null) {
            DMImageCreator c = a.b().c(str);
            RoundRadiusImageView roundRadiusImageView = this.mDmImgIv;
            if (roundRadiusImageView == null) {
                k21.A("mDmImgIv");
                roundRadiusImageView = null;
            }
            c.g(roundRadiusImageView);
        }
        if (!TextUtils.isEmpty(str2) && (textView = this.mDmNameTv) != null) {
            if (textView == null) {
                k21.A("mDmNameTv");
            } else {
                textView2 = textView;
            }
            textView2.setText(str2);
        }
    }
}

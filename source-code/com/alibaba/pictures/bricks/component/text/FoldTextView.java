package com.alibaba.pictures.bricks.component.text;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.pictures.R$color;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.pm0;
import tb.qm0;
import tb.rm0;
import tb.xi;

/* compiled from: Taobao */
public final class FoldTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private SpannableString SPAN_CLOSE;
    @Nullable
    private SpannableString SPAN_EXPAND;
    @NotNull
    private String TEXT_CLOSE = "  收起";
    @NotNull
    private String TEXT_EXPAND = "  展开";
    private int close_colorId;
    private int expand_colorId;
    private boolean foldNow;
    private int initWidth;
    private int mFoldLines = 3;
    private int mMaxLinex;
    @Nullable
    private OnChangeListener onChangeListener;
    @Nullable
    private String originText;

    /* compiled from: Taobao */
    public interface OnChangeListener {
        void onChanged(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldTextView(@Nullable Context context) {
        super(context);
        k21.f(context);
        int i = R$color.bricks_white;
        this.expand_colorId = i;
        this.close_colorId = i;
        this.mMaxLinex = Integer.MAX_VALUE;
        initExpandTail();
    }

    private final void initCloseTail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833372278")) {
            ipChange.ipc$dispatch("833372278", new Object[]{this});
            return;
        }
        String str = this.TEXT_CLOSE;
        this.SPAN_CLOSE = new SpannableString(str);
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        xi xiVar = new xi(context, new pm0(this), this.close_colorId);
        SpannableString spannableString = this.SPAN_CLOSE;
        k21.f(spannableString);
        spannableString.setSpan(xiVar, 0, str.length(), 17);
    }

    /* access modifiers changed from: private */
    /* renamed from: initCloseTail$lambda-3  reason: not valid java name */
    public static final void m146initCloseTail$lambda3(FoldTextView foldTextView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657405005")) {
            ipChange.ipc$dispatch("-1657405005", new Object[]{foldTextView, view});
            return;
        }
        k21.i(foldTextView, "this$0");
        foldTextView.expand();
    }

    private final void initExpandTail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677205022")) {
            ipChange.ipc$dispatch("-1677205022", new Object[]{this});
            return;
        }
        String str = this.TEXT_EXPAND;
        this.SPAN_EXPAND = new SpannableString(str);
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        xi xiVar = new xi(context, new rm0(this), this.expand_colorId);
        SpannableString spannableString = this.SPAN_EXPAND;
        k21.f(spannableString);
        spannableString.setSpan(xiVar, 0, str.length(), 17);
        int i = this.initWidth;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context2 = getContext();
        k21.g(context2, "null cannot be cast to non-null type android.app.Activity");
        Display.getMetrics(((Activity) context2).getWindowManager().getDefaultDisplay(), displayMetrics);
        if (i == 0) {
            this.initWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initExpandTail$lambda-1  reason: not valid java name */
    public static final void m147initExpandTail$lambda1(FoldTextView foldTextView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818040841")) {
            ipChange.ipc$dispatch("818040841", new Object[]{foldTextView, view});
            return;
        }
        k21.i(foldTextView, "this$0");
        foldTextView.fold();
    }

    /* access modifiers changed from: private */
    /* renamed from: setExpandColorId$lambda-0  reason: not valid java name */
    public static final void m148setExpandColorId$lambda0(FoldTextView foldTextView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459460270")) {
            ipChange.ipc$dispatch("-1459460270", new Object[]{foldTextView, view});
            return;
        }
        k21.i(foldTextView, "this$0");
        foldTextView.fold();
    }

    @NotNull
    public final Layout createWorkingLayout(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755800354")) {
            return (Layout) ipChange.ipc$dispatch("-755800354", new Object[]{this, str});
        } else if (Build.VERSION.SDK_INT >= 16) {
            return new StaticLayout(str, getPaint(), (this.initWidth - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
        } else {
            return new StaticLayout(str, getPaint(), (this.initWidth - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
    }

    public final void expand() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494289022")) {
            ipChange.ipc$dispatch("-1494289022", new Object[]{this});
            return;
        }
        super.setMaxLines(this.mFoldLines);
        showFoldText(this.originText);
        this.foldNow = false;
        OnChangeListener onChangeListener2 = this.onChangeListener;
        if (onChangeListener2 != null) {
            onChangeListener2.onChanged(0);
        }
    }

    public final void fold() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398849925")) {
            ipChange.ipc$dispatch("-398849925", new Object[]{this});
            return;
        }
        super.setMaxLines(this.mMaxLinex);
        showExpandText(this.originText);
        this.foldNow = true;
        OnChangeListener onChangeListener2 = this.onChangeListener;
        if (onChangeListener2 != null) {
            onChangeListener2.onChanged(1);
        }
    }

    public final void initWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472168747")) {
            ipChange.ipc$dispatch("472168747", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.initWidth = i;
    }

    public final boolean isFoldNow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-320047929")) {
            return this.foldNow;
        }
        return ((Boolean) ipChange.ipc$dispatch("-320047929", new Object[]{this})).booleanValue();
    }

    public final void setChangeListener(@NotNull OnChangeListener onChangeListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936366159")) {
            ipChange.ipc$dispatch("1936366159", new Object[]{this, onChangeListener2});
            return;
        }
        k21.i(onChangeListener2, "listener");
        this.onChangeListener = onChangeListener2;
    }

    public final void setCloseColorId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2104250211")) {
            ipChange.ipc$dispatch("-2104250211", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.close_colorId = i;
    }

    public final void setExpandColorId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079960713")) {
            ipChange.ipc$dispatch("2079960713", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.expand_colorId = i;
        String str = this.TEXT_EXPAND;
        this.SPAN_EXPAND = new SpannableString(str);
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        xi xiVar = new xi(context, new qm0(this), i);
        SpannableString spannableString = this.SPAN_EXPAND;
        k21.f(spannableString);
        spannableString.setSpan(xiVar, 0, str.length(), 17);
    }

    public final void setExpandMaxLine(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325704995")) {
            ipChange.ipc$dispatch("325704995", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mMaxLinex = i;
    }

    public final void setExpandSpan(@NotNull SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409219798")) {
            ipChange.ipc$dispatch("-1409219798", new Object[]{this, spannableString});
            return;
        }
        k21.i(spannableString, "span");
        this.SPAN_EXPAND = spannableString;
    }

    public final void setFoldLine(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515730540")) {
            ipChange.ipc$dispatch("1515730540", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mFoldLines = i;
    }

    public void setMaxLines(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222392878")) {
            ipChange.ipc$dispatch("-1222392878", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mFoldLines = i;
        super.setMaxLines(i);
    }

    public final void setTextClose(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342379267")) {
            ipChange.ipc$dispatch("-342379267", new Object[]{this, str});
            return;
        }
        k21.i(str, "TEXT_CLOSE");
        this.TEXT_CLOSE = str;
    }

    public final void setTextExpand(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9330577")) {
            ipChange.ipc$dispatch("-9330577", new Object[]{this, str});
            return;
        }
        k21.i(str, "TEXT_EXPAND");
        this.TEXT_EXPAND = str;
    }

    public final void showExpandText(@Nullable String str) {
        int i;
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177211166")) {
            ipChange.ipc$dispatch("-1177211166", new Object[]{this, str});
            return;
        }
        if (this.SPAN_CLOSE == null) {
            initCloseTail();
        }
        this.originText = String.valueOf(str);
        if (Build.VERSION.SDK_INT >= 16) {
            i = getMaxLines();
        } else {
            i = this.mMaxLinex;
        }
        String sb = new StringBuilder(this.originText).toString();
        k21.h(sb, "StringBuilder(originText).toString()");
        if (i != -1) {
            Layout createWorkingLayout = createWorkingLayout(sb);
            if (createWorkingLayout.getLineCount() > i) {
                String str2 = this.originText;
                k21.f(str2);
                int i2 = i - 1;
                String substring = str2.substring(0, createWorkingLayout.getLineEnd(i2));
                k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int length2 = substring.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length2) {
                    boolean z2 = k21.k(substring.charAt(!z ? i3 : length2), 32) <= 0;
                    if (!z) {
                        if (!z2) {
                            z = true;
                        } else {
                            i3++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length2--;
                    }
                }
                String obj = substring.subSequence(i3, length2 + 1).toString();
                StringBuilder sb2 = new StringBuilder();
                String str3 = this.originText;
                k21.f(str3);
                String substring2 = str3.substring(0, createWorkingLayout.getLineEnd(i2));
                k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int length3 = substring2.length() - 1;
                int i4 = 0;
                boolean z3 = false;
                while (i4 <= length3) {
                    boolean z4 = k21.k(substring2.charAt(!z3 ? i4 : length3), 32) <= 0;
                    if (!z3) {
                        if (!z4) {
                            z3 = true;
                        } else {
                            i4++;
                        }
                    } else if (!z4) {
                        break;
                    } else {
                        length3--;
                    }
                }
                sb2.append(substring2.subSequence(i4, length3 + 1).toString());
                sb2.append("...");
                sb2.append((Object) this.SPAN_CLOSE);
                Layout createWorkingLayout2 = createWorkingLayout(sb2.toString());
                while (createWorkingLayout2.getLineCount() > i && (length = obj.length() - 1) != -1) {
                    obj = obj.substring(0, length);
                    k21.h(obj, "this as java.lang.String…ing(startIndex, endIndex)");
                    createWorkingLayout2 = createWorkingLayout(obj + "..." + ((Object) this.SPAN_CLOSE));
                }
                sb = obj + "...";
            }
        }
        setText(sb);
        append(this.SPAN_CLOSE);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void showFoldText(@Nullable CharSequence charSequence) {
        int i;
        int length;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-149680139")) {
            ipChange.ipc$dispatch("-149680139", new Object[]{this, charSequence});
            return;
        }
        if (this.SPAN_EXPAND == null) {
            initExpandTail();
        }
        this.originText = String.valueOf(charSequence);
        if (Build.VERSION.SDK_INT >= 16) {
            i = getMaxLines();
        } else {
            i = this.mFoldLines;
        }
        String sb = new StringBuilder(this.originText).toString();
        k21.h(sb, "StringBuilder(originText).toString()");
        if (i != -1) {
            Layout createWorkingLayout = createWorkingLayout(sb);
            if (createWorkingLayout.getLineCount() > i) {
                String str = this.originText;
                k21.f(str);
                int i2 = i - 1;
                String substring = str.substring(0, createWorkingLayout.getLineEnd(i2));
                k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int length2 = substring.length() - 1;
                int i3 = 0;
                boolean z2 = false;
                while (i3 <= length2) {
                    boolean z3 = k21.k(substring.charAt(!z2 ? i3 : length2), 32) <= 0;
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i3++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length2--;
                    }
                }
                String obj = substring.subSequence(i3, length2 + 1).toString();
                StringBuilder sb2 = new StringBuilder();
                String str2 = this.originText;
                k21.f(str2);
                String substring2 = str2.substring(0, createWorkingLayout.getLineEnd(i2));
                k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int length3 = substring2.length() - 1;
                int i4 = 0;
                boolean z4 = false;
                while (i4 <= length3) {
                    boolean z5 = k21.k(substring2.charAt(!z4 ? i4 : length3), 32) <= 0;
                    if (!z4) {
                        if (!z5) {
                            z4 = true;
                        } else {
                            i4++;
                        }
                    } else if (!z5) {
                        break;
                    } else {
                        length3--;
                    }
                }
                sb2.append(substring2.subSequence(i4, length3 + 1).toString());
                sb2.append("...");
                sb2.append((Object) this.SPAN_EXPAND);
                Layout createWorkingLayout2 = createWorkingLayout(sb2.toString());
                while (createWorkingLayout2.getLineCount() > i && (length = obj.length() - 1) != -1) {
                    obj = obj.substring(0, length);
                    k21.h(obj, "this as java.lang.String…ing(startIndex, endIndex)");
                    createWorkingLayout2 = createWorkingLayout(obj + "..." + ((Object) this.SPAN_EXPAND));
                }
                sb = obj + "...";
                z = true;
            }
        }
        setText(sb);
        if (z) {
            append(this.SPAN_EXPAND);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.f(context);
        int i = R$color.bricks_white;
        this.expand_colorId = i;
        this.close_colorId = i;
        this.mMaxLinex = Integer.MAX_VALUE;
        initExpandTail();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.f(context);
        int i2 = R$color.bricks_white;
        this.expand_colorId = i2;
        this.close_colorId = i2;
        this.mMaxLinex = Integer.MAX_VALUE;
        initExpandTail();
    }
}

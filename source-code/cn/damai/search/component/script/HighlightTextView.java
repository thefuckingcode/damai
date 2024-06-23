package cn.damai.search.component.script;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class HighlightTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    @ColorInt
    @Nullable
    private Integer highlightColor;
    private int index;
    @Nullable
    private ArrayList<String> keyWords;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HighlightTextView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HighlightTextView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void doHighlight() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2111018892")) {
            ipChange.ipc$dispatch("2111018892", new Object[]{this});
            return;
        }
        CharSequence text = getText();
        if (!(text == null || text.length() == 0)) {
            ArrayList<String> arrayList = this.keyWords;
            if (arrayList == null || arrayList.isEmpty()) {
                z = true;
            }
            if (!z) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
                ArrayList<String> arrayList2 = this.keyWords;
                if (arrayList2 != null) {
                    for (T t : arrayList2) {
                        try {
                            Matcher matcher = Pattern.compile(t).matcher(getText());
                            while (true) {
                                if (!matcher.find()) {
                                    break;
                                }
                                int start = matcher.start();
                                this.index = start;
                                if (start == -1) {
                                    break;
                                } else if (start >= 0) {
                                    Context context = getContext();
                                    Integer num = this.highlightColor;
                                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, num != null ? num.intValue() : R$color.color_FF2D79));
                                    int i = this.index;
                                    spannableStringBuilder.setSpan(foregroundColorSpan, i, t.length() + i, 18);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                setText(spannableStringBuilder);
            }
        }
    }

    @Nullable
    public final Integer getHighlightColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1153472105")) {
            return this.highlightColor;
        }
        return (Integer) ipChange.ipc$dispatch("-1153472105", new Object[]{this});
    }

    public final void setHighlightColor(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819809005")) {
            ipChange.ipc$dispatch("-819809005", new Object[]{this, num});
            return;
        }
        this.highlightColor = num;
    }

    public final void setText(@Nullable String str, @Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498584102")) {
            ipChange.ipc$dispatch("-498584102", new Object[]{this, str, arrayList});
            return;
        }
        setText(str);
        this.keyWords = arrayList;
        doHighlight();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HighlightTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}

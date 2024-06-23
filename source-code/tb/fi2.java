package tb;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class fi2 extends DXTextViewWidgetNode {
    private static final long A = my.a("richText");
    private static final long B = my.a("price");
    private static final long C = my.a("symbolScale");
    private static final long D = my.a("decimalScale");
    public static final long DX_WIDGET_ID = my.a(NAME);
    public static final String NAME = "tdTradePriceView";
    private CharSequence v;
    private CharSequence w;
    private float x = 0.625f;
    private float y = 1.0f;
    private float z = 0.625f;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new fi2();
        }
    }

    private CharSequence w(CharSequence charSequence) {
        if (charSequence instanceof SpannableString) {
            return charSequence;
        }
        if (charSequence == null) {
            return "";
        }
        String charSequence2 = charSequence.toString();
        int indexOf = charSequence2.indexOf(46);
        SpannableString spannableString = new SpannableString(charSequence2);
        int x2 = x(charSequence2);
        try {
            spannableString.setSpan(new RelativeSizeSpan(this.x), 0, x2, 33);
            int length = charSequence2.length();
            if (indexOf < 0) {
                spannableString.setSpan(new RelativeSizeSpan(this.y), x2, length, 33);
            } else {
                spannableString.setSpan(new RelativeSizeSpan(this.y), x2, indexOf, 33);
                spannableString.setSpan(new RelativeSizeSpan(this.z), indexOf, length, 33);
            }
            return spannableString;
        } catch (Throwable unused) {
            return charSequence2;
        }
    }

    private int x(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new fi2();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void h(TextView textView) {
        super.h(textView);
        if (!TextUtils.isEmpty(this.v)) {
            textView.setText(this.v);
        } else if (!TextUtils.isEmpty(this.w)) {
            CharSequence w2 = w(this.w);
            this.w = w2;
            textView.setText(w2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z2) {
        super.onClone(dXWidgetNode, z2);
        if (dXWidgetNode instanceof fi2) {
            fi2 fi2 = (fi2) dXWidgetNode;
            this.v = fi2.v;
            this.w = fi2.w;
            this.x = fi2.x;
            this.z = fi2.z;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!TextUtils.isEmpty(this.v)) {
                textView.setText(this.v);
            } else if (!TextUtils.isEmpty(this.w)) {
                CharSequence w2 = w(this.w);
                this.w = w2;
                textView.setText(w2);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        super.onSetDoubleAttribute(j, d);
        if (C == j) {
            this.x = (float) d;
        } else if (D == j) {
            this.z = (float) d;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        super.onSetObjAttribute(j, obj);
        if (A != j) {
            return;
        }
        if (obj instanceof CharSequence) {
            this.v = (CharSequence) obj;
        } else {
            this.v = "";
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        super.onSetStringAttribute(j, str);
        if (B == j) {
            this.w = str;
        }
    }
}

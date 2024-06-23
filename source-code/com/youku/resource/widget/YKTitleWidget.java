package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
public class YKTitleWidget extends LinearLayout implements YKCustomizedView {
    public static final String TITLE_STYLE_1 = "title_1";
    public static final String TITLE_STYLE_2 = "title_2";
    public static final String TITLE_STYLE_3 = "title_3";
    public static final String TITLE_STYLE_4 = "title_4";
    public static final String TITLE_STYLE_5 = "title_5";
    public static final String TITLE_STYLE_6 = "title_6";
    private TUrlImageView deleteIcon;
    private TUrlImageView leftIcon;
    private TUrlImageView navArrow;
    private YKTextView navHint;
    private TUrlImageView navIcon;
    private YKTextView textContext1;
    private YKTextView textContext2;
    private YKTextView textContext3;
    private TUrlImageView titleImg;
    private ViewStub titleImgVb;
    private String titleStyle;

    public YKTitleWidget(Context context) {
        super(context);
        init(context, null);
    }

    public TUrlImageView getDeleteIcon() {
        return this.deleteIcon;
    }

    public TUrlImageView getLeftIcon() {
        return this.leftIcon;
    }

    public TUrlImageView getNavArrow() {
        return this.navArrow;
    }

    public YKTextView getNavHint() {
        return this.navHint;
    }

    public TUrlImageView getNavIcon() {
        return this.navIcon;
    }

    public YKTextView getTextContext1() {
        return this.textContext1;
    }

    public YKTextView getTextContext2() {
        return this.textContext2;
    }

    public YKTextView getTextContext3() {
        return this.textContext3;
    }

    public TUrlImageView getTitleImg() {
        return this.titleImg;
    }

    public ViewStub getTitleImgVb() {
        return this.titleImgVb;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (r0.equals(com.youku.resource.widget.YKTitleWidget.TITLE_STYLE_1) == false) goto L_0x002a;
     */
    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            char c = 0;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKTitleWidget, 0, 0);
            this.titleStyle = obtainStyledAttributes.getString(R.styleable.YKTitleWidget_title_style);
            obtainStyledAttributes.recycle();
            int i = R.layout.resource_yk_title_1;
            String str = this.titleStyle;
            if (str != null) {
                str.hashCode();
                switch (str.hashCode()) {
                    case -1307248630:
                        break;
                    case -1307248629:
                        if (str.equals(TITLE_STYLE_2)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1307248628:
                        if (str.equals(TITLE_STYLE_3)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1307248627:
                        if (str.equals(TITLE_STYLE_4)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1307248626:
                        if (str.equals(TITLE_STYLE_5)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1307248625:
                        if (str.equals(TITLE_STYLE_6)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 1:
                        i = R.layout.resource_yk_title_2;
                        break;
                    case 2:
                        i = R.layout.resource_yk_title_3;
                        break;
                    case 3:
                        i = R.layout.resource_yk_title_4;
                        break;
                    case 4:
                        i = R.layout.resource_yk_title_5;
                        break;
                    case 5:
                        i = R.layout.resource_yk_title_6;
                        break;
                }
            }
            View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) this, true);
            this.leftIcon = (TUrlImageView) inflate.findViewById(R.id.title_left_icon);
            this.navArrow = (TUrlImageView) inflate.findViewById(R.id.nav_arrow);
            this.deleteIcon = (TUrlImageView) inflate.findViewById(R.id.delete_icon);
            this.titleImgVb = (ViewStub) inflate.findViewById(R.id.title_img_vb);
            this.navHint = (YKTextView) inflate.findViewById(R.id.nav_hint);
            this.textContext1 = (YKTextView) inflate.findViewById(R.id.title_context_1);
            this.textContext2 = (YKTextView) inflate.findViewById(R.id.title_context_2);
            this.textContext3 = (YKTextView) inflate.findViewById(R.id.title_context_3);
            this.navIcon = (TUrlImageView) inflate.findViewById(R.id.nav_icon);
        }
    }

    public void reset() {
        TUrlImageView tUrlImageView = this.leftIcon;
        if (tUrlImageView != null) {
            tUrlImageView.setVisibility(8);
        }
        TUrlImageView tUrlImageView2 = this.deleteIcon;
        if (tUrlImageView2 != null) {
            tUrlImageView2.setVisibility(8);
        }
        YKTextView yKTextView = this.navHint;
        if (yKTextView != null) {
            yKTextView.setVisibility(8);
        }
        TUrlImageView tUrlImageView3 = this.navIcon;
        if (tUrlImageView3 != null) {
            tUrlImageView3.setVisibility(8);
        }
        TUrlImageView tUrlImageView4 = this.navArrow;
        if (tUrlImageView4 != null) {
            tUrlImageView4.setVisibility(8);
        }
        TUrlImageView tUrlImageView5 = this.titleImg;
        if (tUrlImageView5 != null) {
            tUrlImageView5.setVisibility(8);
        }
    }

    public YKTitleWidget(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}

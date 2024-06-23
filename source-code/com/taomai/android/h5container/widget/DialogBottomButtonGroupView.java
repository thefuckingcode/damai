package com.taomai.android.h5container.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.taomai.android.h5container.R$color;
import com.taomai.android.h5container.R$drawable;
import java.util.ArrayList;
import java.util.List;
import tb.g90;

/* compiled from: Taobao */
public class DialogBottomButtonGroupView extends FrameLayout implements View.OnClickListener {
    public static final int BUTTON_LAYOUT_LIST = 2;
    public static final int BUTTON_LAYOUT_NORMAL = 1;
    public static final int BUTTON_LAYOUT_OLD = 0;
    public static final int BUTTON_LAYOUT_STRONG = 3;
    private LinearLayout buttonContainer;
    private int buttonGroupType = 0;
    private int buttonHeight;
    private List<Button> buttons = new ArrayList();
    private Context context;
    private View horizontalDivider;
    private Button negativeBtn;
    private OnItemClickListener onItemClickListener;
    private Button positiveBtn;
    private boolean positiveButtonEnabled = true;
    private boolean positiveButtonNormal = false;
    private boolean positiveButtonWarning = false;
    private View verticalDivider;

    /* compiled from: Taobao */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public DialogBottomButtonGroupView(Context context2) {
        super(context2);
        init(context2, null);
    }

    private void addHorizonDivider() {
        this.buttonContainer.addView(createDivider(this.context), -1, 1);
    }

    @NonNull
    private Button createButton(Context context2, AttributeSet attributeSet) {
        Button button = new Button(context2, attributeSet);
        button.setTextSize(1, 18.0f);
        button.setTextColor(AppCompatResources.getColorStateList(context2, R$color.h5_base_dialog_button_text_color));
        button.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
        button.setMinHeight(this.buttonHeight);
        button.setGravity(17);
        button.setSingleLine();
        return button;
    }

    private View createDivider(Context context2) {
        View view = new View(context2);
        view.setBackgroundColor(context2.getResources().getColor(R$color.color_e5e5e5));
        return view;
    }

    private void init(Context context2, AttributeSet attributeSet) {
        this.context = context2;
        this.buttonHeight = g90.a(49.0f);
        this.positiveBtn = createButton(context2, attributeSet);
        this.negativeBtn = createButton(context2, attributeSet);
        View createDivider = createDivider(context2);
        this.horizontalDivider = createDivider;
        addView(createDivider, -1, 1);
        this.horizontalDivider.setVisibility(8);
        this.verticalDivider = createDivider(context2);
        LinearLayout linearLayout = new LinearLayout(context2, attributeSet);
        this.buttonContainer = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.buttonContainer, -1, -2);
        renderToOldStyle();
    }

    private void initDefaultStyle() {
        if (this.buttonGroupType == 0) {
            setButtonLayout(1);
        }
    }

    private boolean isNegativeBtnValid() {
        return this.negativeBtn.length() > 0 && this.negativeBtn.getVisibility() == 0;
    }

    private boolean isPositiveBtnValid() {
        return this.positiveBtn.length() > 0 && this.positiveBtn.getVisibility() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0101  */
    private void renderNormalStyle() {
        boolean z;
        boolean z2;
        int length = this.positiveBtn.length();
        int length2 = this.negativeBtn.length();
        if (length != 0 || length2 != 0) {
            if (length == 0 || length2 == 0) {
                z = false;
            } else {
                if (!this.positiveButtonNormal) {
                    this.positiveBtn.getPaint().setFakeBoldText(true);
                }
                z = true;
            }
            if (z) {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(this.positiveBtn.getTextSize());
                float measureText = textPaint.measureText(this.positiveBtn.getText().toString());
                float measureText2 = textPaint.measureText(this.negativeBtn.getText().toString());
                float a = (((float) g90.a(280.0f)) / 2.0f) - ((float) (g90.a(12.0f) * 2));
                if (measureText > a || measureText2 > a) {
                    z2 = false;
                    Button button = this.positiveBtn;
                    int i = R$drawable.h5_dialog_normal_button_bg;
                    button.setBackgroundResource(i);
                    this.negativeBtn.setBackgroundResource(i);
                    if (!z2) {
                        this.buttonContainer.removeAllViews();
                        this.horizontalDivider.setVisibility(0);
                        this.buttonContainer.setOrientation(0);
                        setPositiveBtnStyle();
                        if (isNegativeBtnValid()) {
                            this.buttonContainer.addView(this.negativeBtn, -1, this.buttonHeight);
                        }
                        if (this.negativeBtn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                            ((LinearLayout.LayoutParams) this.negativeBtn.getLayoutParams()).weight = 1.0f;
                        }
                        if (z) {
                            this.buttonContainer.addView(this.verticalDivider, 1, this.buttonHeight);
                            this.positiveBtn.setBackgroundResource(R$drawable.h5_dialog_right_button_bg);
                            this.negativeBtn.setBackgroundResource(R$drawable.h5_dialog_left_button_bg);
                        } else {
                            Button button2 = this.positiveBtn;
                            int i2 = R$drawable.h5_dialog_bottom_button_bg;
                            button2.setBackgroundResource(i2);
                            this.negativeBtn.setBackgroundResource(i2);
                        }
                        if (isPositiveBtnValid()) {
                            this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
                        }
                        if (this.positiveBtn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                            ((LinearLayout.LayoutParams) this.positiveBtn.getLayoutParams()).weight = 1.0f;
                            return;
                        }
                        return;
                    }
                    renderToListStyle();
                    return;
                }
            }
            z2 = true;
            Button button3 = this.positiveBtn;
            int i3 = R$drawable.h5_dialog_normal_button_bg;
            button3.setBackgroundResource(i3);
            this.negativeBtn.setBackgroundResource(i3);
            if (!z2) {
            }
        }
    }

    private void renderToListStyle() {
        this.buttonContainer.removeAllViews();
        this.buttonContainer.setOrientation(1);
        if (isPositiveBtnValid()) {
            addHorizonDivider();
            setPositiveBtnStyle();
            this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
        }
        if (isNegativeBtnValid()) {
            addHorizonDivider();
            this.buttonContainer.addView(this.negativeBtn, -1, this.buttonHeight);
        }
        if (this.buttonContainer.getChildCount() > 0) {
            LinearLayout linearLayout = this.buttonContainer;
            if (linearLayout.getChildAt(linearLayout.getChildCount() - 1) instanceof Button) {
                LinearLayout linearLayout2 = this.buttonContainer;
                linearLayout2.getChildAt(linearLayout2.getChildCount() - 1).setBackgroundResource(R$drawable.h5_dialog_bottom_button_bg);
            }
        }
    }

    private void renderToMainStyle() {
        this.buttonContainer.removeAllViews();
        this.buttonContainer.setOrientation(1);
        if (isPositiveBtnValid()) {
            this.positiveBtn.setBackgroundResource(R$drawable.h5_button_bg_for_main);
            this.positiveBtn.setTextColor(AppCompatResources.getColorStateList(this.context, R$color.h5_button_textcolor_white));
            this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.positiveBtn.getLayoutParams();
            int a = g90.a(12.0f);
            int a2 = g90.a(12.0f);
            if (isNegativeBtnValid()) {
                a = g90.a(12.0f);
            }
            layoutParams.setMargins(a2, 0, a2, a);
        }
        if (isNegativeBtnValid()) {
            this.negativeBtn.setBackgroundColor(this.context.getResources().getColor(17170445));
            this.buttonContainer.addView(this.negativeBtn, -1, this.buttonHeight);
        }
    }

    private void renderToOldStyle() {
        this.horizontalDivider.setVisibility(0);
        this.positiveBtn.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
        this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
    }

    private void setPositiveBtnStyle() {
        if (this.positiveButtonWarning) {
            this.positiveBtn.setTextColor(AppCompatResources.getColorStateList(this.context, R$color.h5_base_dialog_button_text_color_warning));
        }
        if (!this.positiveButtonNormal && isNegativeBtnValid()) {
            this.positiveBtn.getPaint().setFakeBoldText(true);
        }
    }

    public Button getNegativeBtn() {
        return this.negativeBtn;
    }

    public Button getPositiveBtn() {
        return this.positiveBtn;
    }

    public void hideBottomLine() {
        this.horizontalDivider.setVisibility(8);
    }

    public void onClick(View view) {
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 != null) {
            onItemClickListener2.onItemClick(this.buttons.indexOf(view));
        }
    }

    public void renderView() {
        int i = this.buttonGroupType;
        if (i == 0) {
            return;
        }
        if (i == 2) {
            renderToListStyle();
        } else if (i != 3) {
            renderNormalStyle();
        } else {
            renderToMainStyle();
        }
    }

    public void setButtonLayout(int i) {
        if (i > 0 && i <= 3) {
            this.buttonGroupType = i;
        }
    }

    public void setButtonList(List<? extends CharSequence> list, OnItemClickListener onItemClickListener2) {
        this.buttonGroupType = 0;
        this.onItemClickListener = onItemClickListener2;
        Context context2 = getContext();
        this.buttonContainer.removeAllViews();
        this.buttons.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View createDivider = createDivider(context2);
            createDivider.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            this.buttonContainer.addView(createDivider);
            Button createButton = createButton(context2, null);
            createButton.setText((CharSequence) list.get(i));
            if (size > 1 && i == 0 && !this.positiveButtonNormal) {
                createButton.getPaint().setFakeBoldText(true);
            }
            if (i == 0) {
                createButton.setEnabled(this.positiveButtonEnabled);
                if (this.positiveButtonWarning) {
                    createButton.setTextColor(AppCompatResources.getColorStateList(context2, R$color.h5_base_dialog_button_text_color_warning));
                }
            }
            if (i < size - 1) {
                createButton.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
            } else {
                createButton.setBackgroundResource(R$drawable.h5_dialog_bottom_button_bg);
            }
            createButton.setMinHeight(this.buttonHeight);
            createButton.setGravity(17);
            createButton.setOnClickListener(this);
            this.buttonContainer.addView(createButton, -1, this.buttonHeight);
            this.buttons.add(createButton);
        }
    }

    public void setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(charSequence);
        this.negativeBtn.setOnClickListener(onClickListener);
        initDefaultStyle();
    }

    public void setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(charSequence);
        this.positiveBtn.setOnClickListener(onClickListener);
        initDefaultStyle();
    }

    public void setPositiveButtonEnabled(boolean z) {
        this.positiveButtonEnabled = z;
        this.positiveBtn.setEnabled(z);
        if (this.buttons.size() > 0 && this.buttons.get(0) != null) {
            this.buttons.get(0).setEnabled(z);
        }
    }

    public void setPositiveButtonToNormal() {
        this.positiveButtonNormal = true;
    }

    public void setPositiveButtonToWarning() {
        this.positiveButtonWarning = true;
    }

    public DialogBottomButtonGroupView(Context context2, @Nullable AttributeSet attributeSet) {
        super(context2, attributeSet);
        init(context2, attributeSet);
    }
}

package com.alibaba.security.biometrics.logic.view.widget;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.alibaba.security.biometrics.c.d;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;
import java.util.Map;

/* compiled from: Taobao */
public final class b {
    private static final String a = "SkinAssignUtils";

    public static void a(Button button, ButtonSkinData buttonSkinData) {
        if (buttonSkinData != null && button != null) {
            if (buttonSkinData.getBackgroundImageBitmap() != null) {
                button.setBackgroundDrawable(new BitmapDrawable(button.getResources(), buttonSkinData.getBackgroundImageBitmap()));
            } else if (buttonSkinData.getBackgroundColor() != null) {
                button.setBackgroundColor(d.a(buttonSkinData.getBackgroundColor(), 17170450));
            }
            button.setTextColor(d.a(buttonSkinData.getTextColor(), button.getCurrentTextColor()));
            if (buttonSkinData.getFontSize() > 0) {
                button.setTextSize(1, (float) (buttonSkinData.getFontSize() / 2));
            }
            if (buttonSkinData.getTextPadding() != null) {
                button.setPadding(a(buttonSkinData.getTextPadding()), c(buttonSkinData.getTextPadding()), b(buttonSkinData.getTextPadding()), d(buttonSkinData.getTextPadding()));
            }
        }
    }

    private static int b(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("right").intValue();
    }

    private static int c(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("top").intValue();
    }

    private static int d(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("bottom").intValue();
    }

    private static void a(View view, ControlSkinData controlSkinData, @ColorRes int i) {
        if (controlSkinData != null && view != null) {
            view.setBackgroundColor(d.a(controlSkinData.getBackgroundColor(), i));
        }
    }

    public static void a(TextView textView, TextViewSkinData textViewSkinData) {
        if (textViewSkinData != null && textView != null) {
            textView.setTextColor(d.a(textViewSkinData.getTextColor(), textView.getCurrentTextColor()));
            if (textViewSkinData.getFontSize() > 0) {
                textView.setTextSize(2, (float) (textViewSkinData.getFontSize() / 2));
            }
            if (textViewSkinData.getTextPadding() != null) {
                textView.setPadding(a(textViewSkinData.getTextPadding()), c(textViewSkinData.getTextPadding()), b(textViewSkinData.getTextPadding()), d(textViewSkinData.getTextPadding()));
            }
        }
    }

    private static int a(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("left").intValue();
    }

    public static void a(ImageView imageView, ImageViewSkinData imageViewSkinData, @DrawableRes int i) {
        if (imageView != null) {
            imageView.setImageResource(i);
            if (imageViewSkinData != null && imageViewSkinData.getSrc() != null) {
                imageView.setImageBitmap(imageViewSkinData.getSrcImageBitmap());
            }
        }
    }
}

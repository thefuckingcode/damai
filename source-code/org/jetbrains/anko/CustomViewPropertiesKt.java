package org.jetbrains.anko;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b(\")\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\n\u001a\u00020\t*\u00020\u000b2\u0006\u0010\b\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\"-\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u000b2\b\u0010\u0000\u001a\u0004\u0018\u00010\u00108Æ\u0002@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\")\u0010\u0016\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8Æ\u0002@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\")\u0010\u0019\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\t8G@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\"(\u0010\u001e\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f\".\u0010!\u001a\u0004\u0018\u00010\u0010*\u00020\"2\b\u0010\u0000\u001a\u0004\u0018\u00010\u00108Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\"*\u0010'\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007\")\u0010)\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8Æ\u0002@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000f\")\u0010,\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8G@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000f\".\u0010/\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\u0012\u0012\u0004\b0\u00101\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000f\".\u00104\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\u0012\u0012\u0004\b5\u00101\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000f\")\u00108\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8Æ\u0002@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000f\"(\u0010;\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001d\"(\u0010>\u001a\u00020\t*\u00020\u00032\u0006\u0010\b\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001d\"(\u0010A\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001d\")\u0010D\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8Æ\u0002@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000f\"(\u0010G\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\t8G@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000f¨\u0006J"}, d2 = {"value", "", "allCaps", "Landroid/widget/TextView;", "getAllCaps", "(Landroid/widget/TextView;)Z", "setAllCaps", "(Landroid/widget/TextView;Z)V", "colorId", "", "backgroundColorResource", "Landroid/view/View;", "getBackgroundColorResource", "(Landroid/view/View;)I", "setBackgroundColorResource", "(Landroid/view/View;I)V", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "getBackgroundDrawable", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "bottomPadding", "getBottomPadding", "setBottomPadding", "ems", "getEms", "(Landroid/widget/TextView;)I", "setEms", "(Landroid/widget/TextView;I)V", "horizontalPadding", "getHorizontalPadding", "setHorizontalPadding", "image", "Landroid/widget/ImageView;", "getImage", "(Landroid/widget/ImageView;)Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "isSelectable", "setSelectable", "leftPadding", "getLeftPadding", "setLeftPadding", "padding", "getPadding", "setPadding", "paddingHorizontal", "paddingHorizontal$annotations", "(Landroid/view/View;)V", "getPaddingHorizontal", "setPaddingHorizontal", "paddingVertical", "paddingVertical$annotations", "getPaddingVertical", "setPaddingVertical", "rightPadding", "getRightPadding", "setRightPadding", "textAppearance", "getTextAppearance", "setTextAppearance", "textColorResource", "getTextColorResource", "setTextColorResource", "textSizeDimen", "getTextSizeDimen", "setTextSizeDimen", "topPadding", "getTopPadding", "setTopPadding", "verticalPadding", "getVerticalPadding", "setVerticalPadding", "platform-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: CustomViewProperties.kt */
public final class CustomViewPropertiesKt {
    @Deprecated(message = "Use horizontalPadding instead", replaceWith = @ReplaceWith(expression = "horizontalPadding", imports = {}))
    public static /* synthetic */ void paddingHorizontal$annotations(View view) {
    }

    @Deprecated(message = "Use verticalPadding instead", replaceWith = @ReplaceWith(expression = "verticalPadding", imports = {}))
    public static /* synthetic */ void paddingVertical$annotations(View view) {
    }

    public static final Drawable getBackgroundDrawable(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return view.getBackground();
    }

    public static final void setBackgroundDrawable(View view, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setBackgroundDrawable(drawable);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getBackgroundColorResource(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setBackgroundColorResource(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        view.setBackgroundColor(context.getResources().getColor(i));
    }

    public static final int getLeftPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return view.getPaddingLeft();
    }

    public static final void setLeftPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final int getTopPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return view.getPaddingTop();
    }

    public static final void setTopPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final int getRightPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return view.getPaddingRight();
    }

    public static final void setRightPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final int getBottomPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return view.getPaddingBottom();
    }

    public static final void setBottomPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getPaddingHorizontal(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPaddingHorizontal(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getHorizontalPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setHorizontalPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getPaddingVertical(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPaddingVertical(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getVerticalPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setVerticalPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPadding(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        view.setPadding(i, i, i, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final boolean getAllCaps(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setAllCaps(TextView textView, boolean z) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        textView.setAllCaps(z);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getEms(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setEms(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        textView.setEms(i);
    }

    public static final boolean isSelectable(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        return textView.isTextSelectable();
    }

    public static final void setSelectable(TextView textView, boolean z) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        textView.setTextIsSelectable(z);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getTextAppearance(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextAppearance(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getTextSizeDimen(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextSizeDimen(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        Context context = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        textView.setTextSize(0, context.getResources().getDimension(i));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getTextColorResource(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextColorResource(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$receiver");
        Context context = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        textView.setTextColor(context.getResources().getColor(i));
    }

    public static final Drawable getImage(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "$receiver");
        return imageView.getDrawable();
    }

    public static final void setImage(ImageView imageView, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(imageView, "$receiver");
        imageView.setImageDrawable(drawable);
    }
}

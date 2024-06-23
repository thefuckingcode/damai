package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* compiled from: Taobao */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    /* access modifiers changed from: private */
    @RequiresApi(16)
    /* compiled from: Taobao */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i) {
            if ((i & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i) {
            CharSequence coerceToText = item.coerceToText(context);
            return ((i & 1) == 0 || !(coerceToText instanceof Spanned)) ? coerceToText : coerceToText.toString();
        }
    }

    @NonNull
    private static CharSequence coerceToText(@NonNull ClipData clipData, @NonNull Context context, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
            CharSequence coerceToText = coerceToText(context, clipData.getItemAt(i2), i);
            if (coerceToText != null) {
                spannableStringBuilder.append(coerceToText);
            }
        }
        return spannableStringBuilder;
    }

    private static void onReceiveForDragAndDrop(@NonNull TextView textView, @NonNull ContentInfoCompat contentInfoCompat) {
        replaceSelection((Editable) textView.getText(), coerceToText(contentInfoCompat.getClip(), textView.getContext(), contentInfoCompat.getFlags()));
    }

    private static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + contentInfoCompat);
        }
        int source = contentInfoCompat.getSource();
        if (source == 2) {
            return contentInfoCompat;
        }
        if (source == 3) {
            onReceiveForDragAndDrop((TextView) view, contentInfoCompat);
            return null;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < clip.getItemCount(); i++) {
            CharSequence coerceToText = coerceToText(context, clip.getItemAt(i), flags);
            if (coerceToText != null) {
                if (!z) {
                    replaceSelection(editable, coerceToText);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), StringUtils.LF);
                    editable.insert(Selection.getSelectionEnd(editable), coerceToText);
                }
            }
        }
        return null;
    }

    private static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.coerce(context, item, i);
        }
        return ApiImpl.coerce(context, item, i);
    }
}

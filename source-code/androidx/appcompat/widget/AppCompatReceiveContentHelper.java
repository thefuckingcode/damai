package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    /* access modifiers changed from: private */
    @RequiresApi(24)
    /* compiled from: Taobao */
    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        /* JADX INFO: finally extract failed */
        static boolean onDropForTextView(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.performReceiveContent(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        static boolean onDropForView(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    @NonNull
    static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(@NonNull final View view) {
        return new InputConnectionCompat.OnCommitContentListener() {
            /* class androidx.appcompat.widget.AppCompatReceiveContentHelper.AnonymousClass1 */

            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                    try {
                        inputContentInfoCompat.requestPermission();
                        InputContentInfo inputContentInfo = (InputContentInfo) inputContentInfoCompat.unwrap();
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable(AppCompatReceiveContentHelper.EXTRA_INPUT_CONTENT_INFO, inputContentInfo);
                    } catch (Exception e) {
                        Log.w(AppCompatReceiveContentHelper.LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
                        return false;
                    }
                }
                if (ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle).build()) == null) {
                    return true;
                }
                return false;
            }
        };
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View view, @NonNull DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity tryGetActivity = tryGetActivity(view);
            if (tryGetActivity == null) {
                Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return OnDropApi24Impl.onDropForTextView(dragEvent, (TextView) view, tryGetActivity);
                    }
                    return OnDropApi24Impl.onDropForView(dragEvent, view, tryGetActivity);
                }
            }
        }
        return false;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView textView, int i) {
        ClipData clipData;
        int i2 = 0;
        if ((i != 16908322 && i != 16908337) || ViewCompat.getOnReceiveContentMimeTypes(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(clipData, 1);
            if (i != 16908322) {
                i2 = 1;
            }
            ViewCompat.performReceiveContent(textView, builder.setFlags(i2).build());
        }
        return true;
    }

    @Nullable
    static Activity tryGetActivity(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}

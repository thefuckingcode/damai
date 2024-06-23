package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class WXTextView extends View implements WXGestureObservable, IWXTextView, IRenderStatus<WXText>, IRenderResult<WXText> {
    private boolean mIsLabelSet = false;
    private WeakReference<WXText> mWeakReference;
    private Layout textLayout;
    private WXGesture wxGesture;

    public WXTextView(Context context) {
        super(context);
    }

    public void enableCopy(boolean z) {
        if (z) {
            setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.taobao.weex.ui.view.WXTextView.AnonymousClass1 */

                public boolean onLongClick(View view) {
                    final String str;
                    PopupMenu popupMenu = new PopupMenu(WXTextView.this.getContext(), WXTextView.this);
                    try {
                        str = WXTextView.this.getContext().getResources().getString(17039361);
                    } catch (Throwable unused) {
                        str = "Copy";
                    }
                    popupMenu.getMenu().add(str);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        /* class com.taobao.weex.ui.view.WXTextView.AnonymousClass1.AnonymousClass1 */

                        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (!str.equals(menuItem.getTitle())) {
                                return false;
                            }
                            String charSequence = WXTextView.this.getText().toString();
                            ClipboardManager clipboardManager = (ClipboardManager) WXTextView.this.getContext().getSystemService("clipboard");
                            if (clipboardManager == null) {
                                return true;
                            }
                            clipboardManager.setPrimaryClip(ClipData.newPlainText(charSequence, charSequence));
                            return true;
                        }
                    });
                    popupMenu.show();
                    return true;
                }
            });
        } else {
            setOnLongClickListener(null);
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // com.taobao.weex.ui.view.IWXTextView
    public CharSequence getText() {
        Layout layout = this.textLayout;
        if (layout != null) {
            return layout.getText();
        }
        return null;
    }

    public Layout getTextLayout() {
        return this.textLayout;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Layout textLayout2 = getTextLayout();
        if (textLayout2 != null) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            textLayout2.draw(canvas);
        }
        canvas.restore();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? onTouchEvent | wXGesture.onTouch(this, motionEvent) : onTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void setAriaLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mIsLabelSet = true;
            setContentDescription(str);
            return;
        }
        this.mIsLabelSet = false;
        Layout layout = this.textLayout;
        if (layout != null) {
            setContentDescription(layout.getText());
        }
    }

    public void setTextColor(@ColorInt int i) {
        Layout textLayout2 = getTextLayout();
        if (textLayout2 != null) {
            textLayout2.getPaint().setColor(i);
        }
    }

    public void setTextLayout(Layout layout) {
        WXText wXText;
        this.textLayout = layout;
        if (layout != null && !this.mIsLabelSet) {
            setContentDescription(layout.getText());
        }
        WeakReference<WXText> weakReference = this.mWeakReference;
        if (weakReference != null && (wXText = weakReference.get()) != null) {
            wXText.readyToRender();
        }
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    @Nullable
    public WXText getComponent() {
        WeakReference<WXText> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void holdComponent(WXText wXText) {
        this.mWeakReference = new WeakReference<>(wXText);
    }
}

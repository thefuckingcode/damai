package com.taobao.android.dinamicx.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.weex.common.Constants;
import java.lang.reflect.Field;
import tb.c80;
import tb.i00;
import tb.ry;
import tb.x00;

/* compiled from: Taobao */
public class DXTextInputViewWidgetNode extends j {
    public static final long DXORDERTEXTINPUTVIEWCHEN_CURSORCOLOR = -1990674490194665048L;
    public static final long DXTEXTINPUTVIEW_COUNTNUMCOLOR = 9071837297406208101L;
    public static final long DXTEXTINPUTVIEW_ISSHOWHINTNUM = 2472129721305181261L;
    public static final long DXTEXTINPUTVIEW_ISSINGLELINE = 9201315914461489362L;
    public static final long DXTEXTINPUTVIEW_MULTILINEMAXHEIGHT = 2175688563532828996L;
    public static final long DXTEXTINPUTVIEW_TEXTINPUTVIEW = -7398276613927103139L;
    public static final long DXTEXTINPUTVIEW_TOTALNUMCOLOR = 36296692771444064L;
    private int j;
    private boolean k = true;
    private int l;
    private int m;
    private int n;
    private boolean o = false;

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        final /* synthetic */ EditText a;

        a(EditText editText) {
            this.a = editText;
        }

        public void onClick(View view) {
            this.a.requestFocus();
            this.a.setCursorVisible(true);
            DXTextInputViewWidgetNode.this.e(this.a);
        }
    }

    /* compiled from: Taobao */
    class b implements View.OnTouchListener {
        final /* synthetic */ EditText a;

        b(DXTextInputViewWidgetNode dXTextInputViewWidgetNode, EditText editText) {
            this.a = editText;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 1) {
                return false;
            }
            this.a.setCursorVisible(true);
            return false;
        }
    }

    /* compiled from: Taobao */
    public static class c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXTextInputViewWidgetNode();
        }
    }

    /* compiled from: Taobao */
    public static class d implements TextWatcher {
        private DXTextInputViewWidgetNode a;
        private View b;
        x00 c = new x00(5288679823228297259L);

        public d(DXTextInputViewWidgetNode dXTextInputViewWidgetNode, View view) {
            this.a = dXTextInputViewWidgetNode;
            this.b = view;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            View view = this.b;
            if (view instanceof RelativeLayout) {
                ((TextView) view.findViewById(R$id.tv_word_count)).setText(String.valueOf(charSequence.length()));
                this.c.f(((EditText) this.b.findViewById(R$id.dx_multi_line_input)).getText());
                this.a.postEvent(this.c);
                return;
            }
            this.c.f(((EditText) view).getText());
            this.a.postEvent(this.c);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(EditText editText) {
        InputMethodManager inputMethodManager;
        if (editText != null && getDXRuntimeContext() != null && getDXRuntimeContext().getContext() != null) {
            if ((!(getDXRuntimeContext().getContext() instanceof Activity) || !((Activity) getDXRuntimeContext().getContext()).isFinishing()) && (inputMethodManager = (InputMethodManager) getDXRuntimeContext().getContext().getSystemService("input_method")) != null) {
                editText.requestFocus();
                editText.requestFocusFromTouch();
                inputMethodManager.showSoftInput(editText, 0);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXTextInputViewWidgetNode();
    }

    public void d(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {editText.getContext().getResources().getDrawable(i2), editText.getContext().getResources().getDrawable(i2)};
            drawableArr[0].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (Throwable unused) {
            ry.g(ry.TAG, "textInput 游标颜色设置失败");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        if (j2 != 5288679823228297259L) {
            super.onBindEvent(context, view, j2);
        } else if (view instanceof EditText) {
            super.onBindEvent(context, view, j2);
        } else {
            int i = c80.TEXT_WATCHER;
            d dVar = (d) view.getTag(i);
            EditText editText = (EditText) view.findViewById(R$id.dx_multi_line_input);
            if (dVar != null) {
                editText.removeTextChangedListener(dVar);
            }
            d dVar2 = new d(this, view);
            editText.setTag(i, dVar2);
            editText.addTextChangedListener(dVar2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXTextInputViewWidgetNode) {
            DXTextInputViewWidgetNode dXTextInputViewWidgetNode = (DXTextInputViewWidgetNode) dXWidgetNode;
            this.j = dXTextInputViewWidgetNode.j;
            this.k = dXTextInputViewWidgetNode.k;
            this.l = dXTextInputViewWidgetNode.l;
            this.o = dXTextInputViewWidgetNode.o;
            this.m = dXTextInputViewWidgetNode.m;
            this.n = dXTextInputViewWidgetNode.n;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (this.k) {
            return super.onCreateView(context);
        }
        View a2 = i00.a(context, R$layout.multi_line_input_view);
        ((EditText) a2.findViewById(R$id.dx_multi_line_input)).setBackgroundColor(0);
        if (this.o) {
            ((TextView) a2.findViewById(R$id.tv_word_total)).setVisibility(0);
            ((TextView) a2.findViewById(R$id.tv_word_count)).setVisibility(0);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (!this.k) {
            setMeasuredDimension(i, this.j);
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, final View view) {
        final EditText editText;
        if (view == null) {
            return;
        }
        if ((view instanceof EditText) || (view instanceof RelativeLayout)) {
            if (!this.k) {
                editText = (EditText) view.findViewById(R$id.dx_multi_line_input);
                final TextView textView = (TextView) view.findViewById(R$id.tv_word_total);
                if (this.f > 0) {
                    textView.setText("/" + this.f);
                }
                int i = this.m;
                if (i != 0) {
                    ((TextView) view.findViewById(R$id.tv_word_count)).setTextColor(tryFetchDarkModeColor("textColor", 0, i));
                }
                int i2 = this.n;
                if (i2 != 0) {
                    textView.setTextColor(tryFetchDarkModeColor("textColor", 0, i2));
                }
                view.setOnClickListener(new a(editText));
                if (this.o) {
                    view.post(new Runnable() {
                        /* class com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode.AnonymousClass2 */

                        public void run() {
                            editText.setMaxHeight((view.getHeight() - textView.getMeasuredHeight()) - ((RelativeLayout.LayoutParams) textView.getLayoutParams()).bottomMargin);
                        }
                    });
                }
            } else {
                editText = (EditText) view;
                a(editText, this.e);
            }
            editText.setHint(this.g);
            editText.setHintTextColor(tryFetchDarkModeColor(Constants.Name.PLACEHOLDER_COLOR, 0, this.h));
            editText.setText(this.a);
            editText.setTextSize(0, this.c);
            editText.setTextColor(tryFetchDarkModeColor("textColor", 0, this.b));
            b(editText, this.d);
            editText.setCursorVisible(false);
            int i3 = this.l;
            if (i3 != 0) {
                d(editText, i3);
            }
            editText.setOnTouchListener(new b(this, editText));
            if (this.f <= 0) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
                return;
            }
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f)});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i) {
        if (j2 == DXTEXTINPUTVIEW_MULTILINEMAXHEIGHT) {
            this.j = i;
        } else if (j2 == DXORDERTEXTINPUTVIEWCHEN_CURSORCOLOR) {
            this.l = i;
        } else if (j2 == DXTEXTINPUTVIEW_COUNTNUMCOLOR) {
            this.m = i;
        } else if (j2 == DXTEXTINPUTVIEW_TOTALNUMCOLOR) {
            this.n = i;
        } else {
            boolean z = true;
            if (j2 == DXTEXTINPUTVIEW_ISSINGLELINE) {
                if (i == 0) {
                    z = false;
                }
                this.k = z;
            } else if (j2 == DXTEXTINPUTVIEW_ISSHOWHINTNUM) {
                if (i == 0) {
                    z = false;
                }
                this.o = z;
            } else {
                super.onSetIntAttribute(j2, i);
            }
        }
    }
}

package tb;

import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
public class g11 extends s70 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnTouchListener {
        final /* synthetic */ View a;
        final /* synthetic */ Map b;
        final /* synthetic */ x70 c;
        final /* synthetic */ z70 d;

        a(View view, Map map, x70 x70, z70 z70) {
            this.a = view;
            this.b = map;
            this.c = x70;
            this.d = z70;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                View view2 = this.a;
                int i = c80.KEY_BOARD_LISTENER;
                if (((c) view2.getTag(i)) == null) {
                    ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
                    if (this.b.containsKey(DAttrConstant.VIEW_EVENT_BEGIN)) {
                        String str = (String) this.b.get(DAttrConstant.VIEW_EVENT_BEGIN);
                        if (!TextUtils.isEmpty(str)) {
                            ArrayList arrayList = new ArrayList(5);
                            arrayList.add(((EditText) this.a).getText());
                            this.a.setTag(c80.VIEW_PARAMS, arrayList);
                            s70.d(this.a, this.c, this.d, str);
                        }
                    }
                    c cVar = new c(g11.this, this.a, this.d);
                    cVar.e(this.c);
                    this.a.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
                    this.a.setTag(i, cVar);
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    public class b implements TextWatcher {
        private x70 a;
        private z70 b;
        private String c;
        private View d;

        public b(g11 g11, View view, z70 z70) {
            this.b = z70;
            this.d = view;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.c = map.get(DAttrConstant.VIEW_EVENT_CHANGE);
                map.get(DAttrConstant.VIEW_EVENT_BEGIN);
            }
        }

        public void a(x70 x70) {
            this.a = x70;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!TextUtils.isEmpty(this.c)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add(((EditText) this.d).getText());
                this.d.setTag(c80.VIEW_PARAMS, arrayList);
                s70.d(this.d, this.a, this.b, this.c);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private x70 a;
        private z70 b;
        private String c;
        private View d;
        private boolean e;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements View.OnFocusChangeListener {
            a() {
            }

            public void onFocusChange(View view, boolean z) {
                if (!z && !c.this.e) {
                    c.this.c();
                }
            }
        }

        public c(g11 g11, View view, z70 z70) {
            this.b = z70;
            this.d = view;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.c = map.get(DAttrConstant.VIEW_EVENT_FINISH);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void c() {
            if (!TextUtils.isEmpty(this.c)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add(((EditText) this.d).getText());
                this.d.setTag(c80.VIEW_PARAMS, arrayList);
                s70.d(this.d, this.a, this.b, this.c);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.d.setTag(c80.KEY_BOARD_LISTENER, null);
            } else {
                this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.d.setTag(c80.KEY_BOARD_LISTENER, null);
            }
            this.e = true;
        }

        private void d() {
        }

        public void e(x70 x70) {
            this.a = x70;
            this.d.setOnFocusChangeListener(new a());
        }

        public void onGlobalLayout() {
            Rect rect = new Rect();
            View rootView = this.d.getRootView();
            rootView.getWindowVisibleDisplayFrame(rect);
            int height = rootView.getHeight();
            if (height - rect.bottom > height / 3) {
                d();
            } else {
                c();
            }
        }
    }

    @Override // tb.s70
    public void b(View view, x70 x70) {
        super.b(view, x70);
        e(view, x70);
    }

    public void e(View view, x70 x70) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
        }
        z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
        if (z70 != null) {
            Map<String, String> map = z70.d;
            if (map.isEmpty()) {
                return;
            }
            if (view.isFocusable()) {
                if (map.containsKey(DAttrConstant.VIEW_EVENT_CHANGE)) {
                    int i = c80.TEXT_WATCHER;
                    b bVar = (b) view.getTag(i);
                    if (bVar != null) {
                        ((EditText) view).removeTextChangedListener(bVar);
                    }
                    b bVar2 = new b(this, view, z70);
                    bVar2.a(x70);
                    view.setTag(i, bVar2);
                    ((EditText) view).addTextChangedListener(bVar2);
                }
                if (map.containsKey(DAttrConstant.VIEW_EVENT_FINISH) || map.containsKey(DAttrConstant.VIEW_EVENT_BEGIN)) {
                    view.setOnTouchListener(new a(view, map, x70, z70));
                    return;
                }
                return;
            }
            view.setOnTouchListener(null);
            b bVar3 = (b) view.getTag(c80.TEXT_WATCHER);
            if (bVar3 != null) {
                ((EditText) view).removeTextChangedListener(bVar3);
            }
            view.setOnFocusChangeListener(null);
        }
    }
}

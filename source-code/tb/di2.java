package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.android.ultron.trade.R$id;
import com.alibaba.android.ultron.trade.dinamicx3.widget.TDTextInputDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;

/* compiled from: Taobao */
public class di2 extends DXTextViewWidgetNode {
    private static final long C = my.a(Constants.Name.PLACEHOLDER);
    private static final long D = my.a(Constants.Name.PLACEHOLDER_COLOR);
    public static final long DX_WIDGET_ID = my.a("tdTextInput");
    private static final long E = my.a(Constants.Event.KEYBOARD);
    private static final long F = my.a(Constants.Name.MAX_LENGTH);
    private static final long G = my.a(RemoteMessageConst.INPUT_TYPE);
    private static final long H = my.a("textUnit");
    private static final long I = my.a(DAttrConstant.VIEW_EVENT_FINISH);
    public static final int ID_KEY_BOARD = R$id.trade_id_key_board;
    public static final int ID_MAX_LENGTH = R$id.trade_id_max_length;
    public static final int ID_PLACE_HOLDER = R$id.trade_id_place_holder;
    public static final int ID_PLACE_HOLDER_COLOR = R$id.trade_id_place_holder_color;
    public static final int ID_TV_TEXT = R$id.trade_id_text;
    public static final String INPUT_TYPE_DIALOG = "dialog";
    public static final String INPUT_TYPE_INPUT = "input";
    private static final int J = R$id.trade_text_watcher;
    private String A;
    private String B;
    private String v;
    private String w;
    private int x;
    private int y;
    private int z;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new di2();
        }
    }

    /* compiled from: Taobao */
    public class b {
        private String a;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements View.OnTouchListener {
            final /* synthetic */ View a;

            /* renamed from: tb.di2$b$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            class C0301a implements TDTextInputDialog.OnClickListener {
                C0301a() {
                }

                @Override // com.alibaba.android.ultron.trade.dinamicx3.widget.TDTextInputDialog.OnClickListener
                public void onClick(DialogInterface dialogInterface, CharSequence charSequence) {
                    a aVar = a.this;
                    b bVar = b.this;
                    bVar.c(aVar.a, bVar.a);
                }
            }

            a(View view) {
                this.a = view;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1 || view.isFocusable()) {
                    return false;
                }
                TDTextInputDialog tDTextInputDialog = new TDTextInputDialog(view.getContext());
                tDTextInputDialog.h((EditText) this.a);
                tDTextInputDialog.i(new C0301a());
                tDTextInputDialog.show();
                return true;
            }
        }

        public b(String str) {
            this.a = str;
        }

        public void b(View view) {
            if (view instanceof EditText) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.setFocusable(true);
                    viewGroup.setFocusableInTouchMode(true);
                }
                c cVar = (c) view.getTag(di2.J);
                if (cVar != null) {
                    ((EditText) view).removeTextChangedListener(cVar);
                }
                c cVar2 = new c(view, this.a);
                view.setTag(di2.J, cVar2);
                ((EditText) view).addTextChangedListener(cVar2);
                view.setOnTouchListener(new a(view));
            }
        }

        public void c(View view, String str) {
            if ("dialog".equals(str)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add("dialog");
                arrayList.add(((EditText) view).getText());
                view.setTag(jw2.DINAMICX_3_CUSTOM_INPUT_KEY, arrayList);
                di2.this.postEvent(new lx(di2.I));
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private View a;
        private String b;

        public c(View view, String str) {
            this.a = view;
            this.b = str;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.isFocusable() && "input".equals(this.b)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add("input");
                arrayList.add(((EditText) this.a).getText());
                this.a.setTag(jw2.DINAMICX_3_CUSTOM_INPUT_KEY, arrayList);
                di2.this.postEvent(new lx(di2.I));
            }
        }
    }

    private void y(EditText editText, boolean z2) {
        if (editText != null) {
            editText.setFocusable(z2);
            editText.setFocusableInTouchMode(z2);
        }
    }

    private void z(View view) {
        if (view instanceof EditText) {
            view.setTag(ID_TV_TEXT, this.v);
            EditText editText = (EditText) view;
            i80.b(editText, this.x);
            view.setTag(ID_PLACE_HOLDER_COLOR, Integer.valueOf(this.x));
            i80.c(editText, this.y);
            view.setTag(ID_KEY_BOARD, Integer.valueOf(this.y));
            i80.d(editText, this.z);
            view.setTag(ID_MAX_LENGTH, Integer.valueOf(this.z));
            if (!TextUtils.isEmpty(this.w)) {
                i80.a(editText, this.w);
                view.setTag(ID_PLACE_HOLDER, this.w);
            } else if (!TextUtils.isEmpty(this.B)) {
                y(editText, "input".equalsIgnoreCase(this.B));
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new di2();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void h(TextView textView) {
        super.h(textView);
        z(textView);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
        if (I == j) {
            new b(this.B).b(view);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z2) {
        super.onClone(dXWidgetNode, z2);
        if (dXWidgetNode instanceof di2) {
            di2 di2 = (di2) dXWidgetNode;
            this.v = di2.v;
            this.A = di2.A;
            this.w = di2.w;
            this.x = di2.x;
            this.y = di2.y;
            this.z = di2.z;
            this.B = di2.B;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        EditText editText = new EditText(context);
        editText.setPadding(0, 0, 0, 0);
        return editText;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (!TextUtils.isEmpty(this.A)) {
            t(this.v + this.A);
        }
        super.onRenderView(context, view);
        z(view);
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        super.onSetIntAttribute(j, i);
        if (D == j) {
            this.x = i;
        } else if (E == j) {
            this.y = i;
        } else if (F == j) {
            this.z = i;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        super.onSetStringAttribute(j, str);
        if (38178040921L == j) {
            this.v = str;
        } else if (C == j) {
            this.w = str;
        } else if (G == j) {
            this.B = str;
        } else if (H == j) {
            this.A = str;
        }
    }
}

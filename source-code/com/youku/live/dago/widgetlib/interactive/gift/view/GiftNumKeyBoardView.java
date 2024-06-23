package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftKeyBoardAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.KeyBoardBean;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import java.util.ArrayList;

/* compiled from: Taobao */
public class GiftNumKeyBoardView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_COLUMN = 4;
    private Button btnSure;
    private ClickSureListener clickSureListener;
    private NoScrollGridView gridView;
    private boolean isClickSure;
    private ArrayList<KeyBoardBean> list;
    private Context mContext;
    private RelativeLayout mEditNumLayout;
    private EditText mEditText;
    private View mSpace;
    private Drawable mSureBtnBackgroundDrawable;
    TextWatcher mTextWatcher;

    /* compiled from: Taobao */
    public interface ClickSureListener {
        void onNumConfirm(long j);
    }

    public GiftNumKeyBoardView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530217089")) {
            ipChange.ipc$dispatch("-1530217089", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_num_keyboard_layout, (ViewGroup) this, true);
        this.mEditNumLayout = (RelativeLayout) findViewById(R.id.rl);
        this.gridView = (NoScrollGridView) findViewById(R.id.id_gv);
        this.mEditText = (EditText) findViewById(R.id.id_editText_show_num);
        this.btnSure = (Button) findViewById(R.id.id_btn_sure);
        View findViewById = findViewById(R.id.space);
        this.mSpace = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "533837660")) {
                    ipChange.ipc$dispatch("533837660", new Object[]{this, view});
                    return;
                }
                GiftNumKeyBoardView.this.onDismiss();
            }
        });
        this.btnSure.setEnabled(false);
        this.btnSure.setTextColor(-1);
        this.btnSure.setOnClickListener(this);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.mEditText.setFocusable(false);
        this.mEditText.setFocusableInTouchMode(false);
        this.mEditText.clearFocus();
        this.mEditText.setInputType(0);
        init();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onDismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593822175")) {
            ipChange.ipc$dispatch("-593822175", new Object[]{this});
            return;
        }
        if (this.clickSureListener != null) {
            String obj = this.mEditText.getEditableText().toString();
            if (obj.length() <= 0) {
                this.clickSureListener.onNumConfirm(0);
            } else if (this.isClickSure) {
                this.clickSureListener.onNumConfirm(Long.valueOf(obj).longValue());
            } else {
                this.clickSureListener.onNumConfirm(0);
            }
        }
        this.mEditText.getEditableText().clear();
        this.isClickSure = false;
    }

    public int getGiftNum(Editable editable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275563984")) {
            return ((Integer) ipChange.ipc$dispatch("275563984", new Object[]{this, editable})).intValue();
        }
        String obj = editable.toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() == 0) {
            obj = "0";
        }
        return Integer.parseInt(obj);
    }

    public void init() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-37921842")) {
            ipChange.ipc$dispatch("-37921842", new Object[]{this});
            return;
        }
        this.list.clear();
        this.mEditText.getEditableText().clear();
        for (int i2 = 1; i2 <= 9; i2++) {
            ArrayList<KeyBoardBean> arrayList = this.list;
            arrayList.add(new KeyBoardBean("" + i2, 0));
        }
        this.list.add(new KeyBoardBean("", 1));
        this.list.add(new KeyBoardBean("0", 0));
        this.list.add(new KeyBoardBean("", 2));
        int size = this.list.size() / 4;
        if (this.list.size() % 4 != 0) {
            i = 1;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gridView.getLayoutParams();
        layoutParams.height = (size + i) * DensityUtil.dip2px(this.mContext, 50.0f);
        this.gridView.setLayoutParams(layoutParams);
        this.gridView.setAdapter((ListAdapter) new GiftKeyBoardAdapter(this.mContext, this.list));
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1219859173")) {
                    ipChange.ipc$dispatch("1219859173", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)});
                    return;
                }
                int i2 = ((KeyBoardBean) GiftNumKeyBoardView.this.list.get(i)).type;
                if (i2 == 0) {
                    int selectionStart = GiftNumKeyBoardView.this.mEditText.getSelectionStart();
                    Editable editableText = GiftNumKeyBoardView.this.mEditText.getEditableText();
                    if (editableText.length() >= 5) {
                        ToastUtil.showCenter(GiftNumKeyBoardView.this.mContext, "最多只能输入99999哦");
                        return;
                    }
                    if (selectionStart < 0) {
                        editableText.append((CharSequence) ((KeyBoardBean) GiftNumKeyBoardView.this.list.get(i)).name);
                    } else {
                        editableText.insert(selectionStart, ((KeyBoardBean) GiftNumKeyBoardView.this.list.get(i)).name);
                    }
                    if (editableText.toString().startsWith("0")) {
                        ToastUtil.showCenter(GiftNumKeyBoardView.this.mContext, "不能以0开头哦");
                        editableText.clear();
                    }
                } else if (i2 == 2) {
                    GiftNumKeyBoardView.this.mEditText.onKeyDown(67, new KeyEvent(0, 67));
                }
            }
        });
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600296945")) {
            ipChange.ipc$dispatch("-1600296945", new Object[]{this, view});
            return;
        }
        this.isClickSure = true;
        onDismiss();
    }

    public void setClickSureListener(ClickSureListener clickSureListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568717436")) {
            ipChange.ipc$dispatch("-1568717436", new Object[]{this, clickSureListener2});
            return;
        }
        this.clickSureListener = clickSureListener2;
    }

    public void setKeyBoardBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373002241")) {
            ipChange.ipc$dispatch("-1373002241", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mEditNumLayout.setBackgroundResource(R.drawable.dago_pgc_ykl_num_keyboard_top_full_bg);
            this.gridView.setBackgroundResource(R.drawable.dago_pgc_ykl_num_keyboard_bottom_full_bg);
        } else {
            this.mEditNumLayout.setBackgroundResource(R.drawable.dago_pgc_ykl_num_keyboard_top_bg);
            this.gridView.setBackgroundResource(R.drawable.dago_pgc_ykl_num_keyboard_bottom_bg);
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626821984")) {
            ipChange.ipc$dispatch("-1626821984", new Object[]{this, giftTheme});
            return;
        }
        GradientDrawable gradientDrawable = ThemeUtils.getGradientDrawable(giftTheme.btnGiantStartColor, giftTheme.btnGiantEndColor, GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, (float) (DensityUtil.dip2px(this.mContext, 1.0f) * 18));
        this.mSureBtnBackgroundDrawable = gradientDrawable;
        this.btnSure.setBackground(gradientDrawable);
    }

    public GiftNumKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftNumKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.list = new ArrayList<>();
        this.mTextWatcher = new TextWatcher() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void afterTextChanged(Editable editable) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-886006983")) {
                    ipChange.ipc$dispatch("-886006983", new Object[]{this, editable});
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1880243370")) {
                    ipChange.ipc$dispatch("1880243370", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-661072310")) {
                    ipChange.ipc$dispatch("-661072310", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                } else if (charSequence.toString().length() == 0) {
                    GiftNumKeyBoardView.this.mEditText.clearFocus();
                    GiftNumKeyBoardView.this.mEditText.setFocusable(false);
                    GiftNumKeyBoardView.this.mEditText.setFocusableInTouchMode(false);
                    GiftNumKeyBoardView.this.mEditText.setHint("输入赠送数量,  最多99999");
                    GiftNumKeyBoardView.this.btnSure.setTextColor(Color.parseColor("#55ffffff"));
                    GiftNumKeyBoardView.this.btnSure.setEnabled(false);
                } else {
                    GiftNumKeyBoardView.this.btnSure.setTextColor(-1);
                    GiftNumKeyBoardView.this.btnSure.setEnabled(true);
                }
            }
        };
        initView(context);
    }
}

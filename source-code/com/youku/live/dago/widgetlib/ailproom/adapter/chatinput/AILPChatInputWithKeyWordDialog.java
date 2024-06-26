package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog;
import com.youku.live.dago.widgetlib.ailproom.view.ConfigurationChangedRelativeLayout;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class AILPChatInputWithKeyWordDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COUNTDOWN_HANDLER_WHAT = 1;
    public static final int COUNTDOWN_INTERVAL = 1000;
    public static final int DEFAULT_MAX_CHAT_INPUT_LENGTH = 60;
    private Handler handler;
    private KeywordChatInputDto keywordChatInputDto;
    private Activity mContext;
    private TextView mCountTimeView;
    private TUrlImageView mInputBgView;
    private EditText mInputEditText;
    private View mInputLayout;
    private BaseInputDialog.OnInputCompleteListener mInputListener;
    private InputMethodManager mInputMethodManager;
    private View mKeywordBgView;
    private RelativeLayout mKeywordLayout;
    private CharSequence mLastInput;
    private int mOrientation;
    private TUrlImageView mRedIconView;
    private TextView mRedTipView;
    private LinearLayout mRootLayout;
    private TextView mSumTextView;
    private int maxLength;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private boolean weexCallClose = false;

    public AILPChatInputWithKeyWordDialog(@NonNull Context context, int i, int i2, final KeywordChatInputDto keywordChatInputDto2, BaseInputDialog.OnInputCompleteListener onInputCompleteListener) {
        super(context, i);
        this.mContext = (Activity) context;
        this.mOrientation = i2;
        this.mInputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        this.keywordChatInputDto = keywordChatInputDto2;
        int i3 = keywordChatInputDto2.limit;
        this.maxLength = i3 <= 0 ? 60 : i3;
        this.mInputListener = onInputCompleteListener;
        this.handler = new Handler() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-123266893")) {
                    ipChange.ipc$dispatch("-123266893", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                if (message.what == 1) {
                    KeywordChatInputDto keywordChatInputDto = keywordChatInputDto2;
                    int i = keywordChatInputDto.countTime;
                    if (i < 0) {
                        if (!TextUtils.isEmpty(keywordChatInputDto.endTips)) {
                            AILPChatInputWithKeyWordDialog.this.showTextToast(keywordChatInputDto2.endTips);
                        }
                        AILPChatInputWithKeyWordDialog.this.mKeywordLayout.setVisibility(8);
                        return;
                    }
                    keywordChatInputDto.countTime = i - 1;
                    AILPChatInputWithKeyWordDialog.this.mCountTimeView.setText(AILPChatInputWithKeyWordDialog.parseCountTime(keywordChatInputDto2.countTime));
                    AILPChatInputWithKeyWordDialog.this.handler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        };
    }

    private static int parseColor(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913997502")) {
            return ((Integer) ipChange.ipc$dispatch("1913997502", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* access modifiers changed from: private */
    public static String parseCountTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525860366")) {
            return (String) ipChange.ipc$dispatch("-525860366", new Object[]{Integer.valueOf(i)});
        } else if (i <= 0) {
            return "00:00";
        } else {
            int i2 = i % 60;
            int i3 = i / 60;
            StringBuilder sb = new StringBuilder();
            if (i3 >= 10) {
                sb.append(i3);
                sb.append(":");
            } else {
                sb.append("0");
                sb.append(i3);
                sb.append(":");
            }
            if (i2 >= 10) {
                sb.append(i2);
            } else {
                sb.append("0");
                sb.append(i2);
            }
            return sb.toString();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMessage() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-610022675")) {
            ipChange.ipc$dispatch("-610022675", new Object[]{this});
        } else if (this.mInputListener != null) {
            int spaceCount = BaseInputDialog.getSpaceCount(this.mInputEditText.getText());
            int i = this.maxLength;
            if (spaceCount > i) {
                onOverMaxLength(spaceCount, i);
                return;
            }
            Editable text = this.mInputEditText.getText();
            if (TextUtils.isEmpty(text) || TextUtils.isEmpty(text.toString().trim())) {
                z = true;
            }
            if (z) {
                onEmptyInput();
            } else {
                onInput(text);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTextToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925698393")) {
            ipChange.ipc$dispatch("925698393", new Object[]{this, str});
            return;
        }
        Context context = getContext();
        if (context != null) {
            ToastUtil.toast(context, str);
        }
    }

    private void updateView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352639600")) {
            ipChange.ipc$dispatch("-1352639600", new Object[]{this});
            return;
        }
        if (!TextUtils.isEmpty(this.keywordChatInputDto.placeholder)) {
            this.mInputEditText.setHint(this.keywordChatInputDto.placeholder);
            this.mInputEditText.setHintTextColor(parseColor(this.keywordChatInputDto.placeholderColor, this.mInputEditText.getCurrentHintTextColor()));
        }
        setSumTextView(this.mSumTextView, false, this.maxLength);
        this.mInputEditText.setTextColor(parseColor(this.keywordChatInputDto.textColor, this.mInputEditText.getCurrentTextColor()));
        String str = !TextUtils.isEmpty(this.keywordChatInputDto.text) ? this.keywordChatInputDto.text : !TextUtils.isEmpty(this.mLastInput) ? this.mLastInput : "";
        if (!TextUtils.isEmpty(str)) {
            this.mInputEditText.setText(str);
            this.mInputEditText.setSelection(str.length());
            int spaceCount = this.maxLength - BaseInputDialog.getSpaceCount(str);
            setSumTextView(this.mSumTextView, spaceCount < 0, Math.abs(spaceCount));
        }
        int parseColor = parseColor(this.keywordChatInputDto.bgColor, ContextCompat.getColor(getContext(), R.color.dago_pgc_chat_input_normal_bg_color));
        this.mKeywordBgView.setBackgroundColor(parseColor);
        this.mInputLayout.setBackgroundColor(parseColor);
        if (!TextUtils.isEmpty(this.keywordChatInputDto.inputBgImg)) {
            this.mInputBgView.setImageUrl(this.keywordChatInputDto.inputBgImg);
        }
        KeywordChatInputDto keywordChatInputDto2 = this.keywordChatInputDto;
        if (keywordChatInputDto2.isNormal || keywordChatInputDto2.countTime <= 0) {
            this.mKeywordLayout.setVisibility(8);
            return;
        }
        this.mKeywordLayout.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(this.keywordChatInputDto.title)) {
            SpannableString spannableString = new SpannableString(this.keywordChatInputDto.title);
            if (!TextUtils.isEmpty(this.keywordChatInputDto.titleColor)) {
                spannableString.setSpan(new ForegroundColorSpan(parseColor(this.keywordChatInputDto.titleColor, ContextCompat.getColor(getContext(), R.color.dago_pgc_chat_input_keyword_title_text_color))), 0, spannableString.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        spannableStringBuilder.append((CharSequence) StringUtils.LF);
        if (!TextUtils.isEmpty(this.keywordChatInputDto.keyword)) {
            SpannableString spannableString2 = new SpannableString(this.keywordChatInputDto.keyword);
            if (!TextUtils.isEmpty(this.keywordChatInputDto.keywordColor)) {
                spannableString2.setSpan(new ForegroundColorSpan(parseColor(this.keywordChatInputDto.keywordColor, ContextCompat.getColor(getContext(), R.color.dago_pgc_chat_input_keyword_desc_text_color))), 0, spannableString2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.mRedTipView.setText(spannableStringBuilder);
        }
        if (!TextUtils.isEmpty(this.keywordChatInputDto.icon)) {
            this.mRedIconView.setImageUrl(this.keywordChatInputDto.icon);
        }
        this.mCountTimeView.setTextColor(parseColor(this.keywordChatInputDto.countTimeColor, this.mCountTimeView.getCurrentTextColor()));
        this.mCountTimeView.setText(parseCountTime(this.keywordChatInputDto.countTime));
        this.handler.sendEmptyMessageDelayed(1, 1000);
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544665332")) {
            ipChange.ipc$dispatch("544665332", new Object[]{this});
            return;
        }
        this.weexCallClose = true;
        dismiss();
    }

    public void dismiss() {
        EditText editText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094549150")) {
            ipChange.ipc$dispatch("-2094549150", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (!(inputMethodManager == null || (editText = this.mInputEditText) == null)) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        LinearLayout linearLayout = this.mRootLayout;
        if (!(linearLayout == null || this.onGlobalLayoutListener == null)) {
            linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
        this.handler.removeCallbacks(null);
        super.dismiss();
    }

    public CharSequence getInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154505872")) {
            return (CharSequence) ipChange.ipc$dispatch("-1154505872", new Object[]{this});
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            return editText.getText();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303667556")) {
            return ((Integer) ipChange.ipc$dispatch("303667556", new Object[]{this})).intValue();
        } else if (this.mOrientation == 2) {
            return R.layout.dago_pgc_ailp_chat_edit_bar_with_keyword_fullscreen;
        } else {
            return R.layout.dago_pgc_ailp_chat_edit_bar_with_keyword;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654028375")) {
            ipChange.ipc$dispatch("-1654028375", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_layout);
        this.mRootLayout = linearLayout;
        ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
        AnonymousClass2 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;
            private int curDecorBottom;
            private int firstDecorBottom = -1;

            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1754272384")) {
                    ipChange.ipc$dispatch("-1754272384", new Object[]{this});
                    return;
                }
                View decorView = AILPChatInputWithKeyWordDialog.this.getWindow().getDecorView();
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int i = this.firstDecorBottom;
                if (i == -1) {
                    int i2 = rect.bottom;
                    this.firstDecorBottom = i2;
                    this.curDecorBottom = i2;
                    return;
                }
                int i3 = rect.bottom;
                if (i != i3 || this.curDecorBottom >= i3) {
                    this.curDecorBottom = i3;
                } else {
                    AILPChatInputWithKeyWordDialog.this.close();
                }
            }
        };
        this.onGlobalLayoutListener = r1;
        viewTreeObserver.addOnGlobalLayoutListener(r1);
        this.mSumTextView = (TextView) findViewById(R.id.tv_comment_sum_left);
        this.mInputEditText = (EditText) findViewById(R.id.et_comment_input);
        this.mCountTimeView = (TextView) findViewById(R.id.count_time);
        this.mKeywordLayout = (RelativeLayout) findViewById(R.id.keyword_layout);
        this.mRedTipView = (TextView) findViewById(R.id.keyword_tip);
        this.mRedIconView = (TUrlImageView) findViewById(R.id.red_icon);
        if (this.mOrientation == 2) {
            this.mInputLayout = findViewById(R.id.input_root_layout);
        } else {
            this.mInputLayout = findViewById(R.id.group_edit_container);
        }
        ((ConfigurationChangedRelativeLayout) findViewById(R.id.group_edit_container)).setConfigurationListener(new ViewFlowLayout.ConfigurationListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout.ConfigurationListener
            public void onConfigurationChanged(Configuration configuration) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1998154688")) {
                    ipChange.ipc$dispatch("1998154688", new Object[]{this, configuration});
                } else if (AILPChatInputWithKeyWordDialog.this.isShowing()) {
                    AILPChatInputWithKeyWordDialog.this.close();
                }
            }
        });
        this.mKeywordBgView = findViewById(R.id.keyword_bg);
        this.mInputBgView = (TUrlImageView) findViewById(R.id.input_bg);
        this.mInputEditText.addTextChangedListener(new TextWatcher() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void afterTextChanged(Editable editable) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "-1233293416")) {
                    ipChange.ipc$dispatch("-1233293416", new Object[]{this, editable});
                    return;
                }
                AILPChatInputWithKeyWordDialog aILPChatInputWithKeyWordDialog = AILPChatInputWithKeyWordDialog.this;
                aILPChatInputWithKeyWordDialog.mLastInput = aILPChatInputWithKeyWordDialog.mInputEditText.getText().toString();
                int spaceCount = AILPChatInputWithKeyWordDialog.this.maxLength - BaseInputDialog.getSpaceCount(AILPChatInputWithKeyWordDialog.this.mLastInput);
                AILPChatInputWithKeyWordDialog aILPChatInputWithKeyWordDialog2 = AILPChatInputWithKeyWordDialog.this;
                TextView textView = aILPChatInputWithKeyWordDialog2.mSumTextView;
                if (spaceCount >= 0) {
                    z = false;
                }
                aILPChatInputWithKeyWordDialog2.setSumTextView(textView, z, Math.abs(spaceCount));
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "432425899")) {
                    ipChange.ipc$dispatch("432425899", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1457950155")) {
                    ipChange.ipc$dispatch("1457950155", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        });
        this.mInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1587941204")) {
                    return ((Boolean) ipChange.ipc$dispatch("1587941204", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
                } else if (i != 6 && i != 4) {
                    return false;
                } else {
                    AILPChatInputWithKeyWordDialog.this.sendMessage();
                    return true;
                }
            }
        });
        this.mInputEditText.setOnTouchListener(new View.OnTouchListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1260476209")) {
                    return ((Boolean) ipChange.ipc$dispatch("1260476209", new Object[]{this, view, motionEvent})).booleanValue();
                }
                if (motionEvent.getAction() == 0) {
                    AILPChatInputWithKeyWordDialog.this.mInputEditText.requestFocus();
                }
                return false;
            }
        });
        this.mInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onFocusChange(View view, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1086261486")) {
                    ipChange.ipc$dispatch("-1086261486", new Object[]{this, view, Boolean.valueOf(z)});
                } else if (z) {
                    ((ILog) Dsl.getService(ILog.class)).d("baseInputDialog", "Has focus ");
                } else {
                    ((ILog) Dsl.getService(ILog.class)).d("baseInputDialog", "lose focus");
                }
            }
        });
        this.mInputLayout.postDelayed(new Runnable() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "480649837")) {
                    ipChange.ipc$dispatch("480649837", new Object[]{this});
                } else if (AILPChatInputWithKeyWordDialog.this.mInputEditText != null) {
                    AILPChatInputWithKeyWordDialog.this.mInputEditText.requestFocus();
                    AILPChatInputWithKeyWordDialog.this.mInputMethodManager.showSoftInput(AILPChatInputWithKeyWordDialog.this.mInputEditText, 0);
                }
            }
        }, 300);
        updateView();
    }

    public boolean isWeexCallClose() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1697341089")) {
            return this.weexCallClose;
        }
        return ((Boolean) ipChange.ipc$dispatch("1697341089", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798561265")) {
            ipChange.ipc$dispatch("1798561265", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(getLayoutId());
        initView();
    }

    /* access modifiers changed from: protected */
    public void onEmptyInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247640034")) {
            ipChange.ipc$dispatch("247640034", new Object[]{this});
            return;
        }
        showTextToast("请输入聊天内容");
    }

    /* access modifiers changed from: protected */
    public void onInput(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215561413")) {
            ipChange.ipc$dispatch("1215561413", new Object[]{this, charSequence});
            return;
        }
        BaseInputDialog.OnInputCompleteListener onInputCompleteListener = this.mInputListener;
        if (onInputCompleteListener != null) {
            onInputCompleteListener.onInputComplete(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    public void onOverMaxLength(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955881877")) {
            ipChange.ipc$dispatch("1955881877", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        showTextToast("聊天不能超过" + String.valueOf(i2) + "字");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343707529")) {
            ipChange.ipc$dispatch("1343707529", new Object[]{this});
            return;
        }
        super.onStart();
        setWindowAttributes();
    }

    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139638273")) {
            ipChange.ipc$dispatch("2139638273", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onWindowFocusChanged(z);
        if (!z) {
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void setSumTextView(TextView textView, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642634800")) {
            ipChange.ipc$dispatch("1642634800", new Object[]{this, textView, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (z) {
            textView.setText("-" + i + "");
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            textView.setTextColor(parseColor(this.keywordChatInputDto.limitColor, textView.getCurrentTextColor()));
            textView.setText(i + "");
        }
    }

    /* access modifiers changed from: protected */
    public void setWindowAttributes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900106461")) {
            ipChange.ipc$dispatch("-1900106461", new Object[]{this});
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(this.mContext.getWindowManager().getDefaultDisplay(), displayMetrics);
        window.setLayout(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), getWindow().getAttributes().height);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}

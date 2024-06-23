package com.youku.widget;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.taobao.android.nav.Nav;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
public class YoukuSearchView extends LinearLayout implements View.OnClickListener {
    private boolean mChangedWhenWindowFocus;
    private View mCloseArea;
    private ImageView mCloseButton;
    private long mDelay = 2000;
    private ImageView mIconButton;
    private View.OnClickListener mOnIconClickListener;
    private OnQueryChangeListener mOnQueryChangeListener;
    private OnSuggestionListener mOnSuggestionListener;
    private SearchEditText mQueryEditText;
    private String mQueryText;
    private SearchableInfo mSearchableInfo;
    private Runnable mShowImeRunnable;
    private View mSubmitArea;
    private ImageView mSubmitButton;
    private TimerTask mTask;
    private TextWatcher mTextWatcher = new TextWatcher() {
        /* class com.youku.widget.YoukuSearchView.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            if (YoukuSearchView.this.mOnQueryChangeListener != null) {
                YoukuSearchView.this.mOnQueryChangeListener.onQueryTextChange(editable.toString());
            }
            String obj = editable.toString();
            int i = 0;
            boolean z = !TextUtils.isEmpty(obj) && TextUtils.getTrimmedLength(obj) > 0;
            YoukuSearchView.this.mCloseArea.setVisibility((!z || !YoukuSearchView.this.mQueryEditText.isEnabled()) ? 8 : 0);
            YoukuSearchView.this.mSubmitButton.setVisibility(z ? 0 : 8);
            ImageView imageView = YoukuSearchView.this.mVoiceButton;
            if (z || !YoukuSearchView.this.mVoiceButtonEnabled) {
                i = 8;
            }
            imageView.setVisibility(i);
            YoukuSearchView.this.startTimer(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private Timer mTimer;
    private final Intent mVoiceAppSearchIntent;
    private ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private View.OnClickListener mVoiceClickListener;
    private final Intent mVoiceWebSearchIntent;

    /* compiled from: Taobao */
    public interface OnQueryChangeListener {
        boolean onQueryInputInvalid();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* compiled from: Taobao */
    public interface OnSuggestionListener {
        void onRequestSuggestion(String str);
    }

    /* compiled from: Taobao */
    public static class SearchEditText extends EditText {
        private YoukuSearchView mSearchView;

        public SearchEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setSearchView(YoukuSearchView youkuSearchView) {
            this.mSearchView = youkuSearchView;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 66) {
                YoukuSearchView youkuSearchView = this.mSearchView;
                youkuSearchView.onClick(youkuSearchView.mSubmitButton);
            }
            return super.onKeyDown(i, keyEvent);
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.mSearchView.clearFocus();
                        this.mSearchView.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (!isEnabled()) {
                onTouchEvent = false;
            }
            if (isFocused() && motionEvent.getAction() == 1) {
                setSelection(getText().length());
            }
            return onTouchEvent;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.mSearchView.hasFocus() && getVisibility() == 0 && isEnabled() && this.mSearchView.mChangedWhenWindowFocus) {
                this.mSearchView.setImeVisibility(true);
                this.mSearchView.setChangedWhenWindowFocus(false);
            }
        }
    }

    public YoukuSearchView(Context context) {
        super(context);
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        this.mShowImeRunnable = new Runnable() {
            /* class com.youku.widget.YoukuSearchView.AnonymousClass2 */

            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) YoukuSearchView.this.getContext().getApplicationContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    try {
                        Method method = inputMethodManager.getClass().getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                        method.setAccessible(true);
                        method.invoke(inputMethodManager, 0, null);
                    } catch (Exception unused) {
                        inputMethodManager.showSoftInput(YoukuSearchView.this, 0);
                    }
                }
            }
        };
        init();
        findView();
        initView();
        setListener();
    }

    private void cancelTimer() {
        TimerTask timerTask = this.mTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
        this.mTask = null;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private void findView() {
        this.mIconButton = (ImageView) findViewById(R$id.bt_widget_search_icon);
        this.mQueryEditText = (SearchEditText) findViewById(R$id.et_widget_search_text);
        this.mCloseButton = (ImageView) findViewById(R$id.bt_widget_search_clear);
        this.mSubmitButton = (ImageView) findViewById(R$id.bt_widget_search_go);
        this.mVoiceButton = (ImageView) findViewById(R$id.bt_widget_search_voice);
        this.mCloseArea = findViewById(R$id.ll_widget_search_clear_area);
        this.mSubmitArea = findViewById(R$id.ll_widget_search_submit_area);
    }

    private boolean hasVoiceSearch() {
        SearchableInfo searchableInfo = this.mSearchableInfo;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.mSearchableInfo.getVoiceSearchLaunchWebSearch()) {
            intent = this.mVoiceWebSearchIntent;
        } else if (this.mSearchableInfo.getVoiceSearchLaunchRecognizer()) {
            intent = this.mVoiceAppSearchIntent;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.widget_search_view, (ViewGroup) this, true);
    }

    private void initView() {
        int inputType = this.mQueryEditText.getInputType();
        if ((inputType & 15) == 1) {
            this.mQueryEditText.setRawInputType(inputType | 65536);
        }
        this.mQueryEditText.setSearchView(this);
        this.mQueryEditText.clearFocus();
    }

    private void launchQuerySearch(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str2);
        Nav.from(getContext()).withExtras(bundle).toUri("sokusdk://searchresult");
    }

    private void setListener() {
        this.mIconButton.setOnClickListener(this);
        this.mCloseButton.setOnClickListener(this);
        this.mSubmitButton.setOnClickListener(this);
        this.mVoiceButton.setOnClickListener(this);
        this.mQueryEditText.addTextChangedListener(this.mTextWatcher);
    }

    public EditText getEditText() {
        return this.mQueryEditText;
    }

    public String getQuery() {
        return this.mQueryEditText.getText().toString();
    }

    public void onClick(View view) {
        if (view.getId() == R$id.bt_widget_search_icon) {
            View.OnClickListener onClickListener = this.mOnIconClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (view.getId() == R$id.bt_widget_search_clear) {
            this.mQueryEditText.setText("");
            this.mQueryEditText.requestFocus();
            setImeVisibility(true);
        } else if (view.getId() == R$id.bt_widget_search_go) {
            String obj = this.mQueryEditText.getText().toString();
            if (obj == null || TextUtils.getTrimmedLength(obj) <= 0) {
                OnQueryChangeListener onQueryChangeListener = this.mOnQueryChangeListener;
                if (onQueryChangeListener != null) {
                    onQueryChangeListener.onQueryInputInvalid();
                    return;
                }
                return;
            }
            OnQueryChangeListener onQueryChangeListener2 = this.mOnQueryChangeListener;
            if (onQueryChangeListener2 == null || !onQueryChangeListener2.onQueryTextSubmit(obj)) {
                launchQuerySearch(0, null, obj);
                setImeVisibility(false);
            }
        } else if (view.getId() == R$id.bt_widget_search_voice) {
            View.OnClickListener onClickListener2 = this.mVoiceClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
            SearchableInfo searchableInfo = this.mSearchableInfo;
            if (searchableInfo != null) {
                try {
                    if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, this.mSearchableInfo));
                    } else if (this.mSearchableInfo.getVoiceSearchLaunchRecognizer()) {
                        getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, this.mSearchableInfo));
                    }
                } catch (ActivityNotFoundException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelTimer();
    }

    public void setChangedWhenWindowFocus(boolean z) {
        this.mChangedWhenWindowFocus = z;
    }

    public void setClickable(boolean z) {
        int i;
        boolean z2 = false;
        if (z) {
            i = 8;
        } else {
            z2 = true;
            i = 0;
        }
        this.mQueryEditText.setEnabled(z2);
        this.mCloseArea.setVisibility(i);
        this.mSubmitArea.setVisibility(i);
        super.setClickable(z);
    }

    public void setEditFocus(boolean z) {
        if (z) {
            this.mQueryEditText.requestFocus();
        } else {
            this.mQueryEditText.clearFocus();
        }
    }

    public void setHint(String str) {
        this.mQueryEditText.setHint(str);
    }

    public void setIconVisibility(int i) {
        this.mIconButton.setVisibility(i);
    }

    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.mShowImeRunnable);
            return;
        }
        removeCallbacks(this.mShowImeRunnable);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getApplicationContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        setClickable(true);
        super.setOnClickListener(onClickListener);
    }

    public void setOnIconClickListener(View.OnClickListener onClickListener) {
        this.mOnIconClickListener = onClickListener;
    }

    public void setOnQueryChangeListener(OnQueryChangeListener onQueryChangeListener) {
        this.mOnQueryChangeListener = onQueryChangeListener;
    }

    public void setOnQueryFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mQueryEditText.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setOnVoiceClickListener(View.OnClickListener onClickListener) {
        this.mVoiceClickListener = onClickListener;
    }

    public void setQuery(String str) {
        this.mQueryEditText.setText(str);
    }

    public void setRequestSuggestionDelay(long j) {
        this.mDelay = j;
    }

    public void setSearchableInfo(Activity activity) {
        SearchableInfo searchableInfo;
        try {
            searchableInfo = ((SearchManager) activity.getSystemService("search")).getSearchableInfo(activity.getComponentName());
        } catch (Exception e) {
            e.printStackTrace();
            searchableInfo = null;
        }
        setSearchableInfo(searchableInfo);
    }

    public void startTimer() {
        startTimer(this.mQueryText);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startTimer(String str) {
        long j = (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mQueryText)) ? 0 : this.mDelay;
        this.mQueryText = str;
        cancelTimer();
        this.mTimer = new Timer(true);
        AnonymousClass3 r4 = new TimerTask() {
            /* class com.youku.widget.YoukuSearchView.AnonymousClass3 */

            public void run() {
                YoukuSearchView.this.post(new Runnable() {
                    /* class com.youku.widget.YoukuSearchView.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        if (YoukuSearchView.this.mOnSuggestionListener != null && YoukuSearchView.this.mQueryText != null && TextUtils.getTrimmedLength(YoukuSearchView.this.mQueryText) > 0) {
                            YoukuSearchView.this.mOnSuggestionListener.onRequestSuggestion(YoukuSearchView.this.mQueryText);
                        }
                    }
                });
            }
        };
        this.mTask = r4;
        this.mTimer.schedule(r4, j);
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchableInfo = searchableInfo;
        boolean hasVoiceSearch = hasVoiceSearch();
        this.mVoiceButtonEnabled = hasVoiceSearch;
        if (hasVoiceSearch) {
            this.mQueryEditText.setPrivateImeOptions("nm");
        }
        this.mVoiceButton.setVisibility(this.mVoiceButtonEnabled ? 0 : 8);
    }

    public YoukuSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        this.mShowImeRunnable = new Runnable() {
            /* class com.youku.widget.YoukuSearchView.AnonymousClass2 */

            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) YoukuSearchView.this.getContext().getApplicationContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    try {
                        Method method = inputMethodManager.getClass().getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                        method.setAccessible(true);
                        method.invoke(inputMethodManager, 0, null);
                    } catch (Exception unused) {
                        inputMethodManager.showSoftInput(YoukuSearchView.this, 0);
                    }
                }
            }
        };
        init();
        findView();
        initView();
        setListener();
    }
}

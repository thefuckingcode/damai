package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellInfoBean;
import com.youku.live.dago.widgetlib.ailproom.manager.BaseInfoBean;
import com.youku.live.dago.widgetlib.ailproom.utils.DensityUtil;
import com.youku.live.dago.widgetlib.ailproom.view.ConfigurationChangedRelativeLayout;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import java.util.List;
import tb.jl1;
import tb.tp1;
import tb.vp1;

/* compiled from: Taobao */
public class AILPChatInputDialog extends BaseInputDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String YELL_TAG = "yell";
    private boolean isRotateDismiss = true;
    private List<BaseInfoBean> mExpressionList;
    private int mOrientation;
    private boolean mShowGif = false;
    private String mTopic;
    private TextView mTopicText;
    private RecyclerView mYellGridView;
    private Toast toast = null;
    private boolean weexCallClose = false;

    /* compiled from: Taobao */
    public interface OnInputCompleteListener extends BaseInputDialog.OnInputCompleteListener {
        void onTopicSend(String str);
    }

    public AILPChatInputDialog(@NonNull Context context, int i, int i2, CharSequence charSequence, CharSequence charSequence2, int i3, boolean z, boolean z2, String str, boolean z3, List<BaseInfoBean> list, BaseInputDialog.OnInputCompleteListener onInputCompleteListener) {
        super(context, i, i2, charSequence, charSequence2, onInputCompleteListener);
        this.mOrientation = i3;
        this.mHasYell = z;
        this.mShowYell = z2;
        this.mShowGif = z3;
        this.mYellIconUrl = str;
        this.mExpressionList = list;
    }

    private void addExpressionView(Activity activity, List<BaseInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939329336")) {
            ipChange.ipc$dispatch("-939329336", new Object[]{this, activity, list});
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int dip2px = DensityUtil.dip2px(activity, 1.0f);
        this.mYellGridView = new RecyclerView(getContext());
        this.mYellGridView.setLayoutManager(new GridLayoutManager(activity, 4));
        this.mYellGridView.setOverScrollMode(2);
        this.mYellGridView.setVerticalScrollBarEnabled(false);
        int i = dip2px * 15;
        int i2 = dip2px * 8;
        this.mYellGridView.setPadding(i, i2, i, i2);
        this.mYellGridView.setLayoutParams(layoutParams);
        this.mCustomPanel.addView(this.mYellGridView);
        this.mYellGridView.setTag("yell");
        YellGridlistAdapter yellGridlistAdapter = new YellGridlistAdapter(getContext(), list, (DensityUtil.getScreenWidth() - (dip2px * 30)) / 4, this.mShowGif);
        this.mYellGridView.setAdapter(yellGridlistAdapter);
        yellGridlistAdapter.setOnItemClickListener(new YellGridlistAdapter.OnYellItemClickListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter.OnYellItemClickListener
            public void onItemClick(int i, BaseInfoBean baseInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1236857010")) {
                    ipChange.ipc$dispatch("-1236857010", new Object[]{this, Integer.valueOf(i), baseInfoBean});
                } else if (baseInfoBean != null && (baseInfoBean instanceof YellInfoBean)) {
                    AILPChatInputDialog aILPChatInputDialog = AILPChatInputDialog.this;
                    aILPChatInputDialog.onInput(jl1.ARRAY_START_STR + ((YellInfoBean) baseInfoBean).tag + jl1.ARRAY_END_STR);
                }
            }
        });
    }

    private void setExpressionData(List<BaseInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072097904")) {
            ipChange.ipc$dispatch("1072097904", new Object[]{this, list});
        } else if (list != null && list.size() != 0 && list.size() > 0) {
            addExpressionView(this.mContext, list);
        }
    }

    private void showTextToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028760304")) {
            ipChange.ipc$dispatch("-1028760304", new Object[]{this, str});
            return;
        }
        Context context = getContext();
        if (context != null) {
            ToastUtil.toast(context, str);
        }
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013053803")) {
            ipChange.ipc$dispatch("1013053803", new Object[]{this});
            return;
        }
        this.weexCallClose = true;
        dismiss();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public View getCommitButton() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "909853190")) {
            return findViewById(R.id.tv_send);
        }
        return (View) ipChange.ipc$dispatch("909853190", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public FrameLayout getCustomPanel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2070880079")) {
            return (FrameLayout) findViewById(R.id.custom_panel);
        }
        return (FrameLayout) ipChange.ipc$dispatch("2070880079", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public ConfigurationChangedRelativeLayout getEditContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2074832096")) {
            return (ConfigurationChangedRelativeLayout) findViewById(R.id.group_edit_container);
        }
        return (ConfigurationChangedRelativeLayout) ipChange.ipc$dispatch("-2074832096", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public ImageView getExpressionButton() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-655770003")) {
            return (ImageView) findViewById(R.id.iv_expression);
        }
        return (ImageView) ipChange.ipc$dispatch("-655770003", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public EditText getInputEditText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1471250549")) {
            return (EditText) findViewById(R.id.et_comment_input);
        }
        return (EditText) ipChange.ipc$dispatch("-1471250549", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417681765")) {
            return ((Integer) ipChange.ipc$dispatch("-417681765", new Object[]{this})).intValue();
        } else if (this.mOrientation == 2) {
            return R.layout.dago_pgc_ailp_chat_edit_bar_fullscreen;
        } else {
            return R.layout.dago_pgc_ailp_chat_edit_bar;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public TextView getSumTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "593647540")) {
            return (TextView) findViewById(R.id.tv_comment_sum_left);
        }
        return (TextView) ipChange.ipc$dispatch("593647540", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053133778")) {
            ipChange.ipc$dispatch("2053133778", new Object[]{this});
            return;
        }
        if (this.mHasYell) {
            setExpressionData(this.mExpressionList);
            this.mEditContainer.setConfigurationListener(new ViewFlowLayout.ConfigurationListener() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout.ConfigurationListener
                public void onConfigurationChanged(Configuration configuration) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1746169064")) {
                        ipChange.ipc$dispatch("-1746169064", new Object[]{this, configuration});
                    } else if (AILPChatInputDialog.this.isRotateDismiss && AILPChatInputDialog.this.isShowing()) {
                        AILPChatInputDialog.this.close();
                        AILPChatInputDialog.this.release();
                    }
                }
            });
            this.mExpressionButton.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1591939143")) {
                        ipChange.ipc$dispatch("1591939143", new Object[]{this, view});
                    } else if (AILPChatInputDialog.this.mCustomPanel.getVisibility() == 0) {
                        AILPChatInputDialog.this.hideExpressionboard();
                        AILPChatInputDialog.this.mInputEditText.requestFocus();
                        AILPChatInputDialog aILPChatInputDialog = AILPChatInputDialog.this;
                        aILPChatInputDialog.mInputMethodManager.showSoftInput(aILPChatInputDialog.mInputEditText, 0);
                    } else {
                        AILPChatInputDialog.this.showExpressionboard();
                    }
                }
            });
        }
        if (this.mOrientation == 2) {
            this.mExpressionButton.setVisibility(8);
            if (this.mCustomPanel.getVisibility() != 8) {
                switchExpressionButton(false);
                this.mCustomPanel.setVisibility(8);
            }
        }
        TextView textView = (TextView) findViewById(R.id.chat_topic_text_btn);
        this.mTopicText = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-591737784")) {
                    ipChange.ipc$dispatch("-591737784", new Object[]{this, view});
                    return;
                }
                BaseInputDialog.OnInputCompleteListener onInputCompleteListener = AILPChatInputDialog.this.getOnInputCompleteListener();
                if (AILPChatInputDialog.this.mTopic != null && onInputCompleteListener != null && (onInputCompleteListener instanceof OnInputCompleteListener)) {
                    ((OnInputCompleteListener) onInputCompleteListener).onTopicSend(AILPChatInputDialog.this.mTopic);
                }
            }
        });
        if (!TextUtils.isEmpty(this.mTopic)) {
            this.mTopicText.setVisibility(0);
            this.mTopicText.setText(this.mTopic);
            this.mTopicText.setTag(this.mTopic);
        }
        if (!TextUtils.isEmpty(this.mYellIconUrl)) {
            vp1 s = tp1.o().s(this.mYellIconUrl);
            int i = R.drawable.dago_pgc_chat_expression_default_bg;
            s.H(i).k(i).y(this.mExpressionButton);
        } else if (this.mOrientation == 2) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_landscape_icon);
        } else {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_portrait_icon);
        }
    }

    public boolean isWeexCallClose() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-56557480")) {
            return this.weexCallClose;
        }
        return ((Boolean) ipChange.ipc$dispatch("-56557480", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void onEmptyInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639352437")) {
            ipChange.ipc$dispatch("-639352437", new Object[]{this});
            return;
        }
        showTextToast("请输入聊天内容");
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void onInput(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738897284")) {
            ipChange.ipc$dispatch("-738897284", new Object[]{this, charSequence});
            return;
        }
        BaseInputDialog.OnInputCompleteListener onInputCompleteListener = getOnInputCompleteListener();
        if (onInputCompleteListener != null) {
            onInputCompleteListener.onInputComplete(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void onOverMaxLength(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86537100")) {
            ipChange.ipc$dispatch("86537100", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        showTextToast("聊天不能超过" + String.valueOf(i2) + "字");
    }

    public void refreshYellData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436702734")) {
            ipChange.ipc$dispatch("-1436702734", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mYellGridView;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            this.mYellGridView.getAdapter().notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815448708")) {
            ipChange.ipc$dispatch("-815448708", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mCustomPanel;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void setCommitButtonStatus(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58178072")) {
            ipChange.ipc$dispatch("-58178072", new Object[]{this, view, Boolean.valueOf(z)});
        } else if (z) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(-1);
            }
            view.setBackground(getContext().getResources().getDrawable(R.drawable.dago_pgc_ailp_chat_fullscreen_btn_background));
        } else {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(-4473925);
            }
            view.setBackground(getContext().getResources().getDrawable(R.drawable.dago_pgc_ailp_chat_edit_small_send_btn_background));
        }
    }

    public void setRotateDismiss(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331125978")) {
            ipChange.ipc$dispatch("331125978", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isRotateDismiss = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void setSumTextView(TextView textView, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711329497")) {
            ipChange.ipc$dispatch("-711329497", new Object[]{this, textView, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (z) {
            textView.setText("-" + i + "");
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            if (this.mOrientation == 2) {
                textView.setTextColor(-1);
            } else {
                textView.setTextColor(-5131855);
            }
            textView.setText(i + "");
        }
    }

    public void setTopic(String str) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099672580")) {
            ipChange.ipc$dispatch("1099672580", new Object[]{this, str});
            return;
        }
        this.mTopic = str;
        if (!TextUtils.isEmpty(str) && (textView = this.mTopicText) != null) {
            textView.setVisibility(0);
            this.mTopicText.setText(this.mTopic);
            this.mTopicText.setTag(this.mTopic);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    public void switchExpressionButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361059243")) {
            ipChange.ipc$dispatch("1361059243", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_keyboard_icon);
        } else if (!TextUtils.isEmpty(this.mYellIconUrl)) {
            vp1 s = tp1.o().s(this.mYellIconUrl);
            int i = R.drawable.dago_pgc_chat_expression_default_bg;
            s.H(i).k(i).y(this.mExpressionButton);
        } else if (this.mOrientation == 2) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_landscape_icon);
        } else {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_portrait_icon);
        }
    }
}

package com.alibaba.poplayerconsole.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.poplayer.trigger.view.c;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.fu2;
import tb.jl1;

/* compiled from: Taobao */
public class PopLayerToolsView extends ScrollView implements View.OnClickListener, ILogView {
    private boolean mIsTrackMode;
    private c mSelector = new c();
    private Button mTrackBtn;
    private TextView mTrackResult;

    /* compiled from: Taobao */
    private class b implements View.OnTouchListener {
        private View[] a;
        private final Drawable b;

        /* compiled from: Taobao */
        class a extends ClickableSpan {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public void onClick(View view) {
                PopLayerToolsView.this.copyToClipboard(this.a);
                Toast.makeText(PopLayerToolsView.this.getContext().getApplicationContext(), "Copy to clipboard success.", 0).show();
            }
        }

        private b() {
            this.b = new ColorDrawable(-2013265920);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        @TargetApi(16)
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            int i = 0;
            if (action == 0) {
                PopLayerToolsView.this.updateButton();
                this.a = PopLayerToolsView.this.mSelector.k(rawX, rawY);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) "Find ");
                append.append((CharSequence) ("" + this.a.length)).append((CharSequence) " selector: \n");
                View[] viewArr = this.a;
                int length = viewArr.length;
                while (i < length) {
                    View view2 = viewArr[i];
                    view2.setTag(R$id.poplayer_console_register_background_tag_id, view2.getBackground());
                    view2.setBackground(this.b);
                    String hierarchy = PopLayerToolsView.this.getHierarchy(view2, 3);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) hierarchy);
                    spannableStringBuilder.setSpan(new a(hierarchy), length2, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append((CharSequence) "\n\n");
                    i++;
                }
                PopLayerToolsView.this.mTrackResult.setMovementMethod(LinkMovementMethod.getInstance());
                PopLayerToolsView.this.mTrackResult.setText(spannableStringBuilder);
                return true;
            } else if (action != 1 && action != 3) {
                return true;
            } else {
                View[] viewArr2 = this.a;
                int length3 = viewArr2.length;
                while (i < length3) {
                    View view3 = viewArr2[i];
                    view3.setBackground((Drawable) view3.getTag(R$id.poplayer_console_register_background_tag_id));
                    i++;
                }
                this.a = null;
                return true;
            }
        }
    }

    public PopLayerToolsView(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.console_tools, (ViewGroup) this, true);
        this.mTrackBtn = (Button) findViewById(R$id.track_pick_btn);
        this.mTrackResult = (TextView) findViewById(R$id.track_result);
        this.mTrackBtn.setOnClickListener(this);
        this.mTrackResult.setOnClickListener(this);
        updateButton();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void copyToClipboard(String str) {
        ((ClipboardManager) getContext().getApplicationContext().getSystemService("clipboard")).setText(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getHierarchy(View view, int i) {
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(view);
        int i2 = 0;
        while (true) {
            if (i > 0 && i2 >= i) {
                break;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
            arrayList.add(view);
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        for (View view2 : arrayList) {
            sb.insert(0, getViewProps(view2)).insert(0, jl1.G);
        }
        if (sb.length() >= 1) {
            return sb.substring(1, sb.length());
        }
        return sb.toString();
    }

    private String getViewProps(View view) {
        String str;
        if (view == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.getClass().getName());
        CharSequence contentDescription = view.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            sb.append("[contentDescription=");
            sb.append(contentDescription.toString());
            sb.append(jl1.ARRAY_END_STR);
        }
        Object tag = view.getTag();
        if (tag != null) {
            sb.append("[tag=");
            sb.append(tag.toString());
            sb.append(jl1.ARRAY_END_STR);
        }
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                sb.append("[text=");
                sb.append(text.toString());
                sb.append(jl1.ARRAY_END_STR);
            }
        }
        int id = view.getId();
        if (-1 != id && id == 0) {
            Resources resources = view.getResources();
            int i = -16777216 & id;
            if (i == 16777216) {
                str = "android";
            } else if (i != 2130706432) {
                try {
                    str = resources.getResourcePackageName(id);
                } catch (Resources.NotFoundException unused) {
                }
            } else {
                str = "app";
            }
            String resourceTypeName = resources.getResourceTypeName(id);
            String resourceEntryName = resources.getResourceEntryName(id);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":");
            sb2.append(resourceTypeName);
            sb2.append("/");
            sb2.append(resourceEntryName);
            sb.append("[id=");
            sb.append(sb2.toString());
            sb.append(jl1.ARRAY_END_STR);
            return sb2.toString();
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateButton() {
        Button button = this.mTrackBtn;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mIsTrackMode ? "Stop" : "Start");
        sb.append(" Track Mode");
        button.setText(sb.toString());
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "Tools";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    public void onClick(View view) {
        if (view.getId() == R$id.track_pick_btn) {
            try {
                this.mIsTrackMode = !this.mIsTrackMode;
                updateButton();
                Activity activity = (Activity) fu2.a((WeakReference) com.alibaba.poplayerconsole.a.d().get("page").b);
                if (activity == null) {
                    Toast.makeText(getContext().getApplicationContext(), "Current Activity is null", 0).show();
                    return;
                }
                Window window = activity.getWindow();
                int i = R$id.poplayer_console_selector_touch_interceptor_id;
                View findViewById = window.findViewById(i);
                if (findViewById != null) {
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    return;
                }
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setBackgroundColor(1157562368);
                frameLayout.setId(i);
                activity.getWindow().addContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setOnTouchListener(new b());
            } catch (Exception e) {
                Log.e("PopLayer", "Toggle_view_tracker.error", e);
            }
        }
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(com.alibaba.poplayerconsole.lib.Window window) throws Throwable {
    }
}

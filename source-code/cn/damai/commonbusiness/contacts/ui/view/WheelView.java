package cn.damai.commonbusiness.contacts.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WheelView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int OFF_SET_DEFAULT = 1;
    private static final int SCROLL_DIRECTION_DOWN = 1;
    private static final int SCROLL_DIRECTION_UP = 0;
    public static final String TAG = WheelView.class.getSimpleName();
    int displayItemCount;
    int initialY;
    int itemHeight = 0;
    List<String> items;
    int newCheck = 50;
    int offset = 1;
    private b onWheelViewListener;
    Paint paint;
    private int scrollDirection = -1;
    Runnable scrollerTask;
    int[] selectedAreaBorder;
    int selectedIndex = 1;
    int viewWidth;
    private LinearLayout views;

    /* compiled from: Taobao */
    public class a extends Drawable {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void draw(Canvas canvas) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "238590280")) {
                ipChange.ipc$dispatch("238590280", new Object[]{this, canvas});
                return;
            }
            float f = (float) WheelView.this.obtainSelectedAreaBorder()[0];
            WheelView wheelView = WheelView.this;
            canvas.drawLine(0.0f, f, (float) wheelView.viewWidth, (float) wheelView.obtainSelectedAreaBorder()[0], WheelView.this.paint);
            float f2 = (float) WheelView.this.obtainSelectedAreaBorder()[1];
            WheelView wheelView2 = WheelView.this;
            canvas.drawLine(0.0f, f2, (float) wheelView2.viewWidth, (float) wheelView2.obtainSelectedAreaBorder()[1], WheelView.this.paint);
        }

        public int getOpacity() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "221243775")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("221243775", new Object[]{this})).intValue();
        }

        public void setAlpha(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-608843074")) {
                ipChange.ipc$dispatch("-608843074", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public void setColorFilter(ColorFilter colorFilter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-269083072")) {
                ipChange.ipc$dispatch("-269083072", new Object[]{this, colorFilter});
            }
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;

        public void a(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "334721699")) {
                ipChange.ipc$dispatch("334721699", new Object[]{this, Integer.valueOf(i), str});
            }
        }
    }

    public WheelView(Context context) {
        super(context);
        init(context);
    }

    private TextView createView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850657744")) {
            return (TextView) ipChange.ipc$dispatch("1850657744", new Object[]{this, str});
        }
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(1, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.setBackgroundColor(-1);
        int dip2px = dip2px(15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        if (this.itemHeight == 0) {
            this.itemHeight = getViewMeasuredHeight(textView);
            this.views.setLayoutParams(new FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.itemHeight * this.displayItemCount));
        }
        return textView;
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-569411217")) {
            return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-569411217", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    private List<String> getItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1594760578")) {
            return this.items;
        }
        return (List) ipChange.ipc$dispatch("-1594760578", new Object[]{this});
    }

    private int getViewMeasuredHeight(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834882506")) {
            return ((Integer) ipChange.ipc$dispatch("-834882506", new Object[]{this, view})).intValue();
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819354693")) {
            ipChange.ipc$dispatch("1819354693", new Object[]{this, context});
            return;
        }
        String str = TAG;
        Log.d(str, "parent: " + getParent());
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.views = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.views);
        this.scrollerTask = new Runnable() {
            /* class cn.damai.commonbusiness.contacts.ui.view.WheelView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1296320351")) {
                    ipChange.ipc$dispatch("1296320351", new Object[]{this});
                    return;
                }
                int scrollY = WheelView.this.getScrollY();
                WheelView wheelView = WheelView.this;
                int i = wheelView.initialY;
                if (i - scrollY == 0) {
                    int i2 = wheelView.itemHeight;
                    final int i3 = i % i2;
                    final int i4 = i / i2;
                    if (i3 == 0) {
                        wheelView.selectedIndex = i4 + wheelView.offset;
                        wheelView.onSeletedCallBack();
                    } else if (i3 > i2 / 2) {
                        wheelView.post(new Runnable() {
                            /* class cn.damai.commonbusiness.contacts.ui.view.WheelView.AnonymousClass1.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1864608562")) {
                                    ipChange.ipc$dispatch("1864608562", new Object[]{this});
                                    return;
                                }
                                WheelView wheelView = WheelView.this;
                                wheelView.smoothScrollTo(0, (wheelView.initialY - i3) + wheelView.itemHeight);
                                WheelView wheelView2 = WheelView.this;
                                wheelView2.selectedIndex = i4 + wheelView2.offset + 1;
                                wheelView2.onSeletedCallBack();
                            }
                        });
                    } else {
                        wheelView.post(new Runnable() {
                            /* class cn.damai.commonbusiness.contacts.ui.view.WheelView.AnonymousClass1.AnonymousClass2 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1668095057")) {
                                    ipChange.ipc$dispatch("1668095057", new Object[]{this});
                                    return;
                                }
                                WheelView wheelView = WheelView.this;
                                wheelView.smoothScrollTo(0, wheelView.initialY - i3);
                                WheelView wheelView2 = WheelView.this;
                                wheelView2.selectedIndex = i4 + wheelView2.offset;
                                wheelView2.onSeletedCallBack();
                            }
                        });
                    }
                } else {
                    wheelView.initialY = wheelView.getScrollY();
                    WheelView wheelView2 = WheelView.this;
                    wheelView2.postDelayed(wheelView2.scrollerTask, (long) wheelView2.newCheck);
                }
            }
        };
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291406809")) {
            ipChange.ipc$dispatch("291406809", new Object[]{this});
            return;
        }
        this.displayItemCount = (this.offset * 2) + 1;
        for (String str : this.items) {
            this.views.addView(createView(str));
        }
        refreshItemView(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int[] obtainSelectedAreaBorder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453429910")) {
            return (int[]) ipChange.ipc$dispatch("-453429910", new Object[]{this});
        }
        if (this.selectedAreaBorder == null) {
            int[] iArr = new int[2];
            this.selectedAreaBorder = iArr;
            int i = this.itemHeight;
            int i2 = this.offset;
            iArr[0] = i * i2;
            iArr[1] = i * (i2 + 1);
        }
        return this.selectedAreaBorder;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onSeletedCallBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988100759")) {
            ipChange.ipc$dispatch("-1988100759", new Object[]{this});
            return;
        }
        b bVar = this.onWheelViewListener;
        if (bVar != null) {
            int i = this.selectedIndex;
            bVar.a(i, this.items.get(i));
        }
    }

    private void refreshItemView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984847745")) {
            ipChange.ipc$dispatch("-984847745", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.itemHeight;
        int i3 = this.offset;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.views.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.views.getChildAt(i7);
            if (textView != null) {
                if (i4 == i7) {
                    textView.setTextColor(Color.parseColor("#222222"));
                } else {
                    textView.setTextColor(Color.parseColor("#999999"));
                }
            } else {
                return;
            }
        }
    }

    public void fling(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523227784")) {
            ipChange.ipc$dispatch("1523227784", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.fling(i / 3);
    }

    public int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1286251647")) {
            return this.offset;
        }
        return ((Integer) ipChange.ipc$dispatch("-1286251647", new Object[]{this})).intValue();
    }

    public b getOnWheelViewListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1129140990")) {
            return this.onWheelViewListener;
        }
        return (b) ipChange.ipc$dispatch("-1129140990", new Object[]{this});
    }

    public int getSeletedIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-896661782")) {
            return this.selectedIndex - this.offset;
        }
        return ((Integer) ipChange.ipc$dispatch("-896661782", new Object[]{this})).intValue();
    }

    public String getSeletedItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1895580942")) {
            return this.items.get(this.selectedIndex);
        }
        return (String) ipChange.ipc$dispatch("-1895580942", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944238353")) {
            ipChange.ipc$dispatch("-1944238353", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i2);
        if (i2 > i4) {
            this.scrollDirection = 1;
        } else {
            this.scrollDirection = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138525341")) {
            ipChange.ipc$dispatch("-2138525341", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        setBackgroundDrawable(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647578958")) {
            return ((Boolean) ipChange.ipc$dispatch("-1647578958", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689846611")) {
            ipChange.ipc$dispatch("-1689846611", new Object[]{this, drawable});
            return;
        }
        if (this.viewWidth == 0) {
            this.viewWidth = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getWidth();
        }
        if (this.paint == null) {
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setColor(Color.parseColor("#f2f3f4"));
            this.paint.setStrokeWidth((float) dip2px(0.5f));
        }
        super.setBackgroundDrawable(new a());
    }

    public void setItems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131157158")) {
            ipChange.ipc$dispatch("131157158", new Object[]{this, list});
            return;
        }
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.items.clear();
        this.items.addAll(list);
        for (int i = 0; i < this.offset; i++) {
            this.items.add(0, "");
            this.items.add("");
        }
        initData();
    }

    public void setOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444934335")) {
            ipChange.ipc$dispatch("-444934335", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.offset = i;
    }

    public void setOnWheelViewListener(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889936224")) {
            ipChange.ipc$dispatch("1889936224", new Object[]{this, bVar});
            return;
        }
        this.onWheelViewListener = bVar;
    }

    public void setSeletion(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444829299")) {
            ipChange.ipc$dispatch("-444829299", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectedIndex = this.offset + i;
        post(new Runnable() {
            /* class cn.damai.commonbusiness.contacts.ui.view.WheelView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "903293341")) {
                    ipChange.ipc$dispatch("903293341", new Object[]{this});
                    return;
                }
                WheelView wheelView = WheelView.this;
                wheelView.smoothScrollTo(0, i * wheelView.itemHeight);
            }
        });
    }

    public void startScrollerTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905454006")) {
            ipChange.ipc$dispatch("1905454006", new Object[]{this});
            return;
        }
        this.initialY = getScrollY();
        postDelayed(this.scrollerTask, (long) this.newCheck);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}

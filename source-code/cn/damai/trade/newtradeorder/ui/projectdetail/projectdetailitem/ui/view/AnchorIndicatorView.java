package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.a5;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class AnchorIndicatorView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<a5> mAnchorList;
    private Context mContext;
    private OnAnchorItemClickListener mOnAnchorItemClickListener;
    private Paint mPaint = new Paint();
    private int mSelectedFontColor;
    private int mSelectedFontSize = 20;
    private int mUnSelectedFontColor;
    private int mUnSelectedFontSize = 16;
    private int paddingBottomBig;
    private int paddingBottomSmall;

    /* compiled from: Taobao */
    public interface OnAnchorItemClickListener {
        void onAnchorItemClick(int i, a5 a5Var);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ a5 a;

        a(a5 a5Var) {
            this.a = a5Var;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1119220028")) {
                ipChange.ipc$dispatch("-1119220028", new Object[]{this, view});
            } else if (AnchorIndicatorView.this.mOnAnchorItemClickListener != null) {
                AnchorIndicatorView.this.mOnAnchorItemClickListener.onAnchorItemClick(this.a.b(), this.a);
            }
        }
    }

    public AnchorIndicatorView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142053009")) {
            ipChange.ipc$dispatch("-142053009", new Object[]{this});
            return;
        }
        removeAllViews();
        int e = xf2.e(this.mAnchorList);
        for (int i = 0; i < e; i++) {
            a5 a5Var = this.mAnchorList.get(i);
            if (a5Var != null) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.anchor_indicator_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                textView.setText(a5Var.a());
                textView.setTextColor(this.mUnSelectedFontColor);
                textView.setTextSize(1, (float) this.mUnSelectedFontSize);
                inflate.setOnClickListener(new a(a5Var));
                addView(inflate);
            }
        }
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2030885828")) {
            return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-2030885828", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241366993")) {
            ipChange.ipc$dispatch("1241366993", new Object[]{this});
            return;
        }
        this.paddingBottomBig = v50.a(this.mContext, 3.0f);
        this.paddingBottomSmall = v50.a(this.mContext, 6.0f);
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(80);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
    }

    public AnchorIndicatorView setAnchorFonSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387865759")) {
            return (AnchorIndicatorView) ipChange.ipc$dispatch("387865759", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontSize = i;
        this.mUnSelectedFontSize = i2;
        return this;
    }

    public AnchorIndicatorView setAnchorFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894782863")) {
            return (AnchorIndicatorView) ipChange.ipc$dispatch("-894782863", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public AnchorIndicatorView setAnchorList(List<a5> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-749544344")) {
            return (AnchorIndicatorView) ipChange.ipc$dispatch("-749544344", new Object[]{this, list});
        }
        this.mAnchorList = list;
        commit();
        setPadding(dip2px(9.0f), 0, dip2px(9.0f), 0);
        return this;
    }

    public AnchorIndicatorView setOnAnchorItemClickListener(OnAnchorItemClickListener onAnchorItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686110468")) {
            return (AnchorIndicatorView) ipChange.ipc$dispatch("-1686110468", new Object[]{this, onAnchorItemClickListener});
        }
        this.mOnAnchorItemClickListener = onAnchorItemClickListener;
        return this;
    }

    public void setSelectAnchor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508098990")) {
            ipChange.ipc$dispatch("-508098990", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int e = xf2.e(this.mAnchorList);
        if (e != 0) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                LinearLayout linearLayout = (LinearLayout) getChildAt(i2);
                TextView textView = (TextView) linearLayout.findViewById(R$id.tv_name);
                ImageView imageView = (ImageView) linearLayout.findViewById(R$id.iv_line);
                if (i == i2) {
                    textView.setTextColor(this.mSelectedFontColor);
                    textView.setTextSize(1, (float) this.mSelectedFontSize);
                    textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), this.paddingBottomBig);
                    if (e != 1) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                } else {
                    textView.setTextColor(this.mUnSelectedFontColor);
                    textView.setTextSize(1, (float) this.mUnSelectedFontSize);
                    textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), this.paddingBottomSmall);
                    imageView.setVisibility(4);
                }
            }
        }
    }

    public AnchorIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}

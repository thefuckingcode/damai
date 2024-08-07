package cn.damai.commonbusiness.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.cq;
import tb.v50;

/* compiled from: Taobao */
public class UserAvatarOverlayListLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATION_DURATION = 1000;
    static boolean isNeedDeleteLast;
    private int MAX_AVATAR_COUNT = 5;
    private int imageSize = -1;
    private List<String> mAllUris = new ArrayList();
    private List<View> mAllViews = new ArrayList();
    private int mAnimXOffset = 0;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mImageOffset = 0.3f;
    private boolean mIsReverse = false;

    /* compiled from: Taobao */
    public interface UserAvatarOverlayListListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ View b;

        a(ImageView imageView, View view) {
            this.a = imageView;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-800455699")) {
                ipChange.ipc$dispatch("-800455699", new Object[]{this, valueAnimator});
                return;
            }
            UserAvatarOverlayListLayout.this.mAnimXOffset = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
            this.a.setAlpha(currentPlayTime);
            if (UserAvatarOverlayListLayout.isNeedDeleteLast && (view = this.b) != null) {
                view.setAlpha(1.0f - currentPlayTime);
            }
            UserAvatarOverlayListLayout.this.requestLayout();
        }
    }

    /* compiled from: Taobao */
    public class b extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "744080669")) {
                ipChange.ipc$dispatch("744080669", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            UserAvatarOverlayListLayout.this.mAnimXOffset = 0;
            int childCount = UserAvatarOverlayListLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                UserAvatarOverlayListLayout.this.getChildAt(i).setAlpha(1.0f);
            }
            if (UserAvatarOverlayListLayout.isNeedDeleteLast) {
                UserAvatarOverlayListLayout.this.removeViewAt(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "652549942")) {
                ipChange.ipc$dispatch("652549942", new Object[]{this, animator});
                return;
            }
            super.onAnimationStart(animator);
        }
    }

    /* compiled from: Taobao */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460461551")) {
                ipChange.ipc$dispatch("460461551", new Object[]{this, valueAnimator});
                return;
            }
            UserAvatarOverlayListLayout.this.mAnimXOffset = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.setAlpha(1.0f - (((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration())));
            UserAvatarOverlayListLayout.this.requestLayout();
        }
    }

    /* compiled from: Taobao */
    public class d extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "728561951")) {
                ipChange.ipc$dispatch("728561951", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            UserAvatarOverlayListLayout.this.mAnimXOffset = 0;
            int childCount = UserAvatarOverlayListLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                UserAvatarOverlayListLayout.this.getChildAt(i).setAlpha(1.0f);
            }
            UserAvatarOverlayListLayout.this.removeViewAt(this.a - 1);
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1376036168")) {
                ipChange.ipc$dispatch("-1376036168", new Object[]{this, animator});
                return;
            }
            super.onAnimationStart(animator);
        }
    }

    public UserAvatarOverlayListLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    private void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290157671")) {
            ipChange.ipc$dispatch("290157671", new Object[]{this});
            return;
        }
        removeAllViews();
        int i = 0;
        while (i < this.mAllUris.size() && i < this.MAX_AVATAR_COUNT) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.user_avatar_overlay_list_item, (ViewGroup) this, false);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.circle_user_head_icon);
            if (this.imageSize > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i2 = this.imageSize;
                layoutParams.height = i2;
                layoutParams.width = i2;
                inflate.getLayoutParams().height = this.imageSize + v50.a(this.mContext, 2.0f);
                inflate.getLayoutParams().width = this.imageSize + v50.a(this.mContext, 2.0f);
            }
            DMImageCreator c2 = cn.damai.common.image.a.b().h(this.mContext).c(this.mAllUris.get(i));
            int i3 = R$drawable.uikit_user_default_icon;
            c2.i(i3).c(i3).k(new cq()).g(imageView);
            addView(inflate);
            i++;
        }
    }

    public void append(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057196312")) {
            ipChange.ipc$dispatch("1057196312", new Object[]{this, str});
            return;
        }
        this.mAllUris.add(str);
        refresh();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-919656744")) {
            return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-919656744", new Object[]{this, attributeSet});
    }

    public void initData(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649164993")) {
            ipChange.ipc$dispatch("-1649164993", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            this.mAllUris = list;
            refresh();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541941227")) {
            ipChange.ipc$dispatch("-1541941227", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.mAllViews.clear();
        getWidth();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.getMeasuredWidth();
            int i7 = ((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).leftMargin;
            this.mAllViews.add(childAt);
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        Collections.reverse(this.mAllViews);
        if (this.mIsReverse) {
            Collections.reverse(this.mAllViews);
        }
        for (int i8 = 0; i8 < this.mAllViews.size(); i8++) {
            View view = this.mAllViews.get(i8);
            if (view.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (i8 == 0) {
                    i5 = marginLayoutParams.leftMargin;
                } else {
                    i5 = marginLayoutParams.leftMargin;
                }
                int i9 = i5 + paddingLeft;
                int i10 = marginLayoutParams.topMargin + paddingTop;
                view.layout(i9, i10, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + i10);
                paddingLeft = (int) (((float) paddingLeft) + (((float) ((view.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin)) - (this.mImageOffset * ((float) view.getWidth()))));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1828455075")) {
            ipChange.ipc$dispatch("1828455075", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i8 = i4 + measuredWidth;
            if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                i7 += i6;
                i5 = Math.max(i5, i4);
                i6 = measuredHeight;
                i4 = measuredWidth;
            } else {
                i6 = Math.max(i6, measuredHeight);
                i4 = i8;
            }
            if (i3 == childCount - 1) {
                i7 += i6;
                i5 = Math.max(i4, i5);
            }
            i3++;
            size2 = size2;
        }
        if (mode != 1073741824) {
            size = i5;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? size2 : i7);
    }

    public void remove(String str, UserAvatarOverlayListListener userAvatarOverlayListListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597668016")) {
            ipChange.ipc$dispatch("1597668016", new Object[]{this, str, userAvatarOverlayListListener});
        } else if (!TextUtils.isEmpty(str) && this.mAllUris.contains(str)) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            int measuredWidth = childAt.getMeasuredWidth();
            this.mAllUris.remove(str);
            ValueAnimator ofInt = ValueAnimator.ofInt((int) (((float) measuredWidth) * this.mImageOffset), 0);
            this.mAnimator = ofInt;
            ofInt.setDuration(1000L);
            this.mAnimator.addUpdateListener(new c(childAt));
            this.mAnimator.addListener(new d(childCount));
            this.mAnimator.start();
        }
    }

    public void setImageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150569173")) {
            ipChange.ipc$dispatch("1150569173", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.imageSize = i;
    }

    public void setMaxAvatarCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859071851")) {
            ipChange.ipc$dispatch("-1859071851", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.MAX_AVATAR_COUNT = i;
    }

    public void setReverse(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603991732")) {
            ipChange.ipc$dispatch("-603991732", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsReverse = z;
    }

    public void setSpWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198570366")) {
            ipChange.ipc$dispatch("-1198570366", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void append(String str, UserAvatarOverlayListListener userAvatarOverlayListListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193785894")) {
            ipChange.ipc$dispatch("-193785894", new Object[]{this, str, userAvatarOverlayListListener});
        } else if (!TextUtils.isEmpty(str)) {
            this.mAllUris.add(str);
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (getChildCount() >= this.MAX_AVATAR_COUNT) {
                isNeedDeleteLast = true;
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.user_avatar_overlay_list_item, (ViewGroup) this, false);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.circle_user_head_icon);
            if (this.imageSize > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i = this.imageSize;
                layoutParams.height = i;
                layoutParams.width = i;
                inflate.getLayoutParams().height = this.imageSize + v50.a(this.mContext, 2.0f);
                inflate.getLayoutParams().width = this.imageSize + v50.a(this.mContext, 2.0f);
            }
            DMImageCreator c2 = cn.damai.common.image.a.b().h(this.mContext).c(str);
            int i2 = R$drawable.uikit_user_default_icon;
            c2.i(i2).c(i2).k(new cq()).g(imageView);
            addView(inflate);
            View childAt = getChildAt(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) (((float) childAt.getMeasuredWidth()) * (1.0f - this.mImageOffset)));
            this.mAnimator = ofInt;
            ofInt.setDuration(1000L);
            this.mAnimator.addUpdateListener(new a(imageView, childAt));
            this.mAnimator.addListener(new b());
            this.mAnimator.start();
        }
    }

    public UserAvatarOverlayListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480265710")) {
            ipChange.ipc$dispatch("480265710", new Object[]{this, str});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mAllUris.remove(str);
        refresh();
    }

    public UserAvatarOverlayListLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }
}

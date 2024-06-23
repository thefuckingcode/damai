package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailproom.favor.FavorLayout;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;
import tb.qg0;
import tb.tp1;
import tb.ug2;

/* compiled from: Taobao */
public class DagoLikeView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoLikeView";
    private BitmapDrawable mAvatar;
    private FavorLayout mFavorLayout;
    private int mLikeTotalCount = 0;

    public DagoLikeView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373207795")) {
            ipChange.ipc$dispatch("373207795", new Object[]{this, context});
            return;
        }
        FavorLayout favorLayout = new FavorLayout(context);
        this.mFavorLayout = favorLayout;
        addView(favorLayout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<Drawable> split(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640222068")) {
            return (List) ipChange.ipc$dispatch("-1640222068", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width / i;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new BitmapDrawable(Bitmap.createBitmap(bitmap, i3 * i, 0, i, height)));
        }
        return arrayList;
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326532006")) {
            ipChange.ipc$dispatch("326532006", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        FavorLayout favorLayout = this.mFavorLayout;
        if (favorLayout != null) {
            favorLayout.destroy();
            this.mFavorLayout = null;
        }
    }

    public void setAvatar(String str) {
        FavorLayout favorLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649774959")) {
            ipChange.ipc$dispatch("649774959", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setAvatar: " + str);
        if (TextUtils.isEmpty(str)) {
            FavorLayout favorLayout2 = this.mFavorLayout;
            if (favorLayout2 != null) {
                favorLayout2.setAvatar(null);
                return;
            }
            return;
        }
        BitmapDrawable bitmapDrawable = this.mAvatar;
        if (!(bitmapDrawable == null || (favorLayout = this.mFavorLayout) == null)) {
            favorLayout.setAvatar(bitmapDrawable);
        }
        DagoImageLoader.getInstance().loadCircle(getContext(), str, new ImageLoadListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1803880124")) {
                    ipChange.ipc$dispatch("1803880124", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1255301630")) {
                    ipChange.ipc$dispatch("-1255301630", new Object[]{this, bitmapDrawable});
                } else if (bitmapDrawable != null) {
                    DagoLikeView.this.mAvatar = bitmapDrawable;
                    ((ILog) Dsl.getService(ILog.class)).i(DagoLikeView.TAG, "mDrawables: " + bitmapDrawable);
                    if (DagoLikeView.this.mFavorLayout != null) {
                        DagoLikeView.this.mFavorLayout.setAvatar(DagoLikeView.this.mAvatar);
                    }
                }
            }
        });
    }

    public void setFlow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1056132653")) {
            ipChange.ipc$dispatch("-1056132653", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFlow: " + i);
        int i2 = this.mLikeTotalCount;
        if (i > i2) {
            this.mLikeTotalCount = i;
            this.mFavorLayout.addFavor(i - i2);
            return;
        }
        this.mLikeTotalCount = i;
    }

    public void setLikeViewSrc(String str, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1351753035")) {
            ipChange.ipc$dispatch("-1351753035", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        tp1.o().s(str).Q(new IPhenixListener<ug2>() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onHappen(ug2 ug2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "371212675")) {
                    return ((Boolean) ipChange.ipc$dispatch("371212675", new Object[]{this, ug2})).booleanValue();
                }
                if (ug2.f() != null && !ug2.i()) {
                    List<Drawable> split = DagoLikeView.this.split(ug2.f().getBitmap(), i);
                    if (!split.isEmpty()) {
                        ((ILog) Dsl.getService(ILog.class)).i(DagoLikeView.TAG, "mDrawables: " + split);
                        if (DagoLikeView.this.mFavorLayout != null) {
                            DagoLikeView.this.mFavorLayout.setDrawables(split);
                        }
                    }
                }
                return true;
            }
        }).m(new IPhenixListener<qg0>() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onHappen(qg0 qg0) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-2061583138")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("-2061583138", new Object[]{this, qg0})).booleanValue();
            }
        }).n();
    }

    public DagoLikeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public DagoLikeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}

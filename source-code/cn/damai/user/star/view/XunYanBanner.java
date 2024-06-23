package cn.damai.user.star.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.BannerScroller;
import cn.damai.user.star.bean.Banner;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import tb.zd2;

/* compiled from: Taobao */
public class XunYanBanner extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FLIP_INTERVAL = 3000;
    private static final int FLIP_SIZE = 1000;
    private String bizId;
    private int bizType;
    private boolean isAttachedToWindow;
    private boolean isFlipping;
    private boolean isSelf;
    private BannerAdapter mAdapter;
    private OnBannerClickListener mClickListener;
    private Runnable mFlipRunnable;
    private WeakReference<OnBannerPageChangedListener> mListenerWeal;

    /* compiled from: Taobao */
    public class BannerAdapter extends PagerAdapter implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private List<Banner> b;
        private Pools.SimplePool<View> c = new Pools.SimplePool<>(4);
        private int d = -1;

        /* compiled from: Taobao */
        public class a implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            a(BannerAdapter bannerAdapter, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1710739697")) {
                    ipChange.ipc$dispatch("-1710739697", new Object[]{this, eVar});
                    return;
                }
                this.a.setImageDrawable(eVar.a);
            }
        }

        /* compiled from: Taobao */
        public class b implements DMImageCreator.DMImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            b(BannerAdapter bannerAdapter, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1480696316")) {
                    ipChange.ipc$dispatch("1480696316", new Object[]{this, dVar});
                    return;
                }
                this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }

        public BannerAdapter(Context context) {
            this.a = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-715112530")) {
                ipChange.ipc$dispatch("-715112530", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            View view = (View) obj;
            viewGroup.removeView(view);
            this.c.release(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "429848901")) {
                return ((Integer) ipChange.ipc$dispatch("429848901", new Object[]{this})).intValue();
            }
            List<Banner> list = this.b;
            if (list == null || list.size() == 0) {
                return 0;
            }
            if (this.b.size() == 1) {
                return 1;
            }
            return 1000;
        }

        public int getRealCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2060799229")) {
                return ((Integer) ipChange.ipc$dispatch("-2060799229", new Object[]{this})).intValue();
            }
            List<Banner> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-927950032")) {
                return ipChange.ipc$dispatch("-927950032", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            int size = i % this.b.size();
            View acquire = this.c.acquire();
            if (acquire == null) {
                acquire = LayoutInflater.from(this.a).inflate(R$layout.mine_starindex_xunyan_banner_item, viewGroup, false);
            }
            Banner banner = this.b.get(size);
            ImageView imageView = (ImageView) acquire.findViewById(R$id.banner_img);
            cn.damai.common.image.a.b().e(banner.pic).i(R$drawable.uikit_default_image_bg_grey).e(new b(this, imageView)).n(new a(this, imageView)).f();
            imageView.setTag(new a(banner, size));
            imageView.setOnClickListener(this);
            viewGroup.addView(acquire);
            return acquire;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-147615329")) {
                return view == obj;
            }
            return ((Boolean) ipChange.ipc$dispatch("-147615329", new Object[]{this, view, obj})).booleanValue();
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-739245124")) {
                ipChange.ipc$dispatch("-739245124", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if ((tag instanceof a) && XunYanBanner.this.mClickListener != null) {
                a aVar = (a) tag;
                XunYanBanner.this.mClickListener.onBannerClick(aVar.a, aVar.b);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1961943288")) {
                ipChange.ipc$dispatch("-1961943288", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            try {
                if (i != this.d) {
                    this.d = i;
                    int size = i % this.b.size();
                    zd2.f().g((View) obj, size, XunYanBanner.this.bizId, XunYanBanner.this.bizType, XunYanBanner.this.isSelf, this.b.get(size).url);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    /* compiled from: Taobao */
    public interface OnBannerClickListener {
        void onBannerClick(Banner banner, int i);
    }

    /* compiled from: Taobao */
    public interface OnBannerPageChangedListener {
        void onChanged(int i, int i2);
    }

    /* compiled from: Taobao */
    public static class a {
        public final Banner a;
        public final int b;

        public a(Banner banner, int i) {
            this.a = banner;
            this.b = i;
        }
    }

    public XunYanBanner(@NonNull Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private OnBannerPageChangedListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535417712")) {
            return (OnBannerPageChangedListener) ipChange.ipc$dispatch("-535417712", new Object[]{this});
        }
        WeakReference<OnBannerPageChangedListener> weakReference = this.mListenerWeal;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144587838")) {
            ipChange.ipc$dispatch("-2144587838", new Object[]{this, context, attributeSet});
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            BannerScroller bannerScroller = new BannerScroller(context);
            bannerScroller.setDuration(800);
            declaredField.set(this, bannerScroller);
        } catch (Exception e) {
            Log.e("XunYanBanner", e.getMessage());
        }
        this.mAdapter = new BannerAdapter(context);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.user.star.view.XunYanBanner.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-467811865")) {
                    ipChange.ipc$dispatch("-467811865", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1760306566")) {
                    ipChange.ipc$dispatch("1760306566", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "426018290")) {
                    ipChange.ipc$dispatch("426018290", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                OnBannerPageChangedListener listener = XunYanBanner.this.getListener();
                if (listener != null && XunYanBanner.this.mAdapter != null) {
                    int realCount = XunYanBanner.this.mAdapter.getRealCount();
                    listener.onChanged(realCount, i % realCount);
                }
            }
        });
        setAdapter(this.mAdapter);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isCanAnimation() {
        BannerAdapter bannerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682174002")) {
            return ((Boolean) ipChange.ipc$dispatch("1682174002", new Object[]{this})).booleanValue();
        }
        return this.isAttachedToWindow && getVisibility() == 0 && (bannerAdapter = this.mAdapter) != null && bannerAdapter.getRealCount() > 1;
    }

    public void addUTParams(String str, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594794861")) {
            ipChange.ipc$dispatch("-594794861", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.bizId = str;
        this.bizType = i;
        this.isSelf = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778942416")) {
            return ((Boolean) ipChange.ipc$dispatch("1778942416", new Object[]{this, motionEvent})).booleanValue();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (dispatchTouchEvent && action == 0) {
            stopAnimation();
        } else if (action == 1 || action == 3) {
            startAnimationIfNeed();
        }
        return dispatchTouchEvent;
    }

    public boolean isFlipping() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-689927929")) {
            return this.isFlipping;
        }
        return ((Boolean) ipChange.ipc$dispatch("-689927929", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951189378")) {
            ipChange.ipc$dispatch("-1951189378", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        startAnimationIfNeed();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898164257")) {
            ipChange.ipc$dispatch("898164257", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        stopAnimation();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37109612")) {
            ipChange.ipc$dispatch("37109612", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            startAnimationIfNeed();
        } else {
            stopAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781701592")) {
            ipChange.ipc$dispatch("1781701592", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAnimationIfNeed();
        } else {
            stopAnimation();
        }
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959626871")) {
            ipChange.ipc$dispatch("-959626871", new Object[]{this, onBannerClickListener});
            return;
        }
        this.mClickListener = onBannerClickListener;
    }

    public void setListener(OnBannerPageChangedListener onBannerPageChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884651562")) {
            ipChange.ipc$dispatch("-1884651562", new Object[]{this, onBannerPageChangedListener});
        } else if (onBannerPageChangedListener != null) {
            this.mListenerWeal = new WeakReference<>(onBannerPageChangedListener);
        } else {
            this.mListenerWeal = null;
        }
    }

    public void startAnimationIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097698359")) {
            ipChange.ipc$dispatch("1097698359", new Object[]{this});
        } else if (isCanAnimation()) {
            removeCallbacks(this.mFlipRunnable);
            this.isFlipping = true;
            postDelayed(this.mFlipRunnable, 3000);
        }
    }

    public void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390493092")) {
            ipChange.ipc$dispatch("-1390493092", new Object[]{this});
            return;
        }
        this.isFlipping = false;
        removeCallbacks(this.mFlipRunnable);
    }

    public void update(List<Banner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904769876")) {
            ipChange.ipc$dispatch("904769876", new Object[]{this, list});
            return;
        }
        this.mAdapter.b = list;
        this.mAdapter.notifyDataSetChanged();
        startAnimationIfNeed();
        if (list == null) {
            return;
        }
        if (list.size() == 1) {
            setCurrentItem(0);
        } else if (list.size() > 1) {
            setCurrentItem(list.size() * 5);
        }
    }

    public XunYanBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlipRunnable = new Runnable() {
            /* class cn.damai.user.star.view.XunYanBanner.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                int currentItem;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1880098534")) {
                    ipChange.ipc$dispatch("1880098534", new Object[]{this});
                } else if (XunYanBanner.this.isCanAnimation() && (currentItem = XunYanBanner.this.getCurrentItem() + 1) <= XunYanBanner.this.mAdapter.getCount() - 1) {
                    XunYanBanner.this.setCurrentItem(currentItem, true);
                    XunYanBanner.this.isFlipping = true;
                    XunYanBanner.this.postDelayed(this, 3000);
                }
            }
        };
        this.isFlipping = false;
        this.isAttachedToWindow = false;
        init(context, attributeSet);
    }
}

package tb;

import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* compiled from: Taobao */
public class cw2 {

    /* compiled from: Taobao */
    static class a implements ViewPager.OnPageChangeListener {
        final /* synthetic */ MagicIndicator a;

        a(MagicIndicator magicIndicator) {
            this.a = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.a.onPageScrollStateChanged(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            this.a.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.a.onPageSelected(i);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}

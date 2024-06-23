package net.lucode.hackware.magicindicator.abs;

/* compiled from: Taobao */
public interface IPagerNavigator {
    void notifyDataSetChanged();

    void onAttachToMagicIndicator();

    void onDetachFromMagicIndicator();

    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, int i2);

    void onPageSelected(int i);
}

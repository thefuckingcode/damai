package com.alibaba.responsive;

/* compiled from: Taobao */
public interface IConfig {
    double getPhoneScreenInches();

    int getPhoneStandardWidthDp();

    boolean hitFold();

    boolean hitPad();

    boolean isOpenResponsiveSwitch();

    boolean isUsePadOpt();
}

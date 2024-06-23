package com.youku.live.dago.widgetlib.interactive.gift.manager;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftCategoryBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftLinkInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPosition;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class GiftDataManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile GiftDataManager sInstance;
    private List<GiftCategoryBean> mGiftCategoryList = new ArrayList();
    private List<GiftLinkInfoBean> mGiftLinkInfoList = new ArrayList();
    private List<GiftPropBean> mGiftPropList = new ArrayList();
    private List<GiftTargetInfoBean> mGiftTargetList = new ArrayList();
    private Map<String, String> mSpm = new HashMap();
    private boolean usingLaifengCoin = false;

    public static GiftDataManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1689853787")) {
            return (GiftDataManager) ipChange.ipc$dispatch("1689853787", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (GiftDataManager.class) {
                if (sInstance == null) {
                    sInstance = new GiftDataManager();
                }
            }
        }
        return sInstance;
    }

    private List<GiftCategoryBean> hookCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802639322")) {
            return (List) ipChange.ipc$dispatch("1802639322", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            GiftCategoryBean giftCategoryBean = new GiftCategoryBean();
            giftCategoryBean.name = "test--0" + i;
            giftCategoryBean.groupId = "83";
            for (int i2 = 0; i2 < 28 - i; i2++) {
                GiftInfoBean giftInfoBean = new GiftInfoBean();
                giftInfoBean.icon = "https://r1.ykimg.com/051000005BA31AC3A11883108E035B77";
                giftInfoBean.name = "大礼物0" + i2;
                giftInfoBean.id = "2";
                giftInfoBean.coins = "1000";
                giftCategoryBean.giftInfos.add(giftInfoBean);
            }
            arrayList.add(giftCategoryBean);
        }
        return arrayList;
    }

    private List<GiftTargetInfoBean> hookTargetCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1108433547")) {
            return (List) ipChange.ipc$dispatch("1108433547", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            GiftTargetInfoBean giftTargetInfoBean = new GiftTargetInfoBean();
            if (i % 2 == 1) {
                giftTargetInfoBean.icon = "https://r1.ykimg.com/051000005BA31AC3A11883108E035B77";
            }
            giftTargetInfoBean.name = "明星" + i;
            giftTargetInfoBean.id = i + "";
            arrayList.add(giftTargetInfoBean);
        }
        return arrayList;
    }

    public void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295952778")) {
            ipChange.ipc$dispatch("-295952778", new Object[]{this});
            return;
        }
        this.mGiftCategoryList.clear();
        this.mGiftTargetList.clear();
        this.mGiftPropList.clear();
    }

    public List<GiftCategoryBean> getGiftCategoryList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1243091396")) {
            return this.mGiftCategoryList;
        }
        return (List) ipChange.ipc$dispatch("-1243091396", new Object[]{this});
    }

    public GiftPosition getGiftPosition(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876972274")) {
            return (GiftPosition) ipChange.ipc$dispatch("-1876972274", new Object[]{this, str});
        }
        GiftPosition giftPosition = new GiftPosition();
        if (TextUtils.isEmpty(str)) {
            return giftPosition;
        }
        for (int i = 0; i < this.mGiftCategoryList.size(); i++) {
            GiftCategoryBean giftCategoryBean = this.mGiftCategoryList.get(i);
            if (!(giftCategoryBean == null || giftCategoryBean.giftInfos == null)) {
                for (int i2 = 0; i2 < giftCategoryBean.giftInfos.size(); i2++) {
                    if (str.equals(giftCategoryBean.giftInfos.get(i2).id)) {
                        giftPosition.groupPosition = i;
                        giftPosition.giftPosition = i2;
                    }
                }
            }
        }
        return giftPosition;
    }

    public List<GiftPropBean> getGiftPropList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1903353375")) {
            return this.mGiftPropList;
        }
        return (List) ipChange.ipc$dispatch("-1903353375", new Object[]{this});
    }

    public List<GiftTargetInfoBean> getGiftTargetList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1084465649")) {
            return this.mGiftTargetList;
        }
        return (List) ipChange.ipc$dispatch("-1084465649", new Object[]{this});
    }

    public Map<String, String> getSpm() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "84917432")) {
            return this.mSpm;
        }
        return (Map) ipChange.ipc$dispatch("84917432", new Object[]{this});
    }

    public int getTargetPosition(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145466086")) {
            return ((Integer) ipChange.ipc$dispatch("-145466086", new Object[]{this, str})).intValue();
        } else if (TextUtils.isEmpty(str)) {
            return -1;
        } else {
            for (int i = 0; i < this.mGiftTargetList.size(); i++) {
                if (this.mGiftTargetList.get(i) != null && str.equals(this.mGiftTargetList.get(i).id)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean getUsingLaifengCoin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1741850050")) {
            return this.usingLaifengCoin;
        }
        return ((Boolean) ipChange.ipc$dispatch("1741850050", new Object[]{this})).booleanValue();
    }

    public List<GiftLinkInfoBean> getmGiftLinkInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2032194377")) {
            return this.mGiftLinkInfoList;
        }
        return (List) ipChange.ipc$dispatch("-2032194377", new Object[]{this});
    }

    public boolean hasTarget() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "677918918")) {
            return this.mGiftTargetList.size() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("677918918", new Object[]{this})).booleanValue();
    }

    public void resetDataExposeState() {
        ArrayList<GiftInfoBean> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921883095")) {
            ipChange.ipc$dispatch("-921883095", new Object[]{this});
            return;
        }
        List<GiftCategoryBean> list = this.mGiftCategoryList;
        if (list != null && list.size() > 0) {
            for (GiftCategoryBean giftCategoryBean : this.mGiftCategoryList) {
                if (!(giftCategoryBean == null || (arrayList = giftCategoryBean.giftInfos) == null || arrayList.size() <= 0)) {
                    Iterator<GiftInfoBean> it = giftCategoryBean.giftInfos.iterator();
                    while (it.hasNext()) {
                        it.next().hasExposed = false;
                    }
                }
            }
        }
        List<GiftTargetInfoBean> list2 = this.mGiftTargetList;
        if (list2 != null && list2.size() > 0) {
            for (GiftTargetInfoBean giftTargetInfoBean : this.mGiftTargetList) {
                giftTargetInfoBean.hasExposed = false;
            }
        }
        List<GiftPropBean> list3 = this.mGiftPropList;
        if (list3 != null && list3.size() > 0) {
            for (GiftPropBean giftPropBean : this.mGiftPropList) {
                giftPropBean.hasExposed = false;
            }
        }
    }

    public void setSpm(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690055638")) {
            ipChange.ipc$dispatch("1690055638", new Object[]{this, map});
            return;
        }
        this.mSpm = map;
    }

    public void setUsingLaifengCoin(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215094242")) {
            ipChange.ipc$dispatch("215094242", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.usingLaifengCoin = z;
    }
}

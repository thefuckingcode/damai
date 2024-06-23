package com.youku.live.dago.widgetlib.view.management;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.view.management.LiveManageDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class BanSpeakDialog extends LiveManageDialog {
    private static transient /* synthetic */ IpChange $ipChange;

    public BanSpeakDialog(Context context, LiveManageController liveManageController) {
        super(context, liveManageController);
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public List<LiveManageDialog.DialogItemEntry> getDialogItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373234462")) {
            return (List) ipChange.ipc$dispatch("373234462", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass1 */

            {
                this.itemName = "10分钟";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1266639050")) {
                            ipChange.ipc$dispatch("-1266639050", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(1);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass2 */

            {
                this.itemName = "30分钟";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass2.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "458841847")) {
                            ipChange.ipc$dispatch("458841847", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(2);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass3 */

            {
                this.itemName = "1小时";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass3.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2110644552")) {
                            ipChange.ipc$dispatch("-2110644552", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(3);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass4 */

            {
                this.itemName = "1天";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.AnonymousClass4.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-385163655")) {
                            ipChange.ipc$dispatch("-385163655", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(4);
                        }
                    }
                };
            }
        });
        return arrayList;
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public String getDialogTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1848942001")) {
            return "禁言时间";
        }
        return (String) ipChange.ipc$dispatch("-1848942001", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943890564")) {
            ipChange.ipc$dispatch("1943890564", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (AppContextUtils.getApp().getResources().getConfiguration().orientation == 2) {
            setListViewHeight(UIUtil.dip2px(150));
        }
    }
}

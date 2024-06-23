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
public class KickoutDialog extends LiveManageDialog {
    private static transient /* synthetic */ IpChange $ipChange;

    public KickoutDialog(Context context, LiveManageController liveManageController) {
        super(context, liveManageController);
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public List<LiveManageDialog.DialogItemEntry> getDialogItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490800377")) {
            return (List) ipChange.ipc$dispatch("-1490800377", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass1 */

            {
                this.itemName = "10分钟";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1077823085")) {
                            ipChange.ipc$dispatch("1077823085", new Object[]{this, view});
                            return;
                        }
                        KickoutDialog.this.dismiss();
                        LiveManageController liveManageController = KickoutDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserKickout(1);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass2 */

            {
                this.itemName = "30分钟";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass2.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1491663314")) {
                            ipChange.ipc$dispatch("-1491663314", new Object[]{this, view});
                            return;
                        }
                        KickoutDialog.this.dismiss();
                        LiveManageController liveManageController = KickoutDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserKickout(2);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass3 */

            {
                this.itemName = "1小时";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass3.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "233817583")) {
                            ipChange.ipc$dispatch("233817583", new Object[]{this, view});
                            return;
                        }
                        KickoutDialog.this.dismiss();
                        LiveManageController liveManageController = KickoutDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserKickout(3);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() {
            /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass4 */

            {
                this.itemName = "1天";
                this.listener = new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.view.management.KickoutDialog.AnonymousClass4.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1959298480")) {
                            ipChange.ipc$dispatch("1959298480", new Object[]{this, view});
                            return;
                        }
                        KickoutDialog.this.dismiss();
                        LiveManageController liveManageController = KickoutDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserKickout(4);
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
        if (!AndroidInstantRuntime.support(ipChange, "2109907448")) {
            return "踢出时间";
        }
        return (String) ipChange.ipc$dispatch("2109907448", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414469971")) {
            ipChange.ipc$dispatch("-1414469971", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (AppContextUtils.getApp().getResources().getConfiguration().orientation == 2) {
            setListViewHeight(UIUtil.dip2px(150));
        }
    }
}

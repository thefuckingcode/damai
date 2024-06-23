package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
public final class bg implements IRouteSearchV2 {
    private RouteSearchV2.OnRouteSearchListener a;
    private Context b;
    private Handler c;

    public bg(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.b = context.getApplicationContext();
            this.c = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            r.a(this.b);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(driveRouteQuery.getFromAndTo())) {
                ah.a().a(driveRouteQuery.getPassedByPoints());
                ah.a().b(driveRouteQuery.getAvoidpolygons());
                RouteSearchV2.DriveRouteQuery clone = driveRouteQuery.clone();
                DriveRouteResultV2 driveRouteResultV2 = (DriveRouteResultV2) new n(this.b, clone).b();
                if (driveRouteResultV2 != null) {
                    driveRouteResultV2.setDriveQuery(clone);
                }
                return driveRouteResultV2;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(final RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bg.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    DriveRouteResultV2 driveRouteResultV2 = null;
                    try {
                        driveRouteResultV2 = bg.this.calculateDriveRoute(driveRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bg.this.a;
                        bundle.putParcelable("result", driveRouteResultV2);
                        obtainMessage.setData(bundle);
                        bg.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bg.this.a;
                    bundle.putParcelable("result", driveRouteResultV2);
                    obtainMessage.setData(bundle);
                    bg.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    private static boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        if (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return false;
        }
        return true;
    }
}

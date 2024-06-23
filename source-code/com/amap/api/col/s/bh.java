package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* compiled from: Taobao */
public final class bh implements IShareSearch {
    private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    private static final String f = "";
    private Context a;
    private ShareSearch.OnShareSearchListener g;

    public bh(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context;
        } else {
            String str = a2.b;
            throw new AMapException(str, 1, str, a2.a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        if (shareBusRouteQuery != null) {
            try {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                String str = b;
                String str2 = f;
                return (String) new al(this.a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, str2, str2, str2)).b();
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchBusRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass2 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1103;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchBusRouteShareUrl = bh.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchBusRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        if (shareDrivingRouteQuery != null) {
            try {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                String str = b;
                String str2 = f;
                return (String) new al(this.a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).b();
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass4 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchDrivingRouteShareUrl = bh.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        if (latLonSharePoint != null) {
            try {
                return (String) new al(this.a, String.format(c, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).b();
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchLocationShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass6 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1101;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchLocationShareUrl = bh.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchLocationShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        String str;
        if (shareNaviQuery != null) {
            try {
                ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
                if (fromAndTo.getTo() != null) {
                    LatLonPoint from = fromAndTo.getFrom();
                    LatLonPoint to = fromAndTo.getTo();
                    int naviMode = shareNaviQuery.getNaviMode();
                    if (fromAndTo.getFrom() == null) {
                        str = String.format(d, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    } else {
                        str = String.format(d, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    }
                    return (String) new al(this.a, str).b();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchNaviShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass5 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1102;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchNaviShareUrl = bh.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchNaviShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return (String) new al(this.a, String.format(e, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).b();
                }
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass1 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1100;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchPoiShareUrl = bh.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchPoiShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        if (shareWalkRouteQuery != null) {
            try {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                String str = b;
                String str2 = f;
                return (String) new al(this.a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).b();
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bh.AnonymousClass3 */

                public final void run() {
                    if (bh.this.g != null) {
                        Message obtainMessage = t.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1105;
                        obtainMessage.obj = bh.this.g;
                        try {
                            String searchWalkRouteShareUrl = bh.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            t.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        t.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.g = onShareSearchListener;
    }
}

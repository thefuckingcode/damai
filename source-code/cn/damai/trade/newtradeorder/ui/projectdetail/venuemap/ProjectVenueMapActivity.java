package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.av2;
import tb.lk1;
import tb.ln2;
import tb.ne2;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class ProjectVenueMapActivity extends DamaiBaseActivity<VenuePresenter, VenueContract.Model> implements AMap.OnMarkerClickListener, AMap.InfoWindowAdapter, PoiSearch.OnPoiSearchListener, VenueContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = ProjectVenueMapActivity.class.getSimpleName();
    private AMap mAMap;
    private double mLat;
    private double mLng;
    private LinearLayout mLvVenueTitleView;
    private View.OnClickListener mOnInfoNavigationClickListener;
    private long mProjectId;
    private TextView mTvVenueMainTitle;
    private DMIconFontTextView mTvVenueTitleBack;
    private Venue mVenue;
    private String mVenueAddress;
    private long mVenueId;
    private LatLng mVenueLatLng;
    private MapView mVenueMapView;
    private String mVenueName;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2061782075")) {
                ipChange.ipc$dispatch("2061782075", new Object[]{this, view});
                return;
            }
            ProjectVenueMapActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-121894852")) {
                ipChange.ipc$dispatch("-121894852", new Object[]{this, view});
            } else if (ProjectVenueMapActivity.this.mVenue != null) {
                ResolveInfo isInstallMapApp = ProjectVenueMapActivity.isInstallMapApp();
                if (isInstallMapApp == null) {
                    ToastUtil.a().j(ProjectVenueMapActivity.this, "没有可用地图导航，建议下载高德地图");
                    return;
                }
                ActivityInfo activityInfo = isInstallMapApp.activityInfo;
                if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                    if (isInstallMapApp.activityInfo.packageName.contains("com.autonavi.minimap")) {
                        ProjectVenueMapActivity.this.startGaoDeMapDestPoiSearch();
                    } else if (isInstallMapApp.activityInfo.packageName.contains("com.baidu.BaiduMap")) {
                        ProjectVenueMapActivity projectVenueMapActivity = ProjectVenueMapActivity.this;
                        ProjectVenueMapActivity.this.enterBaiDuMap(projectVenueMapActivity.getBaiDuMapUri(isInstallMapApp.activityInfo.packageName, projectVenueMapActivity.mLng, ProjectVenueMapActivity.this.mLat));
                    } else {
                        ToastUtil.a().j(ProjectVenueMapActivity.this, "没有可用地图导航，建议下载高德地图");
                    }
                }
            }
        }
    }

    private void addMarkerToMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057852823")) {
            ipChange.ipc$dispatch("2057852823", new Object[]{this});
            return;
        }
        this.mAMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.mVenueLatLng, 16.5f, 0.0f, 0.0f)));
        Venue venue = this.mVenue;
        if (venue != null) {
            String str = venue.venueName;
            String str2 = venue.address;
            MarkerOptions anchor = new MarkerOptions().position(this.mVenueLatLng).icon(getStartBitmapDescriptor()).anchor(0.5f, 0.5f);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            MarkerOptions title = anchor.title(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.mAMap.addMarker(title.snippet(str2)).showInfoWindow();
        }
    }

    private long compatBundleGetVenueId(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098646941")) {
            return ((Long) ipChange.ipc$dispatch("-1098646941", new Object[]{this, bundle})).longValue();
        }
        Object obj = bundle.get("venueid");
        if (obj == null) {
            obj = bundle.get(VenueDetailFragment.VENUE_ID);
        }
        if (obj instanceof String) {
            return lk1.k((String) obj, 0);
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Integer) {
            return (long) ((Integer) obj).intValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void enterBaiDuMap(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181240002")) {
            ipChange.ipc$dispatch("-1181240002", new Object[]{this, str});
        } else if (!xf2.j(str)) {
            try {
                Intent intent = Intent.getIntent(str);
                if (intent != null) {
                    startActivity(intent);
                }
            } catch (Exception | URISyntaxException unused) {
            }
        }
    }

    private void enterGaoDeMapRoutePlanning(String str, String str2, double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026937687")) {
            ipChange.ipc$dispatch("-2026937687", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2)});
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(getGaoDeMapRouterUri(str, str2, d, d2));
        try {
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static double[] gaoDeToBaidu(double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100872436")) {
            return (double[]) ipChange.ipc$dispatch("-1100872436", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + (Math.sin(d2 * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d2, d) + (Math.cos(d * 52.35987755982988d) * 3.0E-6d);
        return new double[]{(Math.cos(atan2) * sqrt) + 0.0065d, (sqrt * Math.sin(atan2)) + 0.006d};
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getBaiDuMapUri(String str, double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992021874")) {
            return (String) ipChange.ipc$dispatch("-1992021874", new Object[]{this, str, Double.valueOf(d), Double.valueOf(d2)});
        }
        double[] gaoDeToBaidu = gaoDeToBaidu(d, d2);
        StringBuilder sb = new StringBuilder();
        if (gaoDeToBaidu.length > 1) {
            sb.append("intent://map/marker?");
            sb.append("location=");
            sb.append(gaoDeToBaidu[1]);
            sb.append(",");
            sb.append(gaoDeToBaidu[0]);
            sb.append("&");
            sb.append("title=到达位置");
            sb.append("&");
            sb.append("content=");
            sb.append(this.mVenueName);
            sb.append("&");
            sb.append("src=cn.damai|DamaiApp");
            sb.append("#Intent;scheme=bdapp;package=");
            sb.append(str);
            sb.append(";end");
        }
        return sb.toString();
    }

    private Uri getGaoDeMapRouterUri(String str, String str2, double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765715999")) {
            return (Uri) ipChange.ipc$dispatch("-1765715999", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2)});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("amapuri://route/plan/?");
        sb.append("sourceApplication=");
        sb.append("DamaiApp");
        sb.append("&");
        sb.append("did=");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("&");
        sb.append("dlat=");
        sb.append(d);
        sb.append("&");
        sb.append("dlon=");
        sb.append(d2);
        sb.append("&");
        sb.append("dname=");
        sb.append(str);
        sb.append("&");
        sb.append("dev=");
        sb.append("0");
        sb.append("&");
        sb.append("t=");
        sb.append(0);
        return Uri.parse(sb.toString());
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95470146")) {
            ipChange.ipc$dispatch("-95470146", new Object[]{this});
            return;
        }
        this.mOnInfoNavigationClickListener = new b();
    }

    private void initMap(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472365491")) {
            ipChange.ipc$dispatch("1472365491", new Object[]{this, bundle});
            return;
        }
        MapView mapView = (MapView) findViewById(R$id.trade_project_detail_venue_map);
        this.mVenueMapView = mapView;
        mapView.onCreate(bundle);
        if (this.mAMap == null) {
            this.mAMap = this.mVenueMapView.getMap();
        }
        setUpMap();
    }

    /* access modifiers changed from: private */
    public static ResolveInfo isInstallMapApp() {
        ResolveInfo resolveInfo;
        ResolveInfo resolveInfo2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849495280")) {
            return (ResolveInfo) ipChange.ipc$dispatch("-1849495280", new Object[0]);
        }
        new HashMap();
        List<ResolveInfo> queryIntentActivities = xs0.a().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:38.899533,-77.036476")), 32);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            resolveInfo2 = null;
            while (true) {
                if (!it.hasNext()) {
                    resolveInfo = null;
                    break;
                }
                resolveInfo = it.next();
                if (resolveInfo.activityInfo.packageName.contains("com.autonavi.minimap")) {
                    break;
                } else if (resolveInfo.activityInfo.packageName.contains("com.baidu.BaiduMap")) {
                    resolveInfo2 = resolveInfo;
                }
            }
        } else {
            resolveInfo2 = null;
            resolveInfo = null;
        }
        if (resolveInfo != null) {
            return resolveInfo;
        }
        if (resolveInfo2 != null) {
            return resolveInfo2;
        }
        return null;
    }

    private boolean isPoiValid(PoiItem poiItem) {
        LatLonPoint latLonPoint;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293147025")) {
            return ((Boolean) ipChange.ipc$dispatch("293147025", new Object[]{this, poiItem})).booleanValue();
        }
        if (poiItem == null || xf2.j(poiItem.getPoiId()) || (latLonPoint = poiItem.getLatLonPoint()) == null) {
            return false;
        }
        try {
            LatLng latLng = new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
            Venue venue = this.mVenue;
            float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, new LatLng(venue.lat, venue.lng));
            if (calculateLineDistance <= 200.0f) {
                return true;
            }
            if (calculateLineDistance > 2000.0f) {
                av2.b(this.mVenue.venueName, this.mVenueId, String.valueOf(calculateLineDistance), this.mProjectId);
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void renderInfo(Marker marker, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116529127")) {
            ipChange.ipc$dispatch("1116529127", new Object[]{this, marker, view});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.trade_venue_map_navigate_tv);
        TextView textView2 = (TextView) view.findViewById(R$id.trade_venue_map_venue_name_tv);
        TextView textView3 = (TextView) view.findViewById(R$id.trade_venue_map_venue_detail_address_tv);
        if (!xf2.j(marker.getTitle())) {
            textView2.setText(marker.getTitle());
        } else {
            textView2.setText("");
        }
        if (!xf2.j(marker.getSnippet())) {
            textView3.setText(marker.getSnippet());
        } else {
            textView3.setText("");
        }
        textView.setOnClickListener(this.mOnInfoNavigationClickListener);
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140787166")) {
            ipChange.ipc$dispatch("1140787166", new Object[]{this});
            return;
        }
        View findViewById = this.mLvVenueTitleView.findViewById(R$id.top_status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, ne2.a(this)));
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void setUpMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706869026")) {
            ipChange.ipc$dispatch("-1706869026", new Object[]{this});
            return;
        }
        this.mAMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.mAMap.getUiSettings().setZoomControlsEnabled(false);
        this.mAMap.getUiSettings().setScaleControlsEnabled(false);
        this.mAMap.setMyLocationEnabled(false);
        this.mAMap.setOnMapLoadedListener(null);
        this.mAMap.setOnMarkerClickListener(this);
        this.mAMap.setInfoWindowAdapter(this);
    }

    private void showPoiBylatlon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816501149")) {
            ipChange.ipc$dispatch("816501149", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double d = extras.getDouble("lat");
            double d2 = extras.getDouble("lng");
            String string = extras.getString(ILocatable.ADDRESS);
            String string2 = extras.getString("name");
            if (d > 0.0d && d2 > 0.0d) {
                Venue venue = new Venue();
                this.mVenue = venue;
                venue.venueName = string2;
                venue.address = string;
                venue.lat = d;
                venue.lng = d2;
                this.mVenueName = string2;
                this.mVenueAddress = string;
                this.mLat = d;
                this.mLng = d2;
                this.mVenueLatLng = new LatLng(this.mLat, this.mLng);
                addMarkerToMap();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startGaoDeMapDestPoiSearch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667631253")) {
            ipChange.ipc$dispatch("667631253", new Object[]{this});
            return;
        }
        Venue venue = this.mVenue;
        if (venue != null) {
            PoiSearch.Query query = new PoiSearch.Query(venue.venueName, "", venue.cityName);
            query.setPageSize(10);
            Venue venue2 = this.mVenue;
            query.setLocation(new LatLonPoint(venue2.lat, venue2.lng));
            query.setCityLimit(true);
            try {
                PoiSearch poiSearch = new PoiSearch(this, query);
                poiSearch.setOnPoiSearchListener(this);
                poiSearch.searchPOIAsyn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618626789")) {
            ipChange.ipc$dispatch("618626789", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void executeVenueDetailInfoRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-327875753")) {
            ipChange.ipc$dispatch("-327875753", new Object[]{this});
        } else if (this.mVenueId != 0) {
            startProgressDialog();
            ((VenuePresenter) this.mPresenter).retrieveVenueDetailInfo(String.valueOf(this.mVenueId));
        }
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1288819267")) {
            return (View) ipChange.ipc$dispatch("1288819267", new Object[]{this, marker});
        }
        View inflate = getLayoutInflater().inflate(R$layout.trade_venue_map_address_info_window, (ViewGroup) null);
        renderInfo(marker, inflate);
        return inflate;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024272339")) {
            return (View) ipChange.ipc$dispatch("-1024272339", new Object[]{this, marker});
        }
        View inflate = getLayoutInflater().inflate(R$layout.trade_venue_map_address_info_window, (ViewGroup) null);
        renderInfo(marker, inflate);
        return inflate;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1254127589")) {
            return R$layout.project_venue_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("1254127589", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public BitmapDescriptor getStartBitmapDescriptor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1529954447")) {
            return BitmapDescriptorFactory.fromResource(R$drawable.trade_venue_address_map_indicator_icon);
        }
        return (BitmapDescriptor) ipChange.ipc$dispatch("-1529954447", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638749130")) {
            ipChange.ipc$dispatch("-1638749130", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596943965")) {
            ipChange.ipc$dispatch("-1596943965", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mVenueId = compatBundleGetVenueId(extras);
            this.mVenueName = extras.getString("name");
            this.mProjectId = extras.getLong("projectId");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109245621")) {
            ipChange.ipc$dispatch("2109245621", new Object[]{this});
            return;
        }
        ((VenuePresenter) this.mPresenter).setVM(this, (VenueContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709056200")) {
            ipChange.ipc$dispatch("1709056200", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initData();
        initViews();
        setStatusBar();
        initListeners();
    }

    public void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443366703")) {
            ipChange.ipc$dispatch("1443366703", new Object[]{this});
            return;
        }
        this.mLvVenueTitleView = (LinearLayout) findViewById(R$id.trade_project_venue_title_lv);
        this.mTvVenueTitleBack = (DMIconFontTextView) findViewById(R$id.trade_project_venue_title_left_icon);
        this.mTvVenueMainTitle = (TextView) findViewById(R$id.trade_project_venue_title_main_tv);
        this.mTvVenueTitleBack.setOnClickListener(new a());
        if (!xf2.j(this.mVenueName)) {
            this.mTvVenueMainTitle.setText(this.mVenueName);
        } else {
            this.mTvVenueMainTitle.setText("");
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946707342")) {
            ipChange.ipc$dispatch("-1946707342", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(ln2.r().O0(getIntent()));
        initMap(bundle);
        showPoiBylatlon();
        executeVenueDetailInfoRequest();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514558414")) {
            ipChange.ipc$dispatch("-1514558414", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mVenueMapView.onDestroy();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396198555")) {
            ipChange.ipc$dispatch("-396198555", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176508944")) {
            ipChange.ipc$dispatch("176508944", new Object[]{this});
        }
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-160163084")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-160163084", new Object[]{this, marker})).booleanValue();
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978872655")) {
            ipChange.ipc$dispatch("-978872655", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920175688")) {
            ipChange.ipc$dispatch("-920175688", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946215306")) {
            ipChange.ipc$dispatch("-946215306", new Object[]{this});
            return;
        }
        super.onPause();
        this.mVenueMapView.onPause();
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiItemSearched(PoiItem poiItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1544594289")) {
            ipChange.ipc$dispatch("-1544594289", new Object[]{this, poiItem, Integer.valueOf(i)});
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiSearched(PoiResult poiResult, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157248273")) {
            ipChange.ipc$dispatch("157248273", new Object[]{this, poiResult, Integer.valueOf(i)});
        } else if (i != 1000) {
            Venue venue = this.mVenue;
            enterGaoDeMapRoutePlanning(venue.venueName, "", venue.lat, venue.lng);
            Venue venue2 = this.mVenue;
            av2.c((venue2 == null || xf2.j(venue2.venueName)) ? "" : this.mVenue.venueName, this.mVenueId, String.valueOf(i), this.mProjectId);
        } else if (poiResult == null || poiResult.getPois() == null || poiResult.getPois().isEmpty()) {
            Venue venue3 = this.mVenue;
            enterGaoDeMapRoutePlanning(venue3.venueName, "", venue3.lat, venue3.lng);
        } else {
            PoiItem poiItem = poiResult.getPois().get(0);
            if (isPoiValid(poiItem)) {
                String poiId = poiItem.getPoiId();
                Venue venue4 = this.mVenue;
                if (venue4 != null) {
                    enterGaoDeMapRoutePlanning(venue4.venueName, poiId, venue4.lat, venue4.lng);
                    return;
                }
                return;
            }
            Venue venue5 = this.mVenue;
            enterGaoDeMapRoutePlanning(venue5.venueName, "", venue5.lat, venue5.lng);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915084207")) {
            ipChange.ipc$dispatch("-1915084207", new Object[]{this});
            return;
        }
        super.onResume();
        this.mVenueMapView.onResume();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract.View
    public void onRetrieveVenueInfoError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440816683")) {
            ipChange.ipc$dispatch("440816683", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this, str2);
        av2.a(this.mVenueId, str, str2, this.mProjectId);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract.View
    public void onRetrieveVenueInfoSuccess(Venue venue) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1020604567")) {
            ipChange.ipc$dispatch("-1020604567", new Object[]{this, venue});
            return;
        }
        stopProgressDialog();
        if (venue != null) {
            this.mVenue = venue;
            if (!TextUtils.isEmpty(this.mVenueName) || TextUtils.isEmpty(venue.venueName)) {
                z = false;
            }
            TextView textView = this.mTvVenueMainTitle;
            if (textView != null && z) {
                textView.setText(venue.venueName);
            }
            Venue venue2 = this.mVenue;
            this.mVenueName = venue2.venueName;
            this.mVenueAddress = venue2.address;
            this.mLat = venue2.lat;
            this.mLng = venue2.lng;
            this.mVenueLatLng = new LatLng(this.mLat, this.mLng);
            addMarkerToMap();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706292967")) {
            ipChange.ipc$dispatch("706292967", new Object[]{this, bundle});
            return;
        }
        super.onSaveInstanceState(bundle);
        this.mVenueMapView.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "186395033")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("186395033", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882122744")) {
            ipChange.ipc$dispatch("882122744", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416415052")) {
            ipChange.ipc$dispatch("-1416415052", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666379672")) {
            ipChange.ipc$dispatch("1666379672", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921210349")) {
            ipChange.ipc$dispatch("-1921210349", new Object[]{this});
        }
    }
}

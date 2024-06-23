package cn.damai.ticklet.ui.activity;

import android.os.Bundle;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.askpermission.IPermissionAction;
import com.alibaba.pictures.piclocation.listener.LocateMapListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b8;
import tb.hp1;
import tb.j02;
import tb.lp1;
import tb.nt0;
import tb.o81;
import tb.xf0;

/* compiled from: Taobao */
public abstract class DamaiMapBaseActivity<T extends cn.damai.common.app.base.a, E extends BaseModel> extends TickletBaseActivity<T, E> implements LocationSource, LocateMapListener, AMap.OnMarkerClickListener, AMap.OnMapClickListener, AMap.OnCameraChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public AMap aMap;
    public LocationSource.OnLocationChangedListener mListener = null;

    /* compiled from: Taobao */
    public class a implements IPermissionAction {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.askpermission.IPermissionAction
        public void onCall(j02 j02, List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1972414762")) {
                ipChange.ipc$dispatch("-1972414762", new Object[]{this, j02, list});
                return;
            }
            o81.INSTANCE.c().startLocationWithNoCache(DamaiMapBaseActivity.this);
        }
    }

    /* compiled from: Taobao */
    public class b extends nt0 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(DamaiMapBaseActivity damaiMapBaseActivity, String str) {
        }
    }

    /* compiled from: Taobao */
    public class c extends xf0 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String b;

        c(DamaiMapBaseActivity damaiMapBaseActivity, String str) {
            this.b = str;
        }

        /* access modifiers changed from: protected */
        @Override // tb.xf0
        public CharSequence a(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "305399718")) {
                return (CharSequence) ipChange.ipc$dispatch("305399718", new Object[]{this, list});
            }
            return hp1.e(list) + this.b;
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164201967")) {
            ipChange.ipc$dispatch("-164201967", new Object[]{this, onLocationChangedListener});
            return;
        }
        this.mListener = onLocationChangedListener;
        o81.INSTANCE.c().startLocationWithNoCache(this);
    }

    @Override // com.amap.api.maps.LocationSource
    public void deactivate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307808322")) {
            ipChange.ipc$dispatch("-307808322", new Object[]{this});
            return;
        }
        this.mListener = null;
        o81.INSTANCE.c().stop();
    }

    public void initLoc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101266194")) {
            ipChange.ipc$dispatch("1101266194", new Object[]{this, str});
            return;
        }
        b8.a(this).a().permission(lp1.LOCATION).showRationale(new c(this, str)).onDenied(new b(this, str)).onGranted(new a()).start();
    }

    public abstract void initMap(Bundle bundle);

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471973508")) {
            ipChange.ipc$dispatch("-471973508", new Object[]{this, cameraPosition});
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465996247")) {
            ipChange.ipc$dispatch("-1465996247", new Object[]{this, cameraPosition});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702059293")) {
            ipChange.ipc$dispatch("1702059293", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initMap(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019587683")) {
            ipChange.ipc$dispatch("-1019587683", new Object[]{this});
            return;
        }
        super.onDestroy();
        AMap aMap2 = this.aMap;
        if (aMap2 != null) {
            aMap2.clear();
            this.aMap.setOnMapLoadedListener(null);
            this.aMap.setOnMapLongClickListener(null);
            this.aMap.setOnMarkerClickListener(null);
            this.aMap.setInfoWindowAdapter(null);
            this.aMap.setOnInfoWindowClickListener(null);
            this.aMap.setOnMapClickListener(null);
            this.aMap = null;
        }
        o81.INSTANCE.c().stop();
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246672851")) {
            ipChange.ipc$dispatch("-1246672851", new Object[]{this, latLng});
        }
    }

    @Override // com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationFailed(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172271708")) {
            ipChange.ipc$dispatch("-172271708", new Object[]{this, Integer.valueOf(i), str});
        }
    }

    @Override // com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationSuccess(AMapLocation aMapLocation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595127969")) {
            ipChange.ipc$dispatch("595127969", new Object[]{this, aMapLocation});
        } else if (this.mListener != null && aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            this.mListener.onLocationChanged(aMapLocation);
            this.aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()), 13.0f));
        }
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "101886175")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("101886175", new Object[]{this, marker})).booleanValue();
    }
}

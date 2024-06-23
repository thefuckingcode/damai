package cn.damai.musicfestival.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class MusicDispatchBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String ipId;
    public String picUrl;
    public int pos;
    public String projectId;
    public String title;
    public String type;
    public String url;

    @Nullable
    public List<CityMusicBean> doShiningChangedEdit(List<CityMusicBean> list, List<MusicIpBean> list2) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731756788")) {
            return (List) ipChange.ipc$dispatch("-731756788", new Object[]{this, list, list2});
        } else if (f92.d(list) || f92.d(list2)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            if (isValidProjectType()) {
                Iterator<MusicIpBean> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MusicIpBean next = it.next();
                    if (TextUtils.equals(this.ipId, next.musicIpId)) {
                        List<MusicProjectBean> list3 = next.projects;
                        if (!f92.d(list3)) {
                            Iterator<MusicProjectBean> it2 = list3.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MusicProjectBean next2 = it2.next();
                                if (TextUtils.equals(this.projectId, next2.projectId)) {
                                    str = next2.cityId;
                                    break;
                                }
                            }
                        }
                    }
                }
                str = null;
                for (CityMusicBean cityMusicBean : list) {
                    if (TextUtils.equals(cityMusicBean.cityId, str)) {
                        List<MusicIpBean> list4 = cityMusicBean.musicIpInfos;
                        if (!f92.d(list4)) {
                            Iterator<MusicIpBean> it3 = list4.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (TextUtils.equals(this.ipId, it3.next().musicIpId)) {
                                        str2 = this.ipId;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        str2 = null;
                        if (!TextUtils.equals(cityMusicBean.shiningIpId, str2)) {
                            cityMusicBean.shiningIpId = str2;
                            arrayList.add(cityMusicBean);
                        }
                    } else {
                        if (!TextUtils.isEmpty(cityMusicBean.shiningIpId)) {
                            arrayList.add(cityMusicBean);
                        }
                        cityMusicBean.shiningIpId = null;
                    }
                }
            } else {
                for (CityMusicBean cityMusicBean2 : list) {
                    if (!TextUtils.isEmpty(cityMusicBean2.shiningIpId)) {
                        arrayList.add(cityMusicBean2);
                    }
                    cityMusicBean2.shiningIpId = null;
                }
            }
            return arrayList;
        }
    }

    public boolean isValidProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1861783433")) {
            return TextUtils.equals("1", this.type) && !TextUtils.isEmpty(this.projectId);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1861783433", new Object[]{this})).booleanValue();
    }

    public boolean isValidProjectType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2015967267")) {
            return isValidProject() && !TextUtils.isEmpty(this.ipId);
        }
        return ((Boolean) ipChange.ipc$dispatch("-2015967267", new Object[]{this})).booleanValue();
    }

    public boolean isValidUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2068234721")) {
            return TextUtils.equals("2", this.type) && !TextUtils.isEmpty(this.url);
        }
        return ((Boolean) ipChange.ipc$dispatch("2068234721", new Object[]{this})).booleanValue();
    }
}

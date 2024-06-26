package cn.damai.mine.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public abstract class AbstractListAdapter<T> extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artistName = "";
    protected Activity mContext;
    protected LayoutInflater mInflater;
    protected List<T> mList;
    private AdapterView mListView;

    public AbstractListAdapter(Activity activity) {
        this.mContext = activity;
        this.mInflater = LayoutInflater.from(activity);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291015566")) {
            ipChange.ipc$dispatch("-291015566", new Object[]{this});
            return;
        }
        List<T> list = this.mList;
        if (list != null && list.size() > 0) {
            this.mList.clear();
        }
    }

    public String getArtistName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1073100041")) {
            return this.artistName;
        }
        return (String) ipChange.ipc$dispatch("1073100041", new Object[]{this});
    }

    public Context getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1109727274")) {
            return this.mContext;
        }
        return (Context) ipChange.ipc$dispatch("1109727274", new Object[]{this});
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103125307")) {
            return ((Integer) ipChange.ipc$dispatch("-2103125307", new Object[]{this})).intValue();
        }
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686832197")) {
            return ipChange.ipc$dispatch("1686832197", new Object[]{this, Integer.valueOf(i)});
        }
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.get(i);
    }

    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "316388988")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("316388988", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    public List<T> getList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1060909796")) {
            return this.mList;
        }
        return (List) ipChange.ipc$dispatch("-1060909796", new Object[]{this});
    }

    public AdapterView getListView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1125554998")) {
            return this.mListView;
        }
        return (AdapterView) ipChange.ipc$dispatch("1125554998", new Object[]{this});
    }

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public void setArtistName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091446773")) {
            ipChange.ipc$dispatch("1091446773", new Object[]{this, str});
            return;
        }
        this.artistName = str;
    }

    public void setList(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218433584")) {
            ipChange.ipc$dispatch("1218433584", new Object[]{this, list});
            return;
        }
        this.mList = list;
    }

    public void setListView(AdapterView adapterView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345569504")) {
            ipChange.ipc$dispatch("-1345569504", new Object[]{this, adapterView});
            return;
        }
        this.mListView = adapterView;
    }
}

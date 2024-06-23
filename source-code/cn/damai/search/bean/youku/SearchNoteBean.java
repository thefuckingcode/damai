package cn.damai.search.bean.youku;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.gr;
import tb.h62;
import tb.lk1;

/* compiled from: Taobao */
public class SearchNoteBean implements ArtificialProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String imgUrl;
    public int index;
    public boolean isShowVideoTag;
    public CharSequence title;

    public SearchNoteBean() {
    }

    public static List<ArtificialProxy> transfer(List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449388545")) {
            return (List) ipChange.ipc$dispatch("1449388545", new Object[]{list});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                SearchNoteBean searchNoteBean = new SearchNoteBean(list.get(i), i);
                if (searchNoteBean.isValid()) {
                    arrayList.add(searchNoteBean);
                }
            }
            return arrayList;
        }
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1591088135")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("1591088135", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2018355560")) {
            return this.imgUrl;
        }
        return (String) ipChange.ipc$dispatch("-2018355560", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public CharSequence getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2103414404")) {
            return this.title;
        }
        return (CharSequence) ipChange.ipc$dispatch("-2103414404", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public PageSpec getToPageSpec() {
        Bundle bundle;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272592733")) {
            return (PageSpec) ipChange.ipc$dispatch("272592733", new Object[]{this});
        }
        String str = null;
        if (!TextUtils.isEmpty(this.id)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("contentId", this.id);
            str = new Uri.Builder().scheme("damai").authority(gr.DISCOVER_CONTENT_DETAIL).build().toString();
            bundle = bundle2;
        } else {
            bundle = null;
        }
        return new PageSpec(str, bundle);
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public ArtificialProxy.Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1636834568")) {
            return ArtificialProxy.Type.NOTE;
        }
        return (ArtificialProxy.Type) ipChange.ipc$dispatch("1636834568", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public int index() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1953499061")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("-1953499061", new Object[]{this})).intValue();
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isShowVideoTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-265856802")) {
            return this.isShowVideoTag;
        }
        return ((Boolean) ipChange.ipc$dispatch("-265856802", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "974391036")) {
            return !TextUtils.isEmpty(this.id);
        }
        return ((Boolean) ipChange.ipc$dispatch("974391036", new Object[]{this})).booleanValue();
    }

    public SearchNoteBean(String str, String str2, CharSequence charSequence, int i, boolean z) {
        this.imgUrl = str;
        this.id = str2;
        this.title = charSequence;
        this.index = i;
        this.isShowVideoTag = z;
    }

    public SearchNoteBean(SearchResultBeanYouKu.ListBean listBean, int i) {
        if (listBean != null) {
            NoteBean a = h62.a(listBean, i);
            this.id = listBean.id;
            String str = listBean.content_image;
            this.imgUrl = str;
            if (TextUtils.isEmpty(str)) {
                this.imgUrl = a.pic;
                String videoCoverUrl = a.getVideoCoverUrl();
                if (!TextUtils.isEmpty(videoCoverUrl)) {
                    this.imgUrl = videoCoverUrl;
                }
            }
            if (TextUtils.isEmpty(this.id)) {
                this.id = a.id;
            }
            this.title = a.content;
            this.isShowVideoTag = a.isShowVideoIcon();
            this.index = lk1.j(listBean.idx, 0);
        }
    }
}

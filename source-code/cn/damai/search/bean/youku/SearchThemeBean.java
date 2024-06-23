package cn.damai.search.bean.youku;

import android.text.TextUtils;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.if2;
import tb.lk1;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class SearchThemeBean implements ArtificialProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String imgUrl;
    public int index;
    public String jumpUrl;
    public boolean show;
    public CharSequence title;

    public SearchThemeBean() {
    }

    public static List<? extends ArtificialProxy> transfer(List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379709524")) {
            return (List) ipChange.ipc$dispatch("379709524", new Object[]{list});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (SearchResultBeanYouKu.ListBean listBean : list) {
                SearchThemeBean searchThemeBean = new SearchThemeBean(listBean);
                if (searchThemeBean.isValid()) {
                    arrayList.add(searchThemeBean);
                }
            }
            return arrayList;
        }
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1218987692")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-1218987692", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-787051163")) {
            return this.imgUrl;
        }
        return (String) ipChange.ipc$dispatch("-787051163", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public CharSequence getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-79727921")) {
            return this.title;
        }
        return (CharSequence) ipChange.ipc$dispatch("-79727921", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public PageSpec getToPageSpec() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1749163536")) {
            return new PageSpec(this.jumpUrl, null);
        }
        return (PageSpec) ipChange.ipc$dispatch("-1749163536", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public ArtificialProxy.Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1188752037")) {
            return ArtificialProxy.Type.THEME;
        }
        return (ArtificialProxy.Type) ipChange.ipc$dispatch("-1188752037", new Object[]{this});
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public int index() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1100512094")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("1100512094", new Object[]{this})).intValue();
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isShowVideoTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "964008747")) {
            return this.show;
        }
        return ((Boolean) ipChange.ipc$dispatch("964008747", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1878519473")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1878519473", new Object[]{this})).booleanValue();
    }

    public SearchThemeBean(SearchResultBeanYouKu.ListBean listBean) {
        if (listBean != null) {
            this.id = listBean.id;
            this.imgUrl = listBean.theme_image;
            this.index = lk1.j(listBean.idx, 0);
            this.jumpUrl = listBean.url;
            String str = listBean.recommend;
            if (!TextUtils.isEmpty(str)) {
                int a = n42.a(xs0.a(), 12.0f);
                this.title = if2.c(xs0.a(), R$drawable.icon_theme_v2, str, a, a);
            }
        }
    }
}

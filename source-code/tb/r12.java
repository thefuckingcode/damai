package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: Taobao */
public class r12 implements IRichTextManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int RICH_TYPE_ARTIST = 4;
    public static final int RICH_TYPE_DETAIL_INTRO = 3;
    public static final int RICH_TYPE_IMPORTANT = 1;
    public static final int RICH_TYPE_OTHER = 5;
    public static final int RICH_TYPE_OUTLINE = 2;
    private Context a;
    private ProjectDataHolder b;
    private List<HtmlParserManager.a> c;
    private ProjectDataHolder d;
    private List<ProjectDataHolder> e = new ArrayList();
    private List<ProjectDataHolder> f = new ArrayList();
    private List<HtmlParserManager.a> g;
    private ProjectDataHolder h;
    private LinkedHashMap<String, Integer> i = new LinkedHashMap<>();
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;

    /* compiled from: Taobao */
    public class a implements HtmlParserManager.OnSpanClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnSpanClickListener
        public void onSpanClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "257546158")) {
                ipChange.ipc$dispatch("257546158", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            r12.this.m(str);
        }
    }

    /* compiled from: Taobao */
    public class b implements HtmlParserManager.OnParseFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnParseFinishedListener
        public void onParseFinished(List<HtmlParserManager.a> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1504109496")) {
                ipChange.ipc$dispatch("-1504109496", new Object[]{this, list});
            } else if (!s71.a(list)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    HtmlParserManager.a aVar = list.get(i);
                    if (!(aVar == null || aVar.a() == null || "".equals(aVar.a().toString().trim()))) {
                        arrayList.add(aVar);
                    }
                }
                if (!s71.a(arrayList)) {
                    if (!TextUtils.isEmpty(this.a)) {
                        r12 r12 = r12.this;
                        r12.b = r12.k(8, this.a);
                    }
                    r12.this.g = arrayList;
                    List h = r12.this.h(arrayList);
                    if (!(h == null || h.isEmpty())) {
                        r12.this.f.clear();
                        r12.this.f.addAll(h);
                        r12.this.o();
                    }
                }
            }
        }
    }

    private r12(Context context, boolean z) {
        this.a = context;
        this.j = z;
        l();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<ProjectDataHolder> h(List<HtmlParserManager.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602742255")) {
            return (List) ipChange.ipc$dispatch("1602742255", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        int e2 = xf2.e(list);
        if (e2 <= 0) {
            return null;
        }
        if (e2 > 2) {
            this.l = true;
            this.c = list.subList(0, 2);
            p(1);
        } else {
            this.l = false;
            p(e2);
            this.c = list;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < e2; i3++) {
            HtmlParserManager.a aVar = list.get(i3);
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(3);
            projectDataHolder.setConvertedItem(aVar);
            projectDataHolder.setConvertedItemPosition(i3);
            projectDataHolder.setConvertedItemSize(e2);
            projectDataHolder.setRichType(this.m);
            if (aVar.e() == 2) {
                this.i.put(aVar.a().toString(), Integer.valueOf(i2));
                i2++;
            }
            arrayList.add(projectDataHolder);
        }
        return arrayList;
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454428252")) {
            ipChange.ipc$dispatch("454428252", new Object[]{this});
            return;
        }
        this.k = true;
        o();
    }

    public static IRichTextManager j(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-246654680")) {
            return new r12(context, z);
        }
        return (IRichTextManager) ipChange.ipc$dispatch("-246654680", new Object[]{context, Boolean.valueOf(z)});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ProjectDataHolder k(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420957083")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("1420957083", new Object[]{this, Integer.valueOf(i2), str});
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i2);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755259620")) {
            ipChange.ipc$dispatch("1755259620", new Object[]{this});
            return;
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(7);
        this.h = projectDataHolder;
        if (!this.j) {
            projectDataHolder.setMoreType(0);
        } else {
            projectDataHolder.setMoreType(-1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575592657")) {
            ipChange.ipc$dispatch("1575592657", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            DMNav.from(this.a).toUri(str);
        }
    }

    private void n(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978393844")) {
            ipChange.ipc$dispatch("-1978393844", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            HtmlParserManager.a(800, 1.4f, 16, 0, 12, 666666).c(this.a, "<span>" + str2.replaceAll("\r|\t|\n", "").replaceAll(" ", "").replaceAll(" ", "") + "</span>", new a(), new b(str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209776537")) {
            ipChange.ipc$dispatch("-1209776537", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> list = this.f;
        if (list != null && !list.isEmpty()) {
            this.e.clear();
            if (this.j) {
                this.e.addAll(this.f);
                this.h.setMoreContent("");
                this.h.setMoreType(-1);
                this.e.add(this.h);
                return;
            }
            this.e.addAll(this.f);
            if (this.l) {
                this.h.setMoreContent(this.k ? "收起" : "展开更多");
                this.h.setMoreType(0);
            } else {
                this.h.setMoreContent("");
                this.h.setMoreType(-1);
            }
            this.e.add(this.h);
        }
    }

    private void p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011706744")) {
            ipChange.ipc$dispatch("1011706744", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673720717")) {
            ipChange.ipc$dispatch("1673720717", new Object[]{this});
            return;
        }
        this.k = false;
        o();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445525474")) {
            ipChange.ipc$dispatch("-1445525474", new Object[]{this});
            return;
        }
        this.b = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public String combineRichText(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896434772")) {
            return (String) ipChange.ipc$dispatch("-896434772", new Object[]{this, list});
        } else if (list == null || list.isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    sb.append("<p>");
                    sb.append(str);
                    sb.append("</p>");
                }
            }
            return sb.toString();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextMoreListener
    public void expandShrinkRichText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015876461")) {
            ipChange.ipc$dispatch("-1015876461", new Object[]{this});
        } else if (!this.k) {
            i();
        } else {
            q();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public ProjectDataHolder geTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1317852407")) {
            return this.b;
        }
        return (ProjectDataHolder) ipChange.ipc$dispatch("1317852407", new Object[]{this});
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public List<ProjectDataHolder> getDisplayRichItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-56678668")) {
            return this.e;
        }
        return (List) ipChange.ipc$dispatch("-56678668", new Object[]{this});
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626661836")) {
            return ((Integer) ipChange.ipc$dispatch("1626661836", new Object[]{this})).intValue();
        }
        List<HtmlParserManager.a> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public LinkedHashMap<String, Integer> getItemImages() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2051532634")) {
            return this.i;
        }
        return (LinkedHashMap) ipChange.ipc$dispatch("-2051532634", new Object[]{this});
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getItemTypePrevious(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389915845")) {
            return ((Integer) ipChange.ipc$dispatch("1389915845", new Object[]{this, Integer.valueOf(i2)})).intValue();
        }
        List<ProjectDataHolder> list = this.f;
        if (list == null || i2 <= 0 || i2 >= list.size()) {
            return -1;
        }
        return this.f.get(i2 - 1).getConvertedItem().e();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public ProjectDataHolder getShrinkRichItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281337995")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("281337995", new Object[]{this});
        }
        List<HtmlParserManager.a> list = this.c;
        if (list != null && list.size() > 0 && this.d == null) {
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(11);
            this.d = projectDataHolder;
            projectDataHolder.setShrinkConvertedItem(this.c);
            this.d.setShrinkRichType(this.m);
        }
        return this.d;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getStartIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-230442952")) {
            return this.n;
        }
        return ((Integer) ipChange.ipc$dispatch("-230442952", new Object[]{this})).intValue();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean hasExpanded() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "704926396")) {
            return this.k;
        }
        return ((Boolean) ipChange.ipc$dispatch("704926396", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean hasMoreRichItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2118810510")) {
            return this.l;
        }
        return ((Boolean) ipChange.ipc$dispatch("2118810510", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean overLimitedHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1329764734")) {
            return this.o;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1329764734", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void parseRichText(RichTextModule richTextModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420592069")) {
            ipChange.ipc$dispatch("1420592069", new Object[]{this, richTextModule});
        } else if (richTextModule != null) {
            n(richTextModule.getTitle(), richTextModule.getContent());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setHasMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480851298")) {
            ipChange.ipc$dispatch("1480851298", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.l = z;
        o();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setOverLimitedHeight(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641093824")) {
            ipChange.ipc$dispatch("-1641093824", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.o = z;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setRichType(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769398256")) {
            ipChange.ipc$dispatch("-1769398256", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.m = i2;
        ProjectDataHolder projectDataHolder = this.h;
        if (projectDataHolder != null) {
            projectDataHolder.setRichType(i2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setStartIndex(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506080106")) {
            ipChange.ipc$dispatch("506080106", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.n = i2;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean showAllRichText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1250550082")) {
            return this.j;
        }
        return ((Boolean) ipChange.ipc$dispatch("1250550082", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void parseRichText(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086969437")) {
            ipChange.ipc$dispatch("-2086969437", new Object[]{this, str, str2});
            return;
        }
        n(str, str2);
    }
}

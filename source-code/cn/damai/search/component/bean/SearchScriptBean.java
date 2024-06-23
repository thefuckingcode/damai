package cn.damai.search.component.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.collections.m;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class SearchScriptBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String costTime;
    @Nullable
    private String descLocal;
    @Nullable
    private String femaleCount;
    @Nullable
    private String grade;
    @Nullable
    private ArrayList<String> highlightWord;
    @Nullable
    private String id;
    @Nullable
    private String itemScore;
    @Nullable
    private String itemStar;
    @Nullable
    private String manCount;
    @Nullable
    private String maxPeopleCount;
    @Nullable
    private String minPeopleCount;
    @Nullable
    private String name;
    @Nullable
    private String peopleDesc;
    @Nullable
    private String schema;
    private final long serialVersionUID = 1;
    @Nullable
    private ArrayList<String> tagList;
    @Nullable
    private String url;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0089 A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009f A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4 A[Catch:{ Exception -> 0x00d0 }] */
    @Nullable
    public final String buildDesc() {
        boolean z;
        String peopleCountDesc;
        boolean z2;
        String str;
        boolean z3;
        IpChange ipChange = $ipChange;
        boolean z4 = false;
        if (AndroidInstantRuntime.support(ipChange, "776291798")) {
            return (String) ipChange.ipc$dispatch("776291798", new Object[]{this});
        }
        String str2 = this.descLocal;
        if (!(str2 == null || str2.length() == 0)) {
            return this.descLocal;
        }
        StringBuilder sb = new StringBuilder();
        try {
            ArrayList<String> arrayList = this.tagList;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    z = false;
                    if (!z) {
                        ArrayList<String> arrayList2 = this.tagList;
                        k21.f(arrayList2);
                        int i = 0;
                        for (T t : arrayList2) {
                            int i2 = i + 1;
                            if (i < 0) {
                                m.p();
                            }
                            T t2 = t;
                            if (i < 2) {
                                sb.append((String) t2);
                                sb.append("·");
                            }
                            i = i2;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(" | ");
                    }
                    peopleCountDesc = getPeopleCountDesc();
                    if (peopleCountDesc != null) {
                        if (peopleCountDesc.length() != 0) {
                            z2 = false;
                            if (!z2) {
                                sb.append(peopleCountDesc);
                                sb.append(" | ");
                            }
                            str = this.costTime;
                            if (str != null) {
                                if (str.length() != 0) {
                                    z3 = false;
                                    if (!z3) {
                                        sb.append(this.costTime);
                                        sb.append(" | ");
                                    }
                                    String str3 = this.grade;
                                    if (str3 == null || str3.length() == 0) {
                                        z4 = true;
                                    }
                                    if (!z4) {
                                        sb.append(this.grade);
                                        sb.append(" | ");
                                    }
                                    this.descLocal = sb.delete(sb.length() - 3, sb.length()).toString();
                                    return this.descLocal;
                                }
                            }
                            z3 = true;
                            if (!z3) {
                            }
                            String str32 = this.grade;
                            z4 = true;
                            if (!z4) {
                            }
                            this.descLocal = sb.delete(sb.length() - 3, sb.length()).toString();
                            return this.descLocal;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    str = this.costTime;
                    if (str != null) {
                    }
                    z3 = true;
                    if (!z3) {
                    }
                    String str322 = this.grade;
                    z4 = true;
                    if (!z4) {
                    }
                    this.descLocal = sb.delete(sb.length() - 3, sb.length()).toString();
                    return this.descLocal;
                }
            }
            z = true;
            if (!z) {
            }
            peopleCountDesc = getPeopleCountDesc();
            if (peopleCountDesc != null) {
            }
            z2 = true;
            if (!z2) {
            }
            str = this.costTime;
            if (str != null) {
            }
            z3 = true;
            if (!z3) {
            }
            String str3222 = this.grade;
            z4 = true;
            if (!z4) {
            }
            this.descLocal = sb.delete(sb.length() - 3, sb.length()).toString();
        } catch (Exception unused) {
        }
        return this.descLocal;
    }

    @Nullable
    public final String getCostTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "12016615")) {
            return this.costTime;
        }
        return (String) ipChange.ipc$dispatch("12016615", new Object[]{this});
    }

    @Nullable
    public final String getDescLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1018084739")) {
            return this.descLocal;
        }
        return (String) ipChange.ipc$dispatch("1018084739", new Object[]{this});
    }

    @Nullable
    public final String getFemaleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1274523980")) {
            return this.femaleCount;
        }
        return (String) ipChange.ipc$dispatch("1274523980", new Object[]{this});
    }

    @Nullable
    public final String getGrade() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-559458176")) {
            return this.grade;
        }
        return (String) ipChange.ipc$dispatch("-559458176", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2055670803")) {
            return this.highlightWord;
        }
        return (ArrayList) ipChange.ipc$dispatch("2055670803", new Object[]{this});
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "138524616")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("138524616", new Object[]{this});
    }

    @Nullable
    public final String getItemScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-170836760")) {
            return this.itemScore;
        }
        return (String) ipChange.ipc$dispatch("-170836760", new Object[]{this});
    }

    @Nullable
    public final String getItemStar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1768033230")) {
            return this.itemStar;
        }
        return (String) ipChange.ipc$dispatch("-1768033230", new Object[]{this});
    }

    @Nullable
    public final String getManCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1106164738")) {
            return this.manCount;
        }
        return (String) ipChange.ipc$dispatch("1106164738", new Object[]{this});
    }

    @Nullable
    public final String getMaxPeopleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1389528855")) {
            return this.maxPeopleCount;
        }
        return (String) ipChange.ipc$dispatch("-1389528855", new Object[]{this});
    }

    @Nullable
    public final String getMinPeopleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1242094139")) {
            return this.minPeopleCount;
        }
        return (String) ipChange.ipc$dispatch("1242094139", new Object[]{this});
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "49052856")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("49052856", new Object[]{this});
    }

    @Nullable
    public final String getPeopleCountDesc() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1037692058")) {
            return (String) ipChange.ipc$dispatch("1037692058", new Object[]{this});
        }
        String str = this.minPeopleCount;
        if (str == null || str.length() == 0) {
            String str2 = this.maxPeopleCount;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            if (z) {
                return null;
            }
            return this.maxPeopleCount + (char) 20154;
        }
        String str3 = this.maxPeopleCount;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (z) {
            return this.minPeopleCount + (char) 20154;
        } else if (k21.d(this.minPeopleCount, this.maxPeopleCount)) {
            return this.minPeopleCount + (char) 20154;
        } else {
            return this.minPeopleCount + '-' + this.maxPeopleCount + (char) 20154;
        }
    }

    @Nullable
    public final String getPeopleDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "931342829")) {
            return this.peopleDesc;
        }
        return (String) ipChange.ipc$dispatch("931342829", new Object[]{this});
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-474324914")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("-474324914", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getTagList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1169646887")) {
            return this.tagList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1169646887", new Object[]{this});
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1814290024")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("-1814290024", new Object[]{this});
    }

    public final void setCostTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490187223")) {
            ipChange.ipc$dispatch("490187223", new Object[]{this, str});
            return;
        }
        this.costTime = str;
    }

    public final void setDescLocal(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469349037")) {
            ipChange.ipc$dispatch("-469349037", new Object[]{this, str});
            return;
        }
        this.descLocal = str;
    }

    public final void setFemaleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444413526")) {
            ipChange.ipc$dispatch("-1444413526", new Object[]{this, str});
            return;
        }
        this.femaleCount = str;
    }

    public final void setGrade(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966934026")) {
            ipChange.ipc$dispatch("-1966934026", new Object[]{this, str});
            return;
        }
        this.grade = str;
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350012165")) {
            ipChange.ipc$dispatch("350012165", new Object[]{this, arrayList});
            return;
        }
        this.highlightWord = arrayList;
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159352042")) {
            ipChange.ipc$dispatch("-1159352042", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public final void setItemScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328790158")) {
            ipChange.ipc$dispatch("1328790158", new Object[]{this, str});
            return;
        }
        this.itemScore = str;
    }

    public final void setItemStar(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143216876")) {
            ipChange.ipc$dispatch("1143216876", new Object[]{this, str});
            return;
        }
        this.itemStar = str;
    }

    public final void setManCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49040668")) {
            ipChange.ipc$dispatch("49040668", new Object[]{this, str});
            return;
        }
        this.manCount = str;
    }

    public final void setMaxPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757171733")) {
            ipChange.ipc$dispatch("757171733", new Object[]{this, str});
            return;
        }
        this.maxPeopleCount = str;
    }

    public final void setMinPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733105923")) {
            ipChange.ipc$dispatch("733105923", new Object[]{this, str});
            return;
        }
        this.minPeopleCount = str;
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227881766")) {
            ipChange.ipc$dispatch("1227881766", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setPeopleDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991940497")) {
            ipChange.ipc$dispatch("991940497", new Object[]{this, str});
            return;
        }
        this.peopleDesc = str;
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080704848")) {
            ipChange.ipc$dispatch("1080704848", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public final void setTagList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788677121")) {
            ipChange.ipc$dispatch("-1788677121", new Object[]{this, arrayList});
            return;
        }
        this.tagList = arrayList;
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010132190")) {
            ipChange.ipc$dispatch("1010132190", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}

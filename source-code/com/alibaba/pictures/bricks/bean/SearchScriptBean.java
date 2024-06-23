package com.alibaba.pictures.bricks.bean;

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
        if (AndroidInstantRuntime.support(ipChange, "-493212272")) {
            return (String) ipChange.ipc$dispatch("-493212272", new Object[]{this});
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
        if (!AndroidInstantRuntime.support(ipChange, "-210682591")) {
            return this.costTime;
        }
        return (String) ipChange.ipc$dispatch("-210682591", new Object[]{this});
    }

    @Nullable
    public final String getDescLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1590623351")) {
            return this.descLocal;
        }
        return (String) ipChange.ipc$dispatch("-1590623351", new Object[]{this});
    }

    @Nullable
    public final String getFemaleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1728016942")) {
            return this.femaleCount;
        }
        return (String) ipChange.ipc$dispatch("-1728016942", new Object[]{this});
    }

    @Nullable
    public final String getGrade() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1754894726")) {
            return this.grade;
        }
        return (String) ipChange.ipc$dispatch("1754894726", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1632703309")) {
            return this.highlightWord;
        }
        return (ArrayList) ipChange.ipc$dispatch("1632703309", new Object[]{this});
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2137230466")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("2137230466", new Object[]{this});
    }

    @Nullable
    public final String getItemScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1515422446")) {
            return this.itemScore;
        }
        return (String) ipChange.ipc$dispatch("1515422446", new Object[]{this});
    }

    @Nullable
    public final String getItemStar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1990732436")) {
            return this.itemStar;
        }
        return (String) ipChange.ipc$dispatch("-1990732436", new Object[]{this});
    }

    @Nullable
    public final String getManCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "883465532")) {
            return this.manCount;
        }
        return (String) ipChange.ipc$dispatch("883465532", new Object[]{this});
    }

    @Nullable
    public final String getMaxPeopleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1197737635")) {
            return this.maxPeopleCount;
        }
        return (String) ipChange.ipc$dispatch("1197737635", new Object[]{this});
    }

    @Nullable
    public final String getMinPeopleCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-465606667")) {
            return this.minPeopleCount;
        }
        return (String) ipChange.ipc$dispatch("-465606667", new Object[]{this});
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "954993394")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("954993394", new Object[]{this});
    }

    @Nullable
    public final String getPeopleCountDesc() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-361425376")) {
            return (String) ipChange.ipc$dispatch("-361425376", new Object[]{this});
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
        if (!AndroidInstantRuntime.support(ipChange, "1665770663")) {
            return this.peopleDesc;
        }
        return (String) ipChange.ipc$dispatch("1665770663", new Object[]{this});
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1743828984")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("-1743828984", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getTagList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-435219053")) {
            return this.tagList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-435219053", new Object[]{this});
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "16049182")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("16049182", new Object[]{this});
    }

    public final void setCostTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118520867")) {
            ipChange.ipc$dispatch("-2118520867", new Object[]{this, str});
            return;
        }
        this.costTime = str;
    }

    public final void setDescLocal(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265078797")) {
            ipChange.ipc$dispatch("265078797", new Object[]{this, str});
            return;
        }
        this.descLocal = str;
    }

    public final void setFemaleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33901596")) {
            ipChange.ipc$dispatch("-33901596", new Object[]{this, str});
            return;
        }
        this.femaleCount = str;
    }

    public final void setGrade(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058529200")) {
            ipChange.ipc$dispatch("1058529200", new Object[]{this, str});
            return;
        }
        this.grade = str;
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122921739")) {
            ipChange.ipc$dispatch("122921739", new Object[]{this, arrayList});
            return;
        }
        this.highlightWord = arrayList;
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670987164")) {
            ipChange.ipc$dispatch("670987164", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public final void setItemScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063217992")) {
            ipChange.ipc$dispatch("2063217992", new Object[]{this, str});
            return;
        }
        this.itemScore = str;
    }

    public final void setItemStar(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465491214")) {
            ipChange.ipc$dispatch("-1465491214", new Object[]{this, str});
            return;
        }
        this.itemStar = str;
    }

    public final void setManCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1735299874")) {
            ipChange.ipc$dispatch("1735299874", new Object[]{this, str});
            return;
        }
        this.manCount = str;
    }

    public final void setMaxPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641945701")) {
            ipChange.ipc$dispatch("-641945701", new Object[]{this, str});
            return;
        }
        this.maxPeopleCount = str;
    }

    public final void setMinPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666011511")) {
            ipChange.ipc$dispatch("-666011511", new Object[]{this, str});
            return;
        }
        this.minPeopleCount = str;
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752732628")) {
            ipChange.ipc$dispatch("-752732628", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setPeopleDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010600425")) {
            ipChange.ipc$dispatch("-2010600425", new Object[]{this, str});
            return;
        }
        this.peopleDesc = str;
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380784342")) {
            ipChange.ipc$dispatch("380784342", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public final void setTagList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496250747")) {
            ipChange.ipc$dispatch("-496250747", new Object[]{this, arrayList});
            return;
        }
        this.tagList = arrayList;
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916072728")) {
            ipChange.ipc$dispatch("1916072728", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}

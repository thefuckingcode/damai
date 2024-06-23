package com.youku.live.livesdk.preloader.templates;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.model.template.TemplateModel;

/* compiled from: Taobao */
public class AbsTemplate implements ITemplate {
    private static transient /* synthetic */ IpChange $ipChange;
    private String landscapeLayout;
    private TemplateModel landscapeModel;
    private String portraitLayout;
    private TemplateModel portraitModel;

    public AbsTemplate(String str, String str2, TemplateModel templateModel, TemplateModel templateModel2) {
        this.landscapeLayout = str;
        this.portraitLayout = str2;
        this.landscapeModel = templateModel;
        this.portraitModel = templateModel2;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getLandscapeLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1608180435")) {
            return this.landscapeLayout;
        }
        return (String) ipChange.ipc$dispatch("-1608180435", new Object[]{this});
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getLandscapeModel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1723418406")) {
            return this.landscapeModel;
        }
        return (TemplateModel) ipChange.ipc$dispatch("1723418406", new Object[]{this});
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getPortraitLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1274599987")) {
            return this.portraitLayout;
        }
        return (String) ipChange.ipc$dispatch("1274599987", new Object[]{this});
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getPortraitModel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-864927060")) {
            return this.portraitModel;
        }
        return (TemplateModel) ipChange.ipc$dispatch("-864927060", new Object[]{this});
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122600306")) {
            ipChange.ipc$dispatch("1122600306", new Object[]{this});
        }
    }
}

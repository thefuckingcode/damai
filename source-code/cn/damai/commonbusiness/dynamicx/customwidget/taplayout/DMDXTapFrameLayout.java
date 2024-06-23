package cn.damai.commonbusiness.dynamicx.customwidget.taplayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import tb.c31;
import tb.pc0;
import tb.pp2;

/* compiled from: Taobao */
public class DMDXTapFrameLayout extends DXNativeFrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isEnabled = true;
    private boolean isExposure;
    private Bundle jumpArgs;
    private String schema;
    private JSONArray spm;
    private JSONArray spmArgs;

    public DMDXTapFrameLayout(@NonNull Context context) {
        super(context);
    }

    private JSONArray getSpmArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702725408")) {
            return (JSONArray) ipChange.ipc$dispatch("-702725408", new Object[]{this});
        }
        JSONArray jSONArray = this.spmArgs;
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.get(2).toString().equals("contentlabel") && this.spmArgs.get(3).toString().equals("0")) {
                JSONArray jSONArray2 = new JSONArray();
                String str = "";
                for (int i = 0; i < this.spmArgs.size(); i++) {
                    if (i == 1) {
                        str = this.spmArgs.get(i).toString();
                        jSONArray2.add("五大金刚");
                    } else if (i == 3) {
                        jSONArray2.add(str);
                    } else {
                        jSONArray2.add(this.spmArgs.get(i));
                    }
                }
                return jSONArray2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.spmArgs;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-67787930")) {
            ipChange.ipc$dispatch("-67787930", new Object[]{this, view});
            return;
        }
        if (this.jumpArgs == null) {
            this.jumpArgs = new Bundle();
        }
        if (!TextUtils.isEmpty(this.schema)) {
            if (this.schema.contains("damai://") || this.schema.contains("http")) {
                DMNav.from(getContext()).withExtras(this.jumpArgs).toUri(this.schema);
            } else {
                DMNav.from(getContext()).withExtras(this.jumpArgs).toUri(NavUri.b(this.schema));
            }
            if ((this.schema.startsWith(pp2.SCHEME_CATEGORYPAGE) || this.schema.contains("category")) && (getContext() instanceof Activity)) {
                ((Activity) getContext()).overridePendingTransition(0, 0);
            }
            if (c31.b(this.spm) >= 3) {
                pc0.a(this.spm, getSpmArgs());
            }
        }
    }

    public void registerOnClickListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271853669")) {
            ipChange.ipc$dispatch("-1271853669", new Object[]{this});
        } else if (this.isEnabled) {
            setOnClickListener(this);
        }
    }

    public void setEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1429197570")) {
            ipChange.ipc$dispatch("-1429197570", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isEnabled = z;
    }

    public void setExposure(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734276344")) {
            ipChange.ipc$dispatch("-1734276344", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isExposure = z;
    }

    public void setJumpArgs(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87338288")) {
            ipChange.ipc$dispatch("-87338288", new Object[]{this, jSONArray});
            return;
        }
        this.jumpArgs = c31.a(jSONArray);
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065196740")) {
            ipChange.ipc$dispatch("-1065196740", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public void setSpm(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769780207")) {
            ipChange.ipc$dispatch("769780207", new Object[]{this, jSONArray});
            return;
        }
        this.spm = jSONArray;
    }

    public void setSpmArgs(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854450898")) {
            ipChange.ipc$dispatch("854450898", new Object[]{this, jSONArray});
            return;
        }
        this.spmArgs = jSONArray;
    }

    public void updateSPM() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932875758")) {
            ipChange.ipc$dispatch("1932875758", new Object[]{this});
        } else if (this.isExposure) {
            pc0.b(this, this.spm, getSpmArgs());
        }
    }

    public DMDXTapFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMDXTapFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

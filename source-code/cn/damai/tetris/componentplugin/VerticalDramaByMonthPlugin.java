package cn.damai.tetris.componentplugin;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.dramachannel.request.FollowRelationUpdateRequest;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.viewholder.FocusUiCall;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jv2;
import tb.s41;

/* compiled from: Taobao */
public class VerticalDramaByMonthPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isSectionRemoved = false;
    private DramaMonthBean mMonthBean;
    private RequestHolder mRequestHolder = new RequestHolder();
    private String mSectionId;

    public VerticalDramaByMonthPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
    }

    private void requestFocusChanged(final FocusUiCall focusUiCall, final DramaV1Bean dramaV1Bean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047162310")) {
            ipChange.ipc$dispatch("-1047162310", new Object[]{this, focusUiCall, dramaV1Bean});
        } else if (dramaV1Bean != null) {
            this.mComponentUi.startProgressDialog();
            boolean z = dramaV1Bean.focus;
            FollowRelationUpdateRequest followRelationUpdateRequest = new FollowRelationUpdateRequest();
            followRelationUpdateRequest.operateType = !z ? 1 : 0;
            followRelationUpdateRequest.targetId = dramaV1Bean.id;
            followRelationUpdateRequest.targetType = "5";
            this.mRequestHolder.a(followRelationUpdateRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
                /* class cn.damai.tetris.componentplugin.VerticalDramaByMonthPlugin.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-991243202")) {
                        ipChange.ipc$dispatch("-991243202", new Object[]{this, str, str2});
                        return;
                    }
                    ((ComponentPlugin) VerticalDramaByMonthPlugin.this).mComponentUi.stopProgressDialog();
                    ToastUtil.i(str2);
                }

                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange = $ipChange;
                    boolean z = false;
                    if (AndroidInstantRuntime.support(ipChange, "1939268066")) {
                        ipChange.ipc$dispatch("1939268066", new Object[]{this, followDataBean});
                        return;
                    }
                    ((ComponentPlugin) VerticalDramaByMonthPlugin.this).mComponentUi.stopProgressDialog();
                    if (!VerticalDramaByMonthPlugin.this.isSectionRemoved) {
                        if (followDataBean != null) {
                            DramaV1Bean dramaV1Bean = dramaV1Bean;
                            if (followDataBean.getStatus() != 0) {
                                z = true;
                            }
                            dramaV1Bean.focus = z;
                            focusUiCall.notifyFocusChanged(true);
                            return;
                        }
                        onFail("", "");
                    }
                }
            }));
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-304770812")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-304770812", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556082533")) {
            return ((Boolean) ipChange.ipc$dispatch("-556082533", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        if (i == 10553 && (obj instanceof jv2)) {
            jv2 jv2 = (jv2) obj;
            DramaV1Bean dramaV1Bean = jv2.c;
            FocusUiCall focusUiCall = jv2.a;
            String str = jv2.b;
            if (focusUiCall == null) {
                return true;
            }
            if (TextUtils.equals(str, this.mSectionId)) {
                requestFocusChanged(focusUiCall, dramaV1Bean);
                return true;
            }
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1584487736")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1584487736", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218895802")) {
            ipChange.ipc$dispatch("1218895802", new Object[]{this, iSection});
        } else if (iSection != null) {
            this.mSectionId = iSection.getSectionId();
            JSONObject item = iSection.getItem();
            if (item != null) {
                DramaMonthBean dramaMonthBean = (DramaMonthBean) s41.d(new NodeData(item), DramaMonthBean.class);
                this.mMonthBean = dramaMonthBean;
                if (dramaMonthBean != null) {
                    dramaMonthBean.utParamsInset();
                }
                iSection.setExtra(this.mMonthBean);
            }
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634247719")) {
            ipChange.ipc$dispatch("1634247719", new Object[]{this, iSection});
            return;
        }
        this.mMonthBean = null;
        this.mSectionId = null;
        this.isSectionRemoved = true;
        this.mRequestHolder.c();
    }
}

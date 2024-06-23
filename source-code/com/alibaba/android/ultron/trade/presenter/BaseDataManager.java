package com.alibaba.android.ultron.trade.presenter;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.DataInfo;
import com.alibaba.android.ultron.trade.data.request.PageInfo;
import com.alibaba.android.ultron.trade.data.request.a;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.LinkageType;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.ArrayList;
import java.util.List;
import tb.f1;
import tb.hn2;
import tb.jn2;
import tb.tr2;

/* compiled from: Taobao */
public abstract class BaseDataManager {
    private static final String TAG = "BaseDataManager";
    protected List<AdjustRequestPageListener> mAdjustPageListeners = new ArrayList();
    protected a mAdjustRequester;
    protected a mBuildRequester;
    protected Context mContext;
    protected a mCreateRequester;
    protected IDMContext mDataContext;
    protected hn2 mDataSource;
    protected List<BuildRequestPageListener> mPageListeners = new ArrayList();
    protected IPresenter mPresenter;

    /* compiled from: Taobao */
    public interface AdjustRequestPageListener {
        void onAdjustRequestFinish();
    }

    /* compiled from: Taobao */
    public interface BuildRequestPageListener {
        void onBuildRequestFinish(PageInfo pageInfo, DataInfo dataInfo);
    }

    public BaseDataManager(IPresenter iPresenter) {
        if (iPresenter != null) {
            this.mPresenter = iPresenter;
            this.mContext = iPresenter.getContext();
            initRequester();
            return;
        }
        throw new IllegalArgumentException("param presenter can not be null");
    }

    public List<AdjustRequestPageListener> getAdjustRequestPageListeners() {
        return this.mAdjustPageListeners;
    }

    public a getAdjustRequester() {
        return this.mAdjustRequester;
    }

    public List<BuildRequestPageListener> getBuildRequestPageListeners() {
        return this.mPageListeners;
    }

    public a getBuildRequester() {
        return this.mBuildRequester;
    }

    public a getCreateRequester() {
        return this.mCreateRequester;
    }

    public IDMContext getDataContext() {
        return this.mDataContext;
    }

    public hn2 getDataSource() {
        return this.mDataSource;
    }

    /* access modifiers changed from: protected */
    public abstract void initRequester();

    public void respondToLinkage(IDMComponent iDMComponent) {
        respondToLinkage(iDMComponent, null);
    }

    public abstract void sendRespondRequest(IDMComponent iDMComponent, jn2 jn2, boolean z, f1 f1Var, Object obj);

    public void setAdjustRequestPageListeners(AdjustRequestPageListener adjustRequestPageListener) {
        this.mAdjustPageListeners.add(adjustRequestPageListener);
    }

    public void setBuildRequestPageListener(BuildRequestPageListener buildRequestPageListener) {
        this.mPageListeners.add(buildRequestPageListener);
    }

    public void setDataContext(IDMContext iDMContext) {
        this.mDataContext = iDMContext;
    }

    public void setDataSource(hn2 hn2) {
        this.mDataSource = hn2;
    }

    public void respondToLinkage(IDMComponent iDMComponent, jn2 jn2) {
        respondToLinkage(iDMComponent, jn2, true, null, null);
    }

    public void respondToLinkage(IDMComponent iDMComponent, jn2 jn2, boolean z, f1 f1Var, Object obj) {
        if (iDMComponent != null) {
            if (iDMComponent.getLinkageType() == LinkageType.REFRESH) {
                this.mPresenter.getViewManager().refreshCurrentContainer();
                return;
            }
            tr2.b(TAG, "respondToLinkage", "开始请求");
            sendRespondRequest(iDMComponent, jn2, z, f1Var, obj);
        }
    }
}

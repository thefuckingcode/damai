package com.youku.live.dago.liveplayback.widget.plugins.dlna.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.AssertEx;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.DlnaQualityInfo;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.yunos.tvhelper.ui.app.UiAppDef;
import com.yunos.tvhelper.ui.app.popup.PopupBase;
import com.yunos.tvhelper.ui.app.popup.PopupDef;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class QualityPopup extends PopupBase {
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.dlna.view.QualityPopup.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1388231999")) {
                return QualityPopup.this.mItems.size();
            }
            return ((Integer) ipChange.ipc$dispatch("1388231999", new Object[]{this})).intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1904028582")) {
                ipChange.ipc$dispatch("-1904028582", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            DlnaQualityInfo dlnaQualityInfo = (DlnaQualityInfo) QualityPopup.this.mItems.get(i);
            ViewHolder viewHolder2 = (ViewHolder) ViewHolder.class.cast(viewHolder);
            TextView textView = viewHolder2.mTextView;
            ImageView imageView = viewHolder2.mTagView;
            if (dlnaQualityInfo.name.equalsIgnoreCase(LiveManager.StreamConfig.QTY_1080P)) {
                textView.setText("蓝光 1080P");
                imageView.setImageResource(R.drawable.dago_dlna_quality_vip);
            } else if (dlnaQualityInfo.name.startsWith("HDR")) {
                textView.setText("HDR");
                imageView.setImageResource(R.drawable.dago_dlna_quality_vip);
            } else if (dlnaQualityInfo.name.contains("720P")) {
                textView.setText(dlnaQualityInfo.name);
            } else {
                textView.setText(dlnaQualityInfo.name);
            }
            String charSequence = textView.getText().toString();
            String onGetCurQuality = QualityPopup.this.mListener.onGetCurQuality();
            if (charSequence == null || onGetCurQuality == null || !charSequence.equalsIgnoreCase(onGetCurQuality)) {
                viewHolder.itemView.setSelected(false);
            } else {
                viewHolder.itemView.setSelected(true);
            }
            ((ViewHolder) ViewHolder.class.cast(viewHolder)).mPos = i;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, com.youku.live.dago.liveplayback.widget.plugins.dlna.view.QualityPopup$ViewHolder, android.view.View$OnClickListener] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1740578596")) {
                return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1740578596", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            View inflate = LayoutInflater.from(QualityPopup.this.caller()).inflate(R.layout.proj_picker_popup_item_tag, viewGroup, false);
            ?? viewHolder = new ViewHolder(inflate);
            inflate.setOnClickListener(viewHolder);
            return viewHolder;
        }
    };
    private List<DlnaQualityInfo> mItems = new ArrayList();
    private DlnaDlg.QualityListener mListener;

    /* compiled from: Taobao */
    private class ViewHolder extends UiAppDef.SimpleViewHolder implements View.OnClickListener {
        private int mPos;
        public ImageView mTagView;
        public TextView mTextView;

        ViewHolder(View view) {
            super(view);
            this.mTextView = (TextView) view.findViewById(R.id.tv_name);
            this.mTagView = (ImageView) view.findViewById(R.id.iv_tag);
        }

        public void onClick(View view) {
            int i;
            if (QualityPopup.this.isShowing() && (i = this.mPos) >= 0 && i < QualityPopup.this.mItems.size()) {
                PopupDef.PopupDismissParam createNormal = PopupDef.PopupDismissParam.createNormal();
                createNormal.arg1 = this.mPos;
                QualityPopup.this.dismissIf(createNormal);
            }
        }
    }

    public QualityPopup(DlnaDlg.QualityListener qualityListener) {
        AssertEx.logic(qualityListener != null);
        this.mListener = qualityListener;
    }

    private String tag() {
        return LogEx.tag(this);
    }

    /* access modifiers changed from: protected */
    public View createContentView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.proj_picker_popup_new, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onContentViewCreated(LayoutInflater layoutInflater, View view) {
        RecyclerView recyclerView = (RecyclerView) view().findViewById(R.id.proj_picker_popup_list);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(caller()));
        recyclerView.setAdapter(this.mAdapter);
    }

    /* access modifiers changed from: protected */
    public void onPopupDismissedIf(PopupDef.PopupDismissParam popupDismissParam) {
        int i;
        QualityPopup.super.onPopupDismissedIf(popupDismissParam);
        if (popupDismissParam.isNormalDismiss()) {
            AssertEx.logic(popupDismissParam.arg1 >= 0 && popupDismissParam.arg1 < this.mItems.size());
            String tag = tag();
            LogEx.i(tag, "selected idx: " + popupDismissParam.arg1 + ", definition: " + this.mItems.get(popupDismissParam.arg1));
            i = popupDismissParam.arg1;
        } else {
            i = -1;
        }
        if (i >= 0) {
            this.mListener.onQualitySelected(caller(), this.mItems.get(i));
        }
        this.mItems.clear();
    }

    /* access modifiers changed from: protected */
    public void onPopupShow() {
        QualityPopup.super.onPopupShow();
        AssertEx.logic(this.mItems.isEmpty());
        this.mItems.addAll(this.mListener.onGetQualities());
        this.mAdapter.notifyDataSetChanged();
    }
}

package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners;

import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;

/* compiled from: Taobao */
public interface OnItemExtendInfoItemClickListener {
    IRichTextManager getRichTextManager(int i);

    void onExtendInfoImageItemClick(View view, int i, String str, String str2);

    void onExtendInfoMoreBtnClick(int i);
}

package com.ali.user.mobile.ui.widget;

import android.view.View;

/* compiled from: Taobao */
public abstract class MenuItemOnClickListener implements View.OnClickListener {
    private BottomMenuFragment bottomMenuFragment;
    private MenuItem menuItem;

    public MenuItemOnClickListener(BottomMenuFragment bottomMenuFragment2, MenuItem menuItem2) {
        this.bottomMenuFragment = bottomMenuFragment2;
        this.menuItem = menuItem2;
    }

    public void onClick(View view) {
        BottomMenuFragment bottomMenuFragment2 = this.bottomMenuFragment;
        if (bottomMenuFragment2 != null && bottomMenuFragment2.isVisible()) {
            try {
                this.bottomMenuFragment.dismiss();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        onClickMenuItem(view, this.menuItem);
    }

    public abstract void onClickMenuItem(View view, MenuItem menuItem2);
}

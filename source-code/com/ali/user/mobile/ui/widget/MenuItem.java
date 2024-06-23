package com.ali.user.mobile.ui.widget;

/* compiled from: Taobao */
public class MenuItem {
    public int bgColor;
    private MenuItemOnClickListener menuItemOnClickListener;
    private String text;
    public int textColor;
    public float textSize;

    public MenuItem() {
    }

    public MenuItemOnClickListener getMenuItemOnClickListener() {
        return this.menuItemOnClickListener;
    }

    public String getText() {
        return this.text;
    }

    public void setMenuItemOnClickListener(MenuItemOnClickListener menuItemOnClickListener2) {
        this.menuItemOnClickListener = menuItemOnClickListener2;
    }

    public void setText(String str) {
        this.text = str;
    }

    public MenuItem(String str, MenuItemOnClickListener menuItemOnClickListener2) {
        this.text = str;
        this.menuItemOnClickListener = menuItemOnClickListener2;
    }
}

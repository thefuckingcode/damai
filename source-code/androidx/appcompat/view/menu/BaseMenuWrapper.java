package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.mMenuItems.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, supportMenuItem);
        this.mMenuItems.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.mSubMenus.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.mContext, supportSubMenu);
        this.mSubMenus.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.mSubMenus;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveGroup(int i) {
        if (this.mMenuItems != null) {
            int i2 = 0;
            while (i2 < this.mMenuItems.size()) {
                if (this.mMenuItems.keyAt(i2).getGroupId() == i) {
                    this.mMenuItems.removeAt(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveItem(int i) {
        if (this.mMenuItems != null) {
            for (int i2 = 0; i2 < this.mMenuItems.size(); i2++) {
                if (this.mMenuItems.keyAt(i2).getItemId() == i) {
                    this.mMenuItems.removeAt(i2);
                    return;
                }
            }
        }
    }
}

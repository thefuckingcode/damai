package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.MenuItem;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import java.util.ArrayList;

/* compiled from: Taobao */
public class BaseHistoryFragment extends BaseLoginFragment {
    protected boolean faceLoginEnable = false;
    protected boolean fingerLoginEnable = false;
    protected String mCurrentSelectedAccount;
    protected TextView mMoreLoginTV;
    protected TextView mTitleView;
    protected boolean pwdLoginEnable = false;
    protected boolean smsLoginEnable = false;

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public int getLoginSite() {
        HistoryAccount historyAccount;
        if (!this.isHistoryMode || (historyAccount = this.mUserLoginActivity.mHistoryAccount) == null) {
            return DataProviderFactory.getDataProvider().getSite();
        }
        return historyAccount.getLoginSite();
    }

    /* access modifiers changed from: protected */
    public void initMode() {
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity.hadReadHistory) {
            this.isHistoryMode = true;
            switchToHistoryMode(userLoginActivity.mHistoryAccount);
            return;
        }
        this.isHistoryMode = false;
        switchMode(false, null);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginFragment
    public void initViews(View view) {
        super.initViews(view);
        this.mTitleView = (TextView) view.findViewById(R.id.aliuser_login_account_tv);
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_switch_more_login);
        this.mMoreLoginTV = textView;
        setOnClickListener(textView);
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mTitleView, this.mMoreLoginTV);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onClick(View view) {
        if (view.getId() == R.id.aliuser_login_switch_more_login) {
            addControl(UTConstans.Controls.UT_CHOOSE_OTHER);
            showBottomMore();
            return;
        }
        super.onClick(view);
    }

    /* access modifiers changed from: protected */
    public void showBottomMore() {
        BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
        ArrayList arrayList = new ArrayList();
        if (this.pwdLoginEnable) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(getString(R.string.aliuser_login_pwd_login));
            menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                /* class com.ali.user.mobile.login.ui.BaseHistoryFragment.AnonymousClass1 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseHistoryFragment.this.isActive()) {
                        BaseHistoryFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OHTER_PWD);
                        BaseHistoryFragment.this.switchToPwdLogin();
                    }
                }
            });
            arrayList.add(menuItem);
        }
        if (this.smsLoginEnable) {
            MenuItem menuItem2 = new MenuItem();
            menuItem2.setText(getString(R.string.aliuser_login_sms_login));
            menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) {
                /* class com.ali.user.mobile.login.ui.BaseHistoryFragment.AnonymousClass2 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseHistoryFragment.this.isActive()) {
                        BaseHistoryFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
                        BaseHistoryFragment.this.switchToSmsLogin();
                    }
                }
            });
            arrayList.add(menuItem2);
        }
        if (this.faceLoginEnable && !(this instanceof AliFingerLoginFragment) && !(this instanceof BaseFaceLoginFragment)) {
            MenuItem menuItem3 = new MenuItem();
            menuItem3.setText(getString(R.string.aliuser_scan_login_text));
            menuItem3.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem3) {
                /* class com.ali.user.mobile.login.ui.BaseHistoryFragment.AnonymousClass3 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseHistoryFragment.this.isActive()) {
                        BaseHistoryFragment.this.addCheckAction(LoginClickAction.ACTION_FACE);
                    }
                }
            });
            arrayList.add(menuItem3);
        }
        if (this.fingerLoginEnable && !(this instanceof AliFingerLoginFragment)) {
            MenuItem menuItem4 = new MenuItem();
            menuItem4.setText(getString(R.string.aliuser_finger_button_text));
            menuItem4.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem4) {
                /* class com.ali.user.mobile.login.ui.BaseHistoryFragment.AnonymousClass4 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseHistoryFragment.this.isActive()) {
                        BaseHistoryFragment.this.addCheckAction(LoginClickAction.ACTION_FINGER);
                    }
                }
            });
        }
        bottomMenuFragment.setMenuItems(arrayList);
        bottomMenuFragment.show(getFragmentManager(), getPageName());
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchAccount() {
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity != null) {
            userLoginActivity.gotoPwdLoginFragment(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void switchToHistoryMode(HistoryAccount historyAccount) {
        if (isActivityAvaiable() && historyAccount != null) {
            String str = historyAccount.userInputName;
            this.mCurrentSelectedAccount = str;
            String dataMasking = StringUtil.dataMasking(str);
            if (this.mTitleView != null && !TextUtils.isEmpty(dataMasking)) {
                this.mTitleView.setText(dataMasking);
            }
            updateAvatar(historyAccount.headImg);
            if (historyAccount.hasPwd == 1 && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                this.pwdLoginEnable = true;
            }
            if (DataProviderFactory.getDataProvider().supportFaceLogin()) {
                UserLoginActivity userLoginActivity = this.mUserLoginActivity;
                if (userLoginActivity.isFaceLoginEnvEnable || userLoginActivity.isFaceLoginActivate) {
                    this.faceLoginEnable = true;
                }
            }
            if (!TextUtils.isEmpty(historyAccount.loginPhone)) {
                if (historyAccount.alipayHid != 0) {
                    this.smsLoginEnable = false;
                } else if (DataProviderFactory.getDataProvider().supportMobileLogin()) {
                    this.smsLoginEnable = true;
                }
            }
            this.fingerLoginEnable = isFingerEnable(historyAccount);
            TextView textView = this.mMoreLoginTV;
            if (textView == null) {
                return;
            }
            if (this.smsLoginEnable || this.pwdLoginEnable) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void switchToPwdLogin() {
        Intent intent = new Intent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        this.mUserLoginActivity.gotoPwdLoginFragment(intent);
    }

    /* access modifiers changed from: protected */
    public void switchToSmsLogin() {
        Intent intent = new Intent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        this.mUserLoginActivity.gotoMobileLoginFragment(intent);
    }
}

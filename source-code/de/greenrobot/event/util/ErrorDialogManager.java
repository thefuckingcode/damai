package de.greenrobot.event.util;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import de.greenrobot.event.EventBus;
import tb.wk2;

/* compiled from: Taobao */
public class ErrorDialogManager {
    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";

    /* compiled from: Taobao */
    public static class SupportManagerFragment extends Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;
        private boolean skipRegisterOnNextResume;

        public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, "de.greenrobot.eventbus.error_dialog_manager").commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.finishAfterDialog = z;
            supportManagerFragment.argumentsForErrorDialog = bundle;
            supportManagerFragment.executionScope = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            throw null;
        }

        public void onEventMainThread(wk2 wk2) {
            if (ErrorDialogManager.c(this.executionScope, wk2)) {
                ErrorDialogManager.b(wk2);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                throw null;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.eventBus.p(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.skipRegisterOnNextResume) {
                this.skipRegisterOnNextResume = false;
                return;
            }
            throw null;
        }
    }

    protected static void b(wk2 wk2) {
        throw null;
    }

    /* access modifiers changed from: private */
    public static boolean c(Object obj, wk2 wk2) {
        return true;
    }
}

package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DialogTitle;
import androidx.appcompat.widget.FitWindowsFrameLayout;
import androidx.appcompat.widget.FitWindowsLinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.ViewStubCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ò\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+0\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002040\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\bR\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:0\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=0\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u001d\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020@0\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\bR\u001d\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020C0\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020F0\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\bR\u001d\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020I0\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u001d\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020L0\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\b¨\u0006N"}, d2 = {"org/jetbrains/anko/appcompat/v7/$$Anko$Factories$AppcompatV7View", "", "()V", "ACTION_BAR_CONTEXT_VIEW", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroidx/appcompat/widget/ActionBarContextView;", "getACTION_BAR_CONTEXT_VIEW", "()Lkotlin/jvm/functions/Function1;", "ACTION_MENU_ITEM_VIEW", "Landroidx/appcompat/view/menu/ActionMenuItemView;", "getACTION_MENU_ITEM_VIEW", "ACTIVITY_CHOOSER_VIEW", "Landroidx/appcompat/widget/ActivityChooserView;", "getACTIVITY_CHOOSER_VIEW", "CONTENT_FRAME_LAYOUT", "Landroidx/appcompat/widget/ContentFrameLayout;", "getCONTENT_FRAME_LAYOUT", "DIALOG_TITLE", "Landroidx/appcompat/widget/DialogTitle;", "getDIALOG_TITLE", "EXPANDED_MENU_VIEW", "Landroidx/appcompat/view/menu/ExpandedMenuView;", "getEXPANDED_MENU_VIEW", "FIT_WINDOWS_FRAME_LAYOUT", "Landroidx/appcompat/widget/FitWindowsFrameLayout;", "getFIT_WINDOWS_FRAME_LAYOUT", "FIT_WINDOWS_LINEAR_LAYOUT", "Landroidx/appcompat/widget/FitWindowsLinearLayout;", "getFIT_WINDOWS_LINEAR_LAYOUT", "SEARCH_VIEW", "Landroidx/appcompat/widget/SearchView;", "getSEARCH_VIEW", "SWITCH_COMPAT", "Landroidx/appcompat/widget/SwitchCompat;", "getSWITCH_COMPAT", "TINTED_AUTO_COMPLETE_TEXT_VIEW", "Landroid/widget/AutoCompleteTextView;", "getTINTED_AUTO_COMPLETE_TEXT_VIEW", "TINTED_BUTTON", "Landroid/widget/Button;", "getTINTED_BUTTON", "TINTED_CHECKED_TEXT_VIEW", "Landroid/widget/CheckedTextView;", "getTINTED_CHECKED_TEXT_VIEW", "TINTED_CHECK_BOX", "Landroid/widget/CheckBox;", "getTINTED_CHECK_BOX", "TINTED_EDIT_TEXT", "Landroid/widget/EditText;", "getTINTED_EDIT_TEXT", "TINTED_IMAGE_BUTTON", "Landroid/widget/ImageButton;", "getTINTED_IMAGE_BUTTON", "TINTED_IMAGE_VIEW", "Landroid/widget/ImageView;", "getTINTED_IMAGE_VIEW", "TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW", "Landroid/widget/MultiAutoCompleteTextView;", "getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW", "TINTED_RADIO_BUTTON", "Landroid/widget/RadioButton;", "getTINTED_RADIO_BUTTON", "TINTED_RATING_BAR", "Landroid/widget/RatingBar;", "getTINTED_RATING_BAR", "TINTED_SEEK_BAR", "Landroid/widget/SeekBar;", "getTINTED_SEEK_BAR", "TINTED_SPINNER", "Landroid/widget/Spinner;", "getTINTED_SPINNER", "TINTED_TEXT_VIEW", "Landroid/widget/TextView;", "getTINTED_TEXT_VIEW", "VIEW_STUB_COMPAT", "Landroidx/appcompat/widget/ViewStubCompat;", "getVIEW_STUB_COMPAT", "anko-appcompat-v7_release"}, k = 1, mv = {1, 1, 11})
/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View  reason: invalid class name */
/* compiled from: Views.kt */
public final class C$$Anko$Factories$AppcompatV7View {
    private static final Function1<Context, ActionBarContextView> ACTION_BAR_CONTEXT_VIEW = C$$Anko$Factories$AppcompatV7View$ACTION_BAR_CONTEXT_VIEW$1.INSTANCE;
    private static final Function1<Context, ActionMenuItemView> ACTION_MENU_ITEM_VIEW = C$$Anko$Factories$AppcompatV7View$ACTION_MENU_ITEM_VIEW$1.INSTANCE;
    private static final Function1<Context, ActivityChooserView> ACTIVITY_CHOOSER_VIEW = C$$Anko$Factories$AppcompatV7View$ACTIVITY_CHOOSER_VIEW$1.INSTANCE;
    private static final Function1<Context, ContentFrameLayout> CONTENT_FRAME_LAYOUT = C$$Anko$Factories$AppcompatV7View$CONTENT_FRAME_LAYOUT$1.INSTANCE;
    private static final Function1<Context, DialogTitle> DIALOG_TITLE = C$$Anko$Factories$AppcompatV7View$DIALOG_TITLE$1.INSTANCE;
    private static final Function1<Context, ExpandedMenuView> EXPANDED_MENU_VIEW = C$$Anko$Factories$AppcompatV7View$EXPANDED_MENU_VIEW$1.INSTANCE;
    private static final Function1<Context, FitWindowsFrameLayout> FIT_WINDOWS_FRAME_LAYOUT = C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_FRAME_LAYOUT$1.INSTANCE;
    private static final Function1<Context, FitWindowsLinearLayout> FIT_WINDOWS_LINEAR_LAYOUT = C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1.INSTANCE;
    public static final C$$Anko$Factories$AppcompatV7View INSTANCE = new C$$Anko$Factories$AppcompatV7View();
    private static final Function1<Context, SearchView> SEARCH_VIEW = C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1.INSTANCE;
    private static final Function1<Context, SwitchCompat> SWITCH_COMPAT = C$$Anko$Factories$AppcompatV7View$SWITCH_COMPAT$1.INSTANCE;
    private static final Function1<Context, AutoCompleteTextView> TINTED_AUTO_COMPLETE_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_AUTO_COMPLETE_TEXT_VIEW$1.INSTANCE;
    private static final Function1<Context, Button> TINTED_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_BUTTON$1.INSTANCE;
    private static final Function1<Context, CheckedTextView> TINTED_CHECKED_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_CHECKED_TEXT_VIEW$1.INSTANCE;
    private static final Function1<Context, CheckBox> TINTED_CHECK_BOX = C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1.INSTANCE;
    private static final Function1<Context, EditText> TINTED_EDIT_TEXT = C$$Anko$Factories$AppcompatV7View$TINTED_EDIT_TEXT$1.INSTANCE;
    private static final Function1<Context, ImageButton> TINTED_IMAGE_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_IMAGE_BUTTON$1.INSTANCE;
    private static final Function1<Context, ImageView> TINTED_IMAGE_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_IMAGE_VIEW$1.INSTANCE;
    private static final Function1<Context, MultiAutoCompleteTextView> TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW$1.INSTANCE;
    private static final Function1<Context, RadioButton> TINTED_RADIO_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_RADIO_BUTTON$1.INSTANCE;
    private static final Function1<Context, RatingBar> TINTED_RATING_BAR = C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1.INSTANCE;
    private static final Function1<Context, SeekBar> TINTED_SEEK_BAR = C$$Anko$Factories$AppcompatV7View$TINTED_SEEK_BAR$1.INSTANCE;
    private static final Function1<Context, Spinner> TINTED_SPINNER = C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1.INSTANCE;
    private static final Function1<Context, TextView> TINTED_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_TEXT_VIEW$1.INSTANCE;
    private static final Function1<Context, ViewStubCompat> VIEW_STUB_COMPAT = C$$Anko$Factories$AppcompatV7View$VIEW_STUB_COMPAT$1.INSTANCE;

    private C$$Anko$Factories$AppcompatV7View() {
    }

    public final Function1<Context, ActionMenuItemView> getACTION_MENU_ITEM_VIEW() {
        return ACTION_MENU_ITEM_VIEW;
    }

    public final Function1<Context, ExpandedMenuView> getEXPANDED_MENU_VIEW() {
        return EXPANDED_MENU_VIEW;
    }

    public final Function1<Context, ActionBarContextView> getACTION_BAR_CONTEXT_VIEW() {
        return ACTION_BAR_CONTEXT_VIEW;
    }

    public final Function1<Context, ActivityChooserView> getACTIVITY_CHOOSER_VIEW() {
        return ACTIVITY_CHOOSER_VIEW;
    }

    public final Function1<Context, AutoCompleteTextView> getTINTED_AUTO_COMPLETE_TEXT_VIEW() {
        return TINTED_AUTO_COMPLETE_TEXT_VIEW;
    }

    public final Function1<Context, Button> getTINTED_BUTTON() {
        return TINTED_BUTTON;
    }

    public final Function1<Context, CheckBox> getTINTED_CHECK_BOX() {
        return TINTED_CHECK_BOX;
    }

    public final Function1<Context, CheckedTextView> getTINTED_CHECKED_TEXT_VIEW() {
        return TINTED_CHECKED_TEXT_VIEW;
    }

    public final Function1<Context, EditText> getTINTED_EDIT_TEXT() {
        return TINTED_EDIT_TEXT;
    }

    public final Function1<Context, ImageButton> getTINTED_IMAGE_BUTTON() {
        return TINTED_IMAGE_BUTTON;
    }

    public final Function1<Context, ImageView> getTINTED_IMAGE_VIEW() {
        return TINTED_IMAGE_VIEW;
    }

    public final Function1<Context, MultiAutoCompleteTextView> getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW() {
        return TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW;
    }

    public final Function1<Context, RadioButton> getTINTED_RADIO_BUTTON() {
        return TINTED_RADIO_BUTTON;
    }

    public final Function1<Context, RatingBar> getTINTED_RATING_BAR() {
        return TINTED_RATING_BAR;
    }

    public final Function1<Context, SeekBar> getTINTED_SEEK_BAR() {
        return TINTED_SEEK_BAR;
    }

    public final Function1<Context, Spinner> getTINTED_SPINNER() {
        return TINTED_SPINNER;
    }

    public final Function1<Context, TextView> getTINTED_TEXT_VIEW() {
        return TINTED_TEXT_VIEW;
    }

    public final Function1<Context, ContentFrameLayout> getCONTENT_FRAME_LAYOUT() {
        return CONTENT_FRAME_LAYOUT;
    }

    public final Function1<Context, DialogTitle> getDIALOG_TITLE() {
        return DIALOG_TITLE;
    }

    public final Function1<Context, FitWindowsFrameLayout> getFIT_WINDOWS_FRAME_LAYOUT() {
        return FIT_WINDOWS_FRAME_LAYOUT;
    }

    public final Function1<Context, FitWindowsLinearLayout> getFIT_WINDOWS_LINEAR_LAYOUT() {
        return FIT_WINDOWS_LINEAR_LAYOUT;
    }

    public final Function1<Context, SearchView> getSEARCH_VIEW() {
        return SEARCH_VIEW;
    }

    public final Function1<Context, SwitchCompat> getSWITCH_COMPAT() {
        return SWITCH_COMPAT;
    }

    public final Function1<Context, ViewStubCompat> getVIEW_STUB_COMPAT() {
        return VIEW_STUB_COMPAT;
    }
}

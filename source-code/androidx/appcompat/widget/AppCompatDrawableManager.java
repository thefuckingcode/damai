package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* compiled from: Taobao */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                preload();
            }
            appCompatDrawableManager = INSTANCE;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() {
                    /* class androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1 */
                    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                    private final int[] TINT_CHECKABLE_BUTTON_LIST = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                    private final int[] TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] TINT_COLOR_CONTROL_STATE_LIST = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

                    private boolean arrayContains(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, 0);
                    }

                    private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
                        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
                        int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{disabledThemeAttrColor, ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
                    }

                    private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                    }

                    private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
                    }

                    private ColorStateList createSwitchThumbColorStateList(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        int i = R.attr.colorSwitchThumbNormal;
                        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i);
                        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = ThemeUtils.getThemeAttrColor(context, i);
                        } else {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = themeAttrColorStateList.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private LayerDrawable getRatingBarLayerDrawable(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DimenRes int i) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                        Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
                        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
                        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable2 = (BitmapDrawable) drawable;
                            bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            drawable.draw(canvas);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                        if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) drawable2;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            drawable2.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.DEFAULT_MODE;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i) {
                        if (i == R.drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                        } else if (i == R.drawable.abc_ratingbar_material) {
                            return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_big);
                        } else {
                            if (i == R.drawable.abc_ratingbar_indicator_material) {
                                return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_medium);
                            }
                            if (i == R.drawable.abc_ratingbar_small_material) {
                                return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_small);
                            }
                            return null;
                        }
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList getTintListForDrawableRes(@NonNull Context context, int i) {
                        if (i == R.drawable.abc_edit_text_material) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
                        }
                        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
                        }
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return createSwitchThumbColorStateList(context);
                        }
                        if (i == R.drawable.abc_btn_default_mtrl_shape) {
                            return createDefaultButtonColorStateList(context);
                        }
                        if (i == R.drawable.abc_btn_borderless_material) {
                            return createBorderlessButtonColorStateList(context);
                        }
                        if (i == R.drawable.abc_btn_colored_material) {
                            return createColoredButtonColorStateList(context);
                        }
                        if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
                        }
                        if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                            return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                        }
                        if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
                        }
                        if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
                        }
                        if (i == R.drawable.abc_seekbar_thumb_material) {
                            return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean tintDrawable(@NonNull Context context, int i, @NonNull Drawable drawable) {
                        if (i == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                            int i2 = R.attr.colorControlNormal;
                            setPorterDuffColorFilter(findDrawableByLayerId, ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        } else if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                            int i3 = R.attr.colorControlActivated;
                            setPorterDuffColorFilter(findDrawableByLayerId2, ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i, @NonNull Drawable drawable) {
                        int i2;
                        boolean z;
                        PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                        int i3 = 16842801;
                        if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                            i3 = R.attr.colorControlNormal;
                        } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                            i3 = R.attr.colorControlActivated;
                        } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                            mode = PorterDuff.Mode.MULTIPLY;
                        } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                            i3 = 16842800;
                            i2 = Math.round(40.8f);
                            z = true;
                            if (!z) {
                                return false;
                            }
                            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                drawable = drawable.mutate();
                            }
                            drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i3), mode));
                            if (i2 != -1) {
                                drawable.setAlpha(i2);
                            }
                            return true;
                        } else if (i != R.drawable.abc_dialog_material_background) {
                            i2 = -1;
                            z = false;
                            i3 = 0;
                            if (!z) {
                            }
                        }
                        i2 = -1;
                        z = true;
                        if (!z) {
                        }
                    }
                });
            }
        }
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    /* access modifiers changed from: package-private */
    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z) {
        return this.mResourceManager.getDrawable(context, i, z);
    }
}

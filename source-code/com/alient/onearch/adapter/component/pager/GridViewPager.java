package com.alient.onearch.adapter.component.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JX\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000220\u0010\u0010\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000f0\u000e0\u000b0\nJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0002@BX\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/GridViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "fixedDuration", "Ltb/ur2;", "fixScrollerSpeed", Constants.GAP, Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, Constants.Name.COLUMN_COUNT, "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "childAdapters", "setData", "notifyDataSetChanged", "height", "position", "setPagerHeights", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "listener", "setOnPageChangeListener", "value", "I", "setFixedDuration", "(I)V", "Lcom/alient/onearch/adapter/component/pager/GridPagerAdapter;", "pagerAdapter", "Lcom/alient/onearch/adapter/component/pager/GridPagerAdapter;", Constants.Name.DEFAULT_HEIGHT, "", "pagerHeightArray", "[I", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GridViewPager extends ViewPager {
    private int defaultHeight;
    private int fixedDuration = 500;
    private GridPagerAdapter pagerAdapter;
    private int[] pagerHeightArray;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridViewPager(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        fixScrollerSpeed(500);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            /* class com.alient.onearch.adapter.component.pager.GridViewPager.AnonymousClass1 */
            final /* synthetic */ GridViewPager this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                int i3;
                int i4;
                if (this.this$0.pagerHeightArray != null) {
                    int[] iArr = this.this$0.pagerHeightArray;
                    k21.f(iArr);
                    if (i != iArr.length - 1 && this.this$0.defaultHeight != 0) {
                        int[] iArr2 = this.this$0.pagerHeightArray;
                        k21.f(iArr2);
                        if (iArr2[i] == 0) {
                            i3 = this.this$0.defaultHeight;
                        } else {
                            int[] iArr3 = this.this$0.pagerHeightArray;
                            k21.f(iArr3);
                            i3 = iArr3[i];
                        }
                        int[] iArr4 = this.this$0.pagerHeightArray;
                        k21.f(iArr4);
                        int i5 = i + 1;
                        if (iArr4[i5] == 0) {
                            i4 = this.this$0.defaultHeight;
                        } else {
                            int[] iArr5 = this.this$0.pagerHeightArray;
                            k21.f(iArr5);
                            i4 = iArr5[i5];
                        }
                        int i6 = (int) ((((float) i3) * (((float) 1) - f)) + (((float) i4) * f));
                        GridViewPager gridViewPager = this.this$0;
                        ViewGroup.LayoutParams layoutParams = gridViewPager.getLayoutParams();
                        layoutParams.height = i6;
                        ur2 ur2 = ur2.INSTANCE;
                        gridViewPager.setLayoutParams(layoutParams);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
    }

    private final void fixScrollerSpeed(int i) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            k21.h(declaredField, "mScroller");
            declaredField.setAccessible(true);
            Context context = getContext();
            k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
            declaredField.set(this, new FixedSpeedScroller(context, i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setFixedDuration(int i) {
        this.fixedDuration = i;
        fixScrollerSpeed(i);
    }

    public final void notifyDataSetChanged() {
        PagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void setData(int i, int i2, int i3, int i4, @NotNull List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        k21.i(list, "childAdapters");
        if (!list.isEmpty()) {
            Context context = getContext();
            k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
            GridPagerAdapter gridPagerAdapter = new GridPagerAdapter(context, i, i2, i3, i4, list);
            this.pagerAdapter = gridPagerAdapter;
            setAdapter(gridPagerAdapter);
            this.pagerHeightArray = new int[list.size()];
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(@NotNull ViewPager.OnPageChangeListener onPageChangeListener) {
        k21.i(onPageChangeListener, "listener");
        addOnPageChangeListener(onPageChangeListener);
    }

    public final void setPagerHeights(int i, int i2) {
        if (i > 0) {
            int[] iArr = this.pagerHeightArray;
            int i3 = 0;
            if ((iArr != null ? iArr.length : 0) > 0) {
                if (iArr != null) {
                    i3 = iArr.length;
                }
                if (i3 > i2) {
                    k21.f(iArr);
                    iArr[i2] = i;
                    if (i2 == 0 && this.defaultHeight == 0) {
                        this.defaultHeight = i;
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        layoutParams.height = i;
                        ur2 ur2 = ur2.INSTANCE;
                        setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        fixScrollerSpeed(500);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            /* class com.alient.onearch.adapter.component.pager.GridViewPager.AnonymousClass1 */
            final /* synthetic */ GridViewPager this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                int i3;
                int i4;
                if (this.this$0.pagerHeightArray != null) {
                    int[] iArr = this.this$0.pagerHeightArray;
                    k21.f(iArr);
                    if (i != iArr.length - 1 && this.this$0.defaultHeight != 0) {
                        int[] iArr2 = this.this$0.pagerHeightArray;
                        k21.f(iArr2);
                        if (iArr2[i] == 0) {
                            i3 = this.this$0.defaultHeight;
                        } else {
                            int[] iArr3 = this.this$0.pagerHeightArray;
                            k21.f(iArr3);
                            i3 = iArr3[i];
                        }
                        int[] iArr4 = this.this$0.pagerHeightArray;
                        k21.f(iArr4);
                        int i5 = i + 1;
                        if (iArr4[i5] == 0) {
                            i4 = this.this$0.defaultHeight;
                        } else {
                            int[] iArr5 = this.this$0.pagerHeightArray;
                            k21.f(iArr5);
                            i4 = iArr5[i5];
                        }
                        int i6 = (int) ((((float) i3) * (((float) 1) - f)) + (((float) i4) * f));
                        GridViewPager gridViewPager = this.this$0;
                        ViewGroup.LayoutParams layoutParams = gridViewPager.getLayoutParams();
                        layoutParams.height = i6;
                        ur2 ur2 = ur2.INSTANCE;
                        gridViewPager.setLayoutParams(layoutParams);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
    }
}

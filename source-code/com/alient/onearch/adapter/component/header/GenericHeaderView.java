package com.alient.onearch.adapter.component.header;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.header.GenericHeaderContract;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.le1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010'\u001a\u00020*¢\u0006\u0004\b8\u00109J(\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010 \u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010!\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0019\u0010'\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010,\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderModel;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderPresent;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$View;", "", "leftTop", "rightTop", "leftBottom", "rightBottom", "", "getCornerRadii", "", "startColor", "endColor", "Ltb/ur2;", "renderBackground", "height", "renderHeight", "", "title", "renderTitle", "color", "renderTitleTextColor", "renderTitleRightTextColor", "url", "renderTitleRightImage", "text", "Lcom/alient/oneservice/nav/Action;", "action", "renderBtnOne", "renderBtnTwo", "hideBtnOne", "hideBtnTwo", "showRightArrow", "hideRightArrow", "Landroid/widget/TextView;", "view", "rightBtnClick", "Landroid/widget/TextView;", "Landroid/view/View;", "rightArrow", "Landroid/view/View;", "btnOne", "btnTwo", "Landroid/widget/ImageView;", "titleImage", "Landroid/widget/ImageView;", OneArchConstants.LayoutKey.TITLE_RIGHT_IMAGE, "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericHeaderView extends AbsView<GenericItem<ItemValue>, GenericHeaderModel, GenericHeaderPresent> implements GenericHeaderContract.View {
    private final TextView btnOne;
    private final TextView btnTwo;
    private final GradientDrawable gradientDrawable = new GradientDrawable();
    private final View rightArrow;
    private final TextView title;
    private final ImageView titleImage;
    private final ImageView titleRightImage;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericHeaderView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        this.title = (TextView) view2.findViewById(R.id.title);
        this.rightArrow = view2.findViewById(R.id.right_arrow);
        this.btnOne = (TextView) view2.findViewById(R.id.action_one);
        this.btnTwo = (TextView) view2.findViewById(R.id.action_two);
        this.titleImage = (ImageView) view2.findViewById(R.id.title_image);
        this.titleRightImage = (ImageView) view2.findViewById(R.id.title_right_image);
    }

    private final float[] getCornerRadii(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideBtnOne() {
        TextView textView = this.btnOne;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideBtnTwo() {
        TextView textView = this.btnTwo;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideRightArrow() {
        View view2 = this.rightArrow;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBackground(int i, int i2) {
        this.gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        this.gradientDrawable.setColors(new int[]{i, i2});
        Integer headerCorner = ((GenericHeaderModel) ((GenericHeaderPresent) getPresenter()).getModel()).getHeaderCorner();
        if (headerCorner != null) {
            float intValue = (float) headerCorner.intValue();
            this.gradientDrawable.setCornerRadii(getCornerRadii(intValue, intValue, 0.0f, 0.0f));
        }
        this.view.setBackground(this.gradientDrawable);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBtnOne(@Nullable String str, @Nullable Action action) {
        TextView textView = this.btnOne;
        if (textView != null) {
            textView.setText(str);
            textView.setVisibility(0);
            if (action != null) {
                textView.setOnClickListener(new GenericHeaderView$renderBtnOne$$inlined$apply$lambda$1(textView, this, str, action));
                UserTrackProviderProxy.expose(textView, action.getTrackInfo());
            }
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBtnTwo(@Nullable String str, @Nullable Action action) {
        TextView textView = this.btnTwo;
        if (textView != null) {
            textView.setText(str);
            textView.setVisibility(0);
            if (action != null) {
                textView.setOnClickListener(new GenericHeaderView$renderBtnTwo$$inlined$apply$lambda$1(textView, this, str, action));
                UserTrackProviderProxy.expose(textView, action.getTrackInfo());
            }
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderHeight(int i) {
        if (i != 0) {
            this.view.getLayoutParams().height = i;
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitle(@Nullable String str) {
        TextPaint paint;
        if (Patterns.WEB_URL.matcher(str).matches()) {
            TextView textView = this.title;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageLoaderProviderProxy.getProxy().load(str, new GenericHeaderView$renderTitle$1(this), new GenericHeaderView$renderTitle$2(this));
            return;
        }
        ImageView imageView = this.titleImage;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.titleImage;
        if (imageView2 != null) {
            imageView2.setImageBitmap(null);
        }
        TextView textView2 = this.title;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.title;
        if (!(textView3 == null || (paint = textView3.getPaint()) == null)) {
            paint.setFakeBoldText(true);
        }
        TextView textView4 = this.title;
        if (textView4 != null) {
            textView4.setText(str);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleRightImage(@Nullable String str) {
        ImageView imageView = this.titleRightImage;
        if (imageView != null) {
            if (str == null || str.length() == 0) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            le1.a aVar = le1.Companion;
            Context context = this.view.getContext();
            k21.h(context, "view.context");
            aVar.a(context).j(str).g(imageView);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleRightTextColor(int i) {
        TextView textView = this.btnOne;
        if (textView != null) {
            textView.setTextColor(i);
        }
        TextView textView2 = this.btnTwo;
        if (textView2 != null) {
            textView2.setTextColor(i);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleTextColor(int i) {
        TextView textView = this.title;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void rightBtnClick(@NotNull TextView textView, @NotNull Action action) {
        k21.i(textView, "view");
        k21.i(action, "action");
        NavProviderProxy.toUri(textView.getContext(), action);
        UserTrackProviderProxy.click(textView, action.getTrackInfo(), true);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void showRightArrow() {
        View view2 = this.rightArrow;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }
}

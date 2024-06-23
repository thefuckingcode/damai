package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(@NonNull FrameLayout frameLayout) {
        super(frameLayout);
    }

    @NonNull
    static FragmentViewHolder create(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}

package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchSuggest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class SearchWordViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_word));
    private Context b;

    public SearchWordViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_word, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.b = context;
    }

    public void a(SearchSuggest searchSuggest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335497376")) {
            ipChange.ipc$dispatch("335497376", new Object[]{this, searchSuggest});
        } else if (searchSuggest != null) {
            try {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(searchSuggest.sugWord);
                Matcher matcher = Pattern.compile(searchSuggest.keyword).matcher(searchSuggest.sugWord);
                while (true) {
                    if (!matcher.find()) {
                        break;
                    }
                    int start = matcher.start();
                    if (start == -1) {
                        break;
                    } else if (start >= 0) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.b, R$color.color_FF2D79)), start, searchSuggest.keyword.length() + start, 18);
                    }
                }
                this.a.setText(spannableStringBuilder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

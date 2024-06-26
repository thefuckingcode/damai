package cn.damai.tetris.component.ip;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.ip.IpInfoContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.uikit.view.ScoreStarViewV2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IpInfoView extends AbsView<IpInfoContract.Presenter> implements IpInfoContract.View<IpInfoContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private View haveSeen;
    TextView ipDesc;
    ImageView ipImg;
    TextView ipName;
    TextView ipScore;
    TextView ipScoreDesc;
    TextView ipUv;
    private Context mContext;
    ScoreStarViewV2 ratingBar;
    private View scoreTip;
    TextView userComment;
    ImageView userImg;
    private View wannaSee;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.tetris.component.ip.IpInfoView$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class DialogInterface$OnClickListenerC0049a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0049a(a aVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1606737906")) {
                    ipChange.ipc$dispatch("1606737906", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "555427792")) {
                ipChange.ipc$dispatch("555427792", new Object[]{this, view});
                return;
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(IpInfoView.this.mContext);
            dMThemeDialog.k("粉丝数解释说明文案\n粉丝数解释说明文案继续选购").i("知道了", new DialogInterface$OnClickListenerC0049a(this)).g(false, null);
            dMThemeDialog.show();
        }
    }

    public IpInfoView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.scoreTip = view.findViewById(R$id.ipinfo_score_title_icon);
        this.haveSeen = view.findViewById(R$id.ipinfo_showinfo_haveseen);
        this.wannaSee = view.findViewById(R$id.ipinfo_showinfo_wannasee);
        this.ipImg = (ImageView) view.findViewById(R$id.ipinfo_showinfo_img);
        this.ipName = (TextView) view.findViewById(R$id.ipinfo_showinfo_title);
        this.ipDesc = (TextView) view.findViewById(R$id.ipinfo_showinfo_type);
        this.ipUv = (TextView) view.findViewById(R$id.ipinfo_showinfo_favnum);
        this.ipScore = (TextView) view.findViewById(R$id.ipinfo_score_value);
        this.ipScoreDesc = (TextView) view.findViewById(R$id.ipinfo_score_desc);
        this.ratingBar = (ScoreStarViewV2) view.findViewById(R$id.ipinfo_score_ratingbar);
        this.userImg = (ImageView) view.findViewById(R$id.ipinfo_score_userimg);
        this.userComment = (TextView) view.findViewById(R$id.ipinfo_score_usertext);
        view.findViewById(R$id.tv_fans_icon_tip).setOnClickListener(new a());
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public View getHaveSeen() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "718847841")) {
            return this.haveSeen;
        }
        return (View) ipChange.ipc$dispatch("718847841", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getIpDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "555424286")) {
            return this.ipDesc;
        }
        return (TextView) ipChange.ipc$dispatch("555424286", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public ImageView getIpImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "688758116")) {
            return this.ipImg;
        }
        return (ImageView) ipChange.ipc$dispatch("688758116", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getIpName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-649924124")) {
            return this.ipName;
        }
        return (TextView) ipChange.ipc$dispatch("-649924124", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getIpScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-892976783")) {
            return this.ipScore;
        }
        return (TextView) ipChange.ipc$dispatch("-892976783", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getIpScoreDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-106224608")) {
            return this.ipScoreDesc;
        }
        return (TextView) ipChange.ipc$dispatch("-106224608", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getIpUv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-512302706")) {
            return this.ipUv;
        }
        return (TextView) ipChange.ipc$dispatch("-512302706", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public ScoreStarViewV2 getRatingBar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1225415872")) {
            return this.ratingBar;
        }
        return (ScoreStarViewV2) ipChange.ipc$dispatch("1225415872", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public View getScoreTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "517483131")) {
            return this.scoreTip;
        }
        return (View) ipChange.ipc$dispatch("517483131", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public TextView getUserComment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-960079896")) {
            return this.userComment;
        }
        return (TextView) ipChange.ipc$dispatch("-960079896", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public ImageView getUserImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1457126144")) {
            return this.userImg;
        }
        return (ImageView) ipChange.ipc$dispatch("1457126144", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpInfoContract.View
    public View getWannaSee() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1535695928")) {
            return this.wannaSee;
        }
        return (View) ipChange.ipc$dispatch("-1535695928", new Object[]{this});
    }
}

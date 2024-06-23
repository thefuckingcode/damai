package com.youku.live.dago.liveplayback.widget.plugins.verticalfull;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract;
import com.youku.live.dago.liveplayback.widget.view.CircleImageView;
import com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar;

/* compiled from: Taobao */
public class VerticalFullControlView extends LazyInflatedView implements VerticalFullControlContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup mBottomContainer;
    private CircleImageView mControlButton;
    private VerticalFullControlContract.LayoutParams mLayoutParams;
    private TextView mLeftText;
    private VerticalFullControlContract.Presenter mPresenter;
    private TextView mRightText;
    private PlayerSeekBar mSeekBar;

    public VerticalFullControlView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str, ViewPlaceholder viewPlaceholder) {
        super(context, iLMLayerManager, str, R.layout.player_vertical_fullscreen_plugin, viewPlaceholder);
    }

    private void refreshLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428353072")) {
            ipChange.ipc$dispatch("428353072", new Object[]{this});
        } else if (this.mLayoutParams != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mControlButton.getLayoutParams();
            VerticalFullControlContract.LayoutParams layoutParams2 = this.mLayoutParams;
            layoutParams.width = layoutParams2.mBtnWidth;
            layoutParams.height = layoutParams2.mBtnHeight;
            layoutParams.leftMargin = layoutParams2.mBtnLeft;
            layoutParams.bottomMargin = layoutParams2.mBtnBottom;
            this.mControlButton.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mSeekBar.getLayoutParams();
            VerticalFullControlContract.LayoutParams layoutParams4 = this.mLayoutParams;
            layoutParams3.width = layoutParams4.mSeekbarWidth;
            layoutParams3.leftMargin = layoutParams4.mSeekbarLeft;
            layoutParams3.bottomMargin = (layoutParams4.mSeekbarBottom - layoutParams.bottomMargin) - layoutParams4.mBtnHeight;
            this.mSeekBar.setLayoutParams(layoutParams3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185393061")) {
            ipChange.ipc$dispatch("1185393061", new Object[]{this, view});
            return;
        }
        this.mLeftText = (TextView) view.findViewById(R.id.time_left);
        this.mRightText = (TextView) view.findViewById(R.id.time_right);
        this.mBottomContainer = (ViewGroup) view.findViewById(R.id.bottom_container);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.play_control_btn);
        this.mControlButton = circleImageView;
        circleImageView.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "294621235")) {
                    ipChange.ipc$dispatch("294621235", new Object[]{this, view});
                    return;
                }
                VerticalFullControlView.this.mPresenter.onControlBtnClicked();
            }
        });
        this.mSeekBar = (PlayerSeekBar) view.findViewById(R.id.player_seekbar);
        this.mSeekBar.setThumbSizeOnDragging((float) (((int) view.getContext().getResources().getDimension(R.dimen.resource_size_40)) / 2));
        this.mSeekBar.setTrackPadding(0.0f);
        int dimension = ((int) view.getContext().getResources().getDimension(R.dimen.resource_size_12)) * 2;
        this.mSeekBar.setPadding(0, dimension, 0, dimension);
        this.mSeekBar.setOnSeekBarChangeListener(new PlayerSeekBar.OnSeekBarChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onBackClicked(long j, long j2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-329680026")) {
                    ipChange.ipc$dispatch("-329680026", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onProgressChanged(PlayerSeekBar playerSeekBar, long j, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "108250672")) {
                    ipChange.ipc$dispatch("108250672", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z)});
                } else if (z) {
                    VerticalFullControlView.this.mSeekBar.setProgress((float) j);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(PlayerSeekBar playerSeekBar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-232299009")) {
                    ipChange.ipc$dispatch("-232299009", new Object[]{this, playerSeekBar});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(PlayerSeekBar playerSeekBar, long j, boolean z, boolean z2, long j2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "874739169")) {
                    ipChange.ipc$dispatch("874739169", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)});
                    return;
                }
                VerticalFullControlView.this.mPresenter.seekTo(playerSeekBar.getProgress());
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onTrackingPressDown(PlayerSeekBar playerSeekBar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2140007865")) {
                    ipChange.ipc$dispatch("2140007865", new Object[]{this, playerSeekBar});
                }
            }
        });
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1499607481")) {
                    ipChange.ipc$dispatch("-1499607481", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                } else if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
                    VerticalFullControlView.this.show();
                }
            }
        });
    }

    @Override // com.youku.alixplugin.view.BaseView, com.youku.alixplugin.view.LazyInflatedView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544780440")) {
            ipChange.ipc$dispatch("544780440", new Object[]{this});
            return;
        }
        super.show();
        IPlayerContainer playerContainer = this.mPresenter.getPlayerContext().getPlayerContainer();
        IAlixPlayer.State currentState = playerContainer.getPlayer().getCurrentState();
        this.mControlButton.setVisibility(0);
        refreshLayout();
        this.mControlButton.setImageResource(currentState == IAlixPlayer.State.STATE_VIDEO_STARTED ? R.drawable.btn_pause_live : R.drawable.btn_play_live);
        this.mSeekBar.setVisibility(0);
        this.mLeftText.setVisibility(0);
        this.mRightText.setVisibility(0);
        long currentPosition = playerContainer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL);
        long duration = playerContainer.getPlayer().getDuration();
        this.mSeekBar.setMax((long) ((int) duration));
        this.mSeekBar.setProgress((float) currentPosition);
        this.mLeftText.setText(Utils.getFormathourTime(currentPosition));
        this.mRightText.setText(Utils.getFormathourTime(duration));
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract.View
    public void updateLayoutParams(VerticalFullControlContract.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257335394")) {
            ipChange.ipc$dispatch("-1257335394", new Object[]{this, layoutParams});
            return;
        }
        this.mLayoutParams = layoutParams;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract.View
    public void updateProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331878916")) {
            ipChange.ipc$dispatch("1331878916", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setProgress((float) i);
        }
        TextView textView = this.mLeftText;
        if (textView != null) {
            textView.setText(Utils.getFormathourTime((long) i));
        }
    }

    public void setPresenter(VerticalFullControlContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880714131")) {
            ipChange.ipc$dispatch("-880714131", new Object[]{this, presenter});
            return;
        }
        this.mPresenter = presenter;
    }
}

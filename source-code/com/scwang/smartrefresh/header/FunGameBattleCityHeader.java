package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* compiled from: Taobao */
public class FunGameBattleCityHeader extends FunGameView {
    protected static final int DEFAULT_BULLET_NUM_SPACING = 360;
    protected static final int DEFAULT_ENEMY_TANK_NUM_SPACING = 60;
    protected static final int DEFAULT_TANK_MAGIC_TOTAL_NUM = 8;
    protected static final float TANK_BARREL_RATIO = 0.33333334f;
    protected static int TANK_ROW_NUM = 3;
    protected int barrelSize;
    protected float bulletRadius;
    protected int bulletSpace;
    protected int bulletSpeed;
    protected SparseArray<Queue<RectF>> eTankSparseArray;
    protected int enemySpeed;
    protected int enemyTankSpace;
    protected int levelNum;
    protected Queue<Point> mBulletList;
    protected int offsetETankX;
    protected int offsetMBulletX;
    protected boolean once;
    protected int overstepNum;
    protected Random random;
    protected Point usedBullet;
    protected int wipeOutNum;

    public FunGameBattleCityHeader(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public int appearanceOption() {
        return this.random.nextInt(TANK_ROW_NUM);
    }

    /* access modifiers changed from: protected */
    public boolean checkTankCrash(int i, float f, float f2) {
        RectF peek = this.eTankSparseArray.get(i).peek();
        return peek != null && peek.contains(f, f2);
    }

    /* access modifiers changed from: protected */
    public boolean checkWipeOutETank(Point point) {
        int trackIndex = getTrackIndex(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        RectF peek = this.eTankSparseArray.get(trackIndex).peek();
        if (peek == null || !peek.contains((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) {
            return false;
        }
        int i = this.wipeOutNum + 1;
        this.wipeOutNum = i;
        if (i == this.levelNum) {
            upLevel();
        }
        this.eTankSparseArray.get(trackIndex).poll();
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawBullet(Canvas canvas, Point point) {
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) - this.bulletSpeed;
        point.x = xVar;
        canvas.drawCircle((float) xVar, (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), this.bulletRadius, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void drawBulletPath(Canvas canvas, int i) {
        this.mPaint.setColor(this.mModelColor);
        int i2 = this.offsetMBulletX + this.bulletSpeed;
        this.offsetMBulletX = i2;
        boolean z = false;
        if (i2 / this.bulletSpace == 1) {
            this.offsetMBulletX = 0;
        }
        if (this.offsetMBulletX == 0) {
            Point point = new Point();
            int i3 = this.controllerSize;
            point.x = (i - i3) - this.barrelSize;
            point.y = (int) (this.controllerPosition + (((float) i3) * 0.5f));
            this.mBulletList.offer(point);
        }
        for (Point point2 : this.mBulletList) {
            if (checkWipeOutETank(point2)) {
                this.usedBullet = point2;
            } else {
                if (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2)) + this.bulletRadius <= 0.0f) {
                    z = true;
                }
                drawBullet(canvas, point2);
            }
        }
        if (z) {
            this.mBulletList.poll();
        }
        this.mBulletList.remove(this.usedBullet);
        this.usedBullet = null;
    }

    /* access modifiers changed from: protected */
    public void drawEnemyTank(Canvas canvas, int i) {
        this.mPaint.setColor(this.lModelColor);
        int i2 = this.offsetETankX + this.enemySpeed;
        this.offsetETankX = i2;
        if (i2 / this.enemyTankSpace == 1 || this.once) {
            this.offsetETankX = 0;
            this.once = false;
        }
        int appearanceOption = appearanceOption();
        boolean z = false;
        for (int i3 = 0; i3 < TANK_ROW_NUM; i3++) {
            Queue<RectF> queue = this.eTankSparseArray.get(i3);
            if (this.offsetETankX == 0 && i3 == appearanceOption) {
                queue.offer(generateEnemyTank(i3));
            }
            Iterator<RectF> it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF next = it.next();
                if (next.left >= ((float) i)) {
                    int i4 = this.overstepNum + 1;
                    this.overstepNum = i4;
                    if (i4 >= 8) {
                        this.status = 2;
                        z = true;
                        break;
                    }
                    z = true;
                } else {
                    drawTank(canvas, next);
                }
            }
            if (this.status == 2) {
                break;
            }
            if (z) {
                queue.poll();
                z = false;
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    public void drawGame(Canvas canvas, int i, int i2) {
        drawSelfTank(canvas, i);
        int i3 = this.status;
        if (i3 == 1 || i3 == 3 || i3 == 4) {
            drawEnemyTank(canvas, i);
            drawBulletPath(canvas, i);
        }
        if (isInEditMode()) {
            int i4 = this.controllerSize;
            drawTank(canvas, new RectF((float) i4, 0.0f, (float) (i4 * 2), (float) i4));
            int i5 = this.controllerSize;
            drawTank(canvas, new RectF(0.0f, (float) i5, (float) i5, (float) (i5 * 2)));
            int i6 = this.controllerSize;
            drawTank(canvas, new RectF((float) (i6 * 3), (float) (i6 * 2), (float) (i6 * 4), (float) (i6 * 3)));
        }
    }

    /* access modifiers changed from: protected */
    public void drawSelfTank(Canvas canvas, int i) {
        this.mPaint.setColor(this.rModelColor);
        boolean checkTankCrash = checkTankCrash(getTrackIndex((int) this.controllerPosition), (float) (i - this.controllerSize), this.controllerPosition);
        int trackIndex = getTrackIndex((int) (this.controllerPosition + ((float) this.controllerSize)));
        int i2 = this.controllerSize;
        boolean checkTankCrash2 = checkTankCrash(trackIndex, (float) (i - i2), this.controllerPosition + ((float) i2));
        if (checkTankCrash || checkTankCrash2) {
            this.status = 2;
        }
        int i3 = this.controllerSize;
        float f = this.controllerPosition;
        float f2 = this.DIVIDING_LINE_SIZE;
        canvas.drawRect((float) (i - i3), f + f2, (float) i, f + ((float) i3) + f2, this.mPaint);
        int i4 = this.controllerSize;
        int i5 = this.barrelSize;
        float f3 = this.controllerPosition;
        canvas.drawRect((float) ((i - i4) - i5), f3 + (((float) (i4 - i5)) * 0.5f), (float) (i - i4), f3 + (((float) (i4 - i5)) * 0.5f) + ((float) i5), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void drawTank(Canvas canvas, RectF rectF) {
        float f = rectF.left;
        int i = this.enemySpeed;
        rectF.set(f + ((float) i), rectF.top, rectF.right + ((float) i), rectF.bottom);
        canvas.drawRect(rectF, this.mPaint);
        float f2 = rectF.top;
        int i2 = this.controllerSize;
        int i3 = this.barrelSize;
        float f3 = f2 + (((float) (i2 - i3)) * 0.5f);
        float f4 = rectF.right;
        canvas.drawRect(f4, f3, f4 + ((float) i3), f3 + ((float) i3), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public RectF generateEnemyTank(int i) {
        int i2 = this.controllerSize;
        float f = (float) (-(this.barrelSize + i2));
        float f2 = ((float) (i * i2)) + this.DIVIDING_LINE_SIZE;
        return new RectF(f, f2, (((float) this.barrelSize) * 2.5f) + f, ((float) this.controllerSize) + f2);
    }

    /* access modifiers changed from: protected */
    public int getTrackIndex(int i) {
        int i2 = this.mHeaderHeight;
        int i3 = TANK_ROW_NUM;
        int i4 = i / (i2 / i3);
        if (i4 >= i3) {
            i4 = i3 - 1;
        }
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.header.fungame.FunGameView, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.header.fungame.FunGameBase
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        int i3 = i / TANK_ROW_NUM;
        this.controllerSize = i3;
        int floor = (int) Math.floor((double) ((((float) i3) * TANK_BARREL_RATIO) + 0.5f));
        this.barrelSize = floor;
        this.bulletRadius = (((float) floor) - (this.DIVIDING_LINE_SIZE * 2.0f)) * 0.5f;
        super.onInitialized(refreshKernel, i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    public void resetConfigParams() {
        this.status = 0;
        this.controllerPosition = this.DIVIDING_LINE_SIZE;
        this.enemySpeed = DensityUtil.dp2px(1.0f);
        this.bulletSpeed = DensityUtil.dp2px(4.0f);
        this.levelNum = 8;
        this.wipeOutNum = 0;
        this.once = true;
        this.enemyTankSpace = this.controllerSize + this.barrelSize + 60;
        this.bulletSpace = 360;
        this.eTankSparseArray = new SparseArray<>();
        for (int i = 0; i < TANK_ROW_NUM; i++) {
            this.eTankSparseArray.put(i, new LinkedList());
        }
        this.mBulletList = new LinkedList();
    }

    /* access modifiers changed from: protected */
    public void upLevel() {
        this.levelNum += 8;
        this.enemySpeed += DensityUtil.dp2px(1.0f);
        this.bulletSpeed += DensityUtil.dp2px(1.0f);
        this.wipeOutNum = 0;
        int i = this.enemyTankSpace;
        if (i > 12) {
            this.enemyTankSpace = i - 12;
        }
        int i2 = this.bulletSpace;
        if (i2 > 30) {
            this.bulletSpace = i2 - 30;
        }
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enemySpeed = 1;
        this.bulletSpeed = 4;
        this.once = true;
        this.random = new Random();
    }
}

package com.spring.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView {

	public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	public CircleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	public CircleImageView(Context context) {
		super(context);
		init();
	}

	/**
	 * 矩形
	 */
	private final RectF roundRect = new RectF();
	/**
	 * 圆角的大小
	 */
	private float rect_adius = 10;
	/**
	 * 画笔
	 */
	private final Paint maskPaint = new Paint();
	/**
	 * 画笔
	 */
	private final Paint zonePaint = new Paint();

	private void init() {
		maskPaint.setAntiAlias(true);
		maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		zonePaint.setAntiAlias(true);
		zonePaint.setColor(Color.WHITE);
		float density = getResources().getDisplayMetrics().density;
		rect_adius = rect_adius * density;
	}

	public void setRectAdius(float adius) {
		rect_adius = adius;
		invalidate();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		int w = getWidth()-this.getPaddingRight();
		int h = getHeight()-this.getPaddingBottom();
		roundRect.set(this.getPaddingLeft(), this.getPaddingTop(), w, h);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
//		canvas.drawRoundRect(roundRect, rect_adius, rect_adius, zonePaint);
		canvas.drawCircle(roundRect.width()/2, roundRect.width()/2, roundRect.width()/2, zonePaint);
		canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
		super.draw(canvas);
		canvas.restore();
	}

	
}

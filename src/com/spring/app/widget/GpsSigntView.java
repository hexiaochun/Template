package com.spring.app.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class GpsSigntView extends View {

	public GpsSigntView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	public GpsSigntView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	public GpsSigntView(Context context) {
		super(context);
		init();
	}

	@SuppressLint("NewApi")
	private void init(){
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.WHITE);
		mPaint.setStyle(Style.STROKE);
		mPaint.setStrokeWidth(strokeWidth);
//		mPaint.setAlpha(0x88);
		rectF = new RectF(strokeWidth, strokeWidth, width-strokeWidth, height-strokeWidth);
		yellow = new RectF(strokeWidth*2,height*2/5, width-strokeWidth*2, height-strokeWidth*2);
		green = new RectF(strokeWidth*2,strokeWidth*2, width-strokeWidth*2, height-strokeWidth*2);
		  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			  this.setLayerType(View.LAYER_TYPE_SOFTWARE, mPaint);
		  }
	}
	
	private Paint mPaint ;
	private RectF rectF ;
	private RectF yellow ;
	private RectF green;
	private int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
	private int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
	private float radus = width/2;
	private float strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());

	private int level1_color = Color.RED;
	
	private int level2_color = Color.YELLOW;
	
	private int level3_color = Color.GREEN;
	
	private int status = 1;
	
	private boolean run = true;
	
	private int line_Color = Color.WHITE;
	
	public void setLine_Color(int line_Color) {
		this.line_Color = line_Color;
	}
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR1)
			  new TwinkleTask().execute();
			else
			  new TwinkleTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
		
	}
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		run = false;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
		invalidate();
	}
	int Interval = 500;
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(width, height);
	}
	
	class TwinkleTask extends AsyncTask<Integer, Integer, Integer>{
		@Override
		protected Integer doInBackground(Integer... params) {
			while (run) {
				try {
					Thread.sleep(Interval);
					if(status<=1)
						publishProgress(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return 0;
		}
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			status = (status+1)%2;
			invalidate();
//			update();
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPaint.setColor(line_Color);
		mPaint.setStyle(Style.STROKE);
		canvas.drawRoundRect(rectF, radus, radus, mPaint);
		switch (status) {
		case 0:
		{
		}
		break;
		case 1:
		{
			mPaint.setColor(level1_color);
			mPaint.setStyle(Style.FILL);
			canvas.drawCircle(this.width/2, height-this.width/2, radus-strokeWidth*2, mPaint);
		}
		break;
		case 2:
		{
			mPaint.setColor(level2_color);
			mPaint.setStyle(Style.FILL);
			canvas.drawRoundRect(yellow, radus, radus, mPaint);
		}
		break;
		case 3:
		{
			mPaint.setColor(level3_color);
			mPaint.setStyle(Style.FILL);
			canvas.drawRoundRect(green, radus, radus, mPaint);
		}
		break;
		}
	}
	
}

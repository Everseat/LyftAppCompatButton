package com.everseat.lyftappcompatbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;

public class LyftAppCompatButton extends AppCompatButton {
  private Paint etaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Rect etaTextBounds = new Rect();

  private int etaInSeconds = 0;

  public LyftAppCompatButton(Context context) {
    super(themedContext(context));
    setup();
  }

  public LyftAppCompatButton(Context context, AttributeSet attrs) {
    super(themedContext(context), attrs);
    setup();
  }

  public LyftAppCompatButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(themedContext(context), attrs, defStyleAttr);
    setup();
  }

  private void setup() {
    setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
    etaPaint.setColor(getCurrentTextColor());
    etaPaint.setTextSize(getTextSize());
  }

  public void setEtaInSeconds(int seconds) {
    etaInSeconds = seconds;
    invalidate();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    String etaString = getEtaString();
    etaPaint.getTextBounds(etaString, 0, etaString.length(), etaTextBounds);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (etaInSeconds > 0) {
      drawEta(canvas);
    }
  }

  private void drawEta(Canvas canvas) {
    Rect rect = getBackground().getBounds();
    float x = (rect.right - getPaddingRight()) - etaTextBounds.width();
    float baseline = (getHeight() / 2) + (etaTextBounds.height() / 2);
    canvas.drawText(getEtaString(), x, baseline, etaPaint);
  }

  private String getEtaString() {
    int etaInMinutes = etaInSeconds / 60;
    return getResources().getString(R.string.lyftappcompatbutton__eta_label, etaInMinutes);
  }

  private static ContextThemeWrapper themedContext(Context context) {
    return new ContextThemeWrapper(context, R.style.LyftAppCompatButton);
  }
}

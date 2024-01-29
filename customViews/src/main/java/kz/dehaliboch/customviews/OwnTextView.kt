package kz.dehaliboch.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class OwnTextView(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatTextView(context, attrs) {

    private val backgroundPaint: Paint

    init {
        backgroundPaint = Paint()
        backgroundPaint.color = Color.RED
        backgroundPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
        super.onDraw(canvas)
    }
}
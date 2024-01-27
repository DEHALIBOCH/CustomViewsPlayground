package kz.dehaliboch.customviews.own_text_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class OwnCustomView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

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
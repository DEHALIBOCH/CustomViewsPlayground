package kz.dehaliboch.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.min

class OwnCustomView(context: Context, attributeSet: AttributeSet? = null) : View(context, attributeSet) {

    private val backgroundPaint: Paint
    private val textPaint: Paint
    private var defaultFillColor: Int = Color.RED
    private val secondaryFillColor: Int = Color.MAGENTA
    private val DEFAULT_SIZE = 450
    private var textX = 0F
    private var textY = 0F
    private var ownNumber: Int

    companion object {
        private var viewNumber = 0
    }

    init {
        attributeSet?.let { attrs ->
            val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.OwnCustomView, 0, 0)
            try {
                defaultFillColor = typedArray.getColor(R.styleable.OwnCustomView_fillColor, Color.RED)
            } catch (_: Exception) {

            } finally {
                typedArray.recycle()
            }
        }

        ownNumber = ++viewNumber
        textPaint = Paint()
        textPaint.color = Color.BLACK
        textPaint.textSize = 30F
        backgroundPaint = Paint()
        backgroundPaint.color = defaultFillColor
        backgroundPaint.style = Paint.Style.FILL
    }

    /**
     *  Этот метод вызывается родительским контейнером для измерения размеров View. Реализация этого метода определяет какой размер должна
     *  иметь View и затем вызывает setMeasuredDimension(int, int) для установки этих размеров.
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d("ON_MEASURE", "width spec" + MeasureSpec.toString(widthMeasureSpec))
        Log.d("ON_MEASURE", "height spec" + MeasureSpec.toString(heightMeasureSpec))
        val width = getMeasurementSize(widthMeasureSpec, DEFAULT_SIZE)
        val height = getMeasurementSize(heightMeasureSpec, DEFAULT_SIZE)
        textX = (width - textPaint.measureText(ownNumber.toString())) / 2
        textY = height.toFloat() / 2
        setMeasuredDimension(width, height)
    }

    /**
     *  Этот метод вызывается после onMeasure для установки View в родительском контейнере(на экране),
     */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

//    /**
//     *  Вызывается после onLayout для отрисовки View
//     */
//    override fun onDraw(canvas: Canvas) {
//        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
//        super.onDraw(canvas)
//    }

    /**
     *  Метод для определения размера View в методе onMeasure.
     *  У View могут быть разные MeasureSpec:
     *      1) MeasureSpec.EXACTLY -> В этом режиме размер задается точно и фиксируется, например когда мы указали размер
     *          match_parent или константу(150dp)
     *
     *      2) MeasureSpec.AT_MOST -> В этом режиме размер ограничен максимальным размером. View может быть как меньше, так и равно указанному
     *          значению, но не больше. Обычно это происходит при использовании атрибута wrap_content.
     *
     *      3) MeasureSpec.UNSPECIFIED -> В этом режиме View может иметь любой размер, например когда наша View находится в ScrollView и при этом
     *          у нее указан размер wrap_content, View не сможет отрисовать себя т.к. не сможет измерить себя нормально, для этого и необходим
     *          этот метод.
     */
    private fun getMeasurementSize(measureSpec: Int, defaultSize: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)

        return when (mode) {
            MeasureSpec.EXACTLY -> {
                size
            }

            MeasureSpec.AT_MOST -> {
                min(defaultSize, size)
            }

            else -> {
                defaultSize
            }
        }
    }

    fun setFillColor(fillColor: Int) {
        backgroundPaint.color = fillColor
    }

    private var needsUpdate = false
    var topLeftColor = defaultFillColor
        set(value) {
            field = value
            needsUpdate = true
        }
    var bottomLeftColor = secondaryFillColor
        set(value) {
            field = value
            needsUpdate = true
        }
    var topRightColor = secondaryFillColor
        set(value) {
            field = value
            needsUpdate = true
        }
    var bottomRightColor = defaultFillColor
        set(value) {
            field = value
            needsUpdate = true
        }

    /**
     *  Вызывается после onLayout для отрисовки View
     */
    override fun onDraw(canvas: Canvas) {
        if (needsUpdate) {
            val colors = intArrayOf(topLeftColor, topRightColor, bottomLeftColor, bottomRightColor)
            val linearGradient = LinearGradient(0F, 0F, width.toFloat(), height.toFloat(), colors, null, Shader.TileMode.CLAMP)
            backgroundPaint.shader = linearGradient
            needsUpdate = false
        }
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
        canvas.drawText(ownNumber.toString(), textX, textY, textPaint)
        super.onDraw(canvas)
    }
}
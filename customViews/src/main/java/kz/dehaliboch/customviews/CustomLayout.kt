package kz.dehaliboch.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.min

class CustomLayout(context: Context, attributeSet: AttributeSet? = null) : ViewGroup(context, attributeSet) {

    /**
     *  l: Int, t: Int, r: Int, b: Int - координаты самого контейнера ViewGroup на layout.
     *  Дальше мы сами высчитываем координаты для вьюшек которые мы размещаем
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // TODO работает немного не правильно, необходимо переделать
        var left = l + paddingLeft
        var top = t + paddingTop
        var isFirstInRow = true

        var rowHeight = 0   // макс высота элемента в строке

        for (i in 0 until childCount) {
            val child = getChildAt(i)

            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            if (isFirstInRow) {
                top += child.paddingTop
                isFirstInRow = false
            }

            left += child.paddingLeft

            if (left + childWidth + child.paddingRight > r) {
                left = l + paddingLeft
                top += rowHeight + child.paddingBottom
                isFirstInRow = true
                rowHeight = 0
            }

            child.layout(left, top, left + childWidth, top + childHeight)

            left += childWidth + child.paddingRight

            if (childHeight > rowHeight) rowHeight = childHeight
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var rowHeight = 0
        var maxWidth = 0
        var maxHeight = 0
        var left = 0
        var top = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)

            measureChild(child, widthMeasureSpec, heightMeasureSpec)

            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            if (left == 0) {
                top += child.paddingTop
            }

            if (left + childWidth + child.paddingLeft < width) {
                left += childWidth + child.paddingLeft
            } else {
                if (left > maxWidth) maxWidth = left
                left = 0
                top += rowHeight + child.paddingBottom
                rowHeight = 0
            }

            if (childHeight > rowHeight) rowHeight = childHeight
        }

        if (left > maxWidth) maxWidth = left
        maxHeight = top + rowHeight

        setMeasuredDimension(getMeasure(widthMeasureSpec, maxWidth), getMeasure(heightMeasureSpec, maxHeight))
    }

    private fun getMeasure(spec: Int, desired: Int): Int = when (MeasureSpec.getMode(spec)) {
        MeasureSpec.EXACTLY -> {
            MeasureSpec.getSize(spec)
        }

        MeasureSpec.AT_MOST -> {
            min(MeasureSpec.getSize(spec), desired)
        }

        else -> {
            desired
        }
    }
}
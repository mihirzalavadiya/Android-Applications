package com.example.paintapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.lang.Math.abs

class DrawPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var paint: Paint? = null
    private var path: Path? = null
    private var mPath: Path? = null
    private var pathList = ArrayList<PaintPath>()
    private var undonePathList = ArrayList<PaintPath>()
    private var mX: Float? = null
    private var mY: Float? = null
    private var touchTolerance: Float = 4f

    init {
        paint = Paint()
        paint!!.color = Color.BLACK
        paint!!.strokeWidth = 10f
        paint!!.style = Paint.Style.STROKE
        paint!!.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        if (pathList.size > 0) {
            for (path in pathList) {
                canvas!!.drawPath(path.path, paint!!)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val xPos: Float = event!!.x
        val yPos: Float = event!!.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                touchStart(xPos, yPos)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                touchMove(xPos, yPos)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                touchUp()
                invalidate()
            }

            else -> {

            }
        }
        invalidate()
        return true
    }

    private fun touchStart(xPos: Float, yPos: Float) {
        mPath = Path()
        val paintPath = PaintPath(mPath!!)
        pathList.add(paintPath)
        mPath!!.reset()
        mPath!!.moveTo(xPos, yPos)
        mX = xPos
        mY = yPos
    }

    private fun touchMove(xPos: Float, yPos: Float) {
        val dX: Float = abs(xPos - mX!!)
        val dY: Float = abs(yPos - mY!!)

        if (dX >= touchTolerance || dY >= touchTolerance) {
            mPath!!.quadTo(mX!!, mY!!, (xPos + mX!!) / 2, (yPos + mY!!) / 2)
            mX = xPos
            mY = yPos
        }
    }

    private fun touchUp() {
        mPath!!.lineTo(mX!!, mY!!)
    }

    fun setUndo() {
        val size = pathList.size
        if (size > 0) {
            undonePathList.add(pathList[size - 1])
            pathList.removeAt(size -1)
            invalidate()
        }
    }

    fun setRedo() {
        val size = undonePathList.size
        if (size > 0) {
            pathList.add(undonePathList[size - 1])
            undonePathList.removeAt(size -1)
            invalidate()
        }
    }

    fun setDelete() {
        if(pathList.size > 0) {
            pathList.clear()
            undonePathList.clear()
            invalidate()
        }
    }

    fun setPaint(value: String)
    {
        if(value == "red")
        {
            paint!!.color = Color.RED
        }

        if(value == "blue")
        {
            paint!!.color = Color.BLUE
        }

        if(value == "orange")
        {
            paint!!.color = Color.rgb(255,165,0)
        }

        if(value == "green")
        {
            paint!!.color = Color.GREEN
        }
        if(value == "pink")
        {
            paint!!.color = Color.rgb(255,20,147)
        }

        if(value == "yellow")
        {
            paint!!.color = Color.YELLOW
        }

        if(value == "white")
        {
            paint!!.color = Color.WHITE
        }
    }
}
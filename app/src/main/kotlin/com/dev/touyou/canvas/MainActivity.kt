package com.dev.touyou.canvas

import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var mCanvas: Canvas? = null
    var mBitmap: Bitmap? = null
    var mPaint: Paint? = null
    var mImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImageView = findViewById(R.id.imageView) as ImageView
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val width: Int = mImageView?.width!!
        val height: Int = mImageView?.height!!
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mBitmap)
        mCanvas?.drawColor(Color.WHITE)
        mPaint = Paint()
        mPaint?.strokeWidth = 10.0f
        mPaint?.color = Color.RED
        mCanvas?.drawPoint(50.0f, 50.0f, mPaint)
        mCanvas?.drawPoint(50.0f, 100.0f, mPaint)
        mCanvas?.drawPoint(100.0f, 50.0f, mPaint)
        mCanvas?.drawPoint(100.0f, 100.0f, mPaint)
        mPaint?.strokeWidth = 5.0f
        mPaint?.color = Color.BLUE
        mCanvas?.drawLine(50.0f, 50.0f, 100.0f, 100.0f, mPaint)
        mCanvas?.drawLine(50.0f, 100.0f, 100.0f, 50.0f, mPaint)
        mPaint?.isAntiAlias = true
        mCanvas?.drawCircle(200.0f, 200.0f, 50.0f, mPaint)
        mPaint?.color = Color.YELLOW
        mCanvas?.drawCircle(300.0f, 400.0f, 100.0f, mPaint)
        val mPath = Path()
        mPaint?.style = Paint.Style.STROKE
        mPaint?.color = Color.argb(255, 255, 0, 0)
        mPath.moveTo(155.0f + 0, 5.0f + 0)
        mPath.lineTo(155.0f + 130, 5.0f + 30)
        mPath.lineTo(155.0f + 10, 5.0f + 50)
        mPath.lineTo(155.0f + 140, 5.0f + 70)
        mPath.lineTo(155.0f + 0, 5.0f + 110)
        mCanvas?.drawPath(mPath, mPaint)
        mImageView?.setImageBitmap(mBitmap)
    }
}

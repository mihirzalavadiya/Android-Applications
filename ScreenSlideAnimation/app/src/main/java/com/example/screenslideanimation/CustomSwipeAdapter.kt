package com.example.screenslideanimation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter

class CustomSwipeAdapter(val context: Context) : PagerAdapter() {

    var images = intArrayOf(R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four)
//    private var context: Context? = null
    private var layoutInflater: LayoutInflater? = null

//    fun CustomSwipeAdapter(context: Context?) {
//        this.context = context
//    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val item_view = layoutInflater?.inflate(R.layout.activity_swipe, container, false)
        val imageView = item_view?.findViewById<View>(R.id.imageview) as ImageView
        imageView.setImageResource(images.get(position))
        container.addView(item_view)
        return item_view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}
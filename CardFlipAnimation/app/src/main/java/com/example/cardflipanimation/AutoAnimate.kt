package com.example.cardflipanimation

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.RelativeLayout.CENTER_IN_PARENT
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.example.cardflipanimation.databinding.ActivityAutoAnimateBinding

class AutoAnimate : AppCompatActivity() {

    private lateinit var binding5: ActivityAutoAnimateBinding
    var count = 0

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding5 = ActivityAutoAnimateBinding.inflate(layoutInflater)
        setContentView(binding5.root)

        setTitle("Auto Animate")

        binding5.itemAdd.setOnClickListener {
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            params.addRule(CENTER_IN_PARENT)
            params.setMargins(10, 10, 10, 10)

            var cv = CardView(this)
            cv.cardElevation = 10f

            count = count + 1

//            android:id="@+id/aanimate"
//            android:layout_width="match_parent"
//            android:layout_height="wrap_content"
//            android:layout_margin="2dp"
//            android:textSize="20dp"
//            android:textStyle="bold"
//            android:text="Mihir"
//            android:fontFamily="monospace"
//            android:textAlignment="center"
//            android:textColor="@color/blue"


            val aanimate = TextView(this)
            aanimate.textSize = 25f
            aanimate.textAlignment = View.TEXT_ALIGNMENT_CENTER
            aanimate.setTextColor(Color.parseColor("#2196F3"))
            aanimate.setLayoutParams(params)
            aanimate.setGravity(Gravity.CENTER_HORIZONTAL)
            aanimate.text = "Layout Animation $count"
            aanimate.setBackgroundColor(Color.BLACK)
            val face: Typeface = Typeface.MONOSPACE
            aanimate.setTypeface(face)
//            val face1: Typeface = Typeface.createFromAsset(getAssets(), "fonts/bolds")
//            aanimate.setTypeface(face1)

            cv.addView(aanimate)
            binding5.container1.addView(cv, 0)
        }

        binding5.itemRemove.setOnClickListener {
            count = count - 1
            binding5.container1.removeViewAt(0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.object_animator, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.getItemId()
        val intent = Intent(this, ObjectAnimator::class.java)
        if (id == R.id.object_animator) {
            startActivity(intent)
            return false
        }
        else if(id == R.id.dynamic_animation) {
            val intent1 = Intent(this, DynamicAnimation::class.java)
            startActivity(intent1)
            return false
        }
        else if(id == R.id.card_flip) {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            return false
        }
        else if(id == R.id.zoom_animation) {
            val intent2 = Intent(this, ZoomAnimation::class.java)
            startActivity(intent2)
            return false
        }
        else if(id == R.id.auto_animate) {
            val intent2 = Intent(this, AutoAnimate::class.java)
            startActivity(intent2)
            return false
        }
        else if(id == R.id.layout_changes) {
            val intent5 = Intent(this, LayoutChanges::class.java)
            startActivity(intent5)
            return false
        }

        return super.onOptionsItemSelected(item)
    }
}
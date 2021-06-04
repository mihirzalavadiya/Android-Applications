package com.example.cardflipanimation

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.util.Pair
import android.view.Menu
import android.view.MenuItem
import com.example.cardflipanimation.databinding.ActivitySharedAnimationBinding

class SharedAnimation : AppCompatActivity() {

    private lateinit var binding: ActivitySharedAnimationBinding

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTitle("Shared Animation")

        binding.profile.setOnClickListener {
            val sharedIntent = Intent(this, SharedAniationTwo::class.java)

//            val pairs: Array<Any?> = arrayOfNulls<Any?>(3)
            val p1 = Pair.create<View, String>(binding.personLogo, "personlogoTransition")
            val p2 = Pair.create<View, String>(binding.sharedTitle, "titleTransition")
            val p3 = Pair.create<View, String>(binding.profileDesc, "descTransition")

            val option = ActivityOptions.makeSceneTransitionAnimation(this, p1, p2, p3) as ActivityOptions

            startActivity(sharedIntent, option.toBundle())
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
        else if(id == R.id.shared_animation) {
            val intent6 = Intent(this, SharedAnimation::class.java)
            startActivity(intent6)
            return false
        }

        return super.onOptionsItemSelected(item)
    }
}
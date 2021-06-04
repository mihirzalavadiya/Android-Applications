package com.example.cardflipanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.LayoutTransition
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.cardflipanimation.databinding.ActivityLayoutChangesBinding

class LayoutChanges : AppCompatActivity() {

    private lateinit var binding6: ActivityLayoutChangesBinding
    var expand: Boolean = false
    var visibleitem: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding6 = ActivityLayoutChangesBinding.inflate(layoutInflater)
        setContentView(binding6.root)

        setTitle("Animate Layout Changes")

        binding6.lchanges.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING)

        binding6.txtChanges.setOnClickListener {
            if (expand)
            {
                expand = false
                binding6.txtChanges.setText("Click Me")
            }
            else
            {
                expand = true
                binding6.txtChanges.setText("This is Animate Layout Changes")
            }
        }

        binding6.btnShow.setOnClickListener {
            binding6.lchanges.layoutTransition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING)
            binding6.lchanges.layoutTransition.setDuration(1500)

            binding6.btnShow.text = if (visibleitem) "Hide" else "Show"
            binding6.txtTv.visibility = if (visibleitem) View.VISIBLE else View.GONE

            visibleitem = !visibleitem
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
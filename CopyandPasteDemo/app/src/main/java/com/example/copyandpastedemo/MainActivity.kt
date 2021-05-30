package com.example.copyandpastedemo

import android.content.ClipData
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ClipboardManager
import android.widget.Toast
import com.example.copyandpastedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clipboardManager= getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        if(!clipboardManager!!.hasPrimaryClip()) {
            binding.btnPaste.setEnabled(false)
        }

        binding.btnCopy.setOnClickListener {
            val text = binding.editText.text.toString()
            if (!text.equals("")) {
                val clipData:ClipData = ClipData.newPlainText("text", text)
                clipboardManager?.setPrimaryClip(clipData)

                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
                binding.btnPaste.setEnabled(true)
            }
        }

        binding.btnPaste.setOnClickListener {
            val clipData: ClipData? = clipboardManager?.primaryClip
            val item: ClipData.Item? = clipData?.getItemAt(0)

            binding.textView.setText(item?.getText().toString())
            Toast.makeText(this, "Pasted", Toast.LENGTH_SHORT).show()
        }
    }
}
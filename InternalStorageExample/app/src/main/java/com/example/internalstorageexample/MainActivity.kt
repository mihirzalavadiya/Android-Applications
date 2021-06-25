package com.example.internalstorageexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.internalstorageexample.databinding.ActivityMainBinding
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    var FILE_NAME : String = "example.txt"
    private lateinit var binding: ActivityMainBinding
    var update:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            save()
        }

        binding.btnLoad.setOnClickListener {
            load();
        }
    }

    fun save() {
        val text: String = binding.editText.getText().toString()
        var fos : FileOutputStream? = null
        try {
            if (update) {
                fos = openFileOutput(FILE_NAME, Context.MODE_APPEND)
            }
            else {
                fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            }
            fos.write(text.toByteArray())

            binding.editText.getText().clear()
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show()
        }
        catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        catch (e:IOException) {
            e.printStackTrace()
        }
        finally {
            if (fos != null) {
                try {
                    fos.close()
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun load() {
        var fis : FileInputStream? = null
        update = false
        try {
            fis = openFileInput(FILE_NAME)
            var inputStreamReader: InputStreamReader = InputStreamReader(fis)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null)  {
                stringBuilder.append(text).append("\n")
            }

            binding.editText.setText(stringBuilder.toString()).toString()

        }
        catch (e : FileNotFoundException) {
            e.printStackTrace()
        }
        catch (e : IOException) {
            e.printStackTrace()
        }
        finally {
            if (fis != null) {
                try {
                    fis.close()
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
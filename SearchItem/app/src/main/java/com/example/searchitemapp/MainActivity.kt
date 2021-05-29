package com.example.searchitemapp

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.miguelcatalan.materialsearchview.MaterialSearchView

class MainActivity : AppCompatActivity() {

    private var SUGGESTION = arrayOf(
        "C", "CPP", "JAVA", "KOTLIN", "HTML", "CSS", "JavaScript",
        "Google", "Microsoft", "Oracle", "HP", "Lenovo", "Assus",
        "Intel", "AMD", "Apple"
    )
    var toolBar: Toolbar? = null
    var materialSearchView: MaterialSearchView? = null
    var arrayAdapter: ArrayAdapter<String>? = null 
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listview:ListView? = findViewById(R.id.items)

        toolBar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)
        toolBar?.setTitleTextColor(Color.parseColor("#FFFFFF"))
        materialSearchView = findViewById(R.id.searchView)
        materialSearchView?.setSuggestions(SUGGESTION)

        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SUGGESTION)

        listview?.setAdapter(arrayAdapter)

        materialSearchView?.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {}
            override fun onSearchViewClosed() {

//                  arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SUGGESTION)
                listview?.setAdapter(arrayAdapter)
            }
        })

        materialSearchView?.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && !newText.isEmpty()) {
                    for (s in SUGGESTION) {
                        if (s.toLowerCase().contains(newText)) {
//                            arrayAdapter?.add(s)
                        }
                    }
                } else {
                    arrayAdapter?.addAll()
                }
                listview?.setAdapter(arrayAdapter)
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem: MenuItem? = menu?.findItem(R.id.searchMenu)
        materialSearchView?.setMenuItem(menuItem)
        return super.onCreateOptionsMenu(menu)
    }
}
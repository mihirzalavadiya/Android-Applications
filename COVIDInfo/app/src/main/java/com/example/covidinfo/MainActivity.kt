package com.example.covidinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    lateinit var worldCaseTV: TextView
    lateinit var worldRecoveredTV: TextView
    lateinit var worldDeathsTV: TextView
    lateinit var countryCasesTV: TextView
    lateinit var countryRecoveredTV: TextView
    lateinit var countryDeathsTV: TextView
    lateinit var stateRV: RecyclerView
    lateinit var stateRVAdapter: StateRVAdapter
    lateinit var stateList: List<StateModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        worldCaseTV = findViewById(R.id.idTVWorldCases)
        worldRecoveredTV = findViewById(R.id.idTVWorldRecovered)
        worldDeathsTV = findViewById(R.id.idTVWorldDeaths)
        countryCasesTV = findViewById(R.id.idTVIndianCases)
        countryDeathsTV = findViewById(R.id.idTVIndianDeaths)
        countryRecoveredTV = findViewById(R.id.idTVIndianRecovered)
        stateRV = findViewById(R.id.idRVStates)
        stateList = ArrayList<StateModel>()

        getStateInfo()
        getWorldInfo()
    }

    private fun getStateInfo() {

//        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()

        val url = "https://api.rootnet.in/covid19-in/stats/latest"
        val queue = Volley.newRequestQueue(this@MainActivity)
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
//                Toast.makeText(this, "Hello1", Toast.LENGTH_SHORT).show()

                val dataObj = response.getJSONObject("data")
                val summaryObj = dataObj.getJSONObject("summary")
                val cases: Long = summaryObj.getLong("total")
                val recovered: Int = summaryObj.getInt("discharged")
                val deaths: Int = summaryObj.getInt("deaths")

//                Toast.makeText(this, "Hello2", Toast.LENGTH_SHORT).show()
                countryCasesTV.text = cases.toString()
                countryRecoveredTV.text = recovered.toString()
                countryDeathsTV.text = deaths.toString()

                val regionalArray = dataObj.getJSONArray("regional")
                for (i in 0 until regionalArray.length()) {
                    val regionalObj = regionalArray.getJSONObject(i)
                    val stateName: String = regionalObj.getString("loc")
                    val cases: Long = regionalObj.getLong("totalConfirmed")
                    val deaths: Int = regionalObj.getInt("deaths")
                    val recovered: Int = regionalObj.getInt("discharged")

                    val stateModel = StateModel(stateName, recovered, deaths, cases)
                    stateList = stateList + stateModel
                }

                stateRVAdapter = StateRVAdapter(stateList)
                stateRV.layoutManager = LinearLayoutManager(this)
                stateRV.adapter = stateRVAdapter
        }, { error ->
            {
                Toast.makeText(this, "Fail to get data", Toast.LENGTH_SHORT).show()
            }
        })
        queue.add(request)
    }

    private fun getWorldInfo() {
        val url = "https://corona.lmao.ninja/v3/covid-19/all"
        val queue = Volley.newRequestQueue(this@MainActivity)
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                val worldCases: Int = response.getInt("cases")
                val worldRecovered: Int = response.getInt("recovered")
                val worldDeaths: Int = response.getInt("deaths")

                worldCaseTV.text = worldCases.toString()
                worldRecoveredTV.text = worldRecovered.toString()
                worldDeathsTV.text = worldDeaths.toString()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error ->
            {
                Toast.makeText(this, "Fail to get data", Toast.LENGTH_SHORT).show()
            }
        })
        queue.add(request)
    }
}
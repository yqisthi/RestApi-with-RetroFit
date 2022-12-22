package com.example.restapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiwithretrofit.api.GraphData
import com.example.restapiwithretrofit.api.PostResponse
import com.example.restapiwithretrofit.api.RetrofitClient
import com.example.restapiwithretrofit.api.SensorData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<SensorData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResponseCode: TextView = findViewById<TextView>(R.id.tvResponseCode)
        val rvPost:RecyclerView = findViewById<RecyclerView>(R.id.rvPost)
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<GraphData>{
            override fun onResponse(
                call: Call<GraphData>,
                response: Response<GraphData>
            ) {
                val responseCode = response.code().toString()
                tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it.data) }
                val adapter = PostAdapter(ArrayList(list.takeLast(5)))
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<GraphData>, t: Throwable) {
                print("FAILLLLLL")
            }
        })
    }
}
package com.example.restapiwithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiwithretrofit.api.PostResponse
import com.example.restapiwithretrofit.api.SensorData


class PostAdapter(private val list: ArrayList<SensorData>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class  PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postResponse: SensorData){
            with(itemView){
                val text = "id: ${postResponse.id}\n" +
                        "amonia: ${postResponse.amonia}\n" +
                        "curah: ${postResponse.curah_hujan}"
                val textView: TextView = findViewById(R.id.tvText) as TextView
                textView.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

}

package com.example.restapiwithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiwithretrofit.api.PostResponse


class PostAdapter(private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class  PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postResponse: PostResponse){
            with(itemView){
                val text = "id: ${postResponse.id}\n" +
                        "text: ${postResponse.text}\n" +
                        "title: ${postResponse.title}"
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

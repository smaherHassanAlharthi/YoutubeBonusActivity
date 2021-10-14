package com.example.kotlinyoutube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter(
    private val videoList: Array<Array<String>>,
    private val player: YouTubePlayer): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){
    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val button: Button = itemView.btVideo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.video_item,
                parent,
                false
        )
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentTitle = videoList[position][0]
        val currentLink = videoList[position][1]
        holder.button.text = currentTitle
        holder.button.setOnClickListener {
            player.loadVideo(currentLink, 0f)
        }
    }

    override fun getItemCount() = videoList.size
}
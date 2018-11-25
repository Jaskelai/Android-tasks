package com.github.kornilovmikhail.homework

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TrackAdapter(private val tracks: List<Track>, private val callback: Callback) : RecyclerView.Adapter<TrackAdapter.TrackHolder>() {

    inner class TrackHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.tv_list_text)
        fun bind(name: String) {
            tvName.text = name
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != -1) {
                    callback.callback(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TrackHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return TrackHolder(v)
    }

    override fun onBindViewHolder(trackHolder: TrackHolder, i: Int) {
        trackHolder.bind(tracks[i].name)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }
}

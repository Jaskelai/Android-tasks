package com.github.kornilovmikhail.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackHolder> {

    private List<Track> tracks;
    private Callback callback;

    public TrackAdapter(Context context) {
        callback = (Callback) context;
        tracks = new TracksRepository(context).getTracks();
    }


    public class TrackHolder extends RecyclerView.ViewHolder {

        private View itemView;


        public TrackHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(String name) {
            TextView textView = itemView.findViewById(R.id.tv_list_text);
            textView.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != -1) {
                        callback.callback(position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public TrackAdapter.TrackHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new TrackHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.TrackHolder trackHolder, int i) {
        trackHolder.bind(tracks.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }
}

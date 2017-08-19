package com.cb.android.jsonholdertypicode.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.Photo;
import com.cb.android.jsonholdertypicode.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cb.android.jsonholdertypicode.R.id.imageView;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private Context context;
    private ArrayList<Photo> photos;
    private OnItemClickListener onItemClickListener;

    public PhotosAdapter(Context context, ArrayList<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    public void updatePhotos(ArrayList<Photo> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photos,parent,false);
        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosViewHolder holder, int position) {
        final Photo thisPhoto = photos.get(position);
        holder.tvPhoto.setText(thisPhoto.getTitle());
        Picasso.with(context).load(thisPhoto.getThumbnailUrl()).into(holder.image);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(thisPhoto.getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder{
        TextView tvPhoto;
        ImageView image;
        View thisView;
        public PhotosViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            image = (ImageView) itemView.findViewById(imageView);
            tvPhoto = (TextView) itemView.findViewById(R.id.tv_Photo);

        }
    }
}

package com.ciclids.where2go.placesList.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciclids.where2go.R;
import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.ImageLoader;
import com.ciclids.where2go.placesList.ui.OnPlaceClickListener;
import com.facebook.share.widget.LikeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max on 2016
 */

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {

    private List<Place> items;
    private OnPlaceClickListener clickListener;
    private ImageLoader glideImageLoader;

    public PlaceListAdapter(List<Place> items, OnPlaceClickListener clickListener, ImageLoader imageLoader) {
        this.items = items;

        this.clickListener = clickListener;
        this.glideImageLoader = imageLoader;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.primary_text.setText(items.get(position).getName());
        holder.secondary_text.setText(items.get(position).getCategories().get(0).getShortName());
        try {
            glideImageLoader.load(holder.placeListImage, items.get(position).getIcon());
        } catch (Exception e) {
            Log.w("error", e.getLocalizedMessage());

        }
        holder.setClickListener(items.get(position), clickListener);
        holder.faceLikeView.setObjectIdAndType(
                items.get(position).getUrl(),
                LikeView.ObjectType.PAGE);
        /*
        * holder.shareButton.setShareContent(content);
        */
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Place> places) {
        items = places;
        this.notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.place_list_image)
        ImageView placeListImage;
        @Bind(R.id.place_list_priText)
        TextView primary_text;
        @Bind(R.id.place_list_secText)
        TextView secondary_text;
        @Bind(R.id.faceLike)
        LikeView faceLikeView;
        View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setClickListener(final Place place,
                                     final OnPlaceClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onPlaceClicked(place);
                }
            });

        }
    }
}
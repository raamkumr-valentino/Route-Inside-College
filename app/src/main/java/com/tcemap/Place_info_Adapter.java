package com.tcemap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RaamKumr on 10/22/2016.
 */
public class Place_info_Adapter extends RecyclerView.Adapter<Place_info_Adapter.PlaceViewHolder> {
    ArrayList<Place_info> place_infos=new ArrayList<>();
    public Place_info_Adapter(ArrayList<Place_info> infos)
    {
        this.place_infos=infos;
    }
    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.place_info_card_design,parent,false);
        PlaceViewHolder placeViewHolder=new PlaceViewHolder(view);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        Place_info placeInfo=place_infos.get(position);
      //  holder.place_image.setImageResource(placeInfo.getPlace_img());
        holder.Place.setText(placeInfo.getPlace());
        holder.Time.setText(placeInfo.getTime());
        holder.Instruction.setText(placeInfo.getInstruction());
    }

    @Override
    public int getItemCount() {
        return place_infos.size();
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder
    {
      //  ImageView place_image;
        TextView Place,Time,Instruction;
        public PlaceViewHolder(View itemView) {
            super(itemView);
       //     place_image=(ImageView)itemView.findViewById(R.id.place_info_img);
            Place=(TextView)itemView.findViewById(R.id.place_head);
            Time=(TextView)itemView.findViewById(R.id.place_time);
            Instruction=(TextView)itemView.findViewById(R.id.ins_id);
        }
    }
}

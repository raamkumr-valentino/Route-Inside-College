package com.tcemap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by RaamKumr on 10/20/2016.
 */
public class NavigateRouteAdapter extends RecyclerView.Adapter<NavigateRouteAdapter.NavigateViewHolder> {

    ArrayList<NavigateRoute> navigateRoutes= new ArrayList<>();
    Context context;
    public NavigateRouteAdapter(ArrayList<NavigateRoute> navigateRoutes)
    {
        this.navigateRoutes=navigateRoutes;
    }

    @Override
    public NavigateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.carddesign,parent,false);
        NavigateViewHolder navigateViewHolder=new NavigateViewHolder(view);
        return navigateViewHolder;
    }

    @Override
    public void onBindViewHolder(final NavigateViewHolder holder, int position) {
        NavigateRoute navigateRoute=navigateRoutes.get(position);
        holder.destination_img.setImageResource(navigateRoute.getImg_id());
        holder.tittle.setText(navigateRoute.getDestination_title());
        holder.routetime.setText(navigateRoute.getWalk_time());
        holder.instruction.setText(navigateRoute.getInstruction());
        holder.share.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Bitmap i=null;
                Uri bmpUri = null;
                Drawable m = v.getResources().getDrawable(R.drawable.tce_main_building);
                try
                {
                    assert ((BitmapDrawable)m) != null;
                    i = ((BitmapDrawable)m).getBitmap();
                }catch (Exception e){

                }
                try {
                    if(i!=null) {
                        File file = new File(v.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "TCE_Map" + System.currentTimeMillis() + ".png");
                        FileOutputStream out = new FileOutputStream(file);
                        i.compress(Bitmap.CompressFormat.PNG, 100, out);
                        out.close();
                        bmpUri = Uri.fromFile(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                try {
                    //Uri mUri = Uri.parse("android.resource://com.tcemap/drawable/tce_main_building.jpg");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, This is test Sharing");
                    v.getContext().startActivity(Intent.createChooser(shareIntent, "Send your image"));
                }catch (Exception e)
                {
                }

            }
        });
        holder.place_info.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Place_information.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return navigateRoutes.size();
    }

    public static class NavigateViewHolder extends RecyclerView.ViewHolder {
        ImageView destination_img;
        TextView tittle,routetime,instruction,share,place_info;
        public NavigateViewHolder(View itemView) {
            super(itemView);
            destination_img= (ImageView) itemView.findViewById(R.id.thumbnail);
            tittle= (TextView) itemView.findViewById(R.id.title);
            routetime= (TextView) itemView.findViewById(R.id.time);
            instruction= (TextView) itemView.findViewById(R.id.ins_id);
            share=(TextView)itemView.findViewById(R.id.share_text);
            place_info=(TextView)itemView.findViewById(R.id.place_info);
        }
    }
}

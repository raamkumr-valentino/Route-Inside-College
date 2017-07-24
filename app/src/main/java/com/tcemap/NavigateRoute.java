package com.tcemap;

/**
 * Created by RaamKumr on 10/20/2016.
 */
public class NavigateRoute  {
    int img_id;
    String destination_title,walk_time,instruction;

    public  NavigateRoute(int img_id,String title,String time,String ins)
    {
        this.setImg_id(img_id);
        this.setDestination_title(title);
        this.setWalk_time(time);
        this.setInstruction(ins);
    }
    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getDestination_title() {
        return destination_title;
    }

    public void setDestination_title(String destination_title) {
        this.destination_title = destination_title;
    }

    public String getWalk_time() {
        return walk_time;
    }

    public void setWalk_time(String walk_time) {
        this.walk_time = walk_time;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

}

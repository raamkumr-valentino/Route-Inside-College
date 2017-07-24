package com.tcemap;

/**
 * Created by RaamKumr on 10/22/2016.
 */
public class Place_info {
    int place_img;
    String Place,Time,Instruction;

    public Place_info(String Place,String Time,String Instruction)
    {
        //this.setPlace_img(place_img);
        this.setPlace(Place);
        this.setTime(Time);
        this.setInstruction(Instruction);
    }

    /*public int getPlace_img() {
        return place_img;
    }*/

   /* public void setPlace_img(int place_img) {
        this.place_img = place_img;
    }*/

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getInstruction() {
        return Instruction;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }
}

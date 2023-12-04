package org.example;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Camera {
    protected double x;
    protected int y;
    protected Rectangle2D camera;
    final int SizeXScene=600;
    final int SizeYScene=300;
    //final int SizeXHeros=75;
    final int SizeXHeros=34;
    //final int SizeYHeros=100;
    final int SizeYHeros=66;
    final int km=1;
    final double fm=1.2;
    //final int ax=1;
    protected double vx=0;



    public Camera(double x, int y,int choix) {
        this.x = x;
        this.y = y;
        if (choix==0){ // On souhaite créer une camera pour une Scène
            this.camera=new Rectangle2D(x,y,SizeXScene,SizeYScene);
        }
        else{
            this.camera=new Rectangle2D(x,y,SizeXHeros,SizeYHeros);
        }
    }

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void update(long time){
        AnimationTimer time2 = new AnimationTimer(){
            @Override
            public void handle(long time){
                //new Hero(name2);
            };};

        double ax=km*(SizeXHeros-this.x)+fm*this.vx;
        this.vx=this.vx+ax*time;
        this.x=this.x+vx*(time);

        //System.out.println("a");
    }

    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getCamera() {
        return camera;
    }
}

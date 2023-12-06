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
    final int SizeXHeros2=47;
    final int SizeXHeros=40;
    //final int SizeYHeros=100;
    final int SizeYHeros=66;
    final double km=0.00001;
    final double fm=0.0006;
    //final int ax=1;
    protected double vx=0;
    protected double timepre;
    private int i;




    public Camera(double x, int y,int choix) {
        this.x = x;
        this.y = y;
        switch (choix){
            case 0: /*On souhaite créer une camera pour une Scène */
                this.camera=new Rectangle2D(x,y,SizeXScene,SizeYScene);
                break;
            case 1:/*On souhaite créer une camera pour les premières frames du heros*/
                this.camera=new Rectangle2D(x,y,SizeXHeros,SizeYHeros);
                break;
            case 2:
                this.camera=new Rectangle2D(x,y,SizeXHeros2,SizeYHeros);
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
        if (this.i==0){
            this.timepre=time;
            this.i++;
        }
        else{
            double dt=(time-timepre)*1E-9;
            double ax=km*(this.x)+fm*this.vx;
            this.vx=this.vx+ax*dt;
            this.x=this.x+vx*(dt);
        }


        System.out.println(this.x);
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

package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Assassin's Creed Runner");
        Group root = new Group();
        //Pane pane = new Pane(root);
        //pane.getChildren().add(new Label("Hello label"));
        //
        Camera camera=new Camera(0,334,0);
        String name="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/desert.png";
        //primaryStage.getScene().setRoot(new Region());
        GameScene a=new GameScene(root,name,0,0,name,name,camera);
        String name2="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/heros.png";
        //HBox root2 = new HBox();
        //ImageView d=new StaticThing(name2,200,300).getImageviev();

        Pane root2=new Pane();
        //root2.getChildren().add(a.getBackGroundleft());
        //root2.getChildren().add(a.getBackGroundRight());

        root2.getChildren().add(a.render(camera.getX(),camera.getY(),a.BackGroundleft));
        a.NumberOfLives(root2,a.getLifePoint());
        Hero h=new Hero(name2);
        //ImageView b=new Hero(name2).getSprite();
        //d=a.render(4,4,d);
        //d.setFitWidth(40);
        //d.setPreserveRatio(true);
        root2.getChildren().add(h.getSprite());
        Scene scene = new Scene(root2);


        primaryStage.setScene(scene);
        //primaryStage.setScene(a.getScene());
        //primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                    //System.out.println(now);
                h.update(now);
                //camera.update(now);
                a.render(camera.getX(),camera.getY(),a.BackGroundleft);
                //primaryStage.setScene(scene);
                //a.update(now);
                primaryStage.show();
                }
            };


            timer.start();



    }


    public static void main(String[] args) {
        launch(args);
        //GameScene a=new GameScene(1,2,"C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/desert.png",200,300,"C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/desert.png","C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/desert.png");


    }
}

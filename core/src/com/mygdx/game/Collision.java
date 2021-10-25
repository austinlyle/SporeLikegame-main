package com.mygdx.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Collision{

        //global objects
        private Circle playerCirc = new Circle();
        private Circle enemyCirc =  new Circle();
        private Actor playerActor;
        private Actor enemyActor;

        public void setCircles(Actor playerActor, Actor enemyActor){

            //receive our created actors in main function and pass them to be stored
            //locally in our method
            this.playerActor = playerActor;
            this.enemyActor = enemyActor;

        //Makes a new circle object and passes the PLAYER ACTORS
        //height and width and adds on the width while dividing it by 2 to find center of actor
        //passes width/2 as radius
           this.playerCirc.setX(this.playerActor.getX() + this.playerActor.getWidth()/2);
           this.playerCirc.setY(this.playerActor.getY() + this.playerActor.getHeight()/2);
           this.playerCirc.setRadius(this.playerActor.getWidth()/2);
           //Error checking:
           //System.out.println("PLAYER WIDTH: "+playerActor.getWidth());


        //Makes a new circle object and passes the ENEMY ACTORS
        //height and width as x and y + width/2 to find the center of the actor
        //passes radius as width/2
            this.enemyCirc.setX(this.enemyActor.getX() + this.enemyActor.getWidth()/2);
            this.enemyCirc.setY(this.enemyActor.getY() + this.enemyActor.getHeight()/2);
            this.enemyCirc.setRadius(this.enemyActor.getWidth()/2);
            //Error Checking:
            //System.out.println("Enemy Width: "+enemyActor.getWidth());

        }

//Just runs isCirclesColliding in an if statement
    public boolean isCollide() {
        //Error checking:
        //System.out.println("ACTOR START X: " +playerActor.getX()+ "Y: "+playerActor.getY());

       if (isCirclesColliding(playerCirc, enemyCirc)) {
           //Error checking:
           System.out.println("Collision");

           return true;
       }
       return false;

    }
    //Collision detection?
     private boolean isCirclesColliding(Circle cir1, Circle cir2) {

        float sidea = Math.abs(cir1.x - cir2.x);
        float sideb = Math.abs(cir1.y - cir2.y);
        sidea = sidea * sidea;
        sideb = sideb * sideb;
        float distance = (float) Math.sqrt(sidea + sideb);
        if (distance < cir1.radius + cir2.radius) {
            return true;
        }
        return false;


    }



        }






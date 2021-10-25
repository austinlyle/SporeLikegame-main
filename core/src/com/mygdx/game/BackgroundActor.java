package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


//Just a simple class for our background image
//
public class BackgroundActor extends Actor {

    //Creates sprite and feeds it the image
    Sprite sprite = new Sprite (new Texture(Gdx.files.internal("background.jpg")));

    public BackgroundActor() {}




    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Starting Pos
        sprite.setPosition(0,0);
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
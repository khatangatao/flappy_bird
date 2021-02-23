package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyDemo;

public class PlayState extends State {
    private Texture bird;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Texture("bird.png");
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dl) {

    }

    @Override
    public void render(SpriteBatch sb) {
        // привязка SpriteBatch к нашей камере, так как нам нужно отображать только те
        //объекты, который попали в область видимости камеры (camera viewport)
        sb.setProjectionMatrix(cam.combined);


        sb.begin();
        sb.draw(bird, 50, 50);

        sb.end();
    }

    @Override
    public void dispose() {
        bird.dispose();
    }
}

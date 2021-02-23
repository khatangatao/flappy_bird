package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyDemo;
import com.mygdx.game.sprites.Bird;

public class PlayState extends State {
    private Bird bird;
    private Texture bg;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 100);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        // привязка SpriteBatch к нашей камере, так как нам нужно отображать только те
        //объекты, который попали в область видимости камеры (camera viewport)
        sb.setProjectionMatrix(cam.combined);


        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        //bird.dispose();
    }
}

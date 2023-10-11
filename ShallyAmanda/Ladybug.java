import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class ladybug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ladybug extends Actor {
    private int velocity = 0;
    private int score = 0;
    private boolean scored = false;

    public Ladybug() {
        setImage(new GreenfootImage("fly.png"));
    }

    public void act() {
        handleKeyPress();
        fall();
        checkCollision();
        checkScore();
    }

    private void handleKeyPress() {
        if (Greenfoot.isKeyDown("space")) {
            velocity = -10;
        }
    }

    private void fall() {
        setLocation(getX(), getY() + velocity);
        velocity += 1;
    }

    private void checkCollision() {
        if (isTouching(Pipe.class)) {
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() /2);
            Greenfoot.stop();
        }
    }

    private void checkScore() {
        FlappyBird world = (FlappyBird) getWorld();
        List<Pipe> pipes = world.getObjects(Pipe.class);

        for (Pipe pipe : pipes) {
            if (getX() > pipe.getX() && !scored) {
                score++;
                world.showText("Score: " + score, 60, 30);
                scored = true;
                world.removeObject(pipe);
            }
        }
    }
}

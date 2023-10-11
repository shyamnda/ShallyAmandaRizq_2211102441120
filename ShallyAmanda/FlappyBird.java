import greenfoot.*;
import java.util.List;

public class FlappyBird extends World {
    private Ladybug ladybug;
    private int pipeSpawnDelay = 100;
    private int pipeSpawnCounter = 0;
    private int score = 0;

    public FlappyBird() 
    {    
        super(400, 600, 1);
        ladybug = new Ladybug();
        addObject(ladybug, 100, getHeight() / 2);
        showText("Score: 0", 60, 30);
    }

    public void act() {
        spawnPipes();
        updateScore();
    }

    private void spawnPipes() {
        if (pipeSpawnCounter == pipeSpawnDelay) {
            Pipe pipe = new Pipe();
            addObject(pipe, getWidth(), Greenfoot.getRandomNumber(getHeight() - 200) + 100);
            pipeSpawnCounter = 0;
        }
        pipeSpawnCounter++;
    }
    
    private void updateScore() {
        score++;
        showText("Score: " + score, 60, 30);
    }
}




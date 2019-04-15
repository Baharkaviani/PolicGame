import java.util.concurrent.ThreadLocalRandom;

public class theif {
    private int x,y;
    private int maxX, maxY;
    private int randomNum ;// = ThreadLocalRandom.current().nextInt(min, max + 1);

    public theif(int x, int y, int maxX, int maxY){
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void move(int x, int y){
        //x move
        if((x > 0) && (x < maxX)) {
            randomNum = ThreadLocalRandom.current().nextInt(-1, 2);
            x += randomNum;
        }
        else if(x == 0){
            randomNum = ThreadLocalRandom.current().nextInt(0, 2);
            x += randomNum;
        }
        else if(x == maxX){
            randomNum = ThreadLocalRandom.current().nextInt(-1, 1);
            x += randomNum;
        }
        //y move
        if((y > 0) && (y < maxY)) {
            randomNum = ThreadLocalRandom.current().nextInt(-1, 2);
            y += randomNum;
        }
        else if(y == 0){
            randomNum = ThreadLocalRandom.current().nextInt(0, 2);
            y += randomNum;
        }
        else if(y == maxY){
            randomNum = ThreadLocalRandom.current().nextInt(-1, 1);
            y += randomNum;
        }
    }

    //getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

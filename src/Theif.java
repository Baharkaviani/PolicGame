import java.util.concurrent.ThreadLocalRandom;

public class Theif {
    private int x,y;
    private int maxX, maxY;
    private int randomNum ;// = ThreadLocalRandom.current().nextInt(min, max + 1);

    public Theif(int x, int y, int maxX, int maxY){
        this.x = x;
        this.y = y;
        this.maxX = maxX - 1;
        this.maxY = maxY - 1;
    }

    public void move(){
        if((x > 0) && (x < maxX)) {
            if ((y > 0) && (y < maxY))
                randomNum = ThreadLocalRandom.current().nextInt(1, 9);
            else if(y == 0)
                randomNum = ThreadLocalRandom.current().nextInt(4, 9);
            else if(y == maxY) {
                randomNum = ThreadLocalRandom.current().nextInt(1, 6);
                if(randomNum == 5)
                    randomNum = 8;
            }
        }
        else if(x == 0){
            if ((y > 0) && (y < maxY))
                randomNum = ThreadLocalRandom.current().nextInt(2, 7);
            else if(y == 0)
                randomNum = ThreadLocalRandom.current().nextInt(4, 7);
            else if(y == maxY)
                randomNum = ThreadLocalRandom.current().nextInt(2, 5);
        }
        else if(x == maxX){
            if ((y > 0) && (y < maxY)) {
                randomNum = ThreadLocalRandom.current().nextInt(4, 9);
                if(randomNum == 4)
                    randomNum = 1;
                if(randomNum == 5)
                    randomNum = 2;
            }
            else if(y == 0)
                randomNum = ThreadLocalRandom.current().nextInt(6, 9);
            else if(y == maxY) {
                randomNum = ThreadLocalRandom.current().nextInt(1, 4);
                if(randomNum == 3)
                    randomNum = 8;
            }
        }
        if (maxX == 0){
            if (y == 0)
                randomNum = 6;
            if (y == maxY)
                randomNum = 2;
        }
        if(maxY == 0){
            if (x == 0)
                randomNum = 4;
            if (x == maxX)
                randomNum = 8;
        }
        switch (randomNum) {
            case 1:
                x--;
                y--;
                break;
            case 2:
                y--;
                break;
            case 3:
                x++;
                y--;
                break;
            case 4:
                x++;
                break;
            case 5:
                x++;
                y++;
                break;
            case 6:
                y++;
                break;
            case 7:
                x--;
                y++;
                break;
            case 8:
                x--;
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

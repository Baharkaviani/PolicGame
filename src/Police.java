public class Police {
    private int x, y, lastX, lastY;
    private boolean thiefSeen;

    public Police(int x, int y){
        this.x = x;
        this.y = y;
        lastX = -1;
        lastY = -1;
        thiefSeen = false;
    }

    //getter
    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isThiefSeen() {
        return thiefSeen;
    }

    //setter
    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setThiefSeen(boolean thiefSeen) {
        this.thiefSeen = thiefSeen;
    }
}

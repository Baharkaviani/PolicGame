import java.util.concurrent.ThreadLocalRandom;

public class Ground {
    private int policeNum, policeMoves, thiefMoves;
    private int row, column;
    private Police[] polices;
    private int[][] ground;
    private Theif theif;
    private boolean thiefSeen;
    private boolean catchThief;

    public Ground(int column, int row, int policeNum){
        this.policeNum = policeNum;
        this.row = row;
        this.column = column;
        polices = new Police[policeNum];
        ground = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ground[i][j] = -1;
            }
        }
        catchThief = false;
    }

    public void thiefSeen(){
        thiefSeen = false;
        for (int i = 0; i < policeNum; i++) {
            double distance = Math.pow((double)Math.abs(polices[i].getX() - theif.getX()), 2.0) + Math.pow((double) Math.abs(polices[i].getY() - theif.getY()), 2.0);
            if(distance <= 8){
                thiefSeen = true;
                break;
            }
        }
    }

    public void firstCoordinates(){
        //coordinates for polices
        for (int i = 0; i < policeNum; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, column);
            int y = ThreadLocalRandom.current().nextInt(0, row);
            while (ground[y][x] == 1){
                x = ThreadLocalRandom.current().nextInt(0, column);
                y = ThreadLocalRandom.current().nextInt(0, row);
            }
            polices[i] = new Police(x, y, column, row);
            ground[polices[i].getY()][polices[i].getX()] = 1;
        }
        //coordinates for theif
        int x = ThreadLocalRandom.current().nextInt(0, column);
        int y = ThreadLocalRandom.current().nextInt(0, row);
        while (ground[y][x] == 1){
            x = ThreadLocalRandom.current().nextInt(0, column);
            y = ThreadLocalRandom.current().nextInt(0, row);
        }
        theif = new Theif(x, y, column, row);
        ground[theif.getY()][theif.getX()] = 0;
        show();
        coordinates();
    }

    public void coordinates(){
        thiefSeen();
        if(!thiefSeen) {
            for (int i = 0; i < policeNum; i++) {
                polices[i].setLastX(polices[i].getX());
                polices[i].setLastY(polices[i].getY());
                polices[i].move();
            }
            theif.move();
            policeMoves += policeNum;
            thiefMoves += 1;
            show();
        }
        else {
            for (int i = 0; i < policeNum; i++) {
                polices[i].setLastX(polices[i].getX());
                polices[i].setLastY(polices[i].getY());
                polices[i].logicMove(theif.getX(), theif.getY());
            }
            theif.move();
            policeMoves += policeNum;
            thiefMoves += 1;
            show();
        }
        if(!catchThief)
            coordinates();
        else {
            System.out.println("THE THIEF WAS CATCHED");
            System.out.println("policeMoves = " + policeMoves);
            System.out.println("thiefMoves = " + thiefMoves);
        }
    }

    public void show(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ground[i][j] = -1;
            }
        }
        for (int i = 0; i < policeNum; i++) {
            ground[polices[i].getY()][polices[i].getX()] = 1;
            if ((polices[i].getLastX() == theif.getX()) && (polices[i].getLastY() == theif.getY())) {
                catchThief = true;
            }
            if ((polices[i].getX() == theif.getX()) && (polices[i].getY() == theif.getY()))
                catchThief = true;
        }
        ground[theif.getY()][theif.getX()] = 0;

        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < column; j++) {
                if(ground[i][j] == -1)
                    System.out.print("-|");
                else if(ground[i][j] == 0)
                    System.out.print("D|");
                else if(ground[i][j] == 1)
                    System.out.print("P|");
            }
            System.out.println();
        }
        System.out.println();
        //waiting 2 seconds
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

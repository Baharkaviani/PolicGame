import java.util.concurrent.ThreadLocalRandom;

public class Ground {
    private int policeNum;
    private int row, column;
    private Police[] polices;
    private int[][] ground;
    private Theif theif;
    private boolean thiefSeen;

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
        thiefSeen = false;
    }

    public void thiefSeen(){
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
        if(thiefSeen == false) {
            for (int i = 0; i < policeNum; i++) {
                polices[i].move();
            }
            theif.move();
            show();
        }
        else {
            for (int i = 0; i < policeNum; i++) {
                //polices[i].logicMove();
            }
            theif.move();
            show();
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
        }
        ground[theif.getY()][theif.getX()] = 0;

        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < column; j++) {
                if(ground[i][j] == -1)
                    System.out.print(" |");
                else if(ground[i][j] == 0)
                    System.out.print("*|");
                else if(ground[i][j] == 1)
                    System.out.print("-|");
            }
            System.out.println();
        }
    }
}

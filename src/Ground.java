import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Ground {
    private int policeNum;
    private int row, column;
    private Police[] polices;
    private HashMap<Integer, Integer> coordinates;
    private int[][] ground;
    private Theif theif;

    public Ground(int column, int row, int policeNum){
        this.policeNum = policeNum;
        this.row = row;
        this.column = column;
        polices = new Police[policeNum];
        ground = new int[row][column];
        coordinates = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ground[i][j] = -1;
            }
        }
    }

    public void firstCoordinates(){
        //coordinates for polices
        System.out.println("column = " + column);
        System.out.println("row = " + row);
        for (int i = 0; i < policeNum; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, column);
            int y = ThreadLocalRandom.current().nextInt(0, row);
            while (ground[y][x] == 1){
                x = ThreadLocalRandom.current().nextInt(0, column);
                y = ThreadLocalRandom.current().nextInt(0, row);
            }
            System.out.println("x = " + x);
            polices[i] = new Police(x, y);
            ground[y][x] = 1;
        }
        //coordinates for theif
        int x = ThreadLocalRandom.current().nextInt(0, column);
        int y = ThreadLocalRandom.current().nextInt(0, row);
        while (ground[y][x] == 1){
            x = ThreadLocalRandom.current().nextInt(0, column);
            y = ThreadLocalRandom.current().nextInt(0, row);
        }
        theif = new Theif(x, y, column, row);
        ground[y][x] = 0;

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
//
    public void show(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

            }
        }
    }
}

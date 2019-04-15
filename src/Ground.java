import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Ground {
    private int policeNum;
    private int row, column;
    private Police[] polices;
    private int[][] ground;
    private Theif theif;

    public Ground(int row, int column, int policeNum){
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
    }

    public void firstCoordinates(){
        ArrayList<Integer> listX = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            listX.add(new Integer(i));
        }
        Collections.shuffle(listX);
        //coordinates for polices
        for (int i = 0; i < policeNum; i++) {
            int x = listX.get(i);
            int y = ThreadLocalRandom.current().nextInt(0, column + 1);
            polices[i] = new Police(x, y);
            ground[x][y] = 1;
        }
        //coordinates for theif
        int x = listX.get(policeNum);
        int y = ThreadLocalRandom.current().nextInt(0, column + 1);
        theif = new Theif(x, y, row, column);
        ground[x][y] = 0;

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

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class labPolice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt(), column = scanner.nextInt(), policeNum = scanner.nextInt();
        Ground ground = new Ground(row, column, policeNum);
        ground.firstCoordinates();
    }
}

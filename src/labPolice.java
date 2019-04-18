import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class labPolice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt(), row = scanner.nextInt(), policeNum = scanner.nextInt();
        Ground ground = new Ground(column, row, policeNum);
        ground.firstCoordinates();
    }
}

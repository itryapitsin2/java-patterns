package problems.easy.DesignParkingSystem;


public class Main {
    public static void main(String[] args) {
        ParkingSystem1 solution1 = new ParkingSystem1(1,1,0);
        System.out.printf("Solution1: " + solution1.addCar(1) + "\n");
        System.out.printf("Solution1: " + solution1.addCar(2) + "\n");
        System.out.printf("Solution1: " + solution1.addCar(3) + "\n");
        System.out.printf("Solution1: " + solution1.addCar(1) + "\n");

        ParkingSystem2 solution2 = new ParkingSystem2(1,1,0);
        System.out.printf("Solution1: " + solution2.addCar(1) + "\n");
        System.out.printf("Solution1: " + solution2.addCar(2) + "\n");
        System.out.printf("Solution1: " + solution2.addCar(3) + "\n");
        System.out.printf("Solution1: " + solution2.addCar(1) + "\n");

    }
}
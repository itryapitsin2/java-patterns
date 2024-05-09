package problems.DesignParkingSystem;

public class ParkingSystem2 {

    int[] occupied = new int[4];
    int[] total = new int[4];

    public ParkingSystem2(int big, int medium, int small) {
        total[1] = big;
        total[2] = medium;
        total[3] = small;
    }

    public boolean addCar(int carType) {
        if(occupied[carType] < total[carType]){
            occupied[carType]++;
            return true;
        }
        return false;
    }
}
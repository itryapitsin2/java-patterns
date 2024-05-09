package problems.DesignParkingSystem;

public class ParkingSystem1 {

    private int big = 0;
    private int medium = 0;
    private int small = 0;

    public ParkingSystem1(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big > 0) {
                    big -= 1;
                    return true;
                }
                return false;
            case 2:
                if (medium > 0) {
                    medium -= 1;
                    return true;
                }
                return false;
            case 3:
                if (small > 0) {
                    small -= 1;
                    return true;
                }
                return false;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
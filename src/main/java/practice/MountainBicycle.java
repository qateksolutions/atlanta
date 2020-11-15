package practice;

public class MountainBicycle extends Bicycle{
    public int seatHeight;

    public MountainBicycle(int gear, int speed, int seatHeight) {
        super(gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setHeight(int height) {
        seatHeight = height;
    }

    public String printInfo() {
        String info = super.printInfo() + " Seat height is: " + seatHeight;
        return info;
    }
}

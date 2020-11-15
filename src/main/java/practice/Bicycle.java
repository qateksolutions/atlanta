package practice;

public class Bicycle {
    public int gear;
    public int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement; // speed = speed - decrement;
    }

    public void speedUp(int increment) {
        speed += increment; // speed = speed + decrement;
    }

    public String printInfo() {
        String info = "No of gears are: " + gear + " speed of bicycle is: " + speed;
        return info;
    }
}

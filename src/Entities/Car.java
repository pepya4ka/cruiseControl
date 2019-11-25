package Entities;

import java.lang.Thread;

public class Car extends Thread {
    private float speed;
    private boolean cruise;
    private boolean isParked;
    private float currentLimit;
    private boolean brake;
    private float distance;
    private float amountOfFuel;

    public Car() {
        this.speed = 0;
        this.cruise = false;
        this.isParked = false;
        this.brake = false;
        this.distance = 0;
        this.amountOfFuel = 0;
    }

    @Override
    public void run() {
        int i = 0;
        while (!isParked) {
            while (cruise) {
                currentLimit = speed;
                i++;
                distance += speed;
                amountOfFuel += amountOfFuel * 0.001;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (brake) {
                speed-=0.01;
                i++;
                distance += speed;
                amountOfFuel += distance * .04f;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!brake) break;
            } while (!cruise && !brake) {
                speed += 0.8;
                i++;
                distance += speed;
                amountOfFuel += distance * .04f;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public void setCruise(boolean cruise) {
        this.cruise = cruise;
    }
    public void setParked(boolean parked) {
        isParked = parked;
    }
    public void setCurrentLimit(float currentLimit) {
        this.currentLimit = currentLimit;
    }
    public void setBrake(boolean brake) {
        this.brake = brake;
    }

    public float getAmountOfFuel() {
        return amountOfFuel;
    }
    public float getSpeed() {
        return speed;
    }
    public float getDistance() {
        return distance;
    }
    public boolean isCruise() {
        return cruise;
    }
    public boolean isParked() {
        return isParked;
    }
    public float getCurrentLimit() {
        return currentLimit;
    }
    public boolean isBrake() {
        return brake;
    }
}

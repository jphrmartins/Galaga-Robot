import robocode.*;

public class Galaga extends Robot {
	private Boolean goRight = true;
    public void run() {
        while(true) {
            if(goRight) {
                turnRight(360);
            } else {
                turnLeft(360);        
            }
        }
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        goRight = e.getBearing() >= 0;        
        turnRight(e.getBearing());
        ahead(30);
        if (e.getDistance() > 200 || getEnergy() < 15) {
            fire(1);
        } else if (e.getDistance() > 50) {
            fire(2);
        } else {
            fire(3);
        }
        scan();
    }
    
    public void onHitWall(HitWallEvent e) {
        if(e.getBearing() >= -90 && e.getBearing() <= 90) {
            back(20);
            scan();
        }
    }

     public void onHitRobot(HitRobotEvent e) {
        turnRight(e.getBearing());
        if (e.getEnergy() > 16) {
            fire(3);
        } else if (e.getEnergy() > 10) {
            fire(2);
        } else {
            fire(1);
        }
        ahead(70);    
    }  	
}
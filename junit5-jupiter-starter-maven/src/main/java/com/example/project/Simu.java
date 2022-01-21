package com.example.project;
import java.util.Random;

// a = rand(num) num%2 == 0 >> on esle off
public class Simu {
	
Random rand = new Random();
int n = rand.nextInt(1); // use the one after =


	public int ignition(){
		int ignitionStatus = 1; 
		//ignitionStatus = rand.nextInt(1);
		return ignitionStatus;
	}

	public int selftest(){
		int result = 0;

		int fuel = 10; 			// rand
		fuel = rand.nextInt(15);
		int tirePressure = 1;	// rand
		int radar = 1;			// rand
		
		if(fuel > 1 && tirePressure == 1 && radar == 1){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}

	public String checkStatus(){
		int a = 0; // rand
		String result = "";

		if(a == 0){
			result = "Follower";
		} else{
			result = "Leader";
		}
		return result;
	}

	public String enterPlatoon(){
		int a = 0; // rand
		String result = "";

		if(a == 0){
			result = "Allowed";
		} else{
			result = "No";
		}
		return result;
	}

	public String allowDrive(){
		String result = "DriverInTruck";
		return result;
	}

	public String right(){
		String a = "steerLeft";
		return a;
	}

	public String left(){
		String a = "steerRight";
		return a;
	}

	public String steering() {
		int number = 0; // rand 0-2
		String result = "";

		switch(number){
			case 0:
			result = right();
			break;

			case 1:
			result = left();
			break;

			default:
			result = "braking";
		}
		return result;
	}

	public String acceleration() {
		int number = 0; // rand 0-2
		String result = "";
		switch(number){
			case 0:
			result = "accelerate";
			break;

			case 1:
			result = "decelerate";
			break;

			default:
			result = "idle";
		}
		return result;
	}
	
	public String communication() {
		int number = 0; // rand 0-1
		String result = "";
		
		if(number == 0){
			result = "sendMessage";
		}else{
			result = "receiveMessage";
		}
		return result;
	}

	public String cruise(int a){
		String ignitionReport = "";
		String selftestReport = "";
		String statusReport = "";
		String platoonReport = "";

		if (ignition() == 1){
			ignitionReport = "IgnitionOn";

			if(selftest() == 1){
				selftestReport = "SelftestOk";
				
				if(checkStatus() == "Follower"){
					statusReport = "Follower";
					
					if(enterPlatoon() == "Allowed"){
						platoonReport = "FollowingInProgress";
						steering();
						acceleration();
						communication();
					} else{
						platoonReport = "NoPlatoon";
					}
				} else {
					statusReport = "MainTruck";
					allowDrive();
				}
			} else{
				selftestReport = "SelftestFail";
			}
		} else {
			ignitionReport = "IgnitionOff";
		}

		String[] results = new String[4];
		results[0] = ignitionReport;
		results[1] = selftestReport;
		results[2] = statusReport;
		results[3] = platoonReport;

		String status = results[a];
		return status;
	}
}

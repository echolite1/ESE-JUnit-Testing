package com.example.project;
import java.util.Random;

public class Simu {
	
Random rand = new Random();

	public int ignition(){ // rand 0 1 
		int ignitionStatus = 1; 
		ignitionStatus = rand.nextInt(50);
		return ignitionStatus;
	}

	public int selftest(){ // rand fuel
		int result = 0;

		int fuel = 10; 			// rand
		fuel = rand.nextInt(10);
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
		a = rand.nextInt(2);
		String result = "F";

		if(a == 0){
			result = "F";
		} else{
			result = "Not";
		}
		return result;
	}

	public String enterPlatoon(){
		int a = 0; // rand
		String result = "Allowed";

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

	public String positioning() { // rand 1 2 3
		int number = 2; // rand 0-2
		number = rand.nextInt(5);
		String result = "braking";

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

	public String airbags(int type){ // rand INPUT 1 2 3
		String result = "NoData";
		String feedback = "NoData";

		switch(type){
			case 0:
			result = "heavyImpact";
			feedback = deployAirbags(type);
			break;

			case 1:
			result = "lightImpact";
			feedback = deployAirbags(type);
			break;

			default:
			result = "rapidBraking";
		}
		return result;
	}

	public String deployAirbags(int a){
		String result = "NoData";
		if(a == 1){
			result = "deployAll";
		} else{
			result = "deployOnlyFront";
		}
		return result;
	}

	public String acceleration() { // rand 1 2 3
		int number = 2; // rand 0-2
		number = rand.nextInt(5);
		String result = "keep";

		switch(number){
			case 0:
			result = "accelerate";
			break;

			case 1:
			result = "decelerate";
			break;

			default:
			result = "keep";
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
		String ignitionReport = "NoData";
		String selftestReport = "NoData";
		String statusReport = "NoData";
		String platoonReport = "NoData";

		if (ignition() >= 1){
			ignitionReport = "IgnitionOn";

			if(selftest() == 1){
				selftestReport = "SelftestOk";
				
				if(checkStatus() == "F"){
					statusReport = "Follower";
					
					if(enterPlatoon() == "Allowed"){
						platoonReport = "FollowingInProgress";

						positioning();
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

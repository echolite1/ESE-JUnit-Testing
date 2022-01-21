package com.example.project;

public class Calculator {

	public int decelerate(int a){
		a = 10;
		return a;
	}

	public int accelerate(int a){
		a = 5;
		return a;
	}

	public int cruise(int distance) {

		switch(distance){
			case 1:
			distance = decelerate(distance);
			break;

			case 10:
			distance = accelerate(distance);
			break;

			default:
			distance = 0;
		}

		return distance;
	}

	public String right(String a){
		a = "left";
		return a;
	}

	public String left(String a){
		a = "right";
		return a;
	}

	public String steer(String obstacle) {

		switch(obstacle){
			case "right":
			obstacle = right(obstacle);
			break;

			case "left":
			obstacle = left(obstacle);
			break;

			default:
			obstacle = "braking";
		}

		return obstacle;
	}

	public String accept(String a){
		a = "connected";
		return a;
	}

	public String reject(String a){
		a = "not able to connect";
		return a;
	}

	public String communicate(String connection){

		switch(connection){
			case "goodRequest":
			connection = accept(connection);
			break;

			case "badRequest":
			connection = reject(connection);
			break;

			default:
			connection = "input error";
			break;
		}

		return connection;
	}
}

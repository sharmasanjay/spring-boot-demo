package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ReqResModel {
	private int goal;
	private int step;
	private String task;
	
	public ReqResModel() {
	}
	
	public ReqResModel(int goal, int step, String task) {
		super();
		this.goal = goal;
		this.step = step;
		this.task = task;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}

}

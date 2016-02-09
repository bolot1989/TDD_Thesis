package diploma;

import java.util.*;

public class Frame {
	//the score of a single frame
	private int firstThrow;
	private int secondThrow;
	private List<Integer> bonus = new ArrayList<Integer>();
	private boolean lastFrame;
	private boolean spare = false;
	private boolean strike = false;
	
	public int getFirstThrow() {
		return firstThrow;		
	}
	
	public int getSecondThrow() {
		return secondThrow;		
	}
	
	public int score(){
		int sum = 0;
		
		sum += this.firstThrow;
		sum += this.secondThrow;
		
		return sum;
	}
	
	public Frame(int firstThrow, int secondThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public String showTwoElements() {
		
		String elems = String.valueOf(this.firstThrow) + " " + String.valueOf(this.secondThrow) + " ";
		
		return elems;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		if(this.firstThrow == 10) {
			strike = true;
		}
		
		return strike;
	}
		
	public boolean checkFirstThrow(int point) {
		return (this.firstThrow == point) ? true : false;
	}
	
	public boolean checkSecondThrow(int point) {
		return (this.secondThrow == point) ? true : false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		
		if((this.firstThrow <= 9) && (this.firstThrow + this.secondThrow == 10)) {
			spare = true;
		}
		
		return spare;
	}

	public void addBonus(int bonus) {
		this.bonus.add(bonus);
	}
	
	public int bonus(){
		int sumBonus = 0;
		for(Integer nums: this.bonus) {
			sumBonus += nums;			
		}
		return sumBonus;
	}
}

package diploma;

import java.util.*;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
		
	public BowlingGame(){
		
	}
		
	public void addFrame(Frame frame){
		//to be implemented
		frames.add(frame);
	}
	
	public boolean checkFrames() {
		return frames.isEmpty();	
	}
	
	public Frame getFirstFrame() {
		return frames.get(0);		
	}
	
	public int numberOfFrames() {
		return frames.size();
	}
	
	public void clearFrames() {
		frames.clear();		
	}
	
	public void removeIndexOfAnElement(int index) {
		if(frames.contains(frames.get(index)) == true) {
			frames.remove(index);
		}
		else {
			System.out.println("Element doesn't exist");
		}
	}
	
	public String showAllElements() {
		String elems = "";
		for(Frame frame: frames)	{
			elems += frame.showTwoElements();
		}
		
		return elems;
	}
	
	public int computeScore() {
		// TODO Auto-generated method stub
		int sum = 0;
		int strikeCount = 0;
		for(int i = 0; i < frames.size(); i++) {
			
			if(i == frames.size() - 1) {
				if(frames.get(i).isSpare() == true) {
					sum += frames.get(i).bonus();
				}
				else if(frames.get(i).isStrike() == true) {
					sum += frames.get(i).bonus();
					strikeCount++;
					if(strikeCount == 10)
						sum += strikeCount;
				}
			}
			
			
			if((frames.get(i).isStrike() == true) && (i < frames.size() - 1)) {
				strikeCount++;
				sum += frames.get(i + 1).score();
				if((frames.get(i+1).isStrike() == true) && (i < frames.size() - 2)) {
					sum += frames.get(i+2).getFirstThrow();
				}
				
			}
			else if((frames.get(i).isSpare() == true) && (i < frames.size()-1)) {
				sum += frames.get(i + 1).getFirstThrow();
			}
			
						
			sum += frames.get(i).score();
		}
		
		return sum;
	}
		

}

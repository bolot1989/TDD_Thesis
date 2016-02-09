package diploma;

import static org.junit.Assert.*;

import org.junit.Test;

//The goal of this package is to teach students how to apply TDD methodology in real life examples
//It is important to test only the output of certain functionality and not mix the real code with the testing class
//The test generation is synchronous to the complexity of the game. It means that initial tests check the most basic functionality
//Each test case check basic rules of the game. The external or edge test cases aren't checked. It is unnecessary because it will increase the complexity
//Thus, the development time will be increased as well. It also doesn't meet our goal because we want students to focus primarily on understanding how to apply TDD
//Each test case should be briefly described by method names which reveal test purpose



public class TestBowlingScoreKeeper {
	
	
	BowlingGame bowlingGame = new BowlingGame();
	
	@Test
	public void defineFrame() {
		Frame frame = new Frame(2, 4);
		bowlingGame.addFrame(frame);
		
		assertEquals(false, bowlingGame.checkFrames());
		bowlingGame.removeIndexOfAnElement(0);
	}
	//In the 1st we define the frame. Within each frame there should be 2 throws. 
	//The throws are initialized in the constructor of the frame  
	
	@Test
	public void checkThrows() {
		Frame frame = new Frame(2, 4);
		
		assertTrue(frame.checkFirstThrow(2));
		assertTrue(frame.checkSecondThrow(4));
	}
	
	
	@Test
	public void checkScoreAfterFirstThrow() {
		Frame firstFrame = new Frame(2, 6);
				
		assertEquals(8, firstFrame.score());
		
		Frame secondFrame = new Frame(0, 9);
		
		assertEquals(9, secondFrame.score());
	}
	//The goal of this test is to calculate basic throws because it is basic brick of functionality
	
	@Test
	public void checkAllFrames() {
		Frame frame1 = new Frame(1, 5);
		Frame frame2 = new Frame(3, 6);
		Frame frame3 = new Frame(7, 2);
		Frame frame4 = new Frame(3, 6);
		Frame frame5 = new Frame(4, 4);
		Frame frame6 = new Frame(5, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(4, 5);
		Frame frame9 = new Frame(8, 1);
		Frame frame10 = new Frame(2, 6);
		
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		bowlingGame.addFrame(frame3);
		bowlingGame.addFrame(frame4);
		bowlingGame.addFrame(frame5);
		bowlingGame.addFrame(frame6);
		bowlingGame.addFrame(frame7);
		bowlingGame.addFrame(frame8);
		bowlingGame.addFrame(frame9);
		bowlingGame.addFrame(frame10);
		
		assertEquals(10, bowlingGame.numberOfFrames());
		
		String points = "1 5 3 6 7 2 3 6 4 4 5 3 3 3 4 5 8 1 2 6 ";
		
		assertEquals(points, bowlingGame.showAllElements());
	}
	//The test checks if the pins in the game are stored
	
	@Test
	public void computeGameScore() {
		Frame frame1 = new Frame(1, 5);
		Frame frame2 = new Frame(3, 6);
		Frame frame3 = new Frame(7, 2);
		Frame frame4 = new Frame(3, 6);
		Frame frame5 = new Frame(4, 4);
		Frame frame6 = new Frame(5, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(4, 5);
		Frame frame9 = new Frame(8, 1);
		Frame frame10 = new Frame(2, 6);
		
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		bowlingGame.addFrame(frame3);
		bowlingGame.addFrame(frame4);
		bowlingGame.addFrame(frame5);
		bowlingGame.addFrame(frame6);
		bowlingGame.addFrame(frame7);
		bowlingGame.addFrame(frame8);
		bowlingGame.addFrame(frame9);
		bowlingGame.addFrame(frame10);
		
		assertEquals(81, bowlingGame.computeScore());
	}
	//The goal of this test is to check how the game can compute ordinary score
	
	
	@Test
	public void computeStrikeOfFrame() {
		Frame frame1 = new Frame(10, 0);
		assertTrue(frame1.isStrike());
		
		Frame frame2 = new Frame(3, 6);
		
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		
		assertEquals(28, bowlingGame.computeScore());
				
		bowlingGame.clearFrames();
		
		Frame frame3 = new Frame(7, 2);
		Frame frame4 = new Frame(3, 6);
		Frame frame5 = new Frame(4, 4);
		Frame frame6 = new Frame(5, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(4, 5);
		Frame frame9 = new Frame(8, 1);
		Frame frame10 = new Frame(2, 6);
		
		
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		bowlingGame.addFrame(frame3);
		bowlingGame.addFrame(frame4);
		bowlingGame.addFrame(frame5);
		bowlingGame.addFrame(frame6);
		bowlingGame.addFrame(frame7);
		bowlingGame.addFrame(frame8);
		bowlingGame.addFrame(frame9);
		bowlingGame.addFrame(frame10);
				
		assertEquals(94, bowlingGame.computeScore());
	}
	
	@Test
	public void computeSpareOfGame() {
		Frame testFrame1 = new Frame(1, 9);
		assertTrue(testFrame1.isSpare());
		
		Frame testFrame2 = new Frame(4, 6);
		assertTrue(testFrame2.isSpare());
		
		Frame testFrame3 = new Frame(7, 3);
		assertTrue(testFrame3.isSpare());
		
		
		Frame testFrame4 = new Frame(1, 9);
		Frame testFrame5 = new Frame(3, 6);
		
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		
		assertEquals(22, bowlingGame.computeScore());
		
		bowlingGame.clearFrames();
		
		Frame frame1 = new Frame(1, 9);
		Frame frame2 = new Frame(3, 6);
		Frame frame3 = new Frame(7, 2);
		Frame frame4 = new Frame(3, 6);
		Frame frame5 = new Frame(4, 4);
		Frame frame6 = new Frame(5, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(4, 5);
		Frame frame9 = new Frame(8, 1);
		Frame frame10 = new Frame(2, 6);
		
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		bowlingGame.addFrame(frame3);
		bowlingGame.addFrame(frame4);
		bowlingGame.addFrame(frame5);
		bowlingGame.addFrame(frame6);
		bowlingGame.addFrame(frame7);
		bowlingGame.addFrame(frame8);
		bowlingGame.addFrame(frame9);
		bowlingGame.addFrame(frame10);
		
		
		assertEquals(88, bowlingGame.computeScore());
	}
	
	@Test 
	public void computeSpareAfterStrike() {
		Frame testFrame1 = new Frame(10, 0);
		assertTrue(testFrame1.isStrike());
		
		Frame testFrame2 = new Frame(4, 6);
		assertTrue(testFrame2.isSpare());
		
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(2, 6);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		assertEquals(103, bowlingGame.computeScore());
	}
	
	@Test
	public void computeMultipleStrikes() {
		Frame testFrame1 = new Frame(10, 0);
		Frame testFrame2 = new Frame(10, 0);
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(2, 6);
		
		assertTrue(testFrame1.isStrike());
		assertTrue(testFrame2.isStrike());
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		
		
		assertEquals(112, bowlingGame.computeScore());
	}
	
	@Test
	public void computeMultipleSpares() {
		Frame testFrame1 = new Frame(8, 2);
		Frame testFrame2 = new Frame(5, 5);
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(2, 6);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		
		assertEquals(98, bowlingGame.computeScore());
	}
	
	@Test 
	public void computeLastSpare() {
		Frame testFrame1 = new Frame(1, 5);
		Frame testFrame2 = new Frame(3, 6);
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(2, 8);
		testFrame10.addBonus(7);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		
		
		assertEquals(90, bowlingGame.computeScore());
	}
	
	@Test 
	public void computeLastStrike() {
		Frame testFrame1 = new Frame(1, 5);
		Frame testFrame2 = new Frame(3, 6);
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(10, 0);
		testFrame10.addBonus(7);
		testFrame10.addBonus(2);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		
		
		assertEquals(92, bowlingGame.computeScore());
	}
	
	
	@Test 
	public void computeBonusStrike() {
		Frame testFrame1 = new Frame(1, 5);
		Frame testFrame2 = new Frame(3, 6);
		Frame testFrame3 = new Frame(7, 2);
		Frame testFrame4 = new Frame(3, 6);
		Frame testFrame5 = new Frame(4, 4);
		Frame testFrame6 = new Frame(5, 3);
		Frame testFrame7 = new Frame(3, 3);
		Frame testFrame8 = new Frame(4, 5);
		Frame testFrame9 = new Frame(8, 1);
		Frame testFrame10 = new Frame(2, 8);
		testFrame10.addBonus(10);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
		
		
		assertEquals(93, bowlingGame.computeScore());
	}
	
	@Test 
	public void computeBestScore() {
		Frame testFrame1 = new Frame(10, 0);
		Frame testFrame2 = new Frame(10, 0);
		Frame testFrame3 = new Frame(10, 0);
		Frame testFrame4 = new Frame(10, 0);
		Frame testFrame5 = new Frame(10, 0);
		Frame testFrame6 = new Frame(10, 0);
		Frame testFrame7 = new Frame(10, 0);
		Frame testFrame8 = new Frame(10, 0);
		Frame testFrame9 = new Frame(10, 0);
		Frame testFrame10 = new Frame(10, 0);
		testFrame10.addBonus(10);
		testFrame10.addBonus(10);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
				
		assertEquals(300, bowlingGame.computeScore());
	}
	
	@Test 
	public void computeRealGameScore() {
		Frame testFrame1 = new Frame(6, 3);
		Frame testFrame2 = new Frame(7, 1);
		Frame testFrame3 = new Frame(8, 2);
		Frame testFrame4 = new Frame(7, 2);
		Frame testFrame5 = new Frame(10, 0);
		Frame testFrame6 = new Frame(6, 2);
		Frame testFrame7 = new Frame(7, 3);
		Frame testFrame8 = new Frame(8, 0);
		Frame testFrame9 = new Frame(7, 3);
		Frame testFrame10 = new Frame(10, 0);
		testFrame10.addBonus(10);
		
		bowlingGame.addFrame(testFrame1);
		bowlingGame.addFrame(testFrame2);
		bowlingGame.addFrame(testFrame3);
		bowlingGame.addFrame(testFrame4);
		bowlingGame.addFrame(testFrame5);
		bowlingGame.addFrame(testFrame6);
		bowlingGame.addFrame(testFrame7);
		bowlingGame.addFrame(testFrame8);
		bowlingGame.addFrame(testFrame9);
		bowlingGame.addFrame(testFrame10);
				
		assertEquals(135, bowlingGame.computeScore());
	}

}

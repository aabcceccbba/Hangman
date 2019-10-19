/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */
import java.awt.Label;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GOval;

public class HangmanCanvas extends GCanvas {
	
	// create reset
	void create_reset() {
	    GLine scaffold = new GLine(100, 100, 100, SCAFFOLD_HEIGHT + 100);
	    GLine beam = new GLine(100, 100, 100 + BEAM_LENGTH, 100);
	    GLine rope = new GLine(100 + BEAM_LENGTH, 100, 100 + BEAM_LENGTH, 100 + ROPE_LENGTH);
	    this.add(scaffold);
	    this.add(beam);
	    this.add(rope);		
	}
	
	// create head
	void create_head() {
		GOval circle = new GOval(100 + BEAM_LENGTH - HEAD_RADIUS, 100 + ROPE_LENGTH, HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		this.add(circle);
	}
	
	// create body
	void create_body() {
		GLine line = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS, 100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH);
		this.add(line);
	}
	
	// create left hand
	void create_lefthand() {
		GLine upper = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		GLine lower = new GLine(100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		this.add(lower);
		this.add(upper);
	}
	
	// create right hand
	void create_righthand() {
		GLine upper = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		GLine lower = new GLine(100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		this.add(lower);
		this.add(upper);
	}
	
	// create left leg
	void create_leftleg() {
		GLine upper = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH);
		GLine lower = new GLine(100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		this.add(upper);
		this.add(lower);
	}
	
	// create right leg
	void create_rightleg() {
		GLine upper = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH);
		GLine lower = new GLine(100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		this.add(upper);
		this.add(lower);
	}
	
	// create left feet
	void create_leftfoot() {
		GLine line = new GLine(100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		this.add(line);	
	}
	
	// create right feet
	void create_rightfoot() {
		GLine line = new GLine(100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, 100 + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		this.add(line);
	}
	
	/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		this.removeAll();
		create_reset();
	}
	
	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game. The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
 	*/
	public void displayWord(String word) {
		/* You fill this in */
		Label update_word = new Label(word);
		this.add(update_word);
//		this.print(word);
	}
	
	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user. Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public void noteIncorrectGuess(int lives) {
		/* You fill this in */
		switch(lives) {
		case 7: this.create_head(); break;
		case 6: this.create_body(); break;
		case 5: this.create_lefthand(); break;
		case 4: this.create_righthand(); break;
		case 3: this.create_leftleg(); break;
		case 2: this.create_rightleg(); break;
		case 1: this.create_leftfoot(); break;
		case 0: this.create_rightfoot(); break;
		default: System.out.println("something wrong with lives");
		}
	}
	
	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
}

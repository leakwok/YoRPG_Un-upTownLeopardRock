/*
Team Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
L01: An Adventurer is You!
2021-11-23
time spent: 2.00 hour
*/

/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * DISCO:
 *      - It is possible to use overloaded constructors without default constructors (see Fairy.java, Elf.java, and Wizard.java, which have constructors that take in a name parameter)>
 *      - Initialize variables as instance variables if you want to use them in different methods! 
 *      - N from class: A protected instance variable is accessible by a class and all its subclasses. For example, _hitpoints in Protagonist is accessible by Protagonist, Fairy, Elf,>
 *      - We can print out the static about() method of each class when allowing the user to pick their characters.
 * QCC:
 *      - Protagonist is-a Character.
 *      - Fairy is-a Protagonist.
 *      - Elf is-a Protagonist.
 *      - Wizard is-a Protagonist.
 *      - Monster is-a Character.
 *      - Ogre is-a Monster.
 *      - Dragon is-a Monster.
 *      - Snowman is-a Monster.
 *              OUR INHERITANCE TREE
 *                      Character
 *      Protagonist                     Monster
 * Fairy   Elf  Wizard           Ogre  Dragon  Snowman
 * OUR DRIVER MODS:
 *      - created instance variables monsterChoice and protagChoice to store the number corresponding to the character's choice of opponent and protagonist role, respectively.
 *      - added selection phase to newGame(), which printed out explanatory questions and Monster + Protagonist subclass choices, with their about() methods.
 *      - added if statements to playTurn() to initialize and Protagonist pat and Monster smaug to the player's choices.
 **********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    int monsterChoice;
    int protagChoice;

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }
    s = "\nIntrepid protagonist, what doth thy born thyself? (Pick your protagonist): \n";
    s += "\t1: Fairy: " + Fairy.about() + " \n";
    s += "\t2: Elf: " + Elf.about() + "\n";
    s += "\t3: Wizard: " + Wizard.about() + "\n";
    System.out.print( s );
    try {
	protagChoice = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }
    s = "\nIntrepid protagonist, what doth thy dare to face? (Pick your opponent): \n";
    s += "\t1: Ogre: " + Ogre.about() + "\n";
    s += "\t2: Dragon: " + Dragon.about() + "\n";
    s += "\t3: Snowman: " + Snowman.about() + "\n";
    System.out.print ( s );
    try {
	monsterChoice = Integer.parseInt ( in.readLine() );
    }
    catch ( IOException e ) { }
    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }

    //instantiate the player's character
    if( protagChoice == 1){
    	pat = new Fairy( name );
    }
    else if(protagChoice == 2){
	pat = new Elf( name );
    }
    else{
	pat = new Wizard( name );
    }

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    System.out.println( "\nLo, yonder monster approacheth!" );
	    if( monsterChoice == 1){
	    	smaug = new Ogre();
	    }
	    else if(monsterChoice == 2){
		smaug = new Dragon();
	    }
	   else{
		smaug = new Snowman();
       	    }

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================

	  ================================================*/
  }//end main

}//end class YoRPG

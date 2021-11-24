/*
Team Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
L01: An Adventurer is You!
2021-11-22
time spent: 00.5 hour
*/

public class Protagonist{

	/*
	// default constructor
	public Protagonist(){

	}
	*/

	private String name;

	//overloaded constructor
	public Protagonist(String s){
		name = s;
	}

	// isAlive() method
	public boolean isAlive(){
		return true;
	}

	// specialize() method
	public void specialize(){
	}

	// normalize() method
	public void normalize(){
	}

	// attack() method
	public int attack( Monster m){
		return -1; // should be the attack damage value
	}

	// getName() method
	public String getName(){
		return name;
	}
}

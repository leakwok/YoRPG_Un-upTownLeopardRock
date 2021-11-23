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
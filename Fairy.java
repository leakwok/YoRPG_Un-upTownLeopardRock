public class Fairy extends Protagonist{
	public Fairy( String name ){
		_name = name;
		_hitPts = 100;
		_strength = 110; 
	}
	public static String about(){
		return "Fairy is a magical (!) protagonist who has lower HP in exchange for higher strength. Use her wisely...";
	}
}

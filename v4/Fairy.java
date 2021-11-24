/*
Team Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
L01: An Adventurer is You!
2021-11-23
time spent: 2.00 hour
*/

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

/*
Team Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
L01: An Adventurer is You!
2021-11-23
time spent: 2.00 hour
*/

public class Wizard extends Protagonist{
	public Wizard( String name ){
		_name = name;
		_attack = 2;
	}
	public static String about(){
		return "Something... Harry Potter... WRONG! This is not your usual Hogwarts wizard--he features a higher attack!";
	}
}

public class Elf extends Protagonist{
	public Elf( String name ){
		_name = name;
		_defense = 30 + ( int ) ( Math.random() * 50);
	}
	public static String about(){
		return "Elf is a master of trickery! A clever protagonist, he may have higher defense than most...";
	}
}

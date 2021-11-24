/*
Team Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
L01: An Adventurer is You!
2021-11-22
time spent: 00.5 hour
*/

public class Character {
      // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
        public int _hitPts;
        public int _strength;
        public int _defense;
        public double _attack;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /**
      boolean isAlive() -- tell whether I am alive
      post: returns boolean indicated alive or dead
      **/
    public boolean isAlive() {
        return _hitPts > 0;
    }


    /**
      int attack(Monster) -- simulates attack on a Monster
      pre:  Input not null
      post: Calculates damage to be inflicted, flooring at 0.
      Calls opponent's lowerHP() method to inflict damage.
      Returns damage dealt.
      **/
    public int attack( Monster opponent ) {

        int damage = (int)( (_strength * _attack) - opponent.getDefense() );
        //System.out.println( "\t\t**DIAG** damage: " + damage );

        if ( damage < 0 )
            damage = 0;

        opponent.lowerHP( damage );

        return damage;
    }//end attack


    /**
      void lowerHP(int) -- lowers life by input value
      pre:  Input >= 0
      post: Life instance var is lowered by input ammount.
      **/
    public void lowerHP( int damageInflicted ) {
        _hitPts = _hitPts - damageInflicted;
    }

  /**
    int getDefense() -- returns value of defense attribute
    pre:
    post: returns value of defense attribute
    **/
  public int getDefense(){
    return _defense;
  }

}

package model.world;

import java.util.ArrayList;

import model.abilities.Ability;

public class Villain extends Champion {

	public Villain(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion c : targets) {

			c.setCurrentHP(0);

		}

	}

	public String toString() {
	     String ab ="";
	        for( Ability a : this.getAbilities()) {
	            ab += a.toString();
	        }
	        return "Name    " +this.getName() + "\nType Vilain "+"\n" + this.getCondition()+
					"\nHP\n" + this.getCurrentHP()+"/"+this.getMaxHP()
					+ "\nAction points "+ this.getCurrentActionPoints() +"/" + this.getMaxActionPointsPerTurn() 
					+"\nMana "+ this.getMana() 
					+"\nAttackDamage "+ this.getAttackDamage()+"\nAttackRange "+ this.getAttackRange()
					+"\nspeed "+ this.getSpeed() +"\n " ;
	   
	}
	
	

}

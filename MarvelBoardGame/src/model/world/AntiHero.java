package model.world;

import java.util.ArrayList;

import model.abilities.Ability;
import model.effects.Stun;

public class AntiHero extends Champion {

	public AntiHero(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion c: targets)
		{
			Stun s = new Stun(2);
			c.getAppliedEffects().add(s);
			s.apply(c);
		}
	}
	
	public String toString() {
        String ab ="";
        for( Ability a : this.getAbilities()) {
            ab += a.toString();
        }

        return "Name    " +this.getName() + "\nType AntiHero "+"\n" + this.getCondition()+
				"\nHP\n" + this.getCurrentHP()+"/"+this.getMaxHP()
				+ "\nAction points"+ this.getCurrentActionPoints() +"/" + this.getMaxActionPointsPerTurn() 
				+"\nMana "+ this.getMana() 
				+"\nAttackDamage "+ this.getAttackDamage()+"\nAttackRange "+ this.getAttackRange()
				+"\nspeed "+ this.getSpeed() +"\n " ;
    }
	
	public String toString1() {
        String ab ="";
        for( Ability a : this.getAbilities()) {
            ab += a.toString();
        }

        return  "  "+this.getName() + "\n  Type AntiHero "+
				"\n  HP " +this.getMaxHP()
				+ "\n  Action points"+ this.getMaxActionPointsPerTurn() 
				+"\n  Mana "+ this.getMana() 
				+"\n  AttackDamage "+ this.getAttackDamage()+"\n  AttackRange "+ this.getAttackRange()
				+"\n  speed "+ this.getSpeed() +"\n " ;
    }
	
	
}

package model.world;

import java.util.ArrayList;

import model.abilities.Ability;
import model.effects.Effect;
import model.effects.EffectType;
import model.effects.Embrace;

public class Hero extends Champion {

	public Hero(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion c : targets) {
			int i = 0;
			while (i < c.getAppliedEffects().size()) {
				Effect e = c.getAppliedEffects().get(i);
				if (e.getType() == EffectType.DEBUFF) {
					e.remove(c);
					c.getAppliedEffects().remove(e);

				} else
					i++;
			}
			Embrace em = new Embrace(2);

			em.apply(c);
			c.getAppliedEffects().add(em);

		}
	}

	public String toString() {
		String ab ="";
		for( Ability a : this.getAbilities()) {
			ab += a.toString();
		}

		return "Name    " +this.getName() + "\nType Hero "+"\n" + this.getCondition()+
				"\nHP\n" + this.getCurrentHP()+"/"+this.getMaxHP()
				+ "\nAction points "+ this.getCurrentActionPoints() +"/" + this.getMaxActionPointsPerTurn() 
				+"\nMana "+ this.getMana() 
				+"\nAttackDamage "+ this.getAttackDamage()+"\nAttackRange "+ this.getAttackRange()
				+"\nspeed    "+ this.getSpeed() +"\n " ;
	}

}
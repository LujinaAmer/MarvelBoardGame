package model.abilities;

import java.util.ArrayList;

import model.effects.Effect;
import model.world.Champion;
import model.world.Damageable;

public class CrowdControlAbility extends Ability {
	private Effect effect;

	public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRadius, AreaOfEffect area, int required,
			Effect effect) {
		super(name, cost, baseCoolDown, castRadius, area, required);
		this.effect = effect;

	}

	public Effect getEffect() {
		return effect;
	}

	@Override
	public void execute(ArrayList<Damageable> targets) throws CloneNotSupportedException {
		for(Damageable d: targets)
		{
			Champion c =(Champion) d;
			c.getAppliedEffects().add((Effect) effect.clone());
			effect.apply(c);
		}
		
	}
	
	public String toString() {
		
		String abilities="";

		abilities= this.getName()+"\n"+ "CrowdControlAbility\n"+"effect " + effect.getName() + "\n"+
				"Cooldown"+  this.getCurrentCooldown()+"/"+ this.getBaseCooldown() +"\n" 
				+this.getCastArea() +"\ncast range   "+  this.getCastRange() +
				" / Mana  " + this.getManaCost()+ " / Action points  "+ this.getRequiredActionPoints() ;

		return abilities;

		

	}

}

package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public class DamagingAbility extends Ability {

	private int damageAmount;

	public DamagingAbility(String name, int cost, int baseCoolDown, int castRadius, AreaOfEffect area, int required,
			int damageAmount) {
		super(name, cost, baseCoolDown, castRadius, area, required);
		this.damageAmount = damageAmount;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	@Override
	public void execute(ArrayList<Damageable> targets) {
		for (Damageable d : targets)

			d.setCurrentHP(d.getCurrentHP() - damageAmount);

	}

	public String toString() {

		String abilities="";

		abilities= this.getName()+"\n"+ "DamagingAbility\n"+"DMG " + damageAmount + "\n"+
				"Cooldown"+  this.getCurrentCooldown()+"/"+ this.getBaseCooldown() +"\n" 
				+this.getCastArea() +"\ncast range   "+  this.getCastRange() +
				" / Mana  " + this.getManaCost()+ " / Action points  "+ this.getRequiredActionPoints() ;

		return abilities;



	}
}

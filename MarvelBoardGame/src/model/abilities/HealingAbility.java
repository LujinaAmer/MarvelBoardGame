package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public  class HealingAbility extends Ability {
	private int healAmount;

	public HealingAbility(String name,int cost, int baseCoolDown, int castRadius, AreaOfEffect area,int required, int healingAmount) {
		super(name,cost, baseCoolDown, castRadius, area,required);
		this.healAmount = healingAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	
	@Override
	public void execute(ArrayList<Damageable> targets) {
		for (Damageable d : targets)

			d.setCurrentHP(d.getCurrentHP() + healAmount);

	}
	
	public String toString() {
		
		String abilities="";

		abilities= this.getName()+"\n"+ "HealingAbility\n"+"heal amount " + healAmount + "\n"+
				"Cooldown"+  this.getCurrentCooldown()+"/"+ this.getBaseCooldown() +"\n" 
				+this.getCastArea() +"\ncast range   "+  this.getCastRange() +
				" / Mana  " + this.getManaCost()+ " / Action points  "+ this.getRequiredActionPoints() ;

		return abilities;

	}
	
	public String toString1() {

		String abilities="";

		abilities= this.getName()+"\n"+ "HealingAbility\n"+"heal amount " + healAmount + "\n"+
				"Cooldown	"+  this.getBaseCooldown() +"\n" 
				+this.getCastArea() +"\ncast range   "+  this.getCastRange() +
				"\nMana  " + this.getManaCost()+ "\nAction points  "+ this.getRequiredActionPoints() ;

		return abilities;

	}

}

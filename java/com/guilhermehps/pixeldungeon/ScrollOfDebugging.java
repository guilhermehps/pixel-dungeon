package com.guilhermehps.pixeldungeon;

import java.util.ArrayList;

import com.guilhermehps.pixeldungeon.actors.hero.Hero;
import com.guilhermehps.pixeldungeon.items.Item;
import com.guilhermehps.pixeldungeon.items.scrolls.ScrollOfEnchantment;

public class ScrollOfDebugging extends Item {

	{
		name = "Scroll of Debugging";
		image = 40;
	}
	
	public static final String AC_READ	= "READ";
	
	@Override
	public ArrayList<String> actions( Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.add( AC_READ );
		return actions;
	}
	
	@Override
	public void execute( Hero hero, String action ) {
		if (action.equals( AC_READ )) {
			
			new ScrollOfEnchantment().collect();
			
		} else {
		
			super.execute( hero, action );
			
		}
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
}

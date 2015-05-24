/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.guilhermehps.pixeldungeon.plants;

import com.guilhermehps.pixeldungeon.Dungeon;
import com.guilhermehps.pixeldungeon.actors.Char;
import com.guilhermehps.pixeldungeon.actors.blobs.Fire;
import com.guilhermehps.pixeldungeon.actors.blobs.Freezing;
import com.guilhermehps.pixeldungeon.items.potions.PotionOfFrost;
import com.guilhermehps.pixeldungeon.levels.Level;
import com.guilhermehps.pixeldungeon.sprites.ItemSpriteSheet;
import com.guilhermehps.pixeldungeon.utils.BArray;
import com.guilhermehps.utils.PathFinder;

public class Icecap extends Plant {

	private static final String TXT_DESC = "Upon touching an Icecap excretes a pollen, which freezes everything in its vicinity.";
	
	{
		image = 1;
		plantName = "Icecap";
	}
	
	@Override
	public void activate( Char ch ) {
		super.activate( ch );
		
		PathFinder.buildDistanceMap( pos, BArray.not( Level.losBlocking, null ), 1 );
		
		Fire fire = (Fire)Dungeon.level.blobs.get( Fire.class );
		
		for (int i=0; i < Level.LENGTH; i++) {
			if (PathFinder.distance[i] < Integer.MAX_VALUE) {
				Freezing.affect( i, fire );
			}
		}
	}
	
	@Override
	public String desc() {
		return TXT_DESC;
	}
	
	public static class Seed extends Plant.Seed {
		{
			plantName = "Icecap";
			
			name = "seed of " + plantName;
			image = ItemSpriteSheet.SEED_ICECAP;
			
			plantClass = Icecap.class;
			alchemyClass = PotionOfFrost.class;
		}
		
		@Override
		public String desc() {
			return TXT_DESC;
		}
	}
}

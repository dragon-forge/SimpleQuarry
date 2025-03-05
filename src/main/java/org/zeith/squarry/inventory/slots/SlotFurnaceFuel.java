package org.zeith.squarry.inventory.slots;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.*;

public class SlotFurnaceFuel
		extends Slot
{
	protected final FuelValues fuelValues;
	
	public SlotFurnaceFuel(FuelValues fuelValues, Container inv, int id, int x, int y)
	{
		super(inv, id, x, y);
		this.fuelValues = fuelValues;
	}
	
	@Override
	public boolean mayPlace(ItemStack stack)
	{
		return stack.getBurnTime(null, fuelValues) > 0;
	}
}
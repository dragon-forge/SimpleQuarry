package org.zeith.squarry.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import org.zeith.hammerlib.annotations.*;
import org.zeith.hammerlib.api.forge.BlockAPI;
import org.zeith.squarry.blocks.entity.*;

@SimplyRegister
public interface TilesSQ
{
	@RegistryName("powered_quarry")
	BlockEntityType<TilePoweredQuarry> POWERED_QUARRY = BlockAPI.createBlockEntityType(TilePoweredQuarry::new, BlocksSQ.POWERED_QUARRY);
	
	@RegistryName("fuel_quarry")
	BlockEntityType<TileFuelQuarry> FUEL_QUARRY = BlockAPI.createBlockEntityType(TileFuelQuarry::new, BlocksSQ.FUEL_QUARRY);
}
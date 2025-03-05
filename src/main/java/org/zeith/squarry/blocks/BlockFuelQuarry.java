package org.zeith.squarry.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.util.Cast;
import org.jetbrains.annotations.Nullable;
import org.zeith.squarry.init.*;

public class BlockFuelQuarry
		extends BlockBaseQuarry
{
	public BlockFuelQuarry(Properties props)
	{
		super(props);
	}
	
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec()
	{
		return Cast.cast(BlocksSQ.FUEL_QUARRY_CODEC.get());
	}
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return TilesSQ.FUEL_QUARRY.create(pos, state);
	}
}
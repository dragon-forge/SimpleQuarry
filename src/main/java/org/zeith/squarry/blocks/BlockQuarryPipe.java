package org.zeith.squarry.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.Nullable;
import org.zeith.hammerlib.core.adapter.*;
import org.zeith.squarry.blocks.entity.TileFuelQuarry;
import org.zeith.squarry.init.TagsSQ;

import java.util.List;

public class BlockQuarryPipe
		extends Block
{
	protected static final VoxelShape SHAPE = box(5, 0, 5, 11, 16, 11);
	
	public BlockQuarryPipe(Properties props)
	{
		super(props);
		TagAdapter.bind(TagsSQ.Blocks.QUARRY_PIPE, this);
		BlockHarvestAdapter.bindTool(BlockHarvestAdapter.MineableType.PICKAXE, ToolMaterial.IRON, this);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Item.TooltipContext ctx, List<Component> tooltip, TooltipFlag flags)
	{
		tooltip.add(Component.translatable("info.squarry.quarry_pipe")
				.withStyle(ChatFormatting.GRAY)
		);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(BlockStateProperties.UP, BlockStateProperties.DOWN);
	}
	
	public BlockState tfState(BlockState base, BlockGetter level, BlockPos pos)
	{
		var above = level.getBlockState(pos.above());
		var below = level.getBlockState(pos.below());
		return base
				.setValue(BlockStateProperties.UP, above.is(this) || level.getBlockEntity(pos.above()) instanceof TileFuelQuarry)
				.setValue(BlockStateProperties.DOWN, below.is(this));
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx)
	{
		return tfState(super.getStateForPlacement(ctx), ctx.getLevel(), ctx.getClickedPos());
	}
	
	@Override
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random)
	{
		return tfState(state, level, pos);
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState p_60537_, LootParams.Builder b)
	{
		return List.of(new ItemStack(this));
	}
	
	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
	{
		return SHAPE;
	}
}
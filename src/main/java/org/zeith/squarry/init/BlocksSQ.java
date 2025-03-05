package org.zeith.squarry.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.zeith.hammerlib.annotations.*;
import org.zeith.hammerlib.api.registrars.Registrar;
import org.zeith.squarry.SimpleQuarry;
import org.zeith.squarry.blocks.*;

@SimplyRegister(
		creativeTabs = @Ref(value = SimpleQuarry.class, field = "ITEM_GROUP")
)
public interface BlocksSQ
{
	@RegistryName("fuel_quarry")
	BlockFuelQuarry FUEL_QUARRY = new BlockFuelQuarry(BlockBehaviour.Properties
			.of()
			.sound(SoundType.METAL)
			.strength(4F)
			.requiresCorrectToolForDrops()
	);
	
	@RegistryName("powered_quarry")
	BlockPoweredQuarry POWERED_QUARRY = new BlockPoweredQuarry(BlockBehaviour.Properties
			.of()
			.sound(SoundType.METAL)
			.strength(4.5F)
			.requiresCorrectToolForDrops()
	);
	
	@RegistryName("quarry_pipe")
	BlockQuarryPipe QUARRY_PIPE = new BlockQuarryPipe(BlockBehaviour.Properties
			.ofFullCopy(Blocks.IRON_BLOCK)
			.strength(2.0F, 8.0F)
	);
	
	// Codecs for whatever reason.
	
	@RegistryName("powered_quarry")
	Registrar<MapCodec<BlockPoweredQuarry>> POWERED_QUARRY_CODEC = Registrar.blockType(BlockBehaviour.simpleCodec(BlockPoweredQuarry::new));
	
	@RegistryName("fuel_quarry")
	Registrar<MapCodec<BlockFuelQuarry>> FUEL_QUARRY_CODEC = Registrar.blockType(BlockBehaviour.simpleCodec(BlockFuelQuarry::new));
}
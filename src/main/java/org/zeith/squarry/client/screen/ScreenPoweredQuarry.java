package org.zeith.squarry.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.zeith.hammerlib.client.flowgui.reader.XmlFlowgui;
import org.zeith.hammerlib.client.screen.FlowguiScreen;
import org.zeith.squarry.*;
import org.zeith.squarry.api.energy.UniversalConverter;
import org.zeith.squarry.blocks.entity.TilePoweredQuarry;
import org.zeith.squarry.inventory.ContainerPoweredQuarry;

import java.text.DecimalFormat;

@XmlFlowgui("powered_quarry")
public class ScreenPoweredQuarry
		extends FlowguiScreen<ContainerPoweredQuarry>
{
	private static final DecimalFormat df = new DecimalFormat("#0");
	
	public TilePoweredQuarry tile;
	
	public ScreenPoweredQuarry(ContainerPoweredQuarry container, Inventory inv, Component label)
	{
		super(container, inv, label);
		this.tile = container.tile;
	}
	
	public float fire, power;
	public String blocksToBreak;
	
	@Override
	public void render(GuiGraphics pose, int mouseX, int mouseY, float partialTime)
	{
		int max = Math.max(1, tile.totalBurnTicks.getInt());
		fire = 1 + (float) tile.burnTicks.getInt() * 13F / max;
		power = (float) (tile.storage.getStoredQF(null) / tile.storage.getQFCapacity(null) * 64);
		blocksToBreak = df.format(Math.floor(
				tile.storage.getStoredQF(null) / (UniversalConverter.FT_QF(SQCommonProxy.COAL.getBurnTime(null, tile.getLevel().fuelValues())) / SQConfig.getBlocksPerCoal())));
		super.render(pose, mouseX, mouseY, partialTime);
	}
}
package org.zeith.squarry.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.zeith.hammerlib.client.flowgui.reader.XmlFlowgui;
import org.zeith.hammerlib.client.screen.FlowguiScreen;
import org.zeith.squarry.blocks.entity.TileFuelQuarry;
import org.zeith.squarry.inventory.ContainerFuelQuarry;

@XmlFlowgui("fuel_quarry")
public class ScreenFuelQuarry
		extends FlowguiScreen<ContainerFuelQuarry>
{
	public TileFuelQuarry tile;
	
	public ScreenFuelQuarry(ContainerFuelQuarry container, Inventory inv, Component label)
	{
		super(container, inv, label);
		this.tile = container.tile;
	}
	
	public float fire;
	
	@Override
	public void render(GuiGraphics pose, int mouseX, int mouseY, float partialTime)
	{
		int max = Math.max(1, tile.totalBurnTicks.getInt());
		fire = 1 + (float) tile.burnTicks.getInt() * 13F / max;
		super.render(pose, mouseX, mouseY, partialTime);
	}
}
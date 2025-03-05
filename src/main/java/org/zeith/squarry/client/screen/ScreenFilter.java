package org.zeith.squarry.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.zeith.hammerlib.client.flowgui.objects.GuiButtonObject;
import org.zeith.hammerlib.client.flowgui.reader.XmlFlowgui;
import org.zeith.hammerlib.client.screen.FlowguiScreen;
import org.zeith.hammerlib.util.mcf.Resources;
import org.zeith.squarry.SimpleQuarry;
import org.zeith.squarry.inventory.ContainerFilter;

@XmlFlowgui("filter")
public class ScreenFilter
		extends FlowguiScreen<ContainerFilter>
{
	protected static final WidgetSprites[] DATA = {
			new WidgetSprites(
					SimpleQuarry.id("filter/data/disabled"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/data/disabled_hover")
			),
			new WidgetSprites(
					SimpleQuarry.id("filter/data/enabled"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/data/enabled_hover")
			)
	};
	
	protected static final WidgetSprites[] PREDICATE = {
			new WidgetSprites(
					SimpleQuarry.id("filter/predicate/blocklist"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/predicate/blocklist_hover")
			),
			new WidgetSprites(
					SimpleQuarry.id("filter/predicate/allowlist"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/predicate/allowlist_hover")
			)
	};
	
	protected static final WidgetSprites[] TAGS = {
			new WidgetSprites(
					SimpleQuarry.id("filter/tags/disabled"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/tags/disabled_hover")
			),
			new WidgetSprites(
					SimpleQuarry.id("filter/tags/enabled"),
					Resources.location("widget/button_disabled"),
					SimpleQuarry.id("filter/tags/enabled_hover")
			)
	};
	
	public ScreenFilter(ContainerFilter container, Inventory plyerInv, Component name)
	{
		super(container, plyerInv, name);
	}
	
	public GuiButtonObject predicate, tags, data;
	public ContainerFilter.FilterData filter;
	
	@Override
	protected void init()
	{
		super.init();
		predicate = root.findByName("predicate", GuiButtonObject.class);
		tags = root.findByName("tags", GuiButtonObject.class);
		data = root.findByName("data", GuiButtonObject.class);
	}
	
	@Override
	public void render(GuiGraphics pose, int mouseX, int mouseY, float partialTime)
	{
		filter = menu.data;
		
		if(predicate != null) predicate.sprites = PREDICATE[filter.invert ? 0 : 1];
		if(tags != null) tags.sprites = TAGS[filter.useod ? 1 : 0];
		if(data != null) data.sprites = DATA[filter.usemeta ? 1 : 0];
		
		super.render(pose, mouseX, mouseY, partialTime);
	}
	
	public boolean handleClick(int k)
	{
		return clickMenuButton(k);
	}
}
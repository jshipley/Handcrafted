package earth.terrarium.handcrafted.common.items;

import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class TooltipBlockItem extends BlockItem {
    private final Component tooltip;

    public TooltipBlockItem(Block block, Component tooltip, Properties properties) {
        super(block, properties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        TooltipUtils.addDescriptionComponent(tooltipComponents, this.tooltip);
    }
}

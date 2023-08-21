package net.anchit.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CUSTOM_TAB = new CreativeModeTab("customitems") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MIDNIGHT_EMERALD.get());
        }
    };
}

package net.anchit.tutorialmod.blocks;

import net.anchit.tutorialmod.TutorialMod;
import net.anchit.tutorialmod.blocks.custom.GazeLantern;
import net.anchit.tutorialmod.blocks.custom.JumpSpeedBlock;
import net.anchit.tutorialmod.item.ModCreativeModeTab;
import net.anchit.tutorialmod.item.ModItems;
import net.anchit.tutorialmod.item.custom.BlueberryCropBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> MIDNIGHT_BLOCK = registerBlock("midnight_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.CUSTOM_TAB);


    public static final RegistryObject<Block> MIDNIGHT_ORE = registerBlock("midnight_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.CUSTOM_TAB);
    public static final RegistryObject<Block> DEEPSLATE_MIDNIGHT_ORE = registerBlock("deepslate_midnight_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.CUSTOM_TAB);

    public static final RegistryObject<Block> JUMPYSPEED_BLOCK = registerBlock("jumpy_speed_block",
            () -> new JumpSpeedBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.CUSTOM_TAB);

    public static final RegistryObject<Block> GAZE_LANTERN = registerBlock("gaze_lantern",
            () -> new GazeLantern(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(GazeLantern.LIT) ? 15 : 0)), ModCreativeModeTab.CUSTOM_TAB);

    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

            private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                                    CreativeModeTab tab){
                return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
            }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}

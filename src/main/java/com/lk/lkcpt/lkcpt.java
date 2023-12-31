package com.lk.lkcpt;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(lkcpt.MODID)
public class lkcpt
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lkcpt";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));




    public static class CopperPickaxeProperties extends Item.Properties
    {
        CopperPickaxeProperties()
        {
            this.rarity(Rarity.COMMON);
            this.defaultDurability(500);

            // 食べれるようになるやつ
            // this.food(new FoodProperties.Builder()
            //        .alwaysEat().nutrition(1).saturationMod(2f).build());
        }
    };

    public static class CopperPickaxeItem extends net.minecraft.world.item.PickaxeItem
    {
        CopperPickaxeItem()
        {
            super(new Tier() {
                @Override
                public int getUses() {
                    return 0;
                }

                @Override
                public float getSpeed() {
                    return 3;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 0;
                }

                @Override
                public int getLevel() {
                    return 5;
                }

                @Override
                public int getEnchantmentValue() {
                    return 0;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return null;
                }
            },3, 0, new CopperPickaxeProperties());


        }
    };

    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new CopperPickaxeItem());


    public static class CopperShovelProperties extends Item.Properties
    {
        CopperShovelProperties ()
        {
            this.rarity(Rarity.COMMON);
            this.defaultDurability(500);
        }
    };

    public static class CopperShovelItem extends net.minecraft.world.item.ShovelItem
    {
        CopperShovelItem()
        {
            super(new Tier() {

                @Override
                public int getUses() {
                    return 0;
                }

                @Override
                public float getSpeed() {
                    return 3;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 0;
                }

                @Override
                public int getLevel() {
                    return 5;
                }

                @Override
                public int getEnchantmentValue() {
                    return 0;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return null;
                }
            }
            ,3,0,new CopperShovelProperties());

        }
    };

    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new CopperShovelItem());

    public static class CopperAxeProperties extends Item.Properties
    {
        CopperAxeProperties ()
        {
            this.rarity(Rarity.COMMON);
            this.defaultDurability(500);
        }
    };

    public static class CopperAxeItem extends net.minecraft.world.item.AxeItem
    {
        CopperAxeItem()
        {
            super(new Tier() {

                      @Override
                      public int getUses() {
                          return 0;
                      }

                      @Override
                      public float getSpeed() {
                          return 3;
                      }

                      @Override
                      public float getAttackDamageBonus() {
                          return 0;
                      }

                      @Override
                      public int getLevel() {
                          return 5;
                      }

                      @Override
                      public int getEnchantmentValue() {
                          return 0;
                      }

                      @Override
                      public Ingredient getRepairIngredient() {
                          return null;
                      }
                  }
                    ,3,0,new CopperAxeProperties());

        }
    };

    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new CopperAxeItem());


    public static class CopperHoeProperties extends Item.Properties
    {
        CopperHoeProperties ()
        {
            this.rarity(Rarity.COMMON);
            this.defaultDurability(500);
        }
    };

    public static class CopperHoeItem extends net.minecraft.world.item.HoeItem
    {
        CopperHoeItem()
        {
            super(new Tier() {

                      @Override
                      public int getUses() {
                          return 0;
                      }

                      @Override
                      public float getSpeed() {
                          return 3;
                      }

                      @Override
                      public float getAttackDamageBonus() {
                          return 0;
                      }

                      @Override
                      public int getLevel() {
                          return 5;
                      }

                      @Override
                      public int getEnchantmentValue() {
                          return 0;
                      }

                      @Override
                      public Ingredient getRepairIngredient() {
                          return null;
                      }
                  }
                    ,3,0,new CopperHoeProperties());

        }
    };

    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new CopperHoeItem());

    public static class CopperSwordProperties extends Item.Properties
    {
        CopperSwordProperties ()
        {
            this.rarity(Rarity.COMMON);
            this.defaultDurability(500);
        }
    };

    public static class CopperSwordItem extends net.minecraft.world.item.SwordItem
    {
        CopperSwordItem()
        {
            super(new Tier() {

                      @Override
                      public int getUses() {
                          return 0;
                      }

                      @Override
                      public float getSpeed() {
                          return 3;
                      }

                      @Override
                      public float getAttackDamageBonus() {
                          return 2;
                      }

                      @Override
                      public int getLevel() {
                          return 5;
                      }

                      @Override
                      public int getEnchantmentValue() {
                          return 0;
                      }

                      @Override
                      public Ingredient getRepairIngredient() {
                          return null;
                      }
                  }
                    ,3,0,new CopperSwordProperties());

        }
    };

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new CopperSwordItem());


    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());


    public static final RegistryObject<CreativeModeTab> COOPER_TOOL_TAB = CREATIVE_MODE_TABS.register("copper_tool_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.TOOLS_AND_UTILITIES)
            .icon(() -> COPPER_PICKAXE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(COPPER_PICKAXE.get());
                output.accept(COPPER_SHOVEL.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(COPPER_AXE.get());
                output.accept(COPPER_HOE.get());
                output.accept(COPPER_SWORD.get());
            }).build());



    public lkcpt()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

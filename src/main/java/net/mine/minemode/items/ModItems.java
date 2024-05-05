package net.mine.minemode.items;

import net.mine.minemode.MineMode;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineMode.MOD_ID);
    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    static FoodProperties foodProperties = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.5f)
            .build();
    public static RegistryObject<Item> BANANA = ITEMS.register("banana", ()-> new Item(new Item.Properties().food(foodProperties)));

    }


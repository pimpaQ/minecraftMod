package net.mine.minemode.items;

import net.mine.minemode.MineMode;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.mine.minemode.items.ModItems.energyDrink;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineMode.MOD_ID);
    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    static FoodProperties bananafood = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.5f)
            .build();
    public static RegistryObject<Item> BANANA = ITEMS.register("banana",
            ()-> new Item(new Item.Properties().food(bananafood)));
    static FoodProperties energyDrink = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(2f)
            .effect(()-> new MobEffectInstance(MobEffect.byId(3), 600, 1), 1.0f)
            .build();
    public static RegistryObject<Item> ENERGY_DRINK = ITEMS.register("energydrink",
            ()-> new Item(new Item.Properties().food(energyDrink)));

    public static RegistryObject<Item> FIREBALL_STICK = ITEMS.register("fireballstick", workfireball::new);
    }




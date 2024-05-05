package net.mine.minemode.items;

import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class workfireball extends Item {
    public workfireball(){
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            Vec3 lookVector = player.getLookAngle();
            double x = player.getX();
            double y = player.getY() + 1.5f;
            double z = player.getZ();

            // Создаем и запускаем файербол
            SmallFireball fireball = new SmallFireball(world, player, 0, 0, 0);
            fireball.shoot(lookVector.x, lookVector.y, lookVector.z, 1.5f, 1.0f);
            world.addFreshEntity(fireball);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}

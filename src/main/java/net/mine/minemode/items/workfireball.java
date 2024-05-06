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
    private int cooldown = 20 * 3;
    private long lastUsed = 0;
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

        if (!world.isClientSide) {
            long currentTime = world.getGameTime();

            if (currentTime - lastUsed < cooldown) {
                return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(hand));
            }

            Vec3 lookVector = player.getLookAngle();
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();

            SmallFireball fireball = new SmallFireball(world, player, 0, 0, 0);
            fireball.shoot(lookVector.x, lookVector.y, lookVector.z, 1.5f, 1.0f);
            world.addFreshEntity(fireball);

            lastUsed = currentTime;
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}

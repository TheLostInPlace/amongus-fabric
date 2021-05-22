package net.gridboy.amongus.item;

import net.gridboy.amongus.Amongus;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AmongusTestItem extends Item {
    public AmongusTestItem (Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(Amongus.SUS_EVENT, 1.0F, 1.0F);
        playerEntity.kill();
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}

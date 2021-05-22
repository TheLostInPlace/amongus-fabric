package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.gridboy.amongus.guis.EButtonGui;
import net.gridboy.amongus.screen.EButtonScreen;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EmergencyButtonBlock extends Block implements BlockEntityProvider {

    public EmergencyButtonBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new EmergencyButtonBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Button used."), false);
            MinecraftClient.getInstance().openScreen(new EButtonScreen(new EButtonGui()));
        }

        return ActionResult.SUCCESS;
    }

}

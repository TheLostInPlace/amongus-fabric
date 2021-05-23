package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.VentBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class VentBlock extends BlockWithEntity implements BlockEntityProvider {
    public VentBlock (AbstractBlock.Settings settings)
    {
        super(settings);
    }

    public static Identifier ID = new Identifier("amongus", "vent_block");

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new VentBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Vent clicked."), false);
            //MinecraftClient.getInstance().openScreen(new EButtonScreen(new EButtonGui()));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

}

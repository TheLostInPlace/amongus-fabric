package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EmergencyButtonBlock extends BlockWithEntity implements BlockEntityProvider {

    public EmergencyButtonBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public static Identifier ID = new Identifier("amongus", "emergency_button");

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new EmergencyButtonBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Button used."), false);
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.5f, 1f);
    }

}

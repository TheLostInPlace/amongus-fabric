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

public class EmergencyButtonBlock extends BlockWithEntity {

    public EmergencyButtonBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public static Identifier ID = new Identifier("amongus", "emergency_button");

    public static VoxelShape B1 = Block.createCuboidShape(5, 0, 5, 11, 7, 11);
    public static VoxelShape B2 = Block.createCuboidShape(1, 0, 5, 4, 4, 11);
    public static VoxelShape B3 = Block.createCuboidShape(4, 0, 5, 5, 6, 11);
    public static VoxelShape B4 = Block.createCuboidShape(5, 0, 12, 11, 4, 15);
    public static VoxelShape B5 = Block.createCuboidShape(5, 0, 11, 11, 6, 12);
    public static VoxelShape B6 = Block.createCuboidShape(12, 0, 5, 15, 4, 11);
    public static VoxelShape B7 = Block.createCuboidShape(11, 0, 5, 12, 6, 11);
    public static VoxelShape B8 = Block.createCuboidShape(5, 0, 1, 11, 4, 4);
    public static VoxelShape B9 = Block.createCuboidShape(5, 0, 4, 11, 6, 5);

    public static VoxelShape CombinedShape = VoxelShapes.union(B1, B2, B3, B4, B5, B6, B7, B8, B9);

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
        return CombinedShape;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return CombinedShape;
    }

}

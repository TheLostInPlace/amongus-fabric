package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EmergencyButtonBlock extends BlockWithEntity {

    public EmergencyButtonBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public static Identifier ID = new Identifier("amongus", "emergency_button");

    public static final Vec3d BUTTON_CENTER_BOTTOMCORNER = new Vec3d(5, 0, 5);
    public static final Vec3d BUTTON_CENTER_TOPCORNER = new Vec3d(11, 7, 11);
    public static final Vector3d EDGE_1 = new Vector3d(1, 0, 5);
    public static final Vector3d EDGE_1_FINISH = new Vector3d(4, 4, 11);
    public static final Vector3d EDGE_1_TOUCH = new Vector3d(4, 0, 5);
    public static final Vector3d EDGE_1_TOUCH_FINISH = new Vector3d(5, 6, 11);
    public static final Vector3d EDGE_2 = new Vector3d(5, 0, 12);
    public static final Vector3d EDGE_2_FINISH = new Vector3d(11, 4, 15);
    public static final Vector3d EDGE_2_TOUCH = new Vector3d(5, 0, 11);
    public static final Vector3d EDGE_2_TOUCH_FINISH = new Vector3d(11, 6, 12);
    public static final Vector3d EDGE_3 = new Vector3d(12, 0, 5);
    public static final Vector3d EDGE_3_FINISH = new Vector3d(15, 4, 11);
    public static final Vector3d EDGE_3_TOUCH = new Vector3d(11, 0, 5);
    public static final Vector3d EDGE_3_TOUCH_FINISH = new Vector3d(12, 6, 11);
    public static final Vector3d EDGE_4 = new Vector3d(5, 0, 1);
    public static final Vector3d EDGE_4_FINISH = new Vector3d(11, 4, 4);
    public static final Vector3d EDGE_4_TOUCH = new Vector3d(5, 0, 4);
    public static final Vector3d EDGE_4_TOUCH_FINISH = new Vector3d(11, 6, 5);

    public static VoxelShape BUTTON_COMBINED = VoxelShapes.cuboid(BUTTON_CENTER_BOTTOMCORNER.x, BUTTON_CENTER_BOTTOMCORNER.y, BUTTON_CENTER_BOTTOMCORNER.z, BUTTON_CENTER_TOPCORNER.x, BUTTON_CENTER_TOPCORNER.y, BUTTON_CENTER_TOPCORNER.z);
    public static VoxelShape EDGE_1_COMBINED = VoxelShapes.cuboid(EDGE_1.x, EDGE_1.y, EDGE_1.z, EDGE_1_FINISH.x, EDGE_1_FINISH.y, EDGE_1_FINISH.z);
    public static VoxelShape EDGE_1T_COMBINED = VoxelShapes.cuboid(EDGE_1_TOUCH.x, EDGE_1_TOUCH.y, EDGE_1_TOUCH.z, EDGE_1_TOUCH_FINISH.x, EDGE_1_TOUCH_FINISH.y, EDGE_1_TOUCH_FINISH.z);
    public static VoxelShape EDGE_2_COMBINED = VoxelShapes.cuboid(EDGE_2.x, EDGE_2.y, EDGE_2.z, EDGE_2_FINISH.x, EDGE_2_FINISH.y, EDGE_2_FINISH.z);
    public static VoxelShape EDGE_2T_COMBINED = VoxelShapes.cuboid(EDGE_2_TOUCH.x, EDGE_2_TOUCH.y, EDGE_2_TOUCH.z, EDGE_2_TOUCH_FINISH.x, EDGE_2_TOUCH_FINISH.y, EDGE_2_TOUCH_FINISH.z);
    public static VoxelShape EDGE_3_COMBINED = VoxelShapes.cuboid(EDGE_3.x, EDGE_3.y, EDGE_3.z, EDGE_3_FINISH.x, EDGE_3_FINISH.y, EDGE_3_FINISH.z);
    public static VoxelShape EDGE_3T_COMBINED = VoxelShapes.cuboid(EDGE_3_TOUCH.x, EDGE_3_TOUCH.y, EDGE_3_TOUCH.z, EDGE_3_TOUCH_FINISH.x, EDGE_3_TOUCH_FINISH.y, EDGE_3_TOUCH_FINISH.z);
    public static VoxelShape EDGE_4_COMBINED = VoxelShapes.cuboid(EDGE_4.x, EDGE_4.y, EDGE_4.z, EDGE_4_FINISH.x, EDGE_4_FINISH.y, EDGE_4_FINISH.z);
    public static VoxelShape EDGE_4T_COMBINED = VoxelShapes.cuboid(EDGE_4_TOUCH.x, EDGE_4_TOUCH.y, EDGE_4_TOUCH.z, EDGE_4_TOUCH_FINISH.x, EDGE_4_TOUCH_FINISH.y, EDGE_4_TOUCH_FINISH.z);

    public static Box BUTTON_EXPERIMENTAL_1 = Box.method_29968(BUTTON_CENTER_BOTTOMCORNER);
    public static Box BUTTON_EXPERIMENTAL_2 = Box.method_29968(BUTTON_CENTER_TOPCORNER);

    public static VoxelShape BUTT_COMB_1 = VoxelShapes.cuboid(BUTTON_EXPERIMENTAL_1);
    public static VoxelShape BUTT_COMB_2 = VoxelShapes.cuboid(BUTTON_EXPERIMENTAL_2);

    public static VoxelShape BUTTON_BOX = VoxelShapes.union(BUTT_COMB_1, BUTT_COMB_2);

    public static VoxelShape ED_1 = VoxelShapes.combineAndSimplify(EDGE_1_COMBINED, EDGE_1T_COMBINED, BooleanBiFunction.OR);
    public static VoxelShape ED_2 = VoxelShapes.combineAndSimplify(EDGE_2_COMBINED, EDGE_2T_COMBINED, BooleanBiFunction.OR);
    public static VoxelShape ED_3 = VoxelShapes.combineAndSimplify(EDGE_3_COMBINED, EDGE_3T_COMBINED, BooleanBiFunction.OR);
    public static VoxelShape ED_4 = VoxelShapes.combineAndSimplify(EDGE_4_COMBINED, EDGE_4T_COMBINED, BooleanBiFunction.OR);
    public static VoxelShape EXPERIMENTAL = VoxelShapes.union(BUTTON_COMBINED, EDGE_1_COMBINED, EDGE_1T_COMBINED, EDGE_2_COMBINED, EDGE_2T_COMBINED, EDGE_3_COMBINED, EDGE_3T_COMBINED, EDGE_4_COMBINED, EDGE_4T_COMBINED);
    public static VoxelShape EXPERIMENTAL2 = VoxelShapes.union(ED_1, ED_2, BUTTON_COMBINED, ED_3, ED_4 );




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
        return VoxelShapes.cuboid(0.1f, 0f, 0.1f, 0.9f, 0.4f, 0.9f);

       // return EXPERIMENTAL2;
        //return VoxelShapes.cuboid(5f, 0f, 5f, 11f, 7f, 11f);
        //return BUTTON_COMBINED;
        //return BUTTON_BOX;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.1f, 0f, 0.1f, 0.9f, 0.4f, 0.9f);
        //return EXPERIMENTAL2;
        //return VoxelShapes.cuboid(5f, 0f, 5f, 11f, 7f, 11f);
        //return BUTTON_COMBINED;
       // return BUTTON_BOX;
    }



}

package net.gridboy.amongus.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.gridboy.amongus.item.AmongusItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class EmergencyButtonBlockRenderer extends BlockEntityRenderer<EmergencyButtonBlockEntity> {

    private static final ItemStack EMERGENCY_ICON = new ItemStack(AmongusItems.EMERGENCY_ITEM, 1);

    public EmergencyButtonBlockRenderer(BlockEntityRenderDispatcher dispatcher)
    {
        super(dispatcher);
    }

    @Override
    public void render(EmergencyButtonBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        // Calculate the current offset in the y value
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;

        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);

        // Rotate the item
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));

        // Tells minecraft to place light above the block so the rendered item is not black
        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());

        MinecraftClient.getInstance().getItemRenderer().renderItem(EMERGENCY_ICON, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers);

        // Mandatory call after GL calls
        matrices.pop();
    }

}

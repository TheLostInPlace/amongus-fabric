package net.gridboy.amongus.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.gridboy.amongus.Amongus;
import net.gridboy.amongus.guis.WireTaskController;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.TickableElement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class WireTaskScreen extends CottonInventoryScreen<WireTaskController> implements Drawable, TickableElement {

    public Identifier TEXTURE = new Identifier(Amongus.MOD_ID, "/textures/gui/wire_task_texture.png");


    public WireTaskScreen(WireTaskController description, PlayerEntity player, Text title) {
        super(description, player, title);
    }

//    @Override
//    public void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        assert this.client != null;
//        this.client.getTextureManager().bindTexture(TEXTURE);
//        int i = this.x;
//        int j = this.y;
//        this.drawTexture(matrices, i, j, 0, 0, 256, 256);
//        super.drawBackground(matrices, delta, mouseX, mouseY);
//    }
//
//    @Override
//    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
//        this.renderBackground(matrices);
//        this.drawBackground(matrices, delta, mouseX, mouseY);
//        super.render(matrices, mouseX, mouseY, delta);
//    }

}

package net.gridboy.amongus.widgets;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WWireWidget extends WButton {

    private static final Identifier TEXTURE = new Identifier("among_us", "textures/gui/wire_end.png");

    @Override
    public boolean canResize() {
        return false; // set to false if you want a static size
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        // This is the most important method of a custom widget, where you decide how it'll look.
        // If you want the whole texture
        matrices.push();
        //matrices.translate(10, 5, 5);
        //matrices.scale(1 ,1 ,1);
        ScreenDrawing.texturedRect(matrices, x, y, 256, 256, TEXTURE, 0xFFFFFFFF);

        // or for partial textures:
//        ScreenDrawing.texturedRect(x, y, width, height, TEXTURE, u1, v1, u2, v2, 0xFFFFFFFF);
        // u1, v1, u2, v2 are fractions of the texture dimensions, so for example for the top half (u: 0-1, v: 0-0.5):
//        ScreenDrawing.texturedRect(x, y, width, height, TEXTURE, 0f, 0f, 1f, 0.5f, 0xFFFFFFFF);
        matrices.pop();
        // the 0xFFFFFFFF is the color in ARGB format, which in this case is white
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onClick(int x, int y, int button) {
        // x & y are the coordinates of the mouse when the event was triggered
        // int button is which button was pressed
        System.out.println("Sus!!!!");
    }

}

package net.gridboy.amongus.block.entity;

import net.gridboy.amongus.block.AmongusBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class VentBlockEntity extends BlockEntity implements Tickable {
    public VentBlockEntity ()
    {
        super(AmongusBlocks.VENT_BLOCK_ENTITY);
    }

    @Override
    public void tick()
    {
        //System.out.println((i++) + " ticks elapsed");
    }
}

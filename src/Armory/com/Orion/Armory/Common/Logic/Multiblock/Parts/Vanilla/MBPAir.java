package com.Orion.Armory.Common.Logic.Multiblock.Parts.Vanilla;
/*
/  MBPAir
/  Created by : Orion
/  Created on : 02/10/2014
*/

import com.Orion.Armory.Common.Logic.Multiblock.IMultiBlockPart;
import com.Orion.Armory.Util.References;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class MBPAir implements IMultiBlockPart
{
    String iInternalName = References.InternalNames.MultiBlock.Air;

    @Override
    public String getInternalName() {
        return this.iInternalName;
    }

    @Override
    public boolean validatePart(Integer pXCoord, Integer pYCoord, Integer pZCoord, World pWorld) {
        if (pWorld.getBlock(pXCoord, pYCoord, pZCoord) == Blocks.air)
        {
            return true;
        }

        return false;
    }
}
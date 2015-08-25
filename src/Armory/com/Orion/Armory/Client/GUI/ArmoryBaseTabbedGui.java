/*
 * Copyright (c) 2015.
 *
 * Copyrighted by SmithsModding according to the project License
 */

package com.Orion.Armory.Client.GUI;

import com.Orion.Armory.Client.GUI.Components.Tab.ITabbedHost;
import com.Orion.Armory.Client.GUI.Components.Tab.TabManager;
import net.minecraft.inventory.Container;
import org.lwjgl.opengl.GL11;

public abstract class ArmoryBaseTabbedGui extends ArmoryBaseGui implements ITabbedHost {

    private TabManager iTabManager = new TabManager(this);

    public ArmoryBaseTabbedGui(Container pTargetedContainer) {
        super(pTargetedContainer);
    }

    @Override
    public void initGui() {
        super.initGui();

        initializeTabManager();
    }

    @Override
    public int getWidth() {
        return iTabManager.getXSize();
    }

    @Override
    public int getHeigth() {
        return iTabManager.getYSize();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float pFloat, int pMouseX, int pMouseY) {
        GL11.glPushMatrix();
        GL11.glTranslatef(getXOrigin(), getYOrigin(), 0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        iTabManager.renderTabsBackground(pFloat, pMouseX, pMouseY);

        GL11.glPopMatrix();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int pMouseX, int pMouseY) {
        super.drawGuiContainerForegroundLayer(pMouseX, pMouseY);

        iTabManager.renderTabsForeground(pMouseX, pMouseY);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (iTabManager.handleMouseClick(mouseX - getXOrigin(), mouseY - getYOrigin(), mouseButton))
            return;

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public TabManager getTabManager() {
        return iTabManager;
    }

    protected abstract void initializeTabManager();
}
package com.ldtteam.armory.api.client.model.renderinfo;

import com.ldtteam.smithscore.client.textures.ITextureController;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * Created by marcf on 1/3/2017.
 */
public interface IRenderInfoProvider<T> {

    /**
     * Getter for the RenderInfo of the current Provider.
     * @return The current renderinfo.
     */
    @SideOnly(Side.CLIENT)
    @Nonnull
    ITextureController getRenderInfo();

    /**
     * Setter for the RenderInfo of the current Provider.
     * @param renderInfo The new renderinfo.
     *
     *
     */
    @SideOnly(Side.CLIENT)
    T setRenderInfo(@Nonnull ITextureController renderInfo);

    /**
     * Method to get the Override for the texture.
     * Has to be supplied so that resourcepack makers can override the behaviour if they fell the need to do it.
     * @return The override identifier for overloading the programmatic behaviour of the RenderInfo.
     *
     *
     */
    @SideOnly(Side.CLIENT)
    @Nonnull
    String getTextureOverrideIdentifier();
}

package com.scmspain.workshop.command;

import com.netflix.ribbon.RibbonRequest;
import io.netty.buffer.ByteBuf;

/**
 * Created by xavier.fornes on 28/08/15.
 */
public interface CampaignRibbonCommandAlt {
    public RibbonRequest<ByteBuf> getForlayo2(String id);
}

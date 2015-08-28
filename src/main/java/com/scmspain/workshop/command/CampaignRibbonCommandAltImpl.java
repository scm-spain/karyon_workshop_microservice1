package com.scmspain.workshop.command;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.ClientProperties;
import com.netflix.ribbon.proxy.annotation.ClientProperties.Property;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.Var;
import io.netty.buffer.ByteBuf;

/**
 * Created by xavier.fornes on 28/08/15.
 */
@ClientProperties(
        properties = {
                @Property(name = "DeploymentContextBasedVipAddresses", value = "microservice-2"),
                @Property(name = "NIWSServerListClassName", value = "com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList"),
        }
)
public interface CampaignRibbonCommandAltImpl extends CampaignRibbonCommandAlt {
    @Override
    @Http(method = Http.HttpMethod.GET, uri="/forlayo2/{id}")
    public RibbonRequest<ByteBuf> getForlayo2(@Var("id") String id);
}

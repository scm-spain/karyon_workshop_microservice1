package com.scmspain.workshop.command;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.client.config.IClientConfig;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;
import io.netty.buffer.ByteBuf;

/**
 * Created by victor.caldentey on 10/6/15.
 */
@Singleton
public class CampaignRibbonCommand {

    private IClientConfig clientConfig;
    private HttpResourceGroup httpResourceGroup;

    @Inject
    public CampaignRibbonCommand(IClientConfig clientConfig){
        this.clientConfig = clientConfig;
        this.clientConfig.loadProperties("ribboninfo-client");
        httpResourceGroup = Ribbon.createHttpResourceGroup("microservice-2",ClientOptions.from(clientConfig));
    }


    public RibbonRequest<ByteBuf> getForlayo2(String id){

        HttpRequestTemplate<ByteBuf> campaignById =
                httpResourceGroup.newTemplateBuilder("getForlayo2", ByteBuf.class)
                        .withMethod("GET")
                        .withUriTemplate("/forlayo2/{id}")
                        .build();

        return campaignById.requestBuilder()
                .withRequestProperty("id",id)
                .build();

    }

}

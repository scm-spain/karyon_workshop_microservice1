package com.scmspain.workshop.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.ribbon.RibbonRequest;
import com.scmspain.workshop.command.CampaignRibbonCommand;
import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import rx.Observable;
import scmspain.karyon.restrouter.annotation.Endpoint;
import scmspain.karyon.restrouter.annotation.Path;

import javax.ws.rs.HttpMethod;
import java.nio.charset.Charset;

@Singleton
@Endpoint
public class ForlayoEndpoint {


    private CampaignRibbonCommand campaignRibbonCommand;

    @Inject
    public ForlayoEndpoint(CampaignRibbonCommand campaignRibbonCommand)
    {
        this.campaignRibbonCommand = campaignRibbonCommand;
    }


    @Path(value = "/forlayos", method = HttpMethod.GET )
    public Observable<Void> getForlayosResource(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {


            return response.writeStringAndFlush("Minglanillas!" + "\n")
                    .concatWith(response.close());



    }

    @Path(value = "/call_to_ms2", method = HttpMethod.GET )
    public Observable<Void> getMicroservice2Resource(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {


        RibbonRequest<ByteBuf> ribbonResponse = campaignRibbonCommand.getForlayo2("1");
        return ribbonResponse.observe()
                .flatMap(data -> {
                            return response.writeStringAndFlush(data.toString(Charset.defaultCharset())).concatWith(response.close());
                        }
                );



    }



}

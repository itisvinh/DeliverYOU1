package com.deliveryou.serializer;

import com.deliveryou.pojo.PostAuction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class PostAuctionListSerializer extends StdSerializer<List<PostAuction>> {
    public PostAuctionListSerializer() {
        this(null);
    }

    public PostAuctionListSerializer(Class<List<PostAuction>> t) {
        super(t);
    }

    @Override
    public void serialize(List<PostAuction> postAuctions, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();

        for (PostAuction postAuction : postAuctions) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("postId", postAuction.getPost().getId());
            jsonGenerator.writeNumberField("shipperId", postAuction.getShipper().getId());
            jsonGenerator.writeNumberField("shippingFee", postAuction.getShippingFee());
            jsonGenerator.writeNumberField("requestedTime", postAuction.getRequestTime().getTime());
            jsonGenerator.writeStringField("shipperAvatar", postAuction.getShipper().getAvatar());
            jsonGenerator.writeStringField("shipperName", postAuction.getShipper().getFirstname() + " " + postAuction.getShipper().getLastname());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}

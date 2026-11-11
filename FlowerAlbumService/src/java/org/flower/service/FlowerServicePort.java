/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flower.service;

import java.awt.Image;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Carlos Antonio Ruiz
 */
@Path("flowerserviceport")
public class FlowerServicePort {

    private org.flower.service_client.FlowerService port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlowerServicePort
     */
    public FlowerServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method getThumbnails
     * @return an instance of javax.xml.bind.JAXBElement<org.flower.service_client.GetThumbnailsResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("getthumbnails/")
    public JAXBElement<org.flower.service_client.GetThumbnailsResponse> getThumbnails() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<java.awt.Image> result = port.getThumbnails();

                class GetThumbnailsResponse_1 extends org.flower.service_client.GetThumbnailsResponse {

                    GetThumbnailsResponse_1(java.util.List<java.awt.Image> _return) {
                        this._return = _return;
                    }
                }
                org.flower.service_client.GetThumbnailsResponse response = new GetThumbnailsResponse_1(result);
                return new org.flower.service_client.ObjectFactory().createGetThumbnailsResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getFlower
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.awt.Image>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("getflower/")
    public JAXBElement<Image> getFlower(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.awt.Image result = port.getFlower(name);
                return new JAXBElement<java.awt.Image>(new QName("http//awt.java/", "image"), java.awt.Image.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method hello
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("hello/")
    public String getHello(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.hello(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private org.flower.service_client.FlowerService getPort() {
        try {
            // Call Web Service Operation
            org.flower.service_client.FlowerService_Service service = new org.flower.service_client.FlowerService_Service();
            org.flower.service_client.FlowerService p = service.getFlowerServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}

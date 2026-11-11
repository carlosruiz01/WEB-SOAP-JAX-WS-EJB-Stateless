
package org.flower.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.flower.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetThumbnails_QNAME = new QName("http://service.flower.org/", "getThumbnails");
    private final static QName _GetFlowerResponse_QNAME = new QName("http://service.flower.org/", "getFlowerResponse");
    private final static QName _GetThumbnailsResponse_QNAME = new QName("http://service.flower.org/", "getThumbnailsResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://service.flower.org/", "helloResponse");
    private final static QName _GetFlower_QNAME = new QName("http://service.flower.org/", "getFlower");
    private final static QName _IOException_QNAME = new QName("http://service.flower.org/", "IOException");
    private final static QName _Hello_QNAME = new QName("http://service.flower.org/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.flower.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetThumbnails }
     * 
     */
    public GetThumbnails createGetThumbnails() {
        return new GetThumbnails();
    }

    /**
     * Create an instance of {@link GetFlowerResponse }
     * 
     */
    public GetFlowerResponse createGetFlowerResponse() {
        return new GetFlowerResponse();
    }

    /**
     * Create an instance of {@link GetThumbnailsResponse }
     * 
     */
    public GetThumbnailsResponse createGetThumbnailsResponse() {
        return new GetThumbnailsResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GetFlower }
     * 
     */
    public GetFlower createGetFlower() {
        return new GetFlower();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThumbnails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "getThumbnails")
    public JAXBElement<GetThumbnails> createGetThumbnails(GetThumbnails value) {
        return new JAXBElement<GetThumbnails>(_GetThumbnails_QNAME, GetThumbnails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "getFlowerResponse")
    public JAXBElement<GetFlowerResponse> createGetFlowerResponse(GetFlowerResponse value) {
        return new JAXBElement<GetFlowerResponse>(_GetFlowerResponse_QNAME, GetFlowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThumbnailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "getThumbnailsResponse")
    public JAXBElement<GetThumbnailsResponse> createGetThumbnailsResponse(GetThumbnailsResponse value) {
        return new JAXBElement<GetThumbnailsResponse>(_GetThumbnailsResponse_QNAME, GetThumbnailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "getFlower")
    public JAXBElement<GetFlower> createGetFlower(GetFlower value) {
        return new JAXBElement<GetFlower>(_GetFlower_QNAME, GetFlower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flower.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}

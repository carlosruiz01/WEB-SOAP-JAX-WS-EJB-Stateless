/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flower.service;

import java.net.URL;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.jws.WebParam;

/**
 *
 * @author Carlos Antonio Ruiz
 * FlowerService es un servicio web que proporciona métodos para recuperar imágenes de flores y miniaturas.
 * Está implementado como un servicio web JAX-WS y utiliza EJB Stateless para la lógica de negocio.
 * Las imágenes de las flores se almacenan en el paquete de recursos del proyecto.
 */
@WebService(serviceName = "FlowerService", wsdlLocation="WEB-INF/wsdl/FlowerService.wsdl")
@Stateless()
public class FlowerService {
    
    // Lista de nombres de flores disponibles
    private static final String[] FLOWERS = {"aster", "honeysuckle", "rose", "sunflower"};
    
    /**
     * Recupera todas las imágenes de flores disponibles.
     * @return Lista de bytes de las imágenes de las flores.
     * @throws IOException Si ocurre un error al leer las imágenes.
     */
    private List allFlowers() throws IOException {
        List flowers = new ArrayList();
        for (String flower : FLOWERS) {
            URL resource = this.getClass().getResource("/org/flower/resources/" + flower + ".jpg");
            flowers.add(getBytes(resource));
        }
        return flowers;
    }
    
    /**
     * Lee los bytes de una imagen desde la URL proporcionada.
     * @param resource La URL de la imagen.
     * @return Bytes de la imagen.
     * @throws IOException Si ocurre un error al leer los bytes de la imagen.
     */
    private byte[] getBytes(URL resource) throws IOException {
        InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int read; (read = in.read(buf)) != -1;) {
            bos.write(buf, 0, read);
        }
        return bos.toByteArray();
    }
    
    /**
     * Recupera los bytes de la imagen de una flor específica.
     * @param name El nombre de la flor.
     * @return Bytes de la imagen de la flor.
     * @throws IOException Si ocurre un error al leer los bytes de la imagen.
     */
    private byte[] getFlowerBytes(String name) throws IOException {
        URL resource = this.getClass().getResource("/org/flower/resources/" + name + ".jpg");
        return getBytes(resource);
    }
    
    /**
     * Obtiene la imagen de los bytes proporcionados.
     * @param bytes Bytes de la imagen.
     * @param isThumbnail Booleano que indica si se debe obtener una miniatura de la imagen.
     * @return La imagen.
     * @throws IOException Si ocurre un error al leer la imagen.
     */
    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {
            param.setSourceSubsampling(4, 4, 0, 0);
        }
        reader.setInput(iis, true);
        return reader.read(0, param);
    }

    /**
     * Este es un método de operación de muestra del servicio web.
     * @param txt El nombre que se utilizará en el saludo.
     * @return Un saludo con el nombre proporcionado.
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operación de servicio web para recuperar la imagen de una flor específica.
     * @param name El nombre de la flor.
     * @return La imagen de la flor.
     * @throws IOException Si ocurre un error al leer la imagen.
     */
    @WebMethod(operationName = "getFlower")
    public Image getFlower(@WebParam(name = "name") String name) throws IOException {
        byte[] bytes = getFlowerBytes(name);
        return getImage(bytes, false);
    }

     /**
     * Operación de servicio web para recuperar miniaturas de todas las imágenes de flores disponibles.
     * @return Lista de miniaturas de imágenes de flores.
     * @throws IOException Si ocurre un error al leer las imágenes.
     */
    @WebMethod(operationName = "getThumbnails")
    public List<Image> getThumbnails() throws IOException {
        List<byte[]> flowers = allFlowers();
        List<Image> flowerList = new ArrayList<Image>(flowers.size());
        for (byte[] flower : flowers) {
            flowerList.add(getImage(flower, true));
        }
        return flowerList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerclient;

import java.util.Map;
import java.awt.Image;
import java.util.HashMap;
import org.flower.service.FlowerService;
import org.flower.service.FlowerService_Service;
import org.flower.service.IOException_Exception;
import java.util.List;

/**
 *
 * @author Carlos Antonio Ruiz
 * FlowerClient es una clase que actúa como cliente para el servicio web FlowerService.
 * Se utiliza para descargar imágenes de flores y miniaturas de imágenes de flores del servicio web y
 * mostrarlas en una interfaz gráfica de usuario (GUI).
 * El cliente utiliza hilos para realizar llamadas asíncronas al servicio web.
 */
public class FlowerClient {
    
    // Contador para rastrear el número de imágenes descargadas
    private static int downloadedPictures;

    /**
     * Método principal de la aplicación cliente.
     * Se encarga de iniciar la interfaz gráfica de usuario y realizar las llamadas al servicio web.
     * @param args Los argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Mapas para almacenar las imágenes de flores y sus miniaturas
        final Map<String, Image> flowers = new HashMap<String, Image>(4);
        final Map<String, Image> thumbs = new HashMap<String, Image>(4);
        
        // Crear y mostrar la ventana de la aplicación
        final FlowerFrame frame = new FlowerFrame(flowers);
        frame.setVisible(true);
        
        // Crear un cliente del servicio web
        FlowerService_Service service = new FlowerService_Service();
        final FlowerService port = service.getFlowerServicePort();
        
        // Crear tareas para descargar las imágenes de las flores
        Runnable[] tasks = new Runnable[4];
        
        // Iniciar hilos para realizar llamadas al servicio web de forma asíncrona
        for (int i = 0; i < 4; i++) {
            final int index = i;
            tasks[i] = new Runnable() {
                public void run() {
                    try {
                        // Llamar a la operación getFlower del servicio web para obtener la imagen de la flor
                        Image img = port.getFlower(FlowerFrame.FLOWERS[index]);
                        System.out.println("picture downloaded: " + FlowerFrame.FLOWERS[index]);
                        // Agregar la imagen al mapa de flores
                        flowers.put(FlowerFrame.FLOWERS[index], img);
                        // Mostrar la imagen en la interfaz gráfica de usuario
                        frame.showFlower();

                    } catch (IOException_Exception ex) {
                        ex.printStackTrace();
                    }
                    // Incrementar el contador de imágenes descargadas
                    downloadedPictures++;
                }
            };
            // Iniciar un nuevo hilo para la tarea
            new Thread(tasks[i]).start();
        }
        
        // Tarea para descargar las miniaturas de las imágenes de flores
        Runnable thumbsTask = new Runnable() {
            public void run() {
                try {
                    // Esperar hasta que todas las imágenes se hayan descargado
                    while (downloadedPictures < 4) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }

                    // Llamar a la operación getThumbnails del servicio web para obtener las miniaturas
                    List<Image> images = port.getThumbnails();
                    System.out.println("thumbs downloaded");
                    
                    // Verificar si se obtuvieron correctamente todas las miniaturas
                    if (images != null && images.size() == 4) {
                        
                        // Agregar las miniaturas al mapa de miniaturas
                        for (int i = 0; i < 4; i++) {
                            thumbs.put(FlowerFrame.FLOWERS[i], images.get(i));
                        }
                        
                        // Establecer las miniaturas en la interfaz gráfica de usuario
                        frame.setThumbnails(thumbs);
                    }
                } catch (IOException_Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        // Iniciar un nuevo hilo para la tarea de miniaturas
        new Thread(thumbsTask).start();
    }

}

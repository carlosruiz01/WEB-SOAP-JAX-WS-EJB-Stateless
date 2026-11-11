# FlowerService
## Descripción
FlowerService es un servicio web desarrollado en Java que permite recuperar imágenes de flores y generar miniaturas (thumbnails) a partir de ellas.

El servicio está implementado utilizando JAX-WS para exponer sus operaciones como servicios web y EJB Stateless para gestionar la lógica de negocio.

Las imágenes de las flores se encuentran almacenadas dentro del paquete de recursos del proyecto, desde donde son recuperadas para proporcionar su contenido en formato de bytes.

## Funcionamiento
El funcionamiento general de FlowerService es el siguiente:

- El cliente realiza una solicitud al servicio web.
- El servicio recibe los parámetros necesarios para ejecutar la operación solicitada.
- El componente EJB Stateless procesa la solicitud.
- Se accede a los recursos del proyecto para localizar y leer las imágenes.
- Las imágenes se procesan y se convierten en arreglos de bytes (byte[]).
- El servicio devuelve el resultado al cliente.

# FlowerClient
FlowerClient es una aplicación cliente desarrollada en Java que permite interactuar con el servicio web FlowerService para descargar imágenes de flores y sus respectivas miniaturas.

La aplicación cuenta con una interfaz gráfica de usuario (GUI) que permite visualizar las imágenes obtenidas desde el servicio web.

Para mejorar la experiencia del usuario y evitar bloqueos en la interfaz, el cliente utiliza hilos (Threads) para realizar llamadas asíncronas al servicio web, permitiendo que las operaciones de descarga se ejecuten en segundo plano.

import java.util.Scanner;


public class Main {

    private static final int LONGITUD_MAX_ID = 10;
    private static final int LONGITUD_MIN_ID = 1;
    private static final int LONGITUD_MIN_NOMBRE = 3;
    private static final int LONGITUD_MAX_NOMBRE = 50;
    private static final int LONGITUD_MIN_MARCA = 2;
    private static final int LONGITUD_MAX_MARCA = 30;
    private static final double PRECIO_MINIMO = 0.01;
    private static final int STOCK_MINIMO = 0;

    public static void main(String[] args) {
        
        Scanner carga = new Scanner(System.in);
        Elementos[] listaElementos = new Elementos[1000];
        int opcionMenu, contador = 0;

        do {
            System.out.println("Bienvenido a nuestra Farmacia");
            System.out.println("1. Cargar el producto");
            System.out.println("2. Ver/Modificar/Eliminar el producto");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción: ");
            opcionMenu = carga.nextInt();

            switch (opcionMenu) {
                case 1: // ingresar productos al arreglo
                    System.out.println("Ingrese el id del producto");
                    String id = carga.next();
                    
                    // Validación para verificar que el ID no exista ya
                    while (id.length() > LONGITUD_MAX_ID || id.length() < LONGITUD_MIN_ID || productoExistente(id, listaElementos, contador)) {
                        if (productoExistente(id, listaElementos, contador)) {
                            System.out.println("ID ya existe. Ingrese otro ID único.");
                        } else {
                            System.out.println("ID inválido. Debe tener entre 1 y 10 caracteres.");
                        }
                        id = carga.next();
                    }

                    // Limpiar el buffer
                    carga.nextLine(); 

                    System.out.println("Ingrese el nombre");
                    String nombre = carga.nextLine();
                    // Validación del nombre
                    while (nombre.length() < LONGITUD_MIN_NOMBRE || nombre.length() > LONGITUD_MAX_NOMBRE) {
                        System.out.println("Nombre inválido. Debe tener entre 3 y 50 caracteres.");
                        nombre = carga.nextLine();
                    }

                    System.out.println("Ingrese la marca");
                    String marca = carga.nextLine();
                    // Validación de la marca
                    while (marca.length() < LONGITUD_MIN_MARCA || marca.length() > LONGITUD_MAX_MARCA) {
                        System.out.println("Marca inválida. Debe tener entre 2 y 30 caracteres.");
                        marca = carga.nextLine();
                    }

                    System.out.println("Ingrese el precio");
                    double precio = carga.nextDouble();
                    // Validación del precio
                    while (precio <= PRECIO_MINIMO) {
                        System.out.println("Precio inválido. Debe ser mayor que 0.");
                        precio = carga.nextDouble();
                    }

                    System.out.println("Ingrese el stock");
                    int stock = carga.nextInt();
                    // Validación del stock 
                    while (stock < STOCK_MINIMO) {
                        System.out.println("Stock inválido. Debe ser mayor o igual a 0.");
                        stock = carga.nextInt();
                    }

                    // Crea el objeto y lo almacena en el array
                    listaElementos[contador] = new Elementos(id, nombre, marca, precio, stock);
                    contador++;

                    System.out.println("Producto cargado correctamente.");
                    break;

                case 2: // editar, eliminar y ver productos del arreglo
                    System.out.println("Productos Ingresados:  " + contador);
                    System.out.println("Ingrese el id del producto que desea ver/modificar/eliminar");
                    String idBuscar = carga.next();
                    boolean encontrado = false;
                    for (int i = 0; i < contador; i++) {
                        if (listaElementos[i].getId().equals(idBuscar)) { // equals compara cadenas de texto
                            encontrado = true;
                            System.out.println("Producto encontrado: " + listaElementos[i].getNombre());
                            System.out.println("1. Modificar producto");
                            System.out.println("2. Eliminar producto");
                            System.out.println("3. Ver producto");
                            System.out.println("Ingrese una opción: ");
                            int opcionSubmenu = carga.nextInt();
                            switch (opcionSubmenu) {
                                case 1:
                                    System.out.println("¿Qué desea modificar?");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Marca");
                                    System.out.println("3. Precio");
                                    System.out.println("4. Stock");
                                    System.out.println("Ingrese una opción: ");
                                    int opcionModificar = carga.nextInt();
                                    switch (opcionModificar) {
                                        case 1:
                                            System.out.println("Ingrese el nuevo nombre:");
                                            carga.nextLine(); // Limpiar el buffer
                                            String nuevoNombre = carga.nextLine();
                                            // Validación del nuevo nombre
                                            while (nuevoNombre.length() < LONGITUD_MIN_NOMBRE || nuevoNombre.length() > LONGITUD_MAX_NOMBRE) {
                                                System.out.println("Nombre inválido. Debe tener entre 3 y 50 caracteres.");
                                                nuevoNombre = carga.nextLine();
                                            }
                                            listaElementos[i].setNombre(nuevoNombre); 
                                            break;
                                        case 2:
                                            System.out.println("Ingrese la nueva marca:");
                                            carga.nextLine(); // Limpiar el buffer
                                            String nuevaMarca = carga.nextLine();
                                            // Validación de la nueva marca
                                            while (nuevaMarca.length() < LONGITUD_MIN_MARCA || nuevaMarca.length() > LONGITUD_MAX_MARCA) {
                                                System.out.println("Marca inválida. Debe tener entre 2 y 30 caracteres.");
                                                nuevaMarca = carga.nextLine();
                                            }
                                            listaElementos[i].setMarca(nuevaMarca);
                                            break;
                                        case 3:
                                            System.out.println("Ingrese el nuevo precio:");
                                            double nuevoPrecio = carga.nextDouble();
                                            // Validación del nuevo precio
                                            while (nuevoPrecio <= PRECIO_MINIMO) {
                                                System.out.println("Precio inválido. Debe ser mayor que 0.");
                                                nuevoPrecio = carga.nextDouble();
                                            }
                                            listaElementos[i].setPrecio(nuevoPrecio);
                                            break;
                                        case 4:
                                            System.out.println("Ingrese el nuevo stock:");
                                            int nuevoStock = carga.nextInt();
                                            // Validación del nuevo stock
                                            while (nuevoStock < STOCK_MINIMO) {
                                                System.out.println("Stock inválido. Debe ser mayor o igual a 0.");
                                                nuevoStock = carga.nextInt();
                                            }
                                            listaElementos[i].setStock(nuevoStock);
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta.");
                                    }
                                    System.out.println("Producto modificado.");
                                    break;
                                case 2:
                                    for (int j = i; j < contador - 1; j++) {
                                        listaElementos[j] = listaElementos[j + 1];
                                    }
                                    contador--;
                                    System.out.println("Producto eliminado.");
                                    break;
                                case 3:
                                    System.out.println("ID: " + listaElementos[i].getId());
                                    System.out.println("Nombre: " + listaElementos[i].getNombre());
                                    System.out.println("Marca: " + listaElementos[i].getMarca());
                                    System.out.println("Precio: " + listaElementos[i].getPrecio());
                                    System.out.println("Stock: " + listaElementos[i].getStock());
                                    break;
                                default:
                                    System.out.println("Opción incorrecta.");
                            }
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Gracias por usar este programa...");
                    break;
                default:
                    System.out.println("Ha marcado una opción incorrecta...");
                    break;
            }

        } while (opcionMenu != 3);
        carga.close(); 
    }

    // verifica si el ID ya existe en el array de productos
    private static boolean productoExistente(String id, Elementos[] listaElementos, int contador) {
        for (int i = 0; i < contador; i++) {
            if (listaElementos[i].getId().equals(id)) {
                return true; // El ID existe
            }
        }
        return false; // El ID no existe
    }
}

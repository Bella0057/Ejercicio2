import com.example.Entidad.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearProducto("Carro", 456000, 3);

        Producto producto1 = leerProducto(1L);  // Asegurándote de pasar el id
        if (producto1 != null) {
            System.out.println("El producto fue encontrado: " + producto1.getNombre());  // Accediendo al método correctamente
        }

        actualizarProducto(1L, "Carro Actualizado", 500000, 5);
        eliminarProducto(1L);
    }

    // Crear producto
    public static void crearProducto(String nombre, int precio, int cantidadEnStock) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Producto producto1 = new Producto();
        producto1.setNombre(nombre);
        producto1.setPrecio(precio);
        producto1.setCantidadEnStock(cantidadEnStock);

        em.persist(producto1);
        em.getTransaction().commit();
        em.close();
    }

    // Leer producto
    public static Producto leerProducto(long id) {
        EntityManager em = emf.createEntityManager();
        Producto producto1 = em.find(Producto.class, id);  // Asegurándote de pasar el id
        em.close();
        return producto1;
    }

    // Actualizar producto
    public static void actualizarProducto(long id, String nuevoNombre, int nuevoPrecio, int nuevaCantidadEnStock) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Producto producto1 = em.find(Producto.class, id);
        if (producto1 != null) {
            producto1.setNombre(nuevoNombre);  // Usando la instancia
            producto1.setPrecio(nuevoPrecio);  // Usando la instancia
            producto1.setCantidadEnStock(nuevaCantidadEnStock);  // Usando la instancia
            em.merge(producto1);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Eliminar producto
    public static void eliminarProducto(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Producto producto1 = em.find(Producto.class, id);
        if (producto1 != null) {
            em.remove(producto1);
        }

        em.getTransaction().commit();
        em.close();
    }
}

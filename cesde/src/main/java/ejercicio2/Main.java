import com.example.Entidad.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearProducto("Carro", 456000, 3);

        Producto producto1 = leerProducto(1l);
        if (producto1 != null){
            System.out.println("El producto fue encontrado: " + Producto.getNombre)
        }
        actualizarProducto(1l);
        eliminarProducto(1l);
    }

    public static void crearProducto(String nombre, int precio, int cantidadEnStock){
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

    public static void leerProducto(){
        EntityManager em = emf.createEntityManager();
    Producto producto1 = em.find(Producto.class, id);
    em.close();
    return producto1;
    }

    public static void actualizarProducto(long id, String nombre, int precio, int cantidadEnStock){
        Producto producto1 = em.find(Producto.class, id);
        if (producto1 != null){
            Producto.setNombre(nuevoNombre);
            Producto.setEmail(nuevoPrecio);
            Producto.setTelefono(nuevoCantidadEnStock);
            em.merge(producto1);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void eliminarProducto(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Producto producto1 = em.find(Producto.class, id);
        if (producto1 != null){
            em.remove(producto1);
        }

        em.getTransaction().commit();
        em.close();
    }
}
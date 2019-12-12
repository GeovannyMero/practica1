
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.producto;

/**
 *
 * @author jeffe
 */
public class productoDAO extends DAO{
    public void registrar(producto prod) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into producto values(nombre, categoria, stock, precio, fechaElaboracion, fechaVencimiento, estado) values(?,?,?,?,?,?,?)");
            st.setString(1, prod.getNombre());
            st.setInt(2, prod.getIdCategoria());
            st.setInt(3, prod.getStock());
            st.setDouble(4, prod.getPrecio());
            st.setString(5, prod.getFechaElaboracion());
            st.setString(6, prod.getFechaVencimiento());
            st.setBoolean(7, prod.isEstado());
            st.executeUpdate();
            
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
    public List<producto> listarProductos() throws Exception{
        List<producto> listaProducto = null;
        producto prd = new producto();
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("select * from producto");
            rs = st.executeQuery();
            listaProducto = new ArrayList();
            while(rs.next()){
                prd = new producto();
                prd.setId(rs.getInt("id"));
                prd.setIdCategoria(rs.getInt("idCategoria"));
                prd.setNombre(rs.getString("nombre"));
                prd.setStock(rs.getInt("stock"));
                prd.setPrecio(rs.getDouble("precio"));
                prd.setFechaElaboracion(rs.getString("fechaElaboracion"));
                prd.setFechaVencimiento(rs.getString("fechaVencimiento"));
                prd.setEstado(rs.getBoolean("estado"));
                listaProducto.add(prd);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.cerrar();
        }
        return listaProducto;

    }
}


package DAO;

import BEAN.CarreraBean;
import UTIL.ConexionBD;
import java.util.*;
import java.sql.*;

public class CarreraDAO {
    //conexion base datos
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ArrayList<CarreraBean> lista=null;
    CarreraBean objCarreraBean=null;
    
    public ArrayList<CarreraBean> ListarCarrera(){
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("select * from carrera;");
            rs=pt.executeQuery();
            lista=new ArrayList<CarreraBean>();
            while(rs.next()){
                objCarreraBean=new CarreraBean();
                objCarreraBean.setCODCARRERA(rs.getInt(1));
                objCarreraBean.setNOMBCARRERA(rs.getString(2));
                objCarreraBean.setESTADOCARRERA(rs.getString(3));
                lista.add(objCarreraBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int InsertarCarrera(CarreraBean objRegionBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("insert into carrera(CODCARRERA,NOMBCARRERA,ESTADOCARRERA) VALUES(?,?,?);");
            pt.setInt(1, objRegionBean.getCODCARRERA());
            pt.setString(2, objRegionBean.getNOMBCARRERA());
            pt.setString(3, objRegionBean.getESTADOCARRERA());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    
    public int ModificarCarrera(CarreraBean objCarreraBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE carrera set NOMBCARRERA=?  ESTADOCARRERA=? WHERE CODCARRERA=?;");
            pt.setString(1, objCarreraBean.getNOMBCARRERA());
            pt.setString(2, objCarreraBean.getESTADOCARRERA());
            pt.setInt(3, objCarreraBean.getCODCARRERA());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    
    public int EliminarCarrera(CarreraBean objCarreraBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("DELETE FROM carrera WHERE CODCARRERA=?;");
            pt.setInt(1, objCarreraBean.getCODCARRERA());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
}

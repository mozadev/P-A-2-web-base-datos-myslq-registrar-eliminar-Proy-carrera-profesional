
package SERVLET;

import BEAN.CarreraBean;
import DAO.CarreraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarreraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcad=request.getParameter("op");
        int op = Integer.parseInt(opcad);
        switch(op){
            case 1:{
                CarreraDAO objCarreraDAO = new CarreraDAO();
                ArrayList listacarrera=objCarreraDAO.ListarCarrera();
                request.setAttribute("listacarrera",listacarrera);
                getServletContext().getRequestDispatcher("/FrmCarreraMant.jsp").forward(request, response);
                break;
            }
            case 2:{
                getServletContext().getRequestDispatcher("/FrmMenuMant.jsp").forward(request, response);
                break;
            }
            case 3:{
                getServletContext().getRequestDispatcher("/FrmCarreraRegistrarMant.jsp").forward(request, response);
                break;
            }
            case 4:{
                String mensaje="";
                String codcad=request.getParameter("txtcodigo");
                int codigo=Integer.parseInt(codcad);
                String nombre = request.getParameter("txtnombre");
                String estado = request.getParameter("txtestado");
                CarreraBean objRegionBean = new CarreraBean();
                objRegionBean.setCODCARRERA(codigo);
                objRegionBean.setNOMBCARRERA(nombre);
                objRegionBean.setESTADOCARRERA(estado);
                CarreraDAO objRegionDAO = new CarreraDAO();
                int estadoBoolean = objRegionDAO.InsertarCarrera(objRegionBean);
                if(estadoBoolean==1){
                    mensaje="Registro Insertado !!";
                }else{
                    mensaje="Registro no insertado";
                }
                request.setAttribute("mensaje",mensaje);
              // getServletContext().getRequestDispatcher("/FrmCarreraRegistrarMant.jsp").forward(request, response);
                 CarreraDAO objCarreraDAO = new CarreraDAO();
                
                
                ArrayList listacarrera=objCarreraDAO.ListarCarrera();
                request.setAttribute("listacarrera",listacarrera);
                getServletContext().getRequestDispatcher("/FrmCarreraMant.jsp").forward(request, response);
              
                break;
            }
            case 5:{
                CarreraDAO objCarreraDAO = new CarreraDAO();
                ArrayList listacarrera=objCarreraDAO.ListarCarrera();
                request.setAttribute("listacarrera",listacarrera);
                getServletContext().getRequestDispatcher("/FrmCarreraMant.jsp").forward(request, response);
                break;
            }
            case 6:{
                String codcad=request.getParameter("COD");
                int codigo = Integer.parseInt(codcad);
                String nombre=request.getParameter("NOM");
                String estado=request.getParameter("ESTADO");
                CarreraBean objCarreraBean = new CarreraBean();
                objCarreraBean.setCODCARRERA(codigo);
                objCarreraBean.setNOMBCARRERA(nombre);
                objCarreraBean.setESTADOCARRERA(estado);
                request.setAttribute("datos", objCarreraBean);
                getServletContext().getRequestDispatcher("/FrmCarreraModificarMant.jsp").forward(request, response);
                break;
            }
            case 7:{
                String mensaje="";
                String codcad=request.getParameter("CODIGO");
                int codigo=Integer.parseInt(codcad);
                String nombre = request.getParameter("txtnombre");
                String estado = request.getParameter("txtestado");
                CarreraBean objCarreraBean = new CarreraBean();
                objCarreraBean.setCODCARRERA(codigo);
                objCarreraBean.setNOMBCARRERA(nombre);
                objCarreraBean.setESTADOCARRERA(estado);
                CarreraDAO objCarreraDAO = new CarreraDAO();
                int estadoV = objCarreraDAO.ModificarCarrera(objCarreraBean);
                if(estadoV==1){
                    mensaje="Registro Modificado";
                }else{
                    mensaje="Registro no Modificado";
                }
                request.setAttribute("mensaje",mensaje);
                request.setAttribute("datos",objCarreraBean);
                getServletContext().getRequestDispatcher("/FrmCarreraModificarMant.jsp").forward(request, response);
                break;
            }
            case 8:{
                String codcad=request.getParameter("COD");
                int codigo = Integer.parseInt(codcad);

                CarreraBean objCarreraBean = new CarreraBean();
                objCarreraBean.setCODCARRERA(codigo);
                
                CarreraDAO objCarreraDAO = new CarreraDAO();
                objCarreraDAO.EliminarCarrera(objCarreraBean);
                
                ArrayList listacarrera=objCarreraDAO.ListarCarrera();
                request.setAttribute("listacarrera",listacarrera);
                getServletContext().getRequestDispatcher("/FrmCarreraMant.jsp").forward(request, response);
                break;
            }
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

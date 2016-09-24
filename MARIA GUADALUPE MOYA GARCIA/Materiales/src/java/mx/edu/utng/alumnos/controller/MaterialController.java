package mx.edu.utng.alumnos.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.alumnos.dao.MaterialDAOImp;
import mx.edu.utng.alumnos.model.Material;
import mx.edu.utng.alumnos.dao.MaterialDAO;

public class MaterialController extends HttpServlet {
    private static final String LISTA_MATERIALES = "/listamateriales.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/material.jsp";
    private MaterialDAO dao ;
    
    public MaterialController(){
        dao = new MaterialDAOImp();
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")){
            forward = LISTA_MATERIALES; 
            int idMaterial = Integer.parseInt(
            request.getParameter("idMaterial"));
            dao.borrarMaterial(idMaterial);
            request.setAttribute("material", dao.desplegarMaterial()); 
        }else if (action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_O_CAMBIAR;
             int idMaterial = Integer.parseInt(
            request.getParameter("idMaterial"));
             Material material = dao.elegirMaterial(idMaterial);
             request.setAttribute("material", material);
        }else if (action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_O_CAMBIAR;
            request.setAttribute("materiales", dao.desplegarMaterial());
        }else{
            forward = LISTA_MATERIALES;
            request.setAttribute("material", dao.desplegarMaterial());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward); 
        view.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Material material = new Material();
        material.setNombre(request.getParameter("nombre"));
        material.setPrecio(Double.parseDouble(request.getParameter("precio")));
        material.setComision(Double.parseDouble(request.getParameter("comision")));
        material.setExistenciaMin(Integer.parseInt(request.getParameter("existenciaMin")));
        material.setExistenciaMax(Integer.parseInt(request.getParameter("existenciaMax")));
        
        String idMaterial = request.getParameter("idMaterial");
        
        if(idMaterial==null || idMaterial.isEmpty()){
                dao.agregarMaterial(material);
            }else{
            material.setIdMaterial(Integer.parseInt(idMaterial));
            dao.cambiarMaterial(material);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_MATERIALES);
        request.setAttribute("material", dao.desplegarMaterial());
        view.forward(request, response);
    }
}
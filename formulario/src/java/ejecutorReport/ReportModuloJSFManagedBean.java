/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutorReport;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author administrador
 */
@ManagedBean
@ViewScoped
public class ReportModuloJSFManagedBean {
    private int ids;
    /**
     * Creates a new instance of ReportModuloJSFManagedBean
     */
    public ReportModuloJSFManagedBean() {
        
    }
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //Instancia hacia la clase reporteModulos        
        reporteModulos rCliente = new reporteModulos();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporteModuloDoctor/reporteModuloDoctor.jasper");
       
        rCliente.getReporte(ruta,this.ids);        
        FacesContext.getCurrentInstance().responseComplete();               
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }
    
}

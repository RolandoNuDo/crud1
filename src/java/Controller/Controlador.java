/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Config.Conexion;
import Entidad.Persona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author rolo_
 */
@Controller
public class Controlador {
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "Select * From datos";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Persona P){
        String sql = "Insert into datos(nombre,apellido,puesto,correo) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,P.getNombre(),P.getApellido(),P.getPuesto(),P.getCorreo());
        
        return new ModelAndView("redirect:/index.htm");
    }
    
      @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql = "Select * From datos where id = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("editar");
        return mav;
    }
      @RequestMapping(value = "editar.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Persona p){
        String sql = "UPDATE datos SET nombre=?,apellido=?,puesto=?,correo=? WHERE id=" + id;
        this.jdbcTemplate.update(sql,p.getNombre(),p.getApellido(),p.getPuesto(),p.getCorreo());
        
        return new ModelAndView("redirect:/index.htm");
    }
    @RequestMapping("eliminar.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="DELETE FROM datos WHERE id = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/index.htm");
    }
}

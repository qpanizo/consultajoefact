package pe.joedayz.joefact.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.joefact.modelo.Grupo;
import pe.joedayz.joefact.repositorio.GrupoRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;


@FacesConverter(forClass=Grupo.class)
public class GrupoConverter implements Converter{

	
	private GrupoRepositorio grupoRepositorio;
	
	public GrupoConverter(){
		grupoRepositorio = CDIServiceLocator.getBean(GrupoRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Grupo retorno = null;
		
		if(value!=null){
			Long id = new Long(value);
			retorno = grupoRepositorio.obtenerGrupo(id); 
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null){
			Grupo grupo = (Grupo) value;
			return grupo.getIdeGrupo() == null ? null :  grupo.getIdeGrupo().toString();
		}
		
		return "";
	}

}

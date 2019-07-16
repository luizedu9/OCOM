package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Orquestra;
import service.OrquestraService;

@FacesConverter("orquestraConverter")
public class OrquestraConverter implements Converter{

	private OrquestraService service = new OrquestraService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Orquestra obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Orquestra aux = (Orquestra)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

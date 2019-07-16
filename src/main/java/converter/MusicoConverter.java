package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Musico;
import service.MusicoService;

@FacesConverter(forClass=Musico.class)
public class MusicoConverter implements Converter{

	private MusicoService service = new MusicoService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Musico obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Musico aux = (Musico)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

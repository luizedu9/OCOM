package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Ensaio;
import service.EnsaioService;

@FacesConverter("ensaioConverter")
public class EnsaioConverter implements Converter{

	private EnsaioService service = new EnsaioService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Ensaio obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Ensaio aux = (Ensaio)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

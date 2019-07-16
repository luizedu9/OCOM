package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Partitura;
import service.PartituraService;

@FacesConverter("partituraConverter")
public class PartituraConverter implements Converter{

	private PartituraService service = new PartituraService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Partitura obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Partitura aux = (Partitura)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

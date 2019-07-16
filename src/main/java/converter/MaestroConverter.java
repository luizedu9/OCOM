package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Maestro;
import service.MaestroService;

@FacesConverter(forClass=Maestro.class)
public class MaestroConverter implements Converter{

	private MaestroService service = new MaestroService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Maestro obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Maestro aux = (Maestro)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

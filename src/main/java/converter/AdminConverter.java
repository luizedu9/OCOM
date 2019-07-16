package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Admin;
import service.AdminService;

@FacesConverter(forClass=Admin.class)
public class AdminConverter implements Converter{

	private AdminService service = new AdminService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Admin obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Admin aux = (Admin)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Apresentacao;
import service.ApresentacaoService;

@FacesConverter("apresentacaoConverter")
public class ApresentacaoConverter implements Converter{

	private ApresentacaoService service = new ApresentacaoService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Apresentacao obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Apresentacao aux = (Apresentacao)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}

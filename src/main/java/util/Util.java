package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class Util {
	
	public static byte[] getBytesFromInputStream(InputStream is) {
	    ByteArrayOutputStream os = new ByteArrayOutputStream(); 
	    byte[] buffer = new byte[0xFFFF];
	    try {
			for (int len = is.read(buffer); len != -1; len = is.read(buffer)) { 
			    os.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	    return os.toByteArray();
	}
	
	public static StreamedContent getImage(byte[] image, String componentId) {
		
		FacesContext context = FacesContext.getCurrentInstance();

        if ((context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) || (image == null)) {
            return new DefaultStreamedContent();
        } else {
            /*String imageId = context.getExternalContext().getRequestParameterMap().get(componentId);*/
            return new DefaultStreamedContent(new ByteArrayInputStream(image));
        }
	}
	
	public static void filterAttributes(String div) {
		
		String str = div.substring(div.indexOf(">") + 1, div.length());
		str = str.substring(str.indexOf(">") + 1, str.length());
		str = str.substring(0, str.indexOf("<"));
		System.out.println(str);
		
	}
	
}

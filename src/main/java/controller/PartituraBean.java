package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import modelo.Instrumento;
import modelo.Integrante;
import modelo.Partitura;
import service.IntegranteService;
import service.PartituraService;
import util.FacesMensagens;
import util.Util;

@ManagedBean(name = "partitura")
@SessionScoped
public class PartituraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Partitura obj = new Partitura();
	private List<Partitura> partituras;
	private PartituraService service = new PartituraService();
	private Part part;
	private byte[] files;
	private List<Instrumento> instrumentos;

	public PartituraBean() {
		setPartituras(service.buscarTodos());
		setInstrumentos(Arrays.asList(Instrumento.values()));
	}

	public String salvar() {
		try {
			if (part != null) {
				try {
					files = Util.getBytesFromInputStream(part.getInputStream());
					if (files != null)
						obj.setPartitura(files);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			service.salvar(obj);
			setPartituras(service.buscarTodos());

			FacesMensagens.info("Registro salvo com sucesso.");
			limpa();
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
		return "";
	}

	public void excluir() {
		try {
			service.remover(obj.getCodigo());
			setPartituras(service.buscarTodos());

			FacesMensagens.info("Registro excluído com sucesso.");
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public String editar() {
		return "cadastro_partitura?faces-redirect=true";
	}

	public String novo() {
		limpa();
		return "cadastro_partitura?faces-redirect=true";
	}

	private void limpa() {
		obj = new Partitura();
	}

	public void preRender(String i) {
		System.out.println(i);
		IntegranteService ser = new IntegranteService();
		Integrante in = ser.buscarPorCodigo(Integer.valueOf(i));
		if (in.getPermissao().contains("MAESTRO")) {
			setPartituras(service.buscarTodos());
			return;
		}
		else {
			System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHH" + in.getNome());
			//setPartituras(service.buscarPorNome("Dowd’s Favourite"));
			setPartituras(service.buscarInstrumento(in.getInstrumento()));
			return;
		}
	}
	
	public void preRender(ComponentSystemEvent e) {
		setPartituras(service.buscarTodos());
	}

	public Partitura getObj() {
		return obj;
	}

	public void setObj(Partitura obj) {
		this.obj = obj;
	}

	public List<Partitura> getPartituras() {
		return partituras;
	}

	public void setPartituras(List<Partitura> partituras) {
		this.partituras = partituras;
	}

	public PartituraService getService() {
		return service;
	}

	public void setService(PartituraService service) {
		this.service = service;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public StreamedContent getFile(Integer i) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getRenderResponse()) {
			return new DefaultStreamedContent();
		} else {
			try {
				Partitura c = service.buscarPorCodigo(Integer.valueOf(i));
				if ((c == null) || (c.getPartitura() == null)) {
					return new DefaultStreamedContent();
				}
				return new DefaultStreamedContent(new ByteArrayInputStream(c.getPartitura()), "image/jpg",
						c.getNome() + ".pdf");
			} catch (Exception e) {
				return new DefaultStreamedContent();
			}

		}
	}

	public StreamedContent getFiles() {
		return Util.getImage(files, "imgShow");
	}

	public void setFiles(byte[] image) {
		this.files = image;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

}

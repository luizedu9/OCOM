package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import modelo.Apresentacao;

import service.ApresentacaoService;

import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    private ApresentacaoService service = new ApresentacaoService();
    private List<Apresentacao> apresentacoes;
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        
        apresentacoes = service.buscarTodos();
        for (Apresentacao apresentacao : apresentacoes) {
        	eventModel.addEvent(new DefaultScheduleEvent(apresentacao.getLocal(), apresentacao.getData(), apresentacao.getData()));
		}
         
        
    }   
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent() {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

}
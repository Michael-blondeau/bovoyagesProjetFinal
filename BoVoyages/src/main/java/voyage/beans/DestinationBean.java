package voyage.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



import org.primefaces.model.UploadedFile;

import voyage.entities.Destination;
import voyage.services.CatalogueService;


@Named("destination")
@ConversationScoped
public class DestinationBean implements Serializable {
	private static final long serialVersionUID = -8090576106232814027L;

	@Inject
	private CatalogueService service;
	
	@Inject
	Conversation conversation;

	private int id;
	private String continent;
	private String pays;
	private String region;
	private String description;
	private boolean promotion;
	private String image;
	private UploadedFile file;

	public DestinationBean() {
	}

	public DestinationBean(int id, String continent, String pays, String region, String description, boolean promotion, String image) {
		this.id = id;
		this.continent = continent;
		this.pays = pays;
		this.region = region;
		this.description = description;
		this.promotion = promotion;
		this.image = image;
	}
	
	public String add(){
		Destination destination = new Destination(continent, pays, region, description, image, promotion);
		if(id!=0){
			destination.setId(id);
		}
		
		if (this.file != null) {
			
			try {
				submit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			destination.setImage(image);
		}
		service.saveOrUpdate(destination);	
		stopConversation();
		return "allDestinations?faces-redirect=true";
  }
	
	
	public String modifier(int id){
		startConversation();
		Destination d = service.getDestinationById(id);
		this.id = d.getId();	
		this.continent = d.getContinent();
		this.pays = d.getPays();
		this.region = d.getRegion();
		this.description = d.getDescription();
		this.promotion = d.isPromotion();
		this.image = d.getImage();
		return "creationDestination?faces-redirect=true";
	}
  
	public void submit() throws IOException{ 
		
		if(file!=null){
		String folder = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("upload-folder");
		this.image = file.getFileName();
		
		Path path = FileSystems.getDefault().getPath(folder,image);
		try {
			InputStream in = file.getInputstream();
			Files.copy(in, path);
			
			in.close();
			setImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			setImage(null);
			e.printStackTrace();
		}
	}
		  }
	
	

	public void startConversation(){
		if (conversation.isTransient()) {
			conversation.begin();
		}	
	}
	
	public void stopConversation(){
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}
	
	public String getDestinationsByPays(String pays){
		startConversation();
		this.pays = pays;
		
		return "destinationsParPays?faces-redirect=true";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}

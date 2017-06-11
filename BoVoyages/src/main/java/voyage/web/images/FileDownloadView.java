package voyage.web.images;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;

 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
public class FileDownloadView {
     
	private StreamedContent file;
	
	 public FileDownloadView() {
	 InputStream stream = this.getClass().getResourceAsStream("yourfile.jpeg");
	 file = new DefaultStreamedContent(stream, "test/jpeg",
	"downloaded_file.jpeg");
	}
	public StreamedContent getFile() {
	return this.file;
	}

}
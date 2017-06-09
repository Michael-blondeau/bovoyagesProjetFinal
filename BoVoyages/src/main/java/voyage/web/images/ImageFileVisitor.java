package voyage.web.images;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class ImageFileVisitor extends SimpleFileVisitor<Path> {
	private List<Path> images = new ArrayList<>();
	private static PathMatcher pathMatcher;
	
	public ImageFileVisitor(String folder) {
		pathMatcher = FileSystems.getDefault().getPathMatcher("glob:"+folder+"*.{jpg,png,gif,jpeg}");
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(pathMatcher.matches(file)){
			images.add(file.getFileName());
		}
		return FileVisitResult.CONTINUE;
	}
	
	public List<Path> getImages(){
		return images;
	}
}

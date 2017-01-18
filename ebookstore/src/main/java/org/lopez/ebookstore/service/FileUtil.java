package org.lopez.ebookstore.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@PropertySource("classpath:application.properties")
public class FileUtil {

	@Value("${image.directory}")
	private String imageDirectory;

	@Value("${image.suffix}")
	private String imageSuffix;

	public void saveBookImage(MultipartFile bookImage, int id, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory + imageDirectory + id + imageSuffix);

		try {
			bookImage.transferTo(new File(path.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Book image saving failed", e);
		}

	}
	
	public void deleteBookImage(int id, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory + imageDirectory + id + imageSuffix);
		
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

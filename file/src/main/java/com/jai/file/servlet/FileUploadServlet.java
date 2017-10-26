package com.jai.file.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/upload" }, loadOnStartup = 1)
@MultipartConfig()
public class FileUploadServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 5222389847735084483L;

	private final static Logger LOGGER = Logger.getLogger(FileUploadServlet.class.getCanonicalName());

	// FileDao dao = new FileDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost called ..");

		// if (ServletFileUpload.isMultipartContent(request)) {
		// System.out.println("isMultipartContent true ..");
		// }
		// else {
		// System.out.println("isMultipartContent false ..");
		// }

		// Retrieves <input type="file" name="file">
		Part filePart = request.getPart("file");
		System.out.println("filePart :: " + filePart);
		// MSIE fix
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream inputStream = filePart.getInputStream();
		System.out.println("File size :: " + inputStream.available());

		File destination = new File(fileName);
		FileUtils.copyInputStreamToFile(inputStream, destination);
		System.out.println("file copied..");

		// dao.directInsert(fileName, inputStream);
		// System.out.println("inserted..");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet called....");
	}

}
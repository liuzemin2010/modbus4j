package com.net4iot.oss.web.servlet;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;

import com.net4iot.oss.infra.config.Config;

public class ImageShowServlet extends HttpServlet {

	private static final long serialVersionUID = 6243416010287674596L;

	public ImageShowServlet() {
		super();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imageName = request.getParameter("name");
		File file = new File(Config.UPLOAD_SAVEPATH + imageName);

		Image src = ImageIO.read(file);
		BufferedImage image = new BufferedImage(src.getWidth(null),
				src.getHeight(null), BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(src, 0, 0, src.getWidth(null),
				src.getHeight(null), null);
		ChartUtilities.writeBufferedImageAsJPEG(response.getOutputStream(),
				image);
		response.flushBuffer();
	}

}

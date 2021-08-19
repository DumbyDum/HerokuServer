package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/rand")
	public String rand(){
	Random r = new Random();
	return String.valueOf(r.nextGaussian()); }


	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = "image/jpg")
	public @ResponseBody
	byte[] getFile()  {
		try {
			// Retrieve image from the classpath.
			InputStream is = this.getClass().getResourceAsStream("/image/kitb.jpg");

			// Prepare buffered image.
			BufferedImage img = ImageIO.read(is);

			// Create a byte array output stream.
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			// Write to output stream
			ImageIO.write(img, "jpg", bao);

			return bao.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
		int a = 1;
		@RequestMapping("/elapsed_time")
		public String elapsedTime(){
			long current = System.currentTimeMillis();
			Random r = new Random();
			double x = r.nextGaussian();

			while (x < a){
				x = r.nextGaussian();
			}
			a++;
			return String.valueOf(System.currentTimeMillis() - current);
		}
}

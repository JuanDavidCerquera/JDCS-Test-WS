package com.example.amonic;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmonicApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AmonicApplication.class, args);

	}
	
    @Override
    public void run(ApplicationArguments args) throws Exception {

    	Thread.sleep(5000);

        String swaggerUrl = "http://localhost:9000/Session3/swagger-ui/index.html";
        openBrowser(swaggerUrl);
    }


    public static void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try {
            if (os.contains("win")) {
                // Windows
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                // macOS
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux/Unix
                String[] browsers = {"google-chrome", "firefox", "mozilla", "xdg-open"};
                StringBuilder cmd = new StringBuilder();
                for (int i = 0; i < browsers.length; i++) {
                    if (i == 0) {
                        cmd.append(String.format("%s \"%s\"", browsers[i], url));
                    } else {
                        cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
                    }
                }
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            } else {
                throw new UnsupportedOperationException("Unsupported operating system.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

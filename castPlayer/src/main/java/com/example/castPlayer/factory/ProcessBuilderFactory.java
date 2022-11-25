package com.example.castPlayer.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessBuilderFactory {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    ProcessBuilder processBuilder;

    public ProcessBuilderFactory build() {
        this.processBuilder = new ProcessBuilder();
        return this;
    }

    public ProcessBuilderFactory linuxCommand(String... params) {
        String format = new String(new char[params.length]).replace("\0", "\"%s\",");
        format = format.substring(0, format.length() - 1);
        //this.processBuilder.command("zsh", String.format(format, params));
        this.processBuilder.command("bash", "/usr/bin/open", "-a", "\"/Applications/Google Chrome.app\"", "'https://www.youtube.com/watch?v=dQw4w9WgXcQ'");
        //this.processBuilder.command("echo", "$PATH");
        return this;
    }

    public void run() throws IOException, InterruptedException {

        // Windows
        //processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");

        // Unix
        //
        //this.processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo());


        Process process = this.processBuilder.start();

        InputStreamReader isr = new InputStreamReader(process.getInputStream());
        BufferedReader rdr = new BufferedReader(isr);
        String line;
        while((line = rdr.readLine()) != null) {
            System.out.println(line);
        }

        isr = new InputStreamReader(process.getErrorStream());
        rdr = new BufferedReader(isr);
        while((line = rdr.readLine()) != null) {
            System.out.println(line);
        }
        isr.close();
        rdr.close();

        int exitCode = process.waitFor();
        //logger.info(String.valueOf(process.getOutputStream()));



        logger.info("Exited with code {}", exitCode);

    }

}

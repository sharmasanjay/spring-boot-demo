package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.ReqResModel;

@Service
public class NumberGenService {
	
	@Value("${my.filelocation}")
	private String fileLocation;
	
	public ReqResModel generateUUID(ReqResModel reqres ) {
		reqres.setTask(UUID.randomUUID().randomUUID().toString());
		return reqres;
	}
	
	public void generateFile(ReqResModel reqres) {

		StringBuilder sb = new StringBuilder();
		for (int i = reqres.getGoal(); i >= 0; i -= reqres.getStep()) {
			sb.append(String.valueOf(i));
			if (i != 0) {
				sb.append(",");
			}
		}
		String fileName = fileLocation+"\\"+reqres.getTask() + "_output.txt";
		populateMockData(reqres);
		try {
			Files.write(Paths.get(fileName), sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ReqResModel> storeList=new  ArrayList<>();
	private void populateMockData(ReqResModel reqres) {
		storeList.add(reqres);
	}
	
	public String readFile(String task) {
		return listFilesForFolder(new File(fileLocation),task);
	}
	
	public String listFilesForFolder(final File folder,String task) {
		String responseContent=null;
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry,task);
	        } else {
	        	String completeFileName=task+"_output.txt";
	            if(fileEntry.getName().equalsIgnoreCase(completeFileName)) {
	            	System.out.println(fileEntry.getName());
	            	responseContent=readFileForResponse(fileEntry.getName());
	            }
	        }
	    }
	    return responseContent;
	}

	public String readFileForResponse(String name) {
		String st = null;
		File file = new File(fileLocation+"\\" + name);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			st = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}

}

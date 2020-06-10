package controller;

import java.io.IOException;

public interface IManipulaArquivos {
	
	
	public String readFile(String path, String name) throws IOException; 
	
	public void createFile(String path, String name, String text) throws IOException;
	
	
	
}

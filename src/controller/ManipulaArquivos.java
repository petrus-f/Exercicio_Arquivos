package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulaArquivos implements IManipulaArquivos{

	@Override
	public String readFile(String path, String name) throws IOException {
		File file = new File(path, name+".txt");
		String texto = "";
		
		if(file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				texto += linha + "\r\n";
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
		return texto;
	}

	@Override
	public void createFile(String path, String name, String text) throws IOException {
		text = prepareText(text);
		File dir = new File(path);
		File file = new File(path, name+".csv");
		if(dir.exists() && dir.isDirectory()) {
			boolean exist = false;
			if(file.exists()) {
				exist = true;
			}
			FileWriter fileWrite = new FileWriter(file, exist);
			PrintWriter print = new PrintWriter(fileWrite);
			print.write(text);
			print.flush();
			print.close();
			fileWrite.close();
		}else {
			throw new IOException("Diretório Inválido");
		}
	}

	private String prepareText(String text) {
		
		String[] textSeparate = text.split(" "); 
		text = "";
		for(int i = 0; i < textSeparate.length; i++) {
			if(i > 0) {
				text += textSeparate[i] + ";";
			}else {
				text += textSeparate[i] + " ";
			}
		}
		System.out.println(text);
		return text;
	}
	
	
}

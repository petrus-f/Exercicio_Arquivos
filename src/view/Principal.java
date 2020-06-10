package view;

import java.io.IOException;

import controller.ManipulaArquivos;

public class Principal {

	public static void main(String[] args) {
		
		ManipulaArquivos arq = new ManipulaArquivos();
		String path = "C:\\Users\\Petrus\\Desktop\\ADS\\SO1\\Exercicio_Arquivos_Java";
		String name = "relatorio";
		
		try {
			String texto = arq.readFile(path, name);
			System.out.println(texto);
			arq.createFile(path, name, texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

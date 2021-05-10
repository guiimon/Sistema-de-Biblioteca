package biblioteca;

import java.io.File;

public class CriaDiretorios {
	public CriaDiretorios() {
		File dir = new File("C:/Biblioteca");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("C:/Biblioteca/autor");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("C:/Biblioteca/livro");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("C:/Biblioteca/exemplar");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("C:/Biblioteca/editora");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("C:/Biblioteca/funcionario");
		if(!dir.exists()) {
			dir.mkdir();
		}
	}
}

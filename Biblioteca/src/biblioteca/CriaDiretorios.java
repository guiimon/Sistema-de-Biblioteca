package biblioteca;

import java.io.File;

public class CriaDiretorios {
	public CriaDiretorios() {
		File dir = new File("c:\\biblioteca");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("c:\\biblioteca\\autor");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("c:\\biblioteca\\livros");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("c:\\biblioteca\\exemplar");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("c:\\biblioteca\\editora");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		dir = new File("c:\\biblioteca\\emprestimos");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		
	}
}

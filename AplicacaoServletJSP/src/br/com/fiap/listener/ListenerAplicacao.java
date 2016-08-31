package br.com.fiap.listener;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public final class ListenerAplicacao implements ServletContextListener, HttpSessionAttributeListener, 
										ServletRequestAttributeListener, HttpSessionListener {

	private static final String FILE_PATH = "C:\\Users\\rm30366\\repositorios\\fiap\\java_web\\AplicacaoServletJSP\\log.txt";
	
	public ListenerAplicacao() {
	}


	public void sessionCreated(HttpSessionEvent event)  { 
		log("Sessão criada");
	}

	public void sessionDestroyed(HttpSessionEvent event)  { 
		log("Sessão destruida");
	}
		

	public void attributeAdded(ServletRequestAttributeEvent event) {
		log("Atribuito adicionado");
	}

	public void attributeReplaced(ServletRequestAttributeEvent event)  { 
		log("Atribuito substituido");
	}
	
	public void attributeRemoved(ServletRequestAttributeEvent event)  { 
		log("Atribuito removido");
	}
	

	public void contextInitialized(ServletContextEvent event)  { 
		log("Contexto inicializado");
	}

	public void contextDestroyed(ServletContextEvent event)  { 
		log("Contexto destruído");
	}
	

	public void attributeAdded(HttpSessionBindingEvent event)  { 
		log("Atribuito adicionado na sessao");
	}

	public void attributeRemoved(HttpSessionBindingEvent event)  { 
		log("Atribuito removido na sessao");
	}

	public void attributeReplaced(HttpSessionBindingEvent event)  { 
		log("Atribuito substituido na sessao");
	}
	
	private void log(String text) {
		
		try(FileWriter writer = new FileWriter(FILE_PATH, true)) {
			
			final String dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format(new Date());			
			text = "[" + dataHora + "] " + text + "\r\n";
			
			writer.write(text);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

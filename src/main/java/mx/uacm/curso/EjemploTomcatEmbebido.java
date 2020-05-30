/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.JarScanFilter;
import org.apache.tomcat.JarScanType;

/**
        
 *
 * @author iarobles
 */
public class EjemploTomcatEmbebido {

    public static void main(String[] args) throws LifecycleException {

        Tomcat t = new Tomcat();
        File basedir = new File("target/servidoremb");
        File webappsdir = new File(basedir, "webapps");
        webappsdir.mkdirs();
        //configurar el servidor su directorio base
        t.setBaseDir(basedir.getAbsolutePath());
        t.setPort(8080);
        //configuramos la ruta del archivo war que se va usar al arrancar este servidor
        String archivowar = new File("target/curso-mapeo-objeto-1.0-SNAPSHOT").getAbsolutePath();
        System.out.println(archivowar);
        
        Context contexto = t.addWebapp(t.getHost(), "/curso", archivowar);
        //opcional: configurar el jar scan filter de tomcat para ignorar JAXB
        JarScanFilter jsf = new JarScanFilter() {
            @Override
            public boolean check(JarScanType jarScanType, String jarName) {
                if (jarName.startsWith("jaxb")) {
                    return false;
                }
                return true;
            }
        };
        //habilitamos el jar scanner
        contexto.getJarScanner().setJarScanFilter(jsf); //contexto.setParentClassLoader(getClass().getClassLoader());
        //habilitamos el funcionamiento del puerto
        t.enableNaming();
        t.getConnector();
        //arrancamos el servidor
        t.start();
        t.getServer().await();

    }

}

package br.com.rlmoura81.sistema.utilidade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UtilidadeLog {
    
    private String diretorio;
    private String arquivo;
    private String linha;
    
    private void diretorio(){
        diretorio = System.getProperty("user.dir");
    }
    
    public void arquivo(){
        File arquivo = new File(this.arquivo);
        if(arquivo.exists() == false){
            try {
                OutputStream os = new FileOutputStream(this.arquivo);               
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo:\n" + 
                        ex.getMessage());
            }
        }
        escreveArquivo(this.linha); 
    }
    
    private void escreveArquivo(String linhalog){
        try {
            FileWriter fwarquivo = new FileWriter(this.arquivo, true);
            PrintWriter pwarquivo = new PrintWriter(fwarquivo);
            pwarquivo.println(linhalog);
            pwarquivo.flush();
            pwarquivo.close();
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao escrever o arquivo:\n" + 
                        ex.getMessage());
        }
    }
    
    private void lerArquivo(){
        File arquivo = new File(this.arquivo);
        if(arquivo.exists() == true){
            try {
                FileReader lerarquivo = new FileReader(this.arquivo);
                BufferedReader brarquivo = new BufferedReader(lerarquivo);
                while((linha = brarquivo.readLine()) != null){
                }
                brarquivo.close();               
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo:\n" + 
                        ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(UtilidadeLog.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

    public void log(String classe, String comando, String objcomando){
        arquivo = "logphsistema.txt";
        linha = Calendar.getInstance().getTime() + "--" + classe + "--" + comando + ":\n" +
                    "--" + objcomando;
        diretorio();
        arquivo();
    }
}

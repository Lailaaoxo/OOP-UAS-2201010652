/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dta_berkelompok;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Laila Nur Azizah (2201010652)
 */
public class operasi {
    public double mean(int [] data){
        double jmlh = 0;
        for (int i = 0; i < data.length; i++) {
            jmlh += data[i];
        }
        return jmlh / data.length;
    }
    public double median(int [] data){
        Arrays.sort(data);
           int n = data.length;
            double h=0;
            if (n % 2 == 0) {
                h= data[(n / 2) -1] + data[n / 2] ;
                return h/ 2;
            } else {
                return data[(n / 2)-1];
            } 
    }
    public String modus(int [] data){
        int mod=0;
        int max=0;
        for (int i = 0; i < data.length; i++) {
            int count=0;
           for (int x = 0; x < data.length; x++) {
                if (data[x]==data[i]) {
                    count++;
                }
            }
            if (count>max) {
                max=count;
                mod=data[i];
            }
        }
        if (max<=1) {
            return "Tidak Ada";
        } else {
            String hasil=Integer.toString(mod);
           return hasil;  
        }
    }
    public double kelas (int [] data){
        int n=data.length;
        double kategori = 1+(3.322*Math.log10(n));
        return Math.round(kategori);
    }
    public double interval (int [] data){
        Arrays.sort(data);
        int n=data.length;
        double jangkauan= data[n-1] - data[0];
        return Math.round(jangkauan/kelas(data));
    }
    public void hapus(int sample, int [] data){
       String inp = JOptionPane.showInputDialog("Masukkan Data Baru (satu data saja)"); 
        if (inp!=null) {
            int tidak=0;
            int konfirm=JOptionPane.showOptionDialog(null,"Ganti Data menjadi "+inp+" ?", "Merubah Seluruh Data Yang Dituju", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if (konfirm==JOptionPane.YES_OPTION) {
                for (int i = 0; i < data.length; i++) {
                     if (data[i]==sample) {
                         tidak+=1;
                         int conv=Integer.parseInt(inp);
                         data[i]=conv;         
                     }
                 }
                
             } 
            if (tidak==0) {
                String[] options = {"OK"};
                Object[] optionsArray = options;
                int konf=JOptionPane.showOptionDialog(null, "Data Tidak Ada Pada Daftar", "Data Tidak Ada", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsArray, null);            
            }else{
            String[] options = {"OK"};
            Object[] optionsArray = options;
            int konf=JOptionPane.showOptionDialog(null, "Data Berhasil Diubah, Silahkan Klik Proses", "Proses Berhasil", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsArray, null);                 
            }
        }
    }
    public void hapus(int sample,int [] data,int jmlh){
        int tidak=0;
        int counts=0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]==sample) {
                counts++;
                tidak+=1;
            }
        }           
        if (jmlh<=counts && tidak !=0) {
         int counter=0;
         for (int i = 0; i < data.length; i++) {
            if (data[i]==sample) {
                counter++;
                if (counter<=jmlh) {
                String inp = JOptionPane.showInputDialog("Masukkan Data Baru (satu data saja)"); 
                if (inp!=null) {
                    int konf=JOptionPane.showOptionDialog(null,"Ganti Data menjadi "+inp+" ?", "Total Frekuensi Data Dituju: "+counts, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                    if (konf==JOptionPane.YES_OPTION) {
                        int conv=Integer.parseInt(inp);
                        data[i]=conv;
                        String[] options = {"OK"};
                        Object[] optionsArray = options;
                        int konf1=JOptionPane.showOptionDialog(null, "Data Berhasil Diubah, Silahkan Klik Proses", "Proses Berhasil", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsArray, null);                        
                    }
                }  
                }
            }
                       
        } 
 
        }else{
            String[] options = {"OK"};
            Object[] optionsArray = options;
            int konf=JOptionPane.showOptionDialog(null, "Frekuensi Data Kurang atau Data Tidak Ada", "Kesalahan Input Frekuensi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsArray, null);
        }
    }
    public double rerata(int [] data){
        double avg=mean(data);
        double cout=0;
        double hasil=0;
        for (int i = 0; i < data.length; i++) {
            cout+=Math.abs(data[i]-avg);
        }
        hasil=cout/data.length;
        return hasil;
    }
    public double varians(int [] data){
        double avg=mean(data);
        double cout=0;
        double hasil=0;
        for (int i = 0; i < data.length; i++) {
            cout+=Math.pow((Math.abs(data[i]-avg)), 2);
        }
        String[] options = {"Sample","Populasi"};
        Object[] optionsArray = options;
        int konf=JOptionPane.showOptionDialog(null, "Apakah Data Berupa Populasi atau Sample?", "Konfirmasi Jenis Data", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsArray, null);
        if (konf==JOptionPane.YES_OPTION) {
            int tempt=data.length-1;
            hasil=cout/tempt;
        }
        if (konf==JOptionPane.NO_OPTION) {
            hasil=cout/data.length;
        }
        return hasil;
    }
     public double baku(int [] data, double varians){
        double hasil= Math.pow(varians, 0.5);
        return hasil;   
    }
}

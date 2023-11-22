/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan07_Interface;

/**
 *
 * @author mmccom
 */
public class Samsung implements Phone {
    
    private int volume;
    private boolean isPowerOn;
    
    public Samsung(){
        this.volume = 30;
    }

    @Override
    public void powerOn() {
       isPowerOn = true;
        System.out.println("Handphone Menyala........");
        System.out.println("Selamat Datang di Samsung PHONE");
        System.out.println("Android Version 12, One UI 4.0"); 
    }

    @Override
    public void powerOf() {
         isPowerOn = false;
       System.out.println("Handphone sedang dimatikan");
    }

    @Override
    public void volumeUp() {
        if(isPowerOn){
            if(this.volume == MAX_VOLUME){
                System.out.println("Volume FULL");
                System.out.println("Sudah " + this.getVolume() + "%");   
            }else{
                this.volume += 10;
                System.out.println("Volume Sekarang " + this.getVolume());
            }
        }else{
            System.out.println("Tolong nyalakan HPnya dulu Boss");
        }
    }

    @Override
    public void volumeDown() {
         if(isPowerOn){
            if(this.volume == MIN_VOLUME){
                System.out.println("Volume sudah paling rendah");
                System.out.println("Sudah " + this.getVolume() + "%");   
            }else{
                this.volume -= 10;
                System.out.println("Volume Sekarang " + this.getVolume());
            }
        }else{
            System.out.println("Nyalain dulu HPnya.....");
        }
    }
    
     public int getVolume(){
        return this.volume;
    }
     
    @Override
     public void Screenshot(){
         if(isPowerOn){
                 System.out.println("Mengambil Tangkapan Layar......");
             }else{
                 System.out.println("Tangkapan Layar Tidak Berhasil");
             }
         }

    @Override
    public void Recovery() {
        if(isPowerOn){
                 System.out.println("Memasuki Mode Pemulihan");
             }else{
                 System.out.println("Gagal Memasuki Mode Pemulihan");
     }
    }
}

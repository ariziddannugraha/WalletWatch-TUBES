/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walletwatch;

/**
 *
 * @author arizi
 */
public class Income {
    private String nama;
    private String nominal;
    private String deskripsi;

    public Income(String nama, String nominal, String deskripsi) {
        this.nama = nama;
        this.nominal = nominal;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public void info(){
        System.out.println(nama);
        System.out.println(nominal);
        System.out.println(deskripsi);
    }
}

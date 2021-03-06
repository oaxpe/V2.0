/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Eskaera {
    private static String eskZenb="Eskaera#0999"; // eskaera zenbakia ezin da aldatu. Eskaera berri bakoitzari, aurrekoa +1 egiten zaio
    private String hornitzailea;
    private String data;
    private int kopurua;
    
    
    public Eskaera () {
        setHornitzailea();
        setData();
        setKopurua();
        setEskZenb();
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Eskaera zenbakia: "+this.eskZenb);
        System.out.println("Hornitzailea: "+this.hornitzailea);
        System.out.println("Data: "+this.data);
        System.out.println("Kopurua: "+this.kopurua);
    }

    public void printEskaera() {
        System.out.println("\t"+this.eskZenb+"\t\t"+this.hornitzailea+"\t"+this.kopurua+"\t"+this.data);
    }
    
    
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getHornitzailea() {
        return hornitzailea;
    }

    public void setHornitzailea() {
        try {
            System.out.print("Sartu Hornitzailea: ");
            this.hornitzailea = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getData() {
        return data;
    }

    public void setData() {
        try {
            Calendar c1 = new GregorianCalendar();
            String egun = Integer.toString(c1.get(Calendar.DATE)); // eguna gorde
            String hilabete = Integer.toString(c1.get(Calendar.MONTH)+1); // hilabetea gorde
            String urte = Integer.toString(c1.get(Calendar.YEAR)); // urtea gorde

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
            Date fetx = df.parse(egun+"/"+hilabete+"/"+urte); // data hori Date formatura parseatu
            
            this.data = new SimpleDateFormat("dd/MM/yyyy").format(fetx.getTime()); // formatu zehatz baten jarri
        }
        catch (ParseException e) {
            System.out.println(Metodoak.printGorriz("Ez da kapaza sartutako datuak parseatzeko."));
        }
    }

    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua() {
        try {
            System.out.print("Sartu kopurua: ");
            this.kopurua = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setKopurua();
        }
    }

    public String getEskZenb() {
        return eskZenb;
    }

    public void setEskZenb() {
        // Eskaera zenbakia automatikoki hartu
        String zenb = String.valueOf(Integer.parseInt(this.eskZenb.substring(8, this.eskZenb.length()))+1);
        this.eskZenb = this.eskZenb.substring(0, 8);
        this.eskZenb += zenb;
    }
}

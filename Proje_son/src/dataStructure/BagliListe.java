package dataStructure;

import java.util.ArrayList;
import java.util.Comparator;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import personel.Personel;

public class BagliListe {
		public Personel bas;
		public Personel son;

		
		public BagliListe(){
			bas=null;
			son=null;
		}
		
		//listeden düğüm silme
		public void Sil(Personel silPersonel) {
			if (bas == null) {
				System.out.println("kardes zaten bos bu");
			}else {
				Personel temp = bas;
				
				 while(temp!= null) {
	
					 if(temp.getMaas() == silPersonel.getMaas()) {
						 if(bas==son) {
							 bas=null;
							 son=null;
						 }
						 
						 if(silPersonel.sonraki == null && bas!=son) {
							 son=temp.onceki;
							 temp.onceki.sonraki = null;
						 }
						 else if(silPersonel.sonraki!=null && silPersonel!=bas) {
							 temp.onceki.sonraki=temp.sonraki;
							 temp.sonraki.onceki=temp.onceki;
						 }else {
							 bas = temp.sonraki;
						 }
				 }
					 temp=temp.sonraki;
				 
				 }
			}
			
			
		}
		
		//listeye düğüm ekleme
		public void Ekle(Personel yeni) {
			
			if(bas==null) {//liste boşsa
				bas=yeni;
				son=yeni;
				System.out.println("başa ekledim");
				return;
			}
			//liste boş değil
			
			son.sonraki=yeni;
			System.out.println("baştan sonraya ekledim");
			Personel temp=son;
			//son.onceki=son;
			son=yeni;
			son.onceki=temp;
			
			//personel numara artırma:
			yeni.setPersonelNo(yeni.onceki.getPersonelNo()+1);
			 
		}
		
		
		//listedeki düğümü güncelleme
		public void guncelleme(Personel guncellePersonel,long maas,String isim,String soyisim,String pozisyon,int yas) {
			Personel temp = bas;
			while(temp !=null) {
				if(guncellePersonel.getMaas() == temp.getMaas()) {
					temp.setMaas(maas);
					temp.setIsim(isim);
					temp.setSoyisim(soyisim);
					temp.setPozisyon(pozisyon);
					temp.setYas(yas);
				}
				temp=temp.sonraki;
			}
		}
		
		
		public ObservableList<Personel> toList() {
		    ObservableList<Personel> list = FXCollections.observableArrayList();
		    Personel temp = bas; // Bağlı listenin başı
		    while (temp != null) {
		        list.add(temp);
		        temp = temp.sonraki;
		    }
		    return list;
		}

		//listeyi yazdır
		public void listeYazdir() {
			
			Personel temp =bas;
			while(temp!=null) {
				
				System.out.println(temp.getMaas()+" "+temp.getIsim()+" "+temp.getSoyisim()+" "+temp.getPozisyon()+" "+temp.getYas());
				temp = temp.sonraki;
				
			}
			System.out.println("--------------------");
		}
		 

}
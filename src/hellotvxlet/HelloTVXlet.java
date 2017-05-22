package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;

//Paar opmerkingen:
import org.havi.ui.event.HActionListener;
//Nieuwe projecten kopieren van voorbeeld, zelf nieuwe aanmaken gaat niet werken
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
//Vergeet niet 'set as main project' te doen, door rechtermousklik op project

//implement HActionListeren is nodig, twee keer moet je import zetten als die een error geeft
public class HelloTVXlet implements Xlet, HActionListener, ResourceClient, HBackgroundImageListener {
    
    //Waarde scene globaal gemaakt zodat de actions eraan kunnen
    HScene scene=HSceneFactory.getInstance().getDefaultHScene();
    
    public HelloTVXlet() {
       
    }

    public void initXlet(XletContext context) {
        
      Time klok= new Time();
      scene.add(klok);
      
      //Tekst op scherm zetten
      HStaticText tekst1=new HStaticText("Tv gids",10,10,100,50); //x,y,w,h
      tekst1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      tekst1.setBackground(Color.BLACK);
      scene.add(tekst1);
      
      //Kanalen
      HStaticText infoblock=new HStaticText("Kanalen",0,380,120,50); //x,y,w,h
      infoblock.setBackgroundMode(HVisible.BACKGROUND_FILL);
      infoblock.setBackground(Color.BLACK);
      scene.add(infoblock);
      
      //Tijdbar
      HStaticText tijdbar=new HStaticText("",120,380,600,50);
      tijdbar.setBackgroundMode(HVisible.BACKGROUND_FILL);
      tijdbar.setBackground(Color.BLACK);
      scene.add(tijdbar);
      
      //Arrays
      ArrayList titles=new ArrayList();ArrayList vrt=new ArrayList();ArrayList vtm=new ArrayList();ArrayList een=new ArrayList();ArrayList row=new ArrayList();
      
      //Vullen van de arrays met programma's/titles
      titles.add("EEN");titles.add("CANVAS");titles.add("VTM");     
      vrt.add("Terzake");vrt.add("De afspraak");vrt.add("Het weer");vrt.add("Extra Time");
      vtm.add("Familie");vtm.add("De buurtpolitie");vtm.add("VTM Nieuws");vtm.add("Het Weer");
      een.add("Thuis");een.add("De zevende dag");een.add("Het Journaal");een.add("Het Weer");
      
      //Print titles
      for(int i=0; i < titles.size(); i++)
      {
          HStaticText title=new HStaticText((String)titles.get(i),0,430+(50*i),120,50);
          title.setBackgroundMode(HVisible.BACKGROUND_FILL);
          title.setBackground(Color.BLACK);
          scene.add(title);
      }
      
      //Print de ��n array
      for(int i = 0; i < een.size(); i++) {
          HTextButton list1=new HTextButton((String)een.get(i),120+(150*i),430,150,50);//x,y,w,h
          list1.setActionCommand((String)een.get(i));
          list1.addHActionListener(this);
          scene.add(list1);
          row.add(list1);
      }
      
      //Print de vrt array
      for(int i = 0; i < vrt.size(); i++) {
          HTextButton list2=new HTextButton((String)vrt.get(i),120+(150*i),480,150,50);//x,y,w,h
          list2.setActionCommand((String)vrt.get(i));
          list2.addHActionListener(this);
          scene.add(list2);
          row.add(list2);
      }
      
      //Print de vtm array
      for(int i = 0; i < vtm.size(); i++) {
          HTextButton list3=new HTextButton((String)vtm.get(i),120+(150*i),530,150,50);//x,y,w,h
          list3.setActionCommand((String)vtm.get(i));
          list3.addHActionListener(this);
          scene.add(list3);
          row.add(list3);
      }
      
      //Controls voor menu
      for(int i = 0; i < row.size(); i++) {
          HTextButton huidige=(HTextButton)row.get(i);
          HTextButton vorige=null, volgende=null, boven=null, onder=null;
          if(i>0) { vorige = (HTextButton)row.get(i-1); }
          if(i != row.size()-1) { volgende = (HTextButton)row.get(i+1); }
          if(i< (vrt.size()+vtm.size()) ) { onder = (HTextButton)row.get(i+4); }
          if(i>een.size()-1){ boven = (HTextButton)row.get(i-4); }
          huidige.setFocusTraversal(boven, onder , vorige, volgende);
      }
     
      ((HTextButton)row.get(0)).requestFocus();
      scene.validate();
      scene.setVisible(true);
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    //Nodig voor actions
    public void actionPerformed(ActionEvent arg0) {
        
        //Print de waarde van de knop af in de output
        System.out.println(arg0.getActionCommand());
                
        if (arg0.getActionCommand().equals("Het Journaal"))
        {
            HStaticText tekst2=new HStaticText("Het Journaal",10,70,700,200); //x,y,w,h
            tekst2.setBackgroundMode(HVisible.BACKGROUND_FILL);
            tekst2.setBackground(Color.ORANGE);
            scene.add(tekst2);
            scene.popToFront(tekst2);
            scene.repaint();
        }
        else {}
            
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

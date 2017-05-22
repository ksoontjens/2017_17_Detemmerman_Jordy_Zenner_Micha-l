package hellotvxlet;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class Time extends HComponent {
    
    HScene sceneTime=HSceneFactory.getInstance().getDefaultHScene();
    
    public Time()
    {          
        Timer t = new Timer();
        t.schedule(new TimerTask() {            
            public void run() {
                
                DateFormat TimeFormat = new SimpleDateFormat("HH:mm d/M");
                
                Date date = new Date();
                
                HStaticText timeText = new HStaticText(TimeFormat.format(date),120,10,150,50);
                
                timeText.setBackgroundMode(HVisible.BACKGROUND_FILL);
                timeText.setBackground(Color.BLACK);
                
                sceneTime.add(timeText);
                sceneTime.repaint();
                sceneTime.popToFront(timeText);
            }
        }, 0, 60000);
    }
}



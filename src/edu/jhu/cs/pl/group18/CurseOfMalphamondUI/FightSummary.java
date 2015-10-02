package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.imageio.plugins.gif.GIFImageMetadata;

/**
 * 
 * This class load the fight animation.
 * @author Xuchen
 *
 */
  
public class FightSummary {
	
	/** 
	 *  Store information on each gif page
	 */  
	public static class GifBean {  
		public BufferedImage image;  
		public int x;  
		public int y;  
		public int width;  
		public int height;  
		public int disposalMethod;  
	}

    private static final long serialVersionUID = 1L;  
    private static GifBean[] gifBeans;  
    private static Map<Integer, Integer[]> gifBeanMap = new HashMap<Integer, Integer[]>();  
    private static int index = 0;  
    
    /**
	 * This function is a static function that can draw the gif during fight.
	 * 
	 * @param g
	 *            Graphics object provides by Java AWT
	 */
	public static void paintSummary( Graphics g) {

		ImageReader reader = null;
	    try {
	        ImageInputStream imageIn = ImageIO.createImageInputStream(new File("image" + File.separator + "fight1.gif"));  
	        Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("gif");
	        if (iter.hasNext()) {
	        	reader = iter.next();  
	        }
	        reader.setInput(imageIn, false);  
	        gifBeanMap.clear();  
	        gifBeans = new GifBean[reader.getNumImages(true)];  
	        GIFImageMetadata meta = null;
	        for (int i = 0; i < gifBeans.length; i++) {
	        	meta = (GIFImageMetadata) reader.getImageMetadata(i);  
	        	gifBeans[i] = new GifBean();
	        	gifBeans[i].image = reader.read(i);  
	        	gifBeans[i].x = meta.imageLeftPosition;
	        	gifBeans[i].y = meta.imageTopPosition;  
	        	gifBeans[i].width = meta.imageWidth;
	        	gifBeans[i].height = meta.imageHeight;  
	        	gifBeans[i].disposalMethod = meta.disposalMethod;  
	        }  
	        for (int i = 1; i < gifBeans.length; i++) {  
	        	if (gifBeans[i].disposalMethod == 2) {  
	        		gifBeanMap.put(new Integer(i), new Integer[] { i });  
	        		continue;  
	        	}
	        	int firstIndex = index;
	        	int tempIndex = index;  
	        	while (tempIndex > 1) {  
	        		if (tempIndex - 1 > 0 && gifBeans[tempIndex - 1].disposalMethod == 2) {  
	        			firstIndex = index;
	        			break;
	        		}  
	        		tempIndex--;
	        		firstIndex = tempIndex;
	        	}
	        	
	        	List<Integer> list = new ArrayList<Integer>();  
	        	for (int j = firstIndex; j <= i; j++) {  
	        		list.add(j);  
	        	}  
	        	gifBeanMap.put(new Integer(i), list.toArray(new Integer[] {}));  
	        }  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
		g.drawImage(gifBeans[0].image, gifBeans[0].x + 100, gifBeans[0].y + 100, null);  
		
		if (index > 0) {  
	        Integer[] array = gifBeanMap.get(index);  
	        for (Integer i : array) {  
	        	g.drawImage(gifBeans[i].image, gifBeans[i].x + 100, gifBeans[i].y + 100, null);  
	        }  
	    }
		index++;
		if (index >= gifBeans.length) {  
			index = 0;  
		}
	}
}

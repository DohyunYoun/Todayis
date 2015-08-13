package kr.ac.todayis.data;

/**
 * Created by Min on 2015-08-13.
 */
public class EmotionItem {
    private String name;
    private int resourceImg;

    public EmotionItem(String name, int resourceImg){
        setName(name);
        setResourceImg(resourceImg);
    }


    public String getName (){
        return name;
    };

    public void setName(String name){
        this.name = name;
    }

    public int getResourceImg (){
        return resourceImg;
    };

    public void setResourceImg(int resourceImg){
        this.resourceImg = resourceImg;
    }

}

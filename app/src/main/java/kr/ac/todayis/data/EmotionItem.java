package kr.ac.todayis.data;

/**
 * Created by Min on 2015-08-13.
 */
public class EmotionItem {
    private int idx;
    private String name;
    private int resourceImg;


    public int getIdx (){
      return idx;
    };

    public void setIdx(int idx){
        this.idx = idx;
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

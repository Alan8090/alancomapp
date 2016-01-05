package com.sanyjbz.alan8090.sanyjbz.Entity;

/**
 * Created by Alan8090 on 2016-01-05.
 */
public class Icon_entity {
    private int iId;
    private String iName;

    public Icon_entity(int id,String name)
    {
        this.iId=id;
        this.iName=name;
    }

    public int getID()
    {
        return iId;
    }
    public String getName()
    {
        return iName;
    }
    public void setId(int id)
    {
        this.iId=id;
    }
    public void setName(String name)
    {
        this.iName=name;
    }


}

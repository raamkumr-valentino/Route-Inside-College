package com.tcemap;

/**
 * Created by RaamKumr on 9/29/2016.
 */
public class mUtility extends Home
{
    boolean result=false;
    String[] IT ={"information technology", "it","it department","it block"};
    String[] CSE ={"cs","cse","cs department","computer science","computer science and engineering","computer science department"};
    String[] MECH ={"mech","mechanical","mechanical department"};
    String[] CIVIL ={"civil","civil department","civil block","civil engineering"};
    String[] ECE ={"ece","ece department","ece block","electronics"," electronics department","electronics and communication engineering"};
    String[] EEE ={"eee","eee block","eee department","electricals","electrical and electronical engineering"};
    String[] BARCH ={"arch","barch","architecture","architechtural department"};
    public boolean isIT(String search)
    {
        for(int i=0;i<IT.length;i++)
        {
            if(IT[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }
     public boolean isCSE(String search)
     {
         for(int i=0;i<CSE.length;i++)
         {
             if(CSE[i].equals(search))
             {
                 result=true;
                 break;
             }
         }
         return result;
     }
    public boolean isCIVIL(String search)
    {
        for(int i=0;i<CIVIL.length;i++)
        {
            if(CIVIL[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean isMECH(String search)
    {
        for(int i=0;i<MECH.length;i++)
        {
            if(MECH[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean isEEE(String search)
    {
        for(int i=0;i<EEE.length;i++)
        {
            if(EEE[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean isECE(String search)
    {
        for(int i=0;i<ECE.length;i++)
        {
            if(ECE[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean isBARCH(String search)
    {
        for(int i=0;i<BARCH.length;i++)
        {
            if(BARCH[i].equals(search))
            {
                result=true;
                break;
            }
        }
        return result;
    }

}

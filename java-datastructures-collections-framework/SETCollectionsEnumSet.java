package JavaDataStructuresAndCollections;

import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Set implementation for EnumSet, Java Collection FrameWork
 *
 * > NOTES : EnumSet:
 *              1) All of the members of an ENUM set must be of the same ENUM type.
 *              2) Ordering of the elements is in the order of enumeration element declaration. 
 *              3) Better performance and memory benefits than using a HashSet. 
 *              4) Support iteration over ranges of ENUM types.
 *
 */

public class SETCollectionsEnumSet
{
    public enum OOPLanguages { CPP , JAVA };
    public static void main(String[] args)
    {
        Set<OOPLanguages> eset = EnumSet.of(OOPLanguages.CPP, OOPLanguages.JAVA);
        
        System.out.println("Elements of the eset :");
        for(OOPLanguages es : eset)
        {
        	System.out.print("\t" + es);	
        }
    }
}

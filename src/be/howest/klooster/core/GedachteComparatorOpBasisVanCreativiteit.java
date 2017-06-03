/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.klooster.core;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Hayk
 */
public class GedachteComparatorOpBasisVanCreativiteit
        implements Comparator<Gedachte>, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Override
    public int compare(Gedachte gedachte1, Gedachte gedachte2) {
        return gedachte1.getCreativiteit() - gedachte2.getCreativiteit();
    }

}

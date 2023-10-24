package org.thom;

import org.thom.annotationprocessor.SuperBox;
import org.thom.annotationprocessor.GloryBox;

public class BoxApp {

    public static void main(String[] args) {


        SuperBox superBox = new GloryBox();
        System.out.println("gloryBox = " + superBox.pullOut());

    }
}

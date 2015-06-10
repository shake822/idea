package com.shake.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoqunqi on 15/5/10.
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] arg) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

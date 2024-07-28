package com.example;

/*
 * #%L
 * ImageJ interactive debugging tutorials.
 * %%
 * Copyright (C) 2009 - 2016 Board of Regents of the University of
 * Wisconsin-Madison.
 * %%
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 * http://creativecommons.org/publicdomain/zero/1.0/
 * #L%
 */
import com.example.utils.ObjectMaker;

import java.util.List;

/**
 * Exercise: Using the Expression Window in the Debug perspective.
 *
 * @author Mark Hiner
 */
public class Exercise4 {

    public static void main(final String... args) {
        // Let's make a list of 100000 objects
        final List<Object> myList = ObjectMaker.getList(100000);

        // Now let's process some objects from our list

        // Process first object
        processElementAtIndex(myList, 0);

        // Process middle object
        processElementAtIndex(myList, 100000 / 2);

        // Process last object
        processElementAtIndex(myList, 100000 - 1);
    }

    private static void processElementAtIndex(final List<Object> list,
                                              final int index)
    {
        if (index < 0 || index >= list.size()) {
            throw new IllegalArgumentException(
                    "If you don't mind, I would prefer not to process your object...");
        }

        list.set(index, null);
    }
}
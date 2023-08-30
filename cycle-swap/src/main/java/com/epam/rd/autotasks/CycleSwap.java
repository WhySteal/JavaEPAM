package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 0) {
            int last = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = last;
        }
    }
    // 13274 74132
    static void cycleSwap(int[] array, int shift) {
        if (array.length > 0) {
            int[] array2;
            array2 = new int[array.length];
            for (int i = 0; i < array.length - shift; i++) {
                array2[i + shift] = array[i];
            }
            for (int i = array.length - shift; i < array.length; i++) {
                array2[i - (array.length - shift)] = array[i];
            }
            for (int k = 0; k < array.length; k++) {
                array[k] = array2[k];
            }
        }
    }
}

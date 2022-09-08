package com.deliveryou.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

// singleton
public class ConditionalChain {
    private static ConditionalChain instance;
    private static List<BooleanSupplier> booleanSuppliers = new ArrayList<>();
    private static String chainName;

    private ConditionalChain() {
    }

    public static ConditionalChain begin() {
        return begin("(No-name)");
    }

    public static ConditionalChain begin(String chain_name) {
        clear();
        chainName = "(" + chain_name + ")";
        if (instance == null)
            instance = new ConditionalChain();
        return instance;
    }

    public ConditionalChain then(BooleanSupplier booleanSupplier) {
        booleanSuppliers.add(booleanSupplier);
        return this;
    }

    public void finish() {
        for (int i = 0; i < booleanSuppliers.size(); i++)
            if (!booleanSuppliers.get(i).getAsBoolean()) {
                System.err.println("[ERROR] Chain " + chainName + " stopped at step " + i);
                break;
            }
        clear();
    }

    public static void clear() {
        booleanSuppliers.clear();
        chainName = "(No-name)";
    }
}

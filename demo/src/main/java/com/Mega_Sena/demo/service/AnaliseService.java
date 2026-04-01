package com.Mega_Sena.demo.service;

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnaliseService {
    public AnaliseService() {
    }

    public Map<Integer, Integer> gerarRankingHistorico() {
        HashMap var1 = new HashMap();

        for(int var2 = 1; var2 <= 60; ++var2) {
            var1.put(var2, 0);
        }

        try {
            BufferedReader var3 = new BufferedReader(new FileReader("historico.csv"));

            String var4;
            while((var4 = var3.readLine()) != null) {
                String[] var5 = var4.split(",");
                if (var5.length >= 2) {
                    String[] var6 = var5[1].split("-");

                    for(int var7 = 0; var7 < var6.length; ++var7) {
                        int var8 = Integer.parseInt(var6[var7]);
                        var1.put(var8, (Integer)var1.get(var8) + 1);
                    }
                }
            }

            var3.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return var1;
    }
}


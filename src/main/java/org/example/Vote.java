package org.example;

public class Vote {


    public static String canVote(int age) {
        if (age < 16) return "Sem direito a votar";
        if (age < 18 || age > 70) return "Voto facultativo";
        return "Voto obrigatório";
    }
}
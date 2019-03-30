package com.dhimas.absenapp.home;

import java.util.ArrayList;
import java.util.List;

public class HomeActivityPresenterImpl implements HomeActivityPresenter {
    @Override
    public String getSum(String first, String second) {
        int result = Integer.parseInt(replaceDotComa(first)) + Integer.parseInt(replaceDotComa(second));
        return result + "";
    }

    @Override
    public String getMulti(String first, String second) {
        int result = Integer.parseInt(replaceDotComa(first)) * Integer.parseInt(replaceDotComa(second));
        return result + "";
    }

    @Override
    public String getPrime(String count) {
        int i;
        int num;
        int countPrime = 0;
        int countResult = Integer.parseInt(replaceDotComa(count));
        //Empty String
        StringBuilder primeNumbers = new StringBuilder();

        for (i = 1; i <= 100; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                //Appended the Prime number to the String
                primeNumbers.append(i).append(" ");
                countPrime++;
            }
            if (countPrime == countResult) {
                break;
            }
        }
        return primeNumbers.toString();
    }

    @Override
    public String getFibo(String count) {
        int countResult = Integer.parseInt(replaceDotComa(count));
        int pass = 0;
        int current = 1;
        int fibonacci;
        StringBuilder fiboNumbers = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        if (countResult > 2) {
            for (int i = 0; i < countResult - 2; i++) {
                fibonacci = current + pass;
                pass = current;
                current = fibonacci;

                list.add(fibonacci);
            }
        }

        for (Integer i : list) {
            fiboNumbers.append(i).append(" ");
        }
        return fiboNumbers.toString();
    }

    private String replaceDotComa(String data) {
        return data.replace(",", "").replace(".", "");
    }
}

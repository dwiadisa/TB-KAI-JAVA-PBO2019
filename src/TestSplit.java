/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adisa
 */
public class TestSplit {
    public static void main(String[] args) {
        String coba = "BG | Bangil";
        String split[]= coba.split(" | ");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}

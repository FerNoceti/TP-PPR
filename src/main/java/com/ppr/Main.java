package com.ppr;

import com.ppr.implementations.AlumnoDaoImp;

public class Main {
    public static void main(String[] args) {
        AlumnoDaoImp alumnoDaoImp = new AlumnoDaoImp();
        System.out.println(alumnoDaoImp.getAllAlumnos().get(0));

    }
}
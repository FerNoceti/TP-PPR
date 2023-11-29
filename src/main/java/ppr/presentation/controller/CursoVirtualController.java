package ppr.presentation.controller;

import ppr.presentation.view.CursoVirtualView;
import ppr.service.implementations.CursoVirtualServiceImp;

public class CursoVirtualController {

    private final CursoVirtualView view;
    CursoVirtualServiceImp cursoVirtualServiceImp = CursoVirtualServiceImp.getInstance();

    public CursoVirtualController(CursoVirtualView view) {
        this.view = view;
    }
}

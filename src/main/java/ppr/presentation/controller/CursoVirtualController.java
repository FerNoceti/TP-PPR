package ppr.presentation.controller;

import ppr.logic.service.implementations.CursoPresencialServiceImplementation;
import ppr.logic.service.implementations.CursoVirtualServiceImp;
import ppr.presentation.view.CursoVirtualView;

public class CursoVirtualController {

    CursoVirtualServiceImp cursoVirtualServiceImp = CursoVirtualServiceImp.getInstance();

    private final CursoVirtualView view;

    public CursoVirtualController(CursoVirtualView view){
        this.view = view;
    }
}

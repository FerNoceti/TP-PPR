package ppr.presentation.controller;

import ppr.model.Persona;
import ppr.presentation.view.ProximosCumpleaniosView;
import ppr.service.implementations.ConsultasSerivceImp;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProximosCumpleaniosController {

    ConsultasSerivceImp consultasSerivceImp = ConsultasSerivceImp.getInstance();

    private final ProximosCumpleaniosView view;

    public ProximosCumpleaniosController(ProximosCumpleaniosView view) {
        this.view = view;
        cargarTablaProximosCumpleanios();
    }

    private DefaultTableModel convertirTabla(List<Persona> personas) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "ID", "Fecha de nacimiento", "Dias restantes"
                }
        );

        model.addRow(new Object[]{"ID", "Fecha de nacimiento", "Dias restantes"});

        for (Persona persona : personas) {
            Object[] fila = new Object[6];
            fila[0] = persona.getIdPersona();
            fila[1] = persona.getFechaNacimiento();
            fila[2] = persona.calcularDiasRestantes();
            model.addRow(fila);
        }

        return model;
    }

    private void cargarTablaProximosCumpleanios() {
        List<Persona> personas = consultasSerivceImp.getCumpleaniosProximos();
        DefaultTableModel model = convertirTabla(personas);
        view.getTablePersonas().setModel(model);
    }
}

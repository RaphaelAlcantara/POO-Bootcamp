package br.ifpe.project.padroes.Repository;

import java.util.ArrayList;
import java.util.List;
import br.ifpe.project.model.negocios.Dev;

public class DevRepository {
    List<Dev> devList = new ArrayList<>();

    public void create(Dev dev) {
        if (dev != null) {
            devList.add(dev);
        }
    }

}
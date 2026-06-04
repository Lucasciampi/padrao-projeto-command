package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorTarefas {

    private List<Command> historicoComandos = new ArrayList<>();

    public void executarComando(Command comando) {
        this.historicoComandos.add(comando);
        comando.executar();
    }

    public void desfazerUltimoComando() {
        if (!historicoComandos.isEmpty()) {
            Command comando = this.historicoComandos.get(this.historicoComandos.size() - 1);
            comando.desfazer();
            this.historicoComandos.remove(this.historicoComandos.size() - 1);
        }
    }

}

package org.example;

public class CancelarTarefaCommand implements Command{

    private Tarefa tarefa;
    private String statusAnterior;

    public CancelarTarefaCommand(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void executar() {
        this.statusAnterior = this.tarefa.getStatus();
        this.tarefa.cancelar();
    }

    @Override
    public void desfazer() {
        this.tarefa.setStatus(this.statusAnterior);
    }

}

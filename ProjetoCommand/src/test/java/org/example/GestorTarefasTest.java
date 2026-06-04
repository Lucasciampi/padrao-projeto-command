package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorTarefasTest {

    private GestorTarefas gestor;
    private Tarefa tarefa;

    @BeforeEach
    void setUp() {
        gestor = new GestorTarefas();
        tarefa = new Tarefa("Desenvolver Relatório de Desempenho");
    }

    @Test
    void deveConcluirTarefa() {
        Command concluir = new ConcluirTarefaCommand(tarefa);
        gestor.executarComando(concluir);

        assertEquals("Concluída", tarefa.getStatus());
    }

    @Test
    void deveCancelarTarefa() {
        Command cancelar = new CancelarTarefaCommand(tarefa);
        gestor.executarComando(cancelar);

        assertEquals("Cancelada", tarefa.getStatus());
    }

    @Test
    void deveDesfazerConclusaoDaTarefa() {
        Command concluir = new ConcluirTarefaCommand(tarefa);
        gestor.executarComando(concluir);
        gestor.desfazerUltimoComando();

        assertEquals("Aberta", tarefa.getStatus());
    }

    @Test
    void deveDesfazerSequenciaDeComandos() {
        Command concluir = new ConcluirTarefaCommand(tarefa);
        Command cancelar = new CancelarTarefaCommand(tarefa);

        gestor.executarComando(concluir);
        gestor.executarComando(cancelar);

        gestor.desfazerUltimoComando();
        assertEquals("Concluída", tarefa.getStatus());

        gestor.desfazerUltimoComando();
        assertEquals("Aberta", tarefa.getStatus());
    }

}
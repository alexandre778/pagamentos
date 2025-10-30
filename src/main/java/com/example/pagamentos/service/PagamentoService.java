package com.example.pagamentos.service;

import com.example.pagamentos.model.Pagamento;
import com.example.pagamentos.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    public void salvar(Pagamento pagamento) {
        repository.save(pagamento);
    }

    // ✅ Adicione estes dois métodos abaixo:
    public Pagamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado: " + id));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

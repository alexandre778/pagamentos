package com.example.pagamentos.controller;

import com.example.pagamentos.model.Pagamento;
import com.example.pagamentos.model.TipoImposto;
import com.example.pagamentos.service.PagamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoViewController {

    private final PagamentoService service;

    public PagamentoViewController(PagamentoService service) {
        this.service = service;
    }

    // Exibir lista de pagamentos
    @GetMapping
    public String listarPagamentos(Model model) {
        List<Pagamento> pagamentos = service.listarTodos();
        model.addAttribute("pagamentos", pagamentos);
        return "lista-pagamentos";
    }

    // Exibir formulário para novo pagamento
    @GetMapping("/novo")
    public String novoPagamento(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        model.addAttribute("tiposImposto", TipoImposto.values());
        return "form-pagamento";
    }

    // Salvar pagamento
    @PostMapping("/salvar")
    public String salvarPagamento(@ModelAttribute Pagamento pagamento) {
        service.salvar(pagamento);
        return "redirect:/pagamentos";
    }

    // Editar pagamento existente
    @GetMapping("/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        Pagamento pagamento = service.buscarPorId(id);
        model.addAttribute("pagamento", pagamento);
        model.addAttribute("tiposImposto", TipoImposto.values());
        return "form-pagamento";
    }

    // Excluir pagamento
    @GetMapping("/excluir/{id}")
    public String excluirPagamento(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/pagamentos";
    }

    // Voltar para o início
    @GetMapping("/inicio")
    public String voltarInicio() {
        return "index";
    }
}

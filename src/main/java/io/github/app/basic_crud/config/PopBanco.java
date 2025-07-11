/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.app.basic_crud.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.app.basic_crud.model.produto.Produto;
import io.github.app.basic_crud.model.produto.ProdutoDTOCreate;
import io.github.app.basic_crud.model.usuario.Usuario;
import io.github.app.basic_crud.model.usuario.UsuarioAuthority;
import io.github.app.basic_crud.repository.ProdutoRepository;
import io.github.app.basic_crud.repository.UsuarioRepository;

/**
 *
 * @author Administrator
 */
@Configuration
public class PopBanco implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        var y = lista().parallelStream().map(Produto::new).toList();
        produtoRepository.saveAll(y);
        Usuario u = new Usuario("adm", passwordEncoder.encode("123"), "fulano", "https://cdn.displate.com/artwork/270x380/2023-03-15/16b10ce0992b84677607920363f87e36_7c53af9d4cda734e553aec7e576732da.jpg");
        UsuarioAuthority ua = new UsuarioAuthority("ADM", u);
        u.getAuthorities().add(ua);
        usuarioRepository.save(u);
    }

    private List<ProdutoDTOCreate> lista() {
        var x = Arrays.asList(
                new ProdutoDTOCreate(
                        "Echo Dot 5ª Geração",
                        349.90,
                        "Smart speaker com Alexa, som potente e design compacto. Controle sua casa com comandos de voz.",
                        "https://m.media-amazon.com/images/I/61M+bgGo7VL._AC_SL1000_.jpg"
                ),
                new ProdutoDTOCreate(
                        "Air Fryer Mondial Family IV",
                        499.00,
                        "Fritadeira elétrica sem óleo com capacidade de 4 litros. Prepare alimentos crocantes e saudáveis.",
                        "https://m.media-amazon.com/images/I/71zeBuMlz2L._AC_SL1500_.jpg"
                ),
                new ProdutoDTOCreate(
                        "Kindle Paperwhite 11ª Geração",
                        699.00,
                        "Leitor digital com tela antirreflexo de 6.8'', iluminação ajustável e bateria de longa duração.",
                        "https://m.media-amazon.com/images/I/81-vCHKJb1L._AC_SL1500_.jpg"
                ),
                new ProdutoDTOCreate(
                        "Cadeira Gamer ThunderX3 EC3",
                        1_199.00,
                        "Cadeira ergonômica com design gamer, apoio lombar e ajuste de altura. Ideal para longas sessões.",
                        "https://m.media-amazon.com/images/I/51zCUhjKG2L._AC_SL1000_.jpg"
                ),
                new ProdutoDTOCreate(
                        "Smartwatch Amazfit Bip U Pro",
                        379.90,
                        "Relógio inteligente com GPS, monitoramento de saúde e notificações. Compatível com Android e iOS.",
                        "https://m.media-amazon.com/images/I/51-57Lg4L5L._AC_SL1044_.jpg"
                )
        );
        return x;
    }

}

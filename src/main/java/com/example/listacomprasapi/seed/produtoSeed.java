package com.example.listacomprasapi.seed;

import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class produtoSeed implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;


    @Override
    public void run(String... args) throws Exception {
        produtoSeed();
    }

    private void produtoSeed() {
        var produtosAtDatabase = produtoRepository.findAll();

        if (produtosAtDatabase.isEmpty()) {
            List<List<String>> records = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader("src//initDB/itens.csv"));
                String line;
                while ((line = br.readLine()) != null) {

                    String[] values = line.split(",");

                    addProduct(values);

                }
                System.out.println("Products Seeded");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void addProduct(String[] values) {


        ProdutoModel product = new ProdutoModel();
        System.out.println(Arrays.toString(values));
        product.setNome(values[1]);

        product.setDescricao(values[2]);


        produtoRepository.save(new ProdutoEntity(product));

    }
}
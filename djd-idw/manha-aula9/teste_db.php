<?php 

    $db = new PDO('mysql:host=localhost;dbname=pet_manha;charset=utf8', 
                'root', '');
    echo "<h2>Conectado ao banco de dados</h2>";

    // $db->exec("INSERT INTO pets (nome, raca, peso, nascimento)".
    //      "VALUES ('Princesa', 'poodle', 4.6, '2019-04-14')");

    $res = $db->query("SELECT * FROM pets");

    forEach($res as $registro) { 
        echo "<p>Nome: " . $registro['nome'] . '</p>';
        echo "<p>Raca: " . $registro['raca'] . '</p>';
        echo "<p>Peso: " . $registro['peso'] . '</p>';
        echo "<p>Nascimneto: " . $registro['nascimento'] . '</p>';
    }

?>
<?php 

    $con = new PDO("mysql:host=localhost;dbname=pets;charset=utf8",
                     "root", "");
    echo "<h2>Conexão no banco de dados pets criada com sucesso</h2>";
    $sql = "INSERT INTO pet (nome, raca, peso) VALUES ('Totó', 'Bulldog', 16.7)";
    $con->exec($sql);
    echo "<h2>Registro inserido com sucesso</h2>";

?>
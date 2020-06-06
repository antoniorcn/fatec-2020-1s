<?php
    echo "Você chegou no petController <br/>";

    $nome = $_REQUEST['NOME'];
    $raca = $_REQUEST['RACA'];
    $peso = $_REQUEST['PESO'];
    $nascimento = $_REQUEST['NASC'];

    // include "./sucesso.html";

    header('location: ./sucesso.html');
?>
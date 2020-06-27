<?php
    $nome = $_REQUEST['NOME'];
    $raca = $_REQUEST['RACA'];
    $peso = $_REQUEST['PESO'];
    $nascimento = $_REQUEST['NASC'];
    $cmd = $_REQUEST['CMD'];

    session_start();

    $con = new PDO('mysql:host=localhost;dbname=pets;charset=utf8', 'root', '');
    $resultado = array();
    if ($cmd == 'adicionar') {
        $sql = "INSERT INTO pet (nome, raca, peso) VALUES ('$nome', '$raca', $peso)";
        $result = $con->exec($sql);
        $msg = "O pet $nome foi adicionado com sucesso";

        $sql = "SELECT * FROM pet";
        $resultado = $con->query($sql);
    } else if ('pesquisar') { 
        $sql = "SELECT * FROM pet WHERE nome LIKE '%$nome%'";
        $resultado = $con->query($sql);
    }
    
    $pets = array();
    foreach($resultado as $res) { 
        array_push($pets, $res);
    }
    
    $_SESSION['MENSAGEM'] = $msg;
    $_SESSION['LISTA'] = $pets;
    header('location: ./pet.php');
?>
<?php
    $nome = $_REQUEST['NOME'];
    $raca = $_REQUEST['RACA'];
    $peso = $_REQUEST['PESO'];
    $nasc = $_REQUEST['NASC'];
    $cmd = $_REQUEST['CMD'];


    // $pet = new StdClass;
    // $pet->NOME = $nome;
    // $pet->RACA = $raca;
    // $pet->PESO = $peso;
    // $pet->NASC = $nasc;

    session_start();
    
    $con = new PDO('mysql:host=localhost;dbname=pet_shop;charset=utf8', 'root', '');

    $mensagem = NULL;
    unset($_SESSION['LISTA']);
    if ($cmd == 'adicionar') {
        // array_push($_SESSION['LISTA'], $pet);
        $sql = "INSERT INTO pets (nome, raca, peso, nascimento) ";
        $sql .= "VALUES ('$nome', '$raca', $peso, '$nasc')";
        $con->exec($sql);
        $mensagem = "Pet $nome inserido com sucesso no banco";
    } else if ($cmd == 'pesquisar') { 
        $lista = array();
        $sql = "SELECT * FROM pets WHERE nome LIKE '%$nome%'";
        $resultado = $con->query($sql);
        foreach($resultado as $pet) { 
            $nome = $pet['nome'];
            array_push($lista, $pet);
        }
        $_SESSION['LISTA'] = $lista;
    }
    $_SESSION['MENSAGEM'] = $mensagem;
    header('Location: ./pet.php');

?>


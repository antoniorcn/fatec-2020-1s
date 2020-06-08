<html>
    <head>
        <title>Gestão de Pets</title>
        <meta charset="utf-8"/>
        <link href="./css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">

            <?php
                $nome = $_REQUEST['NOME'];
                $raca = $_REQUEST['RACA'];
                $peso = $_REQUEST['PESO'];
                $nasc = $_REQUEST['NASC'];
                $cmd = $_REQUEST['CMD'];


                $pet = new StdClass;
                $pet->NOME = $nome;
                $pet->RACA = $raca;
                $pet->PESO = $peso;
                $pet->NASC = $nasc;

                session_start();
                if (isset($_SESSION['LISTA'])) { 
                } else { 
                    $_SESSION['LISTA'] = array();
                }
            
                if ($cmd == 'adicionar') {
                    array_push($_SESSION['LISTA'], $pet);
            ?>
                <h1>Pet cadastrado com sucesso</h1>
                <h3>A lista de PETs possui <?=count($_SESSION['LISTA'])?> pets cadastrados</h3>
            <?php
                } else if ($cmd == 'pesquisar') { 
            ?>
                <h1>Pets econtrados</h1>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>Nome</td>
                            <td>Raça</td>
                            <td>Peso</td>
                            <td>Nascimento</td>
                        </tr>
                    </thead>
                    <tbody>
            <?php
                    foreach($_SESSION['LISTA'] as $p) { 
                        if (strpos($p->NOME, $nome)!== false) {
                            ?>
                            <tr>
                                <td><?=$p->NOME?></td>
                                <td><?=$p->RACA?></td>
                                <td><?=$p->PESO?></td>
                                <td><?=$p->NASC?></td>
                            </tr>
                            <?php
                        }
                    }
                    ?>
                    </tbody>
                </table>
                <?php
                }

            ?>
        </div>
    </body>
</html>

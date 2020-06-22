<html>
    <head>
        <title>Gestão de Pets</title>
        <meta charset="utf-8"/>
        <link href="./css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="./js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Gestão de Pets</h1>

            <?php 
                session_start();
                if (isset($_SESSION['MENSAGEM'])) { 
            ?>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <?=$_SESSION['MENSAGEM']?>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <?php
                    unset($_SESSION['MENSAGEM']);
                }
            ?>

            <form action="./petController.php" method="post">
                <div class="form-group">
                    <label>Nome</label>
                    <input type="text" class="form-control" name="NOME"/>
                </div>
                <div class="form-group">
                    <label>Raça</label>
                    <select class="form-control" name="RACA">
                        <option>Bull Dog</option>    
                        <option>Vira Lata</option>
                        <option>Poodle</option>
                        <option>Cocker</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Peso</label>
                    <input type="number" step="0.1" name="PESO" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Nascimento</label>
                    <input type="date" class="form-control" name="NASC"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" name="CMD" value="adicionar">Adicionar</button>
                    <button type="submit" class="btn btn-primary" name="CMD" value="pesquisar">Pesquisar</button>
                </div>
            </form>

            <?php
                if (isset($_SESSION['LISTA'])) { 
            ?>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Raça</th>
                            <th>Peso</th>
                            <th>Nascimento</th>
                        </tr>
                    </thead>
                    <tbody>
            <?php
                    foreach($_SESSION['LISTA'] as $pet) {
            ?>
                        <tr>
                            <td><?=$pet['nome']?></td>
                            <td><?=$pet['raca']?></td>
                            <td><?=$pet['peso']?></td>
                            <td><?=$pet['nascimento']?></td>
                        </tr>
            <?php
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